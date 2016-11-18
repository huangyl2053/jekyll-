/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710070;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710060.HanyoListShakaiFukushiHojinKeigenProcess;
import jp.co.ndensan.reams.db.dbd.business.report.HanyoListTokubetsuChiikiKasanGemmenOrderby;
import jp.co.ndensan.reams.db.dbd.definition.core.hanyolisttokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenCsvEnumEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenCsvEnumEntity;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd710070.HanyoListTokubetsuChiikiKasanGemmenProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisttokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisttokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd710070.HanyoListTokubetsuChiikiKasanGemmenManager;
import jp.co.ndensan.reams.db.dbd.service.core.hanyolist.HanyoListManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.core.hanyolist.HanyoListShutsuryokuKomoku;
import jp.co.ndensan.reams.db.dbz.business.report.hanyolist.HanyoListReport;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.Outputs;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.ShutsuryokuKomokuPosition;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist.HanyoListEntity;
import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.hanyolist.HanyoListReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder._SetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.PageBreakType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.SortOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.NewpageType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.YamawakeType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト出力(特別地域加算減免)_process処理クラスです。
 *
 * @reamsid_L DBD-3910-030 panxiaobo
 */
public class HanyoListTokubetsuChiikiKasanGemmenProcess extends BatchProcessBase<TokubetsuChiikiKasanGemmenEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701007");
    private static final RString SHOKISAIHIHOKENSHANO = new RString("shoKisaiHokenshaNo");
    private static final RString HIHOKENSHANO = new RString("hihokenshaNo");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolisttokubetsuchiikikasangemmen."
            + "IHanyoListTokubetsuChiikiKasanGemmenMapper.get汎用リスト");
    private final List<RString> csvHeader = new ArrayList<>();
    private List<RString> csvContent;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private HanyoListTokubetsuChiikiKasanGemmenProcessParameter processParamter;
    private CsvWriter<TokubetsuChiikiKasanGemmenEucCsvEntity> eucCsvWriter;
    private CsvListWriter eucCsvWriter1;
    private Association association;
    private HokenshaList hokenshaList;
    private List<PersonalData> personalDataList;
    private boolean is帳票出力;
    private boolean isCSV出力;
    private RString csvFilePath1;
    private RString 項目見出し;
    private int 項目名称;
    private int 項目内容lenth;
    private int 出力文字の開始位置;
    private int 出力桁数;
    private RString 項目内容;
    private IOutputOrder outputOrder;
    private int 連番;
    private int 連番flag;
    private HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku;
    @BatchWriter
    private BatchReportWriter<HanyoListReportSource> batchReportWrite;
    private ReportSourceWriter<HanyoListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        personalDataList = new ArrayList<>();
        連番 = 0;
        連番flag = 0;
        項目見出し = RString.EMPTY;
        項目内容 = RString.EMPTY;
        出力文字の開始位置 = 0;
        出力桁数 = 0;
        csvContent = new ArrayList<>();
        // TODO : 出力項目の設定ができるようになったら下を採用
        hanyoListShutsuryokuKomoku = null;
