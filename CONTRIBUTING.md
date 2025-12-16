# Contributing to OpenMRS Healthcare Testing Framework

Thank you for your interest in contributing! This document provides guidelines for contributing to this project.

## 🤝 How to Contribute

### Reporting Issues

1. **Search existing issues** first to avoid duplicates
2. **Use descriptive titles** for issues
3. **Provide detailed information**:
   - Steps to reproduce
   - Expected vs actual behavior
   - Environment details (OS, browser, Java version)
   - Screenshots if applicable

### Submitting Pull Requests

1. **Fork the repository**
2. **Create a feature branch**:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Make your changes** following the coding standards
4. **Add tests** for new functionality
5. **Run all tests**:
   ```bash
   mvn clean test
   ```
6. **Commit your changes**:
   ```bash
   git commit -m "feat: add your feature description"
   ```
7. **Push to your fork**:
   ```bash
   git push origin feature/your-feature-name
   ```
8. **Create a Pull Request**

## 📝 Coding Standards

### Java Code Style

- Follow Google Java Style Guide
- Use meaningful variable and method names
- Add Javadoc comments for public methods
- Keep methods small and focused
- Use proper exception handling

### Example:

```java
/**
 * Logs in to the application with provided credentials
 * @param username The username for login
 * @param password The password for login
 * @throws LoginException if login fails
 */
public void login(String username, String password) {
    logger.info("Attempting login with username: {}", username);
    // Implementation
}
```

### Test Naming Convention

- Use descriptive test method names
- Follow pattern: `methodName_condition_expectedResult`

```java
@Test
public void login_withValidCredentials_shouldNavigateToDashboard() {
    // Test implementation
}

@Test
public void login_withInvalidCredentials_shouldShowErrorMessage() {
    // Test implementation
}
```

## 🧪 Testing Guidelines

### Writing Tests

1. **Extend BaseTest** for all test classes
2. **Use Page Object Model** pattern
3. **Add proper assertions** with AssertJ
4. **Include logging** for important steps
5. **Use Allure annotations** for better reporting

### Example Test:

```java
public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Authentication")
    public void login_withValidCredentials_shouldNavigateToDashboard() {
        // Given
        LoginPage loginPage = new LoginPage();

        // When
        loginPage.login("admin", "Admin123");

        // Then
        assertThat(getPageTitle()).contains("Home");
    }
}
```

## 📁 Project Structure Guidelines

### Adding New Features

1. **Page Objects**: Add to `src/test/java/com/openmrs/qa/pages/`
2. **Step Definitions**: Add to `src/test/java/com/openmrs/qa/steps/`
3. **API Tests**: Add to `src/test/java/com/openmrs/qa/api/`
4. **Utilities**: Add to `src/test/java/com/openmrs/qa/utilities/`

### File Naming

- **Page Objects**: `PageNamePage.java` (e.g., `LoginPage.java`)
- **Test Classes**: `FeatureNameTest.java` (e.g., `LoginTest.java`)
- **Step Definitions**: `FeatureNameSteps.java` (e.g., `LoginSteps.java`)

## 🔧 Development Setup

1. **Clone the repository**
2. **Import as Maven project** in your IDE
3. **Install Lombok plugin** in your IDE
4. **Set up code formatting** with Google Java Format

## 📋 Pull Request Checklist

Before submitting a PR, ensure:

- [ ] Code follows project style guidelines
- [ ] All tests pass locally
- [ ] New functionality has tests
- [ ] Documentation is updated
- [ ] Commit messages follow conventional format
- [ ] No sensitive data is committed

## 📝 Commit Message Format

Use conventional commits:

```
type(scope): description

[optional body]

[optional footer]
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

Examples:
```
feat(login): add remember me functionality
fix(driver): resolve Chrome driver initialization issue
docs(readme): update installation instructions
```

## 🐛 Bug Reports

When reporting bugs, include:

1. **Environment Details**:
   - OS version
   - Browser version
   - Java version
   - Framework version

2. **Steps to Reproduce**:
   - Detailed step-by-step instructions
   - Code snippets if applicable

3. **Expected vs Actual Behavior**:
   - What you expected to happen
   - What actually happened
   - Error messages or stack traces

## 💡 Feature Requests

For feature requests:

1. **Describe the use case** clearly
2. **Explain why** it's needed
3. **Suggest implementation** if you have ideas
4. **Consider impact** on existing functionality

## 📞 Getting Help

- Create an issue for questions
- Check existing documentation
- Review existing issues for similar problems

## 📄 License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing to the OpenMRS Healthcare Testing Framework! 🎉