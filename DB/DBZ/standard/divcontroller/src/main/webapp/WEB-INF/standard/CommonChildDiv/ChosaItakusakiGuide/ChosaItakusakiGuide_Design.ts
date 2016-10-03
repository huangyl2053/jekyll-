/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module ChosaItakusakiGuide {

        export class Events {

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onClick_btnKensaku(): string {
                return "onClick_btnKensaku";
            }

            public static onSelect(): string {
                return "onSelect";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaItakusakiGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaItakusakiGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaItakusakiGuide.Controls.myType() + "_" + fieldName;
            }

            public ChosaItakusakiGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public Hokensha(): DBZ.HokenshaList.ModeController {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("Hokensha"));
            }

            public txtChosaItakusakiCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCodeFrom"));
            }

            public txtChosaItakuaskiCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakuaskiCodeTo"));
            }

            public radItakusakiJokyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radItakusakiJokyo"));
            }

            public txtChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            }

            public txtChosaItakusakiKanaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiKanaMeisho"));
            }

            public ddlChosaItakusakiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItakusakiKubun"));
            }

            public txtChikuCode(): UZA.TextBoxChikuCode {
                return new UZA.TextBoxChikuCode(this.convFiledName("txtChikuCode"));
            }

            public txtMaxKensu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxKensu"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public KensakuKekkaIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuKekkaIchiran"));
            }

            public dgKensakuKekkaIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKensakuKekkaIchiran"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

