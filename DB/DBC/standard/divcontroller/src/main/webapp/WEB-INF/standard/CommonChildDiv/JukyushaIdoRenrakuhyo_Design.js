var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtIdoYMD = function () {
                return "onBlur_txtIdoYMD";
            };

            Events.onBlur_txtHokenshaNo = function () {
                return "onBlur_txtHokenshaNo";
            };

            Events.onOkClose_btnSearch = function () {
                return "onOkClose_btnSearch";
            };

            Events.onBeforeOpenDialog_btnSearch = function () {
                return "onBeforeOpenDialog_btnSearch";
            };

            Events.onClick_radNijiyoboJigyoKubun = function () {
                return "onClick_radNijiyoboJigyoKubun";
            };
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

            Controls.prototype.txtIdoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYMD"));
            };

            Controls.prototype.radIdoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radIdoKubun"));
            };

            Controls.prototype.ddlJukyushaIdoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJukyushaIdoJiyu"));
            };

            Controls.prototype.txtHiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHiHokenshaNo"));
            };

            Controls.prototype.txtHiHokenshaNameKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtHiHokenshaNameKana"));
            };

            Controls.prototype.txtUmareYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtUmareYMD"));
            };

            Controls.prototype.radSeibetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radSeibetsu"));
            };

            Controls.prototype.txtShikakuShutokuYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuShutokuYMD"));
            };

            Controls.prototype.txtShikakuSoshitsuYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuSoshitsuYMD"));
            };

            Controls.prototype.txtShoKisaiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShoKisaiHokenshaNo"));
            };

            Controls.prototype.txtKoikiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKoikiHokenshaNo"));
            };

            Controls.prototype.txtSofuYM = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSofuYM"));
            };

            Controls.prototype.lin2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoTeisei = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTeisei"));
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

            Controls.prototype.YokaigoNinteiPanel = function () {
                return new UZA.Panel(this.convFiledName("YokaigoNinteiPanel"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.radShinseiShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseiShubetsu"));
            };

            Controls.prototype.btnYokaigoninteiRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnYokaigoninteiRireki"));
            };

            Controls.prototype.ddlYokaigoJotaiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigoJotaiKubun"));
            };

            Controls.prototype.radHenkoShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radHenkoShinseichuKubun"));
            };

            Controls.prototype.txtNinteiYukoKikanYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikanYMD"));
            };

            Controls.prototype.radMinashiYokaigoJotaiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiYokaigoJotaiKubun"));
            };

            Controls.prototype.ShikyuGendoKijungakuPanel = function () {
                return new UZA.Panel(this.convFiledName("ShikyuGendoKijungakuPanel"));
            };

            Controls.prototype.lblKyuHomonTsusho = function () {
                return new UZA.Label(this.convFiledName("lblKyuHomonTsusho"));
            };

            Controls.prototype.txtHomonTsushoServiceShikyuGendoKijungaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHomonTsushoServiceShikyuGendoKijungaku"));
            };

            Controls.prototype.txtHomonTsushoServiceJogenKanriTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHomonTsushoServiceJogenKanriTekiyoYMD"));
            };

            Controls.prototype.lblKyuTankiNyusho = function () {
                return new UZA.Label(this.convFiledName("lblKyuTankiNyusho"));
            };

            Controls.prototype.txtTankiNyushoServiceShikyuGendoKijungaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTankiNyushoServiceShikyuGendoKijungaku"));
            };

            Controls.prototype.txtTankinyushoServiceJogenKanriTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTankinyushoServiceJogenKanriTekiyoYMD"));
            };

            Controls.prototype.KyotakuServicePlanPanel = function () {
                return new UZA.Panel(this.convFiledName("KyotakuServicePlanPanel"));
            };

            Controls.prototype.radKyotakuServiceSakuseiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radKyotakuServiceSakuseiKubun"));
            };

            Controls.prototype.btnKyotakuServiceRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKyotakuServiceRireki"));
            };

            Controls.prototype.txtKyotakuKaigoShienJigyoshoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakuKaigoShienJigyoshoNo"));
            };

            Controls.prototype.txtKyotakuKaigoShienJigyoshoName = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKyotakuKaigoShienJigyoshoName"));
            };

            Controls.prototype.txtKyotakuServiceTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyotakuServiceTekiyoYMD"));
            };

            Controls.prototype.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag"));
            };

            Controls.prototype.JushochiTokureiPanel = function () {
                return new UZA.Panel(this.convFiledName("JushochiTokureiPanel"));
            };

            Controls.prototype.radJushochiTokureiTaishoshaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radJushochiTokureiTaishoshaKubun"));
            };

            Controls.prototype.txtJushochiTokureiTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushochiTokureiTekiyoYMD"));
            };

            Controls.prototype.HokenshaJohoPanel = function () {
                return new UZA.Panel(this.convFiledName("HokenshaJohoPanel"));
            };

            Controls.prototype.txtShisetsuShozaiHokenjaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuShozaiHokenjaNo"));
            };

            Controls.prototype.btnHokenshaSelect = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));
            };

            Controls.prototype.txtHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            };

            Controls.prototype.GemmenGengakuPanel = function () {
                return new UZA.Panel(this.convFiledName("GemmenGengakuPanel"));
            };

            Controls.prototype.btnGemmenGengakuRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnGemmenGengakuRireki"));
            };

            Controls.prototype.radGemmenShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radGemmenShinseichuKubun"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoGemmenGengakuSub = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengakuSub"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRiyoshaFutan"));
            };

            Controls.prototype.radRiyoshaFutanKubunCode = function () {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutanKubunCode"));
            };

            Controls.prototype.txtKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            };

            Controls.prototype.txtTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoYMD"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoFukushiHojinKeigen = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoFukushiHojinKeigen"));
            };

            Controls.prototype.txtKeigenritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenritsu"));
            };

            Controls.prototype.txtKeigenritsuTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeigenritsuTekiyoYMD"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoHyojunFutan = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoHyojunFutan"));
            };

            Controls.prototype.radHyojunFutanKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojunFutanKubun"));
            };

            Controls.prototype.txtFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            };

            Controls.prototype.txtFutangakuTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutangakuTekiyoYMD"));
            };

            Controls.prototype.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi = function () {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"));
            };

            Controls.prototype.radTokuteiNyushoshaNinteiShinseichuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radTokuteiNyushoshaNinteiShinseichuKubun"));
            };

            Controls.prototype.radTokuteiNyushoshaKaigoServiceKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radTokuteiNyushoshaKaigoServiceKubun"));
            };

            Controls.prototype.radKaizeisoTokureiGengakuSochiTaishoFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radKaizeisoTokureiGengakuSochiTaishoFlag"));
            };

            Controls.prototype.txtShokuhiFutanGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhiFutanGendogaku"));
            };

            Controls.prototype.txtFutanGendogakuTekiyoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutanGendogakuTekiyoYMD"));
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

            Controls.prototype.KokiKoureiIryoHokenshaPanel = function () {
                return new UZA.Panel(this.convFiledName("KokiKoureiIryoHokenshaPanel"));
            };

            Controls.prototype.KokiKoureiPanel = function () {
                return new UZA.Panel(this.convFiledName("KokiKoureiPanel"));
            };

            Controls.prototype.txtKokiKoureiIryoHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoureiIryoHokenshaNo"));
            };

            Controls.prototype.txtKokikoureiIryoHiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokikoureiIryoHiHokenshaNo"));
            };

            Controls.prototype.KokuhoPanel = function () {
                return new UZA.Panel(this.convFiledName("KokuhoPanel"));
            };

            Controls.prototype.txtKokuhoHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHokenshaNo"));
            };

            Controls.prototype.txtKokuhoHiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHiHokenshaNo"));
            };

            Controls.prototype.txtKokuhoKojinNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoKojinNo"));
            };

            Controls.prototype.KyufuSeigenPanel = function () {
                return new UZA.Panel(this.convFiledName("KyufuSeigenPanel"));
            };

            Controls.prototype.btnKyufuSeigenRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKyufuSeigenRireki"));
            };

            Controls.prototype.radKohiFutanJogenGengakuAriFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radKohiFutanJogenGengakuAriFlag"));
            };

            Controls.prototype.txtShokanbaraikaYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShokanbaraikaYMD"));
            };

            Controls.prototype.txtKyufuritsuHikisage = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuritsuHikisage"));
            };

            Controls.prototype.RiyosyaFutanWariaiPanel = function () {
                return new UZA.Panel(this.convFiledName("RiyosyaFutanWariaiPanel"));
            };

            Controls.prototype.txtRiyosyaFutanWariaiYukoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyosyaFutanWariaiYukoYMD"));
            };

            Controls.prototype.NijiyoboJigyoPanel = function () {
                return new UZA.Panel(this.convFiledName("NijiyoboJigyoPanel"));
            };

            Controls.prototype.radNijiyoboJigyoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNijiyoboJigyoKubun"));
            };

            Controls.prototype.txtNijiyoboJigyoYukoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiyoboJigyoYukoDateRange"));
            };

            Controls.prototype.RojinHokenPanel = function () {
                return new UZA.Panel(this.convFiledName("RojinHokenPanel"));
            };

            Controls.prototype.txtRojinHokenShichosonNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRojinHokenShichosonNo"));
            };

            Controls.prototype.txtRojinHokenJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRojinHokenJukyushaNo"));
            };

            Controls.prototype.txtKohiFutanshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiFutanshaNo"));
            };
            return Controls;
        })();
        JukyushaIdoRenrakuhyo.Controls = Controls;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
