package com.pgs.pages

import geb.Page

class AstaPage extends Page {


    static url = 'https://asta.pgs-soft.com/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.equals("Automated Software Testing Arena") } }

    static content = {

    }


}