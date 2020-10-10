
@UnitTest @FuctionTest
Feature: calculate postage of parcel

Background:
I want to find out the postage cost and delivery time of parcel

Scenario Outline: calculate the parcel's postage by postcodes
           Given I am on the parcel's postage calculation page: "Postage"
           When I input "<source>" and "<destination>" postcodes
           And I click "Go" button
           Then I should see the start price for "<Express>" and "<Parcel>" Post on new page

Examples:
|source|destination|Express|Parcel|
|2000  |3000       |$11.95 |$8.95 |