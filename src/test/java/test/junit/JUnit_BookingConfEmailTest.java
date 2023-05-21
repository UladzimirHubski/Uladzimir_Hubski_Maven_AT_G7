package test.junit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.booking_pages.BookingAccount_Create;
import pageobjects.mailru_pages.MailRu_Login;
import pageobjects.mailru_pages.MailRu_Mail;
import pageobjects.trashmail_pages.Email_Create;
import steps.FinishTest;
import work.classwork.day19.L4JLogging;

public class JUnit_BookingConfEmailTest {
    private static final Logger LOGGER = Logger.getLogger(L4JLogging.class.getName());
    private final Email_Create createEmail = new Email_Create();
    private final MailRu_Login loginM = new MailRu_Login();
    private final MailRu_Mail mailM = new MailRu_Mail();
    private final BookingAccount_Create accCreate = new BookingAccount_Create();
    private final FinishTest finish = new FinishTest();

    @Before
    public void CreateEmailTest() throws InterruptedException {
        LOGGER.info("Test Started");
        createEmail.OpenLogin();
        createEmail.Input_Name();
        createEmail.Input_PersonalEmail();
        createEmail.Select_Forwards();
        createEmail.Select_Life_Span();
        createEmail.Submit();
        accCreate.OpenLoginPage();
        accCreate.EnterLogin();
        accCreate.EnterPassword();
    }

    @After
    public void exitTest() {
        finish.finishQuitTest();
    }

    @Test
    public void ConfirmEmailTest2() throws InterruptedException {
        loginM.OpenLogin();
        loginM.InputLogin();
        loginM.InputPassword();
        mailM.FindFolder();
        mailM.OpenFolder();
        mailM.FindFirstLetter();
        mailM.OpenFirstLetter();
        mailM.SubmitAccountEmail();
        mailM.CheckConfermedEmail();
    }
}