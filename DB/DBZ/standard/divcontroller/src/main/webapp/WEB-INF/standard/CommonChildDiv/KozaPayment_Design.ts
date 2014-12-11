/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KozaPayment {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KozaPayment";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            }

            public KozaPayment(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            }

            public txtKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            }

            public radKozaShubetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            }

            public txtKozaMeigininKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            }

            public txtKinyuKikanBrunchCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            }

            public txtKinyuKikanBrunchName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            }

            public txtKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            }

            public txtKozaMeiginin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            }

        }

     }

}

