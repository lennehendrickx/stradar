import React, {Component} from "react";
import {stradarClient} from "../service/StradarClient";
import {Activity} from "../service/Activity";

type ActivitiesState = {
    activities: Activity[]
}

export class Activities extends Component<{}, ActivitiesState> {
    readonly state: ActivitiesState = {activities: []};

    async componentDidMount() {
        const activities = await stradarClient.athleteClient.activities();
        this.setState({activities});
    }

    render() {
        return (
            <div>
                <h2>Activities</h2>
                <ul>
                    {this.state.activities.map(activity =>
                        <li>{activity.name}</li>
                    )}
                </ul>
            </div>)
    }
}