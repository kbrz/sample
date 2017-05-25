package net.kbrz.sample.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import net.kbrz.sample.R

/**
 * @author Konrad Brzykcy
 * @since 25.05.17
 */

@BindingAdapter("repoDetailsHeader")
fun setRepoDetailsHeader(imageView: ImageView, repoName: String) {
    val backgroundsCount = 4
    val index = repoName.hashCode() % backgroundsCount
    val headerDrawableId = when (index) {
        0 -> R.drawable.details_bar_bg_1
        1 -> R.drawable.details_bar_bg_2
        2 -> R.drawable.details_bar_bg_3
        3 -> R.drawable.details_bar_bg_4
        else -> R.drawable.details_bar_bg_1
    }
    imageView.setImageResource(headerDrawableId)
}

@BindingAdapter("intText")
fun setIntegerAsText(textView: TextView, text: Int) {
    textView.text = text.toString()
}
