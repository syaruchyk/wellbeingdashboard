---
name: creador-de-skills
description: Genera nuevos skills para Antigravity siguiendo el estándar de calidad definido. Crea la estructura de carpetas, el SKILL.md y los recursos necesarios.
---

# Skill: Creador de Skills

## Cuándo usar este skill
- Cuando el usuario pida "créame un skill para X".
- Cuando el usuario quiera estandarizar un proceso frecuente.
- Cuando necesites convertir un prompt largo o una tarea repetitiva en un skill reutilizable.

## Inputs necesarios
1. **Objetivo del skill:** ¿Qué debe lograr?
2. **Contexto/Reglas:** ¿Hay guías de estilo, restricciones técnicas o PDFs de referencia?
3. **Nivel de libertad:** ¿Es un proceso creativo (alta), documental (media) o técnico/estricto (baja)?

## Workflow
1. **Analizar la solicitud:** Entender el propósito y los inputs disponibles.
2. **Consultar el estándar:** Leer `recursos/creador-de-skills-antigravity.md` para estructura y reglas.
3. **Diseñar el Skill:**
   - Definir nombre (kebab-case).
   - Redactar descripción y triggers.
   - Estructurar el workflow interno del nuevo skill.
   - Identificar recursos necesarios (separar lógica de datos).
4. **Generar archivos:** Crear la carpeta y archivos físicos (`SKILL.md`, recursos).
5. **Validar:** Verificar que cumple los principios de "nombre corto", "descripción clara" y "separación de responsabilidades".

## Instrucciones

### 1. Definición del Nombre y Estructura
Usa nombres cortos y descriptivos (ej. `analisis-seo`, `generador-componentes`). Evita nombres genéricos como `mi-skill`.
Crea siempre la carpeta en `agent/skills/<nombre>/`.

### 2. Creación del SKILL.md
Sigue estrictamente la plantilla del recurso estándar.
- **YAML:** name y description obligatorios.
- **Secciones:** Cuándo usar, Inputs, Workflow, Instrucciones, Output.

### 3. Manejo de Recursos
Si el skill requiere prompts largos, listas de palabras prohibidas, paletas de colores o reglas complejas, NO las pongas en `SKILL.md`. Crea un archivo en `recursos/` (ej. `recursos/guia-estilo.json`, `recursos/prompt-base.md`) y referéncialo.

### 4. Output Esperado
Tu salida debe ser la creación de los archivos. Confirma al usuario:
- Ruta creada: `agent/skills/<nombre>/`
- Archivos generados.
- Resumen de lo que hace el skill.

## Referencia
Para dudas sobre formato o principios, lee siempre:
`recursos/creador-de-skills-antigravity.md`
