package com.pgs

import com.pgs.pages.asta.AstaPage
import com.pgs.pages.CucumberPage
import com.pgs.pages.GebPage
import com.pgs.pages.GooglePage
import com.pgs.pages.PgsPage
import com.pgs.pages.SelenidePage
import com.pgs.pages.SeleniumPage
import com.pgs.pages.asta.TestingCupEx6Page
import com.pgs.pages.asta.TestingCupEx8Page
import com.pgs.pages.asta.TestingCupMainPage
import com.pgs.stepdefs.utils.Functions
import geb.Browser

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When
import static org.hamcrest.MatcherAssert.assertThat

def googlePage = new GooglePage()
def astaPage = new AstaPage()
def pgsPage = new PgsPage()
def cucumberPage = new CucumberPage()
def selenidePage = new SelenidePage()
def seleniumPage = new SelenidePage()
def gebPage = new GebPage()
def testingCupMainPage = new TestingCupMainPage()
def testingCupEx6Page = new TestingCupEx6Page()
def testingCupEx8Page = new TestingCupEx8Page()

def functions = new Functions()
def browser = new Browser()


Given(~/^Google page is opened$/) { ->
    to GooglePage
    googlePage = page
}

When(~/^Welcome message will be presented by google search$/) { ->
    googlePage.enterTextIntoSearch("Testowanie w pgs to również testy automatyczne...")
    functions.ensurePageCanBeRead(2000)
    googlePage.enterTextIntoSearch("...jesteśmy na bieżąco z najnowszymi technologiami...")
    functions.ensurePageCanBeRead(2000)
}

Then(~/^Most popular ui automation tools pages can be presented$/) { ->
    to SeleniumPage
    seleniumPage = page
    functions.ensurePageCanBeRead(2000)
    to CucumberPage
    cucumberPage = page
    functions.ensurePageCanBeRead(2000)
    to SelenidePage
    selenidePage = page
    functions.ensurePageCanBeRead(2000)
    to GebPage
    gebPage = page
    functions.ensurePageCanBeRead(2000)
    to GooglePage
    googlePage = page
    googlePage.enterTextIntoSearch("...i wiele innych...")
    functions.ensurePageCanBeRead(2000)
}


Given(~/^Asta page is explained$/) { ->
    to GooglePage
    googlePage = page
    googlePage.enterTextIntoSearch("Posiadamy własną platformę... ")
    functions.ensurePageCanBeRead(2000)
    googlePage.enterTextIntoSearch("...do doskonalenia się w testowaniu manualnym...")
    functions.ensurePageCanBeRead(2000)
    googlePage.enterTextIntoSearch("...jak również i automatycznym...")
    functions.ensurePageCanBeRead(2000)
    googlePage.enterTextIntoSearch("...przetestujmy coś...")
    functions.ensurePageCanBeRead(2000)
}

Given(~/^Asta main page is opened$/) { ->
    to AstaPage
    astaPage = page
    functions.ensurePageCanBeRead(2000)
}

Given(~/^User navigate to regular app$/) { ->
    to TestingCupMainPage
    testingCupMainPage = page
    functions.ensurePageCanBeRead(2000)
}

Given(~/^User choose (\d+)th exercise$/) { int taskNumber ->
    testingCupMainPage.clickTaskByNumber(taskNumber - 1)
    if (taskNumber == 6) {
        at TestingCupEx6Page
        testingCupEx6Page = page
    } else if (taskNumber == 8) {
        at TestingCupEx8Page
        testingCupEx8Page = page
    }
    functions.ensurePageCanBeRead(2000)
}

When(~/^User fill login form with data '(.+?)', '(.+?)'$/) { String login, String password ->
    testingCupEx6Page.ensureUserIsLoggedOut()
    testingCupEx6Page.fillLoginData(login, password)
    functions.ensurePageCanBeRead(2000)
}

When(~/^User click 'Login' button$/) { ->
    testingCupEx6Page.clickLoginButton()
}

Then(~/^User is properly logged in$/) { ->
    assertThat("User Login state is incorrect", testingCupEx6Page.ifUserIsLogged() == true)
    functions.ensurePageCanBeRead(2000)
}

Then(~/^User can log out$/) { ->
    testingCupEx6Page.clickLogoutButton()
    assertThat("User Login state is incorrect", testingCupEx6Page.ifUserIsLogged() == false)
    functions.ensurePageCanBeRead(2000)
}

When(~/^User fill payment form with data '(.+?)', '(.+?)', '(.+?)', '(.+?)', '(.+?)', '(.+?)'$/) {
    String cardName,
    String firstLastName,
    String cardNumber,
    String cvv,
    String month,
    String year ->
        testingCupEx8Page.fillPaymentForm(cardName, firstLastName, cardNumber, cvv, month, year)
        functions.ensurePageCanBeRead(2000)
}

When(~/^User click 'Pay' button$/) { ->
    testingCupEx8Page.clickPayButton()
}

Then(~/^Transaction is confirmed$/) { ->
    assertThat("Transaction Not finished successfully", testingCupEx8Page.isPaymentWentWell() == true)
    functions.ensurePageCanBeRead(2000)
}

When(~/^Please visit out web page info will be displayed$/) { ->
    googlePage.enterTextIntoSearch("Zapraszamy na naszą stronę !!!!!!!!!!!!!!!!!!!!!")
    functions.ensurePageCanBeRead(2000)
}

Then(~/^PGS web page will be presented$/) { ->
    to PgsPage
    pgsPage = page
    functions.ensurePageCanBeRead(5000)

}