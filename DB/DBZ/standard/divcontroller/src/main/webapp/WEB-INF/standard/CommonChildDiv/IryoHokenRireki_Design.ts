/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module IryoHokenRireki {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryoHokenRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            }

            public IryoHokenRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public plIryoHokenRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("plIryoHokenRireki"));
            }

            public btnIryohokenTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryohokenTsuika"));
            }

            public dgIryohokenIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryohokenIchiran"));
            }

            public pnlIryohokenJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlIryohokenJoho"));
            }

            public tbdKanyubi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("tbdKanyubi"));
            }

            public tbdDattabi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("tbdDattabi"));
            }

            public ddlSyubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSyubetsu"));
            }

            public txtHokensyaKodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensyaKodo"));
            }

            public txtHokensyaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensyaMeisho"));
            }

            public txtKigoBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKigoBango"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

