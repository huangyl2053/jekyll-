/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/URACommonChildDiv.d.ts" />

module DBZ {

     export module KaigoAtenaInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoAtenaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoAtenaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public atenaInfo(): UAX.AtenaShokaiSimple.ModeController {
            //    return new UAX.AtenaShokaiSimple.ModeController(this.convFiledName("atenaInfo"));
            //}

        }

     }

}

