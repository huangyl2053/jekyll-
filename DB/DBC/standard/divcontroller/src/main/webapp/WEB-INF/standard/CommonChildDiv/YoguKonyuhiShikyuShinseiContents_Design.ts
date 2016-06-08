/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module YoguKonyuhiShikyuShinseiContents {

        export class Events {

            public static onClick_btnAddSeikyuDetail(): string {
                return "onClick_btnAddSeikyuDetail";
            }

            public static onClick_btnReflect(): string {
                return "onClick_btnReflect";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YoguKonyuhiShikyuShinseiContents";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiContents.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiContents.Controls.myType() + "_" + fieldName;
            }

            public YoguKonyuhiShikyuShinseiContents(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikyoYM"));
            }

            public txtSeiriNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));
            }

            public txtKyufuRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            }

            public YoguKonyuhiShikyuShinseiSeikyuDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            }

            public btnInputDetail(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnInputDetail"));
            }

            public dgSeikyuDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            }

            public YoguKonyuhiShikyuShinseiSeikyuDetailInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail_YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
            }

            public txtBuyYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            }

            public ddlShumoku(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShumoku"));
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

            public radShinsaMethod(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinsaMethod"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnAddSeikyuDetail(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddSeikyuDetail"));
            }

            public SeikyuSummary(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail_SeikyuSummary"));
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

            public lblPayTotal(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblPayTotal"));
            }

            public cel13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel13"));
            }

            public lblHokenSeikyuAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenSeikyuAmount"));
            }

            public cel14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel14"));
            }

            public lblRiyoshaFutanAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            }

            public cel15(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel15"));
            }

            public lblLimitOverAmount(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLimitOverAmount"));
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

            public cel36(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("cel36"));
            }

            public btnLimitOverCheck(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            }

            public YoguKonyuhiShikyuShinseishaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public txtUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            }

            public YoguKonyuhiShikyuShinseisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho_YoguKonyuhiShikyuShinseisha"));
            }

            public radShinseishaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            }

            public txtShinseishaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtAddress(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public btnSearchJigyosha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            }

            public YoguKonyuhiShikyuShinseiPaymentMethod(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod"));
            }

            public radPayMethod(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPayMethod"));
            }

            public URKoza(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod_URKoza"));
            }

            public txtKari1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKari1"));
            }

            public DBZJuryoinin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod_DBZJuryoinin"));
            }

            public txtKari2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKari2"));
            }

            public btnUpdateShikyuShinsei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdateShikyuShinsei"));
            }

            public btnCancelShikyuShinsei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancelShikyuShinsei"));
            }

        }

     }

}

