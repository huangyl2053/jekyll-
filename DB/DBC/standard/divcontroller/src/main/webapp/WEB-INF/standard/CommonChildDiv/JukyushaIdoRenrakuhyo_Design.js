var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyushaIdoRenrakuhyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyushaIdoRenrakuhyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyushaIdoRenrakuhyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKihonJoho = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKihonJoho"));
            };

            Controls.prototype.txtRenrakuhyoIdoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoIdoDate"));
            };

            Controls.prototype.radRenrakuhyoIdoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radRenrakuhyoIdoKubun"));
            };

            Controls.prototype.ddlIdoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIdoJiyu"));
            };

            Controls.prototype.txtRenrakuhyoHihoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRenrakuhyoHihoNo"));
            };

            Controls.prototype.txtRenrakuhyoHihoName = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtRenrakuhyoHihoName"));
            };

            Controls.prototype.txtHihoBirthday = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHihoBirthday"));
            };

            Controls.prototype.radHihoSex = function () {
                return new UZA.RadioButton(this.convFiledName("radHihoSex"));
            };

            Controls.prototype.txtShikakuShutokuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuShutokuDate"));
            };

            Controls.prototype.txtShikakuSoshitsuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuSoshitsuDate"));
            };

            Controls.prototype.txtShokisaiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            };

            Controls.prototype.txtKoikiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKoikiHokenshaNo"));
            };

            Controls.prototype.txtRenrakuhyoSendYM = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoSendYM"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoTeisei = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTeisei"));
            };

            Controls.prototype.lin2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            };

            Controls.prototype.txtTeiseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeiseiYMD"));
            };

            Controls.prototype.radTeiseiKubunCode = function () {
                return new UZA.RadioButton(this.convFiledName("radTeiseiKubunCode"));
            };

            Controls.prototype.lin3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoYokaigonintei = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoYokaigonintei"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.radShinseiType = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseiType"));
            };

            Controls.prototype.btnYokaigoninteiRireki = function () {
                return new UZA.Button(this.convFiledName("btnYokaigoninteiRireki"));
            };

            Controls.prototype.ddlYokaigoJotaiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigoJotaiKubun"));
            };

            Controls.prototype.radHenkoShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radHenkoShinseichuKubun"));
            };

            Controls.prototype.txtNinteiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiDateRange"));
            };

            Controls.prototype.radMinashiYokaigoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiYokaigoKubun"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoShikyugendoKijungaku = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoShikyugendoKijungaku"));
            };

            Controls.prototype.lblKyuHomonTsusho = function () {
                return new UZA.Label(this.convFiledName("lblKyuHomonTsusho"));
            };

            Controls.prototype.txtKyuHomonTsushoShikyuGendoKijungaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyuHomonTsushoShikyuGendoKijungaku"));
            };

            Controls.prototype.txtKyuHomonTsushoKanriTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuHomonTsushoKanriTekiyoDateRange"));
            };

            Controls.prototype.lblKyuTankiNyusho = function () {
                return new UZA.Label(this.convFiledName("lblKyuTankiNyusho"));
            };

            Controls.prototype.txtKyuTankiNyushoShikyuGendoKijungaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyuTankiNyushoShikyuGendoKijungaku"));
            };

            Controls.prototype.txtKyuTankiNyushoKanriTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuTankiNyushoKanriTekiyoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKyotakuServicePlan = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyotakuServicePlan"));
            };

            Controls.prototype.radPlanSakuseiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radPlanSakuseiKubun"));
            };

            Controls.prototype.btnKyotakuServiceRireki = function () {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceRireki"));
            };

            Controls.prototype.txtShienJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));
            };

            Controls.prototype.txtShienJigyoshaName = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtShienJigyoshaName"));
            };

            Controls.prototype.txtKyotakuServicePlanTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyotakuServicePlanTekiyoDateRange"));
            };

            Controls.prototype.radShokiboKyotakuServiceRiyoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radShokiboKyotakuServiceRiyoUmu"));
            };

            Controls.prototype.JushochiTokureiPanel = function () {
                return new UZA.Panel(this.convFiledName("JushochiTokureiPanel"));
            };

            Controls.prototype.radJushochiTokureiTaishoshaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radJushochiTokureiTaishoshaKubun"));
            };

            Controls.prototype.txtJushochiTokureiTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushochiTokureiTekiyoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoGemmenGengaku = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengaku"));
            };

            Controls.prototype.radGemmenShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radGemmenShinseichuKubun"));
            };

            Controls.prototype.btnGemmenGengakuRireki = function () {
                return new UZA.Button(this.convFiledName("btnGemmenGengakuRireki"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoGemmenGengakuSub = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengakuSub"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRiyoshaFutan"));
            };

            Controls.prototype.radRiyoshaFutanKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutanKubun"));
            };

            Controls.prototype.txtRiyoshaFutanKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanKyufuritsu"));
            };

            Controls.prototype.txtRiyoshaFutanTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyoshaFutanTekiyoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoFukushiHojinKeigen = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoFukushiHojinKeigen"));
            };

            Controls.prototype.txtKeigenritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenritsu"));
            };

            Controls.prototype.txtKeigenritsuTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeigenritsuTekiyoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoHyojunFutan = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoHyojunFutan"));
            };

            Controls.prototype.radHyojunFutanKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojunFutanKubun"));
            };

            Controls.prototype.txtHyojunFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHyojunFutangaku"));
            };

            Controls.prototype.txtHyojunFutanTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHyojunFutanTekiyoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"));
            };

            Controls.prototype.radNinteiShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNinteiShinseichuKubun"));
            };

            Controls.prototype.radServiceKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            };

            Controls.prototype.radTokureiKeigenSochiTaisho = function () {
                return new UZA.RadioButton(this.convFiledName("radTokureiKeigenSochiTaisho"));
            };

            Controls.prototype.txtShokuhiFutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhiFutanGendogaku"));
            };

            Controls.prototype.txtFutanGendogakuTekiyoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutanGendogakuTekiyoDateRange"));
            };

            Controls.prototype.lblKyojuhiFutanGendogaku = function () {
                return new UZA.Label(this.convFiledName("lblKyojuhiFutanGendogaku"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.txtJuraigataKoshitsuTokuyoFutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuTokuyoFutanGendogaku"));
            };

            Controls.prototype.txtKyotakuhiShin1FutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin1FutanGendogaku"));
            };

            Controls.prototype.txtJuraigataKoshitsuRokenRyoyoFutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku"));
            };

            Controls.prototype.txtKyotakuhiShin2FutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin2FutanGendogaku"));
            };

            Controls.prototype.txtTashoshitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTashoshitsu"));
            };

            Controls.prototype.txtKyotakuhiShin3utanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin3utanGendogaku"));
            };

            Controls.prototype.txtUnitKoshitsuGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitKoshitsuGendogaku"));
            };

            Controls.prototype.txtUnitJunKoshitsuFutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitJunKoshitsuFutanGendogaku"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKokiKoreiKokuho = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKoreiKokuho"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKokiKorei = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKorei"));
            };

            Controls.prototype.txtKokiKoreiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHokenshaNo"));
            };

            Controls.prototype.txtKokiKoreiHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHihokenshaNo"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKokuho = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokuho"));
            };

            Controls.prototype.txtKokuhoHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHokenshaNo"));
            };

            Controls.prototype.txtKokuhoHihokenshashoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHihokenshashoNo"));
            };

            Controls.prototype.txtKokuhoKojinNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoKojinNo"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoKyufuSeigen = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyufuSeigen"));
            };

            Controls.prototype.radKohiFutanJogengakuGengakuUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radKohiFutanJogengakuGengakuUmu"));
            };

            Controls.prototype.btnKyufuSeigenRireki = function () {
                return new UZA.Button(this.convFiledName("btnKyufuSeigenRireki"));
            };

            Controls.prototype.txtKyufuritsuHikisageDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuritsuHikisageDateRange"));
            };

            Controls.prototype.txtShokanBaraikaDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShokanBaraikaDateRange"));
            };

            Controls.prototype.RiyosyaFutanWariaiPanel = function () {
                return new UZA.Panel(this.convFiledName("RiyosyaFutanWariaiPanel"));
            };

            Controls.prototype.txtRiyosyaFutanWariaiYukoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyosyaFutanWariaiYukoYMD"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoNijiyoboJigyo = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoNijiyoboJigyo"));
            };

            Controls.prototype.radNijiyoboJigyoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNijiyoboJigyoKubun"));
            };

            Controls.prototype.txtNijiyoboJigyoYukoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiyoboJigyoYukoDateRange"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoRojinHoken = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRojinHoken"));
            };

            Controls.prototype.RokenShichosonNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("RokenShichosonNo"));
            };

            Controls.prototype.RokenJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("RokenJukyushaNo"));
            };

            Controls.prototype.RokenKohiFutanshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("RokenKohiFutanshaNo"));
            };
            return Controls;
        })();
        JukyushaIdoRenrakuhyo.Controls = Controls;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
