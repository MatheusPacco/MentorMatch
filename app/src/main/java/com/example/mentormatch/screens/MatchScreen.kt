package com.example.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentormatch.R
import com.example.mentormatch.enums.SoftSkill
import com.example.mentormatch.enums.Technology
import com.example.mentormatch.model.User
import com.example.mentormatch.repository.getAllUsers
import com.example.mentormatch.ui.theme.MentorMatchTheme

@Preview(
    name = "PreviewMatchScreen",
    showSystemUi = true,
    heightDp = 2000
)
@Composable
fun PreviewMatchScreen(){
    Surface {
        var searchTextState = remember {
            mutableStateOf("")
        }
        var userListState = remember {
            mutableStateOf(getAllUsers())
        }
        var technologyListState = remember {
            mutableStateListOf<String>()
        }
        var softSkillListState = remember {
            mutableStateListOf<String>()
        }
        Column (
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState(), enabled = true),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ){
            Text(
                text = "Encontre o seu aprendiz!",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )

            OutlinedTextField(
                value = searchTextState.value,
                onValueChange = {
                    searchTextState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Nome do aprendiz")
                },
                trailingIcon = {
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                }
            )
            // Cabeçalho de filtro
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Text(
                    text = "Filtro de Tecnologias:",
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState(), enabled = true),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    filterTecnologySection(technologyListState, userListState, softSkillListState)
                }
            }

            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Text(
                    text = "Filtro de Tecnologias:",
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState(), enabled = true),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    filterSoftSkillSection(softSkillListState, technologyListState, userListState)
                }
            }

            // Seção de usuários
//            LazyRow(){
//                items(userListState.){
//                    StudioCard(game = it)
//                }
//            }

            userListState.component1().forEach { user ->
                UserCard(user);
            }
        }
    }
}

//@Preview(
//    name = "PreviewUserCard",
//    showBackground = true
//)
@Composable
fun UserCard(user:User){
    Card (
        modifier = Modifier
            .height(164.dp)
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
            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = { TODO() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                )
                {
                    Text(color = Color.LightGray, text="Match")
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Gray
                    )
                )
                {
                    Text(color = Color.Gray, text="Passar")
                }
            }
        }
    }
}

@Composable
fun tecnologylist(listTecnology:Array<String>){
    Row (
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        listTecnology.forEach { tecnology ->
            AssistChip(
                modifier = Modifier
                    .height(24.dp),
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = "$tecnology",
                        fontSize = 10.sp,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        color = MaterialTheme.typography.bodySmall.color
                    )
                },
                colors =  AssistChipDefaults.assistChipColors(Color.Blue, labelColor = Color.LightGray),
                border =  AssistChipDefaults.assistChipBorder(borderColor = Color.LightGray)
            )
        }
    }
}

@Composable
fun softSkilllist(softSkillList:Array<String>){
    Row (
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        softSkillList.forEach { softSkill ->
            AssistChip(
                modifier = Modifier
                    .height(24.dp),
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = "$softSkill",
                        fontSize = 10.sp,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        color = MaterialTheme.typography.bodySmall.color
                    )
                },
                colors =  AssistChipDefaults.assistChipColors(Color.Blue, labelColor = Color.LightGray),
                border =  AssistChipDefaults.assistChipBorder(borderColor = Color.LightGray)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun filterTecnologySection(technologyListState : SnapshotStateList<String>, userListState : MutableState<List<User>>,  softSkillListState : SnapshotStateList<String>){
    Technology.values().forEach { tecnologia ->
        FilterChip(
            modifier = Modifier
                .height(24.dp),
            label = {
                Text(
                    text = "$tecnologia",
                    fontSize = 10.sp,
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    color = MaterialTheme.typography.bodySmall.color
                )
            },
            onClick = {
                Log.d("Assist chip", "NAME: " + tecnologia.name)
                if(tecnologia.name in technologyListState){
                    val index = technologyListState.indexOf(tecnologia.name)
                    technologyListState.removeAt(index)
                }else{
                    technologyListState.add(tecnologia.name)
                }

                var newUserListState:List<User> = getAllUsers();
                if(!technologyListState.toList().isEmpty())
                    newUserListState = filterUserListByTecnology(technologyListState, newUserListState);

                if(!softSkillListState.toList().isEmpty())
                    newUserListState = filterUserListBySoftSkill(softSkillListState, newUserListState);

                userListState.value = newUserListState;
            },
            selected = tecnologia.name in technologyListState,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun filterSoftSkillSection(softSkillListState : SnapshotStateList<String>, technologyListState : SnapshotStateList<String>, userListState : MutableState<List<User>>){
    SoftSkill.values().forEach { softskill ->
        FilterChip(
            modifier = Modifier
                .height(24.dp),
            label = {
                Text(
                    text = "$softskill",
                    fontSize = 10.sp,
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    color = MaterialTheme.typography.bodySmall.color
                )
            },
            onClick = {
                Log.d("Assist chip", "Name: " + softskill.name)
                if(softskill.name in softSkillListState){
                    val index = softSkillListState.indexOf(softskill.name)
                    softSkillListState.removeAt(index)
                }else{
                    softSkillListState.add(softskill.name)
                }

                var newUserListState:List<User> = getAllUsers();
                if(!technologyListState.toList().isEmpty())
                    newUserListState = filterUserListByTecnology(technologyListState, newUserListState);

                if(!softSkillListState.toList().isEmpty())
                    newUserListState = filterUserListBySoftSkill(softSkillListState, newUserListState);

                userListState.value = newUserListState;
            },
            selected = softskill.name in softSkillListState,
        )
    }
}

fun filterUserListByTecnology(technologyListState : SnapshotStateList<String>, listUser:List<User>): List<User> {
        return  listUser.filter { user ->
            Log.d("Usuário", user.toString());
            Log.d("Filtro de tecnologia", technologyListState.toList().toString())

            val tecnologyFound:List<String> = user.technologies.filter { tecnology ->
                tecnology in technologyListState.toList()
            }

            tecnologyFound.size == technologyListState.size
        }
}

fun filterUserListBySoftSkill(softSkillListState: SnapshotStateList<String>, listUser:List<User>): List<User> {
    return  listUser.filter { user ->
        Log.d("Usuário", user.toString());
        Log.d("Filtro de SoftSkill", softSkillListState.toList().toString())

        val softSkillFound:List<String> = user.softSkills.filter { softSkill ->
            softSkill in softSkillListState.toList()
        }

        softSkillFound.size == softSkillListState.size
    }
}

//fun filterUserList(, softSkillListState : SnapshotStateList<String>): List<User>{
//    val listUser:List<User> = getAllUsers();
//    Log.d("Lista Usuários", listUser.toString());
//
//    val usersFilteredByTechnology = listUser.filter { user ->
//        Log.d("Usuário", user.toString());
//        Log.d("Filtro de tecnologia", technologyListState.toList().toString())
//
//        val tecnologyFound:List<String> = user.technologies.filter { tecnology ->
//            tecnology in technologyListState.toList()
//        }
//
//        tecnologyFound.size == technologyListState.size
//    }
//
//}


