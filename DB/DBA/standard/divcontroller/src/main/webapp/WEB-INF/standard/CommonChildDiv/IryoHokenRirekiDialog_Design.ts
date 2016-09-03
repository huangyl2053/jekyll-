/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBA {

     export module IryoHokenRirekiDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryoHokenRirekiDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.IryoHokenRirekiDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.IryoHokenRirekiDialog.Controls.myType() + "_" + fieldName;
            }

            public IryoHokenRirekiDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdIryoHokenRireki(): DBZ.IryohokenRirekiCommonChildDiv.ModeController {
            //    return new DBZ.IryohokenRirekiCommonChildDiv.ModeController(this.convFiledName("ccdIryoHokenRireki"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

