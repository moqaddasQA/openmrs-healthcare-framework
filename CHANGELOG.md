# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Initial framework setup with modern Java testing stack
- SLF4J + Logback logging framework
- WebDriverManager for automatic driver management
- Allure Reports integration for better test reporting
- JaCoCo code coverage reporting
- BaseTest class with common setup/teardown
- Environment variable support for sensitive configuration
- Docker support for containerized testing
- GitHub Actions CI/CD pipeline
- Comprehensive documentation (README, CONTRIBUTING, etc.)

### Changed
- Updated ConfigReader with environment variable fallback
- Enhanced DriverFactory with better browser options
- Improved error handling and logging throughout

### Fixed
- Resource leak in ConfigReader (fixed with try-with-resources)
- Hardcoded file paths (now uses classpath loading)
- Missing dependency management in pom.xml

### Security
- Added password masking in logs
- Environment variable support for sensitive data
- No more hardcoded credentials in source code

## [1.0.0] - 2024-12-13

### Added
- Project initialization
- Basic Selenium WebDriver support
- TestNG integration
- Configuration management
- Page Object Model structure
- Cucumber BDD support
- REST Assured for API testing
- Apache POI for Excel data handling
- MySQL database connectivity

---

## Version Format

This project follows [Semantic Versioning](https://semver.org/):
- **MAJOR**: Breaking changes
- **MINOR**: New features (backward compatible)
- **PATCH**: Bug fixes (backward compatible)

---

## Release Process

1. Update version in `pom.xml`
2. Update `CHANGELOG.md`
3. Create release tag
4. Generate release notes