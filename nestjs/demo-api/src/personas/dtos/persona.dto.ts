import { IsNotEmpty, IsInt, IsAlpha, Min, Max, Length } from 'class-validator';
import { ApiProperty } from '@nestjs/swagger';
export class PersonaDto {
  @ApiProperty({ example: 10001, minimum: 1000, maximum: 1000000000 })
  @IsInt({ message: 'numero de identificacion no presenta un formato valido' })
  @Min(1000, {
    message: 'numero de identificacion no se encuentra el rango permitido',
  })
  @Max(1000000000, {
    message: 'numero de identificacion supera el rango permitido',
  })
  id: number;

  @ApiProperty({ example: 'Jorge', minLength: 10, maxLength: 100 })
  @IsNotEmpty({ message: 'campo nombres es requerido' })
  @IsAlpha('es-ES', { message: 'campo nombres solo debe contener letras' })
  @Length(3, 50, {
    message: 'longitud de los nombres debe ser entre 3 y 50',
  })
  nombres: string;

  @ApiProperty({ example: 'Quintero', minLength: 10, maxLength: 100 })
  @IsNotEmpty({ message: 'campo apellidos es requerido' })
  @IsAlpha('es-ES', { message: 'campo apellidos solo debe contener letras' })
  @Length(3, 50, {
    message: 'longitud de los apellidos debe ser entre 3 y 50',
  })
  apellidos: string;
}
