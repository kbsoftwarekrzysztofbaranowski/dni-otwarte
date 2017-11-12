package com.pgs.pages.asta

import geb.Page

class TestingCupMainPage extends Page {


    static url = 'https://testingcup.pgs-soft.com/'
    static atCheckWaiting = true
    static at = { waitFor { browser.title.contains("Welcome!") } }

    static content = {
        taskList(wait: true){ $('.task-list').find('h2') }
    }

    def clickTaskByNumber(number){
        waitFor {taskList[number].isDisplayed()}
        taskList[number].click()
    }

}