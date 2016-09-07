/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1720001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.KoikinaiTenkyoRirekiHenkanDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
     * 認定申請日_終了日が開始日以前チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定申請日範囲チェック(ValidationMessageControlPairs validPairs) {
        FlexibleDate shinnseikafrom = div.getTxtNinteiShinseiDateFrom().getValue();
        FlexibleDate shinnseikato = div.getTxtNinteiShinseiDateTo().getValue();
        if (shinnseikafrom.isEmpty()) {
            shinnseikafrom = FlexibleDate.MIN;
        }
        if (shinnseikato.isEmpty()) {
            shinnseikato = FlexibleDate.MAX;
        }
        if (shinnseikato.isBefore(shinnseikafrom)) {
            validPairs.add(new ValidationMessageControlPair(KoikinaiTenkyoRirekiMessages.認定申請日範囲チェック));
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
        if (div.getTxtShokisaiHokenshaNo().getValue().equals(div.getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(KoikinaiTenkyoRirekiMessages.証記載保険者番号チェック));
        }
        return validPairs;
    }

    private static enum KoikinaiTenkyoRirekiMessages implements IValidationMessage {

        証記載保険者番号チェック(UrErrorMessages.更新不可, "（転居先）証記載保険者番号"),
        認定申請日範囲チェック(UrErrorMessages.終了日が開始日以前);
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
