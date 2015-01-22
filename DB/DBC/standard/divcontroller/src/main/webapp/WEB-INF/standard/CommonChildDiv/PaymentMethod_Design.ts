/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module PaymentMethod {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "PaymentMethod";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.PaymentMethod.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.PaymentMethod.Controls.myType() + "_" + fieldName;
            }

            public PaymentMethod(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radPayMethod(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPayMethod"));
            }

            public URKoza(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("URKoza"));
            }

            public txtKari1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKari1"));
            }

            public DBZJuryoinin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DBZJuryoinin"));
            }

            public txtKari2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKari2"));
            }

        }

     }

}

