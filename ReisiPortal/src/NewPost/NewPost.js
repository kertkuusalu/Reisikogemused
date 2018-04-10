import{HttpClient, json} from 'aurelia-fetch-client';
import { inject } from 'aurelia-framework';

@inject(HttpClient)
export class NewPost{
	
	postData = {}
	postList = []
	
	constructor(){
		this.appName = "reisiPortal"
	}

	addPost() {
		let client = new HttpClient();
		
		
		client.fetch('http://localhost:8080/NewPost/add', {
			'method': "POST",
			'body': json(this.postData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("server saatis" + data.content);
				console.log(document.getElementById("file").size);
			});
		
		console.log("Method excecuted");
		setTimeout(function() {
			window.location.href = "/#/Reisikogemused";
		}, 500);
		
	}
}