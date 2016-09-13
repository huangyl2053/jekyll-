/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module ShisetsuNyutaishoDialogButton {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuNyutaishoDialogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialogButton.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuNyutaishoDialogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnShisetsuNyutaisho(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShisetsuNyutaisho"));
            }

        }

     }

}

