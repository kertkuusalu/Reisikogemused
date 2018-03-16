export class App {

	configureRouter(config, router) {
        this.router = router;
        config.title = 'Reisi application';
        config.map([
          { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
          { route: ['Reisikogemused'],            name: 'Reisikogemused',      moduleId: 'Reisikogemused', nav: true},
          { route: ['Register'], name: 'Register',      moduleId: 'Register', nav: true},
          { route: ['Login'],            name: 'Login',      moduleId: 'Login', nav: true},
		  { route: ['NewPost'],            name: 'NewPost',      moduleId: 'NewPost', nav: true}
        ]);
	}
}
