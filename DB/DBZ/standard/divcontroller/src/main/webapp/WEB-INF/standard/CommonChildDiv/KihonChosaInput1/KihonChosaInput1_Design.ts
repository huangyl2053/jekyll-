/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput1 {

        export class Events {

            public static onClick_chkMahiChange(): string {
                return "onClick_chkMahiChange";
            }

            public static onClick_chkKoshukuChange(): string {
                return "onClick_chkKoshukuChange";
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
                return "KihonChosaInput1";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput1.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput1.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput1(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public DaiichigunShintaiKino(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DaiichigunShintaiKino"));
            }

            public Mahi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Mahi"));
            }

            public btnMahi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMahi"));
            }

            public chkMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            }

            public Koshuku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            }

            public btnKoshuku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKoshuku"));
            }

            public chkKoshuku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            }

            public NeKaeri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            }

            public btnNeKaeri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNeKaeri"));
            }

            public radNeKaeri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            }

            public OkiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            }

            public btnOkiAgari(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOkiAgari"));
            }

            public radOkiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            }

            public Zai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zai"));
            }

            public btnZai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZai"));
            }

            public radZai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            }

            public RyoAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            }

            public btnRyoAshi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRyoAshi"));
            }

            public radRyoAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            }

            public Buko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Buko"));
            }

            public btnBuko(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBuko"));
            }

            public radBuko(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            }

            public TachiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            }

            public btnTachiAgari(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTachiAgari"));
            }

            public radTachiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            }

            public KataAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            }

            public btnKataAshi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKataAshi"));
            }

            public radKataAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            }

            public Senshin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Senshin"));
            }

            public btnSenshin(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSenshin"));
            }

            public radSenshin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            }

            public TumeKiri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            }

            public btnTumeKiri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTumeKiri"));
            }

            public radTumeKiri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            }

            public Shiryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            }

            public btnShiryoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShiryoku"));
            }

            public radShiryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            }

            public Choryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            }

            public btnChoryoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChoryoku"));
            }

            public radChoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChoryoku"));
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

