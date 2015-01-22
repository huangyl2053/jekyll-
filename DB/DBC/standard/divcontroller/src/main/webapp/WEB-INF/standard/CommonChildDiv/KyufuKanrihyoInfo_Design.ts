/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyufuKanrihyoInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyufuKanrihyoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyufuKanrihyoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyufuKanrihyoInfo.Controls.myType() + "_" + fieldName;
            }

            public KyufuKanrihyoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSakuseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSakuseiKubun"));
            }

            public txtSakuseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD"));
            }

            public txtZengetsuNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuNissu"));
            }

            public txtKeikakuSakuseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            }

            public txtShienJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));
            }

            public txtShienJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShienJigyoshaName"));
            }

            public txtShikyuGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuGendogaku"));
            }

            public txtGendogakuTekiyoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendogakuTekiyoKikan"));
            }

            public txtShiteiServiceShokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiteiServiceShokei"));
            }

            public txtKijunServiceShokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKijunServiceShokei"));
            }

            public txtGokeiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGokeiTanisu"));
            }

            public dgMeisaiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgMeisaiList"));
            }

            public txtTantoSenmonNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTantoSenmonNo"));
            }

            public txtItakuJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtItakuJigyoshaNo"));
            }

            public txtItakuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtItakuJigyoshaName"));
            }

            public txtItakuSenmonNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtItakuSenmonNo"));
            }

        }

     }

}

