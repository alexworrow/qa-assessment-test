package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumPages.Page_FindingTheTruthPage;

/**
 * findingTheTruthStepDefinition contains all the test steps for running the scenarios detailed in the findingTheTruth.feature file.
 * Where possible all assertions are performed in the step steps to validate if the step has passed or failed.
 */

public class findingTheTruthStepDefinition {

    Page_FindingTheTruthPage findingTheTruthPage = new Page_FindingTheTruthPage();

    @Given("^I am on the Finding the Truth screen$")
    public void i_am_on_the_Finding_the_Truth_screen(){
        findingTheTruthPage.goToWebPage();
        Assert.assertTrue(findingTheTruthPage.confirmOnHomeScreen());
    }

    @Given("^I select the Start button$")
    public void i_select_the_Start_button() {
        findingTheTruthPage.selectStartButton();
    }

    @When("^I select the case \"([^\"]*)\"$")
    public void i_select_the_case(String crimeCase) {
        findingTheTruthPage.selectCase(crimeCase);
    }

    @Then("^I will be taken to the \"([^\"]*)\" case screen$")
    public void i_will_be_taken_to_the_case_screen(String caseName) {
        Assert.assertTrue("Case screen was not displayed.", findingTheTruthPage.confirmOnCaseScreen(caseName));
    }

    @Given("^I navigate to the 'Guilty or not' screen$")
    public void i_navigate_to_the_Guilty_or_not_screen() {
        findingTheTruthPage.selectJudgeThisButton();
    }

    @When("^I vote \"([^\"]*)\" for my first choice in case one$")
    public void i_vote_for_my_first_choice_in_case_one(String vote) {
        findingTheTruthPage.selectVoteChoice(vote);
        findingTheTruthPage.selectVoteButton();
    }

    @Then("^the \"([^\"]*)\" notification will be displayed$")
    public void the_notification_will_be_displayed(String vote) {
        Assert.assertEquals(vote,findingTheTruthPage.getNotificationHeaderText(vote));
    }

    /**
     * To navigate to the Final Verdict screen, I chose to go through the side menu instead of completing the full crime case.
     * This was to speed up the test, as the focus of the test did not relate to the users choices earlier on in the crime case.
     */
    @When("^I navigate to the Final Verdict screen$")
    public void i_navigate_to_the_Final_Verdict_screen() {
        findingTheTruthPage.selectJudgeThisButton();
        findingTheTruthPage.selectVoteChoice("GUILTY!");
        findingTheTruthPage.selectVoteButton();
        findingTheTruthPage.selectContinueOnGuiltyVoteNotification();
        findingTheTruthPage.openSideMenu();
        findingTheTruthPage.selectFinalVerdictFromSideMenu();
    }

    @When("^I select the DNA case study$")
    public void i_select_the_DNA_case_study() {
        findingTheTruthPage.selectDNACaseStudy();
    }

    @Then("^I will be taken to the DNA case study screen$")
    public void i_will_be_taken_to_the_DNA_case_study_screen() {
       Assert.assertTrue("DNA Case study not displayed.", findingTheTruthPage.confirmOnDNACaseScreen());
    }
}
