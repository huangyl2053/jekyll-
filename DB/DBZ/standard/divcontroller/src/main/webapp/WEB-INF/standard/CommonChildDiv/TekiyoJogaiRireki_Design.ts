/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShisetsuJoho.ts" />

module DBZ {

     export module TekiyoJogaiRireki {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TekiyoJogaiRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.TekiyoJogaiRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.TekiyoJogaiRireki.Controls.myType() + "_" + fieldName;
            }

            public TekiyoJogaiRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public panelTekiyoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelTekiyoRireki"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public datagridTekiyoJogai(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("datagridTekiyoJogai"));
            }

            public panelTekiyoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelTekiyoInput"));
            }

            public txtTekiyoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtTekiyoTodokeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoTodokeDate"));
            }

            public ddlTekiyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            }

            public txtNyusyoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNyusyoDate"));
            }

            public txtKayijoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKayijoDate"));
            }

            public txtKaijoTodokedeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTodokedeDate"));
            }

            public ddlKaijyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijyoJiyu"));
            }

            public txtTaisyoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoDate"));
            }

            public panelTekiyoJokaiTekiInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelTekiyoJokaiTekiInput"));
            }

            public panelJogaisyaTekiyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelJogaisyaTekiyo"));
            }

            public txtNyusyoDateInput(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNyusyoDateInput"));
            }

            public txtTekiyoDateInput(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoDateInput"));
            }

            public txtTkyoTododkDateIn(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTkyoTododkDateIn"));
            }

            public ddlTekiyoJiyuInput(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyuInput"));
            }

            public ccdShisetsuJoho(): DBZ.ShisetsuJoho.ModeController {
                return new DBZ.ShisetsuJoho.ModeController(this.convFiledName("ccdShisetsuJoho"));
            }

            public panelTekiyoJokaiKaiJyoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelTekiyoJokaiKaiJyoInput"));
            }

            public panelJogaisyaKaijo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelJogaisyaKaijo"));
            }

            public txtTaisyoDateInput(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoDateInput"));
            }

            public txtKaijoDateInput(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoDateInput"));
            }

            public txtKaijoTododkDateIn(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTododkDateIn"));
            }

            public ddlKaijoJiyuInput(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyuInput"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnInputClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnInputClear"));
            }

        }

     }

}

