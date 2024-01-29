package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


    public class CommonActionsWithElements {

        protected WebDriver webDriver;
        WebDriverWait webDriverWait10, webDriverWait15;

        public CommonActionsWithElements(WebDriver webDriver) {
            this.webDriver = webDriver;
            PageFactory.initElements(webDriver, this);
            webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        }

        protected void enterTextIntoElement(WebElement webElement, String text) {
            try {
                webElement.clear();
                webElement.sendKeys(text);
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

        protected void clickElement(WebElement webElement) {
            try {
                //webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

        protected void clickElement(String xpath) {
            try {
                clickElement(webDriver.findElement(By.xpath(xpath)));

            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

        protected void scroll(WebElement webElement) {
            new Actions(webDriver).moveToElement(webElement).perform();
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("javascript:window.scrollBy(250,350)");
        }

        protected void customDragAndDrop (WebElement source, WebElement target) {
            Actions actions = new Actions(webDriver);
            try {
            actions.dragAndDrop(source,target).build().perform();
            } catch (Exception e) {
               Assert.fail("Can't drag and drop");
            }
        }

        protected void selectTextInDropDown(WebElement dropDown, String visibleText) {
            try{

                Select select = new Select(dropDown);
                select.selectByVisibleText(visibleText);
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

        protected void selectValueInDropdown (WebElement dropDown, String value){
            try {
                Select select = new Select(dropDown);
                select.selectByValue(value);

            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

        protected void uncheckCheckbox(WebElement checkbox){
            if (isCheckboxSelected(checkbox)) {
                checkCheckbox(checkbox);
            }
        }

        protected void checkCheckbox(WebElement checkbox) {
            if (!isCheckboxSelected(checkbox)) {
                clickElement(checkbox);
            }
        }

        protected boolean isCheckboxSelected (WebElement checkbox) {
            return checkbox.isSelected();
        }

        protected boolean isElementDisplayed(WebElement webElement) {
            try {
                boolean state = webElement.isDisplayed();
                String message;
                if (state) {
                    message = getElementName(webElement) + " Element is displayed";
                } else {
                    message = getElementName(webElement) + " Element is not displayed";
                }

                return state;
            } catch (Exception e) {

                return false;
            }
        }

        private String getElementName(WebElement webElement) {
            try {
                return webElement.getAccessibleName();
            } catch (Exception e) {
                return "";
            }
        }

        protected void printErrorAndStopTest(Exception e) {

            Assert.fail("Can not work with element " + e);
        }



    }


