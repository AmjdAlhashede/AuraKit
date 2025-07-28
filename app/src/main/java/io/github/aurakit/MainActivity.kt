package io.github.aurakit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import io.github.aurakit.engine.entry.AuraOperationInvoker
import io.github.aurakit.media.cut.AuraMediaCutOperation
import io.github.aurakit.ui.theme.AuraKitTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuraKitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    ElevatedButton(
        modifier = modifier,
        onClick = {
            scope.launch {
                val operation = AuraMediaCutOperation(
                    "file:///android_asset/hi.mp3",
                    0L,
                    200L
                )

                val handle = AuraOperationInvoker.invoke(
                    operation = operation
                )
                println("------------------=================[AURA KIT CUT MEDIA OPERATION]=${handle.size}")

            }
        }
    ) {
        Text(
            text = "Hello $name!",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuraKitTheme {
        Greeting("Android")
    }
}