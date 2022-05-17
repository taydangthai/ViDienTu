export class TransactionsPostPutClass {

  // sai ở đây
  // tự chuyển về bằng tay chứ sao nữa ông
  // tslint:disable-next-line:variable-name
  private transId: number;
  // tslint:disable-next-line:variable-name
  private amount: number;
  // tslint:disable-next-line:variable-name
  private dateTime: string;
  // tslint:disable-next-line:variable-name
  private note: string;
  // tslint:disable-next-line:variable-name
  private transType: number;
  // tslint:disable-next-line:variable-name
  private userId: number;
  // tslint:disable-next-line:variable-name
  private walletId: number;
  // tslint:disable-next-line:variable-name
  private categoryId: number;


  // tslint:disable-next-line:max-line-length
  constructor(transId: number, amount: number, dateTime: string, note: string, transType: number, userId: number, walletId: number, categoryId: number) {
    this.transId = transId;
    this.amount = amount;
    this.dateTime = dateTime;
    this.note = note;
    this.transType = transType;
    this.userId = userId;
    this.walletId = walletId;
    this.categoryId = categoryId;
  }

  get transId2(): number {
    return this.transId;
  }

  set transId2(value: number) {
    this.transId = value;
  }

  get amount2(): number {
    return this.amount;
  }

  set amount2(value: number) {
    this.amount = value;
  }

  get dateTime2(): string {
    return this.dateTime;
  }

  set dateTime2(value: string) {
    this.dateTime = value;
  }

  get note2(): string {
    return this.note;
  }

  set note2(value: string) {
    this.note = value;
  }

  get transType2(): number {
    return this.transType;
  }

  set transType2(value: number) {
    this.transType = value;
  }

  get userId2(): number {
    return this.userId;
  }

  set userId2(value: number) {
    this.userId = value;
  }

  get walletId2(): number {
    return this.walletId;
  }

  set walletId2(value: number) {
    this.walletId = value;
  }

  get categoryId2(): number {
    return this.categoryId;
  }

  set categoryId2(value: number) {
    this.categoryId = value;
  }
}
