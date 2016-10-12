/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

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
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType() + "_" + fieldName;
            }

            public HihokenshaShikakuHakko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public YukoKigenInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YukoKigenInfo"));
            }

            public btnTyokuzenRireki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTyokuzenRireki"));
            }

            public btnSaishin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaishin"));
            }

            public txtYukoKigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKigen"));
            }

            public txtKofuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

            public ddlKofuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKofuJiyu"));
            }

            public NinteiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiInfo"));
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtNinteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYMD"));
            }

            public txtNinteiYukoFromYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYukoFromYMD"));
            }

            public lblKara1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara1"));
            }

            public txtNinteiYukoToYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYukoToYMD"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public chkSeidoitsuseiShogai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeidoitsuseiShogai"));
            }

            public tabHihokenshaShikakuShosai(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabHihokenshaShikakuShosai"));
            }

            public tplGendoGaku(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplGendoGaku"));
            }

            public tblGendoGaku(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblGendoGaku"));
            }

            public celKubunGendoGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKubunGendoGaku"));
            }

            public KubunGendoGaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KubunGendoGaku"));
            }

            public txtKubunShikyuGendoKijunGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendoKijunGaku"));
            }

            public txtYukoFromYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoFromYMD"));
            }

            public lblKara(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara"));
            }

            public txtYukoToYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoToYMD"));
            }

            public celShuruiGendoKijungaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShuruiGendoKijungaku"));
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

            public celTekiyoStYMD(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD"));
            }

            public lblTekiyoStYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTekiyoStYMD"));
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

            public txtTodokedeYMD1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD1"));
            }

            public celTekiyoStYMD1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD1"));
            }

            public txtTekiyoStYMD1(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD1"));
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

            public txtTodokedeYMD2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD2"));
            }

            public celTekiyoStYMD2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD2"));
            }

            public txtTekiyoStYMD2(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD2"));
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

            public txtTodokedeYMD3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeYMD3"));
            }

            public celTekiyoStYMD3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTekiyoStYMD3"));
            }

            public txtTekiyoStYMD3(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoStYMD3"));
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

