
@FunctionTest
Feature: calculate postage of parcel

Background:
I want to find out the postage cost and delivery time of parcel

Scenario Outline: calculate the parcel's postage by postcodes
           Given I am on the parcel's postage calculation page: "Postage"
           When I input "<Source>" and "<Destination>" postcodes
           And I click "Go" button
           Then I should see the start price for "<Express>" and "<Parcel>" Post on new page

Examples:
|Source|Destination|Express|Parcel|
|2000  |3000       |$11.95 |$8.95 |
|3000  |2000       |$11.95 |$8.95 |