/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ZenkaiNinteiKekkaJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ZenkaiNinteiKekkaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ZenkaiNinteiKekkaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ZenkaiNinteiKekkaJoho.Controls.myType() + "_" + fieldName;
            }

            public ZenkaiNinteiKekkaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtNinteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiDay"));
            }

            public txtYukoKikanFrom(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKikanFrom"));
            }

            public txtYukoKikanTo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKikanTo"));
            }

            public btnZenkaiShosaiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiShosaiGuide"));
            }

        }

     }

}

