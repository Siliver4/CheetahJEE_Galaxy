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
    JEE universe is wide, let's try to visit the JPA planet 
</p>

<br>
    
<pre>
<b>Personal Objectives :</b>

  Learning purpose project :
    using IntelliJ IDEA ULTIMATE (for educational use only)
    using EclipseLink as JPA implementation (first time)
    using Database pooling with BoneCP (first time)

  Additionally :
    using Java
    using Servlet, JSP, JSTL, ${EL language}, JDBC, EJB Entity, Basic exception/error handlers
    using Glashfish v5.0.0
    using BoneCP v0.8.0
</pre>

</br>

<h4>Application overview :</h4>

 - Redo of the Cheetah_DAO basic project, but using JPA which reduce the amount of code needed and also enhance the way we can persist our objects in the mysql database. Therefore : "a webuser can view a list of clients (surname, name) or register one through a web form."
 
 - Servlet used as controllers, jsp as views, and finally for the model : a Client class as an EJB Entity, a ClientDaoImpl to provide action on the database (add, list) using an EntityManager and JPQL queries, and using BoneCP to handle database pooling.
 
<h4>Problems encountered :</h4>

 - Having to set the timezone for the BoneCP database url.
   - to set the configuration of BoneCP I used an xml file <a href="https://github.com/Siliver4/CheetahJEE_Galaxy/blob/master/Cheetah_JPA/bonecp-datasource.xml"><b>'boncecp_datasource.xml'</b></a> and the command line <b>'add-resources boncecp_datasource.xml'</b> through the Glassfish admin command line <b>'asadmin.bat'</b>.
   - to reset those values, I had to delete the previous ones using <b>'delete-jdbc-resource jdbc/bonecp_resource'</b> and <b>'delete-jdbc-connection-pool bonecpPool'</b> 
   - to fix the timezone problem I had to use the <b>'serverTimezone=UTC'</b> url parameter as follow :

<pre>
     <b><</b>property name="jdbcUrl" value="jdbc:mysql://localhost:3306/library_jee?serverTimezone=UTC" <b>/></b>
</pre>
      
    
     
