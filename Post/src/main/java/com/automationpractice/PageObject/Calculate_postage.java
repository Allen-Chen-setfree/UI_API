package com.automationpractice.PageObject;

import com.automationpractice.Utilities.UserAction;
import org.openqa.selenium.By;

public class Calculate_postage {

    private final By Obj_srcPostcode_input = By.id("domFrom_value");
    private final By Obj_dstPostcode_input = By.id("domTo_value");
    private final By Obj_go_button = By.id("submit-domestic");
    private final By Obj_address_list = By.xpath("//*[@ng-repeat='result in results']");

    private final UserAction action;
    public Calculate_postage(UserAction action) {
        this.action = action;
    }

    public Calculate_postage input_src_postcode(String srcPostcode) {
        action.input(Obj_srcPostcode_input,srcPostcode);
        return this;
    }

    public Calculate_postage input_dst_postcode(String dstPostcode) {
        action.input(Obj_dstPostcode_input,dstPostcode);
        return this;
    }

    public Calculate_postage select_address(int index) throws Exception {
        action.waitTillVisibility(Obj_address_list,1);
        action.select(Obj_address_list,index);
        return this;
    }
    public Calculate_postage_domestic click_go_button() {
        action.click(Obj_go_button);
        return new Calculate_postage_domestic(action);
    }

}
