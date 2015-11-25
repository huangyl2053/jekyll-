/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module shisetsuJohoCommonChildDiv {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "shisetsuJohoCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.shisetsuJohoCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.shisetsuJohoCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public shisetsuJohoCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlDaichoShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            }

            public radKaigoHokenShisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaigoHokenShisetsu"));
            }

            public radOtherTokureiShisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOtherTokureiShisetsu"));
            }

            public radTekiyoJyogaiShisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTekiyoJyogaiShisetsu"));
            }

            public txtNyuryokuShisetsuKodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyuryokuShisetsuKodo"));
            }

            public btnJigyoshaKensaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaKensaku"));
            }

            public txtNyuryokuShisetsuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyuryokuShisetsuMeisho"));
            }

        }

     }

}

