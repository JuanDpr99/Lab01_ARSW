# Lab01_ARSW

# Laboratorio 1 - Arquitecturas de Software

Este repositorio contiene el código y experimentos realizados para el **Laboratorio No. 1** de la materia de Arquitecturas de Software del semestre 2024-2. El objetivo principal del laboratorio es explorar la implementación y manejo de hilos en Java, así como la optimización de tareas a través del paralelismo.

## Contenido

### Parte I: Hilos en Java
- **Objetivo:** Implementar y comprender el ciclo de vida de un hilo en Java.
- **Tareas:**
  - Implementar la clase `CountThread` que imprime números en un intervalo definido.
  ![image](https://github.com/user-attachments/assets/12e9914e-f9c4-4b18-af33-7a8825b6ae80)

  - Crear tres hilos que impriman en intervalos diferentes.
  ![image](https://github.com/user-attachments/assets/cece802c-1135-4b02-9d46-47e57ef7317b)

  - Comparar la ejecución usando `start()` y `run()`.
  ![image](https://github.com/user-attachments/assets/46214606-195f-47be-8e23-1014b3137780)


### Parte II:
- **Objetivo:** Implementar una solución paralela para la búsqueda de servidores maliciosos utilizando hilos.
- **Tareas:**
  - Crear una clase `Thread` que realice la búsqueda en segmentos.
  ![image](https://github.com/user-attachments/assets/419818a3-af06-41a8-ab59-92df2b81ee0f)

  - Dividir la búsqueda en N partes y paralelizar el proceso, implementar el método `join` para sincronizar la ejecución de hilos.
  ![image](https://github.com/user-attachments/assets/1479f4e5-1477-4c5e-b06f-6a9df080dfbf)


### Parte III: Evaluación de Desempeño
- **Objetivo:** Medir y analizar el rendimiento de la solución en diferentes escenarios de concurrencia.
- **Tareas:**
  - Realizar experimentos con diferentes cantidades de hilos.
    ●	Un solo hilo.
    ![image](https://github.com/user-attachments/assets/051b642b-9b01-407b-ae1b-77e40bd693ad)

    ●	Tantos hilos como núcleos de procesamiento (haga que el programa determine esto haciendo uso del API Runtime).
    ![image](https://github.com/user-attachments/assets/9b2241be-0373-4d82-a95d-a6be292fb266)

    ●	Tantos hilos como el doble de núcleos de procesamiento.
    ![image](https://github.com/user-attachments/assets/8cc0145a-88de-427f-86ce-2fa3a6f805f0)

    ●	50 hilos.
    ![image](https://github.com/user-attachments/assets/ff5f0226-8ec7-4416-b8bf-278bb80fcb84)

    ●	100 hilos.
    ![image](https://github.com/user-attachments/assets/1466ae46-491a-48c1-8c4d-7f658402aef0)

  - Medir el uso de CPU y memoria en cada caso.
    ![image](https://github.com/user-attachments/assets/ec07984d-0bb1-4696-8ddf-cb3bef27480e)

  - Analizar los resultados basados en la Ley de Amdahl.

### Analisis

![image](https://github.com/user-attachments/assets/a8fc8ada-61dd-4b03-8b31-e71ee3dcabe1)

A medida que aumentamos el número de hilos, se  espera una mejora en el rendimiento. Sin embargo, la Ley de Amdahl muestra que esta mejora no es lineal y tiene un límite, debido a la parte del código que no se puede paralelizar.
El rendimiento mejora a medida que agregas más hilos, pero después de un cierto punto, agregar más hilos solo resulta en una pequeña mejora adicional. Esto se debe a la fracción    (1 - P) que no se puede paralelizar. Incluso si usas 500 hilos, esa parte del proceso siempre se ejecutará de manera secuencial, limitando la aceleración total.

![image](https://github.com/user-attachments/assets/8d3db0f6-3843-477b-86ec-216eb6d73e57)

De acuerdo con nuestra gráfica, observamos que al duplicar el número de núcleos a 16, el desempeño mejoró proporcionalmente, logrando un rendimiento dos veces superior al inicial con 8 núcleos.

![image](https://github.com/user-attachments/assets/c1c16012-77dc-46b8-9eeb-f55281a77daa)

![image](https://github.com/user-attachments/assets/dc80a266-4626-4a26-a52a-b725bac7bcf0)

Usar 1 hilo en cada una de las 100 máquinas hipotéticas:
Teóricamente, la Ley de Amdahl se aplica mejor aquí porque cada máquina ejecuta su hilo de forma independiente, reduciendo la contención de recursos. No obstante, el rendimiento real también dependerá de la eficiencia de la comunicación y sincronización entre las máquinas.
 
Usar c hilos en 100/c máquinas distribuidas:
Si se optimiza bien la ejecución paralela dentro de cada máquina y se minimizan las sobrecargas de sincronización, es probable que se obtenga una mejora en el rendimiento. Sin embargo, como en el primer escenario, la eficiencia de la comunicación entre máquinas sigue siendo un factor crucial.




