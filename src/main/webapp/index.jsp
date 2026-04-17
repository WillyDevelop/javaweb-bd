<html>
    <head>
        <title>Formulario de Prueba</title>
    </head>
    <body>
        <h1>Datos del Usuario</h1>
        <form action="SvUsuarios" method="POST">
            <p><label>DNI: </label> <input type="text" name="dni"></p>
            <p><label>Nombre: </label> <input type="text" name="nombre"></p>
            <p><label>Apellido: </label> <input type="text" name="apellido"></p>
            <p><label>Telefono: </label> <input type="text" name="telefono"></p>
            <button type="submit" >Enviar</button>
        </form>

        <h1>Ver lista de Usuario</h1>
        <p>Para ver los datos de los usuarios cargados haga click en el siguiente boton</p>
        <form action="SvUsuarios" method="GET">
            <button type="submit" >Mostrar Usuarios</button>
        </form>

    </body>
</html>
