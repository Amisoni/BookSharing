<?php
include 'connection.php';
header('Content-Type: application/json');
                                $query = "select r.name as donarname, rs.name as receivername, re.* from receive_book re 
left join registration r on r.id=re.d_id 
left JOIN registration rs on rs.id=re.r_id";
                                $result = mysqli_query($conn, $query);
                                if ($result) 
                                {
                                    while ($row[] = mysqli_fetch_assoc($result)) {
                                           $json=json_encode($row);
                                    }
                                }
                                echo $json;
?>