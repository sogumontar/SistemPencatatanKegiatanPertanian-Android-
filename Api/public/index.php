<?php
use Psr\Http\Message\ServerRequestInterface as Request;
use Psr\Http\Message\ResponseInterface as Response;

require '../vendor/autoload.php';
require '../includes/DbConnect.php';
$app=new \Slim\App;
// $app = new \Slim\App;
// $app->get('/hello/{name}', function (Request $request, Response $response, array $args) {
//     $name = $args['name'];
//     $response->getBody()->write("Hello, $name");
//     $db=new DbConnect;
//     if($db->connect()!=null){
//     	echo "Connect Succes!";
//     }
//     return $response;
// });
$app->post('/createuser',function(Request $request,Response $response){

});
function haveEmptyParameters($required_params, $response){
	$error=false;
	$error_params='';
	$request_params=$_REQUEST;
	foreach ($request_params as $param) {
		if(isset($request[$param]) || strlen($request_params[$param])<=0){
			$error=true;
			$error_params .=$param . ', ';
		}
	}

	if($error){
		$error_detail=array();
		$error_detail['error']=true;
		$error_details['message']='Required parameters ' .substr($error_params,0,-2);
	}
}

$app->run();