<?php
include 'connection.php';
$email = $_POST['email'];
$password = $_POST['password'];
$query = "SELECT  * FROM  registration WHERE email = '" . $email . "'  AND password = '" . $password . "' ";
$result = mysqli_query($conn, $query);
if (mysqli_num_rows($result) > 0) {
    if ($result) {
        echo "<script>";
        echo "window.location='../Admin/index1.php'";
        echo "</script>";
    } 
} else {
 
     echo "password_wrong";
}

mysqli_free_result($result);
mysqli_close($conn);
?>


