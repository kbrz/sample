package net.kbrz.sample.ui.repos.row

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import net.kbrz.sample.model.Repo
import org.junit.Before
import org.junit.Test
import kotlin.test.expect

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoRowViewModelTest {

    lateinit var model: RepoRowViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        model = RepoRowViewModel(buildRepo())
        model.viewAccess = mock()
    }

    @Test
    @Throws(Exception::class)
    fun initialize() {
        expect("repo_name") { model.repoName.get() }
        expect("repo_language") { model.language.get() }
        expect(7) { model.starsCount.get() }
        expect(8) { model.forksCount.get() }
    }

    @Test
    @Throws(Exception::class)
    fun onClick() {
        model.onClick()
        verify(model.viewAccess)!!.openDetails()
    }

    fun buildRepo() = Repo(
            name = "repo_name",
            language = "repo_language",
            stars = 7,
            forks = 8
    )

}