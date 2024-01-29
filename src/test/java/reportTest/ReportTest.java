package reportTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ReportTest extends BaseTest {

    @Test
    public void verifyReport()  {
        loginPage
                .openLoginPage()
                .inputLogin("JoseBarronTest")
                .inputPassword("1111")
                .login()
                .checkRedirectToTimeTracking()
                .openReports()
                .setReportParameters("Actual working hours","This month", "QA Team")
        ;
    }
}
