package com.khhhm.worefa.data

import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.khhhm.worefa.data.entitys.Appointment
import com.khhhm.worefa.data.entitys.Company
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


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)

@SmallTest

class CompanyDaoTest {
    private lateinit var database: WorefaDatabase

    val company = listOf<Company>(
        Company(4, "habib", "xxx", "addis", "addis ababa"),
        Company(3, "kibr", "yyx", "ais", "addis ababa"),
        Company(2, "hena", "zzx", "bbbs", "addis ababa")

    )



    @Before
    fun initDb() {
        database = WorefaDatabase.getDatabase(ApplicationProvider.getApplicationContext())

    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertAllCompanies() = runBlockingTest {
        // GIVEN - insert an appointment
        GlobalScope.launch(Dispatchers.IO) {
            database.companyDao().insertAll(company)

            }
    }

    @Test
    fun getAllCompanies() = runBlockingTest {
        GlobalScope.launch(Dispatchers.IO) {
            val result = database.companyDao().getAllCompanys()
            MatcherAssert.assertThat(result, CoreMatchers.notNullValue())
        }
    }

    @Test
    fun getById() = runBlockingTest {
        GlobalScope.launch(Dispatchers.IO) {
            val result = database.companyDao().getCompany(company.get(0).Id as Long)
            MatcherAssert.assertThat(result, CoreMatchers.notNullValue())
        }
    }


}

/*
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
    fun updateCompany() = runBlockingTest {
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

*/

