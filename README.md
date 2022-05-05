# MyPlantTracker
-This is my Java application that holds an SQL database of how often my plants have to be watered. 

-Uses JRE-17, sqlite, Swing, the Java Activation Framework(JAF) and the Java Mail API.

-Necessary libraries - activation.jar, mail.jar, rs2xml.jar, smtp.jar, sqlite-jdbc-3.36.0.3.jar


HOW TO RUN ON YOUR MACHINE
--------------------------


-Install dependencies and reference libraries.


-Create a sqlite database populated with your user login info. Use fields FIRSTNAME, LASTNAME, USERNAME, PASSWORD.


-Change the sqlite file location in login.java and sqliteConnection.java


-Create a sqlite database populated with your plants' names and watering frequencies.


-Change the sqlite file location in baseline.java


-Add email and server info in SendEmail.java, GreetingClient.java and TestClientSocket.java


