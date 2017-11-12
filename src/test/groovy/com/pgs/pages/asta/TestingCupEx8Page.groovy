package com.pgs.pages.asta

import geb.Page

class TestingCupEx8Page extends Page {


    static url = 'https://testingcup.pgs-soft.com/task_6'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Welcome!") } }

    static content = {
        cardTypeSelect(required: true) { $("#task8_form_cardType") }
        cardTypeSelectOption(required: false) { cardTypeSelect.$('option') }
        firstLastNameInput(required: true) { $('#task8_form_name') }
        cardNumberInput(required: true) { $('#task8_form_cardNumber') }
        cvvCodeInput(required: true) { $('#task8_form_cardCvv') }
        monthSelect(required: true) { $('#task8_form_cardInfo_month') }
        monthSelectOption(required: false) { monthSelect.$('option') }
        yearSelect(required: true) { $('#task8_form_cardInfo_year') }
        yearSelectOption(required: false) { yearSelect.$('option') }
        payButton(required: true) { $('button', name: 'task8_form[save]') }
        alertSuccess(required: false) { $('.alert-success') }
    }

    def selectCardTypeByName(cardName) {
        waitFor { cardTypeSelect.isDisplayed() }
        cardTypeSelect.click()
        def index
        for (int i = 0; i < cardTypeSelectOption.size(); i++) {
            if (cardTypeSelectOption[i].text() == cardName) {
                index = i
                break
            }
        }
        cardTypeSelectOption[index].click()
        cardTypeSelect.click()
    }

    def enterFirstLastName(firstLastName) {
        waitFor { firstLastNameInput.isDisplayed() }
        firstLastNameInput.value(firstLastName)
    }

    def enterCardNumber(cardNumber) {
        waitFor { cardNumberInput.isDisplayed() }
        cardNumberInput.value(cardNumber)
    }

    def enterCvvCode(cvv) {
        waitFor { cvvCodeInput.isDisplayed() }
        cvvCodeInput.value(cvv)
    }

    def selectMonthByName(month) {
        waitFor { monthSelect.isDisplayed() }
        monthSelect.click()
        def index
        for (int i = 0; i < monthSelectOption.size(); i++) {
            if (monthSelectOption[i].text() == month) {
                index = i
                break
            }
        }
        monthSelectOption[index].click()
        monthSelect.click()
    }

    def selectYearByName(year) {
        waitFor { yearSelect.isDisplayed() }
        yearSelect.click()
        def index
        for (int i = 0; i < yearSelectOption.size(); i++) {
            if (yearSelectOption[i].text() == year) {
                index = i
                break
            }
        }
        yearSelectOption[index].click()
        yearSelect.click()
    }

    def fillPaymentForm(cardName, firstLAstName, cardNumber, cvv, month, year) {
        selectCardTypeByName(cardName)
        enterFirstLastName(firstLAstName)
        enterCardNumber(cardNumber)
        enterCvvCode(cvv)
        selectMonthByName(month)
        selectYearByName(year)
    }

    def clickPayButton() {
        waitFor { payButton.isDisplayed() }
        payButton.click()
    }

    boolean isPaymentWentWell() {
        waitFor { alertSuccess.isDisplayed() }
        return alertSuccess.text().contains('Zamówienie opłacone')
    }

}