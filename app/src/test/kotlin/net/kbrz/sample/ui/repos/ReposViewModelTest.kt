package net.kbrz.sample.ui.repos

import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import net.kbrz.sample.di.component.DaggerAppTestComponent
import net.kbrz.sample.di.module.AppTestModule
import net.kbrz.sample.di.module.view.ReposTestModule
import net.kbrz.sample.ui.repos.row.RepoRowViewModel
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import kotlin.test.expect

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class ReposViewModelTest {

    @Inject
    lateinit var model: ReposViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        DaggerAppTestComponent.builder()
                .appTestModule(AppTestModule())
                .build()
                .add(ReposTestModule())
                .inject(this)
    }

    @Test
    @Throws(Exception::class)
    fun initialize() {
        val mock = spy(model)
        doNothing().whenever(mock).fetchRepos()

        mock.initialize("title")
        expect("title") { mock.title.get() }
        verify(mock).fetchRepos()
    }

    @Test
    @Throws(Exception::class)
    fun fetchRepos() {
        whenever(model.githubApi.getUserRepositories(any())).thenReturn(Single.just(listOf()))

        model.fetchRepos()
        verify(model.githubApi).getUserRepositories("google")
    }

    @Test
    @Throws(Exception::class)
    fun handleReposFetchSuccess() {
        val repos = listOf<RepoRowViewModel>()

        model.handleReposFetchSuccess(repos)
        verify(model.viewAccess).notifyReposChanged()
    }

    @Test
    @Throws(Exception::class)
    fun handleReposFetchError() {
        model.handleReposFetchError(null)
        verify(model.viewAccess).showErrorMessage()
    }

}