Technologies:
Java 11,
Apache Maven 3.6.3,
SpringBoot 2.4.2

Instructions:
1. Download .zip file from Git Repository https://github.com/computer-engineer-agf/calculator-api/
2. Unzip file
3. Open IntelliJ Community as an Admin
4. Open Project --> Select Project
5. Build Project
6. Run as Maven, Edit Configuration, Add, apply, Command Line: mvn clean install spring-boot:repackage, Run
7. Open Post-Man and import Calculator.postman_collection.json to test add or ther operation through API. e.g: http://localhost:8080/api/multiply/33/8
8. Open H2 inmemory database to review the operations recorded. http://localhost:8080/h2-ui/ e.g: select * from calculations
