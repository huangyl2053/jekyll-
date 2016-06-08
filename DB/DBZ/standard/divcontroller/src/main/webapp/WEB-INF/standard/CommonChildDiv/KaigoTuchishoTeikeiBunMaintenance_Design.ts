/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoTuchishoTeikeiBunMaintenance {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoTuchishoTeikeiBunMaintenance";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoTuchishoTeikeiBunMaintenance.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoTuchishoTeikeiBunMaintenance.Controls.myType() + "_" + fieldName;
            }

            public KaigoTuchishoTeikeiBunMaintenance(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtBunsho(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBunsho"));
            }

        }

     }

}

