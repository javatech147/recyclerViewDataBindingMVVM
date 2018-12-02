package com.waytojava.recyclerviewkotlinmvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.waytojava.recyclerviewkotlinmvvm.model.Employee

/**
 * Created by Manish Kumar on 12/2/2018
 */
class EmployeeViewModel : ViewModel {

    var id: Int = 0
    var name: String = ""
    var email: String = ""


    constructor()


    constructor(employee: Employee) {
        this.id = employee.id
        this.name = employee.name
        this.email = employee.email
    }


    private var employeeLiveData = MutableLiveData<List<EmployeeViewModel>>()

    fun getEmployeeLiveDataList(): MutableLiveData<List<EmployeeViewModel>> {
        // Prepare Dummy data
        // You can get data from API call
        val employee1 = EmployeeViewModel(Employee(1, "Manish", "javatech147@gmail.com"))
        val employee2 = EmployeeViewModel(Employee(2, "Vikash", "vikash@gmail.com"))
        val employee3 = EmployeeViewModel(Employee(3, "Rakesh", "rakesh@gmail.com"))
        val employee4 = EmployeeViewModel(Employee(4, "Virat", "virat@gmail.com"))

        val employeeList = ArrayList<EmployeeViewModel>()
        employeeList!!.add(employee1)
        employeeList!!.add(employee2)
        employeeList!!.add(employee3)
        employeeList!!.add(employee4)

        employeeLiveData.value = employeeList


        return employeeLiveData
    }
}