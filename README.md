# DemoBlaze-Automation
Selenium Automation Testing for DemoBlaze site

This project is a Selenium-based UI test automation framework for the [DemoBlaze](https://www.demoblaze.com) website. It uses Java, Cucumber (Gherkin), Selenium WebDriver, and JUnit, with Gradle as the build tool.

The purpose is to validate functionality of DemoBlaze registration and login feature and how they work

Configurations & Tools
- Java ( Programming Language )
- Selenium WebDriver (Automation Framework)
- Cucumber (BDD with Gherkin syntax)
- Gradle (Build tool)
- JUnit 5 (Test runner)
- WebDriverManager (Automatic driver management)


🧪 How to Run Tests
1. Test can run from respective .feature under resources package
2. Run the following command from the root of the project in terminal:
   ./gradlew cucumber

Case Example :
- Scenario: user can login with valid account
1. Given user is on demoblaze homepage
2. And user has click login button
3. And Login modal is shown to user
4. When user enter username "DemoAccount15" and password "DemoAccount15"
5. And user click Login
6. When user will successfully login and directed to homepage





