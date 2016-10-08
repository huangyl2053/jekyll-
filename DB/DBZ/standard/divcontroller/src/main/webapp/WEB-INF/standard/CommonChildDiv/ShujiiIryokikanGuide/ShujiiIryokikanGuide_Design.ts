/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module ShujiiIryokikanGuide {

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
                return "ShujiiIryokikanGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanGuide.Controls.myType() + "_" + fieldName;
            }

            public ShujiiIryokikanGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public HokenshaList(): DBZ.HokenshaList.ModeController {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("HokenshaList"));
            }

            public txtIryoKikanCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeFrom"));
            }

            public txtIryoKikanCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeTo"));
            }

            public radIryoKikanJokyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIryoKikanJokyo"));
            }

            public txtIryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            }

            public txtIryoKikanKanaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanKanaMeisho"));
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

