/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChosaItakusakiAndChosainInput {

        export class Events {

            public static onBlur_TxtChosaItakusakiCode(): string {
                return "onBlur_TxtChosaItakusakiCode";
            }

            public static onOKClose_BtnChosaItakusakiGuide(): string {
                return "onOKClose_BtnChosaItakusakiGuide";
            }

            public static onClick_BtnChosaItakusakiGuide(): string {
                return "onClick_BtnChosaItakusakiGuide";
            }

            public static onOKClose_btnChosainRenrakuJiko(): string {
                return "onOKClose_btnChosainRenrakuJiko";
            }

            public static onBefore_btnChosainRenrakuJiko(): string {
                return "onBefore_btnChosainRenrakuJiko";
            }

            public static onClick_BtnZenkaiFukusha(): string {
                return "onClick_BtnZenkaiFukusha";
            }

            public static onBlur_TxtChosainCode(): string {
                return "onBlur_TxtChosainCode";
            }

            public static onOKClose_BtnChosainGuide(): string {
                return "onOKClose_BtnChosainGuide";
            }

            public static onClick_BtnChosainGuide(): string {
                return "onClick_BtnChosainGuide";
            }

            public static onClick_BtnClear(): string {
                return "onClick_BtnClear";
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
                return this._myName + "_" + DBZ.ChosaItakusakiAndChosainInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaItakusakiAndChosainInput.Controls.myType() + "_" + fieldName;
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

