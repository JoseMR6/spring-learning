# spring-learning

Proyectos de curso de Spring Boot

## Configuración Spring Boot

Comprobar Versión de Java y Maven Instalada:

```
java --version
mvn -version
```

Instalar Java y Maven si no está instalado:

```
sudo apt install openjdk-17-jre-headless
sudo apt install maven
```

Si se utiliza Visual Studio se deben instalar las siguientes extensiones:

```
Extension Pack for Java
Spring Initializr Java Support
Spring Boot Dashboard
Spring Boot Tools
Spring Boot Extension Pack
```

Para Crear un nuevo proyecto de Spring Boot en Visual Studio se debe acceder a la `Command Palette` con `Ctrl+Shift+P` y escribir `Spring Initializr: Create a Maven Project`. Tras eso se va especificando la configuración básica del proyecto indicando la versión de Spring Boot (`3.3.4`), el lenguaje del proyecto (`Java`), el `Group Id` (`com.example`), el `Artifact Id` que también indicara el nombre de la carpeta raíz del proyecto, el tipo de empaquetado (`Jar`), la versión de Java instalada (`17`), las dependencias de Spring utilizadas y la carpeta donde se creara el proyecto. Una vez creada la carpeta del proyecto nuevo debe abrirse en Visual Studio para que se configure de forma automática.

Para ejecutar el proyecto localmente en VS se pulsa el botón `Run Java` de la esquina superior derecha estando situado en el fichero `Aplication.java` de la carpeta `main`.

Se puede acceder a al proyecto en ejecución a través del navegador mediante la url `http://localhost:8080/`.

## Configuración MySql

Instalar MySql:

```
sudo apt install mysql-server
```

Comprobar la versión:

```
mysql --version 
```

Comprobar si esta en ejecución:

```
systemctl status mysql
```

Crear usuario administrador en MySql:

```
sudo mysql
alter user 'root'@'localhost' identified with mysql_native_password by 'clave';
exit;
```

Si se quiere acceder a MySql mediante interfaz gráfica se puede instalar `mysql-workbench-community` desde `Ubuntu Software`. De esta forma se instala `MySQL Workbench`.

En `MySQL Workbench` se accede a las bases de datos locales mediante `Local instance`. Para ello se pedirá la contraseña del usuario root.

## Configuración Servicios

En caso de tener servicios que se inician automáticamente al iniciar la máquina como es el caso de MySql puede ser positivo para el rendimiento si se configuran para que solo se inicien de forma manual para evitar que consuman recursos extra en entornos de desarrollo. En mi caso estos servicios son `apache2` y `mysql`.

Comprobar el estado de estos servicios:

```
systemctl status apache2.service
systemctl status mysql.service
```

Parar servicios:

```
systemctl stop apache2.service
systemctl stop mysql.service
```

Iniciar servicios:

```
systemctl start apache2.service
systemctl start mysql.service
```

Desactivar el inicio automático:

```
sudo update-rc.d apache2 disable
sudo update-rc.d mysql disable
```

En el caso de MySql además hay que editar el fichero `/etc/init/mysql.conf` modificándolo con la siguiente línea y reiniciar:

```
start on (never and runlevel [2345])
```
