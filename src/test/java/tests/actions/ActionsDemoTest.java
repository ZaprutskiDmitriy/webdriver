package tests.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.google.BaseTest;

import java.util.List;

public class ActionsDemoTest extends BaseTest {

	private static final String DROPPABLE_TEST_URL = "http://jqueryui.com/droppable/";
	private static final String SELECTABLE_TEST_URL = "http://jqueryui.com/selectable/";
	private static final String DRAGGABLE_TEST_URL = "http://jqueryui.com/draggable/";

	@Test(description = "Drag element by XY-ofset coordinates")
	public void draggable() throws InterruptedException {
		// navigating to test url
		driver.get(DRAGGABLE_TEST_URL);

		// switching to frame containing web element
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']//p"));

		// perform drag-and-drop action
		new Actions(driver).dragAndDropBy(draggable, 120, 120).release().build().perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@Test(description = "Drag and drop (element-to-element", dependsOnMethods = "draggable")
	public void droppable() throws InterruptedException {
		// navigating to test url
		driver.get(DROPPABLE_TEST_URL);

		// switching to frame containing web elements
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		// perform drag-and-drop action
		new Actions(driver).dragAndDrop(draggable, droppable).build().perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}

	@Test(description = "Multiple selection", dependsOnMethods = "droppable")
	public void selectMultiple() throws InterruptedException {
		// navigating to test url
		driver.get(SELECTABLE_TEST_URL);

		// switching to frame containing web elements
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		// getting selectable element list and printing it out for test purpose
		List<WebElement> listItems = driver.findElements(By.cssSelector("ol#selectable *"));
		System.out.println("Item list size: " + listItems.size());

		// perform action chain to select multiple items
		new Actions(driver).clickAndHold(listItems.get(0)).moveToElement(listItems.get(4)).moveByOffset(90, 0).release()
				.perform();

		// freeze for a while to demonstrate action result
		Thread.sleep(3000);
	}
}
