/// <reference path="JukyushaIdoRenrakuhyo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module JukyushaIdoRenrakuhyo {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return ["DisplayMode"];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
        }
        
        export module Modes {
            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                //新規モード
                public shinki(): void {
                    this.controls.txtIdoYMD().disabled = false;	//異動日
                    this.controls.radIdoKubun().disabled = false;	//異動区分
                    this.controls.ddlJukyushaIdoJiyu().disabled = false;	//異動事由
                    this.controls.txtHiHokenshaNo().disabled = true;	//被保険者番号
                    this.controls.txtHiHokenshaNameKana().disabled = false;	//カナ氏名
                    this.controls.txtUmareYMD().disabled = false;	//生年月日
                    this.controls.radSeibetsu().disabled = false;	//性別
                    this.controls.txtShikakuShutokuYMD().disabled = false;	//資格取得日
                    this.controls.txtShikakuSoshitsuYMD().disabled = false;	//資格喪失日
                    this.controls.txtShoKisaiHokenshaNo().disabled = false;	//証記載保険者番号
                    this.controls.txtKoikiHokenshaNo().disabled = true;	//広域保険者番号
                    this.controls.txtSofuYM().disabled = true;	//送付年月
                    
                    this.controls.JukyushaIdoRenrakuhyoTeisei().visible = false;
                    //this.controls.txtTeiseiYMD().disabled = false;	//訂正日
                    //this.controls.radTeiseiKubunCode().disabled = false;	//訂正区分
                    
                    //要介護認定エリア
                    //this.controls.YokaigoNinteiPanel().disabled = true;
                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.radShinseiShubetsu().disabled = false;
                    this.controls.ddlYokaigoJotaiKubun().disabled = false;
                    this.controls.radHenkoShinseichuKubun().disabled = false;
                    this.controls.txtNinteiYukoKikanYMD().disabled = false;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = false;
                    //支給限度基準額エリア
                    //this.controls.ShikyuGendoKijungakuPanel().disabled = true;
                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = false;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = false;
                    //居宅サービス計画エリア
                    //this.controls.KyotakuServicePlanPanel().disabled = true;
                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = false;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = false;
                    //住所地特例エリア
                    //this.controls.JushochiTokureiPanel().disabled = true;
                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = false;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = false;
                    this.controls.HokenshaJohoPanel().disabled = false;
                    //減免・減額エリア
                    //this.controls.GemmenGengakuPanel().disabled = true;
                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = false;
                    //後期高齢・国保エリア
                    //this.controls.KokiKoureiIryoHokenshaPanel().disabled = true;
                    this.controls.KokiKoureiPanel().disabled = false;
                    this.controls.KokuhoPanel().disabled = false;
                    //給付制限エリア
                    //this.controls.KyufuSeigenPanel().disabled = true;
                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = false;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;
                    //二割負担
                    //this.controls.RiyosyaFutanWariaiPanel().disabled = true;
                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = false;
                    //二次予防事業エリア
                    //this.controls.NijiyoboJigyoPanel().disabled = true;
                    this.controls.radNijiyoboJigyoKubun().disabled = false;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = true;
                    //老人保健エリア
                    //this.controls.RojinHokenPanel().disabled = true;
                    this.controls.txtRojinHokenShichosonNo().disabled = false;
                    this.controls.txtRojinHokenJukyushaNo().disabled = false;
                    this.controls.txtKohiFutanshaNo().disabled = false;
                }
                
                //訂正モード
                public teisei(): void {
                    this.controls.txtIdoYMD().disabled = true;	//異動日
                    this.controls.radIdoKubun().disabled = false;	//異動区分
                    this.controls.ddlJukyushaIdoJiyu().disabled = false;	//異動事由
                    this.controls.txtHiHokenshaNo().disabled = true;	//被保険者番号
                    this.controls.txtHiHokenshaNameKana().disabled = false;	//カナ氏名
                    this.controls.txtUmareYMD().disabled = false;	//生年月日
                    this.controls.radSeibetsu().disabled = false;	//性別
                    this.controls.txtShikakuShutokuYMD().disabled = false;	//資格取得日
                    this.controls.txtShikakuSoshitsuYMD().disabled = false;	//資格喪失日
                    this.controls.txtShoKisaiHokenshaNo().disabled = false;	//証記載保険者番号
                    this.controls.txtKoikiHokenshaNo().disabled = true;	//広域保険者番号
                    this.controls.txtSofuYM().disabled = true;	//送付年月
                    
                    this.controls.JukyushaIdoRenrakuhyoTeisei().disabled = false;
                    this.controls.txtTeiseiYMD().disabled = false;	//訂正日
                    this.controls.radTeiseiKubunCode().disabled = false;	//訂正区分
                    
                    //要介護認定エリア
                    //this.controls.YokaigoNinteiPanel().disabled = true;
                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.radShinseiShubetsu().disabled = false;
                    this.controls.ddlYokaigoJotaiKubun().disabled = false;
                    this.controls.radHenkoShinseichuKubun().disabled = false;
                    this.controls.txtNinteiYukoKikanYMD().disabled = false;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = false;
                    //支給限度基準額エリア
                    //this.controls.ShikyuGendoKijungakuPanel().disabled = true;
                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = false;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = false;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = false;
                    //居宅サービス計画エリア
                    //this.controls.KyotakuServicePlanPanel().disabled = true;
                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = false;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = false;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = false;
                    //住所地特例エリア
                    //this.controls.JushochiTokureiPanel().disabled = true;
                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = false;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = false;
                    this.controls.HokenshaJohoPanel().disabled = false;
                    //減免・減額エリア
                    //this.controls.GemmenGengakuPanel().disabled = true;
                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = false;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = false;
                    //後期高齢・国保エリア
                    //this.controls.KokiKoureiIryoHokenshaPanel().disabled = true;
                    this.controls.KokiKoureiPanel().disabled = false;
                    this.controls.KokuhoPanel().disabled = false;
                    //給付制限エリア
                    //this.controls.KyufuSeigenPanel().disabled = true;
                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = false;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;
                    //二割負担
                    //this.controls.RiyosyaFutanWariaiPanel().disabled = true;
                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = false;
                    //二次予防事業エリア
                    //this.controls.NijiyoboJigyoPanel().disabled = true;
                    this.controls.radNijiyoboJigyoKubun().disabled = false;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = false;
                    //老人保健エリア
                    //this.controls.RojinHokenPanel().disabled = true;
                    this.controls.txtRojinHokenShichosonNo().disabled = false;
                    this.controls.txtRojinHokenJukyushaNo().disabled = false;
                    this.controls.txtKohiFutanshaNo().disabled = false;
                }
                
                //再発行モード
                public saihakko(): void {
                    //照会モード同様
                    this.shokai();
                }
                
                //照会モード
                public shokai(): void {
                    this.controls.txtIdoYMD().disabled = true;	//異動日
                    this.controls.radIdoKubun().disabled = true;	//異動区分
                    this.controls.ddlJukyushaIdoJiyu().disabled = true;	//異動事由
                    this.controls.txtHiHokenshaNo().disabled = true;	//被保険者番号
                    this.controls.txtHiHokenshaNameKana().disabled = true;	//カナ氏名
                    this.controls.txtUmareYMD().disabled = true;	//生年月日
                    this.controls.radSeibetsu().disabled = true;	//性別
                    this.controls.txtShikakuShutokuYMD().disabled = true;	//資格取得日
                    this.controls.txtShikakuSoshitsuYMD().disabled = true;	//資格喪失日
                    this.controls.txtShoKisaiHokenshaNo().disabled = true;	//証記載保険者番号
                    this.controls.txtKoikiHokenshaNo().disabled = true;	//広域保険者番号
                    this.controls.txtSofuYM().disabled = true;	//送付年月
                    
                    this.controls.JukyushaIdoRenrakuhyoTeisei().disabled = true;
                    this.controls.txtTeiseiYMD().disabled = true;	//訂正日
                    this.controls.radTeiseiKubunCode().disabled = true;	//訂正区分
                    
                    //要介護認定エリア
                    //this.controls.YokaigoNinteiPanel().disabled = true;
                    this.controls.btnYokaigoninteiRireki().disabled = false;
                    this.controls.txtShinseiYMD().disabled = true;
                    this.controls.radShinseiShubetsu().disabled = true;
                    this.controls.ddlYokaigoJotaiKubun().disabled = true;
                    this.controls.radHenkoShinseichuKubun().disabled = true;
                    this.controls.txtNinteiYukoKikanYMD().disabled = true;
                    this.controls.radMinashiYokaigoJotaiKubun().disabled = true;
                    //支給限度基準額エリア
                    //this.controls.ShikyuGendoKijungakuPanel().disabled = true;
                    this.controls.txtHomonTsushoServiceShikyuGendoKijungaku().disabled = true;
                    this.controls.txtHomonTsushoServiceJogenKanriTekiyoYMD().disabled = true;
                    this.controls.txtTankiNyushoServiceShikyuGendoKijungaku().disabled = true;
                    this.controls.txtTankinyushoServiceJogenKanriTekiyoYMD().disabled = true;
                    //居宅サービス計画エリア
                    //this.controls.KyotakuServicePlanPanel().disabled = true;
                    this.controls.btnKyotakuServiceRireki().disabled = false;
                    this.controls.radKyotakuServiceSakuseiKubun().disabled = true;
                    this.controls.txtKyotakuKaigoShienJigyoshoNo().disabled = true;
                    this.controls.txtKyotakuKaigoShienJigyoshoName().disabled = true;
                    this.controls.txtKyotakuServiceTekiyoYMD().disabled = true;
                    this.controls.radShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().disabled = true;
                    //住所地特例エリア
                    //this.controls.JushochiTokureiPanel().disabled = true;
                    this.controls.radJushochiTokureiTaishoshaKubun().disabled = true;
                    this.controls.txtJushochiTokureiTekiyoYMD().disabled = true;
                    this.controls.HokenshaJohoPanel().disabled = true;
                    //減免・減額エリア
                    //this.controls.GemmenGengakuPanel().disabled = true;
                    this.controls.btnGemmenGengakuRireki().disabled = false;
                    this.controls.radGemmenShinseichuKubun().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoRiyoshaFutan().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoFukushiHojinKeigen().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoHyojunFutan().disabled = true;
                    this.controls.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().disabled = true;
                    //後期高齢・国保エリア
                    //this.controls.KokiKoureiIryoHokenshaPanel().disabled = true;
                    this.controls.KokiKoureiPanel().disabled = true;
                    this.controls.KokuhoPanel().disabled = true;
                    //給付制限エリア
                    //this.controls.KyufuSeigenPanel().disabled = true;
                    this.controls.btnKyufuSeigenRireki().disabled = false;
                    this.controls.radKohiFutanJogenGengakuAriFlag().disabled = true;
                    this.controls.txtShokanbaraikaYMD().disabled = true;
                    this.controls.txtKyufuritsuHikisage().disabled = true;
                    //二割負担
                    //this.controls.RiyosyaFutanWariaiPanel().disabled = true;
                    this.controls.txtRiyosyaFutanWariaiYukoYMD().disabled = true;
                    //二次予防事業エリア
                    //this.controls.NijiyoboJigyoPanel().disabled = true;
                    this.controls.radNijiyoboJigyoKubun().disabled = true;
                    this.controls.txtNijiyoboJigyoYukoDateRange().disabled = true;
                    //老人保健エリア
                    //this.controls.RojinHokenPanel().disabled = true;
                    this.controls.txtRojinHokenShichosonNo().disabled = true;
                    this.controls.txtRojinHokenJukyushaNo().disabled = true;
                    this.controls.txtKohiFutanshaNo().disabled = true;
                }
            }
        }
        

    }
}



module DBC {

    export module JukyushaIdoRenrakuhyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getTeiseiInfoVisible() {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().visible;
            }

            public setTeiseiInfoVisible(value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().visible = value;
            }

            public getTeiseiInfoDisplayNone() {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone;
            }

            public setTeiseiInfoDisplayNone(value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone = value;
            }

        }
    }
}




