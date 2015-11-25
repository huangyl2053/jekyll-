/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoAtesakiJushoSettei {

        export class Events {

            public static onCkCloseBtnAtesakiJushoSettei(): string {
                return "onCkCloseBtnAtesakiJushoSettei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoAtesakiJushoSettei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoSettei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoSettei.Controls.myType() + "_" + fieldName;
            }

            public KaigoAtesakiJushoSettei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radJushoSettei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJushoSettei"));
            }

            public btnAtesakiJushoSettei(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnAtesakiJushoSettei"));
            }

            public txtAtesakiJushoSettei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAtesakiJushoSettei"));
            }

        }

     }

}

