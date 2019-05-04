<?php
 
require_once 'include/DbHandler.php';
require_once 'include/PassHash.php';
require 'libs/Slim/Slim.php';

\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

/**
 * ----------- METHODS WITHOUT AUTHENTICATION ---------------------------------
 */
 
//layanan yang diakses dengan url
//http://localhost/sepakbola/hasil
$app->get('/hasil', function () {
	$response = array();

	//1) untuk pengaksesan database MySQL
	$db = new DbHandler();
	//2) fetching all hasil
	$result = $db->getHasil();
		//print_r($result);

	//3) bagian dari data pada kembalian ke client
	//error = false, jika data tersedia/koneksi database sukses
	$response["error"] = false;
	$response["hasil"] = array();

	//4) looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["nama"] = utf8_encode($strData["nama"]);
	    $tmp["kelas"] = utf8_encode($strData["kelas"]);
	    $tmp["nim"] = utf8_encode($strData["nim"]);

	    array_push($response["hasil"], $tmp);
	}

	echoRespnse(200, $response);
});



$app->post('/createuser',function(Request $request,Response $response){
		$request_data = $request->getParsedBody();
		$nama = $request_data['nama'];
		$kelas = $request_data['kelas'];
		$nim = $request_data['nim'];
		$db = new DbHandler();            
		$result = $db->createUser($nama,$kelas,$nim);
		if($result == USER_CREATED){
            $message = array(); 
            $message['error'] = false; 
            $message['message'] = 'User created successfully';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(201);
        }
	return $response
					->withHeader('Content-type', 'application/json')
					->withStatus(422);
});
	
	/**
* Verifying required params posted or not
*/
function verifyRequiredParams($required_fields) {
	$error = false;
	$error_fields = "";
	$request_params = array();
	$request_params = $_REQUEST;
	// Handling PUT request params
	if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
	$app = \Slim\Slim::getInstance();
	parse_str($app->request() ->getBody(), $request_params);
	}
	foreach ($required_fields as $field) {
	 
	 if (!isset($request_params[$field]) ||strlen(trim($request_params[$field])) <= 0) {
		 $error = true;
		 $error_fields .= $field . ', ';
		}
	 }
	 if ($error) {
		 // Required field(s) are missing or empty
		 // echo error json and stop the app
		 $response = array();
		 $app = \Slim\Slim::getInstance();
		 $response["error"] = true;
		 $response["message"] = 'Required field(s) ' .
		 substr($error_fields, 0, -2) . ' is missing or empty';
		 echoRespnse(400, $response);
		 $app->stop();
		}
	}
	
	$app->post('/hasilpertanggal', function() use ($app) {
	 // check for required params
	 verifyRequiredParams(array('tanggal'));
	
	$response = array();
	// reading post params
	$tanggal = $app->request->post('tanggal');
	
	$db = new DbHandler();
	
	// fetching all hasil per tanggal
	$result = $db->getHasilPerTanggal($tanggal);
	$response["error"] = false;
	$response["hasilpertanggal"] = array();
	// looping through result and preparing materi array
	
	for ($i=0; $i<count($result); $i++) {
		 $tmp = array();
		 $strData = $result->fetch_assoc();
		 $tmp["idUrut"] = utf8_encode($strData["idUrut"]);
		 $tmp["hari"] = utf8_encode($strData["hari"]);
		 $tmp["tanggal"] = utf8_encode($strData["tanggal"]);
		 $tmp["tim1"] = utf8_encode($strData["tim1"]);
		 $tmp["skor"] = utf8_encode($strData["skor"]);
		 $tmp["tim2"] = utf8_encode($strData["tim2"]);
		 array_push($response["hasilpertanggal"], $tmp);
	}
	echoRespnse(200, $response);
	});

/**
 * Echoing json response to client
 * @param String $status_code Http response code
 * @param Int $response Json response
 * Daftar response
 * 200	OK
 * 201	Created
 * 304	Not Modified
 * 400	Bad Request
 * 401	Unauthorized
 * 403	Forbidden
 * 404	Not Found
 * 422	Unprocessable Entity
 * 500	Internal Server Error
 */
function echoRespnse($status_code, $response) {
    $app = \Slim\Slim::getInstance();
    // Http response code
    $app->status($status_code);

    // setting response content type to json
    $app->contentType('application/json');

	//print_r($response);
    echo json_encode($response);
}


$app->run();
?>