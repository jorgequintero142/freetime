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
  create(newPersona: Persona) {
    this.personas.push(newPersona);
    return newPersona;
  }
}
