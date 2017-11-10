package com.pgs

import com.pgs.pages.AstaPage
import com.pgs.pages.CucumberPage
import com.pgs.pages.GebPage
import com.pgs.pages.GooglePage
import com.pgs.pages.PgsPage
import com.pgs.pages.SelenidePage
import com.pgs.pages.SeleniumPage

import com.pgs.stepdefs.utils.Functions
import geb.Browser

import static cucumber.api.groovy.EN.Given

def googlePage = new GooglePage()
def astaPage = new AstaPage()
def pgsPage = new PgsPage()
def cucumberPage = new CucumberPage()
def selenidePage = new SelenidePage()
def seleniumPage = new SelenidePage()
def gebPage = new GebPage()

def functions = new Functions()
def browser = new Browser()

Given(~/^WikiPageIsOpened '(true|false)'$/) { boolean ifRepeat ->
    if (ifRepeat) {
        to GooglePage
        googlePage = page
        googlePage.enterTextIntoSearch("Tutaj pare słów o automatach w pgs")
        sleep(1000)
        googlePage.enterTextIntoSearch("Kilka stron głównych używanych technologii - fajnie to wygląda ;)")
        sleep(1000)
        to SeleniumPage
        seleniumPage = page
        sleep(2000)
        to CucumberPage
        cucumberPage = page
        sleep(2000)
        to SelenidePage
        selenidePage = page
        sleep(2000)
        to GebPage
        gebPage = page
        sleep(2000)
        to GooglePage
        googlePage = page
        googlePage.enterTextIntoSearch("...i wiele innych...")
        sleep(2000)
        googlePage.enterTextIntoSearch("Kilka słów o asta i przejście do właściwego testu...")
        sleep(2000)
        to AstaPage
        astaPage = page
        sleep(2000)
        to GooglePage
        googlePage = page
        googlePage.enterTextIntoSearch("Zachęcenie do odwiedzenia strony pgs")
        sleep(2000)
        to PgsPage
        pgsPage = page
        sleep(2000)
        to GooglePage
        googlePage = page
        googlePage.enterTextIntoSearch("Co wy na to?")
        sleep(2000)
    }
}