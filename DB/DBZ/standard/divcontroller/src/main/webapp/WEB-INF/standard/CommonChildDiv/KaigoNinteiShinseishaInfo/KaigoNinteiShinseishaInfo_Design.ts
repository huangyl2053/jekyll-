/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../KaigoNinteiAtenaInfo/KaigoNinteiAtenaInfo.ts" />
/// <reference path="./../kaigoshikakukihon/KaigoShikakuKihon.ts" />

module DBZ {

     export module KaigoNinteiShinseishaInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNinteiShinseishaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoNinteiShinseishaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoNinteiShinseishaInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoNinteiShinseishaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdKaigoNinteiAtenaInfo(): DBZ.KaigoNinteiAtenaInfo.ModeController {
                return new DBZ.KaigoNinteiAtenaInfo.ModeController(this.convFiledName("ccdKaigoNinteiAtenaInfo"));
            }

            public ccdKaigoShikakuKihon(): DBZ.KaigoShikakuKihon.ModeController {
                return new DBZ.KaigoShikakuKihon.ModeController(this.convFiledName("ccdKaigoShikakuKihon"));
            }

        }

     }

}

