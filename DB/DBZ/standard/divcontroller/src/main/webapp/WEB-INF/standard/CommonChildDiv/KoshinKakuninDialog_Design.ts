/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KoshinKakuninDialog {

        export class Events {

            public static CloseOK(): string {
                return "CloseOK";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KoshinKakuninDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType() + "_" + fieldName;
            }

            public KoshinKakuninDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblKoshinMassage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKoshinMassage"));
            }

            public btnYes(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnYes"));
            }

            public btnNo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNo"));
            }

        }

     }

}

