Feature: To consume a webpage, process data and present it in json.

  Scenario: fetch webpage and return json
    When I run application
    Then console contains json with
      | TITLE                                                               | SIZE                       | UNIT_PRICE        | DESCRIPTION                  |
      | "title" : "Sainsbury's Apricot Ripe & Ready x5"                     | "size" : "34.9140625kb"    | "unitPrice" : 3.5 | "description" : "Apricots"   |
      | "title" : "Sainsbury's Avocado Ripe & Ready XL Loose 300g"          | "size" : "35.5068359375kb" | "unitPrice" : 1.5 | "description" : "Avocados"   |
      | "title" : "Sainsbury's Avocado, Ripe & Ready x2"                    | "size" : "39.4931640625kb" | "unitPrice" : 1.8 | "description" : "Avocados"   |
      | "title" : "Sainsbury's Avocados, Ripe & Ready x4"                   | "size" : "35.533203125kb"  | "unitPrice" : 3.2 | "description" : "Avocados"   |
      | "title" : "Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)" | "size" : "35.2109375kb"    | "unitPrice" : 1.5 | "description" : "Conference" |
      | "title" : "Sainsbury's Golden Kiwi x4"                              | "size" : "35.30078125kb"   | "unitPrice" : 1.8 | "description" : "Gold Kiwi"  |
      | "title" : "Sainsbury's Kiwi Fruit, Ripe & Ready x4"                 | "size" : "36.076171875kb"  | "unitPrice" : 1.8 | "description" : "Kiwi"       |
    And console contains total '15.1'

