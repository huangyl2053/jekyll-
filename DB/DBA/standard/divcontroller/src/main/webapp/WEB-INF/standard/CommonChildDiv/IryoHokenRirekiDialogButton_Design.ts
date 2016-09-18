/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module IryoHokenRirekiDialogButton {

        export class Events {

            public static onOkClose_btnIryoHokenRireki(): string {
                return "onOkClose_btnIryoHokenRireki";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryoHokenRirekiDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.IryoHokenRirekiDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.IryoHokenRirekiDialogButton.Controls.myType() + "_" + fieldName;
            }

            public IryoHokenRirekiDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnIryoHokenRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoHokenRireki"));
            }

        }

     }

}

