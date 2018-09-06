Consulta de Documentos Electrónicos de JoeFact
==============================================

Este proyecto es para que puedan consultar sus documentos electrónicos de forma interna en su empresa. 
Esta versión 1.0 esta hecha con Maven, PrimeFaces y corre en Tomcat 8. 



![Consulta Web de Documentos](https://github.com/joedayz/consultajoefact/blob/master/images/consulta-documentos.png)


## Configuración de Bd en Tomcat ##

La configuración a la Bd es realizada en en persistence.xml

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
