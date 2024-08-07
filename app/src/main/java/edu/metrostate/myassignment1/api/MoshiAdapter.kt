package edu.metrostate.myassignment1.api

import android.icu.lang.UCharacter.isDigit
import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson
import edu.metrostate.myassignment1.data.LoginResponse

@JsonClass(generateAdapter = true)
class MoshiAdapter {
    @FromJson
    fun fromJson(json: LoginResponse): LoginResponse{
        var tmpadmin: Boolean = false
        var tmpenabled: Boolean = false

        if(json.admin == true || json.admin == false){

        }
        else if (json.admin as Int == 1){
            tmpadmin = true
        }

        if(json.admin == true || json.admin == false){

        }
        else if(json.enabled as Int == 1){
            tmpenabled = true
        }


        var tmp: LoginResponse = LoginResponse(
            tmpadmin,
            json.email,
            tmpenabled,
            json.id,
            json.name,
            json.token,
            json.warnings)

        return tmp
    }
    /*
    fun toJson(json: LoginResponse){
        var tmp: LoginResponse = LoginResponse(
            json.admin as Int,
            json.email,
            json.enabled as Int,
            json.id,
            json.name,
            json.token,
            json.warnings)

        return tmp


    }
     */
}