package com.payactive.pages.cards;

import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.clickElement;
import static com.payactive.keywords.WebUI.setText;

public class FilterPage extends CommonPage {

    private final By filter = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer-content/div/nb-card/nb-card-body/div[1]/i");

    private final By employeeNameDropdown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[9]/nb-accordion-item-header/nb-icon");

    private final By employeeIdDropdown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[10]/nb-accordion-item-header/nb-icon");

    private final By departmentDropdown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-header/nb-icon");

    private final By departmentMultiSelect = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-body/div/div/ng-multiselect-dropdown");
    private final By cardStatusDropdown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[27]/nb-accordion-item-header/nb-icon");

    private final By cardTypeDropdown = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[28]/nb-accordion-item-header/nb-icon");

    private final By inputEmployeeName = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[9]/nb-accordion-item-body/div/div/input");

    private final By inputEmployeeId = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[10]/nb-accordion-item-body/div/div/input");

    private final By checkboxDepartment = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[15]/nb-accordion-item-body/div/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]");

    private final By checkboxCardStatusSelectAll = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[27]/nb-accordion-item-body/div/div/nb-card-body/div/div[1]/nb-checkbox");

    private final By checkboxCardStatusActivated = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[27]/nb-accordion-item-body/div/div/nb-card-body/div/div[2]/nb-checkbox");

    private final By checkboxCardTypeSelectAll = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[28]/nb-accordion-item-body/div/div/nb-card-body/div/div[1]/nb-checkbox");

    private final By checkboxCarTypeInstantIssue = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[1]/div[1]/nb-accordion/nb-accordion-item[28]/nb-accordion-item-body/div/div/nb-card-body/div/div[3]/nb-checkbox");

    private final By applyBtn = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/div[2]/button");

    private final By resetBtn = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer/div/div/div[2]/div/ngx-app-filters/nb-card/nb-card-header/div/div[4]/button");

    public void clickFilter() {
        clickElement(filter);
    }
    public void clickEmployeeNameDropdown() {
        clickElement(employeeNameDropdown);
    }

    public void clickEmployeeIdDropdown() {
        clickElement(employeeIdDropdown);
    }

    public void clickDepartmentDropdown() {
        clickElement(departmentDropdown);
    }

    public void clickDepartmentMultiSelect() {
        clickElement(departmentMultiSelect);
    }

    public void clickCardStatusDropdown() {
        clickElement(cardStatusDropdown);
    }

    public void clickCheckboxCardStatusSelectAll() {
        clickElement(checkboxCardStatusSelectAll);
    }

    public void clickCheckboxCardStatusActivated() {
        clickElement(checkboxCardStatusActivated);
    }

    public void clickCardTypeDropdown() {
        clickElement(cardTypeDropdown);
    }

    public void clickCheckboxCardTypeSelectAll() {
        clickElement(checkboxCardTypeSelectAll);
    }

    public void clickCheckboxCarTypeInstantIssue() {
        clickElement(checkboxCarTypeInstantIssue);
    }

    public void inputEmployeeName(String text) {
        setText(inputEmployeeName, text);
    }

    public void inputEmployeeId(String text) {
        setText(inputEmployeeId, text);
    }

    public void clickDepartmentCheckbox() {
        clickElement(checkboxDepartment);
    }

    public void clickApplyBtn() {
        clickElement(applyBtn);
    }

    public void clickResetBtn() {
        clickElement(resetBtn);
    }


}
