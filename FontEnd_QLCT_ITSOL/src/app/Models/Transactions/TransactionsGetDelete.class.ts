export class TransactionsGetDeleteClass {
  private _transId: number;
  private _amount: number;
  private _dateTime: string;
  private _note: string;
  private _transType: number;
  private _userId: number;
  private _walletId: number;
  private _categoryId: number;
  private _name: string;
  private _walletName: string;
  private _categoryName: string;

  /*private int transId;
    private int amount;
    private String dateTime;
    private String note;
    private int transType;
    private String name;
    private String walletName;
    private String categoryName; */


  constructor(amount: number, dateTime: string, note: string, transType: number, name: string, walletName: string, categoryName: string) {
    this._amount = amount;
    this._dateTime = dateTime;
    this._note = note;
    this._transType = transType;
    this._name = name;
    this._walletName = walletName;
    this._categoryName = categoryName;
  }


  get transId(): number {
    return this._transId;
  }

  set transId(value: number) {
    this._transId = value;
  }

  get amount(): number {
    return this._amount;
  }

  set amount(value: number) {
    this._amount = value;
  }

  get dateTime(): string {
    return this._dateTime;
  }

  set dateTime(value: string) {
    this._dateTime = value;
  }

  get note(): string {
    return this._note;
  }

  set note(value: string) {
    this._note = value;
  }

  get transType(): number {
    return this._transType;
  }

  set transType(value: number) {
    this._transType = value;
  }

  get userId(): number {
    return this._userId;
  }

  set userId(value: number) {
    this._userId = value;
  }

  get walletId(): number {
    return this._walletId;
  }

  set walletId(value: number) {
    this._walletId = value;
  }

  get categoryId(): number {
    return this._categoryId;
  }

  set categoryId(value: number) {
    this._categoryId = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get walletName(): string {
    return this._walletName;
  }

  set walletName(value: string) {
    this._walletName = value;
  }

  get categoryName(): string {
    return this._categoryName;
  }

  set categoryName(value: string) {
    this._categoryName = value;
  }
}
