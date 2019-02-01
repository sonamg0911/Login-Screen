package com.neosoft.login.screen.loginscreen.network

import com.neosoft.login.screen.loginscreen.responses.CalendarListResponse
import com.neosoft.login.screen.loginscreen.responses.EventResourceResponse
import com.neosoft.login.screen.loginscreen.utils.GOOGLE_CALENDAR_BASE_URl
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*
import java.util.concurrent.TimeUnit

interface GoogleCalendarService{

    companion object {

        fun create(): GoogleCalendarService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(60,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS)
                    .build()

            var retrofit=Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient)
                    .baseUrl(GOOGLE_CALENDAR_BASE_URl)
                    .build()

            return retrofit.create(GoogleCalendarService::class.java)

        }
    }

    @GET("users/me/calendarList")
    fun getCalendarList(@Query("calendarId")calendarId: String):Observable<CalendarListResponse>

    @GET("calendars/calendarId/events/")
    fun getCalendarEvent(@Query("calendarId")calendarId:String,@Query("eventId")eventId:String): Observable<EventResourceResponse>

    @POST("calendars/calendarId/events")
    @FormUrlEncoded
    fun insertCalendarEvent(@Field("calendarId")calendarId:String, @Body eventResource:EventResourceResponse ):Observable<EventResourceResponse>
}