/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput2 {

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
                return "KihonChosaInput2";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput2.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput2.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput2(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public SeikatsuKinou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuKinou"));
            }

            public Ijyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ijyo"));
            }

            public btnIjyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIjyo"));
            }

            public radIjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIjyo"));
            }

            public Idou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Idou"));
            }

            public btnIdou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIdou"));
            }

            public radIdou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdou"));
            }

            public Enka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Enka"));
            }

            public btnEnka(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnEnka"));
            }

            public radEnka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            }

            public Shokuji(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shokuji"));
            }

            public btnShokuji(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShokuji"));
            }

            public radShokuji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokuji"));
            }

            public Hainyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hainyo"));
            }

            public btnHainyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHainyo"));
            }

            public radHainyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHainyo"));
            }

            public Haiben(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haiben"));
            }

            public btnHaiben(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHaiben"));
            }

            public radHaiben(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaiben"));
            }

            public Kokou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kokou"));
            }

            public btnKokou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKokou"));
            }

            public radKokou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKokou"));
            }

            public Sengan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Sengan"));
            }

            public btnSengan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSengan"));
            }

            public radSengan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSengan"));
            }

            public Seihatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Seihatsu"));
            }

            public btnSeihatsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSeihatsu"));
            }

            public radSeihatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu"));
            }

            public Uwagi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Uwagi"));
            }

            public btnUwagi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnUwagi"));
            }

            public radUwagi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radUwagi"));
            }

            public Zubon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zubon"));
            }

            public btnZubon(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZubon"));
            }

            public radZubon(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZubon"));
            }

            public Hindo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hindo"));
            }

            public btnHindo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHindo"));
            }

            public radHindo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHindo"));
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

