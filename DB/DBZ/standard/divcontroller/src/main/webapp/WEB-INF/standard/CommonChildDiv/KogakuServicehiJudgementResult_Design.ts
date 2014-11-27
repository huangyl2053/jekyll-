/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KogakuServicehiJudgementResult {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuServicehiJudgementResult";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            }

            public KogakuServicehiJudgementResult(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgJudgementResult(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            }

            public KogakuServicehiJudgementResultDetail1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            }

            public txtUketsukeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            }

            public txtHonninPaymentAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            }

            public txtKetteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            }

            public radShikyuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            }

            public txtsetaiShuyakuNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            }

            public txtShikyuAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            }

            public radIsKogakuAutoShokan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            }

            public KogakuServicehiJudgementResultDetail2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            }

            public txtBiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            }

            public radJudgementMethod(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            }

            public txtFushikyuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            }

        }

     }

}

