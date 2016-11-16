/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyufuJissekiHeader {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyufuJissekiHeader";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyufuJissekiHeader.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyufuJissekiHeader.Controls.myType() + "_" + fieldName;
            }

            public KyufuJissekiHeader(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihoNo"));
            }

            public txtJuminShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJuminShubetsu"));
            }

            public txtYoKaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYoKaigodo"));
            }

            public txtYukoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukoKikan"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtSeibetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            }

            public txtSeinengappi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeinengappi"));
            }

            public lin01(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin01"));
            }

            public txtTeikyoNengetsu(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoNengetsu"));
            }

            public txtJissekiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJissekiKubun"));
            }

            public txtSakuseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSakuseiKubun"));
            }

            public txtSeiriNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));
            }

            public txtShokisaiHokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShokisaiHokenshaNo"));
            }

            public txtYoshikiNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYoshikiNo"));
            }

            public txtJigyosha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosha"));
            }

            public txtJigyoshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNo"));
            }

            public txtYoshikiMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYoshikiMeisho"));
            }

        }

     }

}

