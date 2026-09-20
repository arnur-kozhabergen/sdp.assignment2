Assignment 2 Factory Method and Abstract Factory

This is a small Java console program for road and sea delivery. It also creates matching Windows or macOS buttons and checkboxes.

The project uses JDK 17.

Folders
src/main/java/factorymethod - transport classes
src/main/java/abstractfactory - UI classes
src/main/java/app - main program
src/test/java - tests

Build
Run these commands in the project folder

New-Item -ItemType Directory -Force out | Out-Null
javac --release 17 -d out src\main\java\factorymethod\*.java src\main\java\abstractfactory\*.java src\main\java\app\*.java

Run

java -cp out app.Main ROAD WINDOWS

The first value can be ROAD or SEA
The second value can be WINDOWS or MACOS

Example output

Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers solar panels by road to Aktau warehouse
