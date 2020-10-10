$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Postage_calculation.feature");
formatter.feature({
  "line": 3,
  "name": "calculate postage of parcel",
  "description": "",
  "id": "calculate-postage-of-parcel",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@UnitTest"
    },
    {
      "line": 2,
      "name": "@FuctionTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 8,
  "name": "calculate the parcel\u0027s postage by postcodes",
  "description": "",
  "id": "calculate-postage-of-parcel;calculate-the-parcel\u0027s-postage-by-postcodes",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am on the parcel\u0027s postage calculation page: \"Postage\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I input \"\u003csource\u003e\" and \"\u003cdestination\u003e\" postcodes",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I click \"Go\" button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the start price for \"\u003cExpress\u003e\" and \"\u003cParcel\u003e\" Post on new page",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "calculate-postage-of-parcel;calculate-the-parcel\u0027s-postage-by-postcodes;",
  "rows": [
    {
      "cells": [
        "source",
        "destination",
        "Express",
        "Parcel"
      ],
      "line": 15,
      "id": "calculate-postage-of-parcel;calculate-the-parcel\u0027s-postage-by-postcodes;;1"
    },
    {
      "cells": [
        "2000",
        "3000",
        "$11.95",
        "$8.95"
      ],
      "line": 16,
      "id": "calculate-postage-of-parcel;calculate-the-parcel\u0027s-postage-by-postcodes;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "I want to find out the postage cost and delivery time of parcel",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 16,
  "name": "calculate the parcel\u0027s postage by postcodes",
  "description": "",
  "id": "calculate-postage-of-parcel;calculate-the-parcel\u0027s-postage-by-postcodes;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@UnitTest"
    },
    {
      "line": 2,
      "name": "@FuctionTest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I am on the parcel\u0027s postage calculation page: \"Postage\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I input \"2000\" and \"3000\" postcodes",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I click \"Go\" button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the start price for \"$11.95\" and \"$8.95\" Post on new page",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Postage",
      "offset": 48
    }
  ],
  "location": "PostageSteps.i_am_on_the_parcel_s_postage_calculation_page(String)"
});
formatter.result({
  "duration": 4618934000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2000",
      "offset": 9
    },
    {
      "val": "3000",
      "offset": 20
    }
  ],
  "location": "PostageSteps.i_input_and_postcodes(String,String)"
});
formatter.result({
  "duration": 1996128800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Go",
      "offset": 9
    }
  ],
  "location": "PostageSteps.i_click_button(String)"
});
formatter.result({
  "duration": 69882400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "$11.95",
      "offset": 34
    },
    {
      "val": "$8.95",
      "offset": 47
    }
  ],
  "location": "PostageSteps.i_should_see_the_start_price_for_and_Post_on_new_page(String,String)"
});
formatter.result({
  "duration": 1490688300,
  "status": "passed"
});
});