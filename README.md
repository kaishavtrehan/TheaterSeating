# TheaterSeating
You run a small theater and each month, you have patrons mail in requests for pre-sale tickets.  You need to process these ticket requests and either tell them where their party will sit or explain to the patron why you can't complete their order.

## Getting Started
To build this project we have divided the project into four sections:-
* Prerequisites
* Functional Requirements
* Sample Test Case
* Installation & Deployment

### Prerequisites
To run this project you need below softwares in your system.
* Java version JDK 1.8 should be installed.
* Apache Maven should be installed.

### Functional Requirements

#### Requirement#1 Full fill patrons requests
You run a small theater and each month, you have patrons mail in requests for pre-sale tickets.  You need to process these ticket requests and either tell them where their party will sit or explain to the patron why you can't complete their order.

You have a few rules that you need to follow when you fill the orders:
1.	Fill as many orders as possible
2.	Put parties as close to the front as possible.
3.	If there are not enough seats available in the theater to handle a party, tell them "Sorry, we can't handle your party."
4.	Each party must sit in a single row in a single section.  If they won't fit, tell them "Call to split party".

Your program must parse a theater layout and a list of ticket requests and produce a list of tickets or explanations in the same order as the requests.
The theater layout is made up of 1 or more rows.  Each row is made up of 1 or more sections separated by a space.

After the theater layout, there is one empty line, followed by 1 or more theater requests.  The theater request is made up of a name followed by a space and the number of requested tickets.

## Sample Test Case
* Sample Input
```
Enter Input
6 6
3 5 5 3
4 6 6 4
2 8 8 2
6 6

Smith 2
Jones 5
Davis 6
Wilson 100
Johnson 3
Williams 4
Brown 8
Miller 12

```
* Sample Output
```
Smith Row 1 Section 1
Jones Row 2 Section 2
Davis Row 1 Section 2
Wilson Sorry, we can't handle your party.
Johnson Row 2 Section 1
Williams Row 1 Section 1
Brown Row 4  Section 2
Miller Call to split party.
```
## Installation & Deployment
* Open your command line.
* Create a new project folder. 
* Clone a Git repository in newly created project folder. Link :- https://github.com/kaishavtrehan/TheaterSeating.git
* If git clone is successful (you will see hidden .git folder) 
* Once you are in above path you should see pom.xml
* Run ``` mvn package ```
* If Build is successful go to next step else solve build problem; Integration Test cases will pass during build.
* Once you have generated a jar file under /target folder, go to next step
* Run ``` java -jar target/barclaysapp-0.0.1-SNAPSHOT.jar ```
* Test with Sample input.
