---
name: testing-quality
description: Definición y ejecución de pruebas funcionales y de lógica para validar la estabilidad, calidad y correcto funcionamiento del sistema.
---

# Skill: Testing & Quality Assurance

## Cuándo usar este skill
- Cuando necesites verificar el correcto funcionamiento de una funcionalidad (casos de uso).
- Cuando quieras asegurar la estabilidad del sistema antes de una entrega.
- Cuando el usuario solicite ejecutar pruebas manuales o automatizadas.
- Durante la fase de Integración y Pruebas del desarrollo.

## Inputs necesarios
- **Funcionalidad a probar:** Descripción clara del caso de uso o flujo.
- **Entorno:** Local (Debug/Release), Emulador o Dispositivo físico.
- **Tipo de prueba:** Unitarias, Instrumentadas (UI), o Manuales (checklist).
- **Criterios de aceptación:** Qué define el éxito de la prueba.

## Workflow
1.  **Analizar Requerimientos:** Entender qué se va a probar y cuáles son los resultados esperados.
2.  **Preparar Entorno:** Asegurar que la app compila y el entorno de pruebas está listo.
3.  **Definir Casos de Prueba:**
    - Identificar caminos felices (happy paths).
    - Identificar casos borde (edge cases) y errores.
4.  **Ejecutar Pruebas:**
    - **Automáticas:** Ejecutar `./gradlew test` (Unitarias) o `./gradlew connectAndroidTest` (Instrumentadas).
    - **Manuales:** Seguir paso a paso el flujo en la app e interactuar con la UI.
5.  **Reportar Resultados:** Documentar hallazgos, bugs y comportamiento observado.
6.  **Validar Correcciones:** Si hubo fallos, repetir el proceso tras la corrección.

## Instrucciones
- Prioriza las pruebas de los flujos críticos del negocio (Core Features).
- Documenta los bugs con pasos para reproducir (Steps to reproduce).
- No asumas que "compilar" significa "funcionar". Verifica la lógica en ejecución.
- Usa afirmaciones (assertions) claras en pruebas automáticas.

## Output (formato reporte)
```markdown
# Reporte de Pruebas: [Nombre Funcionalidad]

## Resumen
- **Estado:** ✅ PASÓ / ⚠️ CON OBSERVACIONES / ❌ FALLÓ
- **Fecha:** [Fecha]
- **Entorno:** [Dispositivo/Emulador - Versión Android]

## Resultados Detallados
| Caso de Prueba | Resultado Esperado | Resultado Actual | Estado |
| :--- | :--- | :--- | :--- |
| Login Correcto | Acceso al Home | Acceso al Home | ✅ |
| Contraseña vacía | Mensaje de error | App crasheó | ❌ |

## Bugs Encontrados
1.  [Descripción breve del bug critico]
2.  ...

## Conclusiones
[Comentario final sobre la estabilidad]
```
