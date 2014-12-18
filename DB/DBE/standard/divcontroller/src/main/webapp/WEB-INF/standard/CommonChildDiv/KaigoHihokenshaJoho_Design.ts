/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module KaigoHihokenshaJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoHihokenshaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.KaigoHihokenshaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.KaigoHihokenshaJoho.Controls.myType() + "_" + fieldName;
            }

            public KaigoHihokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaNo"));
            }

            public txtHokenshaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtHihokenshaShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaShimei"));
            }

            public txtHihokenshaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKubun"));
            }

            public txtBirthDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBirthDay"));
            }

            public txtNenrei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNenrei"));
            }

            public btnShichosonRenraku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShichosonRenraku"));
            }

            public txtNinteiShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiYMD"));
            }

            public txtShinseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubun"));
            }

            public txtZenkaiYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZenkaiYokaigodo"));
            }

            public txtZenYukokikanStart(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenYukokikanStart"));
            }

            public lblKara2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKara2"));
            }

            public txtZenYukokikanEnd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenYukokikanEnd"));
            }

            public btnRenrakusaki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnRenrakusaki"));
            }

        }

     }

}

