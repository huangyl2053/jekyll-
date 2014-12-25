/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module KaigoSaikinShorishaRireki {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoSaikinShorishaRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType() + "_" + fieldName;
            }

            public KaigoSaikinShorishaRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public wrappedSaikinShorishaRireki(): URZ.SaikinShorishaRireki.ModeController {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("wrappedSaikinShorishaRireki"));
            }

        }

     }

}

