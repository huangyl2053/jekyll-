/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput4 {

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
                return "KihonChosaInput4";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput4.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput4.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput4(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public KoudoShogai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KoudoShogai"));
            }

            public Hiryaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hiryaku"));
            }

            public btnHiryaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHiryaku"));
            }

            public radbtnHiryaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            }

            public TukuriHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            }

            public btnTukuriHanashi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTukuriHanashi"));
            }

            public radTukuriHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            }

            public Kanjyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            }

            public btnKanjyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKanjyo"));
            }

            public radKanjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            }

            public Chuyaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            }

            public btnChuyaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChuyaku"));
            }

            public radChuyaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            }

            public OnajiHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            }

            public btnOnajiHanashi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOnajiHanashi"));
            }

            public radOnajiHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            }

            public BigVoice(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            }

            public btnBigVoice(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBigVoice"));
            }

            public radBigVoice(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            }

            public Teikou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Teikou"));
            }

            public btnTeikou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikou"));
            }

            public radTeikou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            }

            public Ochituki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            }

            public btnOchituki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOchituki"));
            }

            public radOchituki(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            }

            public OutLonly(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            }

            public btnOutLonly(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOutLonly"));
            }

            public radOutLonly(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            }

            public Shushu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shushu"));
            }

            public btnShushu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShushu"));
            }

            public radShushu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            }

            public Kowasu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            }

            public btnKowasu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKowasu"));
            }

            public radKowasu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            }

            public MonoWasure(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            }

            public btnMonoWasure(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMonoWasure"));
            }

            public radMonoWasure(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            }

            public HitoriWarai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            }

            public btnHitoriWarai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHitoriWarai"));
            }

            public radHitoriWarai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            }

            public KateKodo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            }

            public btnKateKodo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKateKodo"));
            }

            public radKateKodo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            }

            public MatomeNai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            }

            public btnMatomeNai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMatomeNai"));
            }

            public radMatomeNai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai"));
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

