package com.example.principalApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.selection.selectable
import java.util.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign


@Composable
fun DatePickerComponent(onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonthIndex = calendar.get(Calendar.MONTH)
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

    val months = listOf(
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    )

    var selectedYear by remember { mutableStateOf(currentYear) }
    var selectedMonthIndex by remember { mutableStateOf(currentMonthIndex) }
    var selectedDay by remember { mutableStateOf(currentDay) }
    var selectedDate by remember { mutableStateOf("${currentDay}/${months[selectedMonthIndex]}/${currentYear}") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF9F9F9))
    ) {
        DatePickerView(
            selectedYear = selectedYear,
            selectedMonthIndex = selectedMonthIndex,
            selectedDay = selectedDay,
            onYearChanged = { year -> selectedYear = year },
            onMonthChanged = { index -> selectedMonthIndex = index },
            onDayChanged = { day -> selectedDay = day }
        )

        Spacer(modifier = Modifier.height(5.dp))

        TextField(
            value = selectedDate,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
    }
    LaunchedEffect(selectedYear, selectedMonthIndex, selectedDay) {
        selectedDate = "${selectedDay}/${months[selectedMonthIndex]}/${selectedYear}"
        onDateSelected(selectedDate)
    }
}

@Composable
fun DatePickerView(
    selectedYear: Int,
    selectedMonthIndex: Int,
    selectedDay: Int,
    onYearChanged: (Int) -> Unit,
    onMonthChanged: (Int) -> Unit,
    onDayChanged: (Int) -> Unit
) {
    val years = (1900..2100).toList()
    val months = listOf(
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    )
    val days = (1..31).toList()

    // Calculate the number of days in the selected month
    val daysInMonth = remember(selectedYear, selectedMonthIndex) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, selectedYear)
            set(Calendar.MONTH, selectedMonthIndex)
            set(Calendar.DAY_OF_MONTH, 1)
        }
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }
    val adjustedDays = days.take(daysInMonth)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        // Year Picker
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White)
                .padding(8.dp)
        ) {
            item {
                Text(
                    text = "Año",
                    fontSize = 22.sp,
                    color = Color(0xFF5B7BC9),
                    fontFamily = FontFamily(Font(R.font.notosans_medium, FontWeight.Normal)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            items(years) { year ->
                Text(
                    text = year.toString(),
                    fontSize = 14.sp,
                    color = if (year == selectedYear) Color(0xFFFFFFFF) else Color(0xFF000000), // Color del texto según selección
                    fontFamily = FontFamily(Font(R.font.notosans_thin, FontWeight.Normal)),
                    textAlign = TextAlign.Center, // Alineación del texto
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .selectable(
                            selected = year == selectedYear,
                            onClick = { onYearChanged(year) }
                        )
                        .background(if (year == selectedYear) Color(0xFFBDBDBD) else Color.Transparent)
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }

        // Month Picker
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White)
                .padding(8.dp)
        ) {
            item {
                Text(
                    text = "Mes",
                    fontSize = 22.sp,
                    color = Color(0xFF5B7BC9),
                    fontFamily = FontFamily(Font(R.font.notosans_medium, FontWeight.Normal)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            items(months) { month ->
                Text(
                    text = month,
                    fontSize = 14.sp,
                    color = if (months.indexOf(month) == selectedMonthIndex) Color(0xFFFFFFFF) else Color(0xFF000000), // Color del texto según selección
                    fontFamily = FontFamily(Font(R.font.notosans_thin, FontWeight.Normal)),
                    textAlign = TextAlign.Center, // Alineación del texto
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .selectable(
                            selected = months.indexOf(month) == selectedMonthIndex,
                            onClick = { onMonthChanged(months.indexOf(month)) }
                        )
                        .background(if (months.indexOf(month) == selectedMonthIndex) Color(0xFFBDBDBD) else Color.Transparent)
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }

        // Day Picker
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White)
                .padding(8.dp)
        ) {
            item {
                Text(
                    text = "Día",
                    fontSize = 22.sp,
                    color = Color(0xFF5B7BC9),
                    fontFamily = FontFamily(Font(R.font.notosans_medium, FontWeight.Normal)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            items(adjustedDays) { day ->
                Text(
                    text = day.toString(),
                    fontSize = 14.sp,
                    color = if (day == selectedDay) Color(0xFFFFFFFF) else Color(0xFF000000), // Color del texto según selección
                    fontFamily = FontFamily(Font(R.font.notosans_thin, FontWeight.Normal)),
                    textAlign = TextAlign.Center, // Alineación del texto
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .selectable(
                            selected = day == selectedDay,
                            onClick = { onDayChanged(day) }
                        )
                        .background(if (day == selectedDay) Color(0xFFBDBDBD) else Color.Transparent)
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}
