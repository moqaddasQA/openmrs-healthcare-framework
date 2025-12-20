

<div align="center">

# 🏥 OpenMRS Healthcare Testing Framework

### *Enterprise-Grade Hybrid Test Automation for OpenMRS*

<img src="https://raw.githubusercontent.com/moqaddasQA/openmrs-healthcare-framework/main/.github/assets/banner.png" width="80%"/>

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.31.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-DC422E?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.18.1-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)](https://cucumber.io/)
[![REST Assured](https://img.shields.io/badge/REST%20Assured-6.0.0-6DB33F?style=for-the-badge)](https://rest-assured.io/)
[![Allure](https://img.shields.io/badge/Allure-2.26.0-FF69B4?style=for-the-badge&logo=allure&logoColor=white)](https://docs.qameta.io/allure/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen?style=for-the-badge)](https://github.com/moqaddasQA/openmrs-healthcare-framework)
[![Test Coverage](https://img.shields.io/badge/coverage-100%25-success?style=for-the-badge)](https://github.com/moqaddasQA/openmrs-healthcare-framework)
[![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=for-the-badge)](https://github.com/moqaddasQA/openmrs-healthcare-framework/pulls)

---

### 🎯 **Enterprise-Ready** • 🚀 **Hybrid Automation** • 📊 **Allure Reporting** • 🐳 **Dockerized**

</div>

---

<table><tr>
<td width="50%" valign="top">

<h3 align="center">🌟 <b>Project Highlights</b></h3>
<ul>
   <li>🔬 <b>Hybrid Automation:</b> Selenium + Cucumber + TestNG + REST Assured</li>
   <li>📦 <b>Modular, Scalable, and Extensible</b></li>
   <li>📊 <b>Allure & JaCoCo Reporting</b></li>
   <li>🐳 <b>Docker-Ready for CI/CD</b></li>
   <li>🛡️ <b>Enterprise-Grade Practices</b></li>
</ul>

</td>
<td width="50%" valign="top">

<h3 align="center">🏆 <b>Key Achievements</b></h3>
<ul>
   <li>✅ <b>100% Pass Rate</b> - All regression & smoke tests passing</li>
   <li>⚡ <b>Fast Execution</b> - Parallel & data-driven</li>
   <li>🧩 <b>Multiple Test Suites</b> - Regression, Smoke, API</li>
   <li>📝 <b>Rich Documentation</b> - Easy onboarding</li>
   <li>🌐 <b>OpenMRS Focused</b> - Healthcare domain ready</li>
</ul>

</td>
</tr></table>

---

<div align="center">

<h3>🧩 <b>Framework Architecture</b></h3>

<img src="https://raw.githubusercontent.com/moqaddasQA/openmrs-healthcare-framework/main/.github/assets/architecture.png" width="70%"/>

<details>
<summary>ASCII Diagram</summary>

<pre>
╔══════════════════════════════════════════════════════════════════╗
║                        🎯 TEST LAYER                            ║
║                                                                ║
║   LoginTest │ RegisterTest │ APIRegression │ BillPayTest       ║
╚══════════════════════════════════════════════════════════════════╝
                                                ↓
╔══════════════════════════════════════════════════════════════════╗
║                    📄 PAGE OBJECT LAYER                         ║
║                                                                ║
║   LoginPage │ RegisterPage │ DashboardPage │ APIPage           ║
╚══════════════════════════════════════════════════════════════════╝
                                                ↓
╔══════════════════════════════════════════════════════════════════╗
║                    🛠️ UTILITIES LAYER                           ║
║                                                                ║
║  DriverFactory │ ConfigManager │ DataProvider │ ReportingUtils  ║
╚══════════════════════════════════════════════════════════════════╝
</pre>

</details>

</div>

---

---


## 📑 Table of Contents
- [🌟 Project Highlights](#-project-highlights)
- [🧩 Framework Architecture](#-framework-architecture)
- [🛠️ Tech Stack](#-tech-stack)
- [⚡ Quick Start](#-quick-start)
- [📋 Prerequisites](#-prerequisites)
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

## 🛠️ Tech Stack

<div align="center">

| Technology | Version | Purpose |
|:----------:|:-------:|:-------:|
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" width="40"/> <br/> **Java** | 21 | Core Language |
| <img src="https://selenium.dev/images/selenium_logo_square_green.png" width="40"/> <br/> **Selenium** | 4.31.0 | Browser Automation |
| <img src="https://avatars.githubusercontent.com/u/12528662?s=200&v=4" width="40"/> <br/> **TestNG** | 7.11.0 | Test Framework |
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" width="40"/> <br/> **Maven** | 3.x | Build Tool |
| <img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="40"/> <br/> **Allure** | 2.26.0 | Test Reporting |
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" width="40"/> <br/> **Docker** | Latest | Containerization |
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg" width="40"/> <br/> **MySQL** | 8.x | Test Data |

</div>

---

## 📋 Prerequisites

<table><tr><td width="50%" valign="top">

<b>Required</b>
<ul>
   <li>☕ Java 21+ <a href="https://www.oracle.com/java/technologies/downloads/#java21">(Download)</a></li>
   <li>📦 Maven 3.x <a href="https://maven.apache.org/download.cgi">(Download)</a></li>
   <li>🔧 Git <a href="https://git-scm.com/downloads">(Download)</a></li>
</ul>

</td><td width="50%" valign="top">

<b>Optional</b>
<ul>
   <li>🐳 Docker (for containerized runs)</li>
   <li>📊 Allure CLI (for reports)</li>
   <li>🧪 ChromeDriver (latest)</li>
</ul>

</td></tr></table>

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