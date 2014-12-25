/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoFukaKihon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoFukaKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            }

            public KaigoFukaKihon(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTsuchishoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtHokenryoDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
            }

            public txtShutokuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            }

            public txtShutokuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            }

            public txtSoshitsuYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            }

            public txtSoshitsuJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            }

            public btnHihoRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            }

        }

     }

}

