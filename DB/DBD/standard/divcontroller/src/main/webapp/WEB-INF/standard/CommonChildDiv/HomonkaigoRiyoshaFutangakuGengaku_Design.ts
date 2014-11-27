/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBD {

     export module HomonkaigoRiyoshaFutangakuGengaku {

        export class Events {

            public static onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList(): string {
                return "onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HomonkaigoRiyoshaFutangakuGengaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.HomonkaigoRiyoshaFutangakuGengaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.HomonkaigoRiyoshaFutangakuGengaku.Controls.myType() + "_" + fieldName;
            }

            public HomonkaigoRiyoshaFutangakuGengaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHiddenHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHiddenHihokenshaNo"));
            }

            public dgHomonkaigoRiyoshaFutangakuGengakuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHomonkaigoRiyoshaFutangakuGengakuList"));
            }

            public HomonkaigoRiyoshaFutangakuGengakuDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail"));
            }

            public HomonkaigoRiyoshaFutangakuGengakuShinsei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_HomonkaigoRiyoshaFutangakuGengakuShinsei"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public txtHobetsuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHobetsuKubun"));
            }

            public txtShinseiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            }

            public ShogaishaTecho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_ShogaishaTecho"));
            }

            public txtHasShogaishaTecho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHasShogaishaTecho"));
            }

            public txtShogaishaTechoTokyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShogaishaTechoTokyu"));
            }

            public txtShogaishaTechoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaishaTechoNo"));
            }

            public HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan"));
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

            public txtKohiFutanshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiFutanshaNo"));
            }

            public txtKohiJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiJukyushaNo"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

