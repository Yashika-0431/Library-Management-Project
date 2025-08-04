
# 🧪 Automated Testing Suite for a Web Application (Library Management)

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/tech-Java-orange)
![Selenium](https://img.shields.io/badge/tested%20with-Selenium-brightgreen)
![Cucumber](https://img.shields.io/badge/BDD-Cucumber-9cf)

This project is an automated testing suite developed for a web-based Library Management application using **Selenium WebDriver**, **TestNG**, **Cucumber (BDD)**, **Java**, and **Maven**. It focuses on functional UI automation using a clean modular structure and BDD best practices.

---

## 📸 Screenshots

> Add your screenshots inside a `/screenshots` folder and update the paths below

### 🖼️ Login Scenario
![Login Feature](screenshots/login.png)

### 📄 HTML Report Example
![Report Example](screenshots/report.png)

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
- Web interactions implemented with direct locators (no PageFactory)  
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
- Developed `Hooks.java` for:
  - Browser management
  - Screenshot capture
  - Logging and reporting
- Managed reusable utilities (e.g., wait strategies, config)

### **Karthik** – Login and Dashboard Features

- Authored `Login.feature` and `Dashboard.feature`
- Implemented `LoginSteps.java` and `DashboardSteps.java`
- Developed `LoginPage.java` and `DashboardPage.java`
- Validated login workflows and dashboard personalization

### **Rithusree** – Registration and Search Modules

- Created `Registration.feature` and `Search.feature`
- Wrote steps in `RegistrationSteps.java` and `SearchSteps.java`
- Developed `RegistrationPage.java` and `SearchPage.java`
- Automated registration and search/filter flows

### **Yashika** – Product Listing and Checkout Features

- Developed `ProductListing.feature` and `Checkout.feature`
- Mapped Gherkin steps in `ProductListingSteps.java` and `CheckoutSteps.java`
- Built `ProductListingPage.java` and `CheckoutPage.java`
- Automated product grid, filtering, and checkout scenarios

---

## 📚 Agile Artifacts

- ✅ **Product Backlog**:  
  High-level goals and feature priorities for the automation suite.

- ✅ **Sprint Backlog**:  
  Task assignments per module, mapped to test case progress.


## 🚀 How to Run the Test Suite

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/library-automation-suite.git
   cd library-automation-suite
2. **Build the project**

   ```bash
   mvn clean install
   ```

3. **Run tests using TestNG**

   ```bash
   mvn test
   ```

4. **Check reports**

   * Generated HTML reports available in the `/target` directory

## 📁 Folder Structure

```text
.
├── features/
│   ├── Login.feature
│   ├── Dashboard.feature
│   ├── Registration.feature
│   └── ...
├── pages/
│   ├── LoginPage.java
│   ├── DashboardPage.java
│   └── ...
├── stepDefinitions/
│   ├── LoginSteps.java
│   ├── RegistrationSteps.java
│   ├── Hooks.java
│   └── ...
├── runners/
│   └── TestRunner.java
├── pom.xml
└── testng.xml
```

---

## 🪪 License

This project is licensed under the [MIT License](LICENSE).

---

## 📫 Contact

For queries or collaboration:

* 📧 Email: [your-email@example.com](mailto:your-email@example.com)
* 💬 GitHub Issues: [Submit here](https://github.com/your-username/library-automation-suite/issues)

---




