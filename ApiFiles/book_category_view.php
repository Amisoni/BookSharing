<?php
include 'connection.php';
                            $query="SELECT * FROM `book_category`;" ;
                                $result = mysqli_query($conn, $query);
                              
                                    while ($row[] = mysqli_fetch_assoc($result)) {
                                        $json=json_encode($row);
                                        //echo "<tr>."
                                        // ."<td>$row[c_id]</td>"
                                        //. "<td>$row[c_name]</td>"
                                        //. "<td><img src=$row[photo] width='90' height='50'></td>"
                                        //."</tr>";
                                    }
                              
                                echo $json;
    ?>