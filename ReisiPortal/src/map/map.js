import{HttpClient, json,} from 'aurelia-fetch-client'
import { withGoogleMap, GoogleMap, Marker, InfoWindow } from "aurelia-google-maps";

export class map{
	
	
	
	activate() {
		let client = new HttpClient();
		var varArr = new Array();

			
		client.fetch('http://localhost:8080/posts')
		  .then(response => response.json())
		  .then(data=> this.dataList = data)
		  .then(function(data){
			varArr.push(data);
			console.log(varArr);
			console.log(data);
			let city = data.map(p=> p.city);	
			return fetch('https://maps.googleapis.com/maps/api/geocode/json?address='+city+'&key=AIzaSyAnrbJjGSt3E6da-DMSrH-BwL0cHA_RQ4w');
		})
		.then(function(response){
			return response.json();
		})
		.then(function(res) {
			var google = window.google;
			var map;
			
			var markerData = varArr[0];
			let cities = res;
			let locations = cities.results.map(c=> c.geometry.location);
			var infowindow = new google.maps.InfoWindow();
			
			map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 59.00, lng: 26.00},
          zoom: 4
		});
		for(var i=0;i<locations.length;i++){
			
			var marker = new google.maps.Marker({	
			position: {lat: locations[i].lat, lng:locations[i].lng}, map: map});
			google.maps.event.addListener(marker, 'click', (function(marker, i) {
			return function() {
				infowindow.setContent(`
					<div id="content">
					  <div id="siteNotice"></div>
					  <h1 id="firstHeading" class="firstHeading">${markerData[i].header}</h1>
					  <div id="bodyContent">
			<p><b>Country: ${markerData[i].country}</br>City: ${markerData[i].city}</b></p></br><p style="max-width: 100px;
				text-overflow: ellipsis;
				overflow: hidden;
				white-space: nowrap;"> ${markerData[i].content}</p>
						<p>Read <a href="http://localhost:9000/#/ViewPost?id=${markerData[i].id}">more</a> about this trip.</p>
					  </div>
					</div>`);
				infowindow.open(map, marker);
        }
    })(marker, i));
		}	
	});
}

}
