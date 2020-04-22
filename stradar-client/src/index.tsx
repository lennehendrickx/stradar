import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter} from 'react-router-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {stradarClient} from "./service/StradarClient";

stradarClient.registerInterceptor({
    onErrorResponse(response: Response): void {
        console.log(`Intercepted error response with status [${response.status}]`)
        if (response.status === 401) {
            stradarClient.authClient.redirectToStravaLogin();
        }
    }
});

ReactDOM.render(
  <React.StrictMode>
      <BrowserRouter>
        <App />
      </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
