package pe.paku.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.data.remote.WeatherApi
import pe.paku.weatherapp.data.repository.WeatherRepositoryImpl
import pe.paku.weatherapp.domain.repository.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: WeatherApi) : WeatherRepository {
        return WeatherRepositoryImpl(api = api)
    }

}