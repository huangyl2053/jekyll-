/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBB {

     export module RentaiNofuGimusha {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RentaiNofuGimusha";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType() + "_" + fieldName;
            }

            public RentaiNofuGimusha(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShikibetsuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShikibetsuCode"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            }

            public txtSyuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSyuryoYMD"));
            }

        }

     }

}

