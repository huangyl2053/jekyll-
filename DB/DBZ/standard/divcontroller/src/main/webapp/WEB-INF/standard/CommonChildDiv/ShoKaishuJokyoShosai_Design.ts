/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShoKaishuJokyoShosai {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuJokyoShosai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuJokyoShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShoKofuShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtYukoKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            }

            public txtKofuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            }

            public txtKofuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            }

            public txtKaishuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            }

            public ddlKaishuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            }

            public txtKaishuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            }

        }

     }

}

