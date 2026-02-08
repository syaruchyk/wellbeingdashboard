---
name: documentation-dam
description: Redacción, mantenimiento y coherencia de la memoria técnica DAM, manual de usuario y manual de instalación.
---

# Skill: Documentación DAM

## Cuándo usar este skill
- Cuando necesites generar o actualizar la Memoria Técnica del proyecto.
- Cuando debas redactar el Manual de Usuario o de Instalación.
- Cuando se añada una nueva funcionalidad importante que deba ser documentada.
- Para asegurar la coherencia entre el código implementado y la documentación entregada.

## Inputs necesarios
- **Código Fuente Actualizado:** Para reflejar fielmente la implementación técnica.
- **Guía Docente/Rúbrica DAM:** Requisitos específicos del centro de estudios (si los hay).
- **Audiencia:** Técnico (profesor/desarrollador) o Usuario Final.

## Workflow
1.  **Identificar Sección:** ¿Qué entregable se está trabajando? (Memoria, Manual Usuario, Anexos).
2.  **Recopilar Información Técnica:** Extraer detalles de arquitectura, tecnologías, diagramas (clases, uso) y decisiones de diseño del código.
3.  **Redactar Borrador:**
    - Usar lenguaje técnico preciso para la Memoria.
    - Usar lenguaje claro y paso a paso para el Manual de Usuario.
4.  **Revisar Coherencia:** Validar que lo escrito coincida con lo implementado (versiones, librerías, flujos).
5.  **Formato y Estilo:** Aplicar formato Markdown profesional, uso de negritas para énfasis y bloques de código cuando aplique.

## Instrucciones
- **Memoria Técnica:** Enfocarse en el "Cómo" y el "Por qué" de las decisiones técnicas (Arquitectura Clean, MVVM, Patrones).
- **Manual de Usuario:** Incluir capturas de pantalla (referencias) y explicaciones funcionales.
- **Manual de Instalación:** Detallar requisitos (Android Studio, JDK, SDK mínimo) y pasos de compilación.
- **Diagramas:** Sugerir código Mermaid para diagramas UML si es necesario.

## Output (formato documento)
```markdown
# [Título del Documento/Sección]

## Introducción
[Contexto breve]

## Contenido Principal
[Detalle técnico o funcional estructurado]
- Punto clave 1
- Punto clave 2

## Justificación Técnica (si aplica)
Se eligió [Tecnología] debido a...

## Referencias
- Archivos: [Lista de archivos relacionados]
```
