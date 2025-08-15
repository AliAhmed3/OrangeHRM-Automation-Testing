# 📌 OrangeHRM Automation Testing Project
# 📖 Overview

This repository contains automated test scripts for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) web application using Java, Selenium WebDriver, TestNG, and Maven.
The project follows the Page Object Model (POM) with the Fluent Interface Pattern for clean and maintainable test code.
It also integrates Allure Reports for test reporting and Java Faker for generating realistic test data.

# 🛠 Tech Stack
- **Java 24** for Programming language
- **Selenium WebDriver** for Web automation
- **TestNG** for Test execution framework
- **Maven** for Build & dependency management
- **Allure Reports** for visual test reporting
- **Java Faker** for Random test data generation
- **Page Object Model**	for Test design pattern so, All locators and actions are defined inside the respective page class.
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

# 📊 Generating Reports
## Allure Report
After running the tests:
```allure serve target/allure-results```

# 🔄Scenario
1. Navigate to the website
2. Login using:
○ Username: Admin
○ Password: admin123
3. Click on the Admin tab in the left-side menu
4. Capture the number of records found
5. Click on Add button and fill in required user data
6. Click on Save
7. Verify that the number of records increased by 1
8. Search by the newly created username
9. Delete the user
10. Verify that the number of records decreased by 1

# 📂 Project Structure
```orangehrm-automation/
│
├── 📜 pom.xml                          
├── 📜 testng.xml                       # TestNG suite configuration                       
│
├── 📂 src
│   ├── 📂 main
│   │   └── 📂 java
│   │       └── 📂 utils
│   │           ├── ConfigReader.java   # Reads config.properties
│   │           ├── DriverFactory.java  # WebDriver setup 
│   │           └── Utility.java        # Faker-based random data
            └── 📂 pages                # Page Object Model classes
│           │   ├── AddUserPage.java     # adduser page locators & actions
│           │   ├── LoginPage.java      # Login page locators & actions
│           │   ├── DashboardPage.java  # Dashboard page locators & actions
│           │   ├── AdminPage.java      # Add/Search/Delete Employee actions
│           │   └── ...

│   │          
│   │
│   └── 📂 test
│       └── 📂 java
│           ├── 📂 tests                # Test classes
│           │   ├── BaseTest.java       # Common setup/teardown for tests
│           │   ├── fullScenarioTest.java     
│           │
│           └── 📂 listeners            # TestNG Listeners
│               └── MethodListener.java   
│               └── TestListener.java    
│       └── 📂 resources
                📂 TestData            
│                         └── environment.properties     
│                         └── validLogin.json      #data  

├── 📂 target                            # Maven output folder (auto-generated)
│   ├── 📂 allure-results                # Allure results (after running tests)
│   ├── 📂 surefire-reports              # TestNG HTML reports
│   └── ...
│
```
# 🔄 Test Data
- **Java Faker is used for generating dynamic data**
