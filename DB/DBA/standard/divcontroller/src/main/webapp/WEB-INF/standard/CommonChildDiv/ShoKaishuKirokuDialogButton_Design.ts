/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module ShoKaishuKirokuDialogButton {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuKirokuDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialogButton.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuKirokuDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnShoKaishu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShoKaishu"));
            }

        }

     }

}

