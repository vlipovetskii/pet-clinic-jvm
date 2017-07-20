package com.github.rskupnik.petclinic.controllers

import com.github.rskupnik.petclinic.model.Pet
import com.github.rskupnik.petclinic.repositories.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

// This controller uses field injection instead of constructor injection

@RestController
@RequestMapping("/pets")
class PetController {

    // When using Autowired like this we need to make the variable lateinit
    @Autowired
    lateinit var petRepository: PetRepository

    @GetMapping
    fun getAllPets() = petRepository.findAll()

    @PostMapping
    fun addPet(@RequestBody pet: Pet): Pet? = petRepository.save(pet)
}