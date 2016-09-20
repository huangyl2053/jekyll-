/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 自己負担額情報補正（単）_情報一覧のValidationHandlerです。
 *
 * @reamsid_L DBC-2080-010 jiangzongyue
 */
public class JikoFutangakuJohoHoseiJohoDgValidationHandler {

    private final JikoFutangakuJohoHoseiJohoDgDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuJohoHoseiJohoDgDiv}
     */
    public JikoFutangakuJohoHoseiJohoDgValidationHandler(JikoFutangakuJohoHoseiJohoDgDiv div) {
        this.div = div;
    }

    /**
     * 様式番号一覧チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate保存する() {
        IValidationMessages message = new JikoFutangakuHoseiJohoDgValidator(div).validate保存する();
        return create保存するDictionary().check(message);
    }

    private ValidationDictionary create保存するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者氏名漢字必須項目, div.getTxtHihokenshaShimei())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者名全角文字で入力してください, div.getTxtHihokenshaShimei())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.郵便番号が不正, div.getTxtAtesakiYubinNo())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.住所全角文字で入力してください, div.getTxtAtesakiJusho())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象期間開始日終了日が不正, div.getTxtTaishouKeisanKikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者期間が不正, div.getTxtHihokenshaKikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算と被保険者開始期間が不正,
                        div.getTxtTaishouKeisanKikan(), div.getTxtHihokenshaKikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算と被保険者終了期間が不正,
                        div.getTxtTaishouKeisanKikan(), div.getTxtHihokenshaKikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払期間年月日が不正,
                        div.getTxtMadoguchiKaishiYMD(), div.getTxtMadoguchiShuryoYMD())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算期間対象年度開始が不正,
                        div.getTxtTaishouKeisanKikan(), div.getTxtTaishouNendo())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.開始時間が不正, div.getTxtMadoguchiKaishiJikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.開始分が不正, div.getTxtMadoguchiKaishiFun())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.終了時間が不正, div.getTxtMadoguchiShuryoJikan())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.終了分が不正, div.getTxtMadoguchiShuryoFun())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所が不正, div.getTxtMadoguchiShiharaiBasho())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所開始日が不正, div.getTxtMadoguchiKaishiYMD())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所開始時間が不正,
                        div.getTxtMadoguchiKaishiJikan(), div.getTxtMadoguchiKaishiFun())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所終了日が不正, div.getTxtMadoguchiShuryoYMD())
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所終了時間が不正,
                        div.getTxtMadoguchiShuryoJikan(), div.getTxtMadoguchiShuryoFun()).build();
    }

    /**
     * 負担額情報入力の明細月のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate負担額情報入力の明細月() {
        IValidationMessages message = new JikoFutangakuHoseiJohoDgValidator(div).validate負担額情報入力の明細月();
        return create負担額情報入力の明細月Dictionary().check(message);
    }

    private ValidationDictionary create負担額情報入力の明細月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者期間明細月が不正, div.getTxtHihokenshaKikan()).build();
    }

    /**
     * 終了年度が同年のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate終了年度が同年() {
        IValidationMessages message = new JikoFutangakuHoseiJohoDgValidator(div).validate終了年度が同年();
        return create終了年度が同年Dictionary().check(message);
    }

    private ValidationDictionary create終了年度が同年Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算期間対象年度終了が不正,
                        div.getTxtTaishouKeisanKikan(), div.getTxtTaishouNendo()).build();
    }
}
