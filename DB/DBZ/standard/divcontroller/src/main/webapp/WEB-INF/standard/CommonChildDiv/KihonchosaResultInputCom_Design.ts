/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module KihonchosaResultInputCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonchosaResultInputCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType() + "_" + fieldName;
            }

            public KihonchosaResultInputCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblItemNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblItemNo"));
            }

            public lblItemName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblItemName"));
            }

            public txtAnswer(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAnswer"));
            }

            public radChoices(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChoices"));
            }

        }

     }

}

