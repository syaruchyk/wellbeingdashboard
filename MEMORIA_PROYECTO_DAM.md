# MEMORIA DEL PROYECTO DAM: Wellbeing Dashboard

**Autor:** [Tu Nombre]
**Curso:** Desarrollo de Aplicaciones Multiplataforma
**Fecha de Inicio:** Febrero 2026

---

## 1. Introducción y Contexto

### 1.1 Introducción
El presente proyecto consiste en el desarrollo de "Wellbeing Dashboard", una aplicación móvil nativa para el sistema operativo Android. Esta aplicación nace de la necesidad de proporcionar herramientas accesibles y privadas para el cuidado del bienestar personal en un entorno digital cada vez más saturado.

### 1.2 Contexto del Problema
En la actualidad, el seguimiento de hábitos saludables y el monitoreo emocional son prácticas recomendadas por profesionales de la salud. Sin embargo, muchas de las soluciones existentes requieren conexión constante a internet, suscripciones de pago o comprometen la privacidad del usuario al almacenar datos sensibles en la nube. "Wellbeing Dashboard" busca democratizar el acceso a estas herramientas mediante una solución "Offline First", gratuita y privada.

---

## 2. Objetivos del Proyecto

### 2.1 Objetivo General
Desarrollar una aplicación Android robusta, escalable y mantenible que permita a los usuarios gestionar sus hábitos diarios y registrar su estado emocional, garantizando la persistencia de datos local y una experiencia de usuario fluida.

### 2.2 Objetivos Específicos
*   Implementar una arquitectura de software profesional basada en **Clean Architecture** y patrón **MVVM**.
*   Utilizar **Jetpack Compose** para la construcción de una interfaz de usuario moderna y declarativa.
*   Garantizar la persistencia de datos local segura mediante **Room Database**.
*   Aplicar principios de **Inyección de Dependencias** con Hilt para mejorar la testabilidad.
*   Documentar todo el ciclo de vida del desarrollo software siguiendo estándares de la industria.

---

## 3. Análisis de Requisitos (Resumen ERS)

### 3.1 Perfil de Usuario
El sistema está dirigido a usuarios con un nivel técnico medio-basico, interesados en su autoconocimiento y productividad personal. Se valora la inmediatez y la privacidad.

### 3.2 Requisitos Funcionales Clave
*   **Gestión de Hábitos:** Crear, listar, y marcar hábitos diarios.
*   **Seguimiento Emocional:** Registro de emoción (básica), intensidad (Leve/Moderado/Intenso) y notas.
*   **Estadísticas:** Resumen visual del progreso semanal.
*   **Notificaciones:** Recordatorios locales diarios.

### 3.3 Requisitos No Funcionales
*   **Usabilidad:** Diseño Material 3.
*   **Rendimiento:** Carga inicial < 2s.
*   **Tecnología:** Kotlin, Android API 26+, Room.

*(Para el detalle completo, consultar el Anexo I: Especificación de Requerimientos de Software)*

---

## 4. Historias de Usuario (User Stories)

| ID | Historia de Usuario | Módulo |
| :--- | :--- | :--- |
| **HU-01** | Como usuario preocupado por mi rutina, quiero crear un nuevo hábito... | Hábitos |
| **HU-02** | Como usuario organizado, quiero ver una lista de mis hábitos del día... | Hábitos |
| **HU-03** | Como usuario motivado, quiero marcar un hábito como "Completado"... | Hábitos |
| **HU-04** | Como usuario, quiero eliminar hábitos que ya no realizo... | Hábitos |
| **HU-05** | Como usuario reflexivo, quiero registrar mi emoción actual... | Emociones |
| **HU-06** | Como usuario detallista, quiero indicar la intensidad y una nota... | Emociones |
| **HU-07** | Como usuario analítico, quiero consultar mi historial de registros... | Emociones |
| **HU-08** | Como usuario enfocado, quiero ver un resumen semanal... | Estadísticas |
| **HU-10** | Como usuario ocupado, quiero recibir un recordatorio diario... | Notificaciones |

---

## 5. Planificación y Metodología

### 5.1 Herramientas Utilizadas
El entorno de desarrollo se ha configurado con las siguientes herramientas estándar:

*   **Android Studio:** Entorno de desarrollo integrado (IDE) principal.
*   **Kotlin:** Lenguaje de programación oficial.
*   **Git & GitHub:** Sistema de control de versiones para trazabilidad del código.
*   **Antigravity:** Asistente de IA para la gestión de tareas, arquitectura y documentación.

