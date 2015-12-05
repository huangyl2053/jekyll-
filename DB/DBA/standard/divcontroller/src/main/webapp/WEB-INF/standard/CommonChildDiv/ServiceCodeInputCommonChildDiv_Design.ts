/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module ServiceCodeInputCommonChildDiv {

        export class Events {

            public static onBlur(): string {
                return "onBlur";
            }

            public static onOkClosebtnSearch(): string {
                return "onOkClosebtnSearch";
            }

            public static onBeforeOpenDialogbtnSearch(): string {
                return "onBeforeOpenDialogbtnSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceCodeInputCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.ServiceCodeInputCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ServiceCodeInputCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ServiceCodeInputCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblServiceCode(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceCode"));
            }

            public txtServiceCode1(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode1"));
            }

            public txtServiceCode2(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode2"));
            }

            public btnKensaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKensaku"));
            }

            public txtServiceCodeName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceCodeName"));
            }

        }

     }

}

