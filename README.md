# grading_tool_app
# Developed with Spring boot framework, MySQL Database

Required Applications - IntelliJ/Eclipse IDE,  
                          MySQL Workbench,  
                          PostMan

How to Clone the repository to computer:
  - On GitHub.com, navigate to the main page of the repository
  - Above the list of files, click (down head arrow) Code
  - To clone the repository using HTTPS, under "Clone with HTTPS", click(copy symbol) . To clone the repository using an SSH key, including a certificate issued by your organization's SSH   certificate authority, (copy symbol) click Use SSH, then click . To clone a repository using GitHub CLI, (copy symbol button) click Use GitHub CLI, then click
  - Open Git Bash
  - Change the current working directory to the location where you want the cloned directory.
  - Type git clone, and then paste the URL you copied earlier
  - Then press enter
  - After that git bash complete the cloning


How to set up the project with intelliJ IDEA
- Open the cloned project with intelliJ IDEA. Make sure the computer is connected to the internet
- initalize the Java JDK version
- The intelliJ IDEA downlod and intall all dependencies automatically within few minutes
- When all dependency installation is done next step is to connect to the DB


Connect to the DB
- Install MySQL Workbench on the computer
- There is a appliction.properties file under resources folder in this project
- In that properties file change the following details according to your acoount details of the MySQL account
-     spring.datasource.username
      spring.datasource.password
- Then create a DataBase called gradesDB 

Run
- In the intelliJ IDEA it appears a start button(Triangle heads to right side) after installing all dependencies. Click on that button
- Then open the PostMan application
- To run the API's - All of the API's are implemented with GET method call
- In the PostMan select GET method and copy paste the URL from the StudentController.class and TeacherViewController.class as below

![Screenshot (175)](https://user-images.githubusercontent.com/68672823/148752125-3d8ffb9a-1e21-40c8-b243-43d730142ba0.png)
![image](https://user-images.githubusercontent.com/68672823/148752252-fd5025b1-4325-4515-9286-ae304db7b415.png)
- Then get results by click on the "Send Button"


