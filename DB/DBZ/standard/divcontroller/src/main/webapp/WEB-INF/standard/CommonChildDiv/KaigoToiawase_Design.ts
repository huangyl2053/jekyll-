/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoToiawase {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoToiawase";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoToiawase.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoToiawase.Controls.myType() + "_" + fieldName;
            }

            public KaigoToiawase(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlHakkoBusho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHakkoBusho"));
            }

            public InjiNaiyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("InjiNaiyo"));
            }

            public ddlBusho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBusho"));
            }

            public dllBushomeiKuhakuUMu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("dllBushomeiKuhakuUMu"));
            }

            public txtName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtName"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtNaisenNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNaisenNo"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public ddlKenmeiFuyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKenmeiFuyo"));
            }

            public ddlShichoshonMei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShichoshonMei"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            }

        }

     }

}

