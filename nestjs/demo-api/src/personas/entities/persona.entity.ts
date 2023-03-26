import { ApiProperty } from '@nestjs/swagger';
export class Persona {
  @ApiProperty({ example: '1' })
  id: number;
  @ApiProperty({ example: 'Jorge' })
  nombres: string;
  @ApiProperty({ example: 'Quintero' })
  apellidos: string;
}
