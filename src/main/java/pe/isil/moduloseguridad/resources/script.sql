create database EP1;

use EP1;

create table Empleado (
	id int auto_increment,
	nombre varchar(45),
	apellido varchar(45),
	pais varchar(20),
	primary key(id)
);

/*Procedimiento almacenado*/
-- insert 

create procedure insertar_empleado(
	in p_nombre varchar(45),
	in p_apellido varchar(45),
	in p_pais varchar(20)
)
begin
	insert into empleado (nombre,apellido,pais) 
	values (p_nombre,p_apellido,p_pais);
end;

call insertar_empleado('Lucas', 'Lopez', 'Peru') ;

select * from empleado e ;

delete from empleado where id = ;

update empleado set nombre = 'Pablo',apellido ='Escalante',pais ='Chile' where id =2;