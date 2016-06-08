/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module KaigoNinteiKekka {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNinteiKekka";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.KaigoNinteiKekka.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.KaigoNinteiKekka.Controls.myType() + "_" + fieldName;
            }

            public KaigoNinteiKekka(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShinseibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseibi"));
            }

            public txtShinseiKubunShinsei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));
            }

            public txtShinseiKubunHorei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHorei"));
            }

            public txtShinsaJun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsaJun"));
            }

            public ddlNinteiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiKubun"));
            }

            public txtIchijiHanteiKekka(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            }

            public ddlTokuteiShippei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));
            }

            public txtNinteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteibi"));
            }

            public ddlNijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            }

            public ddlJotaiZo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJotaiZo"));
            }

            public txtNinteiYukoKikanStart(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanStart"));
            }

            public lblKara3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara3"));
            }

            public txtNinteiYukoKikanEnd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanEnd"));
            }

            public ddlNinteiYukoTsukisu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiYukoTsukisu"));
            }

            public lblShinsakaiIken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            }

            public btnShinsaIkenTeikei(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShinsaIkenTeikei"));
            }

            public lblShinsakaiMemo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiMemo"));
            }

            public txtShinsakaiIken(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            }

            public txtShinsakaiMemo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiMemo"));
            }

        }

     }

}

