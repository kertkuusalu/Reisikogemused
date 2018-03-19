import{HttpClient, json} from 'aurelia-fetch-client'

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
			});
		
		console.log("Method excecuted")
	}
}