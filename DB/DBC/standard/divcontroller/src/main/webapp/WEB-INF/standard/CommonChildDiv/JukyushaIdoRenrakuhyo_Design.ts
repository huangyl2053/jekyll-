/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JukyushaIdoRenrakuhyo {

        export class Events {

            public static onBlur_txtIdoYMD(): string {
                return "onBlur_txtIdoYMD";
            }

            public static onClick_radKyotakuServiceSakuseiKubun(): string {
                return "onClick_radKyotakuServiceSakuseiKubun";
            }

            public static onBlur_txtKyotakuKaigoShienJigyoshoNo(): string {
                return "onBlur_txtKyotakuKaigoShienJigyoshoNo";
            }

            public static onBlur_txtShisetsuShozaiHokenjaNo(): string {
                return "onBlur_txtShisetsuShozaiHokenjaNo";
            }

            public static onOkClose_btnSearch(): string {
                return "onOkClose_btnSearch";
            }

            public static onBeforeOpenDialog_btnSearch(): string {
                return "onBeforeOpenDialog_btnSearch";
            }

            public static onClick_radNijiyoboJigyoKubun(): string {
                return "onClick_radNijiyoboJigyoKubun";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyushaIdoRenrakuhyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            }

            public JukyushaIdoRenrakuhyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public JukyushaIdoRenrakuhyoKihonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKihonJoho"));
            }

            public txtIdoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYMD"));
            }

            public radIdoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdoKubun"));
            }

            public ddlJukyushaIdoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJukyushaIdoJiyu"));
            }

            public txtHiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHiHokenshaNo"));
            }

            public txtHiHokenshaNameKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtHiHokenshaNameKana"));
            }

            public txtUmareYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtUmareYMD"));
            }

            public radSeibetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeibetsu"));
            }

            public txtShikakuShutokuYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuShutokuYMD"));
            }

            public txtShikakuSoshitsuYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuSoshitsuYMD"));
            }

            public txtShoKisaiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShoKisaiHokenshaNo"));
            }

            public txtKoikiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKoikiHokenshaNo"));
            }

            public txtSofuYM(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSofuYM"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            }

            public JukyushaIdoRenrakuhyoTeisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTeisei"));
            }

            public txtTeiseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeiseiYMD"));
            }

            public radTeiseiKubunCode(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeiseiKubunCode"));
            }

            public lin3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            }

            public YokaigoNinteiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("YokaigoNinteiPanel"));
            }

            public txtShinseiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiYMD"));
            }

            public radShinseiShubetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseiShubetsu"));
            }

            public btnYokaigoninteiRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnYokaigoninteiRireki"));
            }

            public ddlYokaigoJotaiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigoJotaiKubun"));
            }

            public radHenkoShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHenkoShinseichuKubun"));
            }

            public txtNinteiYukoKikanYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikanYMD"));
            }

            public radMinashiYokaigoJotaiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMinashiYokaigoJotaiKubun"));
            }

            public ShikyuGendoKijungakuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShikyuGendoKijungakuPanel"));
            }

            public lblKyuHomonTsusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyuHomonTsusho"));
            }

            public txtHomonTsushoServiceShikyuGendoKijungaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHomonTsushoServiceShikyuGendoKijungaku"));
            }

            public txtHomonTsushoServiceJogenKanriTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHomonTsushoServiceJogenKanriTekiyoYMD"));
            }

            public lblKyuTankiNyusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyuTankiNyusho"));
            }

            public txtTankiNyushoServiceShikyuGendoKijungaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTankiNyushoServiceShikyuGendoKijungaku"));
            }

            public txtTankinyushoServiceJogenKanriTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTankinyushoServiceJogenKanriTekiyoYMD"));
            }

            public KyotakuServicePlanPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyotakuServicePlanPanel"));
            }

            public radKyotakuServiceSakuseiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKyotakuServiceSakuseiKubun"));
            }

            public btnKyotakuServiceRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKyotakuServiceRireki"));
            }

            public txtKyotakuKaigoShienJigyoshoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakuKaigoShienJigyoshoNo"));
            }

            public txtKyotakuKaigoShienJigyoshoName(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKyotakuKaigoShienJigyoshoName"));
            }

            public txtKyotakuServiceTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyotakuServiceTekiyoYMD"));
            }

            public radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag"));
            }

            public JushochiTokureiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JushochiTokureiPanel"));
            }

            public radJushochiTokureiTaishoshaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJushochiTokureiTaishoshaKubun"));
            }

            public txtJushochiTokureiTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushochiTokureiTekiyoYMD"));
            }

            public HokenshaJohoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HokenshaJohoPanel"));
            }

            public txtShisetsuShozaiHokenjaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuShozaiHokenjaNo"));
            }

            public btnHokenshaSelect(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));
            }

            public txtHokenshaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            }

            public GemmenGengakuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GemmenGengakuPanel"));
            }

            public btnGemmenGengakuRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnGemmenGengakuRireki"));
            }

            public radGemmenShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radGemmenShinseichuKubun"));
            }

            public JukyushaIdoRenrakuhyoGemmenGengakuSub(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengakuSub"));
            }

            public JukyushaIdoRenrakuhyoRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRiyoshaFutan"));
            }

            public radRiyoshaFutanKubunCode(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutanKubunCode"));
            }

            public txtKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            }

            public txtTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoYMD"));
            }

            public JukyushaIdoRenrakuhyoFukushiHojinKeigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoFukushiHojinKeigen"));
            }

            public txtKeigenritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenritsu"));
            }

            public txtKeigenritsuTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeigenritsuTekiyoYMD"));
            }

            public JukyushaIdoRenrakuhyoHyojunFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoHyojunFutan"));
            }

            public radHyojunFutanKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojunFutanKubun"));
            }

            public txtFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            }

            public txtFutangakuTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutangakuTekiyoYMD"));
            }

            public JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"));
            }

            public radTokuteiNyushoshaNinteiShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTokuteiNyushoshaNinteiShinseichuKubun"));
            }

            public radTokuteiNyushoshaKaigoServiceKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTokuteiNyushoshaKaigoServiceKubun"));
            }

            public radKaizeisoTokureiGengakuSochiTaishoFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaizeisoTokureiGengakuSochiTaishoFlag"));
            }

            public txtShokuhiFutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhiFutanGendogaku"));
            }

            public txtFutanGendogakuTekiyoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutanGendogakuTekiyoYMD"));
            }

            public lblKyojuhiFutanGendogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyojuhiFutanGendogaku"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public txtJuraigataKoshitsuTokuyoFutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuTokuyoFutanGendogaku"));
            }

            public txtKyotakuhiShin1FutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin1FutanGendogaku"));
            }

            public txtJuraigataKoshitsuRokenRyoyoFutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku"));
            }

            public txtKyotakuhiShin2FutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin2FutanGendogaku"));
            }

            public txtTashoshitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTashoshitsu"));
            }

            public txtKyotakuhiShin3utanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyotakuhiShin3utanGendogaku"));
            }

            public txtUnitKoshitsuGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitKoshitsuGendogaku"));
            }

            public txtUnitJunKoshitsuFutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitJunKoshitsuFutanGendogaku"));
            }

            public KokiKoureiIryoHokenshaPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokiKoureiIryoHokenshaPanel"));
            }

            public KokiKoureiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokiKoureiPanel"));
            }

            public txtKokiKoureiIryoHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoureiIryoHokenshaNo"));
            }

            public txtKokikoureiIryoHiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokikoureiIryoHiHokenshaNo"));
            }

            public KokuhoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokuhoPanel"));
            }

            public txtKokuhoHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHokenshaNo"));
            }

            public txtKokuhoHiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHiHokenshaNo"));
            }

            public txtKokuhoKojinNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoKojinNo"));
            }

            public KyufuSeigenPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyufuSeigenPanel"));
            }

            public btnKyufuSeigenRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKyufuSeigenRireki"));
            }

            public radKohiFutanJogenGengakuAriFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKohiFutanJogenGengakuAriFlag"));
            }

            public txtShokanbaraikaYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShokanbaraikaYMD"));
            }

            public txtKyufuritsuHikisage(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuritsuHikisage"));
            }

            public RiyosyaFutanWariaiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RiyosyaFutanWariaiPanel"));
            }

            public txtRiyosyaFutanWariaiYukoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyosyaFutanWariaiYukoYMD"));
            }

            public NijiyoboJigyoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NijiyoboJigyoPanel"));
            }

            public radNijiyoboJigyoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNijiyoboJigyoKubun"));
            }

            public txtNijiyoboJigyoYukoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiyoboJigyoYukoDateRange"));
            }

            public RojinHokenPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RojinHokenPanel"));
            }

            public txtRojinHokenShichosonNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRojinHokenShichosonNo"));
            }

            public txtRojinHokenJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRojinHokenJukyushaNo"));
            }

            public txtKohiFutanshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiFutanshaNo"));
            }

        }

     }

}

