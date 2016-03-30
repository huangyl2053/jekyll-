/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput3 {

        export class Events {

            public static onClick_btnOpenDialog(): string {
                return "onClick_btnOpenDialog";
            }

            public static onClick_btnConfirm(): string {
                return "onClick_btnConfirm";
            }

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonChosaInput3";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput3.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput3.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput3(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public NinchiKinou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchiKinou"));
            }

            public IshiDentatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiDentatsu"));
            }

            public btnIshiDentatsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiDentatsu"));
            }

            public radIshiDentatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            }

            public Nikka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Nikka"));
            }

            public btnNikka(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNikka"));
            }

            public radNikka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            }

            public Info(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Info"));
            }

            public btnInfo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnInfo"));
            }

            public radInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            }

            public DankiKioku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            }

            public btnDankiKioku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnDankiKioku"));
            }

            public radDankiKioku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            }

            public NameInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            }

            public btnNameInfo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNameInfo"));
            }

            public radNameInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            }

            public Kisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            }

            public btnKisetsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKisetsu"));
            }

            public radKisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            }

            public Basho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Basho"));
            }

            public btnBasho(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBasho"));
            }

            public radBasho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            }

            public Haikai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haikai"));
            }

            public btnHaikai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHaikai"));
            }

            public radHaikai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            }

            public Modoru(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Modoru"));
            }

            public btnModoru(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnModoru"));
            }

            public radModoru(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radModoru"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

