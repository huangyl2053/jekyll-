/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekkaDataBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付実績照会_給付実績照会検索一覧画面
 *
 * @reamsid_L DBC-2970-010 linghuhang
 */
public class KyufuJissekiShokaiValidationHandler {

    private final KyufuJissekiShokaiDiv div;
    private static final int サービス提供年月の範囲 = 10;

    /**
     * コンストラクタです。
     *
     * @param div 給付実績照会検索一覧画面Div
     */
    public KyufuJissekiShokaiValidationHandler(KyufuJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs doチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!RString.isNullOrEmpty(div.getRadKyufuJissekiSearchDateType().getSelectedKey())) {
            if (div.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromValue() == null
                    || div.getTxtKyufuJissekiSearchServiceTeikyoYM().getToValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.サービス提供年月, div.getTxtKyufuJissekiSearchServiceTeikyoYM()));
            } else if (!div.getTxtKyufuJissekiSearchServiceTeikyoYM().getToValue().
                    isBeforeOrEquals(div.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromValue().plusYear(サービス提供年月の範囲))) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.サービス提供年月の範囲指定, div.getTxtKyufuJissekiSearchServiceTeikyoYM()));
            }
        }
        return validPairs;
    }

    /**
     * 「検索する」ボタンを押下する場合、チックを実行します。
     *
     * @param 集計データ 集計データ
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs do検索チェック(List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (集計データ.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.該当の給付データ));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        サービス提供年月(UrErrorMessages.未指定, "サービス提供年月を"),
        サービス提供年月の範囲指定(UrErrorMessages.未指定, "サービス提供年月日は10年以内で"),
        該当の給付データ(UrErrorMessages.存在しない, "該当の給付データ");
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
