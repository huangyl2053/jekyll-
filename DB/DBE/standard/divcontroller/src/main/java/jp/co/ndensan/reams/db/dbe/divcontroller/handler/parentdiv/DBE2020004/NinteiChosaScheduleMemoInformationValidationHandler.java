/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020004;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.NinteiChosaScheduleMemoInformationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfCommonMemo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfJichikuMemo_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 認定調査スケジュール登録4のバリデーションハンドラークラスです。
 */
public class NinteiChosaScheduleMemoInformationValidationHandler {

    private final NinteiChosaScheduleMemoInformationDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public NinteiChosaScheduleMemoInformationValidationHandler(NinteiChosaScheduleMemoInformationDiv div) {
        this.div = div;
    }

    /**
     * 「登録する」ボタンを押下するとき、入力チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs メモの種類の必須チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (div.getMaintenanceForMemo().getDdlMemoType().getSelectedKey().isEmpty()) {

            validPairs.add(new ValidationMessageControlPair(RRVMessages.メモの種類));
        }
        return validPairs;
    }

    /**
     * 「保存する」ボタンを押下するとき、入力チェックを行う。
     *
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一覧データの編集状態チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        boolean validPairsFlag = false;
        for (dgListOfCommonMemo_Row dg_Row : div.getDgListOfCommonMemo().getDataSource()) {
            if (dg_Row.getJotai().isEmpty()) {

                validPairsFlag = true;
                break;
            }
        }
        for (dgListOfJichikuMemo_Row dg_Row : div.getDgListOfJichikuMemo().getDataSource()) {
            if (dg_Row.getJotai().isEmpty()) {
                validPairsFlag = true;
                break;
            }
        }
        if ((div.getメモ一覧共通().isEmpty() && div.getメモ一覧自地区().isEmpty()) || validPairsFlag) {

            validPairs.add(new ValidationMessageControlPair(RRVMessages.編集状態チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        メモの種類(UrErrorMessages.選択されていない, "メモの種類"),
        編集状態チェック(UrErrorMessages.編集なしで更新不可);
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
