import axios from 'axios';
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';


const root = ReactDOM.createRoot(document.getElementById('root'));

class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { msg: '' };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    let file = event.target.files[0];
    const form = new FormData();
    form.append("file", file);
    var that = this;
    axios.post("http://localhost:8083/api/v1/upload", form, {
      headers: { "Content-Type": "multipart/form-data", 'Access-Control-Allow-Origin': '*' }
    }).then((r) => {
      this.setState({ msg: "File has been uploaded" });
    }).catch((e) => {
      this.setState({ msg: "File has been uploaded" });
    });
  }

  handleSubmit(event) {
    event.preventDefault();
  }

  render() {
    return (
      <div><label>{this.state.msg}</label><br /><form onSubmit={this.handleSubmit}>

        <label>
          Name:
          <input type="file" id="file-upload" onChange={this.handleChange} />
        </label>
        <input type="submit" value="Submit" />

      </form></div>
    );
  }
}
root.render(<NameForm />);