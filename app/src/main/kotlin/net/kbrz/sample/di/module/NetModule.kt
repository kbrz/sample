package net.kbrz.sample.di.module

import com.google.gson.*
import dagger.Module
import dagger.Provides
import net.kbrz.sample.BuildConfig
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.rx.SchedulersWrapperImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@Module
@Singleton
class NetModule {

    companion object {
        private val DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
    }

    @Provides
    @Singleton
    internal fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(DateTime::class.java, DateTimeTypeConverter())
                .create()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideSchedulersWrapper(): SchedulersWrapper {
        return SchedulersWrapperImpl()
    }

    internal inner class DateTimeTypeConverter : JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
        override fun serialize(src: DateTime, srcType: Type, context: JsonSerializationContext): JsonElement {
            return JsonPrimitive(DATE_FORMATTER.print(src))
        }

        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): DateTime {
            return DateTime.parse(json.asString, DATE_FORMATTER)
        }
    }

}