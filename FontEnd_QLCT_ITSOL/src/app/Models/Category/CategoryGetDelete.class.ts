export class CategoryGetDeleteClass {
  private _categoryId: number;
  private _categoryName: string;


  get categoryId(): number {
    return this._categoryId;
  }

  set categoryId(value: number) {
    this._categoryId = value;
  }

  get categoryName(): string {
    return this._categoryName;
  }

  set categoryName(value: string) {
    this._categoryName = value;
  }


  constructor(categoryName: string) {
    this._categoryName = categoryName;
  }
}
