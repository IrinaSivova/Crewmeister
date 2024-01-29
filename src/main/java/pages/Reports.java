package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reports extends ParentPage {

    @FindBy (xpath = ".//select[@id='page-time-tracking-reports-select-report-type']") protected WebElement timeTypeField;

    @FindBy (xpath = ".//span[@class='_1u7ws2t5 ']") protected WebElement fromToPeriod;

    @FindBy (xpath = ".//span[@class='_ghsr7z ']") protected WebElement teamNameDropdown;

    @FindBy (xpath = ".//div[contains(text(), 'Refresh data')]") protected WebElement buttonRefreshData;

    @FindBy (xpath = ".//span[contains(text(), 'Download')]") protected WebElement buttonDownload;

    @FindBy (xpath =".//span[@class='MuiButtonBase-root MuiIconButton-root jss78 MuiCheckbox-root jss77 MuiCheckbox-colorSecondary _dqb31n jss79 Mui-checked MuiIconButton-colorSecondary']//input[@class = 'jss81']") protected WebElement checkboxEmployee;

    @FindBy (xpath = ".//div[contains (text(), 'Download excel file')]") private WebElement buttonDownloadExcel;

    @FindBy (xpath = ".//select[@id='page-time-tracking-reports-filter-for-employees']") private WebElement periodicallyDropdown;

    @FindBy (xpath = ".//select [@id='page-time-tracking-reports-table-header-select']") private WebElement employeeDropdown;

    @FindBy(xpath = ".//span[@class='MuiButtonBase-root MuiIconButton-root jss39 MuiCheckbox-root jss38 MuiCheckbox-colorSecondary _bfu4ae jss40 Mui-checked MuiIconButton-colorSecondary']") private WebElement selectAllCheckbox;

    @FindBy (xpath = ".//span[@class='MuiButtonBase-root MuiIconButton-root jss78 MuiCheckbox-root jss77 MuiCheckbox-colorSecondary _dqb31n jss79 Mui-checked MuiIconButton-colorSecondary']") private WebElement testEmployeeCheckbox;

    @FindBy (xpath = ".//td[@class='_havbx2m _10w4ep2u undefined']//span[@class='_1fcg26f']") private WebElement totalSumHours;
    private String reportPeriod = ".//li[contains (text(), '%s')]";

    private String targetTeamName = ".//span[contains (text(), '%s')]";
    public Reports(WebDriver webDriver) {
        super(webDriver);
    }

    public Reports setReportParameters(String timeType, String periodDate, String teamName){
        selectTextInDropDown(timeTypeField, timeType);
        clickElement(fromToPeriod);
        clickElement(String.format(reportPeriod,periodDate));
        clickElement(teamNameDropdown);
        clickElement(String.format(targetTeamName,teamName));
        clickElement(teamNameDropdown);
        selectValueInDropdown(periodicallyDropdown, "week");
        selectValueInDropdown(employeeDropdown, "userId--enabled");
        //uncheckCheckbox(selectAllCheckbox);
        //checkCheckbox(testEmployeeCheckbox);
        clickElement(buttonRefreshData);
        clickElement(buttonDownload);
        clickElement(buttonDownloadExcel);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;

    }

}
