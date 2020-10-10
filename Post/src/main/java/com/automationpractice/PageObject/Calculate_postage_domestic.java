package com.automationpractice.PageObject;

import com.automationpractice.Utilities.UserAction;
import org.openqa.selenium.By;

public class Calculate_postage_domestic {

    private final By Obj_expressPrice_info = By.cssSelector(
            ".postage-service__header--domestic_parcel-express .postage-service__section__price.ng-binding"
    );
    private final By Obj_regularPrice_info = By.cssSelector(
            ".postage-service__header--domestic_parcel-regular .postage-service__section__price.ng-binding"
    );

    private final UserAction action;
    public Calculate_postage_domestic(UserAction action) {
        this.action = action;
    }

    public String cal_express_startPrice() {
        action.waitTillVisibility(Obj_expressPrice_info, 3);
        return action.getText(Obj_expressPrice_info);
    }

    public String cal_regular_startPrice() {
        action.waitTillVisibility(Obj_regularPrice_info, 3);
        return action.getText(Obj_regularPrice_info);
    }




}
