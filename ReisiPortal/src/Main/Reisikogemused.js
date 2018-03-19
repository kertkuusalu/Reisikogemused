import{HttpClient, json} from 'aurelia-fetch-client'

export class Reisikogemused{
	
	postData = {}
	postList = []
	
	activate() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/posts')
			.then(response => response.json())
			.then(posts => this.postList = posts);
	}
	
	
	
}