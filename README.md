#  Selenium Java Automation - Login, Logout & Search Profile

This project automates the login, search, and logout process on [Intervue.io](https://www.intervue.io/) using **Selenium WebDriver with Java**.

---

##  **Project Overview**

- **Purpose:** Automate login, search for a profile, and logout process.
- **Technologies Used:**
  - Java 21
  - Selenium WebDriver 4.28.1
  - WebDriverManager
  - Eclipse IDE (or any Java IDE)
- **Tested On:**
  - Windows 11
  - Chrome Version: `134.0.6998.117`

---

##  **Project Structure**


---

## 📄 **Code Summary**

###  **1. Login to Intervue.io**
- Navigate to `https://www.intervue.io/login`.
- Enter the email and password.
- Click the login button.

###  **2. Handle Modals or Popups (if any)**
- Check for modal visibility and close it if present.

###  **3. Click on 'Request Interview' Button**
- Scroll the button into view.
- Click the button using `JavascriptExecutor`.

###  **4. Search for 'Frontend' Profile**
- Enter the search term in the search bar.
- Click the search button.

###  **5. Logout Process**
- Click on the profile image.
- Select the logout option.

---

## ⚙️ **Prerequisites**

1. **Java JDK 21+**  
   Download and install [Java JDK](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).

2. **Chrome Browser v134+**  
   Ensure Chrome is updated to version `134.0.6998.117`.

3. **Eclipse IDE (Recommended)**  
   Download from [Eclipse Official Website](https://www.eclipse.org/downloads/).

4. **Selenium WebDriver 4.28.1**
   - Download the required JAR files:
     - `selenium-java-4.28.1.jar`
     - `selenium-devtools-v134.jar` (for matching CDP version)
   - Or include via Maven:
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.28.1</version>
</dependency>
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-devtools-v134</artifactId>
    <version>4.28.1</version>
</dependency>

