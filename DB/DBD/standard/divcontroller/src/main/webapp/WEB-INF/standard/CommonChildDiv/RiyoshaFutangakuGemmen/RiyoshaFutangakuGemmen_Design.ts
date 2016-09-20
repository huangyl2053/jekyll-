/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module RiyoshaFutangakuGemmen {

        export class Events {

            public static onSelect_dgRiyoshaFutangakuGemmenList(): string {
                return "onSelect_dgRiyoshaFutangakuGemmenList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RiyoshaFutangakuGemmen";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.RiyoshaFutangakuGemmen.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.RiyoshaFutangakuGemmen.Controls.myType() + "_" + fieldName;
            }

            public RiyoshaFutangakuGemmen(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgRiyoshaFutangakuGemmenList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRiyoshaFutangakuGemmenList"));
            }

            public RiyoshaFutangakuGemmenDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RiyoshaFutangakuGemmenDetail"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public RiyoshaFutangakuGemmenRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RiyoshaFutangakuGemmenRiyoshaFutan"));
            }

            public txtKetteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            }

            public txtKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            }

            public txtTekiyoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtYukokigenDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            }

            public txtKyufuRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            }

            public txtFushoninRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

