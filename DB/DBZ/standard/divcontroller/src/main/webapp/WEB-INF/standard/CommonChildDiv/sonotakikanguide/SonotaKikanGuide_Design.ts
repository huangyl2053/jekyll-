/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module SonotaKikanGuide {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SonotaKikanGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SonotaKikanGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SonotaKikanGuide.Controls.myType() + "_" + fieldName;
            }

            public SonotaKikanGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public ccdHokenshaList(): DBZ.HokenshaList.ModeController {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            }

            public txtSonotaKikanCodefrom(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanCodefrom"));
            }

            public blkara(): UZA.Label {
                return new UZA.Label(this.convFiledName("blkara"));
            }

            public txtSonotaKikanCodeto(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanCodeto"));
            }

            public radHaisi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaisi"));
            }

            public txtSonotaKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanName"));
            }

            public ddlChosaItakusakiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItakusakiKubun"));
            }

            public txtMaxDisp(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxDisp"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public SelectIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SelectIchiran"));
            }

            public dgSonotaKikanIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSonotaKikanIchiran"));
            }

            public btnback(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnback"));
            }

        }

     }

}

