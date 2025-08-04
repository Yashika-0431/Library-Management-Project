
# 🧪 Automated Testing Suite for a Web Application (Library Management)

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/tech-Java-orange)
![Selenium](https://img.shields.io/badge/tested%20with-Selenium-brightgreen)
![Cucumber](https://img.shields.io/badge/BDD-Cucumber-9cf)

This project is an automated testing suite developed for a web-based Library Management application using **Selenium WebDriver**, **TestNG**, **Cucumber (BDD)**, **Java**, and **Maven**. It focuses on functional UI automation using a clean modular structure and BDD best practices.

---

## 🔧 Technologies Used

- **Programming Language:** Java  
- **Testing Tools:** Selenium WebDriver, TestNG, Cucumber (BDD)  
- **Build Tool:** Maven  
- **Approach:** Behavior Driven Development (BDD)  
- **Test Data:** Hardcoded input (some Data-Driven Testing implemented)  
- **Design Pattern:** Modular classes without PageFactory  

---

## 🧱 Project Structure

- Maven project with dependencies managed via `pom.xml`  
- Feature files (`*.feature`) written in **Gherkin syntax**  
- Test execution handled using `testng.xml` and `TestRunner.java`  
- Web interactions implemented with PageFactory
- Input data is hardcoded for each test scenario  
- Logs and reports generated via hooks and configured reporters  

---

## 🧩 Reusable Components

### `Hooks.java`

- Handles browser setup and teardown using `@Before` and `@After`
- Captures screenshots on failure
- Provides reusable utilities and global setup

### `TestRunner.java`

- Configures execution options (`features`, `glue`, `tags`)
- Integrates **Cucumber** with **TestNG** for parallel execution and reporting

---

## 👥 Team Contributions

### **K.V. Surendra** – Setup and Infrastructure

- Created BDD-compliant folder structure
- Configured Maven, dependencies, and project setup
- Developed `SetUpHooks.java` and `DriverSetup.java`
- Wrote `ConfigReader.java`  

### **Karthik** – BookSection and ChatSupport Modules

- Authored `BookSection.feature` and `ChatSupport.feature`
- Implemented `BookService.java` and `ChatSupport.java`
- Wrote `BookServiceStepDef.java` and `ChatSupportStepDef.java`
- Validated BookSection and ChatSupport workflows

### **Rithusree** – EmailSupport and LibraryCard Modules , Properties and Runner file

- Authored `EmailSupport.feature` and `LibraryCard.feature`
- Implemented `EmailSupport.java` and `LibraryCard.java`
- Wrote `EmailSupportStepDef.java` and `LibraryCardStepDef.java`
- Validated EmailSupport and LibraryCard workflows
- Wrote `TestRunner.java` runner file and `Setup.properties`

### **Yashika** – Membership and SearchBook Modules , Screenshot and Data driven framework

- Authored `Membership.feature` and `SearchBook.feature`
- Implemented `Membership.java` and `SearchBook.java`
- Wrote `MembershipStepDef.java` and `SearchBookStepDef.java`
- Validated Membership and SearchBook workflows
- Wrote `ScreenshotUtil.java` , `ExcelReader.java` and Excel Data sheet
- Extent Report and Cucumber Report generation

---

## 📚 Agile Artifacts

- ✅ **Product Backlog**:  
  High-level goals and feature priorities for the automation suite.

- ✅ **Sprint Backlog**:  
  Task assignments per module, mapped to test case progress.
