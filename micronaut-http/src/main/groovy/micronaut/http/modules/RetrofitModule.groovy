package micronaut.http.modules

import com.micronaut.playground.client.Client
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * This is how we can wireup as many API's as we want!
 */
@Factory
class RetrofitModule {

    @Singleton
    public Client getClient() {
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("http://localhost:8080")
                .build().create(Client.class)
    }

}
