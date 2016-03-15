/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020008;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * MainPaneValidationMessageバリデーションメッセージを定義している列挙型です。
 *
 */
public class MainPanelValidatisonHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private final MainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public MainPanelValidatisonHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 調査地区グループ一覧が0件の場合とき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForChosaChikuGroup() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosaChikuGroupList_Row> ichiranList = div.getChosaChikuGroupList().getDgChosaChikuGroupList().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        return validPairs;
    }

    /**
     * 調査地区グループ調査地区一覧が0件の場合とき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForGroupChosaChiku() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosaChikuGroupChosaChikuList_Row> ichiranList = div.getChosaChikuGroupChosaChikuList().
                getDgChosaChikuGroupChosaChikuList().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        return validPairs;
    }

    /**
     * 調査地区コード、市町村コードの重複の場合とき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForInsert() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(
                UrErrorMessages.既に存在, "調査地区コードと市町村コード")));
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosaChikuGroupChosaChikuList_Row> chosaChikuList = div.getChosaChikuGroupChosaChikuList().
                getDgChosaChikuGroupChosaChikuList().getDataSource();
        boolean notUpdate = true;
        for (dgChosaChikuGroupChosaChikuList_Row row : chosaChikuList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.編集なしで更新不可),
                    div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList()));
        }

        return validPairs;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count 主治医情報件数
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(RString 状態, int count) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if ((状態_追加.equals(状態) || 状態_修正.equals(状態)) && (状態_修正.equals(状態) && !isUpdate())) {
            validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(UrErrorMessages.編集なしで更新不可)));
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue())
                    && RString.isNullOrEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().getValue())) {
                validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "調査地区コード"),
                        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1()));
            }
            if (!RString.isNullOrEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue())
                    && RString.isNullOrEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().getValue())) {
                validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード"), div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode()));
            }
            if (0 < count) {
                validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(
                        UrErrorMessages.既に登録済, "調査地区コードと市町村コード")));
            }
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param chosaChikuGroupCount 調査地区グループ調査地区情報
     * @param ChosaChikuToroukuCount 調査地区グループ調査地区情報
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(int chosaChikuGroupCount, int ChosaChikuToroukuCount) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (0 < chosaChikuGroupCount) {
            validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(
                    UrErrorMessages.削除不可, "調査地区情報が他のDBにて使用されている")));
        }
        if (0 < ChosaChikuToroukuCount) {
            validPairs.add(new ValidationMessageControlPair(new MainPanelValidatisonHandler.IdocheckMessages(
                    DbeWarningMessages.既に他のグループで調査地区コードが登録)));
        }
        return validPairs;
    }

    /**
     * 調査地区グループ調査地区情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        MainPanelHandler handler = new MainPanelHandler(div);
        return !handler.getInputDiv().equals(div.getChosaChikuGroupChosaChikuInput().getHiddenInputDiv());
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
