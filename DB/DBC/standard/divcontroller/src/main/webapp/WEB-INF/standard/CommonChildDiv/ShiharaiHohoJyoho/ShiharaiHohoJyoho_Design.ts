/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShiharaiHohoJyoho {

        export class Events {

            public static onClick_radMadoguti(): string {
                return "onClick_radMadoguti";
            }

            public static onBlur_txtStartYMD(): string {
                return "onBlur_txtStartYMD";
            }

            public static onBlur_txtEndYMD(): string {
                return "onBlur_txtEndYMD";
            }

            public static onClick_radKoza(): string {
                return "onClick_radKoza";
            }

            public static onChange_ddlKozaID(): string {
                return "onChange_ddlKozaID";
            }

            public static onClick_radJyryoinin(): string {
                return "onClick_radJyryoinin";
            }

            public static onBlur_txtKeiyakuNo(): string {
                return "onBlur_txtKeiyakuNo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShiharaiHohoJyoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShiharaiHohoJyoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShiharaiHohoJyoho.Controls.myType() + "_" + fieldName;
            }

            public ShiharaiHohoJyoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radMadoguti(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMadoguti"));
            }

            public txtShiharaiBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            }

            public txtStartYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtStartYMD"));
            }

            public txtStartYobi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtStartYobi"));
            }

            public txtStartHHMM(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartHHMM"));
            }

            public txtEndYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtEndYMD"));
            }

            public txtEndYobi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtEndYobi"));
            }

            public txtEndHHMM(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndHHMM"));
            }

            public linMadoguti(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linMadoguti"));
            }

            public radKoza(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKoza"));
            }

            public ddlKozaID(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKozaID"));
            }

            public btnKozaToroku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKozaToroku"));
            }

            public txtKinyuKikanCode(): UZA.TextBoxKinyuKikanCode {
                return new UZA.TextBoxKinyuKikanCode(this.convFiledName("txtKinyuKikanCode"));
            }

            public txtKinyuKikanShitenCode(): UZA.TextBoxKinyuKikanShitenCode {
                return new UZA.TextBoxKinyuKikanShitenCode(this.convFiledName("txtKinyuKikanShitenCode"));
            }

            public txtTenban(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTenban"));
            }

            public txtYokinShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokinShubetsu"));
            }

            public txtKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            }

            public txtKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            }

            public txtMeigininKana(): UZA.TextBoxAtenaKanaMeisho {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtMeigininKana"));
            }

            public ttxtMeigininKanji(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("ttxtMeigininKanji"));
            }

            public linKoza(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linKoza"));
            }

            public radJyryoinin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJyryoinin"));
            }

            public txtKeiyakuNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKeiyakuNo"));
            }

            public btnSelect(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSelect"));
            }

            public txtKeiyakuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKeiyakuCode"));
            }

            public txtKeiyakuName(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtKeiyakuName"));
            }

            public txtKinyuKikanCode1(): UZA.TextBoxKinyuKikanCode {
                return new UZA.TextBoxKinyuKikanCode(this.convFiledName("txtKinyuKikanCode1"));
            }

            public txtKinyuKikanShitenCode1(): UZA.TextBoxKinyuKikanShitenCode {
                return new UZA.TextBoxKinyuKikanShitenCode(this.convFiledName("txtKinyuKikanShitenCode1"));
            }

            public txtTenban1(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTenban1"));
            }

            public txtYokinShubetsu1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokinShubetsu1"));
            }

            public txtKozaNo1(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo1"));
            }

            public txtKinyuKikanName1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName1"));
            }

            public txtMeigininKana1(): UZA.TextBoxAtenaKanaMeisho {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtMeigininKana1"));
            }

            public txtMeigininKanji1(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtMeigininKanji1"));
            }

        }

     }

}

