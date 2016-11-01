/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module DBC {

     export module KaigoKyufuKokuhorenJohoTorikomi {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoKyufuKokuhorenJohoTorikomi";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KaigoKyufuKokuhorenJohoTorikomi.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KaigoKyufuKokuhorenJohoTorikomi.Controls.myType() + "_" + fieldName;
            }

            public KaigoKyufuKokuhorenJohoTorikomi(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblChushutsuJoken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            }

            public txtShoriYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShoriYmd"));
            }

            public txtSaishoriKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishoriKubun"));
            }

            public ShoriTaishoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShoriTaishoJoho"));
            }

            public lblShoriTaishoJoho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShoriTaishoJoho"));
            }

            public chkTsuJobun(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuJobun"));
            }

            public KakuninJikoMsg(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KakuninJikoMsg"));
            }

            public lblKakuninJohoMsg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakuninJohoMsg"));
            }

            public lblAruBaiMsg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblAruBaiMsg"));
            }

            public lblNaiBaiMsg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNaiBaiMsg"));
            }

            public txtShoriTaisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoriTaisho"));
            }

            public hdnShoriKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("hdnShoriKubun"));
            }

            public ShutsuRyokujun(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShutsuRyokujun"));
            }

            //public ccdChohyoShutsuryokujun(): URZ.ChohyoShutsuryokujun.ModeController {
            //    return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("ccdChohyoShutsuryokujun"));
            //}

        }

     }

}

