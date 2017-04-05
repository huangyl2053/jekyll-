/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module SeikatsuHogoJohoDailogButton {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuHogoJohoDailogButton";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.SeikatsuHogoJohoDailogButton.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.SeikatsuHogoJohoDailogButton.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuHogoJohoDailogButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnSeikatsuHogoJoho(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSeikatsuHogoJoho"));
            }

        }

     }

}