//        hanyoListShutsuryokuKomoku = HanyoListReportUtil.createInstance()
//                .get汎用リスト出力項目(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給,
//                        new ReportId(processParamter.getCyohyoid()), Long.parseLong(processParamter.getSyutsuryokukomoku().toString()));
        set帳表CSV出力();

    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBD介護受給, new ReportId(processParamter.getCyohyoid()),
                Long.valueOf(processParamter.getSyutsuryokujunparameter().toString()));
        RString 出力順 = get出力順();
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        List<JuminJotai> 住民状態List = new ArrayList<>();
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set住民種別(get住民種別(住民種別List));
        key.set住民状態(get住民状態(住民状態List));
        HanyoListManager.createInstance().地区区分編集(processParamter.getAtenacyusyutsujyoken(), key);
        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key.build();
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toTokubetsuChiikiKasanGemmenMybatisParameter(psmShikibetsuTaisho, psmAtesaki, 出力順));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBD_TokubetsuChiikiKasanGemmen_Temp.csv"));
        csvFilePath1 = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBD_TokubetsuChiikiKasanGemmen.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParamter.isCsvkomokumeifuka()).
                build();
        eucCsvWriter1 = new CsvListWriter.InstanceBuilder(csvFilePath1).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                build();
        List<RString> pageBreakKeys = new ArrayList<>();
        HanyoListTokubetsuChiikiKasanGemmenManager.createInstance().set改頁Key(outputOrder, pageBreakKeys);
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBZ.DBZ700001.getReportId().value(), SubGyomuCode.DBZ介護共通).addBreak(
                new BreakerCatalog<HanyoListReportSource>().simplePageBreaker(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);

    }

    @Override
    protected void process(TokubetsuChiikiKasanGemmenEntity entity) {
        連番 = 連番 + 1;
        TokubetsuChiikiKasanGemmenEucCsvEntity eucCsvEntity = new TokubetsuChiikiKasanGemmenEucCsvEntity();
        HanyoListTokubetsuChiikiKasanGemmenManager.createInstance().get情報設定(eucCsvEntity, entity, association,
                hokenshaList, processParamter.isCsvhitsukesurasyuhensyu());
        eucCsvEntity.set連番(new RString(String.valueOf(連番)));
        eucCsvWriter.writeLine(eucCsvEntity);
        personalDataList.add(toPersonalData(entity));
        boolean flag = false;
        // TODO : 出力項目を設定できるようになったら下を採用
        int index = 0;
        for (TokubetsuChiikiKasanGemmenCsvEnumEntity e : TokubetsuChiikiKasanGemmenCsvEnumEntity.values()) {
            RString 項目内容new = RString.EMPTY;
            RString get項目名称 = e.get名称().substring(3);
            Class clazz = eucCsvEntity.getClass();
            Method getMethod;
            try {
                getMethod = clazz.getDeclaredMethod(e.get名称().toString());
                項目内容new = get項目内容(getMethod, 項目内容new, eucCsvEntity, index);
            } catch (NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HanyoListTokubetsuChiikiKasanGemmenProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            flag = flag ? flag : flag判定(flag, 項目内容new);
            帳票出力とCSV出力編集(index, hanyoListShutsuryokuKomoku, get項目名称, 項目内容new);
            index++;
        }
        帳票出力とCSV出力(entity, flag);
//        if (hanyoListShutsuryokuKomoku != null) {
//            for (int i = 0; i < hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().size(); i++) {
//                RString 項目内容new = RString.EMPTY;
//                RString get項目名称 = hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get項目名称();
//                if (get項目名称 != null && !get項目名称.isEmpty()) {
//                    Class clazz = eucCsvEntity.getClass();
//                    Method getMethod;
//                    try {
//                        getMethod = clazz.getDeclaredMethod(TokubetsuChiikiKasanGemmenCsvEnumEntity
//                                .toValue(new RString(String.valueOf(hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト()
//                                                        .get(i).get項目位置()))).get名称().toString());
//                        項目内容new = get項目内容(getMethod, 項目内容new, eucCsvEntity, i);
//                    } catch (NoSuchMethodException | SecurityException ex) {
//                        Logger.getLogger(HanyoListTokubetsuChiikiKasanGemmenProcess.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    flag = flag判定(flag, 項目内容new);
//                    帳票出力とCSV出力編集(i, hanyoListShutsuryokuKomoku, get項目名称, 項目内容new);
//                }
//            }
//            帳票出力とCSV出力(entity, flag);
//        }
    }

    @Override
    protected void afterExecute() {
        if (eucCsvWriter.getCount() == 0) {
            eucCsvWriter.writeLine(HanyoListTokubetsuChiikiKasanGemmenManager.createInstance().setBlank());
            // TODO : 出力項目が選択できるようになったら下を採用
            int index = 0;
            for (TokubetsuChiikiKasanGemmenCsvEnumEntity e : TokubetsuChiikiKasanGemmenCsvEnumEntity.values()) {
                RString get項目名称 = e.get名称().substring(3);
                帳票出力とCSV出力編集new(index, hanyoListShutsuryokuKomoku, get項目名称);
                index++;
            }
            帳票出力とCSV出力();
//            if (hanyoListShutsuryokuKomoku != null) {
//                for (int i = 0; i < hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().size(); i++) {
//                    RString get項目名称 = hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get項目名称();
//                    帳票出力とCSV出力編集new(i, hanyoListShutsuryokuKomoku, get項目名称);
//                }
//                帳票出力とCSV出力();
//            }
            
        }
        eucCsvWriter.close();
        eucCsvWriter1.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        if (isCSV出力) {
            manager.spool(csvFilePath1, log);
        }
        if (is帳票出力) {
            AccessLogUUID reportLog = AccessLogger.logReport(personalDataList);
            batchReportWrite.addPrivacy(reportLog);
        }
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter1.getCount()));
        HanyoListTokubetsuChiikiKasanGemmenManager.createInstance().バッチ出力条件リストの出力(processParamter, 導入団体コード,
                市町村名, is帳票出力, 出力ページ数, 出力件数);
    }

    private void set帳表CSV出力() {
        if (processParamter.getSyutsuryoku().equals(Outputs.帳票_CSV出力.getコード())
                || processParamter.getSyutsuryoku().equals(Outputs.CSVのみ出力.getコード())) {
            isCSV出力 = true;
        }
        if (processParamter.getSyutsuryoku().equals(Outputs.帳票_CSV出力.getコード())
                || processParamter.getSyutsuryoku().equals(Outputs.帳票のみ出力.getコード())) {
            is帳票出力 = true;
        }

    }

    private void 帳票出力とCSV出力編集new(int i, HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku, RString get項目名称) {
        if (is帳票出力) {
            帳票出力編集new(i, hanyoListShutsuryokuKomoku, get項目名称);
        }
        if (processParamter.isCsvkomokumeifuka() && isCSV出力) {
            出力編集new(i, get項目名称);
        }
    }

    private void 帳票出力編集new(int i, HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku, RString get項目名称) {
        int get項目桁数 = hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get項目桁数();
        if (get項目名称.length()
                > get項目桁数) {
            get項目名称 = get項目名称.substring(0, get項目桁数);
        } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.左詰め.getコード())) {
            int 桁数 = get項目桁数 - get項目名称.length();
            for (int j = 0; j < 桁数; j++) {
                get項目名称 = get項目名称.concat(RString.HALF_SPACE);
            }
        } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.右詰め.getコード())) {
            int 桁数 = get項目桁数 - get項目名称.length();
            for (int j = 0; j < 桁数; j++) {
                get項目名称 = RString.HALF_SPACE.concat(get項目名称);
            }
        }
        if (i == 0) {
            項目見出し = 項目見出し.concat(get項目名称);
            出力桁数 = get項目桁数;
            項目名称 = 出力文字の開始位置 + get項目名称.length();

        } else {
            出力文字の開始位置 = 出力桁数 + hanyoListShutsuryokuKomoku.get項目間スペース数();
            項目見出し = get項目見出し(項目見出し, 出力文字の開始位置 - 項目名称);
            項目見出し = 項目見出し.concat(get項目名称);
            出力桁数 = 出力文字の開始位置 + get項目桁数;
            項目名称 = 出力文字の開始位置 + get項目名称.length();
        }
    }

    private void 出力編集new(int i, RString get項目名称) {
        if (processParamter.isCsvrenbanfuka()) {
            連番ありnew(i, get項目名称);
        } else {
            csvHeader.add(get項目名称);
        }
    }

    private void 連番ありnew(int i, RString get項目名称) {
        if (i == 0) {
            csvHeader.add(new RString("連番"));
        }
        csvHeader.add(get項目名称);
    }

    private void 帳票出力とCSV出力() {
        if (is帳票出力) {
            HanyoListEntity hanyolistentity = new HanyoListEntity();
            HanyoListReport report = new HanyoListReport(hanyolistentity, processParamter.getHyoudai(),
                    processParamter.getDetasyubetsumesyo(), 項目見出し, 項目内容, association, outputOrder);
            report.writeBy(reportSourceWriter);
        }
        if (processParamter.isCsvkomokumeifuka() && isCSV出力) {
            eucCsvWriter1.writeLine(csvHeader);
        }
    }

    private void 帳票出力とCSV出力編集(int i, HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku, RString get項目名称, RString 項目内容new) {
        if (is帳票出力) {
            帳票出力編集(i, hanyoListShutsuryokuKomoku, get項目名称, 項目内容new);
        }
        if (isCSV出力) {
            出力編集(i, get項目名称, 項目内容new);
        }
    }

    private void 帳票出力とCSV出力(TokubetsuChiikiKasanGemmenEntity entity, boolean flag) {
        if (is帳票出力) {
            if (flag) {
                HanyoListEntity hanyolistentity = new HanyoListEntity();
                HanyoListTokubetsuChiikiKasanGemmenManager.createInstance().get方法(entity, hanyolistentity);
                HanyoListReport report = new HanyoListReport(hanyolistentity, processParamter.getHyoudai(),
                        processParamter.getDetasyubetsumesyo(), 項目見出し, 項目内容, association, outputOrder);
                report.writeBy(reportSourceWriter);
            }
            項目見出し = RString.EMPTY;
            項目内容 = RString.EMPTY;
            出力文字の開始位置 = 0;
        }
        if (isCSV出力 && csvContent != null && !csvContent.isEmpty()) {
            連番flag = 連番flag + 1;
            if (連番flag == 1 && processParamter.isCsvkomokumeifuka() && csvHeader != null && !csvHeader.isEmpty()) {
                eucCsvWriter1.writeLine(csvHeader);
            }
            if (flag) {
                eucCsvWriter1.writeLine(csvContent);
            }
            csvContent = new ArrayList();
        }
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, new ReportId(processParamter.getCyohyoid()),
                Long.valueOf(processParamter.getSyutsuryokujunparameter().toString()));
        List<RString> 出力DB項目名 = new ArrayList();
        List<ISetSortItem> 設定項目リスト = order.get設定項目リスト();
        for (ISetSortItem item : 設定項目リスト) {
            出力DB項目名.add(item.getDB項目名());
        }
        if (!出力DB項目名.contains(SHOKISAIHIHOKENSHANO)) {
            order.get設定項目リスト().add(new _SetSortItem(GyomuCode.DB介護保険, new RString("0103"), SHOKISAIHIHOKENSHANO, NewpageType.選択不可,
                    0, YamawakeType.設定不可, SubGyomuCode.DBD介護受給, CodeShubetsu.EMPTY, 0, SortOrder.ASCENDING,
                    true, true, PageBreakType.設定なし, 0, 0));
        }
        if (!出力DB項目名.contains(HIHOKENSHANO)) {
            order.get設定項目リスト().add(new _SetSortItem(GyomuCode.DB介護保険, new RString("0104"), HIHOKENSHANO, NewpageType.選択不可,
                    0, YamawakeType.設定不可, SubGyomuCode.DBD介護受給, CodeShubetsu.EMPTY, 0, SortOrder.ASCENDING,
                    true, true, PageBreakType.設定なし, 0, 0));
        }
        RString 出力順 = MyBatisOrderByClauseCreator.create(HanyoListTokubetsuChiikiKasanGemmenOrderby.class, order);
        return 出力順.concat(",特別地域加算減免_履歴番号");
    }

    private PersonalData toPersonalData(TokubetsuChiikiKasanGemmenEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private List<JuminShubetsu> get住民種別(List<JuminShubetsu> 住民種別List) {
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        return 住民種別List;
    }

    private List<JuminJotai> get住民状態(List<JuminJotai> 住民状態List) {
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        return 住民状態List;
    }

    private void 帳票出力編集(int i, HanyoListShutsuryokuKomoku hanyoListShutsuryokuKomoku, RString get項目名称, RString 項目内容new) {
        int get項目桁数 = hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get項目桁数();
        if (get項目名称.length()
                > get項目桁数) {
            get項目名称 = get項目名称.substring(0, get項目桁数);
        } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.左詰め.getコード())) {
            int 桁数 = get項目桁数 - get項目名称.length();
            for (int j = 0; j < 桁数; j++) {
                get項目名称 = get項目名称.concat(RString.HALF_SPACE);
            }
        } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.右詰め.getコード())) {
            int 桁数 = get項目桁数 - get項目名称.length();
            for (int j = 0; j < 桁数; j++) {
                get項目名称 = RString.HALF_SPACE.concat(get項目名称);
            }
        }
        if (項目内容new != null && !項目内容new.isEmpty()) {
            if (項目内容new.length() > get項目桁数) {
                項目内容new = 項目内容new.substring(0, get項目桁数);
            } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.左詰め.getコード())) {
                int 桁数 = get項目桁数 - 項目内容new.length();
                for (int j = 0; j < 桁数; j++) {
                    項目内容new = 項目内容new.concat(RString.HALF_SPACE);
                }
            } else if (hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get編集方法().equals(ShutsuryokuKomokuPosition.右詰め.getコード())) {
                int 桁数 = get項目桁数 - 項目内容new.length();
                for (int j = 0; j < 桁数; j++) {
                    項目内容new = RString.HALF_SPACE.concat(項目内容new);
                }

            }
        }
        if (i == 0) {
            項目見出し = 項目見出し.concat(get項目名称);
            if (項目内容new == null || 項目内容new.isEmpty()) {
                項目内容 = get項目見出し(項目内容, get項目桁数);
                項目内容lenth = get項目桁数;
            } else {
                項目内容 = 項目内容.concat(項目内容new);
                項目内容lenth = 出力文字の開始位置 + 項目内容new.length();
            }
            出力桁数 = get項目桁数;
            項目名称 = 出力文字の開始位置 + get項目名称.length();

        } else {
            出力文字の開始位置 = 出力桁数 + hanyoListShutsuryokuKomoku.get項目間スペース数();
            項目見出し = get項目見出し(項目見出し, 出力文字の開始位置 - 項目名称);
            項目見出し = 項目見出し.concat(get項目名称);
            項目内容 = get項目見出し(項目内容, 出力文字の開始位置 - 項目内容lenth);
            if (項目内容new == null || 項目内容new.isEmpty()) {
                項目内容 = get項目見出し(項目内容, get項目桁数);
                項目内容lenth = get項目桁数;
            } else {
                項目内容 = 項目内容.concat(項目内容new);
                項目内容lenth = 出力文字の開始位置 + 項目内容new.length();
            }
            出力桁数 = 出力文字の開始位置 + get項目桁数;
            項目名称 = 出力文字の開始位置 + get項目名称.length();

        }
    }

    private void 出力編集(int i, RString get項目名称, RString 項目内容new) {
        if (processParamter.isCsvrenbanfuka()) {
            連番あり(i, get項目名称, 項目内容new);
        } else {
            csvHeader.add(get項目名称);
            if (項目内容new != null && !項目内容new.isEmpty()) {
                csvContent.add(項目内容new);
            } else {
                csvContent.add(new RString(" "));
            }
        }
    }

    private void 連番あり(int i, RString get項目名称, RString 項目内容new) {
        if (i == 0) {
            csvHeader.add(new RString("連番"));
            csvContent.add(new RString(String.valueOf(連番)));
        }
        csvHeader.add(get項目名称);
        if (項目内容new != null && !項目内容new.isEmpty()) {
            csvContent.add(項目内容new);
        } else {
            csvContent.add(new RString(" "));
        }
    }

    private RString get項目見出し(RString 項目見出し, int 出力文字の開始位置) {
        for (int i = 0; i < 出力文字の開始位置; i++) {
            項目見出し = 項目見出し.concat(RString.HALF_SPACE);
        }
        return 項目見出し;
    }

    private RString get項目内容(Method getMethod, RString 項目内容new, TokubetsuChiikiKasanGemmenEucCsvEntity eucCsvEntity, int i) {
        try {
            項目内容new = (RString) getMethod.invoke(eucCsvEntity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(HanyoListTokubetsuChiikiKasanGemmenProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (項目内容new != null && !項目内容new.isEmpty()) {
            項目内容new = HanyoListManager.createInstance().項目内容new編集(i, 項目内容new, hanyoListShutsuryokuKomoku);
        }
        return 項目内容new;
    }

    private boolean flag判定(boolean flag, RString 項目内容new) {
        if (項目内容new != null && !項目内容new.isEmpty()) {
            flag = true;
        }
        return flag;
    }
}