### 5.2 Cronograma de Fases
1.  **Fase 0: Preparación del Entorno** (Completada).
2.  **Fase 1: Análisis y Requisitos** (Completada).
3.  **Fase 2: Diseño UI/UX** (Pendiente).
4.  **Fase 3: Implementación Básica** (Pendiente).
5.  **Fase 4: Implementación Avanzada & Lógica** (Pendiente).
6.  **Fase 5: Pruebas y Optimización** (Pendiente).

---

## 6. Ejecución de la Fase 0: Preparación del Entorno

### 6.1 Actividades Realizadas
En esta fase inicial se estableció la base tecnológica del proyecto. Se creó el proyecto en **Android Studio** configurando el SDK mínimo en 26 (Android 8.0) para garantizar compatibilidad con la mayoría de dispositivos actuales, y el Target SDK en 36.

### 6.2 Decisiones Técnicas y Arquitectura
Se optó por una arquitectura por capas (**Clean Architecture**) para separar responsabilidades y facilitar el mantenimiento:
*   **Capa Domain:** Contiene los modelos (`Habit`, `EmotionRecord`) y las interfaces del repositorio. Es puramente Kotlin y no tiene dependencias de Android.
*   **Capa Data:** Implementa la persistencia con **Room Database**. Se crearon las entidades (`HabitEntity`, `EmotionRecordEntity`) y los DAOs necesarios.
*   **Inyección de Dependencias:** Se configuró **Hilt** (Dagger) para gestionar la creación de objetos, facilitando la escalabilidad.

### 6.3 Infraestructura y Herramientas
*   **Control de Versiones:** Repositorio alojado en GitHub y sincronizado desde el primer commit.
*   **Integración de Skills:** Se incorporaron asistentes de IA específicos para Calidad (`testing-quality`) y Documentación (`documentation-dam`).

---

## 7. Ejecución de la Fase 1: Análisis y Requisitos

### 7.1 Definición y Alcance
Tras analizar la problemática del bienestar personal, se definió un alcance "Offline First". Se descartó el uso de backend remoto para priorizar la privacidad del usuario y la simplicidad del sistema.

### 7.2 Ajuste de Requisitos (Iteración)
Durante la definición del módulo de emociones, se tomó la decisión de **simplificar la escala de intensidad**.
*   *Anterior:* Escala numérica 1-10.
*   *Decisión:* Escala discreta (Leve, Moderado, Intenso).
*   *Justificación:* Reduce la carga cognitiva del usuario al registrar una emoción, mejorando la usabilidad rápida.

### 7.3 Estructura de Datos Definida
Se validaron los modelos de datos principales:
1.  **Hábito:** ID, Título, Descripción, Estado (Completado/No).
2.  **Registro Emocional:** ID, Tipo (Enum), Intensidad (Enum), Nota, Timestamp.

### 7.4 Refactor del Modelo de Datos (Cierre Fase 1)
Antes de iniciar el diseño, se realizó un refactor crítico para alinear el código con el ERS:
*   **Cambio:** `EmotionIntensity` pasó de `Int` (1-10) a `Enum` (LEVE, MODERADO, INTENSO).
*   **Persistencia:** Se optó por guardar el Enum como `String` en Room para mantener la legibilidad de la base de datos.
*   **Migración:** Se incrementó la versión de la base de datos a `2` y se configuró `fallbackToDestructiveMigration()` dada la ausencia de datos de usuario en producción.

*(El detalle completo de requisitos se encuentra en la sección 3 "Análisis de Requisitos")*

---


---

## 8. Ejecución de la Fase 2: Diseño UI/UX

### 8.1 Identidad Visual (Estilo de Marca)
Se definió un sistema de diseño ("Design System") orientado a la calma y la claridad, alineado con el propósito de bienestar de la aplicación.
*   **Paleta de Colores:**
    *   *Primario:* **Teal 800** (`#00695C`) - Evoca estabilidad y naturaleza.
    *   *Secundario:* **Teal 100** (`#B2DFDB`) - Soporte suave.
    *   *Acento:* **Deep Orange 400** (`#FF7043`) - Para acciones clave (FAB), aportando calidez.
    *   *Neutros:* Grises para textos y fondos de alto contraste (Accesibilidad WCAG AA).
*   **Tipografía:** Se seleccionó **Roboto** (Google Fonts) por ser la fuente nativa de Android, garantizando familiaridad y legibilidad óptima.

