package com.automationpractice.stepdefs;

import com.automationpractice.Helper.TestContext;
import com.automationpractice.PageObject.Calculate_postage;
import com.automationpractice.PageObject.Calculate_postage_domestic;
import com.automationpractice.Utilities.Entry;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PostageSteps {
    private final TestContext testContext;
    private Calculate_postage calculate_postage;
    private Calculate_postage_domestic domesticPostage;
    private final Entry entry;

    public PostageSteps(TestContext context){
        testContext=context;
        entry=context.getEntry();
    }

    @Given("^I am on the parcel's postage calculation page: \"([^\"]*)\"$")
    public void i_am_on_the_parcel_s_postage_calculation_page(String page) throws Throwable {

        String url = entry.readProperty().get(page);
        calculate_postage = new Calculate_postage(
                entry.init().navToURL(url)
        );

    }

    @When("^I input \"([^\"]*)\" and \"([^\"]*)\" postcodes$")
    public void i_input_and_postcodes(String srcPostcode, String dstPostcode) throws Throwable {
        calculate_postage.input_src_postcode(srcPostcode).select_address(2);
        calculate_postage.input_dst_postcode(dstPostcode).select_address(1);
    }

    @When("^I click \"([^\"]*)\" button$")
    public void i_click_button(String arg1) throws Throwable {
        domesticPostage = calculate_postage.click_go_button();
    }

    @Then("^I should see the start price for \"([^\"]*)\" and \"([^\"]*)\" Post on new page$")
    public void i_should_see_the_start_price_for_and_Post_on_new_page(String expressPrice, String parcelPrice) throws Throwable {
        Assert.assertEquals(expressPrice, domesticPostage.cal_express_startPrice());
        Assert.assertEquals(parcelPrice, domesticPostage.cal_regular_startPrice());
        entry.closeTab();
    }


}
