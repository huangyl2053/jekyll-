/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiInput {

        export class Events {

            public static onChange_radNinteiKubun(): string {
                return "onChange_radNinteiKubun";
            }

            public static onClick_btnYokaigodoGuide(): string {
                return "onClick_btnYokaigodoGuide";
            }

            public static onClick_kaishiLostFocus(): string {
                return "onClick_kaishiLostFocus";
            }

            public static onClick_syuryoLostFocus(): string {
                return "onClick_syuryoLostFocus";
            }

            public static onClick_btnSixMonthLater(): string {
                return "onClick_btnSixMonthLater";
            }

            public static onClick_btnTwelveMonthLater(): string {
                return "onClick_btnTwelveMonthLater";
            }

            public static onClick_btnEigtheenMonthLater(): string {
                return "onClick_btnEigtheenMonthLater";
            }

            public static onClick_btnTwentyfourMonthLater(): string {
                return "onClick_btnTwentyfourMonthLater";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiInput.Controls.myType() + "_" + fieldName;
            }

            public NinteiInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public NinteiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiJoho"));
            }

            public radNinteiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinteiKubun"));
            }

            public chkMinashiKoshinNintei(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiKoshinNintei"));
            }

            public txtNinteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYMD"));
            }

            public txtYokaigodoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtYokaigodoCode"));
            }

            public btnYokaigodoGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnYokaigodoGuide"));
            }

            public txtYokaigodoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodoName"));
            }

            public txtYukoKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKaishiYMD"));
            }

            public txtYukoShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoShuryoYMD"));
            }

            public btnAfter6Month(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfter6Month"));
            }

            public btnAfter12Month(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfter12Month"));
            }

            public btnAfter18Month(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfter18Month"));
            }

            public btnAfter24Month(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfter24Month"));
            }

            public ServiceShitei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceShitei"));
            }

            public dgServiceIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceIchiran"));
            }

            public lblServiceIken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceIken"));
            }

            public txtShinsakaiIken(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            }

        }

     }

}

