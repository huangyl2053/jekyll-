/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710140;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbd.business.report.HanyoListRiyoshaFutanwariaiOrderby;
import jp.co.ndensan.reams.db.dbd.definition.core.hanyorisutoriyoshafutanwariai.RiyoshaFutanwariaiCsvEnumEntity;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd710140.HanyoListRiyoshaFutanwariaiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd710140.HanyoListRiyoshaFutanwariaiManager;
import jp.co.ndensan.reams.db.dbd.service.core.hanyolist.HanyoListManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.core.hanyolist.HanyoListShutsuryokuKomoku;
import jp.co.ndensan.reams.db.dbz.business.report.hanyolist.HanyoListReport;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.Outputs;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.ShutsuryokuKomokuPosition;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
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
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.PageBreakType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.SortOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.NewpageType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.YamawakeType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト出力(利用者負担割合)_process処理クラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public class HanyoListRiyoshaFutanwariaiProcess extends BatchProcessBase<HanyoRisutoRiyoshaFutanWariaiEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701014");
    private static final RString HIHOKENSHANO = new RString("利用者負担割合_被保険者番号");
    private static final RString CYUSYUTSUTAISYOSHA = new RString("【抽出対象者】");
    private static final RString HOKENSHA = new RString("保険者：");
    private static final RString NENDO = new RString("年度：");
    private static final RString KIZYUNNICHI = new RString("基準日：");
    private static final RString NENLEIKIZYUNNICHI = new RString("年齢基準日:");
    private static final RString CHOKINNOMI = new RString("対象データ：直近のみ");
    private static final RString FUTANWARIAIKUBUN = new RString("負担割合区分：");
    private static final RString FUTANWARIAI_1_2 = new RString("１割・２割");
    private static final RString FUTANWARIAI_1 = new RString("１割");
    private static final RString FUTANWARIAI_2 = new RString("２割");
    private static final RString CHIKI_1 = new RString("地区１");
    private static final RString CHIKI_2 = new RString("地区２");
    private static final RString CHIKI_3 = new RString("地区３");
    private static final RString GYOSEIKU = new RString("行政区");
    private static final RString JUSYO = new RString("住所");
    private static final RString NENLEI = new RString("年齢");
    private static final RString SEINENGAPPI = new RString("生年月日");
    private static final RString SAI = new RString("歳");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutoriyoshafutanwariai."
            + "IHanyoRisutoRiyoshaFutanWariaiMapper.get汎用リスト");
    private static final RString SPACE = new RString(" ");
    private static final RString COMMA = new RString(",");
    private static final RString COLON = new RString(":");
    private static final RString カラ = new RString("～");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private final List<RString> csvHeader = new ArrayList<>();
    private List<RString> csvContent;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private HanyoListRiyoshaFutanwariaiProcessParameter processParamter;
    private CsvWriter<HanyoRisutoRiyoshaFutanWariaiEucCsvEntity> eucCsvWriter;
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
        hanyoListShutsuryokuKomoku = HanyoListReportUtil.createInstance()
                .get汎用リスト出力項目(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給,
                        new ReportId(processParamter.getCyohyoid()), Long.parseLong(processParamter.getSyutsuryokukomoku().toString()));
        set帳表CSV出力();
    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBD介護受給, new ReportId(processParamter.getCyohyoid()),
                Long.valueOf(processParamter.getSyutsuryokujun().toString()));
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
                processParamter.toHanyoRisutoRiyoshaFutanWariaiMybatisParameter(psmShikibetsuTaisho, psmAtesaki, 出力順));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBD_RiyoshaFutanWariai_Temp.csv"));
        csvFilePath1 = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_RiyoshaFutanWariai.csv"));
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
        set改頁Key(outputOrder, pageBreakKeys);
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBZ.DBZ700001.getReportId().value(), SubGyomuCode.DBZ介護共通)
                .addBreak(new BreakerCatalog<HanyoListReportSource>().simplePageBreaker(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        連番 = 連番 + 1;
        HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity = new HanyoRisutoRiyoshaFutanWariaiEucCsvEntity();
        HanyoListRiyoshaFutanwariaiManager.createInstance().CSV情報設定(eucCsvEntity, entity, association, hokenshaList,
                processParamter.isCsvhitsukesurasyuhensyu());
        eucCsvWriter.writeLine(eucCsvEntity);
        personalDataList.add(toPersonalData(entity));
        Class clazz = eucCsvEntity.getClass();
        RString 項目内容new = RString.EMPTY;
        boolean flag = false;
        HanyoListEntity hanyolistentity = new HanyoListEntity();
        get方法(entity, hanyolistentity);
        if (hanyoListShutsuryokuKomoku != null) {
            for (int i = 0; i < hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().size(); i++) {
                RString get項目名称 = hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト().get(i).get項目名称();
                if (get項目名称 != null && !get項目名称.isEmpty()) {
                    try {
                        Method getMethod = clazz.getDeclaredMethod(RiyoshaFutanwariaiCsvEnumEntity
                                .toValue(new RString(String.valueOf(hanyoListShutsuryokuKomoku.get汎用リスト出力項目リスト()
                                                        .get(i).get項目位置()))).get名称().toString());
                        項目内容new = (RString) getMethod.invoke(eucCsvEntity);
                        if (項目内容new != null && !項目内容new.isEmpty()) {
                            項目内容new = HanyoListManager.createInstance().項目内容new編集(i, 項目内容new, hanyoListShutsuryokuKomoku);
                            flag = true;
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                            IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(HanyoListRiyoshaFutanwariaiProcess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (is帳票出力) {
                        帳票出力編集(i, hanyoListShutsuryokuKomoku, get項目名称, 項目内容new);
                    }
                    if (isCSV出力) {
                        出力編集(i, get項目名称, 項目内容new);
                    }
                }
            }
            if (is帳票出力) {
                if (flag) {
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
    }

    @Override
    protected void afterExecute() {
        if (processParamter.isCsvkomokumeifuka() && eucCsvWriter.getCount() == 0) {
            eucCsvWriter.writeLine(HanyoListRiyoshaFutanwariaiManager.createInstance().setBlank());
        }
        eucCsvWriter.close();
        eucCsvWriter1.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        if (isCSV出力) {
            manager.spool(csvFilePath1, log);
        }
        バッチ出力条件リストの出力();
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

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, new ReportId(processParamter.getCyohyoid()),
                Long.valueOf(processParamter.getSyutsuryokujun().toString()));
        List<RString> 出力DB項目名 = new ArrayList();
        List<ISetSortItem> 設定項目リスト = order.get設定項目リスト();
        for (ISetSortItem item : 設定項目リスト) {
            出力DB項目名.add(item.getDB項目名());
        }
        if (!出力DB項目名.contains(HIHOKENSHANO)) {
            order.get設定項目リスト().add(new _SetSortItem(GyomuCode.DB介護保険, new RString("0009"), HIHOKENSHANO, NewpageType.選択不可,
                    0, YamawakeType.設定不可, SubGyomuCode.DBD介護受給, CodeShubetsu.EMPTY, 0, SortOrder.ASCENDING,
                    true, true, PageBreakType.設定なし, 0, 0));
        }
        RString 出力順 = MyBatisOrderByClauseCreator.create(HanyoListRiyoshaFutanwariaiOrderby.class, order);
        return 出力順.concat(",利用者負担割合_履歴番号,利用者負担割合_枝番号");
    }

    private PersonalData toPersonalData(HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString 日本語ファイル名 = new RString("汎用リスト　利用者負担割合CSV");
        RString 英数字ファイル名 = new RString("HanyoList_RiyosyaFutanwariai.csv");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(CYUSYUTSUTAISYOSHA);
        RStringBuilder builder = new RStringBuilder();
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getShichoson_Code()
                && !processParamter.getAtenacyusyutsujyoken().getShichoson_Code().equals(LasdecCode.EMPTY)) {
            builder.append(HOKENSHA);
            Association 地方公共団体 = get地方公共団体(processParamter.getAtenacyusyutsujyoken().getShichoson_Code());
            builder.append(地方公共団体.get市町村名());
            builder.append(COMMA);
        }
        if (null != processParamter.getNendo()) {
            builder.append(NENDO);
            builder.append(processParamter.getNendo().wareki().eraType(EraType.KANJI).toDateString());
            builder.append(COMMA);
        }
        if (null != processParamter.getKizyunnichi()) {
            builder.append(KIZYUNNICHI);
            builder.append(processParamter.getKizyunnichi().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(COMMA);
        }
        if (processParamter.isNendochokindatacyusyutsu()) {
            builder.append(CHOKINNOMI);
            builder.append(COMMA);
        }
        if (builder.toRString() != null && !builder.toRString().isEmpty()) {
            List<RString> builderList = builder.toRString().substring(0, builder.toRString().length() - 1).split(COMMA.toString());
            for (RString build : builderList) {
                出力条件.add(build);
            }
        }
        if (get事業対象者負担情報() != null && get事業対象者負担情報().isEmpty()) {
            出力条件.add(get事業対象者負担情報());
        }
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun()) {
            RString get宛名抽出区分情報 = get宛名抽出区分情報();
            if (get宛名抽出区分情報 != null && !get宛名抽出区分情報.isEmpty()) {
                出力条件.add(get宛名抽出区分情報());
            }
        }
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getChiku_Kubun()) {
            RString get地区区分情報 = get地区選択区分情報();
            if (get地区区分情報 != null && !get地区区分情報.isEmpty()) {
                List<RString> 地区区分情報 = get地区区分情報.substring(0, get地区区分情報.length() - 1).split(COMMA.toString());
                for (RString 情報 : 地区区分情報) {
                    出力条件.add(情報);
                }
            }
        }
        バッチ出力条件表出力(導入団体コード, 市町村名, 出力ページ数, 日本語ファイル名, 英数字ファイル名, ジョブ番号, 出力条件);
    }

    private void バッチ出力条件表出力(RString 導入団体コード, RString 市町村名, RString 出力ページ数, RString 日本語ファイル名,
            RString 英数字ファイル名, RString ジョブ番号, List<RString> 出力条件) {
        if (is帳票出力) {
            RString csv出力有無;
            RString csvファイル名;
            if (processParamter.getSyutsuryoku().equals(Outputs.帳票_CSV出力.getコード())) {
                csv出力有無 = new RString("あり");
                csvファイル名 = 英数字ファイル名;
            } else {
                csv出力有無 = new RString("なし");
                csvファイル名 = RString.EMPTY;
            }
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    new RString("DBD701014"),
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    processParamter.getHyoudai(),
                    出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        } else if (processParamter.getSyutsuryoku().equals(Outputs.CSVのみ出力.getコード())) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    日本語ファイル名,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字ファイル名,
                    new RString("DBD701014"),
                    出力ページ数,
                    出力条件);
            EucFileOutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private RString get地区区間出力条件(RString codeFrom, RString fromMesho, RString codeTo, RString toMesho) {
        RStringBuilder builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(codeFrom)) {
            builder.append(左記号);
            builder.append(codeFrom);
            builder.append(右記号);
            builder.append(SPACE);
            builder.append(fromMesho);
            builder.append(SPACE);
        }
        builder.append(カラ);
        if (!RString.isNullOrEmpty(codeTo)) {
            builder.append(SPACE);
            builder.append(左記号);
            builder.append(codeTo);
            builder.append(右記号);
            builder.append(SPACE);
            builder.append(toMesho);
        }
        return builder.toRString();
    }

    private RString get宛名抽出区分情報() {
        RStringBuilder builder = new RStringBuilder();
        if (NenreiSoChushutsuHoho.年齢範囲.equals(processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun())
                && processParamter.getAtenacyusyutsujyoken().getNenreiKijunbi() != null) {
            builder = get年齢();
        } else if (NenreiSoChushutsuHoho.生年月日範囲.equals(processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun())) {
            builder = get生年月日();
        }
        return builder.toRString();
    }

    private RString get地区選択区分情報() {
        RStringBuilder builder = new RStringBuilder();
        if (Chiku.地区.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            if (!RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku1_From())
                    && !RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku1_To())) {
                builder.append(CHIKI_1);
                builder.append(COLON);
                builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getChiku1_From(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_FromMesho(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_To(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_ToMesho()));
            } else if (!RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku2_From())
                    && RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku2_To())) {
                builder.append(CHIKI_2);
                builder.append(COLON);
                builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getChiku2_From(),
                        processParamter.getAtenacyusyutsujyoken().getChiku2_FromMesho(),
                        RString.EMPTY,
                        RString.EMPTY));
            } else if (RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku3_From())
                    && !RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku3_To())) {
                builder.append(CHIKI_3);
                builder.append(COLON);
                builder.append(get地区区間出力条件(RString.EMPTY,
                        RString.EMPTY,
                        processParamter.getAtenacyusyutsujyoken().getChiku3_To(),
                        processParamter.getAtenacyusyutsujyoken().getChiku3_ToMesho()));
            }
        } else if (Chiku.行政区.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            builder.append(GYOSEIKU);
            builder.append(COLON);
            builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getGyoseiku_From(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_FromMesho(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_To(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_ToMesho()));
        } else if (Chiku.住所.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            builder.append(JUSYO);
            builder.append(COLON);
            builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getJusho_From(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_FromMesho(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_To(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_ToMesho()));
        }
        return builder.toRString();
    }

    private RString get事業対象者負担情報() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isJigyotaishoshafutanichiwari() && processParamter.isJigyotaishoshafutanniwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_1_2);
        } else if (processParamter.isJigyotaishoshafutanichiwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_1);
        } else if (processParamter.isJigyotaishoshafutanniwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_2);
        }
        return builder.toRString();
    }

    private RStringBuilder get年齢() {
        RStringBuilder builder = new RStringBuilder();
        if (null != processParamter.getAtenacyusyutsujyoken().getNenreiRange()
                && null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom()
                && null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo()) {
            builder.append(NENLEI);
            builder.append(SPACE);
            builder.append(COLON);
            builder.append(SPACE);
            builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom().toString()));
            builder.append(SAI);
            builder.append(SPACE);
            builder.append(カラ);
            builder.append(SPACE);
            builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo().toString()));
            builder.append(SAI);
            builder.append(SPACE);
            builder.append(左記号);
            builder.append(NENLEIKIZYUNNICHI);
            builder.append(processParamter.getAtenacyusyutsujyoken().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(右記号);
        } else if (null != processParamter.getAtenacyusyutsujyoken().getNenreiRange()
                && null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom()
                && null == processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo()) {
            builder.append(NENLEI);
            builder.append(SPACE);
            builder.append(COLON);
            builder.append(SPACE);
            builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom().toString()));
            builder.append(SAI);
            builder.append(SPACE);
            builder.append(カラ);
            builder.append(SPACE);
            builder.append(左記号);
            builder.append(NENLEIKIZYUNNICHI);
            builder.append(processParamter.getAtenacyusyutsujyoken().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(右記号);
        } else if (null != processParamter.getAtenacyusyutsujyoken().getNenreiRange()
                && null == processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom()
                && null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo()) {
            builder.append(NENLEI);
            builder.append(SPACE);
            builder.append(COLON);
            builder.append(SPACE);
            builder.append(カラ);
            builder.append(SPACE);
            builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo().toString()));
            builder.append(SAI);
            builder.append(SPACE);
            builder.append(左記号);
            builder.append(NENLEIKIZYUNNICHI);
            builder.append(processParamter.getAtenacyusyutsujyoken().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(右記号);
        }
        return builder;
    }

    private RStringBuilder get生年月日() {
        RStringBuilder builder = new RStringBuilder();
        if (null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange()
                && null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom()
                && null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo()) {
            builder.append(SEINENGAPPI);
            builder.append(COLON);
            builder.append(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(SPACE);
            builder.append(カラ);
            builder.append(SPACE);
            builder.append(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        } else if (null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange()
                && null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom()
                && null == processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo()) {
            builder.append(SEINENGAPPI);
            builder.append(COLON);
            builder.append(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
            builder.append(SPACE);
            builder.append(カラ);
        } else if (null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange()
                && null == processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom()
                && null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo()) {
            builder.append(SEINENGAPPI);
            builder.append(COLON);
            builder.append(SPACE);
            builder.append(カラ);
            builder.append(SPACE);
            builder.append(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        }
        return builder;
    }

    private Association get地方公共団体(LasdecCode 市町村コード) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation(市町村コード);
    }

    private List<JuminShubetsu> get住民種別(List<JuminShubetsu> 住民種別List) {
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        return 住民種別List;
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

    private List<JuminJotai> get住民状態(List<JuminJotai> 住民状態List) {
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        return 住民状態List;
    }

    private RString get項目見出し(RString 項目見出し, int 出力文字の開始位置) {
        for (int i = 0; i < 出力文字の開始位置; i++) {
            項目見出し = 項目見出し.concat(RString.HALF_SPACE);
        }
        return 項目見出し;
    }

    private void set改頁Key(IOutputOrder outputOrder, List<RString> pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > NO_0 && list.get(NO_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(NO_0).get項目ID());
            }
            if (list.size() > NO_1 && list.get(NO_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(NO_1).get項目ID());
            }
            if (list.size() > NO_2 && list.get(NO_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(NO_2).get項目ID());
            }
            if (list.size() > NO_3 && list.get(NO_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(NO_3).get項目ID());
            }
            if (list.size() > NO_4 && list.get(NO_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(NO_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {
        RString 帳票物理名 = RString.EMPTY;
        if (HanyoListRiyoshaFutanwariaiOrderby.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("yubinNo");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("choikiCode");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.番地コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("banchi");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("gyoseikuCode");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.地区１.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("chikuCode1");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.地区２.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("chikuCode2");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("setaiCode");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikibetsuCode");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("kanaShimei");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("seinengappiYMD");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("seibetsuCode");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shichosonCode1");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("hokenshaNo");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.資格区分.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikakuKubun");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.認定開始日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("ninteiKaishiYMD");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.資格取得日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikakuShutokuYMD");
        } else if (HanyoListRiyoshaFutanwariaiOrderby.資格喪失日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikakuSoshitsuYMD");
        }
        return 帳票物理名;
    }

    private void get方法(HanyoRisutoRiyoshaFutanWariaiEntity entity, HanyoListEntity hanyolistentity) {
        ChoikiCode 町域コード = entity.getPsmEntity().getChoikiCode();
        YubinNo 郵便番号 = entity.getPsmEntity().getYubinNo();
        AtenaBanchi 番地コード = entity.getPsmEntity().getBanchi();
        GyoseikuCode 行政区コード = entity.getPsmEntity().getGyoseikuCode();
        ChikuCode 地区１ = entity.getPsmEntity().getChikuCode1();
        ChikuCode 地区２ = entity.getPsmEntity().getChikuCode2();
        SetaiCode 世帯コード = entity.getPsmEntity().getSetaiCode();
        hanyolistentity.set郵便番号(郵便番号 != null ? 郵便番号.getYubinNo() : RString.EMPTY);
        hanyolistentity.set町域コード(町域コード != null ? 町域コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set番地コード(番地コード != null ? 番地コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set行政区コード(行政区コード != null ? 行政区コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set地区１(地区１ != null ? 地区１.getColumnValue() : RString.EMPTY);
        hanyolistentity.set地区２(地区２ != null ? 地区２.getColumnValue() : RString.EMPTY);
        hanyolistentity.set世帯コード(世帯コード != null ? 世帯コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set識別コード(entity.get被保険者台帳管理_識別コード());
        hanyolistentity.set氏名５０音カナ(entity.getPsmEntity().getKanaName());
        hanyolistentity.set生年月日(entity.getPsmEntity().getSeinengappiYMD());
        hanyolistentity.set性別(entity.getPsmEntity().getSeibetsuCode());
        hanyolistentity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        hanyolistentity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        hanyolistentity.set資格区分(entity.get利用者負担割合明細_資格区分());
        hanyolistentity.set認定開始日(entity.get利用者負担割合明細_有効開始日());
        hanyolistentity.set資格取得日(entity.get被保険者台帳管理_資格取得年月日());
        hanyolistentity.set資格喪失日(entity.get被保険者台帳管理_資格喪失年月日());
    }
}
