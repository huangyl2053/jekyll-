/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module RofukuNenkinDialogButton {

        export class Events {

            public static onOkClose_btnRofukuNenkin(): string {
                return "onOkClose_btnRofukuNenkin";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RofukuNenkinDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.RofukuNenkinDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.RofukuNenkinDialogButton.Controls.myType() + "_" + fieldName;
            }

            public RofukuNenkinDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnRofukuNenkin(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRofukuNenkin"));
            }

        }

     }

}

