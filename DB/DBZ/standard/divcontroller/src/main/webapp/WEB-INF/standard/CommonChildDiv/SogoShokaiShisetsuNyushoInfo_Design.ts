/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiShisetsuNyushoInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiShisetsuNyushoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiShisetsuNyushoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiShisetsuNyushoInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiShisetsuNyushoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShisetsuBunrui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuBunrui"));
            }

            public txtShisetsuNyushoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShisetsuNyushoYMD"));
            }

            public txtShisetsuTaishoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShisetsuTaishoYMD"));
            }

            public txtShisetsuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuName"));
            }

            public txtShisetsuJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuJigyoshaNo"));
            }

            public txtShisetsuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuJigyoshaName"));
            }

            public txtShisetsuJigyoshaJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuJigyoshaJusho"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

