package net.kbrz.sample.util

import android.databinding.ObservableField

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class ObservableString : ObservableField<String> {

    constructor()

    constructor(value: String?) : super(value)

    override fun get(): String {
        return super.get() ?: ""
    }

}
