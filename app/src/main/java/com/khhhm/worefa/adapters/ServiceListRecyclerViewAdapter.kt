package com.khhhm.worefa.adapters


import android.app.DatePickerDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.khhhm.worefa.ServiceListFragment.OnListFragmentInteractionListener
import com.khhhm.worefa.data.entitys.Services
import com.khhhm.worefa.databinding.FragmentServicelistBinding
import com.khhhm.worefa.dummy.DummyContent.DummyItem
import java.util.*
import kotlin.math.roundToInt

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class ServiceListRecyclerViewAdapter(

    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<ServiceListRecyclerViewAdapter.ViewHolder>() {
    private var listOfServices: List<Services> = emptyList()
    private val mOnClickListener: View.OnClickListener
    var cal = Calendar.getInstance()

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentServicelistBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    internal fun setService(services: List<Services>) {
        listOfServices = listOf(
            Services(1, 1,"Maintince","We Maintain Our brand Phones","https://media.noria.com/sites/Uploads/2018/12/20/73c77e51-97d0-4ec5-81dc-e80c0b265dcf_Images_ProactiveMaintenanceApproach_31035_1234x694_large.jpeg",
                "jdjdjjdjdgjdflsgsljflgdjdgjldgfgjgjdgglddjgfjgdgjdgjgdfgfgf",2.7),


            Services(1, 1,"Maintince","We Maintain Our brand Phones","https://media.noria.com/sites/Uploads/2018/12/20/73c77e51-97d0-4ec5-81dc-e80c0b265dcf_Images_ProactiveMaintenanceApproach_31035_1234x694_large.jpeg",
                "jdjdjjdjdgjdflsgsljflgdjdgjldgfgjgjdgglddjgfjgdgjdgjgdfgfgf",3.7),

            Services(1, 1,"Maintince","We Maintain Our brand Phones","https://media.noria.com/sites/Uploads/2018/12/20/73c77e51-97d0-4ec5-81dc-e80c0b265dcf_Images_ProactiveMaintenanceApproach_31035_1234x694_large.jpeg",
                "jdjdjjdjdgjdflsgsljflgdjdgjldgfgjgjdgglddjgfjgdgjdgjgdfgfgf",2.7)
            )
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listOfServices[position])

    override fun getItemCount(): Int = listOfServices.size

    inner class ViewHolder(val binding: FragmentServicelistBinding) : RecyclerView.ViewHolder(binding.root) {
        internal fun bind(services: Services) {

            binding.addAppointmentFab.setOnClickListener {
               /* val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker, year: Int, monthOfYear: Int,
                        dayOfMonth: Int
                    ) {
                        cal.set(Calendar.YEAR, year)
                        cal.set(Calendar.MONTH, monthOfYear)
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    }
                }*/
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)


                val dpd = DatePickerDialog(it.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                   // lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
                    Toast.makeText(it.context,dayOfMonth.toString()+"/"+monthOfYear.toString()+"/"+month.toString(),Toast.LENGTH_SHORT).show()
                }, year, month, day)

                dpd.show()
            }
            binding.services = services
            binding.executePendingBindings()
        }


    }
}

