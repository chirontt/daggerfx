package daggerfx;

import jakarta.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DripCoffeeModule {

	@Provides
	@Singleton
	Heater provideHeater() {
		return new ElectricHeater();
	}

	@Provides
	Pump providePump(Thermosiphon pump) {
		return pump;
	}

}
