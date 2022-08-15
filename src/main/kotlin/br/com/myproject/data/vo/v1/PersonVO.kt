package br.com.myproject.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

//Permite configurar a exibição do Json definindo a ordem dos campos ou até ignorar alguns deles
@JsonPropertyOrder("id", "address", "first_Name", "lastName", "gender")
data class PersonVO (

    var id: Long = 0,

    @field:JsonProperty("first_Name")
    var firstName: String = "",

    var lastName: String = "",
    var address: String = "",

    @field:JsonIgnore
    var gender: String = ""
)
