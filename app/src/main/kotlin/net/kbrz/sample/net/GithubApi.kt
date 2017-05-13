package net.kbrz.sample.net

import io.reactivex.Single
import net.kbrz.sample.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */
interface GithubApi {

    @GET("users/{username}/repos")
    fun getUserRepositories(@Path("username") username: String): Single<List<Repo>>

}