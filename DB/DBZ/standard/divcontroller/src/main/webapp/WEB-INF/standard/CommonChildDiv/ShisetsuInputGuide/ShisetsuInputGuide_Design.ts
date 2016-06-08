/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../ShisetsuNyutaishoRirekiKanri.ts" />

module DBZ {

     export module ShisetsuInputGuide {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShisetsuNyutaishoRirekikanri(): DBZ.ShisetsuNyutaishoRirekiKanri.ModeController {
                return new DBZ.ShisetsuNyutaishoRirekiKanri.ModeController(this.convFiledName("ccdShisetsuNyutaishoRirekikanri"));
            }

            public linizontalLine(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linizontalLine"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

