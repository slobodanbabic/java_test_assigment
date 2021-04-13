package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import setup.PageObject;

public class StudentPage extends PageObject {

	@FindBy(css = "button[aria-label='add']")				   
	private WebElement addStudentButton;

	@FindBy(name = "name")
	private WebElement studentName;

	@FindBy(name = "surname")
	private WebElement studentSurname;

	@FindBy(name = "accountName")
	private WebElement studentAccountName;

	@FindBy(name = "email")
	private WebElement studentEmail;

	@FindBy(name = "bankCardNumber")
	private WebElement studentBankCardNumber;

	@FindBy(css = "button[data-test-id='save']")
	private WebElement saveStudentButton;

	@FindBy(tagName = "h6")
	private WebElement studentHeader;
	
	@FindBy(className = "MuiTablePagination-root")
	private WebElement rowCount;

	public StudentPage(WebDriver driver) {
		super(driver);
	}

	public void newStudent() {		
		//open a form to add a new student
		addStudentButton.click();
		// fill up data
		studentName.sendKeys("John");
		studentSurname.sendKeys("Doe");
		studentAccountName.sendKeys("john_doe");
		studentEmail.sendKeys("johndoe@gmail.com");
		studentBankCardNumber.sendKeys("123456789");
		// save student in DB
		saveStudentButton.click();
	}

	// We will use this boolean for assertion. Check if page is opened
	public boolean isInitialized() {
		return studentHeader.isDisplayed();
	}
	
	// We will use this it for assertion. Check count of student before and after add/delete
	public int getNumberOfStudents() {		
		String str = rowCount.getText().split(" ")[2];
		return Integer.parseInt(str);
	}

}
