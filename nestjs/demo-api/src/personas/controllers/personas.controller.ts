import { Body, Controller, Get, Post } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { ApiOperation, ApiResponse } from '@nestjs/swagger/dist';
import { PersonaDto } from '../dtos/persona.dto';
import { PersonasService } from '../services/personas.service';

@ApiTags('Personas')
@Controller('personas')
export class PersonasController {
  constructor(private personasService: PersonasService) {}

  @ApiOperation({ description: 'Listar todas las personas' })
  @ApiResponse({
    status: 200,
    description: 'Se han listado todas las personas ',
  })
  @Get()
  findAll() {
    return { personas: this.personasService.findAll() };
  }

  @ApiOperation({ description: 'Crear nueva persona' })
  @ApiResponse({
    status: 201,
    description: 'Se ha registrado una nueva persona',
  })
  @Post()
  create(@Body() payload: PersonaDto) {
    return { persona: this.personasService.create(payload) };
  }
}
