/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ChosainJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ChosainJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteiShinseiJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteiShinseiJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteichosaItakusakiJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteichosaItakusakiJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ShujiiIryoKikanJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ShujiiIryoKikanJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ShujiiJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.ShujiiJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgTorikomiTaisho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString 電算標準版 = new RString("3");
    private static final RString 厚労省 = new RString("4");
    private static final RString 東芝版 = new RString("5");
    private static final int 電算標準版_197 = 197;
    private static final int 厚労省_174 = 174;
    private static final int 東芝版_87 = 87;
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
     * 実行するとき、バリデーションチェックを実施します。
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
     * 認定申請情報ファイルの取り込みとき、バリデーションチェックを実施します。
     *
     * @param validPairs validPairs
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check認定申請情報ファイル(ValidationMessageControlPairs validPairs, RString path, boolean pathFlag) {
        // TODO 文字コードは連携文字コード以外の場合、エラーとする
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 要介護認定申請連携データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString 認定申請IF種類 = DbBusinessConfig.get(ConfigNameDBE.認定申請IF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<NinteiShinseiJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (電算標準版_197 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }

            } else if (厚労省.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<NinteiShinseiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (厚労省_174 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else if (東芝版.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<NinteiShinseiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (東芝版_87 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定申請情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 認定調査委託先情報ファイルの取り込みとき、バリデーションチェックを実施します。
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
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<NinteichosaItakusakiJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (電算標準版_11 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }

            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<NinteichosaItakusakiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (厚労省_10 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査委託先情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 認定調査員情報ファイル(電算標準版)の取り込みとき、バリデーションチェックを実施します。
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
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ChosainJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (電算標準版_9 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ChosainJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (厚労省_8 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査員情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 主治医医療機関情報ファイルの取り込みとき、バリデーションチェックを実施します。
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
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ShujiiIryoKikanJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (電算標準版_10 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ShujiiIryoKikanJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (厚労省_9 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医医療機関情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * 主治医情報ファイルの取り込みとき、バリデーションチェックを実施します。
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
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ShujiiJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (電算標準版_8 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                    return validPairs;
                }
                CsvReader<ShujiiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(true).build();
                if (厚労省_7 < getSize(read) || !TITLE.equals(csvReader.readLine().getシーケンシャル番号())) {
                    validPairs.add(new ValidationMessageControlPair(
                            FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
                }
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医情報ファイル, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            }
        }
        return validPairs;
    }

    /**
     * ファイル名称チェックを実施します。
     *
     * @param validPairs validPairs
     * @param is認定申請情報ファイル is認定申請情報ファイル
     * @param is認定調査委託先情報ファイル is認定調査委託先情報ファイル
     * @param is認定調査員情報ファイル is認定調査員情報ファイル
     * @param is主治医医療機関情報ファイル is主治医医療機関情報ファイル
     * @param is主治医情報ファイル is主治医情報ファイル
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs checkFileName(ValidationMessageControlPairs validPairs,
            boolean is認定申請情報ファイル, boolean is認定調査委託先情報ファイル, boolean is認定調査員情報ファイル,
            boolean is主治医医療機関情報ファイル, boolean is主治医情報ファイル) {
        for (dgTorikomiTaisho_Row row : div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getSelectedItems()) {
            if (要介護認定申請連携データ取込みファイル名.equals(row.getFileName()) && !is認定申請情報ファイル) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定申請情報ファイル, div.getUploadArea().getUploadTool()));
            }
            if (認定調査委託先データ取込みファイル名.equals(row.getFileName()) && !is認定調査委託先情報ファイル) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査委託先情報ファイル, div.getUploadArea().getUploadTool()));
            }
            if (認定調査員データ取込みファイル名.equals(row.getFileName()) && !is認定調査員情報ファイル) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate認定調査員情報ファイル, div.getUploadArea().getUploadTool()));
            }
            if (主治医医療機関データ取込みファイル名.equals(row.getFileName()) && !is主治医医療機関情報ファイル) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医医療機関情報ファイル, div.getUploadArea().getUploadTool()));
            }
            if (主治医データ取込みファイル名.equals(row.getFileName()) && !is主治医情報ファイル) {
                validPairs.add(new ValidationMessageControlPair(
                        FilecheckMessages.Validate主治医情報ファイル, div.getUploadArea().getUploadTool()));
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
