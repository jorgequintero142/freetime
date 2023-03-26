import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { PersonasModule } from './personas/personas.module';

@Module({
  imports: [PersonasModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
