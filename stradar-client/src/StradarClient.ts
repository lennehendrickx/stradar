class HttpService {

    private _interceptors: RequestInterceptor[];

    constructor() {
        this._interceptors = [];
    }

    registerInterceptor(interceptor: RequestInterceptor) {
        this._interceptors.push(interceptor);
    }

    async fetch<T>(request: RequestInfo): Promise<T> {
        const response = await fetch(request);
        if (!response.ok) {
            // TODO: improve error handling
            this._interceptors.forEach(interceptor => interceptor.onErrorResponse(response));
            throw response;
        }
        return await response.json();

    }

}

class AuthClient {

    constructor(private _httpService: HttpService) {
    }

    redirectToStravaLogin() {
        window.location.replace('/oauth/login/strava');
    }

    async logout(): Promise<void> {
        try {
            const logoutRequest = new Request('/logout', {method: 'POST'});
            await this._httpService.fetch(logoutRequest);
        } catch (e) {
            if (e instanceof Response && e.status === 303) {
                window.location.reload();
            } else {
                throw e;
            }

        }
    }

}

class User {
    constructor(
        public username: String,
        public firstname: String,
        public lastname: String,
        public city: String,
        public country: String,
        public sex: String,
        public friendCount: Number,
        public followerCount: Number,
        public profile: String,
        public weight: Number) {
    }
}

class UserClient {

    constructor(private _httpService: HttpService) {
    }

    async user(): Promise<User> {
        return await this._httpService.fetch('/api/user');
    }

}

class Athlete {
    constructor(
        public username: String,
        public firstname: String,
        public lastname: String,
        public city: String,
        public country: String,
        public sex: String,
        public friendCount: Number,
        public followerCount: Number,
        public profile: String,
        public weight: Number) {
    }
}

class AthleteClient {
    constructor(private _httpService: HttpService) {
    }

    async activities(): Promise<Athlete[]> {
        return await this._httpService.fetch('/api/activities');
    }
}


interface RequestInterceptor {

    onErrorResponse(response: Response): void

}

class StradarClient {

    private _httpService: HttpService;
    private _authClient: AuthClient;
    private _userClient: UserClient;
    private _athleteClient: AthleteClient;

    constructor() {
        this._httpService = new HttpService();
        this._authClient = new AuthClient(this._httpService);
        this._userClient = new UserClient(this._httpService);
        this._athleteClient = new AthleteClient(this._httpService);
    }

    registerInterceptor(interceptor: RequestInterceptor) {
        this._httpService.registerInterceptor(interceptor);
    }

    get authClient(): AuthClient {
        return this._authClient;
    }

    get userClient(): UserClient {
        return this._userClient;
    }

    get athleteClient(): AthleteClient {
        return this._athleteClient;
    }
}

const stradarClient = new StradarClient();
export {
    stradarClient
}