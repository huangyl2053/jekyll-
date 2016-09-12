/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ServiceTypeInputCommonChildDiv {

        export class Events {

            public static onBlur_txtServiceType(): string {
                return "onBlur_txtServiceType";
            }

            public static onChange_txtServiceType(): string {
                return "onChange_txtServiceType";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceTypeInputCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ServiceTypeInputCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ServiceTypeInputCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ServiceTypeInputCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceType(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceType"));
            }

            public btnKensaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKensaku"));
            }

            public txtServiceTypeName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceTypeName"));
            }

        }

     }

}

