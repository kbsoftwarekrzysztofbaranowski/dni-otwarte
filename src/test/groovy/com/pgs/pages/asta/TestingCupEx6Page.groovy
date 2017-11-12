package com.pgs.pages.asta

import geb.Page

class TestingCupEx6Page extends Page {


    static url = 'https://testingcup.pgs-soft.com/task_6'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Welcome!") } }

    static content = {
        loginInput(required: false) { $('#LoginForm__username') }
        passwordInput(required: false) { $('#LoginForm__password') }
        loginButton(required: false) { $('#LoginForm_save') }
        logoutButton(required: false) { $('#logout') }
    }

    def enterLogin(login) {
        waitFor { loginInput.isDisplayed() }
        loginInput.value(login)
    }

    def enterPassword(password) {
        waitFor { passwordInput.isDisplayed() }
        passwordInput.value(password)
    }

    def fillLoginData(login, password) {
        enterLogin(login)
        enterPassword(password)
    }

    def clickLoginButton() {
        waitFor { loginButton.isDisplayed() }
        loginButton.click()
    }

    def clickLogoutButton() {
        waitFor { logoutButton.isDisplayed() }
        logoutButton.click()
    }

    boolean ifUserIsLogged() {
        if (logoutButton.isDisplayed())
            return true
        else if (loginButton.isDisplayed())
            return false
    }

    def ensureUserIsLoggedOut() {
        if (logoutButton.isDisplayed()) {
            logoutButton.click()
            waitFor { loginInput.isDisplayed() }
        }
    }

}