# parabankAutomation
A testing automation framework 

**Technology stack:**
* Selenium
* Java 8
* PageObject model
* TestNG Framework

**System properties:**

System properties data can be changed directly : 
* Baseurl for different env URLs.
* Username and Password.
* Headless to run browser in headless mode "Change value to true"
<br>property file can be found inside: `src/main/resources/system.properties` change then save and run<br>

**Reporting:**

Reports is gereneated in html format using maven Surefire reports containg status of run, Passed and Failed TCs.
<br>Reports file can be found inside: `target/surefire-reports`<br>

**Running testing Suit using maven from cmd:**

* Installing Java Env on machine --> Run in cmd `java -version` for confirmation on setup
* Installing maven Env on machine --> Run in cmd `mvn -version` for confirmation on setup
<br>Open cmd from project's file then run command: `mvn clean test`<br>

