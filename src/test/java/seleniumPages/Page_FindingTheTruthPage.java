package seleniumPages;

import common.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page_findingTheTruthPage contains all the selenium logic for accessing WebElements
 * and performing actions on the screens relating to the Finding The Truth feature.
 */

public class Page_FindingTheTruthPage extends basePage {

    //Home screen WebElements
    @FindBy(id = "pa_5c9126fe3b767_p15577f075e9-textButton")
    WebElement homeStartButton;

    //case selection screen
    @FindBy(id = "pa_5c9126fe3f4fb_p15414dc068c-text")
    WebElement caseSelectionDescriptionText;

    @FindBy(id = "pa_5c9126fe3f4fb_p179d7b273e1-card__image-1")
    WebElement case1Image;

    @FindBy(id = "pa_5c9126fe3f4fb_p179d7b273e1-card__image-2")
    WebElement case2Image;

    //Case 1 screen
    @FindBy(id = "pa_5c9126fe434ba_p154ce332d27-text")
    WebElement case1Description;

    @FindBy(id = "pa_5c9126fe434ba_p15564daa856-textButton")
    WebElement case1JudgeButton;

    //case 2 screen
    @FindBy(id = "pa_5c9126ff8a53e_p154ce332d27-text")
    WebElement case2Description;

    //Case 1 vote screen
    @FindBy(id = "pa_5c9126fe47260_p15515116385-answer-1")
    WebElement case1GuiltyOption;

    @FindBy(id = "pa_5c9126fe47260_p15515116385-answer-2")
    WebElement case1NotGuiltyOption;

    @FindBy(id = "pa_5c9126fe47260_p15515116385-save_button")
    WebElement case1VoteButton;

    //Case 1 Notifications
    @FindBy(id = "pa_5c9126fe47260_p1554e607e3b-modalTitle")
    WebElement case1GuiltyHeader;

    @FindBy(id = "pa_5c9126fe47260_p1554e60707e-modalTitle")
    WebElement case1NotGuiltyHeader;

    @FindBy(id = "pa_5c9126fe47260_p15583b88249-dismiss_button")
    WebElement case1GuiltyContinueButton;

    //side menu
    @FindBy(id = "pr_5c9126fd760e5_p15515b73b67-toolbar__spot--menu__toggle")
    WebElement sideMenuToggle;

    @FindBy(id = "pr_5c9126fd760e5_pp56c46645babc9-menu__body")
    WebElement sideMenu;

    //Final veridict screen
    @FindBy(id = "pa_5c9126fe72755_p155cf0d16a7-card__image-3")
    WebElement DNACaseStudyIcon;

    //DNA case study screen
    @FindBy(id = "pa_5c9126ff79810_p15579041c8c-textButton")
    WebElement DNACaseStudyReturnToFinalVerdictButton;

    public Page_FindingTheTruthPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToWebPage() {
        driver.get("https://learning.elucidat.com/course/5c9126fd760e5-611a53751213a");
    }

    public Boolean confirmOnHomeScreen()  {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(homeStartButton));
        return homeStartButton.isDisplayed();
    }

    public void selectStartButton()  {
        homeStartButton.click();
    }

    public void selectCase(String crimeCase) {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(caseSelectionDescriptionText));

        try {
            switch (crimeCase) {
                case "Making a case against Kevin":
                    case1Image.click();
                    break;
                case "Who is to blame?":
                    case2Image.click();
                    break;
                default:
                    System.out.println("Case not available.");
                    break;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Case not displayed.");
        }
    }

    public boolean confirmOnCaseScreen(String caseName) {
        WebDriverWait wait = (new WebDriverWait(driver, 5));

        try {
            switch (caseName) {
                case "Making a case against Kevin":
                    wait.until(ExpectedConditions.visibilityOf(case1Description));
                    return case1Description.isDisplayed();
                case "Who is to blame?":
                    wait.until(ExpectedConditions.visibilityOf(case2Description));
                    return case2Description.isDisplayed();
                default:
                    System.out.println("Case not available.");
                    return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Case screen was not displayed. Test timed out.");
            return false;
        }
    }

    public void selectJudgeThisButton()  {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(case1JudgeButton));
        case1JudgeButton.click();
    }

    public void selectVoteChoice(String vote) {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(case1VoteButton));

        try {
            switch (vote) {
                case "GUILTY!":
                    case1GuiltyOption.click();
                    break;
                case "NOT GUILTY!":
                    case1NotGuiltyOption.click();
                    break;
                default:
                    System.out.println("Option not available.");
                    break;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Option not displayed.");
        }
    }

    public void selectVoteButton() {
        case1VoteButton.click();
    }

    public String getNotificationHeaderText(String vote) {
        WebDriverWait wait = (new WebDriverWait(driver, 5));

        try {
            switch (vote) {
                case "GUILTY!":
                    wait.until(ExpectedConditions.visibilityOf(case1GuiltyHeader));
                    return case1GuiltyHeader.getText();
                case "NOT GUILTY!":
                    wait.until(ExpectedConditions.visibilityOf(case1NotGuiltyHeader));
                    return case1NotGuiltyHeader.getText();
                default:
                    System.out.println("Option not available.");
                    return "Option not available.";
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Notification not displayed. Test timed out.");
            return "Notification not displayed.";
        }
    }

    public void selectContinueOnGuiltyVoteNotification() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(case1GuiltyContinueButton));
        case1GuiltyContinueButton.click();
    }

    public void openSideMenu() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(sideMenuToggle));
        sideMenuToggle.click();
    }

    public void selectFinalVerdictFromSideMenu() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(sideMenu));
        sideMenu.findElement(By.xpath("li[2]/ul/li[12]/a/span[text() = \"FINAL VERDICT\"]")).click();
    }

    public void selectDNACaseStudy() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOf(DNACaseStudyIcon));
        DNACaseStudyIcon.click();
    }

    public Boolean confirmOnDNACaseScreen() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        try {
            wait.until(ExpectedConditions.visibilityOf(DNACaseStudyReturnToFinalVerdictButton));
            return DNACaseStudyReturnToFinalVerdictButton.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("DNA case study not displayed. Test timed out.");
            return false;
        }
    }
}