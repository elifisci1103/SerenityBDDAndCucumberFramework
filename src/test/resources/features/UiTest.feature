Feature: User adds product to cart from the relevant category on the shopping page
  @ui
  Scenario: The user should be able to add the desired product to their cart from the relevant category

    Given The user goes to the "automationPracticeUrl"
    And  Search by typing a "Dress" in the search box.
    Then Sort products from A to Z
    And  Clicks on the "3rd" product
    And  Selects the "M" size of the product
    And  Adds 2 items to the cart
    And  Verifies the products is successfully added to the cart
    And  Close Browser
