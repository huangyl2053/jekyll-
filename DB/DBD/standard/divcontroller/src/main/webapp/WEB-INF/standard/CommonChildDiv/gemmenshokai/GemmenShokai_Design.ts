/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module GemmenShokai {

        export class Events {

            public static onClick_BtnClose(): string {
                return "onClick_BtnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "GemmenShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.GemmenShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.GemmenShokai.Controls.myType() + "_" + fieldName;
            }

            public GemmenShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public YokaigoNinteiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YokaigoNinteiJoho"));
            }

            public txtYokaigoNinteiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiJokyo"));
            }

            public txtYokaigoNinteiShinseiYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiShinseiYmd"));
            }

            public txtYokaigoNinteiShinseiShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiShinseiShurui"));
            }

            public txtYokaigoNinteiKyuSochiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiKyuSochiKubun"));
            }

            public txtYokaigodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            }

            public txtYokaigoNinteiKaishiYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiKaishiYmd"));
            }

            public txtYokaigoNinteiShuryoYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiShuryoYmd"));
            }

            public txtYokaigoNinteiNinteiYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiNinteiYmd"));
            }

            public ShinseiChuJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinseiChuJoho"));
            }

            public txtShinseiChuShinseiYmd(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiChuShinseiYmd"));
            }

            public txtShinseiChuShinseiShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiChuShinseiShurui"));
            }

            public KakushuGemmenJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KakushuGemmenJoho"));
            }

            public lblKetteiKubun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKetteiKubun"));
            }

            public lblKaishiYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaishiYMD"));
            }

            public lblShuryoYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShuryoYMD"));
            }

            public lblShinseiJokyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinseiJokyo"));
            }

            public txtFutanGendoGakuKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuKetteiKubun"));
            }

            public txtFutanGendoGakuKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuKaishiYMD"));
            }

            public txtFutanGendoGakuShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuShuryoYMD"));
            }

            public txtRiyoshaFutanDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanDankai"));
            }

            public txtFutanGendoGakuKyuSochi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuKyuSochi"));
            }

            public txtFutanGendoGakuShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuShinseiJokyo"));
            }

            public txtFutanGendoGakuShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuShinseiYMD"));
            }

            public txtRiyoshaFutanKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanKetteiKubun"));
            }

            public txtRiyoshaFutanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanKaishiYMD"));
            }

            public txtRiyoshaFutanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanShuryoYMD"));
            }

            public txtRiyoshaFutanKyufuRitsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanKyufuRitsu"));
            }

            public txtRiyoshaFutanShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanShinseiJokyo"));
            }

            public txtRiyoshaFutanShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanShinseiYMD"));
            }

            public txtHomonKaigoKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoKetteiKubun"));
            }

            public txtHomonKaigoKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHomonKaigoKaishiYMD"));
            }

            public txtHomonKaigoShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHomonKaigoShuryoYMD"));
            }

            public txtHomonKaigoKyufuRitsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoKyufuRitsu"));
            }

            public txtHomonKaigoBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoBango"));
            }

            public txtHomonKaigoHobetsuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoHobetsuKubun"));
            }

            public txtShaFukuKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShaFukuKetteiKubun"));
            }

            public txtShaFukuKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuKaishiYMD"));
            }

            public txtShaFukuShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuShuryoYMD"));
            }

            public txtShaFukuKyufuRitsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShaFukuKyufuRitsu"));
            }

            public txtShaFukuBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShaFukuBango"));
            }

            public txtShaFukuShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShaFukuShinseiJokyo"));
            }

            public txtShaFukuShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuShinseiYMD"));
            }

            public txtTokubetsuChiikiKasanKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKetteiKubun"));
            }

            public txtTokubetsuChiikiKasanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanKaishiYMD"));
            }

            public txtTokubetsuChiikiKasanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanShuryoYMD"));
            }

            public txtTokubetsuChiikiKasanKyufuRitsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKyufuRitsu"));
            }

            public txtTokubetsuChiikiKasanKetteiKubunBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKetteiKubunBango"));
            }

            public txtTokubetsuChiikiKasanShinseiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanShinseiJokyo"));
            }

            public txtTokubetsuChiikiKasanShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanShinseiYMD"));
            }

            public RoreiSeihoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RoreiSeihoJoho"));
            }

            public lblRoreiFukushiNenkin(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRoreiFukushiNenkin"));
            }

            public txtRoreiJukyuKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRoreiJukyuKaishiYMD"));
            }

            public txtRoreiJukyuShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRoreiJukyuShuryoYMD"));
            }

            public lblSeikatsuHogo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeikatsuHogo"));
            }

            public txtSeihoJukyuKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeihoJukyuKaishiYMD"));
            }

            public txtSeihoJukyuHaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeihoJukyuHaishiYMD"));
            }

            public txtSeihoShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeihoShubetsu"));
            }

            public KyufuSeigenJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyufuSeigenJoho"));
            }

            public lblShiharaiHohoHenko(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShiharaiHohoHenko"));
            }

            public txtShiharaiHohoHenkoTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiHohoHenkoTorokuKubun"));
            }

            public txtShiharaiHohoHenkoKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShiharaiHohoHenkoKaishiYMD"));
            }

            public txtShiharaiHohoHenkoShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShiharaiHohoHenkoShuryoYMD"));
            }

            public lblKyufuGakuGengaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyufuGakuGengaku"));
            }

            public txtKyufuGakuGengakuTorokuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuGakuGengakuTorokuKubun"));
            }

            public txtKyufuGakuGengakuKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGakuGengakuKaishiYMD"));
            }

            public txtKyufuGakuGengakuShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGakuGengakuShuryoYMD"));
            }

            public FutanWariaiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FutanWariaiJoho"));
            }

            public txtFutanWariai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFutanWariai"));
            }

            public txtFutanWariaiKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanWariaiKaishiYMD"));
            }

            public txtFutanWariaiShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanWariaiShuryoYMD"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