### 8.2 Arquitectura de Información y Navegación
Se diseñó una estructura de navegación basada en **Bottom Navigation Bar** con tres destinos principales, facilitando el acceso rápido a las funciones core:
1.  **Inicio (Dashboard):** Visión inmediata del día (hábitos pendientes y estado emocional).
2.  **Hábitos:** Gestión CRUD completa.
3.  **Progreso:** Visualización de estadísticas e historial.

### 8.3 Wireframes Funcionales
Se definieron los esquemas de las pantallas principales siguiendo **Material Design 3**:
*   *Dashboard:* Tarjetas resumen y acceso rápido a registro emocional mediante FAB.
*   *Registro Emocional:* Uso de *Modal Bottom Sheet* para no interrumpir el flujo del usuario, con selectores de intensidad discretos (Leve/Moderado/Intenso).

*(Material gráfico disponible en el anexo `design_system.md` y `wireframes_navigation.md`)*

---

---

## 9. Ejecución de la Fase 3: Implementación Básica

### 9.1 Incremento 3.1: Infraestructura de Navegación
Se ha construido el esqueleto de la aplicación utilizando **Jetpack Compose Navigation**.
*   **Componentes Creados:**
    *   `Screen.kt`: Clase sellada para gestión de rutas tipadas (Dashboard, Habits, Stats, Settings).
    *   `MainScreen.kt`: Contenedor principal con `Scaffold` y `NavHost`.
    *   `BottomNavBar.kt`: Barra de navegación inferior funcional.
*   **Tema:** Se aplicó la paleta de colores Teal/Orange definida en la Fase 2.

### 9.2 Incremento 3.2: Dashboard (UI + Datos)
Se implementó la pantalla de inicio (`DashboardScreen.kt`) conectada a la base de datos.
*   **Funcionalidad:**
    *   Saludo al usuario.
    *   Tarjeta "Resumen Emocional" (Visual).
    *   **Hábitos de Hoy:** Lista dinámica que muestra solo los hábitos programados para el día actual, obtenidos vía `DashboardViewModel`.
*   **Componentes:** Reutilización de `HabitCard` para consistencia visual entre Dashboard y Lista de Hábitos.

---

### 9.3 Incremento 3.3: Módulo de Hábitos (UI)
Se desarrolló el flujo completo de gestión de hábitos (sin persistencia).
*   **Pantalla de Lista (`HabitsScreen`):** Muestra los hábitos activos y permite navegar a la creación.
*   **Formulario (`HabitFormScreen`):** Interfaz para definir título, descripción y frecuencia (días de la semana).
*   **Navegación:** Se integró el flujo `Dashboard -> Hábitos -> Nuevo Hábito`.

---

### 9.4 Incremento 3.4: Conexión de Datos (MVVM + Room)
Se implementó la persistencia y la lógica de negocio para el módulo de Hábitos.
*   **Base de Datos:**
    *   `HabitEntity`: Definición del hábito (título, descripción).
    *   `HabitScheduleEntity`: Días de la semana asociados (1:N).
    *   `HabitCheckEntity`: Historial de cumplimiento diario.
*   **Capa de Datos:**
    *   `HabitDao`: Transacciones para insertar hábitos y horarios. Uso de `HabitWithSchedules` (POJO) para consultas relacionales.
    *   `WellbeingRepositoryImpl`: Mapeo entre entidades y modelo de dominio.
*   **Capa de Presentación:**
    *   `HabitsViewModel`: Expone `StateFlow<List<Habit>>` observando la BD en tiempo real.
    *   `HabitFormViewModel`: Gestiona la creación de hábitos y la validación del formulario.
*   **Resultado:** La pantalla de hábitos ahora muestra datos reales de la base de datos local.

---

### 10. FASE 4: FUNCIONALIDAD AVANZADA (ESTADÍSTICAS Y EMOCIONES)

#### 10.1 Incremento 4.1: Módulo de Registro Emocional
Se implementó la capacidad de registrar el estado de ánimo diario, integrándolo con el Dashboard.
*   **Modelo de Datos:** Reutilización de `EmotionRecordEntity` y `EmotionIntensity` (Enum: LEVE, MODERADO, INTENSO).
*   **Lógica de Negocio:** `EmotionViewModel` gestiona el estado del formulario (`EmotionUiState`) y la inserción en BD mediante `StateFlow`, asegurando un flujo unidireccional de datos (UDF).
*   **Interfaz de Usuario:**
    *   `EmotionEntrySheet`: Componente *ModalBottomSheet* que permite seleccionar una emoción (de 8 básicas de Plutchik), intensidad y añadir una nota opcional.
    *   **Integración:** El botón flotante (+) del Dashboard ahora despliega este formulario.
