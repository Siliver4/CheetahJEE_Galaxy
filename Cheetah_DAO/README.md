<h1 align="center">
    <br>
      <a href="https://raw.githubusercontent.com/Siliver4/CheetahJEE_Galaxy/master/assets/img/cheetah_logo.png">
        <img src="assets/img/cheetah_logo.png" alt="CheetahJEE_Galaxy_logo" width="247">
      </a>
    <br>
      CheetahJEE_Galaxy
    <br>
</h1>

<p align="center">
    JEE universe is wide, let's try to visit the DAO planet
</p>

<br>
    
<pre>
<b>Personal Objectives :</b>

  Learning purpose project :
    using IntelliJ IDEA ULTIMATE (for educational use only)
    using DAO design pattern (first time)

  Additionally :
    using Java
    using Servlet, JSP, JSTL, ${EL language}, JDBC, Basic exception/error handlers
    using Glashfish v5.0.0
</pre>

</br>

<h4>Application overview :</h4>

 - Using DAO design pattern, a webuser can view a list of clients (surname, name) or register one through a web form.
 
 - Servlet used as controllers, jsp as views, and finally for the model : a Client class as a bean entity, a ClientDao interface to provide action on the database (add, list), a ClientDaoImpl which is the implementation of the ClientDao class using SQL, and a DaoFactory to generate centralized access points to the database.
 
 - Manual transaction with the database in case of SQLException (commit/rollback).
 
 - Property file containing the database connection infos.
