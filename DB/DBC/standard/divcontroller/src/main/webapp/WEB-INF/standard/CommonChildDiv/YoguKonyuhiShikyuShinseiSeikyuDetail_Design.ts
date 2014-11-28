/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module YoguKonyuhiShikyuShinseiSeikyuDetail {

        export class Events {

            public static onSelectBySelectButton(): string {
                return "onSelectBySelectButton";
            }

            public static onSelectByModifyButton(): string {
                return "onSelectByModifyButton";
            }

            public static onSelectByDeleteButton(): string {
                return "onSelectByDeleteButton";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onClick_btnModifyDetail(): string {
                return "onClick_btnModifyDetail";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YoguKonyuhiShikyuShinseiSeikyuDetail";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiSeikyuDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiSeikyuDetail.Controls.myType() + "_" + fieldName;
            }

            public YoguKonyuhiShikyuShinseiSeikyuDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgSeikyuDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            }

            public YoguKonyuhiShikyuShinseiSeikyuDetailInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
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

            public btnShohinmeiSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShohinmeiSearch"));
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

            public btnModifyDetail(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModifyDetail"));
            }

        }

     }

}

