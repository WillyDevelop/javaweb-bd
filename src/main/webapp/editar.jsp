<%@ page import="com.willydev.logica.Usuario" %>
<html>
    <head>
        <title>Editar Usuario</title>
    </head>
    <body>
        <% Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar"); %>
        <h1>Datos del Usuario</h1>
        <form action="SvEditar" method="POST">
        <input type="hidden" name="id" value="<%=usu.getId()%>">
            <p><label>DNI: </label> <input type="text" name="dni" value="<%=usu.getDni()%>"></p>
            <p><label>Nombre: </label> <input type="text" name="nombre" value="<%=usu.getNombre()%>"></p>
            <p><label>Apellido: </label> <input type="text" name="apellido" value="<%=usu.getApellido()%>"></p>
            <p><label>Telefono: </label> <input type="text" name="telefono" value="<%=usu.getTelefono()%>"></p>
            <button type="submit" >Guardar</button>
        </form>
        </body>
</html>
