import{HttpClient, json} from 'aurelia-fetch-client'

export class ViewPost{
	postData = {};	
	commentList = []
	
	activate(params) {
		this.PostId = params.id;
		let client = new HttpClient();

		client.fetch('http://localhost:8080/posts/'+this.PostId)
			.then(response => response.json())
			.then(posts => this.post = posts);
			
		client.fetch('http://localhost:8080/posts/'+this.PostId+'/comments/')
			.then(response => response.json())
			.then(comments => this.commentList = comments);

			return this.postId;
	}
	
	addComment(post_id) {
		let client = new HttpClient();
		client.fetch('http://localhost:8080/posts/'+this.PostId+'/comments/', {
			'method': "POST",
			'body': json(this.commentData)
		})
			.then(response => response.json())
			.then(data => {
				this.comments = data;
			}).then(function(){
				window.location.reload();
			});
		
	}
}
