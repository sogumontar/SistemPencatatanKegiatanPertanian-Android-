<?php
use Psr\Http\Message\ServerRequestInterface as Request;
use Psr\Http\Message\ResponseInterface as Response;

require '../vendor/autoload.php';
require '../includes/DbConnect.php';
require '../includes/DbOperations.php';


$app = new \Slim\App;

$app->get('/allusers', function(Request $request, Response $response){
    $db = new DbOperations; 
    $users = $db->getAllUsers();
    $response_data = array();
    $response_data['error'] = false; 
    $response_data['users'] = $users; 
    $response->write(json_encode($response_data));
    return $response
    ->withHeader('Content-type', 'application/json')
    ->withStatus(200);  
});
$app->post('/createuser',function(Request $request,Response $response){
		$request_data = $request->getParsedBody();
		$nama = $request_data['nama'];
		$kelas = $request_data['kelas'];
		$nim = $request_data['nim'];


	

		$db = new DBOperations();

		$result = $db->createUser($nama,$kelas,$nim);

		if($result == USER_CREATED){
            $message = array(); 
            $message['error'] = false; 
            $message['message'] = 'User created successfully';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(201);
        }else if($result == USER_FAILURE){
            $message = array(); 
            $message['error'] = true; 
            $message['message'] = 'Some error occurred';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(422);    
        }else if($result == USER_EXISTS){
            $message = array(); 
            $message['error'] = true; 
            $message['message'] = 'User Already Exists';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(422);    
        }
	
	return $response
					->withHeader('Content-type', 'application/json')
					->withStatus(422);
});
function haveEmptyParameters($required_params, $request, $response){
    $error = false; 
    $error_params = '';
    $request_params = $request->getParsedBody(); 
    foreach($required_params as $param){
        if(!isset($request_params[$param]) || strlen($request_params[$param])<=0){
            $error = true; 
            $error_params .= $param . ', ';
        }
    }
    if($error){
        $error_detail = array();
        $error_detail['error'] = true; 
        $error_detail['message'] = 'Required parameters ' . substr($error_params, 0, -2) . ' are missing or empty';
        $response->write(json_encode($error_detail));
    }
    return $error; 
}


$app->run();