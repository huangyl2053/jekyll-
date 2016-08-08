/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.RenkeiDataTorikomiBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.ShiseiDataParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteiShinseiJohoDensanCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.NinteiShinseiJohoKouroushouCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgTorikomiTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgtorikomidataichiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定申請連携データ取込のHandlerクラスです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomiHandler {

    private static final RString 法改正前 = new RString("key0");
    private static final RString 法改正後 = new RString("key1");
    private static final int 電算標準版_197 = 197;
    private static final int 厚労省_174 = 174;
    private static final int 東芝版_87 = 87;
    private static final RString 要介護認定申請連携データ取込みファイル名 = new RString("Z8NCI201.CSV");
    private static final RString フォーマット_要介護認定申請 = new RString("NCI201");
    private static final RString フォーマット_認定調査委託先 = new RString("NCI101");
    private static final RString フォーマット_認定調査員 = new RString("NCI111");
    private static final RString フォーマット_主治医医療機関 = new RString("NCI121");
    private static final RString フォーマット_主治医 = new RString("NCI131");
    private static final RString なし = new RString("0");
    private static final RString あり = new RString("1");
    private static final RString SJIS = new RString("1");
    private static final RString UTF8 = new RString("2");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString 共有ファイル名 = new RString("要介護認定申請連携データ取込");
    private final RenkeiDataTorikomiDiv div;
    private final RDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public RenkeiDataTorikomiHandler(RenkeiDataTorikomiDiv div) {
        this.div = div;
        基準日 = RDate.getNowDate();
    }

    /**
     * 初期化の設定します。
     *
     * @param 法改正前Flag 法改正前Flag
     * @param path path
     */
    public void onLoad(boolean 法改正前Flag, RString path) {
        div.getRenkeiDataTorikomiBatchParameter().getListHokennsha().loadHokenshaList();
        if (法改正前Flag) {
            div.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei().setSelectedKey(法改正前);
        } else {
            div.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei().setSelectedKey(法改正後);
        }
        div.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei().setDisabled(true);
        RString 要介護認定申請 = DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        RString 認定調査委託先 = DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        RString 認定調査員 = DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        RString 主治医医療機関 = DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        RString 主治医 = DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        List<dgTorikomiTaisho_Row> list = new ArrayList<>();
        list.add(setRowFile(path, フォーマット_要介護認定申請,
                DbBusinessConfig.get(ConfigNameDBE.NCI201ファイル名称, 基準日, SubGyomuCode.DBE認定支援),
                要介護認定申請));
        list.add(setRowFile(path, フォーマット_認定調査委託先,
                DbBusinessConfig.get(ConfigNameDBE.NCI101ファイル名称, 基準日, SubGyomuCode.DBE認定支援),
                認定調査委託先));
        list.add(setRowFile(path, フォーマット_認定調査員,
                DbBusinessConfig.get(ConfigNameDBE.NCI111ファイル名称, 基準日, SubGyomuCode.DBE認定支援),
                認定調査員));
        list.add(setRowFile(path, フォーマット_主治医医療機関,
                DbBusinessConfig.get(ConfigNameDBE.NCI121ファイル名称, 基準日, SubGyomuCode.DBE認定支援),
                主治医医療機関));
        list.add(setRowFile(path, フォーマット_主治医,
                DbBusinessConfig.get(ConfigNameDBE.NCI131ファイル名称, 基準日, SubGyomuCode.DBE認定支援),
                主治医));
        div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().addAll(list);
    }

    /**
     * 取込みファイルデータを取得します。
     */
    public void getFileData() {
        if (あり.equals(div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(0).getTotal())) {
            RString 文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, 基準日, SubGyomuCode.DBE認定支援);
            Encode コード = null;
            if (SJIS.equals(文字コード)) {
                コード = Encode.SJIS;
            } else if (UTF8.equals(文字コード)) {
                コード = Encode.UTF_8;
            }
            setRowFileData(コード);
        }
    }

    /**
     * 対象ファイルを共有フォルダに保存します。
     *
     * @param path 格納パス
     * @return SharedFileEntryDescriptor
     */
    public SharedFileEntryDescriptor upLoadFile(FilesystemPath path) {
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(共有ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, path, opts);
        div.setPath(entity.getDirectAccessPath());
        return entity;
    }

    /**
     * バッチパラメータを作成します。
     *
     * @return RenkeiDataTorikomiBatchParamter
     */
    public RenkeiDataTorikomiBatchParamter setBatchParameter() {
        RenkeiDataTorikomiBatchParamter batchParameter = new RenkeiDataTorikomiBatchParamter();
        List<RString> list = new ArrayList<>();
        List<ShiseiDataParameter> parameterList = new ArrayList<>();
        batchParameter.set市町村コード(div.getRenkeiDataTorikomiBatchParameter().getListHokennsha().getSelectedItem().get市町村コード().value());
        for (dgTorikomiTaisho_Row row : div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getSelectedItems()) {
            list.add(row.getFileName());
        }
        batchParameter.set取込み対象ファイルリスト(list);
        for (dgtorikomidataichiran_Row row : div.getTorikomiichiran().getDgtorikomidataichiran().getSelectedItems()) {
            ShiseiDataParameter dataParameter = new ShiseiDataParameter();
            dataParameter.set保険者番号(row.getHokenshano());
            dataParameter.set被保険者番号(row.getHihono());
            dataParameter.set認定申請日(row.getNinteishinseiymd().getValue().toDateString());
            dataParameter.set申請種別コード(row.getShinseikubunshinseiji());
            parameterList.add(dataParameter);
        }
        batchParameter.set申請情報データリスト(parameterList);
        batchParameter.set格納パス(div.getPath());
        return batchParameter;
    }

    private void setRowFileData(Encode コード) {
        List<dgtorikomidataichiran_Row> list = new ArrayList<>();
        RString path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString filePath = Path.combinePath(path, 要介護認定申請連携データ取込みファイル名);
        try (CsvListReader read = new CsvListReader.InstanceBuilder(Path.combinePath(path, 要介護認定申請連携データ取込みファイル名)).build()) {
            int size = read.readLine().size();
            if (電算標準版_197 == size) {
                try (CsvReader<NinteiShinseiJohoDensanCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoDensanCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setEncode(コード)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(false).build()) {
                    List<NinteiShinseiJohoDensanCsvEntity> csvEntityList = new ArrayList<>();
                    while (true) {
                        NinteiShinseiJohoDensanCsvEntity entity = csvReader.readLine();
                        if (entity != null) {
                            entity.set項目数(size);
                            csvEntityList.add(entity);
                        } else {
                            break;
                        }
                    }
                    for (NinteiShinseiJohoDensanCsvEntity entity : csvEntityList) {
                        dgtorikomidataichiran_Row rowData = new dgtorikomidataichiran_Row();
                        rowData.setSelected(Boolean.TRUE);
                        rowData.setKoroshoifshikibetsucode(entity.get識別コード());
                        rowData.setHokenshano(entity.get保険者番号());
                        rowData.setHihono(entity.get被保険者番号());
                        rowData.getNinteishinseiymd().setValue(new RDate(entity.get認定申請日().toString()));
                        rowData.setShinseikubunshinseiji(NinteiShinseiShinseijiKubunCode.toValue(entity.get申請区分コード_申請時()).get名称());
                        rowData.setHihokubun(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
                        rowData.setShimei(entity.get氏名());
                        rowData.getSeinengappi().setValue(new RDate(entity.get生年月日().toString()));
                        rowData.getNenrei().setValue(new Decimal(entity.get年齢().toString()));
                        rowData.setSeibetsu(Seibetsu.toValue(entity.get性別()).get名称());
                        list.add(rowData);
                        div.getTorikomiichiran().getDgtorikomidataichiran().setDataSource(list);
                        PersonalData personalData = PersonalData.of(new ShikibetsuCode(rowData.getKoroshoifshikibetsucode()),
                                new ExpandedInformation(new Code("0001"),
                                        new RString("被保険者番号"), rowData.getHihono()));
                        AccessLogger.log(AccessLogType.照会, personalData);
                    }
                }
            } else if (厚労省_174 == size) {
                try (CsvReader<NinteiShinseiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class)
                        .setDelimiter(EUC_WRITER_DELIMITER)
                        .setEncode(コード)
                        .setNewLine(NewLine.CRLF)
                        .hasHeader(false).build()) {
                    List<NinteiShinseiJohoKouroushouCsvEntity> csvEntityList = new ArrayList<>();
                    while (true) {
                        NinteiShinseiJohoKouroushouCsvEntity entity = csvReader.readLine();
                        if (entity != null) {
                            entity.set項目数(size);
                            csvEntityList.add(entity);
                        } else {
                            break;
                        }
                    }
                    for (NinteiShinseiJohoKouroushouCsvEntity csvEntity : csvEntityList) {
                        dgtorikomidataichiran_Row rowData = new dgtorikomidataichiran_Row();
                        rowData.setSelected(Boolean.TRUE);
                        rowData.setKoroshoifshikibetsucode(csvEntity.get識別コード());
                        rowData.setHokenshano(csvEntity.get保険者番号());
                        rowData.setHihono(csvEntity.get被保険者番号());
                        rowData.getNinteishinseiymd().setValue(new RDate(csvEntity.get認定申請日().toString()));
                        rowData.setShinseikubunshinseiji(NinteiShinseiShinseijiKubunCode.toValue(csvEntity.get申請区分コード_申請時()).get名称());
                        rowData.setHihokubun(HihokenshaKubunCode.toValue(csvEntity.get被保険者区分コード()).get名称());
                        rowData.setShimei(csvEntity.get氏名());
                        rowData.getSeinengappi().setValue(new RDate(csvEntity.get生年月日().toString()));
                        rowData.getNenrei().setValue(new Decimal(csvEntity.get年齢().toString()));
                        rowData.setSeibetsu(Seibetsu.toValue(csvEntity.get性別()).get名称());
                        list.add(rowData);
                        div.getTorikomiichiran().getDgtorikomidataichiran().setDataSource(list);
                        PersonalData personalData = PersonalData.of(new ShikibetsuCode(rowData.getKoroshoifshikibetsucode()),
                                new ExpandedInformation(new Code("0001"),
                                        new RString("被保険者番号"), rowData.getHihono()));
                        AccessLogger.log(AccessLogType.照会, personalData);
                    }
                }
                // TODO
            } else if (東芝版_87 == size) {
                try (CsvReader<NinteiShinseiJohoKouroushouCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                        filePath, NinteiShinseiJohoKouroushouCsvEntity.class).setDelimiter(EUC_WRITER_DELIMITER)
                        .setEncode(コード).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
                    List<NinteiShinseiJohoKouroushouCsvEntity> csvEntityList = new ArrayList<>();
                    while (true) {
                        NinteiShinseiJohoKouroushouCsvEntity csventity = csvReader.readLine();
                        if (csventity != null) {
                            csventity.set項目数(size);
                            csvEntityList.add(csventity);
                        } else {
                            break;
                        }
                    }
                    for (NinteiShinseiJohoKouroushouCsvEntity csvEntity : csvEntityList) {
                        dgtorikomidataichiran_Row row = new dgtorikomidataichiran_Row();
                        row.setSelected(Boolean.TRUE);
                        row.setKoroshoifshikibetsucode(csvEntity.get識別コード());
                        row.setHokenshano(csvEntity.get保険者番号());
                        row.setHihono(csvEntity.get被保険者番号());
                        row.getNinteishinseiymd().setValue(new RDate(csvEntity.get認定申請日().toString()));
                        row.setShinseikubunshinseiji(NinteiShinseiShinseijiKubunCode.toValue(csvEntity.get申請区分コード_申請時()).get名称());
                        row.setHihokubun(HihokenshaKubunCode.toValue(csvEntity.get被保険者区分コード()).get名称());
                        row.setShimei(csvEntity.get氏名());
                        row.getSeinengappi().setValue(new RDate(csvEntity.get生年月日().toString()));
                        row.getNenrei().setValue(new Decimal(csvEntity.get年齢().toString()));
                        row.setSeibetsu(Seibetsu.toValue(csvEntity.get性別()).get名称());
                        list.add(row);
                        div.getTorikomiichiran().getDgtorikomidataichiran().setDataSource(list);
                        PersonalData personalData = PersonalData.of(new ShikibetsuCode(row.getKoroshoifshikibetsucode()),
                                new ExpandedInformation(new Code("0001"),
                                        new RString("被保険者番号"), row.getHihono()));
                        AccessLogger.log(AccessLogType.照会, personalData);
                    }
                }
            }
        }
    }

    private void getFileCount(RString path, RString ファイル, dgTorikomiTaisho_Row row) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(path).append(File.separator).append(ファイル);
        File file = new File(path.toString());
        if (file.exists()) {
            row.setTotal(あり);
        } else {
            row.setTotal(なし);
        }
    }

    private dgTorikomiTaisho_Row setRowFile(RString path, RString フォーマット, RString 名称, RString ファイル名) {
        dgTorikomiTaisho_Row row = new dgTorikomiTaisho_Row();
        row.setSelected(Boolean.TRUE);
        row.setFileFormat(フォーマット);
        row.setMeisho(名称);
        row.setFileName(ファイル名);
        getFileCount(path, ファイル名, row);
        return row;
    }
}
