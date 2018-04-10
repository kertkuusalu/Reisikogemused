import{HttpClient, json} from 'aurelia-fetch-client'

export class ViewPost{
	postData = {};	
	activate(params) {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/posts/'+params.id)
			.then(response => response.json())
			.then(posts => this.post = posts);
	}
	
}
