package io.github.media_transcodec_demo

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import io.github.aurakit_android_prime.AuraOperationInvoker
import io.github.aurakit_media_transcoder.AuraMediaTranscoder
import io.github.media_transcodec_demo.ui.theme.AuraKitTheme
import kotlinx.coroutines.launch
import java.io.File

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

suspend fun tryIt(context: Context) {
    val handle = AuraOperationInvoker.invoke(
        operation = AuraMediaTranscoder(
            input = "file:///android_asset/amjd.ogg",
            startMs = 0,
            endMs = 1000
        )
    )

    val file = File(context.cacheDir, "segment_output.pcm")
    file.writeBytes(handle)
    Log.i("AuraKit", "✅ PCM saved: ${file.absolutePath}")

    println("------------------=================[AURA KIT CUT MEDIA OPERATION] after decode =${handle.size}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    ElevatedButton(
        modifier = modifier,
        onClick = {
            runCatching {
                scope.launch {
                    tryIt(context)
                }
            }.onFailure {
                println("this is message error  ${it.message}")
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