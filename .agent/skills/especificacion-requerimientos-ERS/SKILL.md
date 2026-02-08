---
name: especificacion-requerimientos-ERS
description: Genera documentos profesionales de Especificación de Requerimientos de Software (ERS) siguiendo estándares IEEE 830. Idea, planifica y documenta software.
---

# Generador de Especificación de Requerimientos de Software (IEEE 830)

## Cuándo usar esta habilidad
- **Planificar nuevas aplicaciones:** Documentar requerimientos antes de iniciar el desarrollo.
- **Documentar sistemas existentes:** Especificar funciones para sistemas actuales.
- **Especificaciones técnicas:** Crear documentación formal para stakeholders.
- **Alineación de equipos:** Asegurar que todos entiendan los requerimientos.
- **Industrias reguladas:** Producir documentación de cumplimiento formal.

## Inputs necesarios
1. **Información Esencial:**
   - Nombre y descripción del proyecto.
   - Requerimientos funcionales clave (qué debe hacer el sistema).
   - Tipos de usuarios y características.
   - Restricciones técnicas.
2. **Información Adicional (si aplica):**
   - Requerimientos no funcionales (rendimiento, seguridad, usabilidad).
   - Interfaces externas (APIs, hardware).
   - Prioridades (Crítica, Alta, Media, Baja).

## Workflow

### Paso 1: Recopilación de Información
Preguntar por los detalles esenciales si no se han proporcionado.
- "¿De qué trata tu aplicación?"
- "¿Cuáles son las funciones principales?"
- "¿Quién usará esta aplicación?"
- "¿Hay requerimientos de rendimiento o seguridad?"

### Paso 2: Crear Archivo de Configuración (Conceptual)
Organizar la información en una estructura lógica (simulando un JSON de configuración):
- **Introducción:** Propósito y alcance.
- **Descripción General:** Perspectiva, usuarios, restricciones.
- **Requerimientos:** Funcionales (con prioridades) y No Funcionales.
- **Características:** Desglose de funcionalidades.

### Paso 3: Generar Documento ERS
Producir el documento final en formato Markdown (compatible con conversión a DOCX/PDF), estandarizado según IEEE 830.

## Estructura del Documento Generado
El ERS incluirá las siguientes secciones estándar:

1. **Introducción:** Propósito, Alcance, Definiciones, Referencias.
2. **Descripción General:** Perspectiva del producto, funciones, usuarios, restricciones.
3. **Requerimientos Específicos:**
   - Funcionales (ej. RF-001) con Prioridad y Criterios de Aceptación.
   - No Funcionales (Rendimiento, Seguridad, Usabilidad).
4. **Características del Sistema:** Descripción detallada de features.
5. **Requerimientos de Interfaces Externas:** UI, Hardware, Software.
6. **Apéndices:** Documentación adicional.

## Reglas de Calidad
- **Especificidad:** Usa criterios medibles (ej. "Tiempo de respuesta < 2s").
- **Claridad:** Evita ambigüedades (ej. "El usuario debe verificar...", no "debería").
- **Priorización Consistente:**
  - **Crítica:** Indispensable.
  - **Alta:** Central para lanzamiento.
  - **Media:** Importante, diferible.
  - **Baja:** Opcional.
- **Criterios de Aceptación:** Define cómo se verificará cada requerimiento.

## Output (Formato Exacto)
Genera siempre un bloque de código Markdown con la estructura completa del ERS.

```markdown
# Especificación de Requerimientos de Software: [Nombre]

... (Contenido estructurado según IEEE 830) ...
```
