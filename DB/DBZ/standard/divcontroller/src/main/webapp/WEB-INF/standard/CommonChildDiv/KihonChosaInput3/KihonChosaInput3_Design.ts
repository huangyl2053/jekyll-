/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput3 {

        export class Events {

            public static onBeforeOpenDialog_btnIshiDentatsu(): string {
                return "onBeforeOpenDialog_btnIshiDentatsu";
            }

            public static onBeforeOpenDialog_btnNikka(): string {
                return "onBeforeOpenDialog_btnNikka";
            }

            public static onBeforeOpenDialog_btnInfo(): string {
                return "onBeforeOpenDialog_btnInfo";
            }

            public static onBeforeOpenDialog_btnDankiKioku(): string {
                return "onBeforeOpenDialog_btnDankiKioku";
            }

            public static onBeforeOpenDialog_btnNameInfo(): string {
                return "onBeforeOpenDialog_btnNameInfo";
            }

            public static onBeforeOpenDialog_btnKisetsu(): string {
                return "onBeforeOpenDialog_btnKisetsu";
            }

            public static onBeforeOpenDialog_btnBasho(): string {
                return "onBeforeOpenDialog_btnBasho";
            }

            public static onBeforeOpenDialog_btnHaikai(): string {
                return "onBeforeOpenDialog_btnHaikai";
            }

            public static onBeforeOpenDialog_btnModoru(): string {
                return "onBeforeOpenDialog_btnModoru";
            }

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

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

        }

     }

}

