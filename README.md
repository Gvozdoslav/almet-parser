Ремизов Ростислав Олегович - вроде продвинутый вариант :)

# Csv file parser

## How does it work?
1. Declare required classes or reuse existing in `com\almettech\firstproject\model\entity`
2. Write the data to be parsed into the `*.csv` file in such format:
* ClassName1
* fieldName1,fieldName2,fieldName3,...
* fieldValue1,fieldValue2,fieldValue3,...
* ...
* fieldValueN, ...
* aboba
* ClassName2
* fieldName1,fieldName2,fieldName3,...
* fieldValue1,fieldValue2,fieldValue3,...
* ...
* fieldValueN, ...
* ...
3. Run the application
4. Execute the `POST` request to the `http://localhost:8080/parse` with form-data content type, containing required `type` and `csvFile` fields (you can find the example of csv file in the root of the project)
5. Unfortunately, only `JAVA` type is supported in this implementation

The default fields delimiter is `,`, you can configure it into the application.properties file