Sainsbury’s Software Engineering Test

This task is intended to test your ability to consume a webpage, process some data

and present it.

While there is no specific time limit, we would not expect you to spend any longer

than 2 hours completing this.

We are looking for concise, testable, clean, well commented code and that you have

chosen the right tools for the right job. We will also be looking at your app structure

as a whole.

Requirements

Using best practice coding methods, build a console application that scrapes the

Sainsbury’s grocery site - Ripe Fruits page and returns a JSON array of all the

products on the page.

Example of the table below:

You need to follow each link and get the size (in kb) of the linked HTML (no assets)

and the description to display in the JSON

Each element in the JSON results array should contain ‘title’, ‘unit_price’, ‘size’ and

‘description’ keys corresponding to items in the table.

Additionally, there should be a total field which is a sum of all unit prices on the page.

The link to use is:

http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

Example JSON:

{

"results":[

{

"title":"Sainsbury's Avocado, Ripe & Ready x2",

"size": "90.6kb",

"unit_price": 1.80,

"description": "Great to eat now - refrigerate at home 1 of 5 a day 1

avocado counts as 1 of your 5..."

},

{

"title":"Sainsbury's Avocado, Ripe & Ready x4",

"size": "87kb",

"unit_price": 2.00,

"description": "Great to eat now - refrigerate at home 1 of 5 a day 1

avocado counts as 1 of your 5..."

}

],

"total": 3.80

}

Your code should:

 Include unit and / or behavioural tests.

 Include a README.md file in the root describing how to run the app, how to

run tests and any dependencies needed from the system

 Work on whichever of the following is relevant to the role you are applying for:

PHP5.4+, Python 2.7+, Golang 1.4+, Java 1.7+

You may use a dependency management system (e.g. composer, pip) and as many

dependencies as you like.

Please provide a link to a public VCS (github, etc)