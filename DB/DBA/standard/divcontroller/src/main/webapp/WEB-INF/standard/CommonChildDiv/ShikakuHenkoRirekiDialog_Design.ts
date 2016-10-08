/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBA {

     export module ShikakuHenkoRirekiDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuHenkoRirekiDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialog.Controls.myType() + "_" + fieldName;
            }

            public ShikakuHenkoRirekiDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdShikakuHenkoRireki(): DBZ.ShikakuHenkoRireki.ModeController {
            //    return new DBZ.ShikakuHenkoRireki.ModeController(this.convFiledName("ccdShikakuHenkoRireki"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

