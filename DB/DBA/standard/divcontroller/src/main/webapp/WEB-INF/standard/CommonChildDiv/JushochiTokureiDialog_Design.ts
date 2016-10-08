/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBA {

     export module JushochiTokureiDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.JushochiTokureiDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.JushochiTokureiDialog.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdJushochiTokureiRireki(): DBZ.JushochiTokureiRirekiList.ModeController {
            //    return new DBZ.JushochiTokureiRirekiList.ModeController(this.convFiledName("ccdJushochiTokureiRireki"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

