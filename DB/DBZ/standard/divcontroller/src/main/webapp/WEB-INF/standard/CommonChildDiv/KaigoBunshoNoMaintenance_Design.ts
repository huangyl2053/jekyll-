/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module KaigoBunshoNoMaintenance {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoBunshoNoMaintenance";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoBunshoNoMaintenance.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoBunshoNoMaintenance.Controls.myType() + "_" + fieldName;
            }

            public KaigoBunshoNoMaintenance(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdBunshoMaintenance(): URZ.BunshoNoMaintenance.ModeController {
            //    return new URZ.BunshoNoMaintenance.ModeController(this.convFiledName("ccdBunshoMaintenance"));
            //}

        }

     }

}

