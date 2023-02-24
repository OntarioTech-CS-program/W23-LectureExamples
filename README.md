# W23-LectureExamples

Repository containing demos for the CSCI2020U course during the Winter 2023 term.

by Mariana Shimabukuro

## Module 2 - RestHelloWorld
IntelliJ Project.

Simple REST Web Service using IntelliJ Jakarta + Glassfish. 

Find the base tutorial instructions used for the demo here: https://www.jetbrains.com/help/idea/creating-and-running-your-first-restful-web-service.html#troubleshooting

## Module 3 - demoCustomer (modified during Module 4)
IntelliJ Project.

REST Api to serve customers data from a json file using Domain objects.

This demo is associated with the videos posted on Module 3.

## Module 4a - HTML-example

Basic HTML project directory structure, without IntelliJ.

This folder contains the demo produced in the Module 4 Part 1 and Part 2 videos.

## Module 4b - htmlCustomerClient

HTML client that create a table with the data from a JSON object. It calls the **modified** demoCustomer server API.

This folder contains the demo produced in the Module 4 Part 3 and Part 4 videos.

## Lecture Activity [Feb 6 and 7] - CanvasAnimation
This is the demo activity for creating an HTML Canvas sprite animation.

> This demo was reproduced from the tutorial: https://mr-easy.github.io/2017-06-26-creating-spritesheet-animation-in-html5-canvas-using-javascript/

## Module 5a - ParsingFiles (Server)
Example parsers 
- `ExampleParser` Java class demontrated in week 6 of the lecture.
- `BookParser` Java class demontrated in Module 5 videos part 1 and 2. Created the endpoint `/book` that parses files in the `documents` directory.
  > More about the Gutenberg project: https://www.gutenberg.org/
- `ExampleWriter` Java class to create and write content to a new file in the server-side. Also, created a new endpoint to `/save` using a `POST` request.


## Module 5b - wordcloud (Client)
 - HTML Client that fetches a list of words and their frequencies from the ParsingFiles server; then displays them in a WordCloud visualization using [WordCloud2](https://github.com/timdream/wordcloud2.js). 
 - From Part 3 video, this was modified to include text inputs and send a POST request to the server.

