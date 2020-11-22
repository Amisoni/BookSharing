<?php error_reporting (E_ALL ^ E_NOTICE); ?>
<?php
include 'connection.php';
$name = $_POST['name'];
$email = $_POST['email'];
$mobile_no = $_POST['mobile_no'];
$address = $_POST['address'];
$password = $_POST['password'];
$enrollment_no = $_POST['enrollment_no'];
$user_type=$_POST['user_type'];

$valid_formats = array("jpg", "jpeg", "png");
$max_file_size = 1024 * 1024 * 1; //1 MB
$targetPath = "";
$flagFileUpload = FALSE;
if (isset($_FILES["flUserPhoto"]["type"])) {
    $file_extension = strtolower(pathinfo($_FILES["flUserPhoto"]["name"], PATHINFO_EXTENSION));
    //($_FILES["flUserPhoto"]["type"] == "application/pdf") &&
    if (($_FILES["flUserPhoto"]["size"] <= $max_file_size) && in_array($file_extension, $valid_formats)) {
        if ($_FILES["flUserPhoto"]["error"] > 0) {
            $flag = FALSE;
            echo "Please enter valid photo: " . $_FILES["flUserPhoto"]["error"] . "<br/><br/>";
        } else {
            $sourcePath = $_FILES['flUserPhoto']['tmp_name']; // Storing source path of the file in a variable
            $targetPath = '../profilephoto/' . time() . '_' . uniqid() . '.' . $file_extension; // Target path where file is to be stored
            $fileResult = move_uploaded_file($sourcePath, $targetPath); // Moving Uploaded file    
            $flagFileUpload = TRUE;
        }
    }
}
$query = "INSERT INTO registration(name, email, mobile_no, address, photo, password, enrollment_no,user_type) VALUES "
        . "('".$name."','".$email."','".$mobile_no."','".$address."','".$targetPath."','".$password."','".$enrollment_no."','".$user_type."')";
//echo "success";
$result = mysqli_query($conn, $query);
if (!$result) {
    $flag = FALSE;
    die('invalid query');
   
} else {
    echo 'sucess';
}
mysqli_close($conn);
?>
