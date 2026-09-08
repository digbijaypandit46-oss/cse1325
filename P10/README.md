# CSE1325 P10 — MavTutor

## Requirements

The following software is required to build and run the project:

- Java JDK 17 or later
- Apache Ant
- Git (if cloning the repository)

Verify that Java and Ant are installed:

```bash
java -version
javac -version
ant -version
Running the Program

Navigate to the P10 directory:

cd cse1325/P10
Compile the Source Code

Compile all Java source files into the target directory:

javac -d target $(find src -name "*.java")
Run MavTutor

After compiling, run the program with:

java -cp target mdi.MavTutor

The -cp target option tells Java to look for compiled .class files in the
target directory.

The mdi.MavTutor command specifies the main class used to start the program.

Running After Making Changes

If you modify any source code, recompile the project before running it:

javac -d target $(find src -name "*.java")
java -cp target mdi.MavTutor
Apache Ant

Apache Ant is required for the project and is included in the project through
the build.xml file.

The project can be compiled using:

ant compile

The project also includes targets for generating documentation and creating a
distribution JAR:

ant javadoc
ant dist

To remove generated files:

ant clean

Although Ant is a project requirement, MavTutor can be run directly using the
Java commands above:

javac -d target $(find src -name "*.java")
java -cp target mdi.MavTutor
Quick Start

From the P10 directory:

javac -d target $(find src -name "*.java")
java -cp target mdi.MavTutor
Project Structure
P10/
├── src/
│   ├── mdi/
│   │   └── MavTutor.java
│   ├── menu/
│   ├── people/
│   ├── rating/
│   └── session/
├── target/
└── build.xml
