/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBA {

     export module TekiyoJogaiRireki {

        export class Events {

            public static onClick_BtnAdd(): string {
                return "onClick_BtnAdd";
            }

            public static onClick_Selected(): string {
                return "onClick_Selected";
            }

            public static onClick_Update(): string {
                return "onClick_Update";
            }

            public static onClick_Delete(): string {
                return "onClick_Delete";
            }

            public static onBlur_TekiyoRireki(): string {
                return "onBlur_TekiyoRireki";
            }

            public static onBlur_KayijoRireki(): string {
                return "onBlur_KayijoRireki";
            }

            public static onBlur_Tekiyo(): string {
                return "onBlur_Tekiyo";
            }

            public static onBlur_Kayijo(): string {
                return "onBlur_Kayijo";
            }

            public static onClick_BtnKakunin(): string {
                return "onClick_BtnKakunin";
            }

            public static onClick_Torikeshi(): string {
                return "onClick_Torikeshi";
            }

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
                return this._myName + "_" + DBA.TekiyoJogaiRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.TekiyoJogaiRireki.Controls.myType() + "_" + fieldName;
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

            public txtKayijoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKayijoDate"));
            }

            public txtKaijoTodokedeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaijoTodokedeDate"));
            }

            public ddlKaijyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijyoJiyu"));
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

            //public ccdShisetsuJoho(): DBZ.ShisetsuJohoCommonChildDiv.ModeController {
            //    return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJoho"));
            //}

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

