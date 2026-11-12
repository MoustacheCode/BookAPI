Feature: Customer API

  Scenario: Retrieve all customers
    When the user requests a list of customers
    Then the API returns a 200 status code


  Scenario: Retrieve a customer by ID
    When the user requests customer with ID 16
    Then the API returns a 200 status code
    And the response contains customer ID 16

  Scenario: Create a new customer
    Given the following customer details:
    | Name           | Address           | Email              | Phone No.     |
    | Mark Poppleton | 17 Imaginary Lane | imaginary@mail.com | 01234 567 890 |
    When the user creates the customer
    Then the API returns a 201 status code
    And the response contains the created customer details

  Scenario: Update an existing customer
    Given the new customer details are:
    | Name               | Address       |
    | Mark Ian Poppleton | 25 Madeup Ave |
    When the user updates customer with ID 16
    Then the API returns a 200 status code
    And the respose contains the updated customer details

  Scenario: Delete an existing customer
    When the user deletes the customer with ID 16
    Then the API returns a 200 status code
    When then the user requests customer with ID 16
    Then the API returns a 404 status code
