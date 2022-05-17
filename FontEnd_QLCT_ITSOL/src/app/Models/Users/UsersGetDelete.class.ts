export class UsersGetDeleteClass {
  private _userId: number;
  private _userName: string;
  private _name: string;
  private _password: string;
  private _phoneNumber: number;
  private _gender: number;
  private _pathAva: string;


  get userId(): number {
    return this._userId;
  }

  set userId(value: number) {
    this._userId = value;
  }

  get userName(): string {
    return this._userName;
  }

  set userName(value: string) {
    this._userName = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get phoneNumber(): number {
    return this._phoneNumber;
  }

  set phoneNumber(value: number) {
    this._phoneNumber = value;
  }

  get gender(): number {
    return this._gender;
  }

  set gender(value: number) {
    this._gender = value;
  }

  get pathAva(): string {
    return this._pathAva;
  }

  set pathAva(value: string) {
    this._pathAva = value;
  }


  constructor(userId: number, name: string, phoneNumber: number, gender: number, pathAva: string) {
    this._userId = userId;
    this._name = name;
    this._phoneNumber = phoneNumber;
    this._gender = gender;
    this._pathAva = pathAva;
  }
}
