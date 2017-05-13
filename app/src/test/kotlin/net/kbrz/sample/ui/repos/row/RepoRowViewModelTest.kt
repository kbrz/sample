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
        model = RepoRowViewModel(Repo(name = "test_name"))
        model.viewAccess = mock()
    }

    @Test
    @Throws(Exception::class)
    fun initialize() {
        expect("test_name") { model.repoName.get() }
    }

    @Test
    @Throws(Exception::class)
    fun onClick() {
        model.onClick()
        verify(model.viewAccess)!!.openDetails()
    }

}