package PageObject;

import Utilities.UserAction;
import org.openqa.selenium.By;

public class Calculate_postage_domestic {

    private final By Obj_setSizeWeight_btn = By.cssSelector("[ng-click='switchSizeWeightSectionToInputMode()']");
    private final By Obj_changeSizeWeight_btn = By.cssSelector("[ng-click='switchSizeWeightSectionToEditMode()']");
    private final By Obj_clearSizeWeight_btn = By.cssSelector("[ng-click='clearSizeWeight()']");
    private final By Obj_length_input = By.name("lengthInput");
    private final By Obj_width_input = By.name("widthInput");
    private final By Obj_height_input = By.name("heightInput");
    private final By Obj_weight_input = By.name("weightInput");
    private final By Obj_saveSizeWeight_btn = By.xpath("//button[text()='Set size & weight']");
    private final By Obj_arriveBy_btn = By.xpath("//input[@aria-label='arrive by delivery date']");
    private final By Obj_sendOn_btn = By.xpath("//input[@aria-label='send on delivery date']");
    private final By Obj_setDate_btn = By.cssSelector("[ng-click='switchDeliveryDateSectionToInputMode()']");
    private final By Obj_changeDate_btn = By.cssSelector("[ng-click='switchDeliveryDateSectionToEditMode()']");
    private final By Obj_clearDate_btn = By.cssSelector("[ng-click='clearDeliveryDate()']");
    private final By Obj_date_input = By.name("dateInput");
    private final By Obj_saveDate_btn = By.id("set-date");

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

    public Calculate_postage_domestic setSizeWeight(String length, String width, String height, String weight) {
        action.waitTillVisibility(Obj_setSizeWeight_btn,1).click(Obj_setSizeWeight_btn)
                .waitTillVisibility(Obj_length_input,1).input(Obj_length_input,length)
                .input(Obj_width_input,width).input(Obj_height_input,height).input(Obj_weight_input,weight)
                .click(Obj_saveSizeWeight_btn).waitTillVisibility(Obj_changeSizeWeight_btn,1);
        return this;
    }

    public Calculate_postage_domestic setDate(String mode, String date) {
        action.waitTillVisibility(Obj_setDate_btn,1).click(Obj_setDate_btn)
                .waitTillVisibility(Obj_date_input,1).input(Obj_date_input,date)
                .click(mode.equals("Send")?Obj_sendOn_btn:Obj_arriveBy_btn).click(Obj_saveDate_btn)
                .waitTillVisibility(Obj_changeDate_btn,1);
        return this;
    }




}
