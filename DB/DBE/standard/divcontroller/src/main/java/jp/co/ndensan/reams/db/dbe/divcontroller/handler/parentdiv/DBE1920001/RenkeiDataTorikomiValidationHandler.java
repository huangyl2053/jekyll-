/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001;

import java.util.List;
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
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
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
    private static final RString 電算標準版 = new RString("3");
    private static final RString 厚労省 = new RString("4");
    private static final RString 東芝版 = new RString("5");
    private static final int 電算標準版_197 = 197;
    private static final int 厚労省_174 = 174;
    private static final int 東芝版_197 = 197;
    private static final int 電算標準版_11 = 11;
    private static final int 厚労省_10 = 10;
    private static final int 電算標準版_10 = 10;
    private static final int 厚労省_9 = 9;
    private static final int 電算標準版_9 = 9;
    private static final int 厚労省_8 = 8;
    private static final int 電算標準版_8 = 8;
    private static final int 厚労省_7 = 7;
    private static final RString SJIS = new RString("1");
    private static final RString UTF8 = new RString("2");
    private static final RString なし = new RString("0");
    private final RenkeiDataTorikomiDiv div;
    private final RDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public RenkeiDataTorikomiValidationHandler(RenkeiDataTorikomiDiv div) {
        this.div = div;
        基準日 = RDate.getNowDate();
    }

    /**
     * 実行するとき、バリデーションチェックを実施します。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs checkSelected() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgTorikomiTaisho().getSelectedItems() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    FilecheckMessages.Validate未選択, div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho()));
            return validPairs;
        }
        boolean flag = true;
        for (dgTorikomiTaisho_Row row : div.getDgTorikomiTaisho().getSelectedItems()) {
            if (row.getFileName().equals(要介護認定申請連携データ取込みファイル名)) {
                flag = false;
            }
        }
        if (flag && !div.getTorikomiichiran().getDgtorikomidataichiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    FilecheckMessages.Validateチェック, div.getTorikomiichiran().getDgtorikomidataichiran()));
        }
        if (!flag && div.getTorikomiichiran().getDgtorikomidataichiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    FilecheckMessages.Validate未選択, div.getTorikomiichiran().getDgtorikomidataichiran()));
        }
        return validPairs;
    }

    /**
     * ファイルを取込むとき、バリデーションチェックを実施します。
     *
     * @param files
     */
    public void checkゼロ件ファイル(FileData[] files) {
        RString rmessage = RString.EMPTY;
        boolean flag = false;
        for (FileData file : files) {
            List<dgTorikomiTaisho_Row> dataSource = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource();
            for (dgTorikomiTaisho_Row rowData : dataSource) {
                if (rowData.getFileName().equals(file.getFileName())) {
                    if (rowData.getTotal().equals(なし)) {
                        if (flag) {
                            rmessage = rmessage.concat(new RString(","));
                        }
                        if (flag) {
                            rmessage = rmessage.concat(new RString(file.getFileName().toString()));
                        } else {
                            rmessage = new RString(file.getFileName().toString());
                        }
                        flag = true;
                    }
                    break;
                }
            }
        }
        div.setHiddenErrorFiles(rmessage);
    }

    /**
     * ゼロ件チェックの結果をメッセージに変換します。
     *
     * @return message
     */
    public Message getMessage() {
        RString rmessage = div.getHiddenErrorFiles();
        if (!RString.isNullOrEmpty(rmessage)) {
            return InfoMessages.ゼロ件チェック.getMessage().replace(rmessage.toString());
        }
        return Message.NO_MESSAGE;
    }

    /**
     * 不正ファイルの結果をメッセージに変換します。
     *
     * @return message
     */
    public Message getError() {
        RString rmessage = div.getHiddenErrorFiles();
        if (!RString.isNullOrEmpty(rmessage)) {
            return InfoMessages.不正ファイル.getMessage().replace(rmessage.toString());
        }
        return Message.NO_MESSAGE;
    }

    /**
     * 初期エラーの結果をメッセージに変換します。
     *
     * @param error
     * @return message
     */
    public Message get初期Error(RString error) {
        return InfoMessages.初期ファイル不正.getMessage().replace(error.toString());
    }

    /**
     * ファイル名の不正の結果
     *
     * @param error
     * @param file
     * @return message
     */
    public RString setファイル名不正(RString error, FileData file) {
        error = set複数エラー(error, file.getFileName(), true);
        return error;
    }

    /**
     * ファイル名の不正の結果をメッセージに変換します。
     *
     * @return message
     */
    public Message get不正ファイル名() {
        RString rmessage = div.getHiddenErrorFiles();
        if (!RString.isNullOrEmpty(rmessage)) {
            return InfoMessages.ファイル名の不正.getMessage().replace(rmessage.toString());
        }
        return Message.NO_MESSAGE;
    }

    /**
     * 認定申請情報ファイルの取り込みとき、バリデーションチェックを実施します。
     *
     * @param error
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public RString check認定申請情報ファイル(RString error, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 要介護認定申請連携データ取込みファイル名);
        }
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString 認定申請IF種類 = DbBusinessConfig.get(ConfigNameDBE.認定申請IF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            boolean flag = false;
            if (電算標準版.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (電算標準版_197 < getSize(read)) {
                    flag = true;
                }
            } else if (厚労省.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (厚労省_174 < getSize(read)) {
                    flag = true;
                }
            } else if (東芝版.equals(認定申請IF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (東芝版_197 < getSize(read)) {
                    flag = true;
                }
            }
            return set複数エラー(error, 要介護認定申請連携データ取込みファイル名, flag);
        }
    }

    /**
     * 認定調査委託先情報ファイルの取り込みとき、バリデーションチェックを実施します。
     *
     * @param error
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public RString check認定調査委託先情報ファイル(RString error, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 認定調査委託先データ取込みファイル名);
        }
        boolean flag = false;
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (電算標準版_11 < getSize(read)) {
                    flag = true;
                }

            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, NinteichosaItakusakiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (厚労省_10 < getSize(read)) {
                    flag = true;
                }
            }
            return set複数エラー(error, 認定調査委託先データ取込みファイル名, flag);
        }
    }

    /**
     * 認定調査員情報ファイル(電算標準版)の取り込みとき、バリデーションチェックを実施します。
     *
     * @param error
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public RString check認定調査員情報ファイル(RString error, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 認定調査員データ取込みファイル名);
        }
        boolean flag = false;
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (電算標準版_9 < getSize(read)) {
                    flag = true;
                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ChosainJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (厚労省_8 < getSize(read)) {
                    flag = true;
                }
            }
            return set複数エラー(error, 認定調査員データ取込みファイル名, flag);
        }
    }

    /**
     * 主治医医療機関情報ファイルの取り込みとき、バリデーションチェックを実施します。
     *
     * @param error
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public RString check主治医医療機関情報ファイル(RString error, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 主治医医療機関データ取込みファイル名);
        }
        boolean flag = false;
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoDensanCsvEntity.class
                )
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (電算標準版_10 < getSize(read)) {
                    flag = true;

                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiIryoKikanJohoKouroushouCsvEntity.class
                )
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (厚労省_9 < getSize(read)) {
                    flag = true;
                }
            }
            return set複数エラー(error, 主治医医療機関データ取込みファイル名, flag);
        }
    }

    /**
     * 主治医情報ファイルの取り込みとき、バリデーションチェックを実施します。
     *
     * @param error
     * @param path path
     * @param pathFlag pathFlag
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public RString check主治医情報ファイル(RString error, RString path, boolean pathFlag) {
        RString filePath;
        if (pathFlag) {
            filePath = path;
        } else {
            filePath = Path.combinePath(path, 主治医データ取込みファイル名);
        }
        boolean flag = false;
        try (CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build()) {
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (電算標準版.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoDensanCsvEntity.class
                )
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (電算標準版_8 < getSize(read)) {
                    flag = true;

                }
            } else if (厚労省.equals(マスタIF種類)) {
                if (new CsvReader.InstanceBuilder(
                        filePath, ShujiiJohoKouroushouCsvEntity.class
                )
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setNewLine(NewLine.CRLF).build().readLine() == null) {
                    flag = true;
                }
                if (厚労省_7 < getSize(read)) {
                    flag = true;
                }
            }
            return set複数エラー(error, 主治医データ取込みファイル名, flag);
        }
    }

    private RString set複数エラー(RString error, RString ファイル名, boolean flag) {
        if (flag) {
            if (!RString.isNullOrEmpty(error)) {
                error = error.concat(new RString(","));
                error = error.concat(ファイル名);
            } else {
                error = ファイル名;
            }
        }
        return error;
    }

    private int getSize(CsvListReader read) {
        int size = 0;
        List<RString> list = read.readLine();
        if (list != null && !list.isEmpty()) {
            size = list.size();
        }
        return size;
    }

    private Encode set文字コード() {
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, 基準日, SubGyomuCode.DBE認定支援);
        Encode コード = null;
        if (SJIS.equals(文字コード)) {
            コード = Encode.SJIS;
        } else if (UTF8.equals(文字コード)) {
            コード = Encode.UTF_8;
        }
        return コード;

    }

    private static enum FilecheckMessages implements IValidationMessage {

        Validate未選択(UrErrorMessages.選択されていない, "取込み対象"),
        Validate認定申請情報ファイル(UrErrorMessages.不正, "認定申請情報ファイル"),
        Validate認定調査委託先情報ファイル(UrErrorMessages.不正, "認定調査委託先情報ファイル"),
        Validate認定調査員情報ファイル(UrErrorMessages.不正, "認定調査員情報ファイル"),
        Validate主治医医療機関情報ファイル(UrErrorMessages.不正, "主治医医療機関情報ファイル"),
        Validate主治医情報ファイル(UrErrorMessages.不正, "主治医情報ファイル"),
        Validateチェック(UrErrorMessages.設定不可, "認定申請情報が選択されていない");
        private final Message message;

        private FilecheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private enum InfoMessages implements IMessageGettable {

        /**
         * "保存は正常に終了しました。"を定義しています。
         */
        ゼロ件チェック(30, "?は総件数が0件のためアップロードできません。"),
        不正ファイル(20, "?は不正のファイルのためアップロードできません。"),
        初期ファイル不正(00, "?が不正のファイルです。"),
        ファイル名の不正(10, "?のファイル名が不正のためアップロードできません。");

        private final int no;
        private final RString message;

        private InfoMessages(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new InformationMessage(toCode("I", no), message.toString());
        }

    }
}
