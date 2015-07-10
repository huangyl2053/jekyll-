/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module BunshoBangoInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "BunshoBangoInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.BunshoBangoInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.BunshoBangoInput.Controls.myType() + "_" + fieldName;
            }

            public BunshoBangoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtBunshoShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoShurui"));
            }

            public txtBunshoHeader(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoHeader"));
            }

            public txtBunshoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoNo"));
            }

            public txtBunshoFooter(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoFooter"));
            }

            public btnGetBunshoNo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnGetBunshoNo"));
            }

        }

     }

}

