/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3500011;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshasofulist.HokenshaSofuResult;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshasofulist.HokenshaSofuListMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataBaitaiTorikomuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshasofu.HokenshaSofuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連情報データ媒体取込のHandlerクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
public class HokenshaSofuListHandler {

    private JyusinDataBaitaiTorikomuDiv div;
    private final RString searchSharedFile = new RString("1\\_%");
    private static final int ゼロ = 0;
    private static final int 一1 = 1;
    private static final int 二2 = 2;
    private static final int 三 = 3;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final int 七 = 7;
    private static final int 八 = 8;
    private static final int 十 = 10;
    private static final int 十二 = 12;
    private static final int 八十九 = 89;
    private static final RString カンマ = new RString(",");
    private static final RString ブラケット左 = new RString("[");
    private static final RString ブラケット右 = new RString("]");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");
    private static final RString CSV = new RString(".csv");
    private static final RString REPLACE1 = new RString("_");
    private static final RString REPLACE2 = new RString("\\_");
    private static final RString 給付実績情報111 = new RString("111");
    private static final RString データ種別112 = new RString("112");
    private static final RString データ種別114 = new RString("114");
    private static final RString データ種別151 = new RString("151");
    private static final RString データ種別161 = new RString("161");
    private static final RString データ種別171 = new RString("171");
    private static final RString データ種別172 = new RString("172");
    private static final RString データ種別221 = new RString("221");
    private static final RString データ種別222 = new RString("222");
    private static final RString データ種別331 = new RString("331");
    private static final RString データ種別351 = new RString("351");
    private static final RString データ種別533 = new RString("533");
    private static final RString データ種別534 = new RString("534");
    private static final RString データ種別537 = new RString("537");
    private static final RString データ種別5C3 = new RString("5C3");
    private static final RString データ種別5C4 = new RString("5C4");
    private static final RString 識別番号011 = new RString("011");
    private static final RString 取消3 = new RString("3");
    private static final RString 新規1 = new RString("1");
    private static final RString 一 = new RString("1");
    private static final RString ゼロゼロ = new RString("0");
    private static final RString 二 = new RString("2");
    private static final RString 九 = new RString("2");
    private static final RString H1 = new RString("H1");
    private static final RString D8 = new RString("D8");
    private static FlexibleYearMonth 審査年月;
    private static FlexibleYearMonth 審査年月の翌月;
    private static FlexibleYearMonth 処理年月;
    private static FlexibleYearMonth 処理年月の前月;
    private static RString 識別番号;
    private static RString 保険者番号;

    /**
     * コンストラクタです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     */
    public HokenshaSofuListHandler(JyusinDataBaitaiTorikomuDiv div) {
        this.div = div;
    }

    /**
     * initializeのメッソドです。
     */
    public void initialize() {

        List<UzT0885SharedFileEntryEntity> uzt0805EntityList = SharedFile.searchSharedFile(searchSharedFile);
        setDatasource(uzt0805EntityList);
    }

