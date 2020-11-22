<?php

include 'connection.php';

$name = $_POST['name'];


$valid_formats = array("jpg", "jpeg", "png");
$max_file_size = 1024 * 1024 * 1; //1 MB
$targetPath = "";
$flagFileUpload = FALSE;
if (isset($_FILES["photo"]["type"])) {
    $file_extension = strtolower(pathinfo($_FILES["photo"]["name"], PATHINFO_EXTENSION));
    //($_FILES["flUserPhoto"]["type"] == "application/pdf") &&
    if (($_FILES["photo"]["size"] <= $max_file_size) && in_array($file_extension, $valid_formats)) {
        if ($_FILES["photo"]["error"] > 0) {
            $flag = FALSE;
            echo "Please enter valid photo: " . $_FILES["photo"]["error"] . "<br/><br/>";
        } else {
            $sourcePath = $_FILES['photo']['tmp_name']; // Storing source path of the file in a variable
            $targetPath = '../images/' . time() . '_' . uniqid() . '.' . $file_extension; // Target path where file is to be stored
            $fileResult = move_uploaded_file($sourcePath, $targetPath); // Moving Uploaded file    
            $flagFileUpload = TRUE;
        }
    }
}

$query = "INSERT INTO `book_category`(name,photo) VALUES ('" . $name . "','" . $targetPath . "')";
$result = mysqli_query($conn,$query);
if (!$result) {
    $flag = FALSE;
    die('invalid query');
    print($result);
    
} else {
    echo 'record added';
print($result);
    
}

mysqli_close($conn);
?>


