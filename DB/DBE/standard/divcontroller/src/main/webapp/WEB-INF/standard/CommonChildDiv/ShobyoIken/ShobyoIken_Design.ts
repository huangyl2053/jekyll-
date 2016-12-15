/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="../../d.ts/URZCommonChildDiv.d.ts" />

module DBE {

     export module ShobyoIken {

        export class Events {

            public static onClick_tsuika(): string {
                return "onClick_tsuika";
            }

            public static onClick_double(): string {
                return "onClick_double";
            }

            public static onClick_syusei(): string {
                return "onClick_syusei";
            }

            public static onClick_sakujyo(): string {
                return "onClick_sakujyo";
            }

            public static onClick_btnNo(): string {
                return "onClick_btnNo";
            }

            public static onClick_btnOK(): string {
                return "onClick_btnOK";
            }

            public static onChange_antei(): string {
                return "onChange_antei";
            }

            public static onClick_btnCansel(): string {
                return "onClick_btnCansel";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShobyoIken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShobyoIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShobyoIken.Controls.myType() + "_" + fieldName;
            }

            public ShobyoIken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ShindanName(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShindanName"));
            }

            public txtShindanName1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName1"));
            }

            public txtShindanYMD1(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD1"));
            }

            public txtShindanName2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName2"));
            }

            public txtShindanYMD2(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD2"));
            }

            public txtShindanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName"));
            }

            public txtShindanYMD3(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD3"));
            }

            public geninShikkanPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("geninShikkanPanel"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgGenyin(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGenyin"));
            }

            public geninShikkanShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("geninShikkanShosai"));
            }

            public ccdCodeInputGeninShikkan(): URZ.CodeInput.ModeController {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdCodeInputGeninShikkan"));
            }

            public radIsShutaruGeninShikkan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIsShutaruGeninShikkan"));
            }

            public btnNo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNo"));
            }

            public btnOK(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOK"));
            }

            public ShojoAnteisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShojoAnteisei"));
            }

            public radShojoAnteisei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShojoAnteisei"));
            }

            public txtFuanteiShosaiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFuanteiShosaiJokyo"));
            }

            public SeikatsuKinoGenin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuKinoGenin"));
            }

            public lblChiryoNaiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChiryoNaiyo"));
            }

            public txtNaiyo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNaiyo"));
            }

            public btnCansel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCansel"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

