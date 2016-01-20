/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 福祉用具商品名入力ガイドのチェッククラスです。
 */
public class ValidationHandler {

    private final FukushiyoguShohinGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 福祉用具商品名入力ガイド
     */
    public ValidationHandler(FukushiyoguShohinGuideDiv div) {
        this.div = div;
    }

    public void 管理日Fromの必須チェック(ValidationMessageControlPairs validPairs) {
        if (div.getPanInput().getTxtKanriKaishiDay().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate管理日必須, div.getPanInput().getTxtKanriKaishiDay()));
        } else if (div.getPanInput().getTxtKanriShuryoDay().getValue() != null
                && !div.getPanInput().getTxtKanriShuryoDay().getValue().toDateString().equals(RString.EMPTY)
                && div.getPanInput().getTxtKanriShuryoDay().getValue().
                isBefore(div.getPanInput().getTxtKanriKaishiDay().getValue())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate整合性));
        }
    }

    public void 商品名の必須チェック(ValidationMessageControlPairs validPairs) {
        if (div.getPanInput().getTxtShohinmei().getValue() == null || div.getPanInput().getTxtShohinmei().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate商品名必須, div.getPanInput().getTxtShohinmei()));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate管理日必須(UrErrorMessages.必須, "管理日From"),
        Validate商品名必須(UrErrorMessages.必須, "商品名"),
        Validate整合性(DbzErrorMessages.期間が不正_未来日付不可, "管理日From", "管理日To");
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
