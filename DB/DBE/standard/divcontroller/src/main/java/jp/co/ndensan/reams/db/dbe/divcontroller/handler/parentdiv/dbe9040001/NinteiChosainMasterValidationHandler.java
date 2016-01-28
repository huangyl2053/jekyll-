/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査員マスタ画面のバリデーションハンドラークラスです。
 */
public class NinteiChosainMasterValidationHandler {

    private final NinteiChosainMasterDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public NinteiChosainMasterValidationHandler(NinteiChosainMasterDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForOutputCsv() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象データなし)));
        }
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbzErrorMessages.編集後更新指示)));
                break;
            }
        }
        return validPairs;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count 調査員情報件数
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(RString 状態, int count) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
            if (状態_修正.equals(状態) && !isUpdate()) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.編集なしで更新不可)));
            }
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChiku().getValue())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChikuMei().getValue())) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "地区コード"),
                        div.getChosainJohoInput().getTxtChiku()));
            }
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getTxtShichoson().getValue())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getTxtShichosonmei().getValue())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード"),
                        div.getChosainJohoInput().getTxtShichoson()));
            }
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChosaItakusaki().getValue())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChosaItakusakiMeisho().getValue())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                        "調査委託先コード"), div.getChosainJohoInput().getTxtChosaItakusaki()));
            }
            RString chosainCode = div.getChosainJohoInput().getTxtChosainCode().getValue();
            if (0 < count) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, String.valueOf(chosainCode)),
                        div.getChosainJohoInput().getTxtChosainCode()));
            }
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.編集なしで更新不可),
                    div.getChosainIchiran().getDgChosainIchiran()));
        }

        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param ninteiShinseiJohoCount 要介護認定申請情報件数
     * @param ninteichosaIraiJohoCount 認定調査依頼情報件数
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(int ninteiShinseiJohoCount, int ninteichosaIraiJohoCount) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (0 < ninteiShinseiJohoCount) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.排他_他のユーザが更新済で更新処理を中止)));
        }
        if (0 < ninteichosaIraiJohoCount) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.排他_他のユーザが更新済で更新処理を中止)));
        }
        return validPairs;
    }

    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        NinteiChosainMasterHandler handler = new NinteiChosainMasterHandler(div);
        if (!handler.getInputDiv().equals(div.getChosainJohoInput().getHiddenInputDiv())) {
            return true;
        }
        return false;
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
