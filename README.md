Consulta de Documentos Electrónicos de JoeFact
==============================================

Este proyecto es para que puedan consultar sus documentos electrónicos de forma interna en su empresa. 
Esta versión 1.0 esta hecha con Maven, PrimeFaces y corre en Tomcat 8. 



![Consulta Web de Documentos](https://github.com/joedayz/consultajoefact/blob/master/images/consulta-documentos.png)

## Requisitos ##

  - Java 8
  - [Simple-Email] (https://github.com/codylerum/simple-email), aplicar un __mvn install__



## Configuración de Bd en el Proyecto ##

La configuración a la Bd es realizada en el __persistence.xml__

```
    <persistence-unit name="PedidoPU">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <non-jta-data-source>java:comp/env/jdbc/facturaelectronica</non-jta-data-source>
        <properties>
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />

        </properties>


    </persistence-unit>
```
## Configuración de Bd en el Tomcat ##

En el Tomcat se tiene que agregar dicho Resource en el archivo __server.xml__ del Tomcat mismo (tomcat/conf/server.xml)

```
  <GlobalNamingResources>
    <!-- Editable user database that can also be used by
         UserDatabaseRealm to authenticate users
    -->


        <Resource
            auth="Container"
            driverClassName="com.mysql.jdbc.Driver"
            maxActive="5"
            maxIdle="2"
            maxWait="5000"
            name="jdbc/facturaelectronica"
            username="root"
            password="joedayz"
            testOnBorrow="true"
            type="javax.sql.DataSource"
            url="jdbc:mysql://localhost/facturaelectronica"
            />  
            
       ...     
</GlobalNamingResources>
```
