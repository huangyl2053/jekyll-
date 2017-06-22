/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1720001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.KoikinaiTenkyoRirekiHenkanDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE1720001_広域内転居のバリデーションクラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
public class KoikinaiTenkyoRirekiValidationHandler {

    private final KoikinaiTenkyoRirekiHenkanDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KoikinaiTenkyoRirekiValidationHandler(KoikinaiTenkyoRirekiHenkanDiv div) {
        this.div = div;
    }

    /**
     *
     * 被保険者番号をチェックします。
     *
     * @param validPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 被保険者番号チェック(ValidationMessageControlPairs validPairs) {
        if (RString.isNullOrEmpty(div.getTxtHihokenshaNumber().getValue())) {
            validPairs.add(new ValidationMessageControlPair(KoikinaiTenkyoRirekiMessages.被保険者番号));
        }
        return validPairs;
    }

    /**
     * 証記載保険者番号チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 証記載保険者番号チェック(ValidationMessageControlPairs validPairs) {
        if (div.getTxtShokisaiHokenshaNo().getValue().equals(div.getDdlHokenshaList().getSelectedItem().get証記載保険者番号().getColumnValue())) {
            validPairs.add(new ValidationMessageControlPair(KoikinaiTenkyoRirekiMessages.証記載保険者番号チェック));
        }
        return validPairs;
    }

    private static enum KoikinaiTenkyoRirekiMessages implements IValidationMessage {

        被保険者番号(UrErrorMessages.必須項目_追加メッセージあり, "被保険者番号"),
        証記載保険者番号チェック(UrErrorMessages.更新不可, "（転居先）証記載保険者番号");
        private final Message message;

        private KoikinaiTenkyoRirekiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
