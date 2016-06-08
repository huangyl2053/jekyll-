/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module OutputOrderAndNewpage {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "OutputOrderAndNewpage";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.OutputOrderAndNewpage.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.OutputOrderAndNewpage.Controls.myType() + "_" + fieldName;
            }

            public OutputOrderAndNewpage(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnChangeOrder(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnChangeOrder"));
            }

            public txtNewPageItem(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNewPageItem"));
            }

            public txt1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txt1"));
            }

            public txt2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txt2"));
            }

            public txt3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txt3"));
            }

            public txt4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txt4"));
            }

            public txt5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txt5"));
            }

        }

     }

}

