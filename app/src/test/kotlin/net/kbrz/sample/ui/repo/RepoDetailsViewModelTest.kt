package net.kbrz.sample.ui.repo

import net.kbrz.sample.di.component.DaggerAppTestComponent
import net.kbrz.sample.di.module.AppTestModule
import net.kbrz.sample.di.module.view.RepoDetailsTestModule
import net.kbrz.sample.model.Owner
import net.kbrz.sample.model.Repo
import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import kotlin.test.expect

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoDetailsViewModelTest {

    @Inject
    lateinit var model: RepoDetailsViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        DaggerAppTestComponent.builder()
                .appTestModule(AppTestModule())
                .build()
                .add(RepoDetailsTestModule())
                .inject(this)
    }

    @Test
    @Throws(Exception::class)
    fun initialize() {
        model.initialize("title", createRepo())
        expect("title") { model.title.get() }
        expect("name") { model.name.get() }
        expect("description") { model.description.get() }
        expect("owner") { model.author.get() }
        expect("13.05.2017") { model.createdAt.get() }
    }

    private fun createRepo(): Repo {
        return Repo(
                name = "name",
                description = "description",
                owner = Owner(
                        login = "owner"
                ),
                createdAt = DateTime(2017, 5, 13, 22, 22)
        )
    }

}