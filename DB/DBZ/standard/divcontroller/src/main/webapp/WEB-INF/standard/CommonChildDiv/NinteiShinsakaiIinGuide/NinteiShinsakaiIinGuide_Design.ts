/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module NinteiShinsakaiIinGuide {

        export class Events {

            public static onOKClose_chosaItakusakiGuide(): string {
                return "onOKClose_chosaItakusakiGuide";
            }

            public static onBefore_chosaItakusakiGuide(): string {
                return "onBefore_chosaItakusakiGuide";
            }

            public static onOKClose_iryoKikanGuide(): string {
                return "onOKClose_iryoKikanGuide";
            }

            public static onBefore_iryoKikanGuide(): string {
                return "onBefore_iryoKikanGuide";
            }

            public static onOKClose_sonotaKikanGuide(): string {
                return "onOKClose_sonotaKikanGuide";
            }

            public static onBefore_sonotaKikanGuide(): string {
                return "onBefore_sonotaKikanGuide";
            }

            public static onClick_btnKensakku(): string {
                return "onClick_btnKensakku";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onClick_ShinsakaiIinIchiranDate(): string {
                return "onClick_ShinsakaiIinIchiranDate";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

            public static onClick_btnSaikensaku(): string {
                return "onClick_btnSaikensaku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinsakaiIinGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinsakaiIinGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public KensakuJokenInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJokenInput"));
            }

            public txtShinsakaiIinCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeFrom"));
            }

            public txtShinsakaiIinCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeTo"));
            }

            public txtShinsakaiIinName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            }

            public ddlSeibetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            }

            public ddlShinsainShikakuCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinsainShikakuCode"));
            }

            public txtKijunbi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunbi"));
            }

            public radKikan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKikan"));
            }

            public chkHaishi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHaishi"));
            }

            public pnlShosaiJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlShosaiJoken"));
            }

            public ccdHokensha(): DBZ.HokenshaList.ModeController {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokensha"));
            }

            public txtChosaItakusakiCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiCode"));
            }

            public btnChosaItakusaki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusaki"));
            }

            public txtChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            }

            public txtIryoKikanCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanCode"));
            }

            public btnIryoKikan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoKikan"));
            }

            public txtIryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            }

            public txtSonotaJigyoshaCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaJigyoshaCode"));
            }

            public btnSonotaJigyosha(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSonotaJigyosha"));
            }

            public txtSonotaJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaJigyoshaName"));
            }

            public txtMaxKensu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxKensu"));
            }

            public btnKensakku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensakku"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public ShinsakaiIinIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            }

            public dgShinsakaiIinIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnSaikensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaikensaku"));
            }

        }

     }

}

