/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBD {

     export module HikazeiNenkinKensaku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HikazeiNenkinKensaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType() + "_" + fieldName;
            }

            public HikazeiNenkinKensaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TextBox1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox1"));
            }

            public TextBox2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("TextBox2"));
            }

            public DataGrid1(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("DataGrid1"));
            }

            public Button1(): UZA.Button {
                return new UZA.Button(this.convFiledName("Button1"));
            }

        }

     }

}

