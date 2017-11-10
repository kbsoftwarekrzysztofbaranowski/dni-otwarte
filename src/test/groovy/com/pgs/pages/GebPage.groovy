package com.pgs.pages

import geb.Page

class GebPage extends Page {


    static url = 'http://www.gebish.org/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Geb") } }

    static content = {

    }


}