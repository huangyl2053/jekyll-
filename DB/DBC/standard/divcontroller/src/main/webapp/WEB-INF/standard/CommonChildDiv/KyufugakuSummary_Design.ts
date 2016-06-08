/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyufugakuSummary {

        export class Events {

            public static onClick_btnRireki(): string {
                return "onClick_btnRireki";
            }

            public static onClick_btnCheckGendogaku(): string {
                return "onClick_btnCheckGendogaku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyufugakuSummary";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyufugakuSummary.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyufugakuSummary.Controls.myType() + "_" + fieldName;
            }

            public KyufugakuSummary(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tblSeikyuSummary(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            }

            public cel11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel11"));
            }

            public lblSummary(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSummary"));
            }

            public cel12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel12"));
            }

            public lblHiyoTotal(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHiyoTotal"));
            }

            public cel13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel13"));
            }

            public lblHokenTaishoHiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));
            }

            public cel14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel14"));
            }

            public lblHokenKyufuAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));
            }

            public cel15(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel15"));
            }

            public lblRiyoshaFutanAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            }

            public cel21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel21"));
            }

            public lblSummaryMae(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            }

            public cel22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel22"));
            }

            public txtHiyoTotalMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalMae"));
            }

            public cel23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel23"));
            }

            public txtHokenTaishoHiyoMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoMae"));
            }

            public cel24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel24"));
            }

            public txtHokenKyufuAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountMae"));
            }

            public cel25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel25"));
            }

            public txtRiyoshaFutanAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            }

            public cell26(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cell26"));
            }

            public btnRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRireki"));
            }

            public cel31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel31"));
            }

            public lblSummaryNow(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            }

            public cel32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel32"));
            }

            public txtHiyoTotalNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalNow"));
            }

            public cel33(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel33"));
            }

            public txtHokenTaishoHiyoNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoNow"));
            }

            public cel34(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel34"));
            }

            public txtHokenKyufuAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountNow"));
            }

            public cel35(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel35"));
            }

            public txtRiyoshaFutanAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            }

            public cel36(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel36"));
            }

            public btnLimitOverCheck(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            }

        }

     }

}

