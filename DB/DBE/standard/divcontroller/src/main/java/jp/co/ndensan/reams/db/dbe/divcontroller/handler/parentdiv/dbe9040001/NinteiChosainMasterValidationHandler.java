/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.ChosainJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString MAN = new RString("1");
    private static final RString CODE_有効 = new RString("1");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

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
            if (状態_修正.equals(状態) && !isUpdateForKakutei()) {
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

    private boolean isUpdateForKakutei() {
        boolean update = false;
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getClickedItem();
        ChosainJohoInputDiv chosainJohoInputDiv = div.getChosainJohoInput();
        if (!row.getShichosonCode().equals(chosainJohoInputDiv.getTxtShichoson().getValue())) {
            update = true;
        }
        if (!row.getShichoson().equals(chosainJohoInputDiv.getTxtShichosonmei().getValue())) {
            update = true;
        }
        if (!row.getChosainCode().getValue().equals(chosainJohoInputDiv.getTxtChosainCode().getValue())) {
            update = true;
        }
        if (!row.getChosaItakusakiCode().getValue().equals(chosainJohoInputDiv.getTxtChosaItakusaki().getValue())) {
            update = true;
        }
        if (!row.getChosaItakusakiMeisho().equals(chosainJohoInputDiv.getTxtChosaItakusakiMeisho().getValue())) {
            update = true;
        }
        if (!row.getChosainShimei().equals(chosainJohoInputDiv.getTxtChosainShimei().getValue())) {
            update = true;
        }
        if (!row.getChosainKanaShimei().equals(chosainJohoInputDiv.getTxtChosainKanaShimei().getValue())) {
            update = true;
        }
        if (!row.getSeibetsu().equals(chosainJohoInputDiv.getRadSeibetsu().getSelectedValue())) {
            update = true;
        }
        if (!row.getChikuCode().equals(chosainJohoInputDiv.getTxtChiku().getValue())) {
            update = true;
        }
        if (!row.getChiku().equals(chosainJohoInputDiv.getTxtChikuMei().getValue())) {
            update = true;
        }
        if (!row.getChosainShikaku().equals(chosainJohoInputDiv.getDdlChosainShikaku().getSelectedValue())) {
            update = true;
        }
        if (!row.getChosaKanoNinzu().getValue().equals(chosainJohoInputDiv.getTxtChosaKanoNinzu().getValue())) {
            update = true;
        }
        if (!editYubinNo(row.getYubinNo()).equals(chosainJohoInputDiv.getTxtYubinNo().getValue().value())) {
            update = true;
        }
        if (!row.getJusho().equals(chosainJohoInputDiv.getTxtJusho().getDomain().value())) {
            update = true;
        }
        if (!row.getTelNo().equals(chosainJohoInputDiv.getTxtTelNo().getDomain().value())) {
            update = true;
        }
        if (!row.getFaxNo().equals(chosainJohoInputDiv.getTxtFaxNo().getDomain().value())) {
            update = true;
        }
        if (!row.getShozokuKikanName().equals(chosainJohoInputDiv.getTextBoxShozokuKikan().getDomain().value())) {
            update = true;
        }
        if (!row.getJokyoFlag().equals(chosainJohoInputDiv.getRadChosainJokyo().getSelectedValue())) {
            update = true;
        }
        return update;
    }

    private RString editYubinNo(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (yubinNo.contains(ハイフン)) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(yubinNo.substring(INDEX_4));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        boolean update = false;
        ChosainJohoInputDiv chosainJohoInputDiv = div.getChosainJohoInput();
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtShichoson().getValue())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtChosainCode().getValue())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtChosaItakusaki().getValue())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtChosainShimei().getValue())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtChosainKanaShimei().getValue())) {
            update = true;
        }
        if (!MAN.equals(chosainJohoInputDiv.getRadSeibetsu().getSelectedKey())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtChiku().getValue())) {
            update = true;
        }
        if (chosainJohoInputDiv.getDdlChosainShikaku().getSelectedIndex() != 0) {
            update = true;
        }
        if (chosainJohoInputDiv.getTxtChosaKanoNinzu().getValue() != null) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtYubinNo().getValue().value())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtJusho().getDomain().value())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtTelNo().getDomain().value())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTxtFaxNo().getDomain().value())) {
            update = true;
        }
        if (!RString.isNullOrEmpty(chosainJohoInputDiv.getTextBoxShozokuKikan().getDomain().value())) {
            update = true;
        }
        if (!CODE_有効.equals((chosainJohoInputDiv.getRadChosainJokyo().getSelectedKey()))) {
            update = true;
        }
        return update;
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
