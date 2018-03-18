package com.bhanu.pageObjects.Leads;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bhanu.helper.logger.LoggerHelper;
import com.bhanu.helper.waitHelper.WaitHelper;
import com.bhanu.testBase.DataSource;

public class Leads {

	WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(Leads.class);

	@FindBy(linkText = "Leads")
	WebElement leads;

	@FindBy(xpath = "//img[@title='Create Lead...']")
	WebElement createLeads;

	@FindBy(xpath = "//select[@name='salutationtype']")
	WebElement firstNameType;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='company']")
	WebElement company;

	@FindBy(xpath = "//input[@name='designation']")
	WebElement designation;

	@FindBy(name = "leadsource")
	WebElement leadsource;

	@FindBy(xpath = "//select[@name='industry']")
	WebElement industry;

	@FindBy(name = "annualrevenue")
	WebElement annualrevenue;

	@FindBy(id = "noofemployees")
	WebElement noofemployees;

	@FindBy(xpath = "//*[@id='secondaryemail']")
	WebElement secondaryemail;

	@FindBy(xpath = "//textarea[@name='lane']")
	WebElement street;

	@FindBy(xpath = "//input[@name='code']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@name='country']")
	WebElement country;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "mobile")
	WebElement mobile;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(name = "leadstatus")
	WebElement leadstatus;

	@FindBy(xpath = "//input[@name='assigntype' and @value='T']")
	WebElement assignTo;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement save;

	Select select;

	public Leads(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(leads, DataSource.getExplicitWait());
	}

	public void clickLeads() {
		log.info("clicking on leads in Home page");
		leads.click();
	}

	public void clickOnCreateLeads() {
		log.info("clicking on create leads button");
		createLeads.click();
	}

	public void selectFirstNameType(String type) {
		log.info("selecting first Name type as: " + type);
		select = new Select(firstNameType);
		select.selectByIndex(1);
	}

	public void enterFirstName(String firstName) {
		log.info("entering first name as : " + firstName);
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		log.info("entering lastName as: " + lastName);
		this.lastName.sendKeys(lastName);
	}

	public void enterCompany(String company) {
		log.info("entering company Name as: " + company);
		this.company.sendKeys(company);
	}

	public void enterDesignation(String designation) {
		log.info("enter designation as: " + designation);
		this.designation.sendKeys(designation);
	}

	public void selectLeadSource(String leadSource) {
		log.info("selecting lead source as: " + leadSource);
		select = new Select(this.leadsource);
		select.selectByVisibleText("Employee");
	}

	public void selectIndustry(String industry) {
		log.info("selecting industry as  : " + industry);
		select = new Select(this.industry);
		select.selectByVisibleText("Chemicals");
	}

	public void enterAnnualrevenue(String annualrevenue) {
		log.info("entering annualrevenue as: " + annualrevenue);
		this.annualrevenue.sendKeys(annualrevenue);
	}

	public void enterNoofemployees(String noofemployees) {
		log.info("entering noofemployees as : " + noofemployees);
		this.noofemployees.sendKeys(noofemployees);
	}

	public void enterStreet(String street) {
		log.info("entering street as: " + street);
		this.street.sendKeys(street);
	}

	public void enterPostalCode(String postalCode) {
		log.info("entering postalCode as: " + postalCode);
		this.postalCode.sendKeys(postalCode);
	}

	public void enterCountry(String country) {
		log.info("enter country as : " + country);
		this.country.sendKeys(country);
	}

	public void enterDescription(String description) {
		log.info("enter description as: " + description);
		this.description.sendKeys(description);
	}

	public void enterPhone(String phone) {
		log.info("enter phone number as: " + phone);
		this.phone.sendKeys(phone);
	}

	public void enterMobile(String mobile) {
		log.info("enter mobile number as: " + mobile);
		this.mobile.sendKeys(mobile);
	}

	public void enterEmail(String email) {
		log.info("enter email: " + email);
		this.email.sendKeys(email);
	}

	public void selectLeadStatus(String leadStatus) {
		log.info("selecting leadStatus as: " + leadStatus);
		select = new Select(this.leadstatus);
		select.selectByVisibleText("Contact in Future");
	}

	public void selectAssignedTo() {
		this.assignTo.click();
	}

	public void clickSave() {
		log.info("clicking on save button");
		save.click();
	}

	/**
	 * This method will create Leads
	 * @param type
	 * @param firstName
	 * @param lastName
	 * @param company
	 * @param designation
	 * @param leadSource
	 * @param industry
	 * @param annualrevenue
	 * @param noofemployees
	 * @param street
	 * @param postalCode
	 * @param country
	 * @param description
	 * @param phone
	 * @param mobile
	 * @param email
	 * @param leadStatus
	 */
	public void createLeads(String type, String firstName, String lastName, String company, String designation, String leadSource, String industry, String annualrevenue, String noofemployees, String street, String postalCode, String country,
			String description, String phone, String mobile, String email, String leadStatus) {
		clickLeads();
		clickOnCreateLeads();
		selectFirstNameType(type);
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCompany(company);
		enterDesignation(designation);
		selectLeadSource(leadSource);
		selectIndustry(industry);
		enterAnnualrevenue(annualrevenue);
		enterNoofemployees(noofemployees);
		enterStreet(street);
		enterPostalCode(postalCode);
		enterCountry(country);
		enterDescription(description);
		enterPhone(phone);
		enterMobile(mobile);
		enterEmail(email);
		selectLeadStatus(leadStatus);
		selectAssignedTo();
		clickSave();
	}
}
