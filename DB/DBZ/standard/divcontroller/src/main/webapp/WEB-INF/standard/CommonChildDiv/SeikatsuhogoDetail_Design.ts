/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SeikatsuhogoDetail {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuhogoDetail";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuhogoDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SeikatsuhogoDetailSub(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub"));
            }

            public txtJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            }

            public txtKaishiYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYM"));
            }

            public txtHaishiYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHaishiYM"));
            }

            public txtHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            }

            public btnHokenshaGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaGuide"));
            }

            public txtHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            }

            public HokenryoDairinofu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_HokenryoDairinofu"));
            }

            public radDairinofuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            }

            public txtNofuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNofuYM"));
            }

            public KyugoShisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_KyugoShisetsu"));
            }

            public radNyutaishoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            }

            public txtNyushoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNyushoDate"));
            }

            public txtTaishoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoDate"));
            }

            public FujoShurui(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            }

            public chkFujyoShurui(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFujyoShurui"));
            }

        }

     }

}

