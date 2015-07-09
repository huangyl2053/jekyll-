/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBE {

     export module ShujiiIkenshoIraiShokai {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShujiiIkenshoIraiShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType() + "_" + fieldName;
            }

            public ShujiiIkenshoIraiShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdKaigoShikakuKihon(): DBZ.KaigoShikakuKihon.ModeController {
            //    return new DBZ.KaigoShikakuKihon.ModeController(this.convFiledName("ccdKaigoShikakuKihon"));
            //}

            public dgIkenshoIraiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIkenshoIraiIchiran"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

