/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBA {

     export module ShisetsuNyutaishoDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuNyutaishoDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialog.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuNyutaishoDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdShisetsuNyutaisho(): DBZ.ShisetsuNyutaishoRirekiKanri.ModeController {
            //    return new DBZ.ShisetsuNyutaishoRirekiKanri.ModeController(this.convFiledName("ccdShisetsuNyutaisho"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

