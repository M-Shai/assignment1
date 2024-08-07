package edu.metrostate.myassignment1


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.metrostate.myassignment1.api.Request
import edu.metrostate.myassignment1.models.RegisterViewModel

@Composable
fun RegisterView(viewModel: RegisterViewModel, navController : NavController){
    // var login by remember { mutableStateOf(false) }
    // var register by remember { mutableStateOf(false) }
    var inputEmail by remember{ mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputFirstName by remember{ mutableStateOf("") }
    var inputLastName by remember { mutableStateOf("") }
    // var inputPhoneNumber by remember{ mutableStateOf("") }
    // var inputAddress by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .absoluteOffset(0.dp, (-171).dp),
            color = Color.Blue,
            text = stringResource(id = R.string.title),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier
                .absoluteOffset(0.dp, (-0).dp),
            color = Color.Blue,
            text = stringResource(id = R.string.msg5),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        OutlinedTextField(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(50.dp, 4.dp)
                .fillMaxWidth(),
            value = inputFirstName,
            onValueChange = { inputFirstName = it },
            label = {Text(text = stringResource(id = R.string.nme))}
        )
        /*
        OutlinedTextField(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(50.dp, 4.dp)
                .fillMaxWidth(),
            value = inputLastName,
            onValueChange = { inputLastName = it },
            label = {Text(text = stringResource(id = R.string.lname))}
        )
         */
        OutlinedTextField(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(50.dp, 4.dp)
                .fillMaxWidth(),
            value = inputEmail,
            onValueChange = { inputEmail = it },
            label = {Text(text = stringResource(id = R.string.email))}
        )
        OutlinedTextField(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(50.dp, 4.dp)
                .fillMaxWidth(),
            value = inputEmail,
            onValueChange = { inputPassword = it },
            label = {Text(text = stringResource(id = R.string.password))}
        )

        Spacer(modifier = Modifier.padding(6.dp))
        Button(onClick = {
           /* val data = Request.registerUser(
                name = inputFirstName,
                email = inputEmail,
                password = inputPassword
            )*/
            //inputPassword = data.toString()

            //Log.d("Main Activity", data.toString())
            navController.navigate(Screen.Home.route)
        }) {
            Text(
                text = stringResource(id = R.string.regis),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun RegisterViewPreview(){
    RegisterView(
        RegisterViewModel(),
    navController = rememberNavController()
    )
}
