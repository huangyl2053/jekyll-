/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput6 {

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

            public btnShochiNaiyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShochiNaiyo"));
            }

            public chkShochiNaiyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            }

            public TokiTaiou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            }

            public btnTokiTaiou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTokiTaiou"));
            }

            public chkTokiTaiou(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou"));
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

