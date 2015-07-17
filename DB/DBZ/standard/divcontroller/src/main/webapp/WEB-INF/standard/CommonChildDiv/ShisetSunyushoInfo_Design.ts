/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShisetSunyushoInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetSunyushoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetSunyushoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetSunyushoInfo.Controls.myType() + "_" + fieldName;
            }

            public ShisetSunyushoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNyushoShisetsuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNyushoShisetsuCode"));
            }

            public txtNyushoShisetsuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsuName"));
            }

            public txtShisetsunyuShoDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsunyuShoDay"));
            }

            public txtShisetsuTaishoDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDay"));
            }

        }

     }

}

