/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.dgTorikomiTaiasho_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）バリデーションクラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomiValidationHandler {

    private final NinteiShinsakaiKekkaDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiShinsakaiKekkaDataTorikomiValidationHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 対象未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象未選択チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgTorikomiTaiasho().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.対象未選択チェック));
        }
        return validPairs;
    }

    /**
     * 一致性チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @param fileName fileName
     * @param filePath filePath
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一致性チェック(ValidationMessageControlPairs validPairs, RString fileName, RString filePath) {
        boolean flag = true;
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
            if (row.getFileName().equals(fileName)) {
                CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build();
                row.getDataNum().setValue(new Decimal(getSize(read)));
                flag = false;
            }
        }
        if (flag) {
            validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.一致性チェック));
        }
        return validPairs;
    }

    private int getSize(CsvListReader read) {
        int size = 0;
        while (read.readLine() != null) {
            size++;
        }
        return size;
    }

    /**
     * データ件数チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ件数チェック(ValidationMessageControlPairs validPairs) {
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
            if (null == row.getDataNum().getValue() || 0 == row.getDataNum().getValue().compareTo(Decimal.ZERO)) {
                validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.データ件数チェック));
            }
        }
        return validPairs;
    }

    private static enum NinteiShinsakaiKekkaDataTorikomiMessages implements IValidationMessage {

        対象未選択チェック(UrErrorMessages.選択されていない, "取込みファイル内容一覧対象"),
        一致性チェック(UrErrorMessages.不正, "アップロードファイルの名称"),
        データ件数チェック(UrErrorMessages.対象データなし_追加メッセージあり, "選択されたレコードのファイル名");
        private final Message message;

        private NinteiShinsakaiKekkaDataTorikomiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
