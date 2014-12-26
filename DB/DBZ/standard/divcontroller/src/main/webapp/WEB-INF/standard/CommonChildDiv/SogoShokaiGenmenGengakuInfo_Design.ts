/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiGenmenGengakuInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiGenmenGengakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiGenmenGengakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtGenmenShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenShinseiYMD"));
            }

            public txtGenmenKyuSochiUmu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyuSochiUmu"));
            }

            public SogoShokaiGenmenGengakuTecho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuTecho"));
            }

            public txtGenmenTechoUmu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoUmu"));
            }

            public txtGenmenTechoTokyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoTokyu"));
            }

            public txtGenmenTechoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoNo"));
            }

            public txtGenmenTechoKofuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenTechoKofuYMD"));
            }

            public txtGenmenSeihoUmu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoUmu"));
            }

            public txtGenmenSeihoTokureiUmu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoTokureiUmu"));
            }

            public txtGenmenRofukuUmu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenRofukuUmu"));
            }

            public txtGenmenFutanDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanDankai"));
            }

            public txtGenmenKyokaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyokaiKubun"));
            }

            public txtGenmenGekihenDanwaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenGekihenDanwaKubun"));
            }

            public SogoShokaiGenmenGengakuFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuFutan"));
            }

            public txtGenmenFutanKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKetteiKubun"));
            }

            public txtGenmenFutanKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanKetteiYMD"));
            }

            public txtGenmenFutanTekiyoKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanTekiyoKaishiYMD"));
            }

            public txtGenmenFutanYukoKigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanYukoKigen"));
            }

            public txtGenmenFutanKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanKyufuritsu"));
            }

            public txtGenmenFutanFutanshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanFutanshaNo"));
            }

            public txtGenmenFutanJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanJukyushaNo"));
            }

            public txtGenmenFutanKyoshitsuShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKyoshitsuShubetsu"));
            }

            public txtGenmenFutanShokuji(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanShokuji"));
            }

            public txtGenmenFutanUnit(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnit"));
            }

            public txtGenmenFutanUnitJun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnitJun"));
            }

            public txtGenmenFutanTokuyo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTokuyo"));
            }

            public txtGenmenFutanRoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanRoken"));
            }

            public txtGenmenFutanTasho(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTasho"));
            }

            public txtGenmenFutanSeigen(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanSeigen"));
            }

            public txtGenmenFutanGengakuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanGengakuKubun"));
            }

            public txtGenmenFutanFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanFutangaku"));
            }

            public txtGenmenFutanHyojunKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanHyojunKubun"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

