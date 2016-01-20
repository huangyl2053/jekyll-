/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JukyuSikakuShomeishoHakko {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyuSikakuShomeishoHakko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JukyuSikakuShomeishoHakko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JukyuSikakuShomeishoHakko.Controls.myType() + "_" + fieldName;
            }

            public JukyuSikakuShomeishoHakko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlJukyushaJoho1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlJukyushaJoho1"));
            }

            public txtKofubi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofubi"));
            }

            public txtIdoYotebi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIdoYotebi"));
            }

            public txtYokaigoJotaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            }

            public txtShinsebi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsebi"));
            }

            public txtdrYukokikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtdrYukokikan"));
            }

            public cblInji(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("cblInji"));
            }

            public pnlJukyushaJoho2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlJukyushaJoho2"));
            }

            public lblShinsakaiYikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiYikan"));
            }

            public tbmShinsakaiYikan(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("tbmShinsakaiYikan"));
            }

            public lblBiko(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblBiko"));
            }

            public tbmBiko(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("tbmBiko"));
            }

        }

     }

}

