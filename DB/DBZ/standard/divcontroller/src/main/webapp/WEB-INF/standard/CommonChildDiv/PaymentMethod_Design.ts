/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./KozaPayment.ts" />

module DBZ {

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
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType() + "_" + fieldName;
            }

            public PaymentMethod(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radPayMethod1(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));
            }

            public JuryoininJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JuryoininJoho"));
            }

            public txtJuryoininKeiyakuNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public txtJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            }

            public txtJigyoshaNameKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));
            }

            public radPayMethod2(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));
            }

            public KozaPayment(): DBZ.KozaPayment.ModeController {
                return new DBZ.KozaPayment.ModeController(this.convFiledName("KozaPayment"));
            }

            public radPayMethod3(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));
            }

            public MadoguchiPayment(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));
            }

            public txtShiharaiBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            }

            public txtShiharaiKaishiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));
            }

            public txtShiharaiKaishiDay(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));
            }

            public txtShiharaiKaishiTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            }

            public txtShiharaiShuryoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));
            }

            public txtShiharaiShuryoDay(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));
            }

            public txtShiharaiShuryoTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            }

        }

     }

}

