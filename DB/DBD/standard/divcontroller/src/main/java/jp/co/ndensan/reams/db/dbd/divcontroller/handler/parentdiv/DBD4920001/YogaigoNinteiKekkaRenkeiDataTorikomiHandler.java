/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shinchokudataoutputeuccsv.ShinchokuDataOutputEucCsvBusiness;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD492001.DBD492001_NinteiKekkaInfoUploadParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.DataGridFile_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.dgtorikomidataichiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.basic.KaigoNinteiHokaiseiKanriManager;
import jp.co.ndensan.reams.db.dbd.service.core.yogaigoninteikekkarenkeidatatorikomi.YogaigoNinteiKekkaRenkeiDataTorikomiService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.dbt7202kaigoninteihokaiseikanri.DbT7202KaigoNinteiHokaiseiKanriBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 * 要介護認定申請連携データ取込のHandlerクラスです。
 *
 * @reamsid_L DBD_1510-010 miaojin
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiHandler {

    private static final RString いち = new RString("1");
    private static final RString ゼロ = new RString("0");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString 共有ファイル名 = new RString("共有ファイル名");
    private static final int NO_328 = 328;
    private final YogaigoNinteiKekkaRenkeiDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public YogaigoNinteiKekkaRenkeiDataTorikomiHandler(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     *
     */
    public void onLoad() {
        KaigoNinteiHokaiseiKanriManager manager = new KaigoNinteiHokaiseiKanriManager();
        List<DbT7202KaigoNinteiHokaiseiKanriBusiness> 護認定法改正管理情報 = manager.get介護認定法改正管理情報();
        if (!護認定法改正管理情報.isEmpty() && 護認定法改正管理情報.get(0).get法改正施行年月日().isBeforeOrEquals(FlexibleDate.getNowDate())) {
            div.getRadIfType().setSelectedKey(ゼロ);
        } else {
            div.getRadIfType().setSelectedKey(いち);
        }
        div.getHokenshaList().loadHokenshaList();
        div.getRadDataSelect().setSelectedKey(KEY0);
        div.getDataGridFile().setDataSource(getFileSource());
    }

    /**
     * 取込みデータを押下。
     */
    public void onChange_data() {
        div.getDataGridFile().setDataSource(getFileSource());
    }

    /**
     * 新/旧フォーマットを押下。
     */
    public void onChange_type() {
        div.getDataGridFile().setDataSource(getFileSource());
    }

    /**
     * 連携データを取込みするを押下。
     *
     * @param files FileData[]
     */
    public void onClick_appurodo(FileData... files) {
        for (FileData file : files) {
            File shareFile = new File(file.getFilePath().toString());
            RString csvPath = file.getFilePath();
            div.getDgtorikomidataichiran().setDataSource(getFileData(csvPath));
            RString localFilePath = new RString(shareFile.getPath());
            FilesystemPath path = new FilesystemPath(localFilePath);
            FilesystemName filesystemName = new FilesystemName(共有ファイル名);
            SharedFileDescriptor sfd = SharedFile.defineSharedFile(filesystemName);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts();
            SharedFile.copyToSharedFile(sfd, path, opts);
            SharedFile.copyToLocal(filesystemName, new FilesystemPath(Path.getTmpDirectoryPath()));
        }
        for (dgtorikomidataichiran_Row row : div.getDgtorikomidataichiran().getDataSource()) {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("'被保険者番号"),
                    row.getHihono());
            AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(ShikibetsuCode.EMPTY, expandedInfo));
        }
    }

    /**
     * 項目数を設定。
     *
     * @param files FileData[]
     */
    public void before_onClick(FileData... files) {
        for (FileData file : files) {
            set項目数(file.getFilePath());
        }
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return DBD492001_NinteiKekkaInfoUploadParameter
     */
    public DBD492001_NinteiKekkaInfoUploadParameter toParameter() {
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(共有ファイル名);
        RDateTime sharedFileId = RDateTime.now();
        for (UzT0885SharedFileEntryEntity sharedFile : sharedFiles) {
            sharedFileId = sharedFile.getSharedFileId();
        }
        FilesystemName filesystemName = new FilesystemName(共有ファイル名);
        SharedFileEntryDescriptor sfed = new SharedFileEntryDescriptor(filesystemName, sharedFileId);
        DBD492001_NinteiKekkaInfoUploadParameter parameter = new DBD492001_NinteiKekkaInfoUploadParameter();
        parameter.set取込みデータ区分(div.getRadDataSelect().getSelectedValue());
        parameter.set格納パス(SharedFile.getDirectAccessPath(sfed));
        if (div.getHokenshaList().getSelectedItem().get保険者区分() != null) {
            parameter.set保険者区分(div.getHokenshaList().getSelectedItem().get保険者区分().getコード());
        } else {
            parameter.set保険者区分(RString.EMPTY);
        }
        parameter.set市町村コード(div.getHokenshaList().getSelectedItem().get市町村コード().value());
        parameter.set市町村名称(div.getHokenshaList().getSelectedItem().get市町村名称());
        parameter.set証記載保険者番号(div.getHokenshaList().getSelectedItem().get証記載保険者番号().value());
        List<RString> 保険者番号リスト = new ArrayList<>();
        List<RString> 被保番号リスト = new ArrayList<>();
        List<RString> 認定申請日リスト = new ArrayList<>();
        List<RString> 申請区分_申請時_コードリスト = new ArrayList<>();
        for (dgtorikomidataichiran_Row row : div.getDgtorikomidataichiran().getSelectedItems()) {
            保険者番号リスト.add(row.getHokenshano());
            被保番号リスト.add(row.getHihono());
            認定申請日リスト.add(row.getShinseikubunshinseiji());
            申請区分_申請時_コードリスト.add(row.getShinseikubunshinseijiCode());
        }
        parameter.set保険者番号リスト(保険者番号リスト);
        parameter.set申請区分_申請時_コードリスト(申請区分_申請時_コードリスト);
        parameter.set被保番号リスト(被保番号リスト);
        parameter.set認定申請日リスト(認定申請日リスト);
        return parameter;
    }

    private Encode getEncode() {
        RString 連携文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (new RString("1").equals(連携文字コード)) {
            return Encode.SJIS;
        } else {
            return Encode.UTF_8;
        }
    }

    private RString getファイル名称() {
        if (div.getRadDataSelect().getSelectedKey().equals(KEY0) && div.getRadIfType().getSelectedKey().equals(ゼロ)) {
            return DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名_新, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } else if (div.getRadDataSelect().getSelectedKey().equals(KEY0) && div.getRadIfType().getSelectedKey().equals(いち)) {
            return DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名_旧, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } else if (div.getRadDataSelect().getSelectedKey().equals(KEY1) && div.getRadIfType().getSelectedKey().equals(ゼロ)) {
            return DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名_新, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } else {
            return DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名_旧, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
    }

    private void set項目数(RString path) {
        int size = 0;
        List<RString> 項目数;
        try (CsvListReader reader = new CsvListReader.InstanceBuilder(path).
                setDelimiter(new RString(",")).setEnclosure(new RString("\""))
                .hasHeader(false).setEncode(getEncode()).setNewLine(NewLine.CRLF).build()) {
            while ((項目数 = reader.readLine()) != null) {
                size = size + 項目数.size();
            }
        }
        div.getHdNum().setValue(new RString(size % NO_328));
    }

    private List<DataGridFile_Row> getFileSource() {
        DataGridFile_Row data = new DataGridFile_Row();
        data.setFileFormat(new RString("NCI242"));
        data.setFileName(getファイル名称());
        data.setTotal(RString.EMPTY);
        data.setMeisho(DbBusinessConfig.get(ConfigNameDBE.NCI242ファイル名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        List<DataGridFile_Row> dataSource = new ArrayList<>();
        dataSource.add(data);
        return dataSource;
    }

    private List<dgtorikomidataichiran_Row> getFileData(RString path) {
        List<dgtorikomidataichiran_Row> dataSources = new ArrayList<>();
        YogaigoNinteiKekkaRenkeiDataTorikomiService service = new YogaigoNinteiKekkaRenkeiDataTorikomiService();
        List<ShinchokuDataOutputEucCsvBusiness> ファイル内容 = service.getFileDateSource(path, getEncode());
        for (ShinchokuDataOutputEucCsvBusiness business : ファイル内容) {
            dgtorikomidataichiran_Row row = new dgtorikomidataichiran_Row();
            row.setHihokubun(HihokenshaKubunCode.toValue(business.get被保険者区分コード()).get名称());
            row.setHihono(business.get被保険者番号());
            row.setHokenshano(business.get保険者番号());
            row.setJyosho(business.get住所());
            row.getNenrei().setValue(new Decimal(business.get年齢().toString()));
            row.getNinteishinseiymd().setValue(new RDate(business.get認定申請日().toString()));
            row.setSeibetsu(Seibetsu.toValue(business.get性別コード()).get名称());
            row.getSeinengappi().setValue(new RDate(business.get生年月日().toString()));
            row.setShikibetsuCode(business.get識別コード());
            row.setShimei(business.get被保険者漢字氏名());
            row.setShinseikubunshinseijiCode(business.get申請区分申請時コード());
            row.setShinseikubunshinseiji(NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分申請時コード()).get名称());
            dataSources.add(row);
        }
        return dataSources;
    }
}
