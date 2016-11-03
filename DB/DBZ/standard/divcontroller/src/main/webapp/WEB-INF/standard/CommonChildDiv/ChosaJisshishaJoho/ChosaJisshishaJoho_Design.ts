/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ChosaJisshishaJoho {

        export class Events {

            public static onBlur_txtShozokuKikanCode(): string {
                return "onBlur_txtShozokuKikanCode";
            }

            public static onOkClose_btnChosaItakusakiGuide(): string {
                return "onOkClose_btnChosaItakusakiGuide";
            }

            public static onClick_btnChosaItakusakiGuide(): string {
                return "onClick_btnChosaItakusakiGuide";
            }

            public static onChange_ddlChosaJisshiBasho(): string {
                return "onChange_ddlChosaJisshiBasho";
            }

            public static onBlur_txtKinyushaCode(): string {
                return "onBlur_txtKinyushaCode";
            }

            public static onOkClose_btnChosainGuide(): string {
                return "onOkClose_btnChosainGuide";
            }

            public static onClick_btnChosainGuide(): string {
                return "onClick_btnChosainGuide";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaJisshishaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType() + "_" + fieldName;
            }

            public ChosaJisshishaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNinteiShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDate"));
            }

            public txtChosaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaKubun"));
            }

            public txtShozokuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShozokuKikanCode"));
            }

            public btnChosaItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusakiGuide"));
            }

            public txtShozokuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShozokuKikanName"));
            }

            public txtChosaJisshiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtChosaJisshiDate"));
            }

            public ddlChosaJisshiBasho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            }

            public txtJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJisshiBashoMeisho"));
            }

            public txtKinyushaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyushaCode"));
            }

            public btnChosainGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            }

            public txtKinyushaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyushaName"));
            }

        }

     }

}

