/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module PaymentDate {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "PaymentDate";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.PaymentDate.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.PaymentDate.Controls.myType() + "_" + fieldName;
            }

            public PaymentDate(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public PayToKoza(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("PayToKoza"));
            }

            public txtKozaPaymentDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKozaPaymentDate"));
            }

            public PayToMadoguchi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("PayToMadoguchi"));
            }

            public txtShiharaiBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            }

            public txtShiharaiDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShiharaiDateRange"));
            }

            public txtShiharaiKaishiTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            }

            public txtShiharaiShuryoTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            }

        }

     }

}

