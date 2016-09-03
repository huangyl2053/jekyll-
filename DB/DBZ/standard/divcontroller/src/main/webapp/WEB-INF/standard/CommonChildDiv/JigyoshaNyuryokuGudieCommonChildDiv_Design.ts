/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JigyoshaNyuryokuGudieCommonChildDiv {

        export class Events {

            public static onBlur_JigyoshaNo(): string {
                return "onBlur_JigyoshaNo";
            }

            public static onChange_BtnKenCode(): string {
                return "onChange_BtnKenCode";
            }

            public static search_Jigyosya(): string {
                return "search_Jigyosya";
            }

            public static onclick_BtnClear(): string {
                return "onclick_BtnClear";
            }

            public static close_Dialog(): string {
                return "close_Dialog";
            }

            public static select_BtnSenTaKu(): string {
                return "select_BtnSenTaKu";
            }

            public static select_BtnSilyuuseyi(): string {
                return "select_BtnSilyuuseyi";
            }

            public static select_BtnSakujo(): string {
                return "select_BtnSakujo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JigyoshaNyuryokuGudieCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JigyoshaNyuryokuGudieCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JigyoshaNyuryokuGudieCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public JigyoshaNyuryokuGudieCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TaishoJigyoshaKensaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TaishoJigyoshaKensaku"));
            }

            public KennsakuJyokenn(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KennsakuJyokenn"));
            }

            public txtJIgyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJIgyoshaNo"));
            }

            public txtYukouKaishibi(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukouKaishibi"));
            }

            public txtJigyoshamei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshamei"));
            }

            public ddlKennsakuKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKennsakuKubun"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            }

            public ServiceJigyosha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceJigyosha"));
            }

            public ddlKennCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKennCode"));
            }

            public ddlJigyoshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            }

            public ddlGunshiCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlGunshiCode"));
            }

            public ddlServiceShurui(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlServiceShurui"));
            }

            public OtherTokureiShisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OtherTokureiShisetsu"));
            }

            public radKannaiKanngaiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKannaiKanngaiKubun"));
            }

            public txtMaxHyojiKensu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxHyojiKensu"));
            }

            public btnTaishoJigyoshaKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTaishoJigyoshaKensaku"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnYameru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnYameru"));
            }

            public JigyoshaItirann(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JigyoshaItirann"));
            }

            public dgJigyoshaItiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJigyoshaItiran"));
            }

        }

     }

}

