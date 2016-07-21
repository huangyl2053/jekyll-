/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteiShinseiJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請連携データ取込のバリデーションチェッククラスです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomiValidationHandler {

    private static final RString 要介護認定申請連携データ取込みファイル名 = new RString("Z8NCI201.CSV");
    private static final RString 認定調査委託先データ取込みファイル名 = new RString("C1NCI101.CSV");
    private static final RString 認定調査員データ取込みファイル名 = new RString("C1NCI111.CSV");
    private static final RString 主治医医療機関データ取込みファイル名 = new RString("C1NCI121.CSV");
    private static final RString 主治医データ取込みファイル名 = new RString("C1NCI131.CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString TITLE = new RString("シーケンシャル番号");
    private static final int 電算標準版_123 = 123;
    private static final int 厚労省_100 = 100;
    private static final int 電算標準版_11 = 11;
    private static final int 厚労省_10 = 10;
    private static final int 電算標準版_10 = 10;
    private static final int 厚労省_9 = 9;
    private static final int 電算標準版_9 = 9;
    private static final int 厚労省_8 = 8;
    private static final int 電算標準版_8 = 8;
    private static final int 厚労省_7 = 7;
    private final RenkeiDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public RenkeiDataTorikomiValidationHandler(RenkeiDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 実行するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs checkSelected() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTorikomiichiran().getDgtorikomidataichiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    FilecheckMessages.Validate未選択, div.getTorikomiichiran().getDgtorikomidataichiran()));
        } else if (div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    FilecheckMessages.Validate未選択, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
        }
        return validPairs;
    }

    /**
     * 認定申請情報ファイルの取り込みとき、バリデーションチェックを行う。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check認定申請情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 要介護認定申請連携データ取込みファイル名);
        }
        // TODO 文字コードは連携文字コード以外の場合、エラーとする
        // タイトルがない場合、エラーとする
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            CsvReader<NinteiShinseiJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                    filePath, NinteiShinseiJohoDensanCsvEntity.class)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(false).build();
            // TODO ファイル版本はどうやって判断する。
            if (電算標準版_123 < getSize(read)
                    || 厚労省_100 < getSize(read)
                    || TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 認定調査委託先情報ファイルの取り込みとき、バリデーションチェックを行う。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check認定調査委託先情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 認定調査委託先データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            if (電算標準版_11 < getSize(read) || 厚労省_10 < getSize(read)) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 認定調査員情報ファイル(電算標準版)の取り込みとき、バリデーションチェックを行う。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check認定調査員情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 認定調査員データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            if (電算標準版_10 < getSize(read) || 厚労省_9 < getSize(read)) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 主治医医療機関情報ファイルの取り込みとき、バリデーションチェックを行う。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check主治医医療機関情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 主治医医療機関データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            if (電算標準版_9 < getSize(read) || 厚労省_8 < getSize(read)) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 主治医情報ファイルの取り込みとき、バリデーションチェックを行う。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check主治医情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 主治医データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            if (電算標準版_8 < getSize(read) || 厚労省_7 < getSize(read)) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    private int getSize(CsvListReader read) {
        int size = 0;
        if (read.readLine() != null) {
            size = read.readLine().size();
        }
        return size;
    }

    private static enum FilecheckMessages implements IValidationMessage {

        Validate未選択(UrErrorMessages.選択されていない, "取込み対象"),
        Validate認定申請情報ファイル(UrErrorMessages.不正, "認定申請情報ファイル"),
        Validate認定調査委託先情報ファイル(UrErrorMessages.不正, "認定調査委託先情報ファイル"),
        Validate認定調査員情報ファイル(UrErrorMessages.不正, "認定調査員情報ファイル"),
        Validate主治医医療機関情報ファイル(UrErrorMessages.不正, "主治医医療機関情報ファイル"),
        Validate主治医情報ファイル(UrErrorMessages.不正, "主治医情報ファイル");
        private final Message message;

        private FilecheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
