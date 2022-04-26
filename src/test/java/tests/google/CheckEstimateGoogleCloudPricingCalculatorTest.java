package tests.google;

import model.VirtualMachine;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.MachineCreator;

public class CheckEstimateGoogleCloudPricingCalculatorTest extends BaseTest {

    @Test
    public void checkEstimateGoogleCloudPricingCalculatorTest() {
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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("VM class: regular"), "Wrong VM class");
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("Instance type: n1-standard-8"), "Wrong instance type");
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("Region: Frankfurt"), "Wrong region");
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("Local SSD: 2x375 GiB"), "Wrong local SSD");
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("Commitment term: 1 Year"), "Wrong commitment term");
        softAssert.assertTrue(googleCalculatorMainPage.getResult().contains("Total Estimated Cost: USD 1,082.77 per 1 month"), "Wrong total estimated cost");
        softAssert.assertAll();
    }
}
