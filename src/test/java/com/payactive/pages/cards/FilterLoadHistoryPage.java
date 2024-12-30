package com.payactive.pages.cards;

import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.clickElement;
import static com.payactive.keywords.WebUI.setText;

public class FilterLoadHistoryPage extends CommonPage {

    private final By resetButton = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/nb-card/nb-card-header/div/div[4]/button");
    private final By applyButton = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[2]/button");

    //Employee Name
    private final By employeeNameDropDown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[9]/nb-accordion-item-header/nb-icon");
    private final By employeeNameInput = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[9]/nb-accordion-item-body/div/div/input");

    //Employee ID
    private final By employeeIdDropDown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[10]/nb-accordion-item-header/nb-icon");
    private final By employeeIdInput = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[10]/nb-accordion-item-body/div/div/input");

    //Department
    private final By departmentDropDown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-header/nb-icon");
    private final By departmentMultiSelect = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-body/div/div/ng-multiselect-dropdown");
    private final By checkboxDepartment = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-body/div/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]");

    //Last 4 digits of Card
    private final By last4DigitsOfCardDropDown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[33]/nb-accordion-item-header/nb-icon");
    private final By last4DigitsOfCardInput = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[33]/nb-accordion-item-body/div/div/input");

    public void clickEmployeeNameDropDown() {
        clickElement(employeeNameDropDown);
    }
    public void setEmployeeNameInput(String employeeName) {
        setText(employeeNameInput, employeeName);
    }

    public void clickEmployeeIdDropDown() {
        clickElement(employeeIdDropDown);
    }
    public void setEmployeeIdInput(String employeeId) {
        setText(employeeIdInput, employeeId);
    }

    public void clickDepartmentDropDown() {
        clickElement(departmentDropDown);
    }

    public void clickDepartmentMultiSelect() {
        clickElement(departmentMultiSelect);
    }

    public void clickCheckboxDepartment() {
        clickElement(checkboxDepartment);
    }

    public void clickLast4DigitsOfCardDropDown() {
        clickElement(last4DigitsOfCardDropDown);
    }
    public void setLast4DigitsOfCardInput(String last4DigitsOfCard) {
        setText(last4DigitsOfCardInput, last4DigitsOfCard);
    }

    public void clickApplyButton() {
        clickElement(applyButton);
    }

    public void clickResetButton() {
        clickElement(resetButton);
    }

}
