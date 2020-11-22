<?php
include 'connection.php';
header('Content-Type: application/json');
                                $query = "select c.c_name,r.name,r.mobile_no,d.* from donate_book d left join book_category c on c.c_id=d.r_id left join registration r on r.id=d.r_id";
                            // $query="select * from donate_book" ;
                                $result = mysqli_query($conn, $query);
                                if ($result) 
                                {
                                    while ($row[] = mysqli_fetch_assoc($result)) {
                                           $json=json_encode($row);
                                    }
                                }
                                echo $json;
?>