*   **Resultado:** Los usuarios pueden registrar cómo se sienten, persistiendo el dato en Room para su posterior análisis.

---

#### 10.2 Incremento 4.2: Motor de Estadísticas
Se implementó el núcleo lógico y visual para el seguimiento del progreso del usuario.
*   **Arquitectura:**
    *   **Dominio:** UseCases puros (`CalculateStreakUseCase`, `GetWeeklyStatsUseCase`) para encapsular la lógica de cálculo de rachas y resúmenes.
    *   **Datos:** Nuevas consultas en `HabitCheckDao` y `EmotionDao` para filtrado por fechas.
*   **UI:** Pantalla `StatsScreen` que muestra de forma resumida:
    *   Racha actual y máxima.
    *   Resumen semanal de hábitos completados.
    *   Desglose de emociones registradas en la semana.
*   **Valor:** Proporciona feedback inmediato sobre la consistencia y el bienestar emocional del usuario.

---

#### 10.3 Incremento 4.3: Notificaciones y Ajustes
Se completó la funcionalidad de recordatorios locales para fomentar el hábito de registro diario.
*   **Estrategia Técnica:** Uso de `WorkManager` (PeriodicWorkRequest) por su fiabilidad y compatibilidad con optimizaciones de batería, frente a `AlarmManager`.
*   **Arquitectura:**
    *   `SettingsRepository`: Gestión de preferencias con DataStore.
    *   `DailyReminderWorker`: Tarea en segundo plano que desencadena la notificación.
    *   `SettingsViewModel`: Expone el estado de la preferencia a la UI.
*   **UI:** Nueva pantalla `SettingsScreen` con switch para activar/desactivar recordatorios, persistiendo la elección del usuario.
*   **Integración:** Inyección de dependencias optimizada para asegurar la creación del canal de notificaciones al inicio.

---

## 11. FASE 5: PRUEBAS Y VALIDACIÓN

### 11.1 Plan de Pruebas Manuales
Se ejecutó un plan de pruebas funcional para validar los flujos críticos de la aplicación antes de la entrega final. A continuación se detallan los resultados obtenidos en el entorno de pruebas (Emulador Android API 35).

| ID | Caso de Prueba | Resultado | Observaciones |
| :--- | :--- | :--- | :--- |
| **A1** | Crear registro emocional (emoción + intensidad + nota) | ✅ OK | Se guarda correctamente en Room. |
| **A2** | Validación de campos obligatorios | ✅ OK | El botón "Guardar" se mantiene deshabilitado hasta completar campos. |
| **A3** | Persistencia tras cerrar y reabrir la app | ✅ OK | Los datos se recuperan correctamente al reiniciar. |
| **B4** | Crear hábito nuevo | ✅ OK | Aparece inmediatamente en el Dashboard y la lista de Hábitos. |
| **B5** | Editar hábito existente | ✅ OK | Los cambios de título/descripción se reflejan en tiempo real. |
| **B6** | Eliminar hábito | ✅ OK | Desaparece de ambas listas y de la base de datos confirmada. |
| **B7** | Dashboard muestra hábitos del día correctamente | ✅ OK | Filtra por `dayOfWeek` correctamente según la fecha del sistema. |
| **C8** | Estadísticas muestran datos reales | ✅ OK | Gráficos y contadores coinciden con los registros de prueba. |
| **C9** | Estadísticas manejan estado vacío | ✅ OK | Se muestran contadores a 0 sin errores de ejecución (Crash). |
| **D10** | Activar notificación | ✅ OK | Worker programado exitosamente (verificado en App Inspection). |
| **D11** | Desactivar notificación | ✅ OK | Worker cancelado correctamente. |
| **D12** | Persistencia de configuración | ✅ OK | El switch mantiene su estado tras reiniciar la app (DataStore). |

### 11.2 Conclusiones de las Pruebas
La aplicación demuestra estabilidad en los flujos principales. No se han detectado errores críticos (crashes) ni bloqueantes durante la sesión de validación. El manejo de estados vacíos y la persistencia funcionan según lo esperado.

---

*(Este documento es vivo y se actualizará progresivamente con el avance de las fases)*

