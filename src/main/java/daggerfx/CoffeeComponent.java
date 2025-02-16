package daggerfx;

import jakarta.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DripCoffeeModule.class})
interface CoffeeComponent {

	FxAppComponent.Builder fxApp();

}
