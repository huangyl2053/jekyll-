/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBU {

     export module HihokenshaShikakuHakko {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HihokenshaShikakuHakko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBU.HihokenshaShikakuHakko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBU.HihokenshaShikakuHakko.Controls.myType() + "_" + fieldName;
            }

            public HihokenshaShikakuHakko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radInjiIchi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radInjiIchi"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public ddlKofuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKofuJiyu"));
            }

            public txtYukoKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtNinteiYukoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public tabHihokenshaShikakuShosai(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabHihokenshaShikakuShosai"));
            }

            public tplGendoGaku(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplGendoGaku"));
            }

            public lblKubunShikyuGendoGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKubunShikyuGendoGaku"));
            }

            public txtKubunShikyuGendoKijunGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendoKijunGaku"));
            }

            public txtKyuhuYukoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuhuYukoKikan"));
            }

            public ShuruiShikyuGendoKijungaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShuruiShikyuGendoKijungaku"));
            }

            public dgShuruiShikyuGendoKijunGaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShuruiShikyuGendoKijunGaku"));
            }

            public tplShinsakaiIken(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShinsakaiIken"));
            }

            public lblShinsakaiIken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            }

            public txtShinsakaiIken(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            }

            public tplKyufuSeigen(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKyufuSeigen"));
            }

            public lblKyufuSeigen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigen"));
            }

            public tblKyuhuSeigen(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKyuhuSeigen"));
            }

            public celKyufuSeigenNaiyoTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyoTitle"));
            }

            public lblKyufuSeigenNaiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenNaiyo"));
            }

            public celKyufuSeigenKikanTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikanTitle"));
            }

            public lblKyufuSeigenKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenKikan"));
            }

            public celKyufuSeigenNaiyo1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo1"));
            }

            public txtKyufuSeigenNaiyo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo1"));
            }

            public celKyufuSeigenKikan1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan1"));
            }

            public txtKyufuSeigenKikan1(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan1"));
            }

            public celKyufuSeigenNaiyo2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo2"));
            }

            public txtKyufuSeigenNaiyo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo2"));
            }

            public celKyufuSeigenKikan2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan2"));
            }

            public txtKyufuSeigenKikan2(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan2"));
            }

            public celKyufuSeigenNaiyo3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo3"));
            }

            public txtKyufuSeigenNaiyo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo3"));
            }

            public celKyufuSeigenKikan3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan3"));
            }

            public txtKyufuSeigenKikan3(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan3"));
            }

            public tplShienJigyosha(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShienJigyosha"));
            }

            public lblShienJigyosha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShienJigyosha"));
            }

            public tblJigyosha(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblJigyosha"));
            }

            public celJigyoshaTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyoshaTitle"));
            }

            public lblJigyosha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblJigyosha"));
            }

            public celTodokedeDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDateTitle"));
            }

            public lblTodokedeDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTodokedeDate"));
            }

            public celJigyosha1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha1"));
            }

            public txtJigyosha1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha1"));
            }

            public celTodokedeDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate1"));
            }

            public txtTodokedeDate1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate1"));
            }

            public celJigyosha2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha2"));
            }

            public txtJigyosha2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha2"));
            }

            public celTodokedeDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate2"));
            }

            public txtTodokedeDate2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate2"));
            }

            public celJigyosha3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celJigyosha3"));
            }

            public txtJigyosha3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha3"));
            }

            public celTodokedeDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate3"));
            }

            public txtTodokedeDate3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate3"));
            }

            public tplShisetsuNyutaisho(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShisetsuNyutaisho"));
            }

            public lblKaigoHokensha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaigoHokensha"));
            }

            public tblShisetsuNyutaisho(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblShisetsuNyutaisho"));
            }

            public celShisetsuShuruiTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuShuruiTitle"));
            }

            public lblShisetsuShurui(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuShurui"));
            }

            public celNyushoShisetsuTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsuTitle"));
            }

            public lblNyushoShisetsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNyushoShisetsu"));
            }

            public celShisetsuNyushoDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDateTitle"));
            }

            public lblShisetsuNyushoDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuNyushoDate"));
            }

            public celShisetsuTaishoDateTitle(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDateTitle"));
            }

            public lblShisetsuTaishoDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuTaishoDate"));
            }

            public celShisetsuShurui1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui1"));
            }

            public txtShisetsuShurui1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui1"));
            }

            public celNyushoShisetsu1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu1"));
            }

            public txtNyushoShisetsu1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu1"));
            }

            public celShisetsuNyushoDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate1"));
            }

            public txtShisetsuNyushoDate1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate1"));
            }

            public celShisetsuTaishoDate1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate1"));
            }

            public txtShisetsuTaishoDate1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate1"));
            }

            public celShisetsuShurui2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui2"));
            }

            public txtShisetsuShurui2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui2"));
            }

            public celNyushoShisetsu2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu2"));
            }

            public txtNyushoShisetsu2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu2"));
            }

            public celShisetsuNyushoDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate2"));
            }

            public txtShisetsuNyushoDate2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate2"));
            }

            public celShisetsuTaishoDate2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate2"));
            }

            public txtShisetsuTaishoDate2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate2"));
            }

            public celShisetsuShurui3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui3"));
            }

            public txtShisetsuShurui3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui3"));
            }

            public celNyushoShisetsu3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu3"));
            }

            public txtNyushoShisetsu3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu3"));
            }

            public celShisetsuNyushoDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate3"));
            }

            public txtShisetsuNyushoDate3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate3"));
            }

            public celShisetsuTaishoDate3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate3"));
            }

            public txtShisetsuTaishoDate3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate3"));
            }

        }

     }

}

