package com.khhhm.worefa.data

import android.graphics.Bitmap
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.khhhm.worefa.data.entitys.Appointment
import com.khhhm.worefa.data.entitys.Company
import com.khhhm.worefa.data.entitys.Services
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

class ServiceDaoTest {
    private lateinit var database: WorefaDatabase

    val services = listOf<Services>(
        Services(4, 3, "xxx", "addis", "addis ababa","cdbskdh",8.7),
        Services(3, 9, "yyx", "ais", "addis ababa","nnnncn",9.1),
        Services(2, 6, "zzx", "bbbs", "addis ababa","kjj",2.1)

    )


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
    fun insertAllServiceAndGetById() = runBlockingTest {
        // GIVEN - insert an appointment
        GlobalScope.launch(Dispatchers.IO) {
             database.servicesDao().insertAllService(services)

            // WHEN - Get the appointment by code from the database
            val loaded = database.servicesDao().getSingleById(services.get(1).Id as Long)

            // THEN - The loaded data contains the expected values
            MatcherAssert.assertThat<Services>(loaded as Services, CoreMatchers.notNullValue())
            MatcherAssert.assertThat(loaded.Id, CoreMatchers.`is`(services.get(1).Id))
            MatcherAssert.assertThat(loaded.companyId, CoreMatchers.`is`(services.get(1).companyId))
            MatcherAssert.assertThat(loaded.details, CoreMatchers.`is`(services.get(1).details))
            MatcherAssert.assertThat(loaded.imgUrl, CoreMatchers.`is`(services.get(1).imgUrl))
            MatcherAssert.assertThat(loaded.name, CoreMatchers.`is`(services.get(1).name))
            MatcherAssert.assertThat(loaded.rating, CoreMatchers.`is`(services.get(1).rating))
            MatcherAssert.assertThat(loaded.subhead, CoreMatchers.`is`(services.get(1).subhead))
        }
    }


    @Test
    fun GetAllServices() = runBlockingTest {
        // GIVEN - insert an appointment
        GlobalScope.launch(Dispatchers.IO) {
            database.servicesDao().insertAllService(services)

            // WHEN - Get the appointment by code from the database
            val loaded = database.servicesDao().getService()

            // THEN - The loaded data contains the expected values
            MatcherAssert.assertThat<Services>(loaded as Services, CoreMatchers.notNullValue())
            MatcherAssert.assertThat(loaded.Id, CoreMatchers.`is`(services.get(1).Id))
            MatcherAssert.assertThat(loaded.companyId, CoreMatchers.`is`(services.get(1).companyId))
            MatcherAssert.assertThat(loaded.details, CoreMatchers.`is`(services.get(1).details))
            MatcherAssert.assertThat(loaded.imgUrl, CoreMatchers.`is`(services.get(1).imgUrl))
            MatcherAssert.assertThat(loaded.name, CoreMatchers.`is`(services.get(1).name))
            MatcherAssert.assertThat(loaded.rating, CoreMatchers.`is`(services.get(1).rating))
            MatcherAssert.assertThat(loaded.subhead, CoreMatchers.`is`(services.get(1).subhead))
        }
    }





    @Test
    fun InsertServiceAndGetByCompanyId() = runBlockingTest {
        // Given a appointment inserted
        GlobalScope.launch(Dispatchers.IO) {
       val service = Services(11, 2, "xxx", "addis", "addis ababa","cdbskdh",8.7)

            database.servicesDao().insertService(service)


            val loaded = database.servicesDao().getAllByCompanyId(service.companyId as Long)

            // THEN - The loaded data contains the expected values
            MatcherAssert.assertThat<Services>(loaded as Services, CoreMatchers.notNullValue())
            MatcherAssert.assertThat(loaded.Id, CoreMatchers.`is`(service.Id))
            MatcherAssert.assertThat(loaded.companyId, CoreMatchers.`is`(service.companyId))
            MatcherAssert.assertThat(loaded.details, CoreMatchers.`is`(service.details))
            MatcherAssert.assertThat(loaded.imgUrl, CoreMatchers.`is`(service.imgUrl))
            MatcherAssert.assertThat(loaded.name, CoreMatchers.`is`(service.name))
            MatcherAssert.assertThat(loaded.rating, CoreMatchers.`is`(service.rating))
            MatcherAssert.assertThat(loaded.subhead, CoreMatchers.`is`(service.subhead))
        }
        }
    }


/*
    @Test
    fun getALLServices() = runBlockingTest {
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




