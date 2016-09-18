/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module ShotokuShokaiDialogButton {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShotokuShokaiDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShotokuShokaiDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShotokuShokaiDialogButton.Controls.myType() + "_" + fieldName;
            }

            public ShotokuShokaiDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnSetaiShotoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiShotoku"));
            }

        }

     }

}

