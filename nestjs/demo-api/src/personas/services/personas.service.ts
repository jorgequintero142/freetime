import { PersonaDto } from './../dtos/persona.dto';
import { Injectable } from '@nestjs/common';
import { Persona } from '../entities/persona.entity';

@Injectable()
export class PersonasService {
  private personas: Persona[];
  constructor() {
    this.personas = [];
  }

  findAll() {
    return this.personas;
  }
  create(payload: PersonaDto) {
    const newPersona = { ...payload };
    this.personas.push(newPersona);
    return newPersona;
  }
}
