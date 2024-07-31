package edu.metrostate.myassignment1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
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

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController){
    // var login by remember { mutableStateOf(false) }
    // var register by remember { mutableStateOf(false) }
    var inputEmail by remember{ mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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

        Text(
            modifier = Modifier
                .absoluteOffset(0.dp, (-344).dp),
            color = Color.Blue,
            text = "Todo App",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )

        Button(
            modifier = Modifier
                .offset(0.dp,0.dp)
                .padding(2.dp)
                .fillMaxWidth(),
            onClick = {
                navController.navigate(Screen.Todo.route)
        }) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedButton(
            modifier = Modifier
                .offset(0.dp,30.dp),
            onClick = {
            navController.navigate(Screen.Register.route)
        }) {
            Text(
                text = "Create Account",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeViewPreview(){
    HomeView(HomeViewModel(),
    navController = rememberNavController()
    )
}

