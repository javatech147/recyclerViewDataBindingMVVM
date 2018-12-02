package com.waytojava.recyclerviewkotlinmvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.waytojava.recyclerviewkotlinmvvm.R
import com.waytojava.recyclerviewkotlinmvvm.databinding.ActivityMainBinding
import com.waytojava.recyclerviewkotlinmvvm.view.adapter.EmployeeRecyclerAdapter
import com.waytojava.recyclerviewkotlinmvvm.view.utils.toast
import com.waytojava.recyclerviewkotlinmvvm.viewmodel.EmployeeViewModel

/**
 * Created by Manish Kumar on 12/2/2018
 */

class MainActivity : AppCompatActivity(), EmployeeRecyclerAdapter.OnEmployeeListItemClickListener {
    private lateinit var employeeAdapter: EmployeeRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerView!!.layoutManager = LinearLayoutManager(this)

        val employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeViewModel.getEmployeeLiveDataList().observe(this, Observer { employeeList ->
            employeeAdapter = EmployeeRecyclerAdapter(this@MainActivity, employeeList!!)
            binding.recyclerView!!.adapter = employeeAdapter
            employeeAdapter!!.setOnEmployeeListItemClickListener(this@MainActivity)
        })
    }

    override fun onEmployeeListItemClickListener(view: View, employeeViewModel: EmployeeViewModel) {
        toast("Welcome ${employeeViewModel.name}")
    }
}