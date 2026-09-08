# cse1325

[svg](https://github.com/digbijaypandit46-oss/cse1325/blob/main/README2.md#cse1325)

CSE1325 Coursework

This is some of my CSE1325 coursework. Each P was part of a lesson I completed, with P10 containing the final version of a project I worked on throughout the semester. The previous versions are from P05 onward. P11 was an additional assignment.

## Requirements

The following are recommended for the Java assignments:

- Java JDK 17 or later
- Apache Ant
- Git

Check your installations with:

```bash
java -version
javac -version
ant -version

Note: The direct javac and java commands below do not require Ant. Ant is included because the assignments contain Apache Ant build files and may be required by the course.

P05-10 — MavTutor

svg

The P10 project includes its own README with instructions on how to use the Apache Ant build file and run the program.

Program Overview

svg

MavTutor is a terminal-based program that provides an interactive menu for managing tutors, students, classes, and sessions.

Once the program starts, a menu is displayed in the terminal. Select the corresponding number from the menu to perform different actions, including:

Create tutors, students, classes, and sessions
View tutors, students, classes, and sessions
Review tutors, students, classes, and sessions
Save program information to a separate file

The program also includes a small startup animation in the terminal. Please be patient while the animation finishes and the menu loads.

Running P10

svg

For complete instructions on compiling and running P10, see the README and build.xml files included in the P10 project.

The program can also be compiled and run directly from the terminal:

javac -d target $(find src -name "*.java")
java -cp target mdi.MavTutor
P01 — Hello

svg

Location
P01/full_credit/

The full-credit version contains Hello.java. There is also a bonus version in P01/bonus/.

Compile

From the P01/full_credit directory:

javac Hello.java
Run
java Hello
Complete Command Sequence
cd P01/full_credit
javac Hello.java
java Hello
P02 — ToDo

svg

Location
P02/full_credit/

The full-credit version contains ToDo.java and an Apache Ant build.xml.

ToDo accepts the number of tasks as a command-line argument and then asks for each task and its priority.

Compile with Java

From the P02/full_credit directory:

javac ToDo.java
Run

The program requires one command-line argument specifying the number of tasks.

For example:

java ToDo 5

The program will then prompt for each task and its priority.

Complete Command Sequence
cd P02/full_credit
javac ToDo.java
java ToDo 5
Ant

The included build.xml can also be used to compile the assignment:

ant

To remove generated .class files:

ant clean
P03 — Flash Cards

svg

Location
P03/full_credit/

The full-credit version contains:

Card.java
FlashCard.java
build.xml

FlashCard.java uses Card.java and provides an interactive flash-card program.

Compile with Java

From the P03/full_credit directory:

javac Card.java FlashCard.java
Run
java FlashCard

The program is interactive. Enter the answer to each displayed definition, or type:

stop

to exit.

Complete Command Sequence
cd P03/full_credit
javac Card.java FlashCard.java
java FlashCard
Ant

The included build.xml can be used to compile the assignment:

ant

To clean generated .class files and documentation:

ant clean

Important: FlashCard.java depends on a correctly implemented Card.java. Both files should be compiled together.

P04 — Polygon

svg

Location
P04/full_credit/

The full-credit version contains:

Point.java
Polygon.java
TestPolygon.java
Polygon.puml
build.xml

TestPolygon.java contains the program's test suite for Point and Polygon.

Compile with Java

From the P04/full_credit directory:

javac Point.java Polygon.java TestPolygon.java
Run the Tests
java TestPolygon

A successful run should report:

All tests passed!
Complete Command Sequence
cd P04/full_credit
javac Point.java Polygon.java TestPolygon.java
java TestPolygon
Ant

The included build.xml can also be used to compile the assignment:

ant

To clean generated .class files:

ant clean
P11 — Threaded Prime Search

svg

Location
P11/full_credit/

P11 is an additional assignment focused on finding prime numbers using different approaches, including a threaded implementation.

The full-credit version contains:

ListPrimes.java
Primes.java
ThreadedPrimes.java
qlogger/
build.xml

The P11/bonus/ directory additionally contains PooledPrimes.java.

Compile with Java

Because P11 uses Java packages and multiple source directories, compile all Java files from the P11 directory.

From the repository root:

cd P11
javac -d . $(find . -name "*.java")
Run ListPrimes

ListPrimes requires three arguments:

java full_credit.ListPrimes <begin> <end> <#threads>

The program uses the third argument to select the implementation:

0 — regular Primes
Positive number — ThreadedPrimes
Negative number — PooledPrimes from the bonus implementation

For example, from the P11 directory:

java full_credit.ListPrimes 1 100 4

This searches from 1 through 100 using 4 threads.

To use the regular, non-threaded implementation:

java full_credit.ListPrimes 1 100 0

The bonus pooled implementation can be selected with a negative thread count, for example:

java full_credit.ListPrimes 1 100 -4
Complete Command Sequence
cd P11
javac -d . $(find . -name "*.java")
java full_credit.ListPrimes 1 100 4
Ant

The P11 full-credit directory includes an Apache Ant build file. If you want to use Ant, run it from the P11/full_credit directory according to the targets defined in that build file.

Quick Reference
Assignment	Directory	Main Class	Compile	Run
P01	P01/full_credit	Hello	javac Hello.java	java Hello
P02	P02/full_credit	ToDo	javac ToDo.java	java ToDo 5
P03	P03/full_credit	FlashCard	javac Card.java FlashCard.java	java FlashCard
P04	P04/full_credit	TestPolygon	javac Point.java Polygon.java TestPolygon.java	java TestPolygon
P05-10	P10	mdi.MavTutor	javac -d target $(find src -name "*.java")	java -cp target mdi.MavTutor
P11	P11	full_credit.ListPrimes	javac -d . $(find . -name "*.java")	java full_credit.ListPrimes 1 100 4
Repository Structure

The relevant assignments are organized approximately as follows:

cse1325/
├── P01/
│   ├── full_credit/
│   │   └── Hello.java
│   └── bonus/
│       └── Hello.java
│
├── P02/
│   └── full_credit/
│       ├── ToDo.java
│       └── build.xml
│
├── P03/
│   └── full_credit/
│       ├── Card.java
│       ├── FlashCard.java
│       └── build.xml
│
├── P04/
│   └── full_credit/
│       ├── Point.java
│       ├── Polygon.java
│       ├── TestPolygon.java
│       ├── Polygon.puml
│       └── build.xml
│
├── P05/
├── P06/
├── P07/
├── P08/
├── P09/
├── P10/
│   ├── src/
│   ├── target/
│   ├── dist/
│   ├── build.xml
│   └── README
│
└── P11/
    ├── full_credit/
    │   ├── ListPrimes.java
    │   ├── Primes.java
    │   ├── ThreadedPrimes.java
    │   ├── qlogger/
    │   └── build.xml
    └── bonus/
        ├── PooledPrimes.java
        └── build.xml
Notes
Run each assignment from the directory specified in its section.
Java commands shown above bypass Ant and compile/run the source directly.
When source code is changed, recompile before running the program.
P11's ListPrimes program expects three command-line arguments: the beginning of the range, the end of the range, and the number of threads.
P10 contains the final version of the MavTutor project. Earlier versions of the project are included in P05-P09.
See prof-rice/cse-1325 on GitHub to see the suggested code as well as some added context for this repository.

One thing I deliberately changed from your pasted version is **P05-10 → P10 in the quick-reference directory**, while keeping **P05-10 — MavTutor** as your section title. That makes it clear that P05–P09 are earlier versions leading up to the final P10 project, rather than implying there is literally a `P05-10` directory.
Ad
I am trying to just copy and paste this into github directly I need you to do this in a manner that make this work

Yes. The problem is that my previous response included extra formatting around the Markdown code block, which you should not paste into GitHub.

Below is the raw README content only. Copy everything inside this box and paste it directly into your GitHub README.md.

# cse1325

CSE1325 Coursework

This is some of my CSE1325 coursework. Each P was part of a lesson I completed, with P10 containing the final version of a project I worked on throughout the semester. The previous versions are from P05 onward. P11 was an additional assignment.

## Requirements

The following are recommended for the Java assignments:

- Java JDK 17 or later
- Apache Ant
- Git

Check your installations with:

```bash
java -version
javac -version
ant -version

Note: The direct javac and java commands below do not require Ant. Ant is included because the assignments contain Apache Ant build files and may be required by the course.

P05-10 — MavTutor

The P10 project includes its own README with instructions on how to use the Apache Ant build file and run the program.

Program Overview

MavTutor is a terminal-based program that provides an interactive menu for managing tutors, students, classes, and sessions.

Once the program starts, a menu is displayed in the terminal. Select the corresponding number from the menu to perform different actions, including:

Create tutors, students, classes, and sessions
View tutors, students, classes, and sessions
Review tutors, students, classes, and sessions
Save program information to a separate file

The program also includes a small startup animation in the terminal. Please be patient while the animation finishes and the menu loads.

Running P10

For complete instructions on compiling and running P10, see the README and build.xml files included in the P10 project.

The program can also be compiled and run directly from the terminal:

cd P10
javac -d target $(find src -name "*.java")
java -cp target mdi.MavTutor
P01 — Hello
Location
P01/full_credit/

The full-credit version contains Hello.java. There is also a bonus version in P01/bonus/.

Compile

From the P01/full_credit directory:

javac Hello.java
Run
java Hello
Complete Command Sequence
cd P01/full_credit
javac Hello.java
java Hello
P02 — ToDo
Location
P02/full_credit/

The full-credit version contains ToDo.java and an Apache Ant build.xml.

ToDo accepts the number of tasks as a command-line argument and then asks for each task and its priority.

Compile with Java

From the P02/full_credit directory:

javac ToDo.java
Run

The program requires one command-line argument specifying the number of tasks.

For example:

java ToDo 5

The program will then prompt for each task and its priority.

Complete Command Sequence
cd P02/full_credit
javac ToDo.java
java ToDo 5
Ant

The included build.xml can also be used to compile the assignment:

ant

To remove generated .class files:

ant clean
P03 — Flash Cards
Location
P03/full_credit/

The full-credit version contains:

Card.java
FlashCard.java
build.xml

FlashCard.java uses Card.java and provides an interactive flash-card program.

Compile with Java

From the P03/full_credit directory:

javac Card.java FlashCard.java
Run
java FlashCard

The program is interactive. Enter the answer to each displayed definition, or type:

stop

to exit.

Complete Command Sequence
cd P03/full_credit
javac Card.java FlashCard.java
java FlashCard
Ant

The included build.xml can be used to compile the assignment:

ant

To clean generated .class files and documentation:

ant clean

Important: FlashCard.java depends on a correctly implemented Card.java. Both files should be compiled together.

P04 — Polygon
Location
P04/full_credit/

The full-credit version contains:

Point.java
Polygon.java
TestPolygon.java
Polygon.puml
build.xml

TestPolygon.java contains the program's test suite for Point and Polygon.

Compile with Java

From the P04/full_credit directory:

javac Point.java Polygon.java TestPolygon.java
Run the Tests
java TestPolygon

A successful run should report:

All tests passed!
Complete Command Sequence
cd P04/full_credit
javac Point.java Polygon.java TestPolygon.java
java TestPolygon
Ant

The included build.xml can also be used to compile the assignment:

ant

To clean generated .class files:

ant clean
P11 — Threaded Prime Search
Location
P11/full_credit/

P11 is an additional assignment focused on finding prime numbers using different approaches, including a threaded implementation.

The full-credit version contains:

ListPrimes.java
Primes.java
ThreadedPrimes.java
qlogger/
build.xml

The P11/bonus/ directory additionally contains PooledPrimes.java.

Compile with Java

Because P11 uses Java packages and multiple source directories, compile all Java files from the P11 directory.

From the repository root:

cd P11
javac -d . $(find . -name "*.java")
Run ListPrimes

ListPrimes requires three arguments:

java full_credit.ListPrimes <begin> <end> <#threads>

The program uses the third argument to select the implementation:

0 — regular Primes
Positive number — ThreadedPrimes
Negative number — PooledPrimes from the bonus implementation

For example:

java full_credit.ListPrimes 1 100 4

This searches from 1 through 100 using 4 threads.

To use the regular, non-threaded implementation:

java full_credit.ListPrimes 1 100 0

The bonus pooled implementation can be selected with a negative thread count, for example:

java full_credit.ListPrimes 1 100 -4
Complete Command Sequence
cd P11
javac -d . $(find . -name "*.java")
java full_credit.ListPrimes 1 100 4
Ant

The P11 full-credit directory includes an Apache Ant build file. If you want to use Ant, run it from the P11/full_credit directory according to the targets defined in that build file.

Quick Reference
Assignment	Directory	Main Class	Compile	Run
P01	P01/full_credit	Hello	javac Hello.java	java Hello
P02	P02/full_credit	ToDo	javac ToDo.java	java ToDo 5
P03	P03/full_credit	FlashCard	javac Card.java FlashCard.java	java FlashCard
P04	P04/full_credit	TestPolygon	javac Point.java Polygon.java TestPolygon.java	java TestPolygon
P05-10	P10	mdi.MavTutor	javac -d target $(find src -name "*.java")	java -cp target mdi.MavTutor
P11	P11	full_credit.ListPrimes	javac -d . $(find . -name "*.java")	java full_credit.ListPrimes 1 100 4
Repository Structure

The relevant assignments are organized approximately as follows:

cse1325/
├── P01/
│   ├── full_credit/
│   │   └── Hello.java
│   └── bonus/
│       └── Hello.java
│
├── P02/
│   └── full_credit/
│       ├── ToDo.java
│       └── build.xml
│
├── P03/
│   └── full_credit/
│       ├── Card.java
│       ├── FlashCard.java
│       └── build.xml
│
├── P04/
│   └── full_credit/
│       ├── Point.java
│       ├── Polygon.java
│       ├── TestPolygon.java
│       ├── Polygon.puml
│       └── build.xml
│
├── P05/
├── P06/
├── P07/
├── P08/
├── P09/
├── P10/
│   ├── src/
│   ├── target/
│   ├── dist/
│   ├── build.xml
│   └── README
│
└── P11/
    ├── full_credit/
    │   ├── ListPrimes.java
    │   ├── Primes.java
    │   ├── ThreadedPrimes.java
    │   ├── qlogger/
    │   └── build.xml
    └── bonus/
        ├── PooledPrimes.java
        └── build.xml
Notes
Run each assignment from the directory specified in its section.
Java commands shown above bypass Ant and compile/run the source directly.
When source code is changed, recompile before running the program.
P11's ListPrimes program expects three command-line arguments: the beginning of the range, the end of the range, and the number of threads.
P10 contains the final version of the MavTutor project. Earlier versions of the project are included in P05-P09.
See prof-rice/cse-1325 on GitHub to see the suggested code as well as some added context for this repository.
