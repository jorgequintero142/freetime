import { Body, Controller, Get, Post } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { ApiOperation } from '@nestjs/swagger/dist';
import { PersonaDto } from '../dtos/persona.dto';
import { Persona } from '../entities/persona.entity';
import { PersonasService } from '../services/personas.service';

@ApiTags('Personas')
@Controller('personas')
export class PersonasController {
  constructor(private personasService: PersonasService) {}

  @ApiOperation({ description: 'Listar todas las personas' })
  @Get()
  findAll() {
    return { personas: this.personasService.findAll() };
  }

  @ApiOperation({ description: 'Crear nueva persona' })
  @Post()
  create(@Body() payload: PersonaDto) {
    return { persona: this.personasService.create(payload) };
  }
}
