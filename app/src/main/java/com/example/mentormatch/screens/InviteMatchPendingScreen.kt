package com.example.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mentormatch.R
import com.example.mentormatch.components.softSkilllist
import com.example.mentormatch.components.tecnologylist
import com.example.mentormatch.database.repository.InviteMatchRepository
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.enums.SoftSkill
import com.example.mentormatch.enums.Technology
import com.example.mentormatch.model.InviteMatch
import com.example.mentormatch.model.User
import com.example.mentormatch.repository.getAllUsers

@Composable
fun InviteMatchPendingScreen(navController: NavHostController, idUser: String){
    Surface {
        val context = LocalContext.current
        val userRepository = UserRepository(context)
        val inviteMatchRepository = InviteMatchRepository(context)

        var currentUser:User = userRepository.buscarUsuarioPeloId(idUser.toLong())
        Log.d("Usuário do contexto",  currentUser.toString())

        var inviteList: List<InviteMatch>? = null;
        if(currentUser.typeUser == "Mentor"){
            inviteList = inviteMatchRepository.buscarInviteMatchPorMentorId(currentUser.id)
        }else{
            inviteList = inviteMatchRepository.buscarInviteMatchPorAprendizId(currentUser.id)
        }
        Log.d("Lista de Invites",  inviteList.toString())

        Column (
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                text = if(currentUser.typeUser == "Aprendiz") "Lista de Mentores Pendentes" else "Lista de Aprendizes pendentes",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )

            LazyColumn(){
                items(inviteList){
                    val user:User = userRepository.buscarUsuarioPeloId(it.aprendizId)
                    Log.d("[Invite List User Id] ${user.id}: ", user.toString())
                    UserCard(user = user)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewUserCard(){
    Surface {
        val user = getAllUsers()[0];
        UserCard(user = user)
    }
}
@Composable
fun UserCard(user: User){
    Card (
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth(),

        ) {
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),

            ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Box (
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp),
                ){
                    Image(
                        painter = painterResource(id = R.drawable.mentor1),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth()
                            // .shadow() // Incluir uma sombra básica e sútil
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Column (
                    modifier = Modifier

                ){
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ){
                        Text(
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                            text = user.name
                        )
                        Text(
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                            text = "-"
                        )
                        Text(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            text = "Idade: " + user.age,
                            color = MaterialTheme.typography.bodySmall.color
                        )
                    }

                    Text(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = MaterialTheme.typography.bodyMedium.color,
                        text = "Objetivo: " + user.goal
                    )
                }
            }
            Row(){
                Column (){
                    tecnologylist(user.technologies)
                    softSkilllist(user.softSkills)
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewInviteMatchPendingScreen(){
    var navController = rememberNavController()
    val idUser = "1"

    InviteMatchPendingScreen(navController, idUser)
}
