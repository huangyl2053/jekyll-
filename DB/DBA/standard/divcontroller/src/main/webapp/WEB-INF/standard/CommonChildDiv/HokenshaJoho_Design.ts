/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module HokenshaJoho {

        export class Events {

            public static onBlur_txtHokenshaNo(): string {
                return "onBlur_txtHokenshaNo";
            }

            public static onOkClose_btnSearch(): string {
                return "onOkClose_btnSearch";
            }

            public static onBeforeOpenDialog_btnSearch(): string {
                return "onBeforeOpenDialog_btnSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HokenshaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.HokenshaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.HokenshaJoho.Controls.myType() + "_" + fieldName;
            }

            public HokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            }

            public btnHokenshaSelect(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));
            }

            public txtHokenshaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            }

        }

     }

}

