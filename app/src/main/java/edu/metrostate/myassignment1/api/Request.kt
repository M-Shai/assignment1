package edu.metrostate.myassignment1.api

import android.util.Log
import edu.metrostate.myassignment1.api.RetrofitInstance.retrofit
import edu.metrostate.myassignment1.data.Credentials
import edu.metrostate.myassignment1.data.LoginResponse
import edu.metrostate.myassignment1.data.RegisterResponse
import edu.metrostate.myassignment1.data.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Request {

    private const val API_KEY = "ada98dfd-5d4b-416b-87f8-be5c22289016"

    fun login(
        email: String,
        password: String
    ): Response<LoginResponse> = runBlocking {
        println("Request 23")
        var response: Response<LoginResponse>? = null
        val job = launch {
            val user = User(email, password)
            println("Request 27")
            response = retrofit.login(API_KEY, user);
            println("Request 29")
        }

        job.join()

        if (response!!.isSuccessful) {
            println("Success: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("failed" + response!!.message())
            return@runBlocking response!!
        }
    }
}

    /*
    fun login(
        //name: String? = null,
        email: String,
        password: String
        //loginResponse: MutableState<ReceivedData>
    ) {
        val user = User(email,password)
        val call: Response<LoginResponse> = retrofit.login(API_KEY, user);

     */

        /*
        call.enqueue(object: Callback<LoginResponse?> {
            override fun onResponse(p0: Call<LoginResponse?>, p1: Response<LoginResponse?>) {
                if(p1.isSuccessful) {
                    Log.d("Main", "success!" + p1.body().toString())
                    return p1.body()!!
                }
            }

            override fun onFailure(p0: Call<LoginResponse?>, t: Throwable) {
                Log.e("Main", "Failed" + t.message.toString())
            }
        })

         */


    /*

    data class Address(val line1: String, val line2: String?, val city: String, val zip: String)
data class Person(val name: String, val age: Int, val profession: String, val address: Address)

suspend fun parseJson(res: Resources): Person? {

    val jString = res.openRawResource(R.raw.person).bufferedReader().use { it.readText() }

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val jsonAdapter: JsonAdapter<Person> = moshi.adapter(Person::class.java)

    return jsonAdapter.fromJson(jString)
}



    fun getTodos(
        userId: Int
    ){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiCall::class.java)

        val call: Call<UserCredentials>? = api.getTodoList( BASE_URL, userId, API_KEY);

        call!!.enqueue(object: Callback<UserCredentials?> {
            override fun onResponse(p0: Call<UserCredentials?>, response: Response<UserCredentials?>) {
                if(response.isSuccessful) {
                    Log.d("Main", "success!" + response.body().toString())
                    credentialState.value = response.body()!!.profile
                }
            }

            override fun onFailure(p0: Call<UserCredentials?>, t: Throwable) {
                Log.e("Main", "Failed" + t.message.toString())
            }
        })

    }


    fun login(
        //name: String? = null,
        email: String,
        password: String
        //loginResponse: MutableState<ReceivedData>
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiCall::class.java)

        val call: Call<ReceivedData>? = api.login(email, password, API_KEY);

        call!!.enqueue(object: Callback<ReceivedData?> {
            override fun onResponse(p0: Call<ReceivedData?>, p1: Response<ReceivedData?>) {
                if(p1.isSuccessful) {
                    Log.d("Main", "success!" + p1.body().toString())
                    //return p1.body()!!
                }
            }

            override fun onFailure(p0: Call<ReceivedData?>, t: Throwable) {
                Log.e("Main", "Failed" + t.message.toString())
            }
        })

    }


     */
