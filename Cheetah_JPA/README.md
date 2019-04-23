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
    JEE universe is wide, let's try to go across the JPA galaxy
</p>

<br>
    
<pre>
<b>Personal Objectives :</b>

  Learning purpose project :
    using IntelliJ IDEA ULTIMATE (for educational use only)
    using EclipseLink as JPA implementation (first time)

  Additionally :
    using Java
    using Servlet, JSP, JSTL, ${EL language}, JDBC, EJB Entity, Basic exception/error handlers
    using Glashfish v5.0.0
    using BoneCP v0.8.0
</pre>

</br>

<h4>Application overview :</h4>

 - Redo of the Cheetah_DAO basic project, but using JPA which reduce the amount of code needed and also enhance the way we can persist our object in the mysql database. Therefore : "a webuser can view a list of clients (surname, name) or register one through a web form."
 
 - Servlet used as controllers, jsp as views, and finally for the model : a Client class as an EJB Entity, a ClientDaoImpl to provide action on the database (add, list) using JPQL, and using BoneCP to handle database pooling.
 
<h4>Problems encountered :</h4>

 - Having to set the timezone for the BoneCP database url.
   - to set the configuration of BoneCP I used a xml file 'boncecp_datasource.xml' and the command line 'add-resources boncecp_datasource.xml'.
   - to fix the problem I had to use the 'serverTimezone=UTC' url parameter as follow.

<pre>
     <b><</b>property name="jdbcUrl" value="jdbc:mysql://localhost:3306/library_jee?serverTimezone=UTC" <b>/></b>
</pre>
     
     
