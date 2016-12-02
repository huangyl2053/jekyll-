/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../ChosaTokkiShiryoShokai/ChosaTokkiShiryoShokai.ts" />

module DBZ {

     export module ChosaTokkiImageShokai {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaTokkiImageShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChosaTokkiImageShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChosaTokkiImageShokai.Controls.myType() + "_" + fieldName;
            }

            public ChosaTokkiImageShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdChosaTokkiShiryoShokai(): DBZ.ChosaTokkiShiryoShokai.ModeController {
            //    return new DBZ.ChosaTokkiShiryoShokai.ModeController(this.convFiledName("ccdChosaTokkiShiryoShokai"));
            //}

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

