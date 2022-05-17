export class WalletPPClass {
    // @ts-ignore
    private walletId: number;
    // @ts-ignore
    private walletName: string;
    // @ts-ignore
    private balance: number;
    // @ts-ignore
    private currency: number;
    // @ts-ignore
    private createDate: string;

    private userId: number;


    constructor(walletId: number, walletName: string, balance: number, currency: number, createDate: string, userId: number) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.balance = balance;
        this.currency = currency;
        this.createDate = createDate;
        this.userId = userId;
    }

    get walletId2(): number {
        return this.walletId;
    }

    set walletId2(value: number) {
        this.walletId = value;
    }

    get walletName2(): string {
        return this.walletName;
    }

    set walletName2(value: string) {
        this.walletName = value;
    }

    get balance2(): number {
        return this.balance;
    }

    set balance2(value: number) {
        this.balance = value;
    }

    get currency2(): number {
        return this.currency;
    }

    set currency2(value: number) {
        this.currency = value;
    }

    get createDate2(): string {
        return this.createDate;
    }

    set createDate2(value: string) {
        this.createDate = value;
    }

    get userId2(): number {
        return this.userId;
    }

    set userId2(value: number) {
        this.userId = value;
    }
}
