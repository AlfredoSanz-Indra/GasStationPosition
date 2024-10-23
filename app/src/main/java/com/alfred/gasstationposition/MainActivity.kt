package com.alfred.gasstationposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.core.navigation.NavigationGraph
import org.koin.compose.KoinContext

/**
 * @author Alfredo Sanz
 * @time 2024
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        Klog.line("MainActivity", "onCreate", "activity creation")
        setContent {
            MaterialTheme {
                KoinContext() {
                    NavigationGraph()
                }
            }
        }
    }
}