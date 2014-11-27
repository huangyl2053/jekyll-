/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiJutakuKaishuhiInfo {

        export class Events {

            public static onClick_btnModify(): string {
                return "onClick_btnModify";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiJutakuKaishuhiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiJutakuKaishuhiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtJutakuOwner(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            }

            public txtRelationWithHihokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            }

            public dgJutakuKaishuDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));
            }

            public JutakuKaishuDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuDetail"));
            }

            public txtKaishuContents(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));
            }

            public txtKaishuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));
            }

            public txtKaishuTaishoAddress1(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuTaishoAddress1"));
            }

            public txtChakkoDueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));
            }

            public txtKanseiDueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));
            }

            public txtEstimatedAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));
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

            public txtPayTotalMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalMae"));
            }

            public cel23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel23"));
            }

            public txtHokenSeikyuAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountMae"));
            }

            public cel24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel24"));
            }

            public txtRiyoshaFutanAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            }

            public cel25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel25"));
            }

            public txtLimitOverAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountMae"));
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

            public txtPayTotalNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalNow"));
            }

            public cel33(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel33"));
            }

            public txtHokenSeikyuAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountNow"));
            }

            public cel34(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel34"));
            }

            public txtRiyoshaFutanAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            }

            public cel35(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel35"));
            }

            public txtLimitOverAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountNow"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

