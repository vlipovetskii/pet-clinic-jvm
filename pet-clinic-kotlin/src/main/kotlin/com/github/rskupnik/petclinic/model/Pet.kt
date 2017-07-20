package com.github.rskupnik.petclinic.model

import javax.persistence.*

// Implementation using a regular class, mimicking regular Java

@Entity
class Pet(var name: String = "") {
    @Id
    @GeneratedValue
    var id: Long = 0

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    var owner: Customer? = null

    override fun toString(): String = "$name"
}