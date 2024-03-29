package studies.example.elements.demoqa;

import org.openqa.selenium.By;

public class ElementsDemoQATable {
    public static final By webTableItem = By.id("item-3");
    // map object using a method
    public static By addNewTableEntry() {
        return By.id("addNewRecordButton");
    }

    public static final By firstNameInput = By.id("firstName");
    public static final By lastNameInput = By.id("lastName");
    public static final By userEmailInput = By.id("userEmail");
    public static final By ageInput = By.id("age");
    public static final By salaryInput = By.id("salary");
    public static final By departmentInput = By.id("department");
    public static final By submitButtonTable = By.xpath("//*[@id=\"submit\"]");
    public static final By table = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]");
    public static final By searchBox = By.id("searchBox");
    public static final By tablecontent = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]");
    public static final By editRowButton = By.id("edit-record-1");
    public static final By registrationModalLastName = By.id("lastName");
    public static final By lastNameFirstRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]");
    public static final By firstRowDeleteButton = By.id("delete-record-1");
    public static final By paginationDropdown = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select");
    public static final By tableRows = By.cssSelector(".rt-table .rt-tbody .rt-tr-group");
    public static final By previousButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]/button");
    public static final By nextButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/button");
    public static final By paginationNumber = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[1]/div/input");
}
