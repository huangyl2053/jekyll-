/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiFukushiYoguKonyuhiInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiFukushiYoguKonyuhiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiFukushiYoguKonyuhiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            }

            public txtSeiriNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSeiriNo"));
            }

            public txtKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            }

            public dgYoguSeikyuDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgYoguSeikyuDetail"));
            }

            public YoguKonyuhiShikyuShinseiSeikyuDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            }

            public txtBuyYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            }

            public txtShumoku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShumoku"));
            }

            public txtShohinName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShohinName"));
            }

            public txtSeizoJigyosha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));
            }

            public txtHanbaiJigyosha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));
            }

            public txtBuyAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));
            }

            public txtHinmokuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));
            }

            public txtShinsaMethod(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsaMethod"));
            }

            public tblYoguSeikyuSummary(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblYoguSeikyuSummary"));
            }

            public celYogu11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu11"));
            }

            public lblYoguSummary(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguSummary"));
            }

            public celYogu12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu12"));
            }

            public lblYoguPayTotal(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguPayTotal"));
            }

            public celYogu13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu13"));
            }

            public lblYoguHokenSeikyuAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguHokenSeikyuAmount"));
            }

            public celYogu14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu14"));
            }

            public lblYoguRiyoshaFutanAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguRiyoshaFutanAmount"));
            }

            public celYogu15(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu15"));
            }

            public lblYoguLimitOverAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguLimitOverAmount"));
            }

            public celYogu21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu21"));
            }

            public lblYoguSummaryMae(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguSummaryMae"));
            }

            public celYogu22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu22"));
            }

            public txtYoguPayTotalMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalMae"));
            }

            public celYogu23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu23"));
            }

            public txtYoguHokenSeikyuAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountMae"));
            }

            public celYogu24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu24"));
            }

            public txtYoguRiyoshaFutanAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountMae"));
            }

            public celYogu25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu25"));
            }

            public txtYoguLimitOverAmountMae(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountMae"));
            }

            public celYogu31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu31"));
            }

            public lblYoguSummaryNow(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoguSummaryNow"));
            }

            public celYogu32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu32"));
            }

            public txtYoguPayTotalNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalNow"));
            }

            public celYogu33(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu33"));
            }

            public txtYoguHokenSeikyuAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountNow"));
            }

            public celYogu34(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu34"));
            }

            public txtYoguRiyoshaFutanAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountNow"));
            }

            public celYogu35(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celYogu35"));
            }

            public txtYoguLimitOverAmountNow(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountNow"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

