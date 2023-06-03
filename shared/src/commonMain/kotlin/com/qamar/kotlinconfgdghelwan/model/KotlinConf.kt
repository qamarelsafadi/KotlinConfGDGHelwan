package com.qamar.kotlinconfgdghelwan.model

data class KotlinConf(
    val title: String,
    val image: String,
    val description: String
) {
    companion object {
        val list = listOf(
            KotlinConf(
                "KotlinConf'23",
                "k23.png",
                "KotlinConf'23 keynotes featured exciting discussions on Kotlin's growth and its impact on the software development landscape. Renowned speakers shared insights on topics like multiplatform development, reactive programming, and Kotlin for Android. The keynotes highlighted Kotlin's versatility, seamless integration, and its role in empowering developers to build innovative solutions. Attendees left inspired, equipped with new perspectives on Kotlin's future and its ability to drive modern software development."
            ),
            KotlinConf(
                "KotlinConf'22",
                "k22.jpeg",
                "KotlinConf'22 was a highly successful event that showcased the latest advancements and trends in the Kotlin programming language. The keynotes delivered inspiring talks on topics like Kotlin in production, building resilient applications, and the future of Kotlin. Attendees gained valuable insights into Kotlin's expanding ecosystem, its benefits for mobile and web development, and its integration with existing technologies. The conference further solidified Kotlin's position as a powerful and versatile language for modern software development."
            ),
            KotlinConf(
                "KotlinConf'21",
                "k21.png",
                "KotlinConf'21 was an impactful event that brought together developers from around the world to explore the latest developments in the Kotlin programming language. The keynotes delivered insightful talks on topics such as Kotlin for backend development, building reactive applications, and Kotlin in the Android ecosystem. Attendees gained valuable knowledge on Kotlin's features, best practices, and its growing community. The conference underscored Kotlin's continued growth and its potential for creating robust and efficient software solutions."
            ),
            KotlinConf(
                "KotlinConf'23",
                "k23.png",
                "KotlinConf'23 keynotes featured exciting discussions on Kotlin's growth and its impact on the software development landscape. Renowned speakers shared insights on topics like multiplatform development, reactive programming, and Kotlin for Android. The keynotes highlighted Kotlin's versatility, seamless integration, and its role in empowering developers to build innovative solutions. Attendees left inspired, equipped with new perspectives on Kotlin's future and its ability to drive modern software development."
            ),
            KotlinConf(
                "KotlinConf'22",
                "k22.jpeg",
                "KotlinConf'22 was a highly successful event that showcased the latest advancements and trends in the Kotlin programming language. The keynotes delivered inspiring talks on topics like Kotlin in production, building resilient applications, and the future of Kotlin. Attendees gained valuable insights into Kotlin's expanding ecosystem, its benefits for mobile and web development, and its integration with existing technologies. The conference further solidified Kotlin's position as a powerful and versatile language for modern software development."
            ),
            KotlinConf(
                "KotlinConf'21",
                "k21.png",
                "KotlinConf'21 was an impactful event that brought together developers from around the world to explore the latest developments in the Kotlin programming language. The keynotes delivered insightful talks on topics such as Kotlin for backend development, building reactive applications, and Kotlin in the Android ecosystem. Attendees gained valuable knowledge on Kotlin's features, best practices, and its growing community. The conference underscored Kotlin's continued growth and its potential for creating robust and efficient software solutions."
            ),

            )
    }
}