# Professors' OfficeHours Search Web Service

Link: TBD

Environment Setup Requirements
--------------------------------

1. [Maven](https://maven.apache.org/download.cgi) 
2. [latest mySQL server](https://www.mysql.com/downloads/)
3. [Tomcat](https://tomcat.apache.org/download-80.cgi)
      - Shortcut
          - For MacOS, use homebrew to install globally in terminal
            ```
            brew install tomcat
            ```
          - Install Tomcat on Windows can be easily done via installer
          - Linux....
4. [Ecilpse](http://www.eclipse.org/)
5. Install the Maven Eclipse Plug-in using the update site (http://www.eclipse.org/m2e/download/)

Setup mySQL server
---------------------



Importing the Project into Eclipse
----------------------------------

1. File->Import->Maven->Existing Maven Projects
2. Select the directory containing the pom.xml file
3. Finish


Running the Project Locally
----------------------------------------
1. On the directory that contain pom.xml
      ```
      mvn package
      ```
2. OfficeHours.war will be built inside tatget folder. Copy OfficeHours.war to where your Tomcat folder is. Put it in webapps folder.
3. To verify:
      - http://localhost:8080/OfficeHours
      
      It should look similar to this:
      ![alt text](https://ibb.co/Hd9CT3f)
