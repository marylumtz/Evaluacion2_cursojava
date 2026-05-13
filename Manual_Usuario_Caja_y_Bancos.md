# Manual de Usuario
## Módulo Caja y Bancos

---

## 1. Introducción
El módulo **Caja y Bancos** permite al usuario consultar, preparar, importar y revisar la información relacionada con movimientos bancarios dentro del sistema.

Este módulo forma parte del proceso de carga de información y está diseñado para facilitar el tratamiento de datos antes de su integración definitiva en el sistema.

Las principales acciones disponibles son:

- **Consultar**
- **Importar**
- **Reportes**

---

## 2. Objetivo del módulo
El objetivo del módulo **Caja y Bancos** es permitir que el usuario:

- prepare la información de bancos antes de su procesamiento,
- importe los registros al sistema,
- consulte el resultado del proceso,
- y revise reportes asociados a la información cargada.

---

## 3. Acceso al módulo
Para utilizar la funcionalidad de **Caja y Bancos**, el usuario debe ingresar al módulo de importación de datos y localizar la fila correspondiente a:

**Importar Caja y Bancos**

En esta sección se muestran:

- el nombre del proceso,
- el número de registros procesados,
- el número de registros no procesados,
- el botón **Importar**,
- el botón **Reportes**,
- y el botón **Consultar**.

---

## 4. Elementos de la pantalla
En la pantalla principal del módulo se muestran los siguientes elementos:

### 4.1 Nombre del proceso
Identifica el tipo de información que se va a trabajar, en este caso:

**Importar Caja y Bancos**

### 4.2 Registros procesados
Indica cuántos registros ya fueron importados correctamente al sistema.

### 4.3 Registros no procesados
Indica cuántos registros aún no han sido importados o se encuentran pendientes de procesamiento.

### 4.4 Botón Importar
Permite ejecutar el proceso de importación de la información preparada.

### 4.5 Botón Reportes
Permite visualizar el reporte asociado al proceso de importación de Caja y Bancos.

### 4.6 Botón Consultar
Permite consultar y actualizar la información de bancos disponible para ser importada.

---

## 5. Funcionamiento general
El flujo de uso recomendado del módulo es el siguiente:

1. **Consultar** la información disponible.
2. Verificar que existan registros listos para procesarse.
3. Ejecutar la opción **Importar**.
4. Revisar el resultado en **Reportes**.

Este orden permite asegurar que primero se preparen los datos, después se procesen y finalmente se revisen los resultados.

---

## 6. Procedimiento de uso

### 6.1 Consultar información
El botón **Consultar** se utiliza para actualizar o preparar la información que será importada posteriormente.

#### Pasos:
1. Ubique la fila **Importar Caja y Bancos**.
2. Presione el botón **Consultar**.
3. El sistema mostrará el mensaje:
   **“Ejecutando, por favor espere...”**
4. Espere a que el sistema complete la operación.
5. Una vez concluido el proceso:
   - el sistema mostrará un mensaje de éxito, o
   - indicará si no existen datos disponibles para migrar.
6. La pantalla se actualizará automáticamente.

#### Resultado esperado:
La información queda preparada en la tabla de importación y se actualizan los registros no procesados.

---

### 6.2 Importar información
El botón **Importar** se utiliza para procesar la información previamente consultada y almacenarla de manera definitiva en el sistema.

#### Pasos:
1. Verifique que existan registros pendientes en la columna de **no procesados**.
2. Presione el botón **Importar**.
3. El sistema ejecutará el servicio de importación de Caja y Bancos.
4. Espere a que finalice el proceso.
5. Al concluir, el sistema actualizará los registros procesados y no procesados.

#### Resultado esperado:
Los registros pendientes se integran al sistema como información bancaria válida.

---

### 6.3 Consultar reportes
El botón **Reportes** se utiliza para abrir el reporte relacionado con la importación de Caja y Bancos.

#### Pasos:
1. Ubique la fila **Importar Caja y Bancos**.
2. Presione el botón **Reportes**.
3. El sistema abrirá la pantalla de reporte correspondiente.
4. Revise la información mostrada para validar el resultado del proceso.

#### Resultado esperado:
El usuario podrá consultar evidencia o detalle del proceso de importación ejecutado.

---

## 7. Orden recomendado de uso
Para evitar errores y asegurar un procesamiento correcto, se recomienda seguir este orden:

1. **Consultar**
2. **Importar**
3. **Reportes**

### Explicación:
- **Consultar** prepara la información.
- **Importar** procesa la información preparada.
- **Reportes** permite revisar el resultado final.

---

## 8. Mensajes que puede mostrar el sistema

### 8.1 Ejecutando, por favor espere...
Este mensaje aparece mientras el sistema realiza la consulta o actualización de la información.

### 8.2 Migración de Bancos completada
Indica que el proceso de consulta y migración de información se realizó correctamente.

### 8.3 No hay datos para migrar
Este mensaje aparece cuando no existe información disponible para cargar desde la fuente de datos.

### 8.4 Actualización en curso, espere...
Este mensaje aparece cuando ya existe un proceso ejecutándose y el sistema bloquea una nueva solicitud.

### 8.5 Error al conectar con el servidor
Indica un problema de comunicación entre la interfaz y el servidor.

---

## 9. Recomendaciones de uso
Para un uso correcto del módulo, considere las siguientes recomendaciones:

- Antes de importar, ejecute siempre la opción **Consultar**.
- No presione varias veces el botón **Consultar** mientras el sistema está procesando.
- Espere a que la pantalla se actualice por completo antes de continuar.
- Revise los contadores de registros procesados y no procesados.
- Consulte el reporte después de importar para validar el resultado.
- Si el sistema indica que no hay datos para migrar, verifique con el área responsable de la carga de información.

---

## 10. Problemas frecuentes y solución

### Problema 1: No hay datos para importar
**Posible causa:** no existe información disponible en la fuente de datos.
**Solución:** verifique que los datos hayan sido cargados correctamente antes de ejecutar la consulta.

### Problema 2: El botón Consultar no responde
**Posible causa:** existe un proceso en curso o un problema de conexión.
**Solución:** espere unos segundos e intente nuevamente. Si el problema continúa, contacte al administrador del sistema.

### Problema 3: La importación no procesa registros
**Posible causa:** no existen registros pendientes o hubo un error en la preparación de datos.
**Solución:** ejecute nuevamente **Consultar** y verifique que existan registros no procesados.

### Problema 4: El reporte no muestra la información esperada
**Posible causa:** la importación aún no se ha ejecutado o no concluyó correctamente.
**Solución:** revise primero el resultado de la importación y después consulte nuevamente el reporte.

---

## 11. Buenas prácticas
Se recomienda que el usuario:

- valide primero que existan registros pendientes,
- ejecute los procesos en el orden correcto,
- conserve evidencia de los reportes cuando sea necesario,
- y reporte inmediatamente cualquier mensaje de error inesperado.

---

## 12. Conclusión
El módulo **Caja y Bancos** permite gestionar de forma ordenada la preparación, importación y consulta de información bancaria dentro del sistema.

Su operación se basa en tres acciones principales:

- **Consultar**, para preparar la información.
- **Importar**, para procesarla.
- **Reportes**, para revisar los resultados.

El uso adecuado de estas opciones garantiza un mejor control del proceso y una integración correcta de la información.
