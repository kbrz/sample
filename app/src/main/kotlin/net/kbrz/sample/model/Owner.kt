package net.kbrz.sample.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@PaperParcel
data class Owner(
        @SerializedName("login") val login: String? = null,
        @SerializedName("id") val id: Long? = null
) : Parcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelOwner.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelOwner.writeToParcel(this, dest, flags)
    }

}