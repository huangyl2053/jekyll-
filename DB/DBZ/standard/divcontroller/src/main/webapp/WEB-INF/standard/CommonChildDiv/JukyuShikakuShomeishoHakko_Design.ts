/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JukyuShikakuShomeishoHakko {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyuShikakuShomeishoHakko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType() + "_" + fieldName;
            }

            public JukyuShikakuShomeishoHakko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtIdoYoteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYoteiDate"));
            }

            public txtYokaigoJotai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotai"));
            }

            public txtNinteiYukoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public lblNinteiShinsakaiIken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiShinsakaiIken"));
            }

            public txtNinteiShinsakaiIken(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinsakaiIken"));
            }

            public lblBiko(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblBiko"));
            }

            public txtBiko(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            }

            public chkJushoHihyoji(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJushoHihyoji"));
            }

        }

     }

}

