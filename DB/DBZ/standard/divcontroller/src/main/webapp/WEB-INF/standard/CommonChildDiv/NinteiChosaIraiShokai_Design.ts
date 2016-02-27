/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./kaigoshikakukihon/KaigoShikakuKihon.ts" />

module DBZ {

     export module NinteiChosaIraiShokai {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiChosaIraiShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiChosaIraiShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiChosaIraiShokai.Controls.myType() + "_" + fieldName;
            }

            public NinteiChosaIraiShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdKaigoShikakuKihon(): DBZ.KaigoShikakuKihon.ModeController {
            //    return new DBZ.KaigoShikakuKihon.ModeController(this.convFiledName("ccdKaigoShikakuKihon"));
            //}

            public dgNinteiChosaIrai(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiChosaIrai"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

