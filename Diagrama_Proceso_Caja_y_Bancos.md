# Diagrama y descripción del proceso
## Importación de información de Caja y Bancos

### Módulo
**Data Import / My Home**

### Proceso analizado
**Importar Caja y Bancos**

### Archivo de referencia
`opentaps/dataimport/webapp/dataimport/myhome/myHome.ftl`

---

# 1. Objetivo del proceso
Permitir al usuario **consultar, importar y revisar reportes** relacionados con la información de **Caja y Bancos**, dentro del módulo de importación del sistema.

Este proceso contempla tres acciones principales:

- **Consultar**
- **Importar**
- **Reportes**

---

# 2. Actores involucrados

## Usuario
Responsable de ejecutar cualquiera de las acciones disponibles en la pantalla:
- Consultar
- Importar
- Reportes

## Sistema
Responsable de:
- consultar los registros disponibles,
- ejecutar la migración de datos,
- procesar la importación,
- y mostrar los reportes asociados.

## Base de datos
Participa como origen y destino de información en las tablas relacionadas con:
- `cabafina`
- `data_import_bancos`
- `Bancos`

---

# 3. Entradas del proceso
Para la importación de Caja y Bancos, el sistema utiliza los siguientes parámetros:

- `organizationPartyId`
- `tipoClave`
- `eventoContable`
- `fechaContable`
- `descripcion`
- `tipoMovimiento`

Estos parámetros son enviados al servicio:

**`importBANCOS`**

---

# 4. Descripción general del proceso

Al ingresar a la pantalla principal de importación, el sistema muestra una fila correspondiente al proceso **Importar Caja y Bancos**. En dicha fila se presentan:

- el número de registros procesados,
- el número de registros no procesados,
- el botón **Importar**,
- el botón **Reportes**,
- y el botón **Consultar**.

Desde esta interfaz el usuario puede ejecutar cualquiera de las tres acciones, dependiendo de la necesidad operativa.

---

# 5. Flujo principal del proceso

## 5.1 Consulta de información
Cuando el usuario da clic en el botón **Consultar**, el sistema realiza una llamada asíncrona al endpoint:

`POST /api/actualizarBancos`

### Actividades realizadas:
1. Se deshabilita temporalmente el botón.
2. Se muestra el mensaje: **“Ejecutando, por favor espere...”**
3. El sistema valida si ya existe una ejecución en curso.
4. Se consulta si la tabla `cabafina` contiene datos disponibles para migración.
5. Si existen datos, se ejecuta la función SQL:
   `actualizar_data_import_bancos()`
6. La información es transferida hacia la tabla `data_import_bancos`.
7. El sistema obtiene los tipos de movimiento (`tipomov`) procesados.
8. Se contabilizan los registros migrados por tipo de movimiento.
9. Se muestra al usuario un mensaje de éxito o advertencia.
10. Finalmente, la pantalla se recarga.

### Resultado esperado:
La información queda preparada en la tabla de importación `data_import_bancos` para ser procesada posteriormente mediante el botón **Importar**.

---

## 5.2 Importación de información
Cuando el usuario da clic en el botón **Importar**, el sistema envía el formulario a:

`setServiceParameters`

con el servicio:

**`SERVICE_NAME=importBANCOS`**

### Actividades realizadas:
1. El sistema recibe los parámetros del servicio.
2. Se invoca la clase Java `ImportarBancos`.
3. Se valida que la organización exista.
4. Se valida que el evento contable esté configurado.
5. Se determina el tipo de clave aplicable.
6. Se leen los registros almacenados en `DataImportBancos`.
7. Se validan y transforman los datos.
8. Se construyen las líneas del motor contable.
9. Se construyen los registros finales de la entidad `Bancos`.
10. Se inicia una transacción.
11. Si no existen errores, los registros se guardan.
12. El sistema devuelve el resultado de la importación.

### Resultado esperado:
Los registros de la tabla temporal de importación son procesados y convertidos en información bancaria definitiva dentro del sistema.

---

## 5.3 Consulta de reportes
Cuando el usuario da clic en el botón **Reportes**, el sistema redirige a la ruta:

`setupReport?reportId=BANCOS&sectionName=myHome`

### Actividades realizadas:
1. El sistema identifica el `reportId` correspondiente a **BANCOS**.
2. Se carga la pantalla del reporte asociado.
3. El usuario puede visualizar el estado o resultado del proceso de importación.

