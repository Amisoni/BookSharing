<?php
include 'connection.php';
header('Content-Type: application/json');
                                $query ="select * from myidea";
                                $result = mysqli_query($conn, $query);
                                if ($result) 
                                {
                                    while ($row[] = mysqli_fetch_assoc($result)) {
                                           $json=json_encode($row);
                                    }
                                }
                                echo $json;
?>