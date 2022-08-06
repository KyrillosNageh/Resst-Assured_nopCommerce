@smoker
Feature: AutoComplete search

  @tag13
  Scenario Outline: Check AutoComplete search with valid Data
    Given Get call to "<url>"
    Then Validate response status code is "<statusCode>"
    Then Validate response body is contain "Asus N551JK-XO076H Laptop"

 
      Examples: 
      | 	url  									 							| statusCode |
      |  searchtermautocomplete?term=laptop   | 		200	 	 | 


    


 			