export class User {
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