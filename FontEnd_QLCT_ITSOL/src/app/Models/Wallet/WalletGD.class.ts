export class WalletGDClass {

    private _userId: number;
    private _name: string;

    private _userWalletId: number;
    private _role: number;

    private _walletId: number;
    private _walletName: string;
    private _balance: number;
    private _currency: number;
    private _createDate: string;


    // tslint:disable-next-line:max-line-length
    constructor(userId: number, name: string, userWalletId: number, role: number, walletId: number, walletName: string, balance: number, currency: number, createDate: string) {
        this._userId = userId;
        this._name = name;
        this._userWalletId = userWalletId;
        this._role = role;
        this._walletId = walletId;
        this._walletName = walletName;
        this._balance = balance;
        this._currency = currency;
        this._createDate = createDate;
    }

    get walletName(): string {
        return this._walletName;
    }

    set walletName(value: string) {
        this._walletName = value;
    }

    get userId(): number {
        return this._userId;
    }

    set userId(value: number) {
        this._userId = value;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get userWalletId(): number {
        return this._userWalletId;
    }

    set userWalletId(value: number) {
        this._userWalletId = value;
    }

    get role(): number {
        return this._role;
    }

    set role(value: number) {
        this._role = value;
    }

    get walletId(): number {
        return this._walletId;
    }

    set walletId(value: number) {
        this._walletId = value;
    }

    get balance(): number {
        return this._balance;
    }

    set balance(value: number) {
        this._balance = value;
    }

    get currency(): number {
        return this._currency;
    }

    set currency(value: number) {
        this._currency = value;
    }

    get createDate(): string {
        return this._createDate;
    }

    set createDate(value: string) {
        this._createDate = value;
    }
}
