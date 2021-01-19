package ru.netology.lesson3.agototext

/**
 * Description
 * Домашнее задание к занятию «1.3. Управляющие конструкции: if, switch, циклы. Работа с отладчиком»
 * Задача №1 - "Только что"
 */

const val daySeconds = 24L * 60L * 60L

fun main()
{
    val secondSeq = sequenceOf(1, 60+10, 60*2, 60*5, 60*12, 60*20, 60*21, 60*22,
                               3600 + 1, 3600 * 2, 3600 * 5, 3600 * 21, 3600 * 23,
                              daySeconds + 2, daySeconds * 2 + 2, daySeconds * 10)
    for (secondsVal in secondSeq)
    {
        println(agoToText(secondsVal))
    }
}
/**
 * Description
 * Функция превращает число секунд в текст означающий сколько времени прошло
 * secondsAgo - сколько секунд прошло
 */
fun agoToText(secondsAgo : Long) : String = when (secondsAgo) {
    in 0L                ..60L            -> "только что"
    in 61L               ..60L * 60L      -> "${secondsAgo / 60L} ${minuteTextFromMinutes(secondsAgo / 60L)} назад"
    in 60L * 60L + 1L    ..daySeconds     -> "${secondsAgo / 3600L} ${hoursTextFromHours ( secondsAgo / 3600L)} назад"
    in daySeconds + 1    ..daySeconds * 2 -> "сегодня"
    in daySeconds * 2 + 1..daySeconds * 3 -> "вчера"
    else                                  -> "давно"
}

/**
 * Description
 * Функция превращает число минут часа в текст означающий сколько минут прошло
 * minutesAgo - сколько минут прошло
 */
fun minuteTextFromMinutes(minutesAgo : Long) : String = when(minutesAgo){
             1L -> "минуту"
    in   2L..4L -> "минуты"
    in 21L..60L -> when (minutesAgo % 10L){
               1L -> "минуту"
        in 2L..4L -> "минуты"
        else      -> "минут"
    }
    else          -> "минут"
}

/**
 * Description
 * Функция превращает число часов в текст означающий сколько часов прошло
 * hoursAgo - сколько часов прошло
 */
fun hoursTextFromHours(hoursAgo : Long) : String = when(hoursAgo){
                    1L, 21L -> "час"
    in  2L..4L, in 22L..24L -> "часа"
    else                    -> "часов"
}