/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module TokubetsuChiikiKasanGemmen {

        export class Events {

            public static onSelect_dgTokubetsuChiikiKasanGemmenList(): string {
                return "onSelect_dgTokubetsuChiikiKasanGemmenList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokubetsuChiikiKasanGemmen";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.TokubetsuChiikiKasanGemmen.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.TokubetsuChiikiKasanGemmen.Controls.myType() + "_" + fieldName;
            }

            public TokubetsuChiikiKasanGemmen(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgTokubetsuChiikiKasanGemmenList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTokubetsuChiikiKasanGemmenList"));
            }

            public TokubetsuChiikiKasanGemmenDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuChiikiKasanGemmenDetail"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public TokubetsuChiikiKasanGemmenRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuChiikiKasanGemmenRiyoshaFutan"));
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

            public txtGengakuRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGengakuRitsu"));
            }

            public txtKakuninNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKakuninNo"));
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

