export class AuthClass {
    private userName: string;
    private passWord: string;


    constructor(userName: string, passWord: string) {
        this.userName = userName;
        this.passWord = passWord;
    }

    get userName2(): string {
        return this.userName;
    }

    set userName2(value: string) {
        this.userName = value;
    }

    get passWord2(): string {
        return this.passWord;
    }

    set passWord2(value: string) {
        this.passWord = value;
    }
}
