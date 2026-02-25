<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Smonk12/webshop_in_beta_playwright" alt="Test Automation" border="0">
    <img src="https://i.ibb.co/bR7w95gs/Test-Automation.png" alt="Test Automation" border="0" alt="Logo" width="200" height="200">
  </a>

  <h3 align="center">Webshop In Beta – Playwright</h3>

  <p align="center">
    Playwright-based end-to-end UI test automation framework in Java using JUnit 5 to validate core webshop workflows, built alongside a parallel Selenium implementation for framework comparison.
    <br />
    <a href="https://github.com/Smonk12/webshop_in_beta_playwright"><strong>Explore the docs »</strong></a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#contributing">Contributing</a></li>
    <li>
      <a href="#contact">Contact</a></li>
    <li>
      <a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

---

<!-- ABOUT THE PROJECT -->
## About The Project

This project is a **modern Playwright-based test automation framework** for the Sauce Demo webshop (https://www.saucedemo.com/), designed to validate **core user workflows** through reliable end-to-end testing.

It covers essential e-commerce scenarios such as:

- **User login and authentication**
- **Adding and removing products from the shopping cart**
- **Checkout process and form validation**

The tests are implemented in **Java** using **Microsoft Playwright** for **fast, stable, and modern browser automation**, combined with **JUnit 5** for structured test execution and assertions.

This project demonstrates a **clean, maintainable, and scalable automation architecture**, focusing on improved **execution speed**, **test reliability**, and **developer feedback cycles**.

For comparison, the same webshop automation project was also implemented using **Selenium WebDriver**, highlighting differences between traditional and modern automation frameworks:  
https://github.com/Smonk12/webshop_in_beta.git


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

Core

[![Java][Java.com]][Java-url]
[![JUnit][JUnit.org]][JUnit-url]

Test Automation

[![Playwright][Playwright.dev]][Playwright-url]

Tooling

[![Maven][Maven.apache]][Maven-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- GETTING STARTED -->

## Getting Started

These instructions will help you set up and run the project locally.

### Prerequisites

Before you begin, ensure the following are installed:

-   **Java 11** or later – [Download Java](https://www.oracle.com/java/)
-   **Maven** – [Install Maven](https://maven.apache.org/)
-   **Git**
-   A modern web browser (Chromium, Firefox, or WebKit – Playwright manages these automatically)

Verify installation by running:

```bash
java -version 
mvn -v 
git --version
```

### Installation

1.  **Clone the repository**

    ```bash
    git clone https://github.com/Smonk12/webshop_in_beta_playwright.git
    cd webshop_in_beta_playwright
    ```
2.  **Install dependencies**

    Maven will download all required dependencies automatically.

    ```bash
    mvn clean install
    ```

3. **Install Playwright browsers**
    ```bash
    mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
    ```

4.  **Run tests**

    ```bash
    mvn test
    ```


💡 **Tip:**

Playwright handles browser installation and waiting automatically, so usually we don’t need to manage drivers or add extra waits in our tests.

<!-- USAGE EXAMPLES -->

## Usage

Execute automated tests using Maven. The tests cover the main workflows of the Sauce Demo webshop.

### Running All Tests

  ```bash
  mvn clean test
  ```

This will launch Playwright in headless mode by default, execute all tests, and print the results to the console.

### Running Specific Tests

You can run a specific test class:

  ```bash
  mvn -Dtest=LoginTests test
  ```

### Headed Mode (Visible Browser)

If your project supports it, you can configure Playwright to run in headed mode for debugging purposes.

### Test Reports

JUnit outputs results to the console and into the `target` directory.
Additional reporting (e.g., HTML reports or CI integration) can be added via Maven plugins or CI pipelines.


<!-- ROADMAP -->
## Roadmap

The project is actively under development, roadmap usually will line up with Selenium written project. The current progress and planned features are as follows:

- [x] Set up Playwright Java project structure with Maven  
- [x] Configure Playwright and browser management  
- [x] Implement Page Object Model (POM) structure  
- [x] Migrate login tests from Selenium to Playwright  
- [x] Implement product listing page tests  
- [x] Implement shopping cart tests (add/remove items, cart validation)  
- [x] Implement checkout flow tests  
- [x] Integrate project with CI (Jenkins)   
- [ ] Add tests for user session handling  *[IN PROGRESS]*

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Contributing:

<a href="https://github.com/Smonk12/webshop_in_beta_playwright/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Smonk12/webshop_in_beta_playwright" alt="contrib.rocks image" />
</a>

Contributors to this project are responsible for implementing, reviewing, and maintaining automated test scenarios.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Bácsik Szabolcs - bacsikszabi@gmail.com

Project Link: https://github.com/Smonk12/webshop_in_beta_playwright

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Sauce Demo](https://www.saucedemo.com/) – Web application the tests run against  
* [Playwright](https://playwright.dev/java/) – Browser automation framework  
* [JUnit 5](https://junit.org/junit5/) – Test execution and assertions  
* [Maven](https://maven.apache.org/) – Build and dependency management tool  
* [MDN Web Docs](https://developer.mozilla.org/) – Reference for Java, HTML, CSS, and web technologies  
* [Img Shields](https://shields.io/) – Dynamic badges for README  
* [GitHub Markdown Cheatsheet](https://guides.github.com/features/mastering-markdown/) – Quick reference for Markdown formatting  

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[contributors-url]: https://github.com/Smonk12/webshop_in_beta_playwright/graphs/contributors
[issues-shield]: https://img.shields.io/github/issues/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[issues-url]: https://github.com/Smonk12/webshop_in_beta_playwright/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/b%C3%A1csik-szabolcs-6150b735b/



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[contributors-url]: https://github.com/Smonk12/webshop_in_beta_playwright/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[forks-url]: https://github.com/Smonk12/webshop_in_beta_playwright/network/members
[stars-shield]: https://img.shields.io/github/stars/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[stars-url]: https://github.com/Smonk12/webshop_in_beta_playwright/stargazers
[issues-shield]: https://img.shields.io/github/issues/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[issues-url]: https://github.com/Smonk12/webshop_in_beta_playwright/issues
[license-shield]: https://img.shields.io/github/license/Smonk12/webshop_in_beta_playwright.svg?style=for-the-badge
[license-url]: https://github.com/Smonk12/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/b%C3%A1csik-szabolcs-6150b735b/
[product-screenshot]: images/screenshot.png

[Java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.oracle.com/java/

[JUnit.org]: https://img.shields.io/badge/JUnit%205-25A162?style=for-the-badge&logo=junit5&logoColor=white
[JUnit-url]: https://junit.org/junit5/

[Playwright.dev]: https://img.shields.io/badge/Playwright-45ba4b?style=for-the-badge&logo=playwright&logoColor=white
[Playwright-url]: https://playwright.dev/java/

[Maven.apache]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/
