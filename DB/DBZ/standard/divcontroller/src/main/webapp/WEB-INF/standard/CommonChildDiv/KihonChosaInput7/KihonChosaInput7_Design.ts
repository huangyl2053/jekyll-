/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput7 {

        export class Events {

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

            public static onClick_btnConfirm(): string {
                return "onClick_btnConfirm";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonChosaInput7";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput7.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput7.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput7(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public Jiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Jiritsudo"));
            }

            public ShogaiKoreisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShogaiKoreisha"));
            }

            public btnShogaiKoreisha(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShogaiKoreisha"));
            }

            public radShogaiKoreisha(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            }

            public NinchishaJiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            }

            public btnNinchishaJiritsudo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinchishaJiritsudo"));
            }

            public radNinchishaJiritsudo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

        }

     }

}

