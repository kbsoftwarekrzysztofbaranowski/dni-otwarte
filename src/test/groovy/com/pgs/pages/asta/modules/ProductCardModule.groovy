package com.pgs.pages.asta.modules

import geb.Module

class ProductCardModule extends Module {


    static content = {
        productImage(required: false) { $('.draggable') }
        productName(required: false) { $('.caption').$('h4') }
        productPrice(required: false) { $('.caption').$('p', 0) }
        productDescription(required: false) { $('.caption').$('p', 1) }
        productQuantityInput(required: false) { $('input') }
        productAddButton(required: false) { $('button') }
    }

    def provideProductQuantity(quantity) {
        waitFor { productQuantityInput.isDisplayed() }
        productQuantityInput.value(quantity)
    }

    def clickAddbutton() {
        waitFor { productAddButton.isDisplayed() }
        productAddButton.click()
    }

    def dragAndDropProductToBasket() {
        browser.interact {
            dragAndDropBy(productImage, 830, 0)
        }
    }
}