    private void setDatasource(List<UzT0885SharedFileEntryEntity> uzt0805EntityList) {
        List<HokenshaSofuResult> hokenshaSofuList1 = new ArrayList();
        List<HokenshaSofuResult> hokenshaSofuList2 = new ArrayList();
        if (uzt0805EntityList != null && !uzt0805EntityList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity uzt0805Entity : uzt0805EntityList) {
                hokenshaSofuList1.add(getHokenshaSofuList(uzt0805Entity));
            }
            for (int i = 0; i < hokenshaSofuList1.size(); i++) {
                for (int j = i; j < hokenshaSofuList1.size(); j++) {
                    if (hokenshaSofuList1.get(i).getH一覧表示順().compareTo(hokenshaSofuList1.get(j).getH一覧表示順()) > ゼロ) {
                        hokenshaSofuList2.add(hokenshaSofuList1.get(j));
                        hokenshaSofuList2.add(hokenshaSofuList1.get(i));
                    } else if (i == j) {
                        hokenshaSofuList2.add(hokenshaSofuList1.get(i));
                    } else {
                        hokenshaSofuList2.add(hokenshaSofuList1.get(i));
                        hokenshaSofuList2.add(hokenshaSofuList1.get(j));
                    }
                }
            }
            JyusinDataList_Row row = new JyusinDataList_Row();
            List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
            for (HokenshaSofuResult entity : hokenshaSofuList2) {
                row.setTxtShoriTaishoNengetsu(entity.get取込情報名称());
                row.setTxtFile(entity.getファイル());
                row.setTxtHokenshaNo(entity.get被保険者番号().getColumnValue());
                row.setTxtShoriTaishoNengetsu(entity.get対象年月().toDateString());
                row.setTxtKoshinNichiji(new RString(entity.get処理日時().toString()));
                row.setTxtItiranHyoujiJyun(entity.getH一覧表示順());
                rowList.add(row);
            }
            div.getJyusinDataList().setDataSource(rowList);
        }
    }

    private HokenshaSofuResult getHokenshaSofuList(UzT0885SharedFileEntryEntity uzt0805Entity) {

        RString ファイル = uzt0805Entity.getSharedFileName();
        File file = new File(SharedFile.getBasePath().concat(File.separator)
                .concat(DB.toString()).concat(File.separator)
                .concat(uzt0805Entity.getSharedFileName().toString()).concat(File.separator)
                .concat((uzt0805Entity.getSharedFileId().toString().replace(コロン.toString(), 中黒.toString())
                        .replace(ハイフン.toString(), 中黒.toString()))).concat(File.separator)
                .concat(ファイル.toString()));

        HokenshaSofuResult hokenshaSofuListEntity;
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(new RString(file.getAbsolutePath()))
                .setDelimiter(カンマ).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
            List<RString> コントロールレコード = csvReader.readLine();
            RString データ種別 = コントロールレコード.get(四);
            ConfigKeysKokuhorenTorikomi 国保連取込情報名称 = ConfigKeysKokuhorenTorikomi.toValue(データ種別);
            hokenshaSofuListEntity = new HokenshaSofuResult();
            if (!コントロールレコード.isEmpty()) {

                RString 一覧表示順 = 国保連取込情報名称.get一覧表示順();
                hokenshaSofuListEntity.set取込情報名称(ブラケット左.concat(データ種別).concat(ブラケット右).concat(国保連取込情報名称.get略称()));
                hokenshaSofuListEntity.setファイル(ファイル);
                hokenshaSofuListEntity.set被保険者番号(new HihokenshaNo(コントロールレコード.get(六)));
                hokenshaSofuListEntity.set対象年月(new FlexibleYearMonth(コントロールレコード.get(十)));
                hokenshaSofuListEntity.set処理日時(uzt0805Entity.getSharedFileId());
                hokenshaSofuListEntity.setH一覧表示順(一覧表示順);
            }
            csvReader.close();
        }
        return hokenshaSofuListEntity;
    }

    /**
     * 受信データリスト.「削除」ボタンのメソッドです。
     */
    public void deleteCsv() {

        List<UzT0885SharedFileEntryEntity> uzt0805EntityList = SharedFile.searchSharedFile(
                div.getJyusinDataList().getClickedItem().getTxtFile().replace(REPLACE1, REPLACE2));
        for (UzT0885SharedFileEntryEntity uzt0805Entity : uzt0805EntityList) {
            ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(
                    new FilesystemName(uzt0805Entity.getSharedFileName()), uzt0805Entity.getSharedFileId());
            SharedFile.deleteEntry(deleteEntity);
        }
        List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
        rowList.remove(div.getJyusinDataList().getClickedItem());
        div.getJyusinDataList().setDataSource(rowList);
    }

    /**
     * 「アップロード」ボタンのメソッドです。
     *
     * @param files FileData[]
     */
    public void upLoadCsv(FileData[] files) {

        FileData file = files[ゼロ];
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(file.getFileName()));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(file.getFilePath()), opts);
        HokenshaSofuListMybatisParameter myBatisParameter = new HokenshaSofuListMybatisParameter();
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(file.getFilePath())
                .setDelimiter(カンマ).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
            List<RString> コントロールレコード = csvReader.readLine();
            List<RString> データレコード = csvReader.readLine();

            RString データ種別 = コントロールレコード.get(四);
            RString 給付実績情報作成区分コード = データレコード.get(五);
            if (データ種別 != null && !データ種別.isEmpty() && データ種別.equals(給付実績情報111)) {
                判断１(データレコード, 給付実績情報作成区分コード, myBatisParameter);
            }
            if (myBatisParameter.get同月過誤取下分フラグ() != null && myBatisParameter.get同月過誤取下分フラグ()) {
                識別番号 = 識別番号011;
            } else {
                識別番号 = データ種別;
            }
            RString 共有ファイル名 = searchSharedFile.concat(識別番号)
                    .concat(コントロールレコード.get(Integer.parseInt(二.toString()))).concat(コントロールレコード.get(六)).concat(CSV);

            List<UzT0885SharedFileEntryEntity> uzt0805EntityList = SharedFile.searchSharedFile(共有ファイル名);
            for (UzT0885SharedFileEntryEntity entity : uzt0805EntityList) {
                List<RString> コントロールレコード2 = csvReader.readLine();
                RString データ種別2 = コントロールレコード2.get(四);
                if (データ種別2 != null && !データ種別2.isEmpty()) {
                    ConfigKeysKokuhorenTorikomi 国保連取込情報名称2 = ConfigKeysKokuhorenTorikomi.toValue(データ種別);
                    if (!(国保連取込情報名称2 != null && 国保連取込情報名称2.isスケジュール設定有無())) {
                        ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(
                                new FilesystemName(entity.getSharedFileName()), entity.getSharedFileId());
                        SharedFile.deleteEntry(deleteEntity);
                        throw new ApplicationException(DbcErrorMessages.国保連アップロード対象ファイル不正.getMessage());
                    }
                }
            }
            コントロールレコード配列内容チェック(コントロールレコード, file, データレコード, データ種別);
            処理年月取得(データ種別);
            二重取込チェック(データ種別, file, myBatisParameter, コントロールレコード);
            審査年月チェック(file, データ種別);
            setDatasource(uzt0805EntityList);
        }
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 取込漏れ確認チェック(FileData file, RString データ種別, KokuhorenInterfaceKanri kanri) {
        if (データ種別 != null && !データ種別.isEmpty() && データ種別.equals(給付実績情報111)
                && kanri.get処理状態区分().equals(九) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage()
                    .replace(処理年月の前月.toString())).respond();
        }
        if (new RString(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            deleteEntitys(file);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 国保連取込漏れ確認チェック(FileData file) {
        if (審査年月の翌月.isBefore(審査年月) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込漏れ確認.getMessage()
                    .replace(審査年月の翌月.toString(), 審査年月.toString())).respond();
        }
        if (new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            deleteEntitys(file);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 国保連取込順序逆転確認チェック(FileData file) {
        if (審査年月.isBefore(審査年月の翌月) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込順序逆転確認.getMessage()
                    .replace(審査年月の翌月.toString(), 審査年月.toString())).respond();
        }
        if (new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            deleteEntitys(file);
        }
        return ResponseData.of(div).respond();
    }

    private void 審査年月チェック(FileData file, RString データ種別) {
        HokenshaSofuResult entity = HokenshaSofuFinder.createInstance().get国保連管理2(データ種別, 処理年月の前月);
        KokuhorenInterfaceKanri kanri = null;
        if (entity != null && entity.getKokuhorenInterfaceKanriList() != null && !entity.getKokuhorenInterfaceKanriList().isEmpty()) {
            kanri = entity.getKokuhorenInterfaceKanriList().get(ゼロ);

        }
        if (kanri != null && kanri.get実績データ上審査年月() != null) {
            if (!kanri.get実績データ上審査年月().isEmpty()) {
                審査年月の翌月 = kanri.get実績データ上審査年月().plusMonth(一1);
            } else {
                審査年月の翌月 = FlexibleYearMonth.EMPTY;
            }
        }

        if (kanri != null && !(審査年月の翌月 != null && 審査年月の翌月.isEmpty() && kanri.get処理状態区分().equals(取消3))) {
            取込漏れ確認チェック(file, データ種別, kanri);
            国保連取込漏れ確認チェック(file);
            国保連取込順序逆転確認チェック(file);
        }
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 二重取込チェック(
            RString データ種別, FileData file, HokenshaSofuListMybatisParameter myBatisParameter, List<RString> コントロールレコード)
            throws NumberFormatException, ApplicationException {
        HokenshaSofuResult entity = HokenshaSofuFinder.createInstance().get国保連管理(データ種別, 処理年月);
        for (KokuhorenInterfaceKanri faceKanri : entity.getKokuhorenInterfaceKanriList()) {
            if (!myBatisParameter.get同月過誤取下分フラグ()
                    && faceKanri.getコントロール上処理年月().toDateString().equals(コントロールレコード.get(十))
                    && faceKanri.getコントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())) {
                if (コントロールレコード.get(三) != null && !コントロールレコード.get(三).isEmpty()
                        && faceKanri.getコントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())
                        && !ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込済続行確認.getMessage()
                            .replace(処理年月.toString(), ConfigKeysKokuhorenTorikomi.toValue(データ種別).toString())).respond();
                }
                if (new RString(DbcQuestionMessages.国保連取込済続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    deleteEntitys(file);
                    return ResponseData.of(div).respond();
                }
            } else if (myBatisParameter.get同月過誤取下分フラグ()
                    && faceKanri.getコントロール上処理年月().toDateString().equals(コントロールレコード.get(十))
                    && faceKanri.getコントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())) {
                if (!コントロールレコード.get(三).isEmpty()
                        && faceKanri.getコントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())
                        && !ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込済二重取込続行確認.getMessage()
                            .replace(処理年月.toString(), ConfigKeysKokuhorenTorikomi.toValue(データ種別).toString())).respond();
                }
                if (new RString(DbcQuestionMessages.国保連取込済二重取込続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    deleteEntitys(file);
                    return ResponseData.of(div).respond();
                }
            }
        }
        return ResponseData.of(div).respond();
    }

    private void 処理年月取得(RString データ種別) {
        HokenshaSofuResult entity = HokenshaSofuFinder.createInstance().getSukejuruRirekiJoho(データ種別, 一);
        if (entity != null && !entity.getKokuhorenInterfaceKanriList().isEmpty()
                && entity.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月() != null) {
            処理年月 = entity.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月();
            処理年月の前月 = entity.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月().minusMonth(一1);
        } else {
            HokenshaSofuResult entity2 = HokenshaSofuFinder.createInstance().getBykokanShikibetsuNo(データ種別);
            if (entity2 != null && !entity2.getKokuhorenInterfaceKanriList().isEmpty()
                    && entity2.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月() != null) {
                処理年月 = entity2.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月();
                処理年月の前月 = entity2.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月().minusMonth(一1);
            }
        }
    }

    private void コントロールレコード配列内容チェック(
            List<RString> コントロールレコード, FileData file, List<RString> データレコード, RString データ種別) throws ApplicationException {
        if (コントロールレコード.size() != 十二) {
            deleteEntitys(file);
            throw new ApplicationException(DbcErrorMessages.国保連データフォーマット不正.getMessage());
        }

        if (!コントロールレコード.get(ゼロ).equals(一)) {
            deleteEntitys(file);
            throw new ApplicationException(DbcErrorMessages.国保連レコード種別不正.getMessage());
        }

        if (DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).equals(ゼロゼロ)) {
            保険者番号 = コントロールレコード.get(六);
        } else if (DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).equals(一)) {
            保険者番号取得(データレコード, データ種別, コントロールレコード);
        }

        if (保険者番号 != null && !保険者番号.equals(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (!保険者番号.equals(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().getColumnValue())) {
                deleteEntitys(file);
                throw new ApplicationException(DbcErrorMessages.国保連保険者番号不正.getMessage());
            }
        }

        if (コントロールレコード.get(二2).compareTo(一) > 0) {
            deleteEntitys(file);
            throw new ApplicationException(DbcErrorMessages.国保連ボリューム連番不正.getMessage());
        }
    }

    private void 保険者番号取得(List<RString> データレコード, RString データ種別, List<RString> コントロールレコード) {
        if (データレコード.get(ゼロ).equals(二)) {
            if (データ種別.equals(給付実績情報111) || データ種別.equals(データ種別112) || データ種別.equals(データ種別114)) {
                保険者番号 = コントロールレコード.get(六);
            }
            if (データ種別.equals(データ種別151) || データ種別.equals(データ種別161) || データ種別.equals(データ種別221)
                    || データ種別.equals(データ種別222) || データ種別.equals(データ種別331) || データ種別.equals(データ種別351)) {
                保険者番号 = コントロールレコード.get(四);
            }
            if (データ種別.equals(データ種別171) || データ種別.equals(データ種別172)) {
                保険者番号 = コントロールレコード.get(五);
            }
            if (データ種別.equals(データ種別534) || データ種別.equals(データ種別5C4)) {
                保険者番号 = コントロールレコード.get(七);
            }
            if (データ種別.equals(データ種別537) || データ種別.equals(データ種別5C3) || データ種別.equals(データ種別533)) {
                保険者番号 = コントロールレコード.get(八);
            }

            //todo QA1672
        }
    }

    private void deleteEntitys(FileData file) {
        List<UzT0885SharedFileEntryEntity> uzt0805EntityList2 = SharedFile.searchSharedFile(file.getFileName());
        for (UzT0885SharedFileEntryEntity entity : uzt0805EntityList2) {
            ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(
                    new FilesystemName(entity.getSharedFileName()), entity.getSharedFileId());
            SharedFile.deleteEntry(deleteEntity);
        }
    }

    private void 判断１(List<RString> データレコード, RString 給付実績情報作成区分コード, HokenshaSofuListMybatisParameter myBatisParameter) {
        if (データレコード.get(ゼロ).equals(二) && (データレコード.get(四).equals(D8) || データレコード.get(四).equals(H1))) {
            if (給付実績情報作成区分コード != null && !給付実績情報作成区分コード.isEmpty() && 給付実績情報作成区分コード.equals(取消3)) {
                myBatisParameter.set同月過誤取下分フラグ(Boolean.TRUE);
            } else if (給付実績情報作成区分コード != null
                    && !給付実績情報作成区分コード.isEmpty() && 給付実績情報作成区分コード.equals(新規1)) {
                myBatisParameter.set同月過誤取下分フラグ(Boolean.FALSE);
            }
            審査年月 = new FlexibleYearMonth(データレコード.get(八十九));
        }
    }
}
