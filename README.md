# hdm-wim-fallstudie-cep

*Hinweis: Bei diesem Projekt handelt es sich um einen Teil eines Forschungsprojekts der Hochschule der Medien, Stuttgart.*
*Das Hauptprojekt ist [hier](https://github.com/Purii/hdm-wim-fallstudie-cep) zu finden.*

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
 
 

## hdm.wim.CEPSpeechTokens 
 Um den Test auszuführen:
 - Sicherstellen, dass in der pom.xml die Zeile `<mainClass>de.hdm.wim.CEPSpeechTokens</mainClass>` nicht auskommentiert ist, die andere `mainClass` sollte auskommentiert sein
 - Beim Fehler mit dem `.classpath` das Projekt mit `mvn clean package` bereinigen
 
Wenn der folgende Fehler auftritt, muss das package  mit `mvn clean package` neu gebuildet werden.

```
Exception in thread "main" org.apache.flink.api.common.functions.InvalidTypesException: The generic type parameters of 'Map' are missing. 
It seems that your compiler has not stored them into the .class file. 
Currently, only the Eclipse JDT compiler preserves the type information necessary to use the lambdas feature type-safely. 
See the documentation for more information about how to compile jobs containing lambda expressions.
	at org.apache.flink.api.java.typeutils.TypeExtractor.validateLambdaGenericParameter(TypeExtractor.java:1316)
	at org.apache.flink.api.java.typeutils.TypeExtractor.validateLambdaGenericParameters(TypeExtractor.java:1302)
	at org.apache.flink.api.java.typeutils.TypeExtractor.getUnaryOperatorReturnType(TypeExtractor.java:346)
	at org.apache.flink.cep.PatternStream.select(PatternStream.java:64)
	at de.hdm.wim.CEPSpeechTokens.main(CEPSpeechTokens.java:68)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)```
 

