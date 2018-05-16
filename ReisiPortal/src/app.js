import {RouterConfiguration, NavigationInstruction, Next, Redirect} from 'aurelia-router';

export class App {

	configureRouter(config, router) {
        this.router = router;
        config.title = 'Reisi application';
        config.map([
          { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
          { route: ['Reisikogemused'],            name: 'Reisikogemused',      moduleId: 'Main/Reisikogemused', nav: true},
		  { route: ['NewPost'],            name: 'NewPost',      moduleId: 'NewPost/NewPost', nav: true},
		  { route: ['ViewPost'],            name: 'ViewPost',      moduleId: 'ViewPost/ViewPost', nav: true},
		  { route: ['posts'],            name: 'posts',      moduleId: 'Posts/posts', nav: true},
		  { route: ['map'],            name: 'map',      moduleId: 'map/map', nav: true},

        ]);
	}
}



