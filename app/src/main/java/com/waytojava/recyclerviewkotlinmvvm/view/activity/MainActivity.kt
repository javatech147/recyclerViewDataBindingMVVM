package com.waytojava.recyclerviewkotlinmvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.waytojava.recyclerviewkotlinmvvm.R
import com.waytojava.recyclerviewkotlinmvvm.databinding.ActivityMainBinding
import com.waytojava.recyclerviewkotlinmvvm.view.adapter.EmployeeRecyclerAdapter
import com.waytojava.recyclerviewkotlinmvvm.viewmodel.EmployeeViewModel

/**
 * Created by Manish Kumar on 12/2/2018
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerView!!.layoutManager = LinearLayoutManager(this)

        val employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeViewModel.getEmployeeLiveDataList().observe(this, Observer { employeeList ->
            val employeeAdapter: EmployeeRecyclerAdapter = EmployeeRecyclerAdapter(this@MainActivity, employeeList!!)
            binding.recyclerView!!.adapter = employeeAdapter
        })
    }
}