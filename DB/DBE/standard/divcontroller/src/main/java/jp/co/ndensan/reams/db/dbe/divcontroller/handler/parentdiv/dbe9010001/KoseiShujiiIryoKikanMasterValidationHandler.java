/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiIryoKikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医医療機関マスタ画面のバリデーションハンドラークラスです。
 */
public class KoseiShujiiIryoKikanMasterValidationHandler {

    private final ShujiiIryoKikanMasterDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div 主治医医療機関情報Div
     */
    public KoseiShujiiIryoKikanMasterValidationHandler(ShujiiIryoKikanMasterDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForOutputCsv() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        for (dgShujiiIchiran_Row row : ichiranList) {
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
     * @param count 主治医医療機関情報件数
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(RString 状態, int count) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
            if (状態_修正.equals(状態) && !isUpdate()) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.編集なしで更新不可)));
            }
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichoson().getValue())
                    && RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichosonmei().getValue())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード"),
                        div.getShujiiJohoInput().getTxtShichoson()));
            }
            RString shujiiIryoKikanCode = div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue();
            if (0 < count) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, String.valueOf(shujiiIryoKikanCode)),
                        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode()));
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
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.編集なしで更新不可),
                    div.getShujiiIchiran().getDgShujiiIchiran()));
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param shujiiJohoCount 主治医情報件数
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForDelete(int shujiiJohoCount) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (0 < shujiiJohoCount) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbeErrorMessages.他の情報で使用している為削除不可)));
        }
        return validPairs;
    }
    
    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        KoseiShujiiIryoKikanMasterHandler handler = new KoseiShujiiIryoKikanMasterHandler(div);
        if (!handler.getInputDiv().equals(div.getShujiiJohoInput().getHiddenInputDiv())) {
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
