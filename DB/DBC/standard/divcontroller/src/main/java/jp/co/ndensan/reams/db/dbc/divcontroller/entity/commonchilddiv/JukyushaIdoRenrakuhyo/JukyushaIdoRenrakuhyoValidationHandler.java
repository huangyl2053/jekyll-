/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受給者異動連絡票関連共有子Divのハンドラクラスです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class JukyushaIdoRenrakuhyoValidationHandler {

    private final JukyushaIdoRenrakuhyoDiv div;

    /**
     * コンストラクタです。
     *
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     */
    public JukyushaIdoRenrakuhyoValidationHandler(JukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate入力チェック() {
        IValidationMessages message = new JukyushaIdoRenrakuhyoValidator(div).validate入力チェック();
        return create入力チェックDictionary().check(message);
    }

    private ValidationDictionary create入力チェックDictionary() {

        List<ViewControl> controls = new ArrayList<>();

        RString 食費負担限度額 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtShokuhiFutanGendogaku().getText();
        RString 従来型個室 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuTokuyoFutanGendogaku().getText();
        RString 老健_療養 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().getText();
        RString 多床室 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtTashoshitsu().getText();
        RString ユニット型個室 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitKoshitsuGendogaku().getText();
        RString ユニット型準個室 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitJunKoshitsuFutanGendogaku().getText();

        if (RString.isNullOrEmpty(食費負担限度額)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtShokuhiFutanGendogaku());
        } else if (RString.isNullOrEmpty(従来型個室)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtJuraigataKoshitsuTokuyoFutanGendogaku());
        } else if (RString.isNullOrEmpty(老健_療養)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku());
        } else if (RString.isNullOrEmpty(多床室)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtTashoshitsu());
        } else if (RString.isNullOrEmpty(ユニット型個室)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtUnitKoshitsuGendogaku());
        } else if (RString.isNullOrEmpty(ユニット型準個室)) {
            controls.add(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtUnitJunKoshitsuFutanGendogaku());
        }

        return new ValidationDictionaryBuilder()
                .add(JukyushaIdoRenrakuhyoValidationMessage.異動日の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.異動区分の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.異動事由の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu())
                .add(JukyushaIdoRenrakuhyoValidationMessage.被保番号の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo())
                .add(JukyushaIdoRenrakuhyoValidationMessage.資格取得日の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.証記載保険者番号の必須項目,
                        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo())
                .add(JukyushaIdoRenrakuhyoValidationMessage.訂正日の必須項目,
                        div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.訂正区分の必須項目,
                        div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode())
                .add(JukyushaIdoRenrakuhyoValidationMessage.状態区分の必須項目,
                        div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.認定期間_Fromの必須項目,
                        div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.認定期間_Toの必須項目,
                        div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.申請種別の必須項目,
                        div.getYokaigoNinteiPanel().getRadShinseiShubetsu())
                .add(JukyushaIdoRenrakuhyoValidationMessage.変更申請中区分の必須項目,
                        div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.みなし区分の必須項目,
                        div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.計画作成区分の必須項目,
                        div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.減免申請中区分の必須項目,
                        div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.認定申請中区分の必須項目,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaNinteiShinseichuKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.サービス区分の必須項目,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun())
                .add(JukyushaIdoRenrakuhyoValidationMessage.特例減額措置対象の必須項目,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag())
                .add(JukyushaIdoRenrakuhyoValidationMessage.公費負担上限額減額_生活保護等の必須項目,
                        div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag())
                .add(JukyushaIdoRenrakuhyoValidationMessage.旧訪問通所_管理適用期間が不正,
                        div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.旧短期入所_管理適用期間が不正,
                        div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.居宅適用期間が不正,
                        div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.住特適用期間が不正,
                        div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.住特適用情報が不正,
                        div.getJushochiTokureiPanel())
                .add(JukyushaIdoRenrakuhyoValidationMessage.利用者負担適用期間が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.社会福祉法人軽減情報適用期間が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoFukushiHojinKeigen().getTxtKeigenritsuTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.社会福祉法人軽減情報が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoFukushiHojinKeigen())
                .add(JukyushaIdoRenrakuhyoValidationMessage.標準負担と異動日が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoHyojunFutan())
                .add(JukyushaIdoRenrakuhyoValidationMessage.標準負担適用期間が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.食費限度額適用期間が不正,
                        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getTxtFutanGendogakuTekiyoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.償還払化期間が不正,
                        div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage())
                .add(JukyushaIdoRenrakuhyoValidationMessage.給付率引下げ期間が不正,
                        div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.二割負担事業適用期間が不正,
                        div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD())
                .add(JukyushaIdoRenrakuhyoValidationMessage.二次予防事業適用期間が不正,
                        div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange())
                .add(JukyushaIdoRenrakuhyoValidationMessage.認定負担限度額が不正,
                        controls)
                .build();
    }

}
