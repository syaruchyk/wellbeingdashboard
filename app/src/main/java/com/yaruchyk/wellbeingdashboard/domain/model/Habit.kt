data class Habit(
    val id: Int = 0,
    val title: String,
    val description: String?,
    val isActive: Boolean = true,
    val daysOfWeek: List<java.time.DayOfWeek> = emptyList() // List of scheduled days
)
