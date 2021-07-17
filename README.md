# FrankVasco_Test

SwagLabs test


This project is about the automation testing of some scenarios to test the site https://www.saucedemo.com/, using Chrome browser.


There are 4 scenarios described in the path SwagLabs\src\test\java\Features, These scenarios are described using Gherkin language.
1. Cart.feature : Describes the process of logging in the app and adding products to the shopping cart

2. Logout.feature:Describes the scenario of logging out the app.

3. PurchaseProduct.feature: Describes an E2E test which takes into account the logging to Swaglabs, selecting one product from the homepage, checkout the purchase, 
filling the personal info, and finishing the process of the purchase.

4. Login.feature:  Describes the login of the app, using a valida credentials (This Scenario is fully automated and can be run, executing the java class called TestRunner 
located in the path SwagLabs\src\test\java\Frank_Vasco_Test\Runner also the glueCode for the Sceanrio is in the path SwagLabs\src\test\java\Frank_Vasco_Test\SeleniumGlueCode),
The pluggin used for automate those test Cases is Cucumber.


Additionally, There 2 more Test Cases, one for the loggin and one that selects the lowest price product and the highest price product from the homepage, and perform the whole 
process of buying the product.
This two test cases can be run using the suite "Suite.xml" which is in the path SwagLabs\src\test\java\Frank_Vasco_Test\Suite, The credentials to run those 2 the test cases
is in the Data provider "DataProvider". The framework used for those test Cases is TestNG.


Also, the project is carried out using Page Object Model (The pages are in the package in path SwagLabs\src\main\jav\Frank_Vasco_Test\Pages). 
The "BasePage" is the super class where are defined all the generic methods that will be used in the other child classes or pages. The driver is set in the class "MyDriver".

