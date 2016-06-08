/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NenReiTotatsuSrchConInfo {

        export class Events {

            public static onClick_btnKensaku(): string {
                return "onClick_btnKensaku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NenReiTotatsuSrchConInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType() + "_" + fieldName;
            }

            public NenReiTotatsuSrchConInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtZenkaiFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiFrom"));
            }

            public txtZenkaiTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiTo"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public txtNenreiTotatsuKikanFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanFrom"));
            }

            public txtNenreiTotatsuKikanTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanTo"));
            }

        }

     }

}

