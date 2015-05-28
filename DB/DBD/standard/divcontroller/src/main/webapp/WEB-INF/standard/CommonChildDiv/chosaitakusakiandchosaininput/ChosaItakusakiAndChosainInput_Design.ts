/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ChosaItakusakiAndChosainInput {

        export class Events {

            public static onBlurTxtchosaItakusaki(): string {
                return "onBlurTxtchosaItakusaki";
            }

            public static onClickBtnZenkaiFukusha(): string {
                return "onClickBtnZenkaiFukusha";
            }

            public static onBlurTxtChosaincode(): string {
                return "onBlurTxtChosaincode";
            }

            public static onClickBtnClear(): string {
                return "onClickBtnClear";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaItakusakiAndChosainInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.ChosaItakusakiAndChosainInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.ChosaItakusakiAndChosainInput.Controls.myType() + "_" + fieldName;
            }

            public ChosaItakusakiAndChosainInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtChosaItakusakiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCode"));
            }

            public btnChosaItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusakiGuide"));
            }

            public txtChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            }

            public btnChosainRenrakuJiko(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainRenrakuJiko"));
            }

            public btnZenkaiFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            }

            public txtChosainCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosainCode"));
            }

            public btnChosainGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            }

            public txtChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosainName"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

        }

     }

}

