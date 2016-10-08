/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module JushochiTokureiDialogButton {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.JushochiTokureiDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.JushochiTokureiDialogButton.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnJushochiTokureiDialog(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJushochiTokureiDialog"));
            }

        }

     }

}

