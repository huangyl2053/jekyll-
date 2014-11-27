/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module PrintContentsSetting {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "PrintContentsSetting";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType() + "_" + fieldName;
            }

            public PrintContentsSetting(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtIssueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIssueDate"));
            }

            public txtSendDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSendDate"));
            }

        }

     }

}

