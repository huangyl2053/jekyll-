/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput6 {

        export class Events {

            public static onBeforeOpenDialog_btnTenteki(): string {
                return "onBeforeOpenDialog_btnTenteki";
            }

            public static onBeforeOpenDialog_btnSeimyaku(): string {
                return "onBeforeOpenDialog_btnSeimyaku";
            }

            public static onBeforeOpenDialog_btnTouseki(): string {
                return "onBeforeOpenDialog_btnTouseki";
            }

            public static onBeforeOpenDialog_btnSutoma(): string {
                return "onBeforeOpenDialog_btnSutoma";
            }

            public static onBeforeOpenDialog_btnSansou(): string {
                return "onBeforeOpenDialog_btnSansou";
            }

            public static onBeforeOpenDialog_btnResupireta(): string {
                return "onBeforeOpenDialog_btnResupireta";
            }

            public static onBeforeOpenDialog_btnKikan(): string {
                return "onBeforeOpenDialog_btnKikan";
            }

            public static onBeforeOpenDialog_btnToutsu(): string {
                return "onBeforeOpenDialog_btnToutsu";
            }

            public static onBeforeOpenDialog_btnKeikan(): string {
                return "onBeforeOpenDialog_btnKeikan";
            }

            public static onBeforeOpenDialog_btnMonita(): string {
                return "onBeforeOpenDialog_btnMonita";
            }

            public static onBeforeOpenDialog_btnJyokuso(): string {
                return "onBeforeOpenDialog_btnJyokuso";
            }

            public static onBeforeOpenDialog_btnKateru(): string {
                return "onBeforeOpenDialog_btnKateru";
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
                return "KihonChosaInput6";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput6.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput6.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput6(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public TokubetsuIryo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuIryo"));
            }

            public ShochiNaiyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShochiNaiyo"));
            }

            public btnTenteki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTenteki"));
            }

            public chkTenteki(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTenteki"));
            }

            public btnSeimyaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSeimyaku"));
            }

            public chkSeimyaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeimyaku"));
            }

            public btnTouseki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTouseki"));
            }

            public chkTouseki(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTouseki"));
            }

            public btnSutoma(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSutoma"));
            }

            public chkSutoma(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSutoma"));
            }

            public btnSansou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSansou"));
            }

            public chkSansou(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSansou"));
            }

            public btnResupireta(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnResupireta"));
            }

            public chkResupireta(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkResupireta"));
            }

            public btnKikan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKikan"));
            }

            public chkKikan(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKikan"));
            }

            public btnToutsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnToutsu"));
            }

            public chkToutsu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkToutsu"));
            }

            public btnKeikan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKeikan"));
            }

            public chkKeikan(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKeikan"));
            }

            public TokiTaiou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            }

            public btnMonita(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMonita"));
            }

            public chkMonita(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMonita"));
            }

            public btnJyokuso(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJyokuso"));
            }

            public chkJyokuso(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJyokuso"));
            }

            public btnbtnKateru(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnbtnKateru"));
            }

            public chkKateru(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKateru"));
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

