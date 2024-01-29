package terminalTest;

import baseTest.BaseTest;
import org.junit.Test;

public class TerminalTest extends BaseTest {

    @Test
    public void terminalTest() {
        loginPage
                .openLoginPage()
                .inputLogin("JoseBarronTest")
                .inputPassword("1111")
                .login()
                .checkRedirectToTimeTracking()
                .openTerminal()
                .checkRedirectToTerminal()
                .clockedIn()
                .moveToBreak()
                .clockedOut()
                ;
    }

}
