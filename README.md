#README#

# Project goal#
  - To allow development teams to record their daily emotions, and using this data, attempt to correlate the emotional well being of individuals with the success of a project.

# Project Functional Contributions #
1.   User login&Registration, Calendar  - TK
2.   User database and User settings  - Brenton
3.   Project edit, create, delete  - Kaibin yu
4.   Dashboard, Frontend Integration  - Sidney
5.   Project database, database Relation, Project List  - Kangdi Zhang
6.   Emoji themes (url /emojiTheme) - Brenton

# Basic architecture #
  - We use Spring MVC design pattern as domain - server - controller - front view. Domain is used to create tables for database schema through java annotations. Sever is responsible for retrieve data from database. Controller is used for take control of server and map the data to the database table. We use RESTful API to handle POST, GET, PUT, DELETE HTTP requests. Front view represents in .jsp format basically consist of CSS, javascript and HTML.

# Connect to AWS database #
  - We set up an AWS MySQL database to hold the data. Following up with the information for programmers to set up our database. Mysql workbench can be used to check all the data in the database.

# Amazon settings: #
  - Type: MySQL
  - Host name: elec5619grp.ci7jxexv2ij7.ap-southeast-2.rds.amazonaws.com
  - Port: 3306
  - Username: brea8524
  - Password: jbh5N552mMzmR7Ge
  - Schema: elec5619