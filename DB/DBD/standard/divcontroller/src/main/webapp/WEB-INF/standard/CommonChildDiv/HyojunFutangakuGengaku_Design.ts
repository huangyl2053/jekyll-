/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBD {

     export module HyojunFutangakuGengaku {

        export class Events {

            public static onSelect_dgHyojunFutangakuGengakuList(): string {
                return "onSelect_dgHyojunFutangakuGengakuList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HyojunFutangakuGengaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.HyojunFutangakuGengaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.HyojunFutangakuGengaku.Controls.myType() + "_" + fieldName;
            }

            public HyojunFutangakuGengaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHiddenHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHiddenHihokenshaNo"));
            }

            public dgHyojunFutangakuGengakuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHyojunFutangakuGengakuList"));
            }

            public HyojunFutangakuGemmenDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HyojunFutangakuGemmenDetail"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public HyojunFutangakuGemmenRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HyojunFutangakuGemmenDetail_HyojunFutangakuGemmenRiyoshaFutan"));
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

            public txtGengakuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGengakuKubun"));
            }

            public txtFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
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

