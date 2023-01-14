//process.env.NODE_ENV = 'test';
let chaiHttp = require('chai-http');
let api = require('../index');
let chai = require('chai');

let should = chai.should();
chai.use(chaiHttp);

describe('Countries', () => {
  describe('/GET countries', () => {
    it('it should GET all the countries', (done) => {
      chai.request(api.app)
        .get('/')
        .end((err, res) => {
          res.should.have.status(200);
          Object.keys(res.body).length.should.be.eql(25);
          done();
        });
    });
    after(async () => {
      api.server.close();
    });
  });
});