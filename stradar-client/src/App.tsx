import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

type User = {
  username: String
}

type UserState = {
  user: User
}

export class App extends Component<{}, UserState> {
  readonly state: UserState = {
    user: {
      username: 'Unknown'
    }
  };

  // After the component did mount, we set the state each second.
  async componentDidMount() {
    const response = await fetch(`/api/user`);
    const user = await response.json();
    this.setState({ user });
  }


  render() {
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              Current user is {this.state.user.username}
            </p>
            <a
                className="App-link"
                href="/oauth/login/strava">
              Login
            </a>
          </header>
        </div>
    )
  }
}

export default App;
