# _LAB4_ARSW_ 🚀
**_Integrantes:_**


* _Angie Daniela Ruiz Alfonso_
* _Juan Sebastian Díaz Salamanca_ 
## _Cinema Book System II_ 🎥
### _Parte I_
_GET para obtener todos los cines:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/1.png)


_GET para obtener un cine dado el nombre:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/2.png)


_GET para obtener todas las funciones dado el nombre del cine y la fecha:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/3.png)


_GET  para obtener todas las funciones dado el nombre del cine y una pelicula:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/4.png)
### _Parte II_
_POST para agregar una nueva función:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/5.png)


_PUT para actualizar una función ya existente:_
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/6.png)
### _Parte III_
  * _Qué condiciones de carrera se podrían presentar?: Es posible que dos personas compren el mismo asiento si lo hacen al tiempo, ya que para ambos la verificacion de asiento vacio va ser igual. Es posible que se compre un tiquete justo cuando alguien este consultando su disponibilidad y le arroje una disponibilidad erronea. Si se realiza una modificación en alguna función, se agrega alguna función o cinema, esto afectará cualquier otra operacion que dependa de ellas. _
  
  
  * _Cuales son las respectivas regiones críticas?: Operaciones sobre los cines, sus funciones y sus asientos._
  
  
  * _Solución aplicada: Cambiamos la lista de funciones de un tipo ArrayList a una lista de tipo CopyOnWriteArrayList, el cual es thread-safe y en dodnde todas las operaciones mutativas como agregar, establecer, etc; Se implementan haciendo una copia nueva de la matriz subyacente. La lista de cinemas la cambiamos de un tipo ArrayList a una tipo ConcurrentHashMap el cual admite la concurrencia total de recuperaciones y una alta concurrencia esperada para las actualizaciones, lo cual es de vital importancia para nuestro ejercicio y no tengamos datos erroneos... No bloqueamos el acceso a las operaciones debido a la recomendación final del laboratorio, la cual dice que esto degradaría significativamente el desempeño de la API._
  
  
### Pruebas  
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB4_ARSW/master/img/7.png)
## _¡¡¡Compile and run instructions!!!_ 🛠️
**_Para compilar:_**
_maven package_


**_Para ejecutar las pruebas:_**
_mvn test_


**_Para ejecutar la clase principal:_** 
_mvn exec:java -Dexec.mainClass="edu.eci.arsw.cinema.Main"_


**_Y para probar el funcionamiento de las peticiones:_**
 * _mvn clean compile_
 * _mvn spring-boot:run_
