package edu.metrostate.myassignment1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.misc.ToDo
import edu.metrostate.myassignment1.models.SharedViewModel
import edu.metrostate.myassignment1.models.SharedViewModel.loggedInUser
import edu.metrostate.myassignment1.models.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoView (viewModel: TodoViewModel, navController: NavController){
    // val todoList = getInitialList()
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember{ mutableStateOf("") }
    var showError by remember{ mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    Column(
        modifier = Modifier
            .absoluteOffset(325.dp, 750.dp)
            .size(100.dp)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        SmallFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            onClick = { showBottomSheet = true},
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
    }
    Column(
        modifier = Modifier
            .absoluteOffset(30.dp, 750.dp)
            .size(100.dp)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        SmallFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            onClick = {
                viewModel.returnToHome(navController)
            },
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.AutoMirrored.Filled.ExitToApp, "Small floating action button.")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .absoluteOffset(0.dp, 48.dp)
            .padding(8.dp)
    ){
        TitleBox()

        todoList?.let{

            LazyColumn (

                content = {
                    itemsIndexed(it) { index: Int, item: AddTodoResponse ->
                        TodoItem(item = item, viewModel)
                    }
                }
            )


        }?: Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.empty),
            //text = loggedInUser.toString(),
            fontSize = 28.sp
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(12.dp, 8.dp)
                            .fillMaxWidth(),
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = {Text(text = stringResource(id = R.string.msg2))}
                    )

                    Spacer(modifier = Modifier.padding(2.dp))

                    Button(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth(),
                        onClick = {
                        if(inputText == "" || inputText == " " || inputText == "   "){
                           showError = true
                        }
                        else{
                            viewModel.addTodo(inputText)
                            showError = false
                            showBottomSheet = false
                        }
                        inputText = ""
                    }) {
                        Text(text = stringResource(id = R.string.sv))
                    }

                    OutlinedButton(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth(),
                        onClick = {
                        inputText = ""
                        showError = false
                        showBottomSheet = false
                    }) {
                        Text(text = stringResource(id = R.string.cncl))
                    }
                    if(showError){
                        Row(
                            modifier = Modifier
                                .offset(0.dp, (-25).dp)
                                .fillMaxWidth()
                                //.fillMaxSize()
                                //.align(alignment = Alignment.CenterHorizontally)
                                .padding(60.dp, 28.dp)
                                .clip(RoundedCornerShape(26.dp))
                                .size(600.dp, 50.dp)
                                .background(Color.Cyan)
                                .padding(60.dp, 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                modifier = Modifier
                                    .fillMaxSize(),
                                text = stringResource(id = R.string.error)
                                    )
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun TodoItem(item: AddTodoResponse, viewModel: TodoViewModel){
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 2.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(12.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
          text = item.description,
          fontSize = 12.sp,
          color = Color.Black)
        Spacer(modifier = Modifier.size(48.dp))
        Spacer(modifier = Modifier.size(48.dp))
        Spacer(modifier = Modifier.size(48.dp))
        Spacer(modifier = Modifier.size(48.dp))
        Checkbox(
            checked = checked,
            onCheckedChange = {
                viewModel.updateThisTodo(
                    loggedInUser.id,
                    item.id,
                    item,
                    loggedInUser.token)
                checked = it }
        )
    }
}

@Composable
private fun TitleBox(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            //.absoluteOffset(0.dp, 0.dp)
            .fillMaxWidth()
            .height(48.dp)
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = stringResource(id = R.string.title),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
private fun Error(){
    Text(text = stringResource(id = R.string.error))
}

@Composable
@Preview(showBackground = true)
fun TodoViewPreview(){
    TodoView(
        TodoViewModel(),
    navController = rememberNavController()
    )
}