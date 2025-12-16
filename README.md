# OpenMRS Healthcare Testing Framework

## 📋 Overview

This is a comprehensive test automation framework for the OpenMRS healthcare system, built with modern Java testing technologies and best practices.

## 🛠️ Tech Stack

- **Java 21** - Programming Language
- **Selenium WebDriver 4.31.0** - UI Automation
- **TestNG 7.11.0** - Test Runner & Assertions
- **Cucumber 7.18.1** - BDD Framework
- **REST Assured 6.0.0** - API Testing
- **Allure Reports** - Test Reporting
- **SLF4J + Logback** - Logging Framework
- **WebDriverManager** - Automatic Driver Management
- **AssertJ** - Fluent Assertions
- **Maven** - Build Tool

## 🚀 Quick Start

### Prerequisites
- Java 21 or higher
- Maven 3.8.0 or higher
- Chrome/Firefox/Edge browser

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd openmrs-healthcare-framework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **View Allure Reports**
   ```bash
   mvn allure:serve
   ```

## 📁 Project Structure

```
src/
└── test/
    ├── java/
    │   └── com/
    │       └── openmrs/
    │           └── qa/
    │               ├── base/           # Base test class
    │               ├── utilities/       # Utility classes
    │               │   ├── ConfigReader.java
    │               │   └── DriverFactory.java
    │               ├── pages/          # Page Object Models
    │               ├── steps/          # Cucumber Step Definitions
    │               ├── runners/        # Test Runners
    │               └── api/            # API Test Classes
    └── resources/
        ├── config.properties  # Test configuration
        ├── logback.xml       # Logging configuration
        └── testng.xml        # TestNG suite configuration
```

## ⚙️ Configuration

### Test Configuration (`config.properties`)

```properties
# Application Settings
url=https://demo.openmrs.org/openmrs/login.htm
browser=chrome
headless=false

# Timeouts (in seconds)
implicit.wait=10
explicit.wait=15
page.load.timeout=30
script.timeout=20

# Test Settings
test.environment=dev
test.parallel=true
test.thread.count=3

# Reporting
allure.report.directory=target/allure-results
take.screenshot.on.failure=true
```

### Environment Variables

For sensitive data, use environment variables:

```bash
# Database credentials
export DB_PASSWORD=your_secure_password

# Browser selection
export BROWSER=firefox

# Headless mode
export HEADLESS=true
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

### Run with Specific Browser
```bash
mvn test -Dbrowser=firefox
```

### Run in Headless Mode
```bash
mvn test -Dheadless=true
```

### Run Tests in Parallel
```bash
mvn test -Dparallel=methods -DthreadCount=4
```

## 📊 Reports

### Allure Reports
1. Run tests: `mvn test`
2. Generate report: `mvn allure:report`
3. View report: `mvn allure:serve`

### JaCoCo Code Coverage
1. Run tests with coverage: `mvn clean test jacoco:report`
2. View coverage report: `target/site/jacoco/index.html`

## 🔧 Development Guidelines

### Creating New Tests

1. **Extend BaseTest**
   ```java
   public class LoginTest extends BaseTest {
       @Test
       public void testLogin() {
           navigateToApplication();
           // Your test code here
       }
   }
   ```

2. **Use Page Object Model**
   ```java
   LoginPage loginPage = new LoginPage();
   loginPage.login("username", "password");
   ```

3. **Add Logging**
   ```java
   logger.info("Performing login with username: {}", username);
   ```

4. **Use Allure Annotations**
   ```java
   @Step("Login with username: {0}")
   public void login(String username) {
       // Implementation
   }
   ```

### Best Practices

- ✅ Use descriptive test method names
- ✅ Add proper logging and assertions
- ✅ Use Page Object Model pattern
- ✅ Handle waits properly
- ✅ Clean up test data
- ✅ Use environment variables for sensitive data
- ✅ Write maintainable and readable code

## 🐛 Troubleshooting

### Common Issues

1. **Driver not found**
   - WebDriverManager automatically handles driver downloads
   - Check internet connection

2. **Tests fail in CI/CD**
   - Use headless mode: `-Dheadless=true`
   - Set proper environment variables

3. **Browser not launching**
   - Check browser version compatibility
   - Verify browser installation

4. **Tests timing out**
   - Increase timeout values in config.properties
   - Check network connectivity

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Run all tests: `mvn clean test`
6. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

For questions or support:
- Create an issue in the repository
- Contact the development team

## 🔄 Version History

- **v1.0-SNAPSHOT** - Initial framework setup with basic utilities