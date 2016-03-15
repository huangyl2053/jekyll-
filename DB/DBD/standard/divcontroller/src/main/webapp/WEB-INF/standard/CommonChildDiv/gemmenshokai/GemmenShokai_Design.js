var DBD;
(function (DBD) {
    (function (GemmenShokai) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        GemmenShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GemmenShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.GemmenShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.GemmenShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GemmenShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.YokaigoNinteiJoho = function () {
                return new UZA.Panel(this.convFiledName("YokaigoNinteiJoho"));
            };

            Controls.prototype.txtYokaigoNinteiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiJokyo"));
            };

            Controls.prototype.txtYokaigoNinteiShinseiYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiShinseiYmd"));
            };

            Controls.prototype.txtYokaigoNinteiShinseiShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiShinseiShurui"));
            };

            Controls.prototype.txtYokaigoNinteiKyuSochiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoNinteiKyuSochiKubun"));
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtYokaigoNinteiKaishiYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiKaishiYmd"));
            };

            Controls.prototype.txtYokaigoNinteiShuryoYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiShuryoYmd"));
            };

            Controls.prototype.txtYokaigoNinteiNinteiYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokaigoNinteiNinteiYmd"));
            };

            Controls.prototype.ShinseiChuJoho = function () {
                return new UZA.Panel(this.convFiledName("ShinseiChuJoho"));
            };

            Controls.prototype.txtShinseiChuShinseiYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiChuShinseiYmd"));
            };

            Controls.prototype.txtShinseiChuShinseiShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiChuShinseiShurui"));
            };

            Controls.prototype.KakushuGemmenJoho = function () {
                return new UZA.Panel(this.convFiledName("KakushuGemmenJoho"));
            };

            Controls.prototype.lblKetteiKubun = function () {
                return new UZA.Label(this.convFiledName("lblKetteiKubun"));
            };

            Controls.prototype.lblKaishiYMD = function () {
                return new UZA.Label(this.convFiledName("lblKaishiYMD"));
            };

            Controls.prototype.lblShuryoYMD = function () {
                return new UZA.Label(this.convFiledName("lblShuryoYMD"));
            };

            Controls.prototype.lblShinseiJokyo = function () {
                return new UZA.Label(this.convFiledName("lblShinseiJokyo"));
            };

            Controls.prototype.txtFutanGendoGakuKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuKetteiKubun"));
            };

            Controls.prototype.txtFutanGendoGakuKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuKaishiYMD"));
            };

            Controls.prototype.txtFutanGendoGakuShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuShuryoYMD"));
            };

            Controls.prototype.txtRiyoshaFutanDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanDankai"));
            };

            Controls.prototype.txtFutanGendoGakuKyuSochi = function () {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuKyuSochi"));
            };

            Controls.prototype.txtFutanGendoGakuShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtFutanGendoGakuShinseiJokyo"));
            };

            Controls.prototype.txtFutanGendoGakuShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanGendoGakuShinseiYMD"));
            };

            Controls.prototype.txtRiyoshaFutanKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanKetteiKubun"));
            };

            Controls.prototype.txtRiyoshaFutanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanKaishiYMD"));
            };

            Controls.prototype.txtRiyoshaFutanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanShuryoYMD"));
            };

            Controls.prototype.txtRiyoshaFutanKyufuRitsu = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanKyufuRitsu"));
            };

            Controls.prototype.txtRiyoshaFutanShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyoshaFutanShinseiJokyo"));
            };

            Controls.prototype.txtRiyoshaFutanShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRiyoshaFutanShinseiYMD"));
            };

            Controls.prototype.txtHomonKaigoKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoKetteiKubun"));
            };

            Controls.prototype.txtHomonKaigoKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHomonKaigoKaishiYMD"));
            };

            Controls.prototype.txtHomonKaigoShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHomonKaigoShuryoYMD"));
            };

            Controls.prototype.txtHomonKaigoKyufuRitsu = function () {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoKyufuRitsu"));
            };

            Controls.prototype.txtHomonKaigoBango = function () {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoBango"));
            };

            Controls.prototype.txtHomonKaigoHobetsuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHomonKaigoHobetsuKubun"));
            };

            Controls.prototype.txtShaFukuKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShaFukuKetteiKubun"));
            };

            Controls.prototype.txtShaFukuKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuKaishiYMD"));
            };

            Controls.prototype.txtShaFukuShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuShuryoYMD"));
            };

            Controls.prototype.txtShaFukuKyufuRitsu = function () {
                return new UZA.TextBox(this.convFiledName("txtShaFukuKyufuRitsu"));
            };

            Controls.prototype.txtShaFukuBango = function () {
                return new UZA.TextBox(this.convFiledName("txtShaFukuBango"));
            };

            Controls.prototype.txtShaFukuShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtShaFukuShinseiJokyo"));
            };

            Controls.prototype.txtShaFukuShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShaFukuShinseiYMD"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKetteiKubun"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanKaishiYMD"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanShuryoYMD"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanKyufuRitsu = function () {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKyufuRitsu"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanKetteiKubunBango = function () {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanKetteiKubunBango"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtTokubetsuChiikiKasanShinseiJokyo"));
            };

            Controls.prototype.txtTokubetsuChiikiKasanShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTokubetsuChiikiKasanShinseiYMD"));
            };

            Controls.prototype.RoreiSeihoJoho = function () {
                return new UZA.Panel(this.convFiledName("RoreiSeihoJoho"));
            };

            Controls.prototype.lblRoreiFukushiNenkin = function () {
                return new UZA.Label(this.convFiledName("lblRoreiFukushiNenkin"));
            };

            Controls.prototype.txtRoreiJukyuKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRoreiJukyuKaishiYMD"));
            };

            Controls.prototype.txtRoreiJukyuShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRoreiJukyuShuryoYMD"));
            };

            Controls.prototype.lblSeikatsuHogo = function () {
                return new UZA.Label(this.convFiledName("lblSeikatsuHogo"));
            };

            Controls.prototype.txtSeihoJukyuKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeihoJukyuKaishiYMD"));
            };

            Controls.prototype.txtSeihoJukyuHaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeihoJukyuHaishiYMD"));
            };

            Controls.prototype.txtSeihoShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtSeihoShubetsu"));
            };

            Controls.prototype.KyufuSeigenJoho = function () {
                return new UZA.Panel(this.convFiledName("KyufuSeigenJoho"));
            };

            Controls.prototype.lblShiharaiHohoHenko = function () {
                return new UZA.Label(this.convFiledName("lblShiharaiHohoHenko"));
            };

            Controls.prototype.txtShiharaiHohoHenkoTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiHohoHenkoTorokuKubun"));
            };

            Controls.prototype.txtShiharaiHohoHenkoKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShiharaiHohoHenkoKaishiYMD"));
            };

            Controls.prototype.txtShiharaiHohoHenkoShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShiharaiHohoHenkoShuryoYMD"));
            };

            Controls.prototype.lblKyufuGakuGengaku = function () {
                return new UZA.Label(this.convFiledName("lblKyufuGakuGengaku"));
            };

            Controls.prototype.txtKyufuGakuGengakuTorokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuGakuGengakuTorokuKubun"));
            };

            Controls.prototype.txtKyufuGakuGengakuKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGakuGengakuKaishiYMD"));
            };

            Controls.prototype.txtKyufuGakuGengakuShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGakuGengakuShuryoYMD"));
            };

            Controls.prototype.FutanWariaiJoho = function () {
                return new UZA.Panel(this.convFiledName("FutanWariaiJoho"));
            };

            Controls.prototype.txtFutanWariai = function () {
                return new UZA.TextBox(this.convFiledName("txtFutanWariai"));
            };

            Controls.prototype.txtFutanWariaiKaishiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanWariaiKaishiYMD"));
            };

            Controls.prototype.txtFutanWariaiShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtFutanWariaiShuryoYMD"));
            };
            return Controls;
        })();
        GemmenShokai.Controls = Controls;
    })(DBD.GemmenShokai || (DBD.GemmenShokai = {}));
    var GemmenShokai = DBD.GemmenShokai;
})(DBD || (DBD = {}));
