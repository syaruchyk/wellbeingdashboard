# Hilt/Dagger
-keep class com.yaruchyk.wellbeingdashboard.WellbeingApplication { *; }
-keep class dagger.hilt.** { *; }
-keep interface dagger.hilt.** { *; }
-keep public class * extends dagger.hilt.internal.aggregatedroot.AggregatedRoot

# Room
-keep class androidx.room.** { *; }
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

# Data Classes (Entities/Models) - Keep mainly for safety in this phase
-keep class com.yaruchyk.wellbeingdashboard.data.local.entity.** { *; }
-keep class com.yaruchyk.wellbeingdashboard.domain.model.** { *; }

# Compose (Generally safe, but keeping for stability)
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod

# Retrofit/Gson (Not used but good practice template)
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile