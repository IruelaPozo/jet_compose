package iruelapozo.com.github.composefundamentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import iruelapozo.com.github.composefundamentos.ui.theme.ComposefundamentosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposefundamentosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaPrincipal(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaPrincipal(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // espaço entre os itens
    ) {
        Inicial()
        NotificationBadge()
        CardMensagem()
    }
}

@Composable
fun Inicial(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(color = Color.Blue).padding(8.dp)) {
        TextoCustomizado("Primeira função composable.")
        Row {
            TextoCustomizado("Seja bem vindo!")
            Spacer(Modifier.width(8.dp))
            TextoCustomizado("Olá usuário.")
        }
    }
}

@Composable
fun TextoCustomizado(texto: String, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun NotificationBadge(modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(16.dp), contentAlignment = Alignment.Center) {
        // círculo verde
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color = Color.Green)
        )
        // bolinha vermelha
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
fun CardMensagem(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Foto do contato",
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "Autor da mensagem")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Conteúdo da mensagem")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaPrincipal() {
    ComposefundamentosTheme {
        TelaPrincipal()
    }
}
