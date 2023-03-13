package com.example.gooru.feature.data.home

import com.example.gooru.feature.domain.model.homepage.HomeInfo
import com.example.gooru.feature.domain.model.homepage.HomePage
import com.example.gooru.feature.presentation.home.HomeViewModel

class FAQ(
    val question: String,
    val response: String,
):HomePage

fun HomeViewModel.creteFAQList(): List<HomePage> {
   return listOf(
        FAQ(
            question = "Что такое парсинг?",
            response = "Парсинг — это автоматизированный процесс сбора информации с любого сайта, " +
                    "её анализ, преобразование и выдача в структурированной форме. Чаще всего это " +
                    "таблица с набором данных. Парсер сайта — это программа или сервис, которые " +
                    "осуществляют парсинг заданного ресурса."
        ),
        FAQ(
            question = "Зачем нужен парсинг?",
            response = "Одна из целей парсинга — развитие бизнеса. На пути к этой цели парсинг" +
                    " выполняет следующие задачи:\n\n • сбор информации об ассортименте " +
                    "конкурентов;\n• парсинг названий товаров, артикулов, цен и прочего наполнения " +
                    "интернет-магазина. Эту задачу парсер может выполнять как единоразово, так " +
                    "и на регулярной основе;\n" +
                    "• анализ структуры сайтов конкурентов ради улучшения собственного сайта."
        ),
        FAQ(
            question = "Как работает парсинг?",
            response = "Процесс парсинга — это автоматическое извлечение большого массива данных" +
                    " с веб-ресурсов, которое выполняется с помощью специальных скриптов." +
                    "Парсер ходит по ссылкам указанного сайта и сканирует код каждой страницы," +
                    " собирая всю информацию в отдельный файл. Совокупность этих данных и есть" +
                    " результат парсинга сайта."
        ),
        FAQ(
            question = "Чем парсинг лучше работы человека?",
            response = "Парсинг — это рутинная и трудоёмкая работа. Можно вручную извлечь " +
                    "информацию, например, с пятистраничного сайта, но только представьте, сколько" +
                    " времени уйдёт на самостоятельный парсинг 50 страниц...\n" +
                    "Не будем исключать и человеческий фактор. Мы случайно можем что-то упустить " +
                    "или не заметить. В случае с парсером такая вероятность исключается. " +
                    "Самое главное — правильно его настроить."
        ),
        FAQ(
            question = "Какую информациюможно получитьпри помощи парсера?",
            response = "Разные парсеры имеют свои ограничения, но фактически вы можете получить " +
                    "любую информацию, которая находится в коде страниц сайта."
        ),
        FAQ(
            question = "Законно ли парсить чужие сайты?",
            response ="Парсинг не противоречит закону, если:\n" +
                    "• получаемая информация лежит в открытом доступе и не является " +
                    "коммерческой тайной;\n" +
                    "• не затрагиваются авторские права;\n" +
                    "• используются законные методы парсинга;\n" +
                    "• парсинг не вредит работе сайта и не приводит к сбоям. Если вам кажется, что" +
                    " вы можете нарушить один из пунктов выше, советуем перед проведением анализа" +
                    " сайта проконсультироваться с юристом."
        ),

    )
}