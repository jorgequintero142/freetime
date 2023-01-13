import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Welcome from './Welcome';

const root = ReactDOM.createRoot(document.getElementById('root'));
const element = <Welcome  />;
root.render(element);