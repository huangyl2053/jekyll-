/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShujiiIryokikanAndShujiiGuide {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShujiiIryokikanAndShujiiGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType() + "_" + fieldName;
            }

            public ShujiiIryokikanAndShujiiGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

            public txtIryoKikanCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeFrom"));
            }

            public txtIryoKikanCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeTo"));
            }

            public txtIryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            }

            public txtShuijiiCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShuijiiCodeFrom"));
            }

            public txtShujiiCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCodeTo"));
            }

            public txtShujiiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public IryoKikanIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoKikanIchiran"));
            }

            public dgIryoKikanIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryoKikanIchiran"));
            }

            public ShujiiIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiIchiran"));
            }

            public dgShujiiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIchiran"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

