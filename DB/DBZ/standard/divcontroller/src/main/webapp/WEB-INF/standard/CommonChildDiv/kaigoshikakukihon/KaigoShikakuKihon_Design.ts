/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoShikakuKihon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoShikakuKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            }

            public KaigoShikakuKihon(): UZA.Panel {
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

            public btnNinteiRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            }

            public btnHihoRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            }

            public btnRenrakusaki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            }

        }

     }

}

