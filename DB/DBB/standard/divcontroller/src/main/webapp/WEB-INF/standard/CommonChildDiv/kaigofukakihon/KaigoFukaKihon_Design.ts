/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

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
                return this._myName + "_" + DBB.KaigoFukaKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
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

            public btnHihoRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            }

        }

     }

}

