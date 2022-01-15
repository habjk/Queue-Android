package com.khhhm.worefa

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.khhhm.worefa.adapters.ServiceListRecyclerViewAdapter

import com.khhhm.worefa.dummy.DummyContent
import com.khhhm.worefa.dummy.DummyContent.DummyItem
import com.khhhm.worefa.viewmodels.ServiceViewModel
import kotlinx.android.synthetic.main.fragment_servicelist.view.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ServiceListFragment.OnListFragmentInteractionListener] interface.
 */
class ServiceListFragment : Fragment() {


    // TODO: Customize parameters
    private var columnCount = 1
    private lateinit var floatingActionButton: FloatingActionButton
    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var servicesViewModel:ServiceViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val serviceListRecyclerViewAdapter:ServiceListRecyclerViewAdapter
        val view = inflater.inflate(R.layout.fragment_servicelist_list, container, false)
        val application=activity?.application

        servicesViewModel= ViewModelProviders.of(this).get(ServiceViewModel::class.java)
                ViewModelProviders.of(this).get(ServiceViewModel::class.java)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                serviceListRecyclerViewAdapter = ServiceListRecyclerViewAdapter(listener)
                adapter=serviceListRecyclerViewAdapter
            }
        //    servicesViewModel.getCompanyServices(5).observe(this, Observer { services->serviceListRecyclerViewAdapter.setService(services) })

            // servicesViewModel.insertService()
           // servicesViewModel.getCompanyServices(5).observe(this, Observer { services ->serviceListRecyclerViewAdapter.setService(services) })

        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }


}
