/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput5 {

        export class Events {

            public static onBeforeOpenDialog_btnKusuri(): string {
                return "onBeforeOpenDialog_btnKusuri";
            }

            public static onBeforeOpenDialog_btnKingakuKanri(): string {
                return "onBeforeOpenDialog_btnKingakuKanri";
            }

            public static onBeforeOpenDialog_btnIshiKetei(): string {
                return "onBeforeOpenDialog_btnIshiKetei";
            }

            public static onBeforeOpenDialog_btnShudan(): string {
                return "onBeforeOpenDialog_btnShudan";
            }

            public static onBeforeOpenDialog_btnKaiMono(): string {
                return "onBeforeOpenDialog_btnKaiMono";
            }

            public static onBeforeOpenDialog_btnKantanChori(): string {
                return "onBeforeOpenDialog_btnKantanChori";
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
                return "KihonChosaInput5";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput5.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput5.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput5(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public ShakaiSekatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShakaiSekatsu"));
            }

            public Kusuri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kusuri"));
            }

            public btnKusuri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKusuri"));
            }

            public radKusuri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            }

            public KingakuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            }

            public btnKingakuKanri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKingakuKanri"));
            }

            public radKingakuKanri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            }

            public IshiKetei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            }

            public btnIshiKetei(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiKetei"));
            }

            public radIshiKetei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            }

            public Shudan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shudan"));
            }

            public btnShudan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShudan"));
            }

            public radShudan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            }

            public KaiMono(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            }

            public btnKaiMono(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKaiMono"));
            }

            public radKaiMono(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            }

            public KantanChori(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            }

            public btnKantanChori(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKantanChori"));
            }

            public radKantanChori(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKantanChori"));
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

