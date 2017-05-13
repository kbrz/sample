package net.kbrz.sample.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import paperparcel.PaperParcel

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@PaperParcel
data class Repo(
        @SerializedName("id") val id: Long? = null,
        @SerializedName("owner") val owner: Owner? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("topics") val topics: List<String?>? = null,
        @SerializedName("created_at") val createdAt: DateTime? = null
) : Parcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelRepo.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelRepo.writeToParcel(this, dest, flags)
    }

}