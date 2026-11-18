# Requerimientos — Serpientes y Escaleras

## 1. Requerimientos funcionales

### Tablero
- RF-01: El sistema debe representar un tablero de 100 casillas numeradas en zigzag (de izquierda a derecha y viceversa en filas alternas).
- RF-02: El tablero debe contener al menos 6 serpientes y 6 escaleras en posiciones fijas predefinidas.
- RF-03: El sistema debe calcular automáticamente el efecto de caer en la cabeza de una serpiente (retroceso) o en el inicio de una escalera (avance).

### Jugadores
- RF-04: El sistema debe permitir configurar entre 2 y 4 jugadores antes de iniciar la partida.
- RF-05: El sistema debe permitir asignar un nombre y un color/ficha distinto a cada jugador.
- RF-06: El sistema debe llevar el turno de forma rotativa entre los jugadores.

### Dado y movimiento
- RF-07: El sistema debe simular el lanzamiento de un dado de 6 caras (valores aleatorios de 1 a 6).
- RF-08: El sistema debe mover la ficha del jugador la cantidad de casillas obtenida en el dado.
- RF-09: Si el movimiento supera la casilla 100, la ficha no debe moverse (regla estándar: se necesita caer exacto en 100).

### Partida
- RF-10: El sistema debe declarar ganador al primer jugador que llegue exactamente a la casilla 100.
- RF-11: El sistema debe permitir iniciar una nueva partida sin cerrar la aplicación.
- RF-12: El sistema debe mostrar en pantalla de quién es el turno actual.

### Interfaz gráfica
- RF-13: El sistema debe mostrar visualmente el tablero, las fichas de los jugadores, las serpientes y las escaleras.
- RF-14: El sistema debe mostrar un botón para lanzar el dado y el resultado obtenido.
- RF-15: El sistema debe mostrar un panel de mensajes/eventos (ej. "Jugador 1 subió por una escalera").

## 2. Requerimientos no funcionales

- RNF-01: La interfaz debe responder a las acciones del usuario (lanzar dado, iniciar partida) en menos de 1 segundo.
- RNF-02: El código debe estar organizado siguiendo el patrón MVC, separado en paquetes modelo/vista/controlador.
- RNF-03: El sistema debe ejecutarse en cualquier equipo con Java 17 o superior instalado.
- RNF-04: El código debe estar versionado en Git con commits descriptivos y organizados por avance.
- RNF-05: La interfaz debe ser intuitiva, sin necesidad de instrucciones externas para jugar una partida básica.

## 3. Requerimientos por componente (resumen para el equipo)

| Componente | Responsable sugerido | Requerimientos relacionados |
|---|---|---|
| Modelo (Tablero, Dado, Serpiente, Escalera) | Por asignar | RF-01 a RF-03, RF-07 a RF-09 |
| Modelo (Jugador, Partida) | Por asignar | RF-04 a RF-06, RF-10 a RF-12 |
| Vista (Swing) | Por asignar | RF-13 a RF-15 |
| Controlador | Por asignar | Conecta todos los RF anteriores |