package com.example.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mentormatch.database.repository.InviteMatchRepository
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.model.InviteMatch
import com.example.mentormatch.model.User

@Preview(
    name = "Criar User",
    showSystemUi = true
)
@Composable
fun CriarUsuario(){
    val context = LocalContext.current
    val userRepository = UserRepository(context)
    val inviteMatchRepository = InviteMatchRepository(context)

    Surface {
        Button(onClick = {
            try{
                val userInstance = User(
                    name = "Pedro Amaral Arrudas",
                    age = 21,
                    description = "Cabeçudoc chatão",
                    gender = false,
                    goal = "Bobão",
                    typeUser = 0,
                    technologies = mutableListOf<String>("JAVA"),
                    softSkills = mutableListOf<String>("Sabe Conversa +-"),
                )
                val idUser = userRepository.salvar(userInstance)
                Log.d("Usuário Amaral Criado", idUser.toString());

                val userInstance2 = User(
                    name = "Letícia Esqueci",
                    age = 21,
                    description = "Mulher",
                    gender = false,
                    goal = "Não é bobona",
                    typeUser = 1,
                    technologies = mutableListOf<String>("Photoshop, Adobe Premier"),
                    softSkills = mutableListOf<String>("Ansiedade Social"),
                )

                val idUser2 = userRepository.salvar(userInstance2)
                Log.d("Letícia criado", idUser2.toString());

                Log.d("Amaral: ", userRepository.buscarUsuarioPeloId(idUser).toString())
                Log.d("Letícia: ", userRepository.buscarUsuarioPeloId(idUser2).toString())

                val aprendiz:User = userRepository.buscarUsuarioPeloId(idUser)

                val inviteMatch = InviteMatch(
                    aprendizId = aprendiz.id,
                    mentorId = 2,
                    inviteStatus = "Pendente Aprovação",
                    aprendizConfirmado = true,
                    mentorConfirmado = false
                )

                inviteMatchRepository.salvar(inviteMatch)
            }catch (e:Exception){
                Log.e("Erro Encontrado", e.toString());
            }

        }
        ) {
            Text(text = "Clique para criar usuário!")
        }

        Spacer(modifier = Modifier
            .height(16.dp))

//        Column(modifier = Modifier
//            // .fillMaxHeight()
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(18.dp)
//        ){
//            listaUsuarioState.value.forEach {user ->
//                Card(
//                    modifier = Modifier,
//                ){
//                    Text(text = "Nome: ${user.nome}")
//                    Text(text = "É amigo: ${user.isAmigo}")
//                    Text(text = "Telefone: ${user.telefone}")
//                }
//            }
//        }
    }
}