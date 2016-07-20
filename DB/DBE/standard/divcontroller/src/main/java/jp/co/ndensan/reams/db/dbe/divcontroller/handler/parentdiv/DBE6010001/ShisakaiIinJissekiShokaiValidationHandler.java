/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.dgShisakaiIinJisseki_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会委員実績照会の画面処理ValidationHandlerクラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShisakaiIinJissekiShokaiValidationHandler {

    private final ShisakaiIinJissekiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShisakaiIinJissekiShokaiValidationHandler(ShisakaiIinJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 一覧を出力するボタンの押下チェック処理。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 審査会委員実績一覧データの行選択チェック処理(ValidationMessageControlPairs pairs) {
        List<dgShisakaiIinJisseki_Row> rows = new ArrayList<>();
        for (dgShisakaiIinJisseki_Row row : div.getDgShisakaiIinJisseki().getDataSource()) {
            if (row.getSelected()) {
                rows.add(row);
            }
        }
        if (rows.isEmpty()) {
            pairs.add(new ValidationMessageControlPair(ShisakaiIinJissekiMessages.審査会委員実績一覧データの行選択チェック));
            return pairs;
        }
        return pairs;
    }

    /**
     * 作成依頼日の必須入力チェックを実施します。
     *
     * @@param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForNyuryuku(ValidationMessageControlPairs pairs) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtMaxKensu().getValue() == null) {
            pairs.add(new ValidationMessageControlPair(ShisakaiIinJissekiMessages.必須項目));
            return pairs;
        }
        return validPairs;
    }

    private static enum ShisakaiIinJissekiMessages implements IValidationMessage {

        必須項目(UrErrorMessages.必須項目),
        審査会委員実績一覧データの行選択チェック(UrErrorMessages.対象行を選択);
        private final Message message;

        @Override
        public Message getMessage() {
            return message;
        }

        private ShisakaiIinJissekiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

    }

}
