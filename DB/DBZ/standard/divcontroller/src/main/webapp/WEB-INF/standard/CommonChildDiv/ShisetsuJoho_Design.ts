/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShisetsuJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlDaichoShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            }

            public radJigyosha(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJigyosha"));
            }

            public radOther(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOther"));
            }

            public radJyogai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJyogai"));
            }

            public txtShisetsuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            }

            public btnJigyoshaInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            }

            public btnOtherTokureiShisetsuInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOtherTokureiShisetsuInputGuide"));
            }

            public btnJogaiShisetsuInputGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJogaiShisetsuInputGuide"));
            }

            public txtShisetsuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuMeisho"));
            }

        }

     }

}

