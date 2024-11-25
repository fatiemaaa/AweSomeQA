package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class P01_HomePage {
    // 1- webdriver declaration
    // 2- constructor
    // 3- locators
    // 4- public action methods
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public P01_HomePage(WebDriver driver){
        this.driver=driver;
    }
    private final By MYACCOUNT_List= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/account\"]");
    private final By REGISTER_LISTBUTTON= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/register\"]");
    private final By LOGIN_LISTBUTTON= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/login\"]");
    private final By CURRENCYLIST= By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    private final By AddToCartBtn = By.xpath("//div[@class= 'product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'][2]//span[text()='Add to Cart']");
    private final By AddToWishListBtn = By.xpath("//div[@class= 'product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'][1]//button[@data-original-title='Add to Wish List']");
    private final By USDOPTION= By.xpath("//button[@class='currency-select btn btn-link btn-block' and @name='USD']");
    private final By SEARCHBOX= By.xpath("//input[@type='text']");
    private final By SEARCHBTN= By.xpath("//span[@class='input-group-btn']");
    private final By DESKTOPCATEGORY= By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/category&path=20']");
    private final By LAPTOPSANDNOTEBOOKSCATEGORY= By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    private final By TABLETSCATEGORY= By.xpath("(//a[@href='https://awesomeqa.com/ui/index.php?route=product/category&path=57'])[1]");
    private final By CATEGORY_LIST = By.xpath("//span[@id='category']");
    final private By CheckOutBtn = By.xpath("//a[@title='Checkout']");

    private final   By ComponentsBtn = By.xpath("//a[text()='Components']");
    private final By TAG_LIST = By.xpath("//div[@class='tag-selector']");

    public P01_HomePage openMyAccountList(){
        driver.findElement(MYACCOUNT_List).click();
        return this;
    }
    public P01_HomePage clickRegisterListButton() throws InterruptedException {
        driver.findElement(REGISTER_LISTBUTTON).click();
        return this;
    }
    public P01_HomePage clickLoginListButton(){
        driver.findElement(LOGIN_LISTBUTTON).click();
        return this;
    }

//    public By getCurrencyList() {
//        return CurrencyList;}



    public P01_HomePage SEARCHBOX(String labtop) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(this.SEARCHBOX).sendKeys(labtop);
        return this;
    }
    public P01_HomePage ClickOnSearchBtn(){
        driver.findElement(SEARCHBTN).click();
        return this;
    }
    public P01_HomePage Change_Currency_To_USD(){
        driver.findElement(CURRENCYLIST).click();
        driver.findElement(USDOPTION).click();
        return this;
    }
    public void AddProductToCart() {
        driver.findElement(AddToCartBtn).click();

    }

//    public void AddProductToWishList() {
//        driver.findElement(AddToWishListBtn).click();
//
//    }
    public P01_HomePage SelectCategory(String category) {
        switch (category.toLowerCase()) {
            case "desktops":
                driver.findElement(DESKTOPCATEGORY).click();
                break;
            case "labtops & notebooks":
                driver.findElement(LAPTOPSANDNOTEBOOKSCATEGORY).click();
                break;
            case "tablets":
                driver.findElement(TABLETSCATEGORY).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
        return this;
    }
    public class CategorySelector {
        private final By DESKTOP = By.xpath("//a[text()='Desktops']");
        private final By LAPTOP = By.xpath("//li[@class='dropdown']/a[contains(text(),'Notebooks')]");
        private final By COMPONENT = By.xpath("//li[@class='dropdown']/a[contains(text(),'Components')]");

        private final WebDriver driver;
        private final Random random;
        private final WebDriverWait wait;
        private final Actions actions;
        private final JavascriptExecutor js;

        public CategorySelector(WebDriver driver) {
            this.driver = driver;
            this.random = new Random();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            this.actions = new Actions(driver);
            this.js = (JavascriptExecutor) driver;

            // Set window size to ensure hover actions work properly
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }

        public String hoverAndClickRandomSubcategory() {
            try {
                System.out.println("Starting hover and click operation...");
                String currentUrl = driver.getCurrentUrl();

                // Wait for page to be fully loaded
                wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

                // Get list of main categories and select one randomly
                List<By> categories = Arrays.asList(DESKTOP, LAPTOP, COMPONENT);
                By randomLocator = categories.get(random.nextInt(categories.size()));

                System.out.println("Selected category locator: " + randomLocator);

                // Find and verify the selected category is present
                WebElement categoryElement = wait.until(ExpectedConditions.presenceOfElementLocated(randomLocator));
                String categoryName = categoryElement.getText().trim();
                System.out.println("Found category element: " + categoryName);

                // Trigger dropdown using multiple methods
                int maxAttempts = 3;
                for (int attempt = 0; attempt < maxAttempts; attempt++) {
                    System.out.println("Attempt " + (attempt + 1) + " to trigger dropdown");

                    // 1. Direct click to open dropdown
                    js.executeScript("arguments[0].click();", categoryElement);
                    Thread.sleep(500);

                    // 2. Simulate hover event using JavaScript
                    js.executeScript(
                            "var event = new MouseEvent('mouseover', {" +
                                    "  bubbles: true," +
                                    "  cancelable: true," +
                                    "  view: window" +
                                    "});" +
                                    "arguments[0].dispatchEvent(event);",
                            categoryElement
                    );
                    Thread.sleep(500);

                    // 3. Force dropdown to be visible
                    js.executeScript(
                            "var parent = arguments[0].closest('.dropdown');" +
                                    "if(parent) {" +
                                    "  parent.classList.add('open');" +
                                    "  var menu = parent.querySelector('.dropdown-menu');" +
                                    "  if(menu) {" +
                                    "    menu.style.cssText = 'display: block !important; opacity: 1 !important; visibility: visible !important;';" +
                                    "  }" +
                                    "}",
                            categoryElement
                    );

                    try {
                        // Find all subcategory links
                        List<WebElement> subcategories = driver.findElements(
                                By.xpath("//li[contains(@class,'dropdown') and .//a[contains(text(),'" + categoryName + "')]]" +
                                        "//ul[@class='list-unstyled']//a")
                        );

                        if (!subcategories.isEmpty()) {
                            // Select and click random subcategory
                            WebElement randomSubcategory = subcategories.get(random.nextInt(subcategories.size()));
                            String subcategoryText = randomSubcategory.getText().trim();
                            String subcategoryUrl = randomSubcategory.getAttribute("href");

                            System.out.println("Clicking subcategory: " + subcategoryText);
                            js.executeScript("arguments[0].click();", randomSubcategory);

                            // Wait for navigation to complete
                            wait.until(driver -> !driver.getCurrentUrl().equals(currentUrl));
                            System.out.println("Successfully navigated to subcategory page");

                            return subcategoryText;
                        }
                    } catch (Exception e) {
                        System.out.println("Attempt " + (attempt + 1) + " failed: " + e.getMessage());
                        if (attempt == maxAttempts - 1) {
                            throw new RuntimeException("Failed to interact with dropdown after " + maxAttempts + " attempts", e);
                        }
                        Thread.sleep(1000);
                    }
                }
                throw new RuntimeException("No subcategories found for category: " + categoryName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while waiting for hover effect", e);
            }
        }
    }
    public void OpenCheckOutPage() {

        driver.findElement(CheckOutBtn).click();

    }











}
