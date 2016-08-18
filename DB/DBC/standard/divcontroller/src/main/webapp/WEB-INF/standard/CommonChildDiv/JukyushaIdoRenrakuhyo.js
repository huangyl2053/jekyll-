var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return ["DisplayMode"];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        JukyushaIdoRenrakuhyo.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shinki = function () {
                    this.controls.txtIdoYMD().disabled = false;
                    this.controls.radIdoKubun().disabled = false;
                    this.controls.ddlJukyushaIdoJiyu().disabled = false;
                    this.controls.txtHiHokenshaNo().disabled = true;
                    this.controls.txtHiHokenshaNameKana().disabled = false;
                    this.controls.txtUmareYMD().disabled = false;
                    this.controls.radSeibetsu().disabled = false;
                    this.controls.txtShikakuShutokuYMD().disabled = false;
                    this.controls.txtShikakuSoshitsuYMD().disabled = false;
                    this.controls.txtShoKisaiHokenshaNo().disabled = false;
                    this.controls.txtKoikiHokenshaNo().disabled = true;
                    this.controls.txtSofuYM().disabled = true;

                    this.controls.JukyushaIdoRenrakuhyoTeisei().visible = false;

                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.radShinseiShubetsu().disabled = false;
                    this.controls.ddlYokaigoJotaiKubun().disabled = false;
                    this.controls.radHenkoShinseichuKubun().disabled = false;
                    this.controls.txtNinteiYukoKikanYMD().disabled = false;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = false;

                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = false;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = false;

                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = false;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = false;

                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = false;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = false;
                    this.controls.HokenshaJohoPanel().disabled = false;

                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = false;

                    this.controls.KokiKoureiPanel().disabled = false;
                    this.controls.KokuhoPanel().disabled = false;

                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = false;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;

                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = false;

                    this.controls.radNijiyoboJigyoKubun().disabled = false;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = true;

                    this.controls.txtRojinHokenShichosonNo().disabled = false;
                    this.controls.txtRojinHokenJukyushaNo().disabled = false;
                    this.controls.txtKohiFutanshaNo().disabled = false;
                };

                DisplayMode.prototype.teisei = function () {
                    this.controls.txtIdoYMD().disabled = true;
                    this.controls.radIdoKubun().disabled = false;
                    this.controls.ddlJukyushaIdoJiyu().disabled = false;
                    this.controls.txtHiHokenshaNo().disabled = true;
                    this.controls.txtHiHokenshaNameKana().disabled = false;
                    this.controls.txtUmareYMD().disabled = false;
                    this.controls.radSeibetsu().disabled = false;
                    this.controls.txtShikakuShutokuYMD().disabled = false;
                    this.controls.txtShikakuSoshitsuYMD().disabled = false;
                    this.controls.txtShoKisaiHokenshaNo().disabled = false;
                    this.controls.txtKoikiHokenshaNo().disabled = true;
                    this.controls.txtSofuYM().disabled = true;

                    this.controls.JukyushaIdoRenrakuhyoTeisei().disabled = false;
                    this.controls.txtTeiseiYMD().disabled = false;
                    this.controls.radTeiseiKubunCode().disabled = false;

                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.radShinseiShubetsu().disabled = false;
                    this.controls.ddlYokaigoJotaiKubun().disabled = false;
                    this.controls.radHenkoShinseichuKubun().disabled = false;
                    this.controls.txtNinteiYukoKikanYMD().disabled = false;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = false;

                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = false;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = false;

                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = false;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = false;

                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = false;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = false;
                    this.controls.HokenshaJohoPanel().disabled = false;

                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = false;

                    this.controls.KokiKoureiPanel().disabled = false;
                    this.controls.KokuhoPanel().disabled = false;

                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = false;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;

                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = false;

                    this.controls.radNijiyoboJigyoKubun().disabled = false;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = false;

                    this.controls.txtRojinHokenShichosonNo().disabled = false;
                    this.controls.txtRojinHokenJukyushaNo().disabled = false;
                    this.controls.txtKohiFutanshaNo().disabled = false;
                };

                DisplayMode.prototype.saihakko = function () {
                    this.shokai();
                };

                DisplayMode.prototype.shokai = function () {
                    this.controls.txtIdoYMD().disabled = true;
                    this.controls.radIdoKubun().disabled = true;
                    this.controls.ddlJukyushaIdoJiyu().disabled = true;
                    this.controls.txtHiHokenshaNo().disabled = true;
                    this.controls.txtHiHokenshaNameKana().disabled = true;
                    this.controls.txtUmareYMD().disabled = true;
                    this.controls.radSeibetsu().disabled = true;
                    this.controls.txtShikakuShutokuYMD().disabled = true;
                    this.controls.txtShikakuSoshitsuYMD().disabled = true;
                    this.controls.txtShoKisaiHokenshaNo().disabled = true;
                    this.controls.txtKoikiHokenshaNo().disabled = true;
                    this.controls.txtSofuYM().disabled = true;

                    this.controls.JukyushaIdoRenrakuhyoTeisei().disabled = true;
                    this.controls.txtTeiseiYMD().disabled = true;
                    this.controls.radTeiseiKubunCode().disabled = true;

                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = true;
                    this.controls.radShinseiShubetsu().disabled = true;
                    this.controls.ddlYokaigoJotaiKubun().disabled = true;
                    this.controls.radHenkoShinseichuKubun().disabled = true;
                    this.controls.txtNinteiYukoKikanYMD().disabled = true;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = true;

                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = true;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = true;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = true;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = true;

                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = true;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = true;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = true;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = true;

                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = true;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = true;
                    this.controls.HokenshaJohoPanel().disabled = true;

                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = true;

                    this.controls.KokiKoureiPanel().disabled = true;
                    this.controls.KokuhoPanel().disabled = true;

                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = true;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;

                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = true;

                    this.controls.radNijiyoboJigyoKubun().disabled = true;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = true;

                    this.controls.txtRojinHokenShichosonNo().disabled = true;
                    this.controls.txtRojinHokenJukyushaNo().disabled = true;
                    this.controls.txtKohiFutanshaNo().disabled = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(JukyushaIdoRenrakuhyo.Modes || (JukyushaIdoRenrakuhyo.Modes = {}));
        var Modes = JukyushaIdoRenrakuhyo.Modes;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getTeiseiInfoVisible = function () {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().visible;
            };

            PublicProperties.prototype.setTeiseiInfoVisible = function (value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().visible = value;
            };

            PublicProperties.prototype.getTeiseiInfoDisplayNone = function () {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone;
            };

            PublicProperties.prototype.setTeiseiInfoDisplayNone = function (value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone = value;
            };
            return PublicProperties;
        })();
        JukyushaIdoRenrakuhyo.PublicProperties = PublicProperties;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
