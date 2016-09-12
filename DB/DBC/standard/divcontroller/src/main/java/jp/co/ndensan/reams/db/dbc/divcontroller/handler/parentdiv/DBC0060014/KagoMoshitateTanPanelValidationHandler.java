/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060014;

import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC0060014_短期入所サービスの給付管理照会ValidationHandlerクラスです。
 *
 * @reamsid_L DBC-2960-050 lizhuoxuan
 */
public class KagoMoshitateTanPanelValidationHandler {

    private static final RString 被保険者番号なし = new RString("被保険者番号なし");

    /**
     * コンストラクタです。
     */
    public KagoMoshitateTanPanelValidationHandler() {
    }

    /**
     * 被保険者番号の取得できますチェックを実施します。
     *
     * @param 対象者一覧 対象者一覧
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor被保険者番号(KyufuKanrihyoShokaiDataModel 対象者一覧) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if ((対象者一覧 == null) || (対象者一覧.get被保険者番号() == null) || (対象者一覧.get被保険者番号().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(DbzErrorMessages.理由付き登録不可, 被保険者番号なし.toString())));
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
