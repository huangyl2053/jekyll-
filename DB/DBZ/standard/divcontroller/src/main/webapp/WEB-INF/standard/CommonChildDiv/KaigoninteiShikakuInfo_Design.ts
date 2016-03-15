/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoninteiShikakuInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoninteiShikakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoninteiShikakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoninteiShikakuInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoninteiShikakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtShutokuYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShutokuYmd"));
            }

            public txtShutokuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            }

            public txtSoshitsuYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSoshitsuYmd"));
            }

            public txtSoshitsuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            }

            public txtJutokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            }

            public txtYokaigoJotaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            }

            public txtNinteiKaishiYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            }

            public txtNinteiShuryoYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            }

            public txtHookenshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHookenshaCode"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

        }

     }

}

