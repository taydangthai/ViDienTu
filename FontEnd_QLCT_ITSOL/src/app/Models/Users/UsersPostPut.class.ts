export class UsersPostPutClass {
  private userWalletId: number;
  private userId: number;
  private walletId: number;
  private role: number;


  constructor(userWalletId: number, userId: number, walletId: number, role: number) {
    this.userWalletId = userWalletId;
    this.userId = userId;
    this.walletId = walletId;
    this.role = role;
  }

  get userWalletId2(): number {
    return this.userWalletId;
  }

  set userWalletId2(value: number) {
    this.userWalletId = value;
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

  get role2(): number {
    return this.role;
  }

  set role2(value: number) {
    this.role = value;
  }
}
