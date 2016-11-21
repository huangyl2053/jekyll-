/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1320011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020.DBC060020_KyufuhiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuCsvEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.grdTuuchiJoho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 給付費通知書作成(一括)のHandlerです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
public class KyufuTsuchiSakuseiIkatuHandler {

    private final KyufuTsuchiSakuseiIkatuDiv div;
    private static final RString すべて選択 = new RString("すべて");
    private static final RString TWO = new RString("2");
    private static final RString ONE = new RString("1");
    private static final int NUM_ZERO = 0;
    private static final RString ZERO = new RString("0");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString 自立 = new RString("自立");
    private static final RString 経過介護 = new RString("経過介護");
    private static final RString 要支援１ = new RString("要支援１");
    private static final RString 要支援２ = new RString("要支援２");
    private static final RString 要介護１ = new RString("要介護１");
    private static final RString 要介護２ = new RString("要介護２");
    private static final RString 要介護３ = new RString("要介護３");
    private static final RString 要介護４ = new RString("要介護４");
    private static final RString 要介護５ = new RString("要介護５");
    private static final RString 介護導入区分_未導入 = new RString("0");
    private static final RString 介護導入区分_導入済 = new RString("1");
    private static final RString 帳票レコード種別 = new RString("F1");
    private static final RString 広域の場合市町村コード = new RString("000000");
    private static final RString SHARED_FILE_NAME = new RString("1_322");
    private static final RString 共有ファイル名 = new RString("国保連IF取込レコードファイル");
    private static final RString FILTER = new RString("1_322*.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final ReportId 帳票ID = ReportIdDBC.DBC100041.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div 給付費通知書作成(一括)のdiv
     */
    public KyufuTsuchiSakuseiIkatuHandler(KyufuTsuchiSakuseiIkatuDiv div) {
        this.div = div;
    }

    /**
     * 給付費通知書作成(一括)初期化を処理します。
     *
     * @param joho 市町村セキュリティの情報
     */
    public void onLoad(ShichosonSecurityJoho joho) {
        if (joho.get導入形態コード() != null) {
            if (DonyuKeitaiCode.事務広域.getCode().equals(joho.get導入形態コード().getKey())) {
                div.getKyufuTsuchiSakusei().setHdn市町村コード(広域の場合市町村コード);
            }
            if (DonyuKeitaiCode.事務単一.getCode().equals(joho.get導入形態コード().getKey())) {
                div.getKyufuTsuchiSakusei().setHdn市町村コード(
                        AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().value());
            }
            div.getKyufuTsuchiSakusei().setHdn保険者構成key(joho.get導入形態コード().getKey());
        }
        setChk要介護度();
        set保険者リスト();
        div.getKyufuTsuchiSakuseiPrint().getKyufuTsuchiSakuseiSetting().
                initialize(true, RDate.getNowDate(), true, false, null, false);
        div.getCcdBunsyobango().initialize(帳票ID);
        div.getOptServiceType().setSelectedValue(すべて選択);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
    }

    /**
     * 給付費通知書作成パラメータを作成します。
     *
     * @return DBC060020_KyufuhiTsuchishoParameter
     */
    public DBC060020_KyufuhiTsuchishoParameter create給付費通知書作成パラメータ() {
        DBC060020_KyufuhiTsuchishoParameter parameter = new DBC060020_KyufuhiTsuchishoParameter();
        parameter.set処理年月日(new FlexibleDate(
                div.getKyufuTsuchiSakuseiPrint().getKyufuTsuchiSakuseiSetting().getIssueDate().toDateString()));
        parameter.setサービス種類区分(div.getKyufuTsuchiSakusei().getOptServiceType().getSelectedValue());
        parameter.setサービス開始年月(new FlexibleYearMonth(
                div.getKyufuTsuchiSakusei().getTdrServiceYM().getFromValue().getYearMonth().toDateString()));
        parameter.setサービス終了年月(new FlexibleYearMonth(
                div.getKyufuTsuchiSakusei().getTdrServiceYM().getToValue().getYearMonth().toDateString()));
        if (!div.getKyufuTsuchiSakusei().getGrdTuuchiJoho().getDataSource().isEmpty()) {
            parameter.set福祉用具貸与ページ出力区分(ONE);
        } else {
            parameter.set福祉用具貸与ページ出力区分(ZERO);
        }
        if (!div.getKyufuTsuchiSakusei().getChkServiceSyuruiSyuyaku().getSelectedItems().isEmpty()) {
            parameter.set集約区分(ONE);
        } else {
            parameter.set集約区分(ZERO);
        }
        if (ONE.equals(parameter.get福祉用具貸与ページ出力区分())) {
            if (DonyuKeitaiCode.事務広域.getCode().equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
                parameter.set保険者構成(TWO);
            } else if (DonyuKeitaiCode.事務単一.getCode().equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
                parameter.set保険者構成(ONE);
            }
        }
        if (DonyuKeitaiCode.事務広域.getCode().equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
            parameter.set証記載保険者番号(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value());
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
            parameter.set証記載保険者番号(広域の場合市町村コード);
        }
        if (div.getKyufuTsuchiSakusei().getChkYokaigodo().getSelectedItems().isEmpty()) {
            div.getKyufuTsuchiSakusei().setHdn要介護度(null);
        } else {
            RStringBuilder 要介護度 = new RStringBuilder();
            for (RString key : div.getKyufuTsuchiSakusei().getChkYokaigodo().getSelectedKeys()) {
                要介護度.append(key);
                要介護度.append(EUC_WRITER_DELIMITER);
            }
            要介護度.deleteCharAt(要介護度.lastIndexOf(EUC_WRITER_DELIMITER));
            parameter.set要介護度(要介護度.toRString());
        }
        List<KeyValueDataSource> chkTyusyutuJokenList = div.getKyufuTsuchiSakusei().getChkTyusyutuJoken().getSelectedItems();
        for (KeyValueDataSource dataSource : chkTyusyutuJokenList) {
            if (KEY0.equals(dataSource.getKey())) {
                parameter.set死亡者分を対象としない(ONE);
            } else if (KEY1.equals(dataSource.getKey())) {
                parameter.setゼロ査定実績を対象としない(ONE);
            } else if (KEY2.equals(dataSource.getKey())) {
                parameter.set再審査分を対象としない(ONE);
            } else if (KEY3.equals(dataSource.getKey())) {
                parameter.set過誤分を対象としない(ONE);
            } else if (KEY4.equals(dataSource.getKey())) {
                parameter.set施設分を対象としない(ONE);
            } else if (KEY5.equals(dataSource.getKey())) {
                parameter.set特定入所者介護を対象としない(ONE);
            } else if (KEY6.equals(dataSource.getKey())) {
                parameter.set償還分を対象としない(ONE);
            }
        }
        parameter.set被保険者番号(div.getKyufuTsuchiSakusei().getTxtHihokenshaNo().getValue());
        if (div.getCcdChohyoShutsuryokujun().getSelected出力順() != null) {
            parameter.setShutsuryokujunId(div.getCcdChohyoShutsuryokujun().getSelected出力順().get出力順ID());
        }
        parameter.set文書番号(div.getKyufuTsuchiSakuseiPrint().getCcdBunsyobango().get文書番号());
        parameter.setLoginUserId(ControlDataHolder.getUserId());
        return parameter;
    }

    /**
     * 給付費通知情報を取り込むします。
     */
    public void setRowFileData() {
        RString localFilePath = RString.EMPTY;
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(SHARED_FILE_NAME);
        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
            FilesystemPath tempPath = get共有ファイル(
                    FilesystemPath.fromString(Path.getTmpDirectoryPath()), sharedfile);
            if (tempPath != null) {
                localFilePath = tempPath.toRString();
            }
        }
        if (RString.isNullOrEmpty(localFilePath)) {
            div.getKyufuTsuchiSakusei().getGrdTuuchiJoho().setDataSource(new ArrayList());
            return;
        }
        RString localFileName;
        List<RString> localFiles = Arrays.asList(Directory.getFiles(localFilePath, FILTER, false));
        if (localFiles != null && !localFiles.isEmpty()) {
            localFileName = localFiles.get(NUM_ZERO);
        } else {
            return;
        }
        List<grdTuuchiJoho_Row> list = new ArrayList();
        try (CsvReader<KyufuTsuchiSakuseiIkatuCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                Path.combinePath(localFilePath, localFileName),
                KyufuTsuchiSakuseiIkatuCsvEntity.class)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(Boolean.TRUE).build()) {
            List<KyufuTsuchiSakuseiIkatuCsvEntity> csvEntityList = new ArrayList<>();
            while (true) {
                KyufuTsuchiSakuseiIkatuCsvEntity entity = csvReader.readLine();
                if (entity != null) {
                    csvEntityList.add(entity);
                } else {
                    break;
                }
            }
            csvEntityList.remove(csvEntityList.size() - Integer.parseInt(ONE.toString()));
            for (KyufuTsuchiSakuseiIkatuCsvEntity entity : csvEntityList) {
                grdTuuchiJoho_Row rowData = new grdTuuchiJoho_Row();
                if ((entity.get帳票レコード種別() != null) && 帳票レコード種別.equals(entity.get帳票レコード種別())) {
                    RYearMonth サービス提供年月 = new RDate(entity.getサービス提供年月().toString()).getYearMonth();
                    if (div.getKyufuTsuchiSakusei().getTdrServiceYM().getFromValue().getYearMonth().isBeforeOrEquals(
                            サービス提供年月)
                            && サービス提供年月.isBeforeOrEquals(
                                    div.getKyufuTsuchiSakusei().getTdrServiceYM().getToValue().getYearMonth())) {
                        rowData.setTxtFileName(共有ファイル名);
                        rowData.setTxtHokenshaName(get保険者名(entity.get保険者番号()));
                        rowData.setTxtServiceNengetsu(entity.getサービス提供年月());
                        list.add(rowData);
                    }
                }
            }
        }
        div.getKyufuTsuchiSakusei().getGrdTuuchiJoho().setDataSource(list);
    }

    private RString get保険者名(RString 保険者番号) {
        if (RString.isNullOrEmpty(保険者番号)) {
            return RString.EMPTY;
        }
        Hokensha 保険者 = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(new HokenjaNo(保険者番号));
        if (保険者 == null) {
            return RString.EMPTY;
        }
        return 保険者.get保険者名();
    }

    private void setChk要介護度() {
        List<KeyValueDataSource> dataSourceList = div.getChkYokaigodo().getDataSource();
        List<KeyValueDataSource> newDataSourceList = new ArrayList();
        for (KeyValueDataSource dataSource : dataSourceList) {
            if (要介護１.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要介護1.getコード());
            } else if (要介護２.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要介護2.getコード());
            } else if (要介護３.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要介護3.getコード());
            } else if (要介護４.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要介護4.getコード());
            } else if (要介護５.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要介護5.getコード());
            } else if (要支援１.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要支援1.getコード());
            } else if (要支援２.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要支援2.getコード());
            } else if (自立.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.非該当.getコード());
            } else if (経過介護.equals(dataSource.getValue())) {
                dataSource.setKey(YokaigoJotaiKubun.要支援_経過的要介護.getコード());
            }
            newDataSourceList.add(dataSource);
        }
        div.getChkYokaigodo().setDataSource(newDataSourceList);
    }

    private void set保険者リスト() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString loginUserId = controlData.getLoginInfo().getUserId();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho
                .getShichosonSecurityJoho(GyomuBunrui.介護事務, loginUserId);
        if (介護導入区分_未導入.equals(市町村セキュリティ情報.get介護導入区分())) {
            div.getCcdHokenshaList().setDisplayNone(true);
        } else if (介護導入区分_導入済.equals(市町村セキュリティ情報.get介護導入区分())) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                div.getCcdHokenshaList().setDisplayNone(true);
            } else {
                div.getCcdHokenshaList().loadHokenshaList();
                div.getCcdHokenshaList().setDisplayNone(false);
            }
        }
    }

    private FilesystemPath get共有ファイル(FilesystemPath local複写先フォルダパス, UzT0885SharedFileEntryEntity entity) {
        ReadOnlySharedFileEntryDescriptor ro_entry = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
        FilesystemPath copiedPath = SharedFile.copyToLocal(ro_entry, local複写先フォルダパス);
        return copiedPath;
    }
}
