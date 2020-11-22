<?php error_reporting (E_ALL ^ E_NOTICE); ?>
<?php
include 'connection.php';

$email = $_POST['email'];
$password = $_POST['password'];

//$query = "UPDATE registration SET password ='".$password."' WHERE email='amisoni1411@gmail.com'";

$query = "UPDATE registration SET password ='".$password."' WHERE email='".$email."'";
echo $query;

$result = mysqli_query($conn, $query);
if (!$result) {
    $flag = FALSE;
  //  die('invalid query');
} else {
//    echo 'record added';
   // echo "<script>";
    //echo "alert('Your Password Is Changed')";
    //echo "</script>";
    //echo "<script>";
    //echo "window.location='https://booksharing2020.000webhostapp.com/include/forgot.php'";
    //echo "</script>";
}
mysqli_close($conn);
?>