import React, {Component} from 'react';
import {Link, Route, Router, Switch} from 'react-router-dom';
import {createBrowserHistory} from "history";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {stradarClient, User} from "./service/StradarClient";
import {Home} from "./pages/Home";
import {Activities} from "./pages/Activities";

type UserState = {
    user?: User
}

export class App extends Component<{}, UserState> {
    readonly state: UserState = {};
    readonly customHistory = createBrowserHistory();

    async componentDidMount() {
        const user = await stradarClient.userClient.user();
        this.setState({user});
    }

    render() {
        const logoutButton = <a className="App-link" href={'/logout'}>Logout</a>

        return (
            <Router history={this.customHistory}>
                <div>
                    <h2>Welcome {this.state.user ? this.state.user.username : 'unknown user'}</h2>
                    <nav className="navbar navbar-expand-lg navbar-light bg-light">
                        <ul className="navbar-nav mr-auto">
                            <li><Link to={'/'} className="nav-link">Home</Link></li>
                            <li><Link to={'/activities'} className="nav-link">Activities</Link></li>
                        </ul>
                    </nav>
                    <Switch>
                        <Route exact path='/' component={Home}/>
                        <Route path='/activities' component={Activities}/>
                    </Switch>
                </div>
            </Router>
        )
    }
}

export default App;
