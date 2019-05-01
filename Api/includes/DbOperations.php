<?php 

	class DbOperations{
		prinvate $con;
		function __construct(){
			require_once dirname(__FILE__) . '/DbConnect.php';
			$db = new DbConnect;
			$this->con=$db->connect();
		}
		public function createUser($nama,$kelas,$nim){
			$statement=$this->con->prepare("INSERT INTO mahasiswa(nama,kelas,nim),VALUES ('hend','d4Ti','asd')");
			if($statement->execute()){
				return USER_CREATED;
			}else{
				return USER_FAILURE;
			}

		}
		return USER_EXISTS;
	}