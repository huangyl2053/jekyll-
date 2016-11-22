/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.KyufuJissekiGaitoshaDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付管理票照会のValidationHandlerです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
public class KyufuJissekiGaitoshaValidationHandler {

    private final KyufuJissekiGaitoshaDiv div;
    private static final RString 必須項目 = new RString("被保番号、支援事業者番号");
    private static final RString 被保険者台帳 = new RString("被保険者台帳");
    private static final RString なし = new RString("なし");

    /**
     * コンストラクタです。
     *
     * @param div {@link KyufuJissekiGaitoshaDiv}
     */
    public KyufuJissekiGaitoshaValidationHandler(KyufuJissekiGaitoshaDiv div) {
        this.div = div;
    }

    /**
     * 被保番号、支援事業者番号の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor必須項目() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue().isEmpty()
                && RString.isNullOrEmpty(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり, 必須項目.toString())));
        }
        return validPairs;
    }

    /**
     * 存在しないエラーメッセージを取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get存在しないエラーメッセージ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(UrErrorMessages.存在しない, 被保険者台帳.toString())));
        return validPairs;
    }

    /**
     * 給付管理票一覧検索チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor検索チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (なし.equals(div.getHidden件数())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.対象データなし)));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
