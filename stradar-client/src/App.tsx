import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {stradarClient} from "./StradarClient";

type User = {
    username: String
}

type UserState = {
    user?: User
}

stradarClient.registerInterceptor({
    onErrorResponse(response: Response): void {
        console.log(`Intercepted error response with status [${response.status}]`)
        if (response.status === 401) {
            stradarClient.authClient.redirectToStravaLogin();
        }
    }
});

export class App extends Component<{}, UserState> {
    readonly state: UserState = {};

    async componentDidMount() {
        const user = await stradarClient.userClient.user();
        this.setState({user});
    }

    render() {
        const logoutButton = <a className="App-link" href={'/logout'}>Logout</a>

        return (
            <div className="App">
                <header className="App-header">
                    <p>
                        Current user is {this.state.user ? this.state.user.username : 'Not logged in'}
                    </p>
                    {this.state.user ? logoutButton : ''}
                </header>
            </div>
        )
    }
}

export default App;
