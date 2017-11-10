package com.pgs.pages

import geb.Page

class PgsPage extends Page {


    static url = 'https://www.pgs-soft.com/pl/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("PGS Software") } }

    static content = {

    }


}