process.env.NODE_ENV = 'test';


let api = require('../index');
let chai = require('chai');
let chaiHttp = require('chai-http');
let should = chai.should();



chai.use(chaiHttp);

describe('Countries', () => {

  describe('/GET countries', () => {
    it('it should GET all the countries', (done) => {
      chai.request(api)
        .get('/')
        .end((err, res) => {
          res.should.have.status(200);
          Object.keys(res.body).length.should.be.eql(251);
          done();
        });
    });
  });
});