/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のバリデーションハンドラークラスです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoValidationHandler {

    /**
     * 更新管理完了対象者一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧データの存在チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {

        if (div.getCcdKoshinTaisho().getDataSource() == null || div.getCcdKoshinTaisho().getDataSource().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.該当データなし)));
        }

        if (div.getCcdKoshinTaisho().getCheckbox() == null || div.getCcdKoshinTaisho().getCheckbox().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象行を選択)));
        }
        return pairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    /**
     * 更新管理完了対象者一覧選択行の完了処理事前チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧選択行の完了処理事前チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            if (row.getKoshinTsuchiYMD().getValue() == null
                    || row.getKoshinTsuchiYMD().getValue().toString().isEmpty()) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.更新不可_汎用, "通知年月日が未設定")));
            }
        }
        return pairs;
    }
}
