<?php 
 
 //Importing database 
 require_once('../koneksi.php');
 if(isset($_GET['nis'])) {
	 $nis = $_GET['nis'];
 }
 $result = array();
 $query = mysqli_query($con, "SELECT * FROM catat ORDER BY nis DESC");
 while ($row = mysqli_fetch_assoc($query)){
	 $result[] = $row;
 }
 echo json_encode(array('result'=>$result));
  
 ?>