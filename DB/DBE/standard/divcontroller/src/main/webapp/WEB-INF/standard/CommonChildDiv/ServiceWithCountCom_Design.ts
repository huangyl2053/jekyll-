/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ServiceWithCountCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceWithCountCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType() + "_" + fieldName;
            }

            public ServiceWithCountCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblServiceName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceName"));
            }

            public txtNum(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNum"));
            }

            public radKaigoOrYobo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaigoOrYobo"));
            }

        }

     }

}

