export class CategoryPostPutClass {
  // @ts-ignore
  private categoryId: number;
  // @ts-ignore
  private categoryName: string;


  constructor(categoryId: number, categoryName: string) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
  }

  get categoryId2(): number {
    return this.categoryId;
  }

  set categoryId2(value: number) {
    this.categoryId = value;
  }

  get categoryName2(): string {
    return this.categoryName;
  }

  set categoryName2(value: string) {
    this.categoryName = value;
  }
}

