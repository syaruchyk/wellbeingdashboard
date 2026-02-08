---
name: systematic-debugging
description: Protocolo riguroso para la identificación, aislamiento y resolución de errores críticos.
---

# Protocolo Systematic Debugging

Este skill define el procedimiento estándar para abordar crashes, errores de compilación complejos o comportamientos inesperados.

## 1. Reproducción y Aislamiento
- **Confirmar síntoma:** ¿Crash al inicio? ¿Error de lógica? ¿Fallo visual?
- **Logs:** Obtener stacktrace completo (Logcat).
- **Entorno:** Confirmar dispositivo/emulador, versión de Android, y commit actual.

## 2. Análisis de Causa Raíz (RCA)
- **Hipótesis:** Generar 2-3 posibles causas.
- **Verificación Estática:** Revisar código sospechoso (inyección de dependencias, base de datos, nulos).
- **Verificación Dinámica:** Si es posible, añadir logs o test unitario que reproduzca el fallo.

## 3. Resolución
- **Plan de Corrección:** Definir los cambios mínimos necesarios.
- **Aplicación:** Modificar código.
- **Limpieza:** Revertir logs de debug o cambios temporales.

## 4. Verificación
- **Prueba de Humo:** Verificar que el error original desapareció.
- **Regresión:** Verificar que no se rompieron funcionalidades adyacentes.

## Checklist Común (Android/Hilt/Room)
- [ ] `@HiltAndroidApp` en Application class.
- [ ] `@AndroidEntryPoint` en Activities/Fragments.
- [ ] Entidades de Room añadidas a `database.entities`.
- [ ] DAOs añadidos a `AppDatabase`.
- [ ] Módulos de Hilt (`@Module`, `@InstallIn`) configurados correctamente.
- [ ] Manifest declara la Application class correcta.
- [ ] Versiones de dependencias compatibles.
