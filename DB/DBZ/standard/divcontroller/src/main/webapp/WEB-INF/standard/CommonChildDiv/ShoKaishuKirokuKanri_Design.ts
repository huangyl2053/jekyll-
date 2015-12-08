/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShoKaishuKirokuKanri {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuKirokuKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuKirokuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public panelKoufuList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelKoufuList"));
            }

            public dgKoufuKaishu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKoufuKaishu"));
            }

            public panelInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelInput"));
            }

            public txtKoufuType(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKoufuType"));
            }

            public txtKoufuDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKoufuDate"));
            }

            public txtYukouKigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukouKigen"));
            }

            public ddlKoufuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKoufuJiyu"));
            }

            public txaKoufuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txaKoufuRiyu"));
            }

            public txtKaisyuDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaisyuDate"));
            }

            public ddlKaisyuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaisyuJiyu"));
            }

            public txaKaishuRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txaKaishuRiyu"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

