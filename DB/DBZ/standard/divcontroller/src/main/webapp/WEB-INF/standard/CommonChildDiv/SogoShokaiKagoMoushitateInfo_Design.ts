/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiKagoMoushitateInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiKagoMoushitateInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiKagoMoushitateInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKagoTaishoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTaishoYM"));
            }

            public txtKagoMoshitateYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoMoshitateYMD"));
            }

            public txtKagoTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTeikyoYM"));
            }

            public txtKagoDogetsuKago(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoDogetsuKago"));
            }

            public txtKagoJigyoshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoJigyoshaCode"));
            }

            public txtKagoJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoJigyoshaName"));
            }

            public SogoShokaiKagoMoshitateJiyu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateJiyu"));
            }

            public txtKagoMoshitateYoshiki(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateYoshiki"));
            }

            public txtKagoMoshitateRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateRiyu"));
            }

            public SogoShokaiKagoMoshitateKekka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka"));
            }

            public SogoShokaiKagoMoshitateHokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateHokensha"));
            }

            public txtKagoHokenshaTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaTanisu"));
            }

            public txtKagoHokenshaFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaFutangaku"));
            }

            public SogoShokaiKagoMoshitateKohi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateKohi"));
            }

            public txtKagoKohiJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiJukyushaNo"));
            }

            public txtKagoKohiJukyushaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoKohiJukyushaName"));
            }

            public txtKagoKohiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiHokenshaNo"));
            }

            public txtKagoKohiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiTanisu"));
            }

            public txtKagoKohiFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiFutangaku"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

