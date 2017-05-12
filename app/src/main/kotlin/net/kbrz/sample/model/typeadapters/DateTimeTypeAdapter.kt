package net.kbrz.sample.model.typeadapters

import android.os.Parcel
import org.joda.time.DateTime
import paperparcel.TypeAdapter

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

object DateTimeTypeAdapter : TypeAdapter<DateTime> {

    override fun writeToParcel(value: DateTime, outParcel: Parcel, flags: Int) {
        outParcel.writeLong(value.millis)
    }

    override fun readFromParcel(inParcel: Parcel): DateTime {
        return DateTime(inParcel.readLong())
    }

}