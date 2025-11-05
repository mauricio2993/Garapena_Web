<?php

$servername = "localhost";
$username   = "root";
$password   = "";
$dbname     = "informacion";

if (isset($_POST["nombre"])&& isset($_POST["apellido"])&& isset($_POST["correo"])&& isset($_POST["telefono"])&& isset($_POST["asunto"])) {
    $nombre = $_POST["nombre"];
	$apellido = $_POST["apellido"];
    $email = $_POST["correo"];
    $telefono = $_POST["telefono"];
    $asunto = $_POST["asunto"];
    

} else {
    $nombre = "";
	$apellido = "";
    $email = "";
    $telefono = "";
    $asunto = "";
}



$conn = new mysqli($servername, $username, $password, $dbname);


if ($conn->connect_error) {
    // Finaliza la ejecución del script y muestra el mensaje indicado al usuario
	// PHP cierra la conexión al finalizar el script, $conn se destruye automáticamente
	die("Error de conexión: " . $conn->connect_error);
}

if ($nombre === "" || $apellido === "" || $email === "" || $telefono === "" || $asunto === "" ) {
    // Finaliza la ejecución del script y muestra el mensaje indicado al usuario
	die("El nombre/apellido no puede estar vacío");
}

$sql = "INSERT INTO inscripciones (nombre, apellido, email, telefono, asunto) VALUES ('$nombre', '$apellido' ,'$email' ,'$telefono' ,'$asunto')";

// Ejecutar
if ($conn->query($sql) === TRUE) {
    echo "<h2>¡Registro correcto!</h2>";
    echo "<p>Nombre insertado: " . $nombre . "</p>";
	echo "<p>Apellido insertado: " . $apellido . "</p>";
    echo "<p>Email insertado: " . $email . "</p>";
    echo "<p>Telefono insertado: " . $telefono . "</p>";
    echo "<p>Asunto insertado: " . $asunto . "</p>";
    echo '<p><a href="javascript:history.back()">Volver</a></p>';
} else {
    echo "Error: " . $conn->error;
}


$conn->close();
?>
