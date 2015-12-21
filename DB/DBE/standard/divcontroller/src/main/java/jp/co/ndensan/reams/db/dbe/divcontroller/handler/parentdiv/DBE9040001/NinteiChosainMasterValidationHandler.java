/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.ChosainJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
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

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public NinteiChosainMasterValidationHandler(NinteiChosainMasterDiv div) {
        this.div = div;
    }

    public ValidationMessageControlPairs validateForOutputCsv() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.該当データが存在しません));
        }
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.編集されています));
                break;
            }
        }
        return validPairs;
    }

    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJokyoFlag())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.更新できません));
        }

        return validPairs;
    }

    public ValidationMessageControlPairs validateForUpdate(int ninteiShinseiJohoCount, int ninteichosaIraiJohoCount) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (0 < ninteiShinseiJohoCount) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.排他_他のユーザが更新済で更新処理を中止));
        }
        if (0 < ninteichosaIraiJohoCount) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.排他_他のユーザが更新済で更新処理を中止));
        }
        return validPairs;
    }

    public boolean isUpdate() {
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getActiveRow();
        boolean update = false;
        ChosainJohoInputDiv chosainJohoInputDiv = div.getChosainJohoInput();
        if (!row.getShichosonCode().equals(chosainJohoInputDiv.getTxtShichoson().getValue())) {
            update = true;
        }
        if (!row.getChosainCode().getValue().equals(chosainJohoInputDiv.getTxtChosainCode().getValue())) {
            update = true;
        }
        if (!row.getChosaItakusakiCode().getValue().equals(chosainJohoInputDiv.getTxtChosaItakusaki().getValue())) {
            update = true;
        }
        if (!row.getChosainShimei().equals(chosainJohoInputDiv.getTxtChosainShimei().getValue())) {
            update = true;
        }
        if (!row.getChosainKanaShimei().equals(chosainJohoInputDiv.getTxtChosainKanaShimei().getValue())) {
            update = true;
        }
        if (!row.getSeibetsu().equals(chosainJohoInputDiv.getRadSeibetsu().getSelectedKey())) {
            update = true;
        }
        if (!row.getChiku().equals(chosainJohoInputDiv.getTxtChiku().getValue())) {
            update = true;
        }
        if (!row.getChosainShikaku().equals(chosainJohoInputDiv.getDdlChosainShikaku().getSelectedValue())) {
            update = true;
        }
        if (!row.getChosaKanoNinzu().getValue().equals(chosainJohoInputDiv.getTxtChosaKanoNinzu().getValue())) {
            update = true;
        }
        if (!row.getYubinNo().equals(chosainJohoInputDiv.getTxtYubinNo().getValue().value())) {
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

    private static enum IdocheckMessages implements IValidationMessage {

        該当データが存在しません(UrErrorMessages.対象データなし, "該当データが存在しません。"),
        更新できません(UrErrorMessages.更新不可, "編集されていないため、更新できません。"),
        排他_他のユーザが更新済で更新処理を中止(UrErrorMessages.排他_他のユーザが更新済で更新処理を中止, "他の端末で対象のデータが変更されているため、更新処理を中止します。"),
        編集されています(UrErrorMessages.対象データなし, "編集されています。");

        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
