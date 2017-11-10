package com.pgs.pages

import geb.Page

class CucumberPage extends Page {


    static url = 'https://cucumber.io/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Cucumber") } }

    static content = {

    }


}