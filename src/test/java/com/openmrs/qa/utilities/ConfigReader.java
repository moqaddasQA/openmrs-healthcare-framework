package com.openmrs.qa.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties properties;

    static {
        logger.info("Loading configuration properties...");
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                logger.error("CRITICAL ERROR: config.properties not found in resources folder");
                throw new RuntimeException("CRITICAL ERROR: config.properties not found in resources folder");
            }

            properties.load(input);
            logger.info("Successfully loaded {} properties from config.properties", properties.size());

        } catch (IOException e) {
            logger.error("CRITICAL ERROR: Failed to load config.properties", e);
            throw new RuntimeException("CRITICAL ERROR: Failed to load config.properties", e);
        }
    }

    /**
     * Get property value by key
     * @param key The property key
     * @return The property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.error("Property '{}' not found in config.properties", key);
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        logger.debug("Retrieved property: {} = {}", key, maskSensitiveValue(key, value));
        return value.trim();
    }

    /**
     * Get property value with a default fallback
     * @param key The property key
     * @param defaultValue The default value if key is not found
     * @return The property value or default value
     */
    public static String getProperty(String key, String defaultValue) {
        String value = properties.getProperty(key, defaultValue);
        if (value != null) {
            value = value.trim();
        }
        logger.debug("Retrieved property: {} = {} (default: {})", key, maskSensitiveValue(key, value), defaultValue);
        return value;
    }

    /**
     * Get property from environment variable first, then from config file
     * @param key The property key
     * @return The property value from environment or config file
     */
    public static String getPropertyWithEnvFallback(String key) {
        // Try environment variable first (convert to uppercase and replace dots with underscores)
        String envKey = key.toUpperCase().replace('.', '_');
        String envValue = System.getenv(envKey);

        if (envValue != null) {
            logger.debug("Using environment variable for {}: {}", key, maskSensitiveValue(key, envValue));
            return envValue;
        }

        // Fallback to config file
        return getProperty(key);
    }

    /**
     * Check if a property exists
     * @param key The property key
     * @return true if the property exists, false otherwise
     */
    public static boolean hasProperty(String key) {
        return properties.containsKey(key);
    }

    /**
     * Get property as integer
     * @param key The property key
     * @return The property value as integer
     */
    public static int getPropertyAsInt(String key) {
        return getPropertyAsInt(key, 0);
    }

    /**
     * Get property as integer with default value
     * @param key The property key
     * @param defaultValue The default value if key is not found
     * @return The property value as integer
     */
    public static int getPropertyAsInt(String key, int defaultValue) {
        try {
            String value = getProperty(key, String.valueOf(defaultValue));
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error("Property '{}' is not a valid integer, using default: {}", key, defaultValue);
            return defaultValue;
        }
    }

    /**
     * Get property as boolean
     * @param key The property key
     * @return The property value as boolean
     */
    public static boolean getPropertyAsBoolean(String key) {
        return getPropertyAsBoolean(key, false);
    }

    /**
     * Get property as boolean with default value
     * @param key The property key
     * @param defaultValue The default value if key is not found
     * @return The property value as boolean
     */
    public static boolean getPropertyAsBoolean(String key, boolean defaultValue) {
        String value = getProperty(key, String.valueOf(defaultValue));
        return Boolean.parseBoolean(value);
    }

    /**
     * Mask sensitive values in logs
     * @param key The property key
     * @param value The property value
     * @return Masked value if sensitive, original value otherwise
     */
    private static String maskSensitiveValue(String key, String value) {
        if (key.toLowerCase().contains("password") ||
            key.toLowerCase().contains("secret") ||
            key.toLowerCase().contains("token")) {
            return "*****";
        }
        return value;
    }
}