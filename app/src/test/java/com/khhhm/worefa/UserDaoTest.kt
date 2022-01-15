package com.khhhm.worefa.data

import android.database.sqlite.SQLiteDatabase
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

class UserDaoTest {
    private lateinit var database: WorefaDatabase

    val users = listOf<User>(
        User("0987654321","1234"),
        User("0912345678","XXXX"),
        User("0976849374","1234"),
        User("0985645314","27836")
        )

    @Before
    fun initDb() {
        database = WorefaDatabase.getDatabase(ApplicationProvider.getApplicationContext())
        //database = SQLiteDatabase.create(null);
    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertUser() = runBlockingTest {
        // GIVEN - insert an appointment
        GlobalScope.launch(Dispatchers.IO) {
            database.userDao().insertUser(users.get(0))

        }
    }

    @Test
    fun getByPhone_No() = runBlockingTest {
        GlobalScope.launch(Dispatchers.IO) {
            val result = database.userDao().getByPhoneNo(users.get(0).phone_no)
            MatcherAssert.assertThat(result, CoreMatchers.notNullValue())
        }
    }

    /*
    @Test
    fun getAllCompanies() = runBlockingTest {
        GlobalScope.launch(Dispatchers.IO) {
            val result = database.companyDao().getAllCompanys()
            MatcherAssert.assertThat(result, CoreMatchers.notNullValue())
        }
    }
*/


}
