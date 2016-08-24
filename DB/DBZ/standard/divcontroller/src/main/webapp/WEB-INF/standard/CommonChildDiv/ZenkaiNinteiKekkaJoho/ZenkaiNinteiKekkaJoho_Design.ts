/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ZenkaiNinteiKekkaJoho {

        export class Events {

            public static onBefore_Dialog(): string {
                return "onBefore_Dialog";
            }

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

            public txtNinteiDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiDay"));
            }

            public txtYukoKikanFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKikanFrom"));
            }

            public txtYukoKikanTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKikanTo"));
            }

            public btnZenkaiShosai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiShosai"));
            }

        }

     }

}

