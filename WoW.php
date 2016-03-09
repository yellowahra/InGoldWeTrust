<?php
	error_reporting(E_ALL);
	ini_set('display_errors', 1);

	$con = mysqli_connect("localhost", "root", "ingoldwetrust") or die('Could not connect: ' . mysqli_error());
	
    $apikey = "cx9fdp85s76wmhzvxrwc7vskgkvrcj55";
	$country = "en_US";
	
	//temporary servers, until we know what servers to use or how to get all
	$servers = array("Agamaggan", "Thaurissan", "Blackrock");

	foreach ($servers as $dbserver)
	{
		mysqli_query($con, "CREATE DATABASE IF NOT EXISTS " . $dbserver);
	}
	
	foreach ($servers as $server)
	{
		mysqli_select_db($con, $server);
		
		$serverlink = 'https://us.api.battle.net/wow/auction/data/' . $server . '?locale=' . $country . '&apikey=' . $apikey;
		$marketdetails = file_get_contents($serverlink);
		$marketlink = json_decode($marketdetails, true);
		
		$marketurl = $marketlink['files'][0]['url'];
		$marketcontents = file_get_contents($marketurl);
		$market = json_decode($marketcontents, true);

		foreach ($market['auctions'] as $key => $data)
		{
			if ($data['ownerRealm'] == $server)
			{
				$ahitem = $data['item'];
				$ahbid = $data['bid'];
				$ahbuy = $data['buyout'];
				$ahquantity = $data['quantity'];
				
				$ahbid = $ahbid / $ahquantity;
				$ahbuy = $ahbuy / $ahquantity;
				
				$newtable = "CREATE TABLE IF NOT EXISTS item" . $ahitem . " (
					bid INT(7) NOT NULL,
					buy INT(7) NOT NULL,
					quantity INT(4) NOT NULL,
					time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";
				mysqli_query($con, $newtable);

				$sql = "INSERT INTO item" . $ahitem . " (bid, buy, quantity) VALUES('$ahbid', '$ahbuy', '$ahquantity')";
				
				mysqli_query($con, $sql);
			}	
		}
	}
?>