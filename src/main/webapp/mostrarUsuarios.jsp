<%@ page import="java.util.List" %>
<%@ page import="com.willydev.logica.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Formulario de Prueba</title>
    </head>
    <body>
        <h1>Lista de Usuarios registrados</h1>
        <%
            List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
            int cont = 1;
                for(Usuario usu : listaUsuarios){
        %>
                    <p><b>Usuario N° <%=cont%></b></p>
                    <p>Id: <%=usu.getId()%></p>
                    <p>Dni: <%=usu.getDni()%></p>
                    <p>Nombre: <%=usu.getNombre()%></p>
                    <p>Apellido: <%=usu.getApellido()%></p>
                    <p>Telefono: <%=usu.getTelefono()%></p>
                    <p>---------------------------------</p>
                    <% cont = cont + 1;%>

            <% } %>
    </body>
</html>