### Resultado esperado:
El usuario obtiene evidencia y seguimiento del proceso ejecutado para Caja y Bancos.

---

# 6. Flujos alternos

## 6.1 No existen datos para consultar
Si durante la acción **Consultar** la tabla `cabafina` no contiene información, el sistema responde con un mensaje indicando que **ya no hay datos para migrar**.

### Resultado:
No se realiza migración y el usuario es notificado.

---

## 6.2 Existe una ejecución en curso
Si otro proceso de actualización de Bancos ya se encuentra ejecutándose, el sistema bloquea la nueva solicitud.

### Resultado:
Se devuelve un mensaje indicando que la actualización está en curso y que el usuario debe esperar.

---

## 6.3 Error de conexión
Si ocurre un problema de comunicación con el servidor durante la consulta, el sistema muestra un mensaje de error de conexión.

### Resultado:
El proceso no concluye y el usuario debe intentar nuevamente.

---

## 6.4 Error durante la importación
Si durante el proceso de importación se detecta información inválida, organización inexistente o evento contable no configurado, la importación no concluye correctamente.

### Resultado:
El sistema devuelve un error y evita guardar información inconsistente.

---

# 7. Reglas observadas en la interfaz

## 7.1 Actualización automática del contador
Al cargar la pantalla, el sistema consulta el contador actual de registros mediante:

`GET /api/actualizarBancos/contador`

Esto permite mostrar el valor actualizado en la columna de registros no procesados.

## 7.2 Bloqueo temporal del botón
El sistema utiliza almacenamiento local (`localStorage`) para registrar la última ejecución del botón **Consultar** mediante la clave:

`bancosConsulted`

Esto permite controlar periodos de espera entre ejecuciones, aunque en el código actual el bloqueo específico para Bancos aparece comentado parcialmente.

---

# 8. Salidas del proceso

Las principales salidas del proceso son:

- actualización del contador de registros,
- migración de datos desde `cabafina`,
- carga de registros en `data_import_bancos`,
- procesamiento de registros hacia la entidad `Bancos`,
- visualización de mensajes de éxito o error,
- generación o consulta de reportes asociados.

---

# 9. Diagrama de flujo del proceso

```mermaid
flowchart TD
    A[Usuario ingresa a la pantalla My Home] --> B[Se muestra la fila Importar Caja y Bancos]
    B --> C[El sistema consulta el contador actual]
    C --> D[GET /api/actualizarBancos/contador]
    D --> E[Actualiza cantidad de registros no procesados]

    E --> F{Acción seleccionada por el usuario}

    F -->|Consultar| G[Deshabilitar botón y mostrar mensaje de ejecución]
    G --> H[POST /api/actualizarBancos]
    H --> I{¿Existe ejecución en curso?}
    I -->|Sí| J[Mostrar mensaje de espera]
    I -->|No| K[Consultar datos en cabafina]
    K --> L{¿Hay datos para migrar?}
    L -->|No| M[Mostrar mensaje: no hay datos para migrar]
    L -->|Sí| N[Ejecutar actualizar_data_import_bancos()]
    N --> O[Actualizar data_import_bancos]
    O --> P[Contar registros por tipo de movimiento]
    P --> Q[Mostrar mensaje de éxito]
    Q --> R[Recargar pantalla]

    F -->|Importar| S[Enviar formulario con SERVICE_NAME=importBANCOS]
    S --> T[Invocar servicio importBANCOS]
    T --> U[Validar organización y evento contable]
    U --> V[Leer DataImportBancos]
    V --> W[Transformar registros]
    W --> X[Construir lineas contables y registros Bancos]
    X --> Y[Guardar en transacción]
    Y --> Z[Mostrar resultado de importación]

    F -->|Reportes| AA[Abrir setupReport]
    AA --> AB[Cargar reporte BANCOS]
    AB --> AC[Mostrar reporte al usuario]
```

---

# 10. Conclusión
El proceso **Importar Caja y Bancos** está compuesto por tres etapas funcionales claramente diferenciadas:

- **Consultar**, que prepara o migra información hacia la tabla de importación.
- **Importar**, que transforma y registra la información dentro del sistema.
- **Reportes**, que permite revisar el resultado del proceso ejecutado.

Este diseño separa la **carga previa de datos**, el **procesamiento de negocio** y la **consulta de resultados**, facilitando el control operativo del módulo.
