package tests.google;

import model.VirtualMachine;
import org.testng.annotations.Test;
import service.MachineCreator;
import utils.WindowsUtils;

import static org.testng.Assert.assertTrue;

public class CheckEstimateGoogleCloudPricingCalculatorViaEmailTest extends BaseTest {

    @Test
    public void checkEstimateGoogleCloudPricingCalculatorViaEmailTest() {
        VirtualMachine testMachine = MachineCreator.createVirtualMachine();
        googleCalculatorMainPage.openPage()
                .selectSection()
                .enterNumberOfInstances(testMachine)
                .selectOperatingSystem(testMachine)
                .selectVirtualMachineClass(testMachine)
                .selectInstanceSeries(testMachine)
                .selectInstanceType(testMachine)
                .selectAddGpuCheckbox()
                .selectGpuType(testMachine)
                .selectNumberOfGpus(testMachine)
                .selectLocalSsd(testMachine)
                .selectDatacenterLocation(testMachine)
                .selectCommittedUsage(testMachine)
                .clickOnAddToEstimateButton();

        WindowsUtils.openNewTab();
        WindowsUtils.switchToNewTab();

        String generatedEmailAddress = yopmailMainPage.openPage()
                .generateEmailAddress()
                .getEmailAddress();

        WindowsUtils.switchToOldTab();

        googleCalculatorMainPage.clickOnEmailEstimateButton()
                .enterEmailInForm(generatedEmailAddress)
                .clickOnSendEmailButton();

        WindowsUtils.switchToNewTab();

        String mailContent = yopmailEmailGeneratorPage.navigateToInboxPage()
                .chooseMail()
                .getMailContent();

        assertTrue(mailContent.contains("USD 1,082.77"), "Total costs do not match");
    }
}
