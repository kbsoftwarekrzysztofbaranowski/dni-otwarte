package com.pgs.pages

import geb.Page

class SelenidePage extends Page {


    static url = 'http://selenide.org/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Selenide") } }

    static content = {

    }


}