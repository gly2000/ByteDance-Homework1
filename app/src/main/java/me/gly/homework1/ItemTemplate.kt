package me.gly.homework1

class ItemTemplate constructor(name: String, info: String, gender: String, age: String, health: String){

    private var name: String = name
    private var age: String = age
    private var gender: String = gender
    private var health: String = health
    private var info: String = info

    fun getName(): String{
        return this.name
    }

    fun getAge(): String{
        return this.age
    }

    fun getGender(): String{
        return this.gender
    }

    fun getHealth(): String{
        return this.health
    }

    fun getDescription(): String {
        return this.info
    }
}