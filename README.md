# Professors' OfficeHours Search Web Service

Link: (www.professorhours.com)

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
Follow the script


      mysql -uroot -p
      [enter your password]
      
      create database OfficeHours;
      use OfficeHours;
      show tables;

      Create Table Department(
      DepartmentName Varchar(30) Primary Key,
      CollegeName Varchar(30)
      );

      Create Table Faculty(
      FacultyId Int Primary Key,
      FirstName Varchar(30),
      LastName Varchar(30),
      PhoneNumber Varchar(20),
      EmailAddress Varchar(30),
      OfficeLocation Varchar(30),
      DepartmentName Varchar(30),
      PassPhrase Varchar(130),
      Foreign Key (DepartmentName) References Department(DepartmentName)
      );


      Create Table OfficeHour(
      FacultyId Int,
      DayTime Varchar(100),
      Comment Varchar(60),
      Primary Key(FacultyId, DayTime),
      Foreign Key (FacultyId) References Faculty(FacultyId)
      );

      Create Table Section(
      Semester Varchar(30),
      CourseTitle Varchar(30),
      Section Varchar(10),
      FacultyId Int,
      DayTime Varchar(30),
      RoomLocation Varchar(30),
      Primary Key(Semester, CourseTitle, Section, FacultyId),
      Foreign Key (FacultyId) References Faculty(FacultyId)
      );

      Select * From Department;
      Select * From Faculty;
      Select * From OfficeHour;
      Select * From Course;
      Select * From Section;
      
      Set Local_infile = "ON";

      Load Data Local Infile '[$YOUR_PATH]/CS4800Fall19/mysql/Department.txt' Into Table Department;
      Load Data Local Infile '[$YOUR_PATH]/CS4800Fall19/mysql/Faculty.txt' Into Table Faculty;
      Load Data Local Infile '[$YOUR_PATH]/CS4800Fall19/mysql/OfficeHour.txt' Into Table OfficeHour;
      Load Data Local Infile '[$YOUR_PATH]/CS4800Fall19/mysql/Section.txt' Into Table Section;
      
__NOTE:__ There are some issues with load data local infile for some people, we are currently doing more research on that

Alternative way is to import the database using OfficeHours.sql in the mysql folder

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

      - https://localhost:8443/OfficeHours
	
      Note: Tomcat needs to be reconfigured for SSL. Please use this guiline https://dzone.com/articles/setting-ssl-tomcat-5-minutes

      It should look similar to this:
      
      To be updated in the future
