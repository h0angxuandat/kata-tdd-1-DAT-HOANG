# kata-tdd-1 project by Dat Hoang
## This is my very first project with TDD

### The main idea is that:
* Write/update the test follow the requirements and enough to fail the test.
* Update the app enough to pass the test.
* Loop these 2 steps until all the requirements are done.

### I use the clover plugin:
* To check the unit test everytime we build
* I set the test coverate is 100%, it means all the things we have must be covered by unit test
* It will generate for us the report as HTML, XML, PDF ... I choose HTML

### Please clode the repository:
* Use Maven to build this project
* Go to the "\kata-tdd-1-DAT-HOANG\tddkata" and run "mvn install clover2:clover" to build with clover
* The clover's report will be "\kata-tdd-1-DAT-HOANG\tddkata\target\site\clover\index.html"
  * You can check the percent of code which have been covered by unit test
  * Because this is only a small project, it will help us a lot in case the bigger project
* I applied only one Strategy pattern in this project
