package com.pgs.pages.asta.modules

import geb.Module

import static org.hamcrest.CoreMatchers.anyOf
import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class BasketModule extends Module {

    static content = {
        //panel
        productInBasketRow(required: false) { $('.row-in-basket') }
        productInBasketName(required: false) { productInBasketRow.$('.text-on-button-level') }
        productInBasketQuantity(required: false) { productInBasketRow.$('.row-in-basket-quantity') }
        productInBasketDeleteButton(required: false) { productInBasketRow.$('button') }
        summaryQuantity(required: false) { $('.summary-quantity') }
        summaryPrice(required: false) { $('.summary-price') }
        placeToDrop(required: false) { $('.place-to-drop') }
    }

    def removeProductFromBasket(int productNumber) {
        waitFor { productInBasketDeleteButton[productNumber].isDisplayed() }
        productInBasketDeleteButton.click()
    }

    String prodName() {
        return productInBasketName.text().trim()
    }

    List<String> prodNames() {
        return productInBasketName.text().trim()
    }

    def checkIfProductAddedToBasket(productName) {
        waitFor { productInBasketName[0].isDisplayed() }
        assertThat("Product not added to basket", prodName(), containsString(productName))
//        assertThat("Product not added to basket", productsNames(), anyOf((containsString(productName))))
    }

    def checkBasketSummaryPriceCorrectness(price) {
        waitFor { summaryPrice.isDisplayed() }
        assertThat("Wrong basket summary price", summaryPrice.text(), containsString(price))
    }

    def checkBasketSummeryQuantityCorrectness(quantity) {
        waitFor { summaryQuantity.isDisplayed() }
        assertThat("Wrong basket summary quantity", summaryQuantity.text(), containsString(quantity))
    }

}