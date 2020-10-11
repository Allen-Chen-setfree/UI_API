
@EndtoEndTest
Feature: calculate postage of parcel

Background:
I want to find out the postage cost and delivery time of parcel

Scenario Outline: calculate the parcel's postage by postcodes
           Given I am on the parcel's postage calculation page: "Postage"
           When I input "<Source>" and "<Destination>" postcodes
           And I click "Go" button
           And I enter the size, weight and delivery date on new page: "<Length>", "<Width>", "<Height>", "<Weight>", "<Mode>","<Date>"
           Then I should see the start price for "<Express>" and "<Parcel>" Post

Examples:
|Source|Destination|Length|Width|Height|Weight|  Mode  |    Date    |Express|Parcel|
|2000  |3000       |  50  |  40 |  30  |  8   |  Send  | 27/11/2020 |$82.50 |$32.50|
|3000  |2000       |  50  |  40 |  30  |  8   | Arrive | 27/11/2020 |$82.50 |$32.50|