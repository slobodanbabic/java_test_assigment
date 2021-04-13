package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import setup.FunctionalTest;
import webpages.StudentPage;

public class StudentTest extends FunctionalTest {

	private StudentPage student;

	public StudentTest() {		
		this.student = new StudentPage(driver);
	}

	@BeforeAll
	public static void setup() {
		// load a new page in the browser
		driver.get("http://localhost:3000/student");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void addStudentTest() {
		// number of students before add
		int numberOfStudents = student.getNumberOfStudents();

		// add a new student
		student.newStudent();

		// expected number of students after adding a new student
		int expected = numberOfStudents++;

		// actual number of students
		int actual = student.getNumberOfStudents();		
		assertEquals(expected, actual);
	}
}
