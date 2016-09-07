/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・審査受付のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
public class KanryoShoriShinsaUketsukeValidationHandler {

    private final KanryoShoriShinsaUketsukeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KanryoShoriShinsaUketsukeValidationHandler(KanryoShoriShinsaUketsukeDiv div) {
        this.div = div;
    }

    /**
     * 審査受付を完了するボタンを押下チェック処理
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 審査受付を完了するボタンを押下チェック処理(ValidationMessageControlPairs pairs) {
        if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.申請情報登録完了一覧データの存在チェック));
            return pairs;
        }

        if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.申請情報登録完了一覧データの行選択チェック));
            return pairs;
        }

        List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
        for (dgNinteiTaskList_Row row : rowList) {
            if (row.getShinseiUketsukeKanryoDay().getValue() != null) {
                pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.申請情報登録完了一覧選択行の完了処理チェック));
                return pairs;
            }
        }

        return pairs;
    }

    /**
     * 一覧を出力するボタンの押下チェック処理。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一覧を出力するボタンの押下チェック処理(ValidationMessageControlPairs pairs) {
        if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.申請情報登録完了一覧データの存在チェック));
            return pairs;
        } else if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.申請情報登録完了一覧データの行選択チェック));
            return pairs;
        }
        return pairs;
    }

    private static enum KanryoshoriIchijihanteiMessages implements IValidationMessage {

        申請情報登録完了一覧データの存在チェック(UrErrorMessages.該当データなし),
        申請情報登録完了一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        申請情報登録完了一覧選択行の完了処理チェック(DbzErrorMessages.理由付き完了不可, "完了済みデータ");
        private final Message message;

        private KanryoshoriIchijihanteiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
