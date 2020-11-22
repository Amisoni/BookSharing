<?php error_reporting (E_ALL ^ E_NOTICE); ?>
<?php
include 'connection.php';
echo '<pre>';
print_r($_POST);
$book_name = $_POST['book_name'];
$author_name = $_POST['author_name'];
$publisher_name = $_POST['publisher_name'];
$edition = $_POST['edition'];
$book_detail = $_POST['book_detail'];
$book_category=$_POST['book_category'];
$r_id=$_POST['r_id'];

//echo $image = $_POST["name"];

//		$name = $_POST["name"];
		$img_url = $_POST["img_url"];
		//$sql = "insert into imageinfo(name, url) values('$name', '$img_url')";
	echo	$upload_path = $img_url;
 
$query = "INSERT INTO donate_book(book_name,author_name,publisher_name,edition,photo,book_detail,book_category,r_id) "
          . "VALUES ('".$book_name."','".$author_name."','".$publisher_name."','".$edition."','".$upload_path."','".$book_detail."','".$book_category."','32')";

//   $query = "INSERT INTO donate_book (book_name,author_name,publisher_name,edition,photo,book_detail,book_category,r_id) "
//           . "VALUES ('java','xyz','pqr','1st','cbalagu.jpg','javabook','programming','33')";
        
echo $query;
$result = mysqli_query($conn, $query);
if (!$result) {
    $flag = FALSE;
    die('Invallid Data');
    //echo json_encode(array('response' => 'Image Upload Failed'));
   
} else {
    echo 'success';
    //file_put_contents($upload_path, base64_decode($image));
		//	echo json_encode(array('response' => 'Image Upload Successfully'));
}
// header('Content-Type: application/json');
//     echo json_encode($result);

mysqli_close($conn);
?>
