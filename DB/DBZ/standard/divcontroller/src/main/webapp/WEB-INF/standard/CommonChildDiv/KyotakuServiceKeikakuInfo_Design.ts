/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KyotakuServiceKeikakuInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyotakuServiceKeikakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KyotakuServiceKeikakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KyotakuServiceKeikakuInfo.Controls.myType() + "_" + fieldName;
            }

            public KyotakuServiceKeikakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKyotakujigyoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakujigyoCode"));
            }

            public txtKyotakuJigyoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyotakuJigyoName"));
            }

            public txtSakuseiKubun(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSakuseiKubun"));
            }

            public txtTekiyokaishiDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyokaishiDay"));
            }

            public txtTekiyoshuryoDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoshuryoDay"));
            }

        }

     }

}

