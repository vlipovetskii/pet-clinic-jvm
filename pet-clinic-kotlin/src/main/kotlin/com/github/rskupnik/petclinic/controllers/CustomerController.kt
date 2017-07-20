package com.github.rskupnik.petclinic.controllers

import com.github.rskupnik.petclinic.model.Customer
import com.github.rskupnik.petclinic.repositories.CustomerRepository
import org.springframework.web.bind.annotation.*

// Constructor injection, as presented here, is the preferred way, especially with Kotlin
@RestController
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

    // The need to use arrayOf() in annotations is annoying, but at least we can ommit it in default value

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable("id") id: Long): Customer? =
            customerRepository.findOne(id)

    @GetMapping("/formatted")
    fun getAllCustomersFormatted() =
            customerRepository.findAll().map { it.toString() }

    @GetMapping
    fun getAllCustomers() = customerRepository.findAll()

    @PostMapping
    fun addCustomer(@RequestBody customer: Customer): Customer? =
            customerRepository.save(customer)
}