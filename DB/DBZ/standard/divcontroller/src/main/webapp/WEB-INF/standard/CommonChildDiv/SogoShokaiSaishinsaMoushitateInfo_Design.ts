/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiSaishinsaMoushitateInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiSaishinsaMoushitateInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiSaishinsaMoushitateInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSaishinsaTaishoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTaishoYM"));
            }

            public txtSaishinsaMoshitateYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaMoshitateYMD"));
            }

            public txtSaishinsaTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTeikyoYM"));
            }

            public txtSaishinsaJigyoshaCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaJigyoshaCode"));
            }

            public txtSaishinsaJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaJigyoshaName"));
            }

            public txtSaishinsaServiceShuruiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceShuruiCode"));
            }

            public txtSaishinsaServiceCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceCode"));
            }

            public txtSaishinsaServiceName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaServiceName"));
            }

            public txtSaishinsaMoshitateTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaMoshitateTanisu"));
            }

            public SogoShokaiSaishinsaJiyu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaJiyu"));
            }

            public txtSaishinsaMoshitateKomoku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateKomoku"));
            }

            public txtSaishinsaMoshitateRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateRiyu"));
            }

            public SogoShokaiSaishinsaKekka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka"));
            }

            public SogoShokaiSaishinsaHokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaHokensha"));
            }

            public txtSaishinsaHokenshaKekka(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaHokenshaKekka"));
            }

            public txtSaishinsaHokenshaToshoTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaToshoTanisu"));
            }

            public txtSaishinsaHokenshaGenshinTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaGenshinTanisu"));
            }

            public txtSaishinsaHokenshaMoshitateTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaMoshitateTanisu"));
            }

            public txtSaishinsaHokenshaKetteiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaKetteiTanisu"));
            }

            public txtSaishinsaHokenshaChoseiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaChoseiTanisu"));
            }

            public txtSaishinsaHokenshaFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaFutangaku"));
            }

            public SogoShokaiSaishinsaKohi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaKohi"));
            }

            public txtSaishinsaKohiJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiJukyushaNo"));
            }

            public txtSaishinsaKohiJukyushaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiJukyushaName"));
            }

            public txtSaishinsaKohiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiHokenshaNo"));
            }

            public txtSaishinsaKohiKekka(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiKekka"));
            }

            public txtSaishinsaKohiToshoTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiToshoTanisu"));
            }

            public txtSaishinsaKohiGenshinTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiGenshinTanisu"));
            }

            public txtSaishinsaKohiMoshitateTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiMoshitateTanisu"));
            }

            public txtSaishinsaKohiKetteiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiKetteiTanisu"));
            }

            public txtSaishinsaKohiChoseiTanisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiChoseiTanisu"));
            }

            public txtSaishinsaKohiFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiFutangaku"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

