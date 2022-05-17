export class TokenClass {
    private token: string;

    constructor(token: string) {
        this.token = token;
    }

    get token2(): string {
        return this.token;
    }

    set token2(value: string) {
        this.token = value;
    }
}
