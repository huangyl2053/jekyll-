/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />

module DBC {

     export module JukyushaIdoRenrakuhyo {

        export class Events {

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

            public txtRenrakuhyoIdoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoIdoDate"));
            }

            public radRenrakuhyoIdoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRenrakuhyoIdoKubun"));
            }

            public ddlIdoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIdoJiyu"));
            }

            public txtRenrakuhyoHihoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRenrakuhyoHihoNo"));
            }

            public txtRenrakuhyoHihoName(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtRenrakuhyoHihoName"));
            }

            public txtHihoBirthday(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHihoBirthday"));
            }

            public radHihoSex(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHihoSex"));
            }

            public txtShikakuShutokuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuShutokuDate"));
            }

            public txtShikakuSoshitsuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShikakuSoshitsuDate"));
            }

            public txtShokisaiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            }

            public txtKoikiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKoikiHokenshaNo"));
            }

            public txtRenrakuhyoSendYM(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtRenrakuhyoSendYM"));
            }

            public JukyushaIdoRenrakuhyoTeisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTeisei"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
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

            public JukyushaIdoRenrakuhyoYokaigonintei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoYokaigonintei"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public radShinseiType(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseiType"));
            }

            public btnYokaigoninteiRireki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnYokaigoninteiRireki"));
            }

            public ddlYokaigoJotaiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigoJotaiKubun"));
            }

            public radHenkoShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHenkoShinseichuKubun"));
            }

            public txtNinteiDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiDateRange"));
            }

            public radMinashiYokaigoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMinashiYokaigoKubun"));
            }

            public JukyushaIdoRenrakuhyoShikyugendoKijungaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoShikyugendoKijungaku"));
            }

            public lblKyuHomonTsusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyuHomonTsusho"));
            }

            public txtKyuHomonTsushoShikyuGendoKijungaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyuHomonTsushoShikyuGendoKijungaku"));
            }

            public txtKyuHomonTsushoKanriTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuHomonTsushoKanriTekiyoDateRange"));
            }

            public lblKyuTankiNyusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyuTankiNyusho"));
            }

            public txtKyuTankiNyushoShikyuGendoKijungaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyuTankiNyushoShikyuGendoKijungaku"));
            }

            public txtKyuTankiNyushoKanriTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuTankiNyushoKanriTekiyoDateRange"));
            }

            public JukyushaIdoRenrakuhyoKyotakuServicePlan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyotakuServicePlan"));
            }

            public radPlanSakuseiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radPlanSakuseiKubun"));
            }

            public btnKyotakuServiceRireki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceRireki"));
            }

            public txtShienJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));
            }

            public txtShienJigyoshaName(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtShienJigyoshaName"));
            }

            public txtKyotakuServicePlanTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyotakuServicePlanTekiyoDateRange"));
            }

            public radShokiboKyotakuServiceRiyoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokiboKyotakuServiceRiyoUmu"));
            }

            public JushochiTokureiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JushochiTokureiPanel"));
            }

            public radJushochiTokureiTaishoshaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJushochiTokureiTaishoshaKubun"));
            }

            public txtJushochiTokureiTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushochiTokureiTekiyoDateRange"));
            }

            //public ccdHokenshaJoho(): DBZ.HokenshaJoho.ModeController {
            //    return new DBZ.HokenshaJoho.ModeController(this.convFiledName("ccdHokenshaJoho"));
            //}

            public JukyushaIdoRenrakuhyoGemmenGengaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengaku"));
            }

            public radGemmenShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radGemmenShinseichuKubun"));
            }

            public btnGemmenGengakuRireki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnGemmenGengakuRireki"));
            }

            public JukyushaIdoRenrakuhyoGemmenGengakuSub(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoGemmenGengakuSub"));
            }

            public JukyushaIdoRenrakuhyoRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRiyoshaFutan"));
            }

            public radRiyoshaFutanKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutanKubun"));
            }

            public txtRiyoshaFutanKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanKyufuritsu"));
            }

            public txtRiyoshaFutanTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyoshaFutanTekiyoDateRange"));
            }

            public JukyushaIdoRenrakuhyoFukushiHojinKeigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoFukushiHojinKeigen"));
            }

            public txtKeigenritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenritsu"));
            }

            public txtKeigenritsuTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeigenritsuTekiyoDateRange"));
            }

            public JukyushaIdoRenrakuhyoHyojunFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoHyojunFutan"));
            }

            public radHyojunFutanKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojunFutanKubun"));
            }

            public txtHyojunFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHyojunFutangaku"));
            }

            public txtHyojunFutanTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHyojunFutanTekiyoDateRange"));
            }

            public JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi"));
            }

            public radNinteiShinseichuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinteiShinseichuKubun"));
            }

            public radServiceKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            }

            public radTokureiKeigenSochiTaisho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTokureiKeigenSochiTaisho"));
            }

            public txtShokuhiFutanGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhiFutanGendogaku"));
            }

            public txtFutanGendogakuTekiyoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtFutanGendogakuTekiyoDateRange"));
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

            public JukyushaIdoRenrakuhyoKokiKoreiKokuho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKoreiKokuho"));
            }

            public JukyushaIdoRenrakuhyoKokiKorei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokiKorei"));
            }

            public txtKokiKoreiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHokenshaNo"));
            }

            public txtKokiKoreiHihokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokiKoreiHihokenshaNo"));
            }

            public JukyushaIdoRenrakuhyoKokuho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKokuho"));
            }

            public txtKokuhoHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHokenshaNo"));
            }

            public txtKokuhoHihokenshashoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoHihokenshashoNo"));
            }

            public txtKokuhoKojinNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKokuhoKojinNo"));
            }

            public JukyushaIdoRenrakuhyoKyufuSeigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoKyufuSeigen"));
            }

            public radKohiFutanJogengakuGengakuUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKohiFutanJogengakuGengakuUmu"));
            }

            public btnKyufuSeigenRireki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKyufuSeigenRireki"));
            }

            public txtKyufuritsuHikisageDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuritsuHikisageDateRange"));
            }

            public txtShokanBaraikaDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShokanBaraikaDateRange"));
            }

            public RiyosyaFutanWariaiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RiyosyaFutanWariaiPanel"));
            }

            public txtRiyosyaFutanWariaiYukoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyosyaFutanWariaiYukoYMD"));
            }

            public JukyushaIdoRenrakuhyoNijiyoboJigyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoNijiyoboJigyo"));
            }

            public radNijiyoboJigyoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNijiyoboJigyoKubun"));
            }

            public txtNijiyoboJigyoYukoDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiyoboJigyoYukoDateRange"));
            }

            public JukyushaIdoRenrakuhyoRojinHoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyushaIdoRenrakuhyoRojinHoken"));
            }

            public RokenShichosonNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("RokenShichosonNo"));
            }

            public RokenJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("RokenJukyushaNo"));
            }

            public RokenKohiFutanshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("RokenKohiFutanshaNo"));
            }

        }

     }

}

