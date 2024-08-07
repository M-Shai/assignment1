package edu.metrostate.myassignment1.api


import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Credentials
import edu.metrostate.myassignment1.data.GetTodoResponse
import edu.metrostate.myassignment1.data.LoginResponse
import edu.metrostate.myassignment1.data.RegisterResponse
import retrofit2.http.GET
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.data.UpdateTodo
import edu.metrostate.myassignment1.data.UpdateTodoResponse
import edu.metrostate.myassignment1.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCall {

    @Headers(
        "Accept: applications/json"
    )

    @POST("/api/users/register")
   suspend fun register(
        @Query("apikey") apiKey: String,
        @Body registerUser: Credentials
    ) : Response<RegisterResponse>

    @POST("/api/users/login")
    suspend fun login(
        @Query("apikey") apiKey: String,
        @Body loginUser: User
    ) : Response<LoginResponse>

    @GET("/api/users/{user_id}/todos")
    suspend fun getUserTodos(
        @Header("authorization") auth: String,
        @Path("user_id") userId: Int,
        @Query("apikey") apiKey: String
    ) : Response<List<GetTodoResponse>>

    @POST("/api/users/{user_id}/todos")
    suspend fun addUserTodo(
        @Header("authorization") auth: String,
        @Path("user_id") userId: Int,
        @Query("apikey") apiKey: String,
        @Body newTodo: Todo
    ) : Response<AddTodoResponse>

    @PUT("/api/users/{user_id}/todos/{todo_id}")
    suspend fun updateTodo(
        @Header("authorization") auth: String,
        @Path("user_id") userId: Int,
        @Path("todo_id") todoId: Int,
        @Query("apikey") apiKey: String,
        @Body updateTodo: UpdateTodo
    ) : Response<UpdateTodoResponse>
}
