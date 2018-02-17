export class App {

	configureRouter(config, router) {
        this.router = router;
        config.title = 'Reisi application';
        config.map([
          { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
          { route: 'Reisikogemused',            name: 'Reisikogemused',      moduleId: 'Reisikogemused', nav: true}      
        ]);
	}
}
