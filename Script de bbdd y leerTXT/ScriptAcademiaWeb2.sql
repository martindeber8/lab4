create database AcademiaWeb2
go
use AcademiaWeb2
go
create table Usuarios(
idUsuario int identity primary key,
nombreUsuario varchar(30) not null,
contraseña varchar(30) not null
);
create table Alumnos(
idAlumno int identity primary key,
documento varchar(15) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
alta bit not null
);
create table Cursos(
idCurso int identity primary key,
descripcion varchar(20) not null,
precio float not null,
imagen varchar(100),
alta bit not null
);
create table Matriculas(
idAlumno int not null foreign key references Alumnos(idAlumno),
idCurso int not null foreign key references Cursos(idCurso),
notaPrimerParcial int,
notaSegundoParcial int,
notaFinal int,
descuento float,
primary key (idAlumno, idCurso)
);
create table Programas(
idPrograma int identity primary key,
idAlumno int not null foreign key references Alumnos(idAlumno),
archivo varchar(200) not null,
descripcion varchar(200) not null,
habilitado bit not null,
cantidadDescargas int not null
);
go
INSERT INTO Usuarios VALUES ('admin', 'admin')

INSERT INTO Cursos VALUES ('JavaScript', 2500, 'JavaScript.png', 1)
INSERT INTO Cursos VALUES ('C#', 2000, 'Csharp.jpg', 1)
INSERT INTO Cursos VALUES ('HTML', 1000, 'HTML.jpg', 1)
INSERT INTO Cursos VALUES ('CSS', 1000, 'CSS.jpg', 1)
INSERT INTO Cursos VALUES ('JAVA', 1500, 'JAVA.jpg', 1)

INSERT INTO Alumnos VALUES('12345678','Juan','Perez', 1)
INSERT INTO Alumnos VALUES('87654321','Jose','Lopez', 1)
INSERT INTO Alumnos VALUES('91919191','Martin','Gonzalez', 1)
INSERT INTO Alumnos VALUES('27272727','Carlos','Martinez', 1)
INSERT INTO Alumnos VALUES('11111111','Pedro','Gerez', 1)
INSERT INTO Alumnos VALUES('22222222','Diego','Perez', 1)
INSERT INTO Alumnos VALUES('33333333','Raul','Gomez', 1)
INSERT INTO Alumnos VALUES('44444444','Juan','Gomez', 1)

INSERT INTO Programas VALUES (1, 'git-bash.exe', 'git-bash', 1, 15)
INSERT INTO Programas VALUES (2, 'git-cmd.exe', 'git-cmd', 1, 20)
INSERT INTO Programas VALUES (3, 'git-gui.exe', 'git-gui', 1, 10)
INSERT INTO Programas VALUES (4, 'git-lfs.exe', 'git-lfs', 1, 13)
INSERT INTO Programas VALUES (5, 'git.exe', 'git', 1, 7)
INSERT INTO Programas VALUES (6, 'unins000.exe', 'uninstallGit', 1, 1)
go
INSERT INTO Matriculas VALUES (1, 1, 6, 6, 7, 0)
INSERT INTO Matriculas VALUES (1, 2, 8, 6, 2, 0)
INSERT INTO Matriculas VALUES (2, 1, 6, 6, 2, 0)
INSERT INTO Matriculas VALUES (2, 3, 2, 2, 0, 0)
INSERT INTO Matriculas VALUES (3, 1, 2, 6, 2, 0)
INSERT INTO Matriculas VALUES (3, 4, 8, 8, 8, 0)
INSERT INTO Matriculas VALUES (4, 1, 2, 2, 0, 500)
INSERT INTO Matriculas VALUES (4, 5, 6, 4, 2, 1000)
INSERT INTO Matriculas VALUES (5, 2, 0, 0, 0, 500)
INSERT INTO Matriculas VALUES (6, 3, 0, 0, 0, 500)
INSERT INTO Matriculas VALUES (7, 4, 0, 0, 0, 500)
INSERT INTO Matriculas VALUES (8, 5, 0, 0, 0, 0)