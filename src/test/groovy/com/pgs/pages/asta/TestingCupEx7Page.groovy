package com.pgs.pages.asta

import com.pgs.pages.asta.modules.BasketModule
import com.pgs.pages.asta.modules.ProductCardModule
import geb.Page

class TestingCupEx7Page extends Page {


    static url = 'https://testingcup.pgs-soft.com/task_7'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Welcome!") } }

    static content = {
        productsList { $('.thumbnail').moduleList(ProductCardModule) }
        basketModule{ module BasketModule }

    }
}