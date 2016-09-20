/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000013;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000013.IdoufunRiyoushyafutanKanendoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 異動分利用者負担割合判定（過年度）のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
public final class IdoufunRiyoushyafutanKanendoMainValidationHandler {

    private final IdoufunRiyoushyafutanKanendoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IdoufunRiyoushyafutanKanendoDiv
     */
    public IdoufunRiyoushyafutanKanendoMainValidationHandler(IdoufunRiyoushyafutanKanendoDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下の存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 実行するボタンを押下の存在チェック(ValidationMessageControlPairs pairs) {
        if (div.getTxtKonkaiKaishiDate().getText().isNullOrEmpty() || div.getTxtKonkaiKaishiTime().getText().isNullOrEmpty()) {
            pairs.add(new ValidationMessageControlPair(IdoufunRiyoushyafutanKanendoMessages.今回開始年月日の未入力チェック));
        }
        if (div.getTxtKonkaiShuryoDate().getText().isNullOrEmpty() || div.getTxtKonkaiShuryoTime().getText().isNullOrEmpty()) {
            pairs.add(new ValidationMessageControlPair(IdoufunRiyoushyafutanKanendoMessages.今回終了年月日の未入力チェック));
            return pairs;
        }
        RDateTime 前回終了date = RDateTime.convertFrom(div.getTxtZenkaiShuryoDate().getValue(), div.getTxtZenkaiShuryoTime().getValue());
        RDateTime 今回開始date = RDateTime.convertFrom(div.getTxtKonkaiKaishiDate().getValue(), div.getTxtKonkaiKaishiTime().getValue());
        RDateTime 今回終了date = RDateTime.convertFrom(div.getTxtKonkaiShuryoDate().getValue(), div.getTxtKonkaiShuryoTime().getValue());
        if (前回終了date.isBefore(今回開始date)) {
            pairs.add(new ValidationMessageControlPair(IdoufunRiyoushyafutanKanendoMessages.前回終了日時と今回開始日時の比較チェック));
        }
        if (今回終了date.isBefore(今回開始date)) {
            pairs.add(new ValidationMessageControlPair(IdoufunRiyoushyafutanKanendoMessages.今回開始日時と今回終了日時の比較チェック));
        }
        return pairs;
    }

    private static enum IdoufunRiyoushyafutanKanendoMessages implements IValidationMessage {

        今回開始年月日の未入力チェック(UrErrorMessages.必須, "今回開始期間"),
        今回終了年月日の未入力チェック(UrErrorMessages.必須, "今回終了期間"),
        前回終了日時と今回開始日時の比較チェック(DbcErrorMessages.抽出期間不正１),
        今回開始日時と今回終了日時の比較チェック(DbcErrorMessages.抽出期間不正２);
        private final Message message;

        private IdoufunRiyoushyafutanKanendoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
