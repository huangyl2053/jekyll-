/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module TekiyoJogaiShisetsuInputGuide {

        export class Events {

            public static onSelectBySelectButton_dgTekiyoJogaiShisetsu(): string {
                return "onSelectBySelectButton_dgTekiyoJogaiShisetsu";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TekiyoJogaiShisetsuInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.TekiyoJogaiShisetsuInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.TekiyoJogaiShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            }

            public TekiyoJogaiShisetsuInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgTekiyoJogaiShisetsu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTekiyoJogaiShisetsu"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

