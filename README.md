
# 🚀 OpenMRS Healthcare Testing Framework

![OpenMRS Banner](https://raw.githubusercontent.com/moqaddasQA/openmrs-healthcare-framework/main/.github/assets/banner.png)

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-blue?logo=java" alt="Java Version"/>
  <img src="https://img.shields.io/github/license/moqaddasQA/openmrs-healthcare-framework?color=brightgreen" alt="License"/>
  <img src="https://img.shields.io/github/actions/workflow/status/moqaddasQA/openmrs-healthcare-framework/ci.yml?label=Build&logo=github" alt="Build Status"/>
  <img src="https://img.shields.io/codecov/c/github/moqaddasQA/openmrs-healthcare-framework?logo=codecov" alt="Coverage"/>
  <img src="https://img.shields.io/github/last-commit/moqaddasQA/openmrs-healthcare-framework?logo=github" alt="Last Commit"/>
  <img src="https://img.shields.io/github/issues/moqaddasQA/openmrs-healthcare-framework?logo=github" alt="Issues"/>
  <img src="https://img.shields.io/github/stars/moqaddasQA/openmrs-healthcare-framework?style=social" alt="Stars"/>
  <img src="https://img.shields.io/github/forks/moqaddasQA/openmrs-healthcare-framework?style=social" alt="Forks"/>
  <img src="https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square" alt="PRs Welcome"/>
  <img src="https://img.shields.io/maintenance/active/2025" alt="Maintenance"/>
</p>

> **Enterprise Hybrid Framework for OpenMRS using Selenium, Docker, and MySQL**

---

## 📑 Table of Contents
- [🎯 Features](#-features)
- [🏗️ Architecture Overview](#️-architecture-overview)
- [⚡ Quick Start](#-quick-start)
- [📦 Prerequisites](#-prerequisites)
- [🚀 Installation & Setup](#-installation--setup)
- [🧪 Running Tests](#-running-tests)
- [📊 Reports & Coverage](#-reports--coverage)
- [🔧 Configuration](#-configuration)
- [📁 Project Structure](#-project-structure)
- [🎨 Code Examples](#-code-examples)
- [🤝 Contributing](#-contributing)
- [📝 Changelog/Roadmap](#-changelogroadmap)
- [👥 Authors & Acknowledgments](#-authors--acknowledgments)
- [📄 License](#-license)
- [🔗 Useful Links](#-useful-links)

<p align="right">[⬆️ Back to Top](#readme)</p>

---

## 🎯 Features

| Feature | Description |
|---------|-------------|
| ✅ Selenium WebDriver | Modern browser automation |
| ✅ TestNG & Cucumber | Hybrid BDD & data-driven testing |
| ✅ REST Assured | API testing integration |
| ✅ Allure Reports | Rich, interactive test reports |
| ✅ Docker Support | Containerized test execution |
| ✅ MySQL Integration | Realistic data scenarios |
| ✅ Parallel Execution | Fast, scalable test runs |
| ✅ CI/CD Ready | GitHub Actions & Maven support |

> **Note:**
> This framework is designed for extensibility and enterprise-grade healthcare automation.

---

## 🏗️ Architecture Overview

```
+-------------------+
|   Test Runner     |
| (TestNG/Cucumber) |
+--------+----------+
         |
         v
+--------+----------+
|   Test Scripts    |
+--------+----------+
         |
         v
+--------+----------+
|  Framework Core   |
| (Selenium, Utils) |
+--------+----------+
         |
         v
+--------+----------+
|   Docker/MySQL    |
+-------------------+
```

> **Info:**
> Modular, layered design for maintainability and scalability.


## ⚡ Quick Start

```bash
# 1. Clone the repository
$ git clone https://github.com/moqaddasQA/openmrs-healthcare-framework.git

# 2. Navigate to the project directory
$ cd openmrs-healthcare-framework

# 3. Build the project
$ mvn clean install

# 4. Run tests
$ mvn test
```

> **Tip:**
> Use Docker for isolated, reproducible test environments.

---

## 📦 Prerequisites

| Tool         | Version |
|--------------|---------|
| Java         | ![Java](https://img.shields.io/badge/21-blue?logo=java) |
| Maven        | ![Maven](https://img.shields.io/badge/3.8%2B-blue?logo=apache-maven) |
| Docker       | ![Docker](https://img.shields.io/badge/20%2B-blue?logo=docker) |
| ChromeDriver | ![Chrome](https://img.shields.io/badge/Latest-blue?logo=google-chrome) |

> **Warning:**
> Ensure all prerequisites are installed and available in your PATH.

---

## 🚀 Installation & Setup

<details>
<summary>Expand for detailed setup instructions</summary>

```bash
# Install dependencies
$ mvn clean install

# (Optional) Start Docker containers
$ docker-compose up -d

# Configure environment variables in `src/test/resources/framework.properties`
```

</details>


## 🧪 Running Tests

| Option | Command |
|--------|---------|
| All Tests | `mvn test` |
| Regression | `mvn test -Dsuite=regression` |
| Smoke | `mvn test -Dsuite=smoke` |
| Cucumber | `mvn verify -Dcucumber.options="--tags @smoke"` |
| Docker | `docker-compose run test` |

> **Note:**
> Test results are output to `target/allure-results` and `target/surefire-reports`.


## 📁 Project Structure

```

├── src/
│   └── test/
│       ├── java/
│       └── resources/
├── target/
│   ├── allure-results/
│   └── surefire-reports/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🎨 Code Examples

<details>
<summary>Expand for Java & Gherkin examples</summary>

```java
// Sample TestNG Test
@Test
public void loginTest() {
      LoginPage login = new LoginPage(driver);
      login.login("admin", "password");
      Assert.assertTrue(login.isLoggedIn());
}
```

```gherkin
# Sample Cucumber Scenario
Feature: Login
   Scenario: Valid login
      Given I am on the login page
      When I enter valid credentials
      Then I should see the dashboard
```

</details>

---
## 📊 Reports & Coverage

- Allure Reports: `target/allure-results` ([Allure Docs](https://docs.qameta.io/allure/))
- JaCoCo Coverage: `target/site/jacoco/index.html`

![Allure Report Screenshot](https://raw.githubusercontent.com/moqaddasQA/openmrs-healthcare-framework/main/.github/assets/allure-report.png)

> **Note:**
> Open reports in your browser for interactive dashboards.

---

## 🔧 Configuration

<details>
<summary>Click to expand configuration details</summary>

- `framework.properties`: Main config for environment, browser, DB, etc.
- `testng-regression.xml` / `testng-smoke.xml`: Test suite definitions
- Environment variables for Dockerized runs

</details>

---

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

## 🤝 Contributing

> **PRs welcome!** Please read [CONTRIBUTING.md](CONTRIBUTING.md).

<p align="center">
   <img src="https://contrib.rocks/image?repo=moqaddasQA/openmrs-healthcare-framework" alt="Contributors"/>
</p>

---

## 📝 Changelog/Roadmap

See [CHANGELOG.md](CHANGELOG.md) for release history.

<details>
<summary>Planned Features</summary>

- [ ] GitHub Actions CI/CD
- [ ] Enhanced Docker support
- [ ] More sample test cases
- [ ] Advanced reporting

</details>

---

## 👥 Authors & Acknowledgments

| Name | GitHub |
|------|--------|
| Moqaddas | [@moqaddasQA](https://github.com/moqaddasQA) |

> **Acknowledgments:**
> Thanks to the OpenMRS community and all contributors!

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🔗 Useful Links

- [OpenMRS](https://openmrs.org/)
- [Selenium WebDriver](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [Cucumber](https://cucumber.io/)
- [REST Assured](https://rest-assured.io/)
- [Allure Reports](https://docs.qameta.io/allure/)
- [JaCoCo](https://www.jacoco.org/jacoco/)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)

<p align="right">[⬆️ Back to Top](#readme)</p>
