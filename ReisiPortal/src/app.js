import {RouterConfiguration, NavigationInstruction, Next, Redirect} from 'aurelia-router';
import { PLATFORM } from 'aurelia-pal';
import { inject } from 'aurelia-framework';
import { AuthService } from './auth-service';
@inject(AuthService)

export class App {

constructor(AuthService) {
    this.auth = AuthService;
    this.authenticated = this.auth.isAuthenticated();
    this.auth.authNotifier.on('authChange', authState => {
      this.authenticated = authState.authenticated;
    });
  }
	configureRouter(config, router) {
        this.router = router;
        config.title = 'Reisi application';
        config.map([
          { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
          { route: ['Reisikogemused'],            name: 'Reisikogemused',      moduleId: 'Main/Reisikogemused', nav: true},
          { route: ['Register'], name: 'Register',      moduleId: 'Register/Register', nav: true},
          { route: ['Login'],            name: 'Login',      moduleId: 'Login/Login', nav: true},
		  { route: ['NewPost'],            name: 'NewPost',      moduleId: 'NewPost/NewPost', nav: true},
		  { route: ['ViewPost'],            name: 'ViewPost',      moduleId: 'ViewPost/ViewPost', nav: true},
		  { route: ['posts'],            name: 'posts',      moduleId: 'Posts/posts', nav: true},
		  { route: ['map'],            name: 'map',      moduleId: 'map/map', nav: true},

        ]);
	}
}



