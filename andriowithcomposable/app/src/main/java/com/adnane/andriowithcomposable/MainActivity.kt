package com.adnane.andriowithcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import com.adnane.andriowithcomposable.ui.theme.AndriowithComposableTheme



class  MainActivity : CompenentActivity {
    override fun  onCreate(saveInstanceState : Bundle?){
        super.onCreate(saveInstanceState)
        setContent{HelloConterTheme {MainScreen() } }
    }
}



@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DireBonjourSection()
        CompteurSection()
    }
}


@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var greetingName by rememberSaveable { mutableStateOf<String?>(null) }

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = name,
            onValueChange = { ... },
            label = { Text(stringResource(R.string.label_firstname)) },
            placeholder = { Text(stringResource(R.string.ph_firstname)) }
        )

        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() } },
            enabled = name.isNotBlank()
        ) {
            Text(stringResource(R.string.btn_greet))
        }

        if (greetingName != null) {
            AssistChip(onClick = { }, label = { Text("Bonjour $greetingName") })
        }
    }
}

