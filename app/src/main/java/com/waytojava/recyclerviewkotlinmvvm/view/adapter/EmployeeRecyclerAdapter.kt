package com.waytojava.recyclerviewkotlinmvvm.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.waytojava.recyclerviewkotlinmvvm.R
import com.waytojava.recyclerviewkotlinmvvm.databinding.EmployeeBinding
import com.waytojava.recyclerviewkotlinmvvm.viewmodel.EmployeeViewModel

/**
 * Created by Manish Kumar on 12/2/2018
 */
class EmployeeRecyclerAdapter(
    private val context: Context,
    private val employeeArrayList: List<EmployeeViewModel>
) :
    RecyclerView.Adapter<EmployeeRecyclerAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val employeeBinding: EmployeeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.single_row, parent, false)
        return EmployeeViewHolder((employeeBinding))
    }

    override fun getItemCount(): Int {
        return employeeArrayList.size
    }

    override fun onBindViewHolder(viewHolder: EmployeeViewHolder, position: Int) {
        var employeeViewModel = employeeArrayList[position]
        viewHolder.bind(employeeViewModel)
    }


    class EmployeeViewHolder(val employeeBinding: EmployeeBinding) : RecyclerView.ViewHolder(employeeBinding.root) {
        fun bind(employeeViewModel: EmployeeViewModel) {
            this.employeeBinding.employeeViewModel = employeeViewModel
            employeeBinding.executePendingBindings()
        }
    }
}