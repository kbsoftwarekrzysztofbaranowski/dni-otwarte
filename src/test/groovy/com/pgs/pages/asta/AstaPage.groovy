package com.pgs.pages.asta

import geb.Page

class AstaPage extends Page {


    static url = 'https://asta.pgs-soft.com/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.equals("Automated Software Testing Arena") } }

    static content = {

        regularAppButton(wait: true) { $('a', href: 'http://testingcup.pgs-soft.com') }

    }

    def clickRegularAppButton() {
        waitFor { regularAppButton.isDisplayed() }
        regularAppButton.click()
    }


}