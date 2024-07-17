package edu.metrostate.myassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import edu.metrostate.myassignment1.ui.theme.MyAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            MyAssignment1Theme {
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //var show: ShowBS = ShowBS()
                    //ContentView()
                    //AddTaskButton()
                    //PartialBottomSheet()
                    TodoView(viewModel = todoViewModel)
                }
            }
        }
    }
}

data class ShowBS(var showBottomSheet: Boolean = false)

@Composable
private fun ContentView(){
    //var
    // var showBottomSheet by remember { mutableStateOf(false) }

    //function calls
    TitleBox(modifier = Modifier)
    //AddTaskButton()
    TodoListView(10, modifier = Modifier)
    //PartialBottomSheet(modifier = Modifier)
    //AddTaskButton()
}

/*
@Composable
fun AddTaskButton() : Boolean {
    var show by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .absoluteOffset(350.dp, 850.dp)
            .size(100.dp)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        SmallFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            onClick = { show = true},
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
        PartialBottomSheet(show)
    }
    return show

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet(show: Boolean) {

    var showBottomSheet by remember { mutableStateOf(show) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Text(
                    "Swipe up to open sheet. Swipe down to dismiss.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

 */

@Composable
fun AddTaskButton() : Boolean {
    var show by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .absoluteOffset(350.dp, 850.dp)
            .size(100.dp)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        SmallFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            onClick = { show = true},
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
    }
    return show

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    showBottomSheet = AddTaskButton()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Text(
                    "Swipe up to open sheet. Swipe down to dismiss.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet(show: ShowBS) {
    //var showBottomSheet by remember { mutableStateOf(false) }
    val temp: Boolean = true
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (temp) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = { show.showBottomSheet = false }
            ) {
                Text(
                    "Swipe up to open sheet. Swipe down to dismiss.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
 */

@Composable
private fun TextEntry() : String{
    var entry by remember { mutableStateOf((TextFieldValue("")))}
    TextField(
        value = entry,
        onValueChange = {entry = it},
        label = {
            Text(
                text = stringResource(id = R.string.msg2)
            )
        }
    )
    return entry.toString()

}

//Change to lazy list
@Composable
private fun TodoListView(items: Int, modifier: Modifier = Modifier){
    Column(
        modifier
            .absoluteOffset(0.dp, 112.dp)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        for(i in 1 until items){
            ItemView(i, modifier)
        }
    }

}

@Composable
private fun ItemView(items: Int, modifier: Modifier = Modifier){
    Color.White
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(id = R.string.msg1, items),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Spacer(modifier = Modifier.size(275.dp))
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Composable
private fun TitleBox(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .absoluteOffset(0.dp, 48.dp)
            .fillMaxWidth()
            .height(48.dp)
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


/*
@Composable
private fun TitleBox(modifier: Modifier = Modifier){
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .height(100.dp)
           .background(androidx.compose.ui.graphics.Color.Blue)
           .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
        //contentAlignment = Alignment.Center
    ){
        Text(
            text = stringResource(id = R.string.title),
            color = androidx.compose.ui.graphics.Color.White,
            textAlign = TextAlign.Center,
            modifier = modifier
                .size(48.dp)
        )
    }
}
*/

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.title),
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAssignment1Theme {
        // Greeting("Android")
        //TitleBox()
        //PartialBottomSheet()
        ContentView()
    }
}