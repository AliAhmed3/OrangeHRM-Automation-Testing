# 📌 OrangeHRM Automation Testing Project
# 📖 Overview

This repository contains automated test scripts for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) web application using Java, Selenium WebDriver, TestNG, and Maven.
The project follows the Page Object Model (POM) with the Fluent Interface Pattern for clean and maintainable test code.
It also integrates Allure Reports for test reporting and Java Faker for generating realistic test data.

# 🛠 Tech Stack
- **Java 24** for Programming language
- **Selenium WebDriver**	for Web automation
- **TestNG** for Test execution framework
- **Maven** for Build & dependency management
- **Allure Reports** for visual test reporting
- **Java Faker** for Random test data generation
- **Page Object Model**	for Test design pattern
- **Fluent Interface Pattern** for Improves readability of test steps

# ⚙️ Setup & Installation
## 1️⃣ Prerequisites
Before running the tests, ensure you have installed:
- **Java 24** → [Download](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html)
- **Maven** → [Download](https://maven.apache.org/)
- **Allure** Commandline → [Download](https://docs.qameta.io/allure/#_installing_a_commandline)

Check installation:
- ```java -version```
- ```mvn -version```
- ```allure --version ```

## 2️⃣ Clone the Repository
- ```git clone https://github.com/your-username/orangehrm-automation.git```
- ```cd orangehrm-automation```

## 3️⃣ Install Dependencies
```mvn clean install```

# 🚀 Running the Tests
option1:
```mvn clean test```

option2: run testng.xml file manually or use thie command:
```mvn clean test -DsuiteXmlFile=testng.xml```



