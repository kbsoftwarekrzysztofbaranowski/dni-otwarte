package com.pgs.pages

import geb.Page

class SeleniumPage extends Page {


    static url = 'http://www.seleniumhq.org/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Selenium") } }

    static content = {

    }


}