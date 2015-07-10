/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoBunshoBangoInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoBunshoBangoInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoBunshoBangoInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoBunshoBangoInput.Controls.myType() + "_" + fieldName;
            }

            public KaigoBunshoBangoInput(): UZA.Panel {
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

            public BunshoFoot(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("BunshoFoot"));
            }

            public btnBunshoNoGet(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBunshoNoGet"));
            }

        }

     }

}

