# hdm-wim-fallstudie-cep

*Hinweis: Bei diesem Projekt handelt es sich um ein Forschungsprojekt der Hochschule der Medien, Stuttgart.*
*Das Hauptprojekt findet man [hier](https://github.com/Purii/hdm-wim-fallstudie-cep).*

## IntelliJ
[Link zum download](https://www.jetbrains.com/idea/)

1. Import projects from existing sources
2. select pom file
3. import
4. project -> maven -> Generate Sources and Update folders
5. IntelliJ Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler, Set compiler to "Eclipse" and bytecode to 1.8
6. Project Structure -> Project -> set Project Language level to 8
7. Project Structure -> Modules -> Sources -> set Language level to 8

## Installation von Maven
 1. in Windows: Pfad zum JDK unter "JAVA_HOME" als Umgebungsvariable anlegen.
 2. [Download Apache Maven](http://maven.apache.org/download.cgi) und in gewünschten Installationsordner entpacken. (Installation nicht notwendig)
 3. "M2_HOME" und "MAVEN_HOME" mit dem Pfad zum Maven Installationsordner als Umgebungsvariablen anlegen.
 4. Unter Systemvariablen `%M2_HOME%\bin` zum Pfad hinzufügen.
 5. Wenn alles funktioniert hat, sollte man in der Eingabeaufforderung mit `mvn -version` aufrufen können.
 
 

## cep-monitoring
Apache Flink CEP program to monitor rack temperatures in a data center

The Flink program monitors an incoming stream of monitor events from a data center.
The input stream contains events about the temperature and power consumption of the individual racks.
Whenever two temperature events occur within a given interval which exceed a certain threshold temperature, a warning will be raised.
If the system should detect two temperature warnings for the same rack and with increasing temperatures, the system will generate an alert for this rack.

*Note:* This program contains Java 8 lambdas.
 In order to run it directly from within IntelliJ you first have to build the project on the command line using Maven `mvn clean package`.
 
 SOURCE: https://github.com/tillrohrmann/cep-monitoring
 
 ## hdm.wim.CEPSpeechTokens
 Um den Test auszuführen:
 - Sicherstellen, dass in der pom.xml die Zeile ´<mainClass>de.hdm.wim.CEPSpeechTokens</mainClass>´ nicht auskommentiert ist, die andere ´mainClass´ sollte auskommentiert sein
 - Beim Fehler mit dem ´.classpath´ das Projekt mit ´mvn clean package´ bereinigen
 
 

