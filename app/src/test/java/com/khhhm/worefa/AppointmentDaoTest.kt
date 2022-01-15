package com.khhhm.worefa.data

import android.graphics.Bitmap
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.khhhm.worefa.data.entitys.Appointment
import com.khhhm.worefa.data.entitys.Company
import com.khhhm.worefa.data.entitys.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.util.*


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)

@SmallTest

class AppointmentDaoTest {
    private lateinit var database: WorefaDatabase

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        // PowerMockito.mockStatic(Log::class.java)
        database = WorefaDatabase.getDatabase(ApplicationProvider.getApplicationContext())/*Room.databaseBuilder(
           ApplicationProvider.getApplicationContext(),
           WorefaDatabase::class.java,"WorefaDatabase").allowMainThreadQueries().build()*/

    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertAppointmentAndGet() = runBlockingTest {
        // GIVEN - insert an appointment
        GlobalScope.launch(Dispatchers.IO) {
            val appointment = Appointment(34, 21, 314, "hena", "14/3/2019", 2, 2)
            database.appointmentDao().insertAppointment(appointment)

            // WHEN - Get the appointment by code from the database
            val loaded = database.appointmentDao().getAppointment(appointment.localId)

            // THEN - The loaded data contains the expected values
            MatcherAssert.assertThat<Appointment>(loaded as Appointment, CoreMatchers.notNullValue())
            MatcherAssert.assertThat(loaded.localId, CoreMatchers.`is`(appointment.localId))
            MatcherAssert.assertThat(loaded.user, CoreMatchers.`is`(appointment.user))
            MatcherAssert.assertThat(loaded.id, CoreMatchers.`is`(appointment.id))
            MatcherAssert.assertThat(loaded.date, CoreMatchers.`is`(appointment.date))
            MatcherAssert.assertThat(loaded.service_id, CoreMatchers.`is`(appointment.service_id))
            MatcherAssert.assertThat(loaded.token, CoreMatchers.`is`(appointment.token))
            MatcherAssert.assertThat(loaded.line_no, CoreMatchers.`is`(appointment.line_no))
        }
    }


    @Test
    fun deleteAppointmentAndGet() = runBlockingTest {
        // Given a appointment inserted
        GlobalScope.launch(Dispatchers.IO) {
            val appointment = Appointment(3, 2, 34, "henok", "4/23/2019", 7, 2)


            // When deleting a appointment by id
            database.appointmentDao().deleteAppointment(appointment)

            // THEN - The object returned is null
            val getUser = database.appointmentDao().getAppointment(appointment.localId)
            MatcherAssert.assertThat(getUser, CoreMatchers.nullValue())
        }
    }

    @Test
    fun updateAppointmentAndGetById() = runBlockingTest {
        // When inserting an appointment
        GlobalScope.launch(Dispatchers.IO) {
            val original = Appointment(13, 24, 34, "kibrleab", "4/3/2019", 7, 2)
             database.appointmentDao().insertAppointment(original)

            // When an appointment is updated
            val updated = Appointment(3, 12, 34, "henok", "4/23/2019", 7, 2)
            database.appointmentDao().updateAppointment(updated)

            // THEN - The loaded data contains the expected values
            val loaded = database.appointmentDao().getAppointment(original.localId)
            MatcherAssert.assertThat(loaded.value?.id, CoreMatchers.`is`(updated.id))
            MatcherAssert.assertThat(loaded.value?.user, CoreMatchers.`is`("henok"))
            MatcherAssert.assertThat(loaded.value?.token, CoreMatchers.`is`(2))
            MatcherAssert.assertThat(loaded.value?.service_id, CoreMatchers.`is`(updated.id))
            MatcherAssert.assertThat(loaded.value?.date, CoreMatchers.`is`("4/23/2019"))
            MatcherAssert.assertThat(loaded.value?.line_no, CoreMatchers.`is`(7))
        }
    }


    @Test
    fun getAllAppointments() = runBlockingTest {
        GlobalScope.launch(Dispatchers.IO) {
            val appointment = Appointment(1, 2, 4, "kibrleab", "4/3/2019", 7, 2)
            database.appointmentDao().insertAppointment(appointment)

            val result = database.appointmentDao().getAllappointments()

            MatcherAssert.assertThat(result, CoreMatchers.notNullValue())
        }
    }

}

