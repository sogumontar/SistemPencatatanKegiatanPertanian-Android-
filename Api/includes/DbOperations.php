<?php 

	class DbOperations{
		private $con;
		function __construct(){
			require_once dirname(__FILE__) . '/DbConnect.php';
			$db = new DbConnect;
			$this->con=$db->connect();
		}
		public function createUser($nama,$kelas,$nim){
			$stmt = $this->con->prepare("INSERT INTO mahasiswa(nama,kelas,nim) VALUES(?,?,?)");
          $stmt->bind_param("sss",$nama,$kelas,$nim);
          if($stmt->execute()){
            return USER_CREATED;
          }else{
            return USER_FAILURE;  
          }
          return USER_EXISTS;  

		}
		 public function getAllUsers(){
            $stmt = $this->con->prepare("SELECT * FROM mahasiswa;");
            $stmt->execute(); 
            $stmt->bind_result($id, $email, $password, $nama);
            $users = array(); 
            while($stmt->fetch()){ 
                $user = array(); 
                $user['id'] = $id; 
                $user['nama']=$email; 
                $user['kelas'] = $password; 
                $user['nim'] = $nama; 
                array_push($users, $user);
            }             
            return $users; 
        }
    
		
	}