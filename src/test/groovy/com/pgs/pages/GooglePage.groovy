package com.pgs.pages

import geb.Page

class GooglePage extends Page {


    static url = 'https://www.google.pl/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.equals("Google") } }

    static content = {
        searchInput(wait: true, required: true) { $('input', name: 'q') }
    }

    def enterTextIntoSearch(text) {
        waitFor { searchInput.isDisplayed()}
        searchInput.value(text)
    }
}