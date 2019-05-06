<?php

class DbHandler {
 
    private $conn;
 
    function __construct() {
        require_once dirname(__FILE__) . './DbConnect.php';
        // opening db connection
        $db = new DbConnect();
        $this->conn = $db->connect();
    }
 
	/**
	* Fetching hasil liga mingguan
	*/
	public function getHasil(){
		$stmt = $this->conn->prepare("SELECT nama, kelas, nim FROM mahasiswa");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}
	
	public function getHasilPerTanggal($tanggal) {
	$stmt = $this->conn->prepare("SELECT idUrut, hari, tanggal, tim1, skor, tim2 FROM hasil WHERE tanggal = ? ORDER BY idUrut ASC");
	$stmt->bind_param("s", $tanggal);
	$stmt->execute();
	$tasks = $stmt->get_result();
	$stmt->close();
	
	return $tasks;
	}
        
        public function createUser($nama,$kelas,$nim){
		$stmt = $this->con->prepare("INSERT INTO mahasiswa(nama,kelas,nim) VALUES(?,?,?)");
		$stmt->bind_param("sss",$nama,$kelas,$nim);
		if($nama == '' || $kelas == '' || $nim ==''){
			return USER_FAILURE;  
		}else if($stmt->execute()){
			return USER_CREATED;
		}else{
			return USER_FAILURE;  
		}
		return USER_EXISTS;  

	}

}
 
?>