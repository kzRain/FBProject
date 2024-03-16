import androidx.compose.ui.window.ComposeUIViewController
import components.ScaffoldExample
import ui.FBTheme

fun MainViewController() = ComposeUIViewController {
    FBTheme() {
        ScaffoldExample()
    }
}
