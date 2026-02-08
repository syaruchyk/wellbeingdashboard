# Guion de Defensa: Wellbeing Dashboard

**Alumno:** [Tu Nombre]
**Asignatura:** Proyecto DAM
**Curso:** 2025/2026

---

## 1. Introducción (1 minuto)
Buenos días/tardes. Presento mi proyecto final "Wellbeing Dashboard", una aplicación móvil nativa para Android enfocada en el bienestar personal mediante el seguimiento de hábitos y emociones.

**Problema:**
En un mundo hiperconectado, descuidamos nuestro bienestar mental. Las apps existentes suelen requerir suscripciones o comprometen la privacidad.

**Solución:**
"Wellbeing Dashboard" es una herramienta **Offline First**, privada y gratuita que permite al usuario gestionar su día a día sin depender de internet ni ceder sus datos a terceros.

---

## 2. Tecnologías y Arquitectura (3 minutos)

### 2.1 Stack Tecnológico
He utilizado el estándar moderno de desarrollo Android:
*   **Lenguaje:** Kotlin (100%).
*   **UI:** Jetpack Compose (Declarativa, Material 3).
*   **Persistencia:** Room Database (SQLite abstracción).
*   **Inyección de Dependencias:** Hilt (Dagger).
*   **Asincronía:** Coroutines y Flow.
*   **Background Work:** WorkManager.

### 2.2 Arquitectura (Clean Architecture + MVVM)
La decisión técnica más importante fue separar el código en capas claras para asegurar mantenibilidad y testabilidad:

1.  **Capa Domain (Reglas de Negocio):**
    *   Contiene modelos puros (`Habit`, `EmotionRecord`) y Casos de Uso (`CalculateStreak`, `ToggleReminder`).
    *   *Ventaja:* No depende de Android, facilitando tests unitarios.

2.  **Capa Data (Datos):**
    *   Implementa los Repositorios y gestiona Room y DataStore.
    *   *Ventaja:* Cambio de fuente de datos transparente para la UI.

3.  **Capa UI (Presentación):**
    *   ViewModels que exponen `StateFlow` y Pantallas en Compose.
    *   *Ventaja:* UI reactiva que solo "dibuja" estados.

---

## 3. Demostración de Funcionalidad (4 minutos)

*(Mostrar App en Emulador/Dispositivo)*

1.  **Dashboard:**
    *   Vista rápida de "Hábitos de Hoy" (Filtrado por día de la semana).
    *   Tarjeta de resumen emocional.

2.  **Gestión de Hábitos (CRUD):**
    *   Crear un hábito con frecuencia personalizada.
    *   Marcarlo como completado (Animación visual).

3.  **Registro Emocional:**
    *   Botón FAB -> BottomSheet.
    *   Selección de emoción e intensidad (Enum persistido).

4.  **Estadísticas y Progreso:**
    *   Cálculo de racha actual (Lógica en Domain).
    *   Gráficos simples de tendencias.

5.  **Notificaciones:**
    *   Ajustes -> Activar Recordatorio 21:00.
    *   Uso de `WorkManager` para garantizar ejecución aunque la app esté cerrada.

---

## 4. Retos y Soluciones (1 minuto)

*   **Reto 1: Sincronización de notificaciones.**
    *   *Problema:* AlarmManager es inexacto en modo Doze.
    *   *Solución:* Implementé `WorkManager` con `PeriodicWorkRequest`, sacrificando precisión de segundos por fiabilidad y batería.

*   **Reto 2: Gestión del estado en Compose.**
    *   *Solución:* Uso estricto de StateHoisting y UDF (Unidirectional Data Flow) en todos los ViewModels.

---

## 5. Conclusiones y Futuro (1 minuto)

**Conclusión:**
El proyecto cumple con los objetivos de crear una app robusta, moderna y respetuosa con el usuario. La arquitectura Clean permite escalar fácilmente.

**Futuras Mejoras:**
*   Sincronización opcional con Google Drive (Backup).
*   Gamificación (Medallas por rachas).
*   Exportación de datos a PDF para terapeutas.

Muchas gracias. Quedo a disposición para sus preguntas.
