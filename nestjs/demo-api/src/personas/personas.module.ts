import { Module } from '@nestjs/common';
import { PersonasController } from './controllers/personas.controller';
import { PersonasService } from './services/personas.service';

@Module({
  controllers: [PersonasController],
  providers: [PersonasService]
})
export class PersonasModule {}
