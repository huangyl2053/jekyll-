/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2920001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.dgTorikomiFileIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 依頼情報データ受取（オルカ）のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IraiJohoDataTorikomiValidationHandler {

    private final IraiJohoDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IraiJohoDataTorikomiDiv
     */
    public IraiJohoDataTorikomiValidationHandler(IraiJohoDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * データを取込のチェックを行います。
     *
     * @param csvEntityList List<IraiJohoDataTorikomiCsvEntity>
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データを取込のチェック(List<IraiJohoDataTorikomiCsvEntity> csvEntityList) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (csvEntityList == null || csvEntityList.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(IraiJohoDataTorikomiMessages.データを取込のチェック));
        }
        return validationMessages;
    }

    /**
     * 申請日のチェックを行います。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請日のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgTorikomiFileIchiran_Row> rowList = div.getDgTorikomiFileIchiran().getDataSource();
        for (int i = 0; i < rowList.size(); i++) {
            if (rowList.get(i).getCheckBox() && !rowList.get(i).getShinseibi().equals(rowList.get(i + 1).getShinseibi())) {
                validationMessages.add(new ValidationMessageControlPair(IraiJohoDataTorikomiMessages.申請日のチェック));
            }
        }
        return validationMessages;
    }

    /**
     * 取込みファイル対象未選択チェックを行います。
     *
     * @param files FileData[]
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ValidationMessageControlPairs 取込みファイル対象未選択チェック(FileData[] files) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (files == null) {
            validationMessages.add(new ValidationMessageControlPair(IraiJohoDataTorikomiMessages.取込みファイル対象未選択チェック));
        }
        return validationMessages;
    }

    private static enum IraiJohoDataTorikomiMessages implements IValidationMessage {

        データを取込のチェック(UrErrorMessages.存在しない, "取込対象のデータ"),
        取込みファイル対象未選択チェック(UrErrorMessages.選択されていない, "取込み対象"),
        申請日のチェック(UrWarningMessages.相違, "(上段(奇数行)に)申請日", "(下段(偶数行)に)申請日");
        private final Message message;

        private IraiJohoDataTorikomiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
