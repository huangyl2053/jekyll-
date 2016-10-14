/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD201010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist.RiyoshaFutanGakuGemmenNinteishaListProperty;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist.RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200002.NinteishaListSakuseiBusiness;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200002.RiyoshaFutangakuGemmenGaitoshaIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.SeteiYouEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
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
 * 利用者負担額減免認定者リスト発行です。
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class NinteishaListSakuseiProcess extends BatchProcessBase<NinteishaListSakuseiResultEntity> {

    private NinteishaListSakuseiProcessParameter parameter;
    private IOutputOrder outputOrder;
    private RString 出力順;
    private RString reamsLoginID;
    private Association 導入団体;
    private RString 帳票ID;
    private RString 帳票タイトル;
    private RString 改ページ;
    private static final RString 認定者リストタイトル = new RString("介護保険 利用者負担額減免認定者リスト");
    private static final RString 該当者リストタイトル = new RString("介護保険 利用者負担額減免該当者リスト");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString ONE = new RString("1");
    private static final RString 課 = new RString("課");
    private static final ReportIdDBD REPORT_DBD200002 = ReportIdDBD.DBD200002;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoulyagennmenn."
            + "IGennMennGennGakuTaiSyoulyaMapper.select利用者負担額減免認定者");
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private CsvWriter<NinteishaListSakuseiResultCsvEntity> eucCsvWriter;
    private EucEntityId eUC_ENTITY_ID;
    private RString ファイル名;
    private RString 帳票名称;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private boolean 項目名付加;
    private RDate 帳票作成日時;
    private FlexibleDate 帳票日時;
    private static final int NUM5 = 5;
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private NinteishaListSakuseiBusiness business;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        帳票作成日時 = RDate.getNowDate();
        帳票日時 = new FlexibleDate(帳票作成日時.toDateString());
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD200002.getReportId(),
                reamsLoginID,
                parameter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(DBD200002_ResultListEnum.class, outputOrder), NUM5);
        }
        導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票ID = parameter.get帳票ID();
        edit初期化();
        business = new NinteishaListSakuseiBusiness();
    }

    @BatchWriter
    private BatchReportWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(shikibetsuTaishoPSMSearchKey);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinteishaListSakuseiMybatisprmParameter(shikibetsutaishoParam, 出力順));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(outputOrder, pageBreakKeys);
        if (!pageBreakKeys.isEmpty()) {
            batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200002.getReportId().value(),
                    SubGyomuCode.DBD介護受給).addBreak(
                            new BreakerCatalog<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource>()
                            .simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200002.getReportId().value(),
                    SubGyomuCode.DBD介護受給).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, eUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(項目名付加).
                build();
    }

    @Override
    protected void process(NinteishaListSakuseiResultEntity t) {
        RiyoshaFutangakuGemmenGaitoshaIchiranReport reportSource = new RiyoshaFutangakuGemmenGaitoshaIchiranReport(t, 帳票日時,
                outputOrder, 導入団体.getLasdecCode_().getColumnValue(), 導入団体.getShichosonName_(), 帳票タイトル, 改ページ);
        reportSource.writeBy(reportSourceWriter);

        if (t.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            ExpandedInformation expandedInformations
                    = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.get被保険者番号().getColumnValue());
            PersonalData personalData = PersonalData.of(kojin.get識別コード(), expandedInformations);
            personalDataList.add(personalData);
        } else {
            if (t.get世帯員リスト() != null) {
                for (SeteiYouEntity entity : t.get世帯員リスト()) {
                    IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
                    PersonalData personalData = PersonalData.of(kojin.get識別コード());
                    personalDataList.add(personalData);
                }
            }
        }
        if (t.get世帯員リスト() != null) {
            NinteishaListSakuseiResultCsvEntity resultEntity = business.set利用者負担額減免認定者リストCSV(t, parameter.getCsv出力設定());
            NinteishaListSakuseiResultCsvEntity csvEntity = resultEntity;
            for (SeteiYouEntity entity : t.get世帯員リスト()) {
                IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
                csvEntity.set世帯員氏名(kojin.get名称().getName().getColumnValue());
                csvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
                if (entity.get課税区分() != null && KazeiKubun.課税.getコード().equals(entity.get課税区分())) {
                    csvEntity.set世帯員課税区分(課);
                }
                if (entity.get課税所得額() != null && entity.get課税所得額().intValue() > 0) {
                    csvEntity.set世帯員所得税課税区分(課);
                }
                eucCsvWriter.writeLine(csvEntity);
                csvEntity = new NinteishaListSakuseiResultCsvEntity();
            }
        } else {
            NinteishaListSakuseiResultCsvEntity resultEntity = business.set利用者負担額減免認定者リストCSV(t, parameter.getCsv出力設定());
            eucCsvWriter.writeLine(resultEntity);
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);
        バッチ出力条件リストの出力();
    }

    private void edit初期化() {
        NinteishaListSakuseiProcessParameter processParameter
                = new NinteishaListSakuseiProcessParameter(parameter.get対象リスト());
        if (processParameter.is該当者リスト()) {
            帳票タイトル = 該当者リストタイトル;
            eUC_ENTITY_ID = new EucEntityId("DBD201010");
            ファイル名 = new RString("RiyoshaFutangakuGemmenGaitoshaIchiran.csv");
            帳票名称 = new RString("DBD200002_RiyoshaFutangakuGemmenGaitoshaIchiran");
        } else if (processParameter.is認定者リスト()) {
            帳票タイトル = 認定者リストタイトル;
            eUC_ENTITY_ID = new EucEntityId("DBD201011");
            ファイル名 = new RString("RiyoshaFutangakuGemmenNinteishaIchiran.csv");
            帳票名称 = new RString("DBD200013_RiyoshaFutangakuGemmenNinteishaIchiran");
        }
        項目名付加 = false;
        if (parameter.getCsv出力設定() != null && !parameter.getCsv出力設定().isEmpty()) {
            for (CSVSettings csvsetings : parameter.getCsv出力設定()) {
                if (ONE.equals(csvsetings.getコード())) {
                    項目名付加 = true;
                }
            }
        }
    }

    private void バッチ出力条件リストの出力() {
        帳票ID = 帳票名称;
        RString 導入団体コード = 導入団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 導入団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = new RString("");
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString csv出力有無 = new RString("あり");
        RString csvファイル名 = ファイル名;

        List<RString> 出力条件 = new ArrayList<>();
        if (parameter.get基準日() != null && !parameter.get基準日().isEmpty()) {
            出力条件.add(parameter.get基準日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        RString 所得年度 = new RString("");
        if (parameter.get所得年度() != null && !parameter.get所得年度().isEmpty()) {
            所得年度 = parameter.get所得年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        出力条件.add(new RString("【所得年度】 " + 所得年度));
        出力条件.add(new RString("【旧措置者区分】 " + parameter.get旧措置区分().get名称()));
        出力条件.add(new RString("【世帯表示】 " + parameter.get世帯表示().get名称()));
        if (TargetList.該当者リスト.equals(parameter.get対象リスト())) {
            出力条件.add(new RString("【受給者区分】 " + parameter.get受給者区分().get名称()));
            RString 世帯非課税等 = new RString("");
            if (null == parameter.get世帯非課税等() || parameter.get世帯非課税等().isEmpty()) {
                世帯非課税等 = new RString("【世帯非課税等】 指定なし");
            } else {
                世帯非課税等 = set世帯非課税等(世帯非課税等, parameter.get世帯非課税等());
            }
            出力条件.add(世帯非課税等);
        }
        if (null != parameter.getCsv出力設定()) {
            出力条件.add(new RString("【CSV出力設定】 項目名付加、連番付加、日付\"/\"編集"));
        } else {
            出力条件.add(new RString("【CSV出力設定】 指定なし"));
        }
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        RString 作成日時 = 帳票作成日時.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(timeFormat);

        出力条件.add(作成日時);
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString set世帯非課税等(RString 世帯非課税等, List<HihokenshaKeizaiJokyo> get世帯非課税等) {
        int count = 0;
        for (HihokenshaKeizaiJokyo 世帯非課税 : get世帯非課税等) {
            if (count == 0) {
                世帯非課税等 = new RString("【世帯非課税等】 ").concat(世帯非課税.get名称());
            } else {
                世帯非課税等 = 世帯非課税等.concat(new RString("    ")).concat(世帯非課税.get名称());
            }
        }
        return 世帯非課税等;
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
        if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("listUpper_2");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.行政区コード.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("listLower_1");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.被保険者番号.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("listUpper_1");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.町域コード.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("choikiCode");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.世帯コード.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("setaiCode");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.識別コード.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikibetsuCode");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.氏名５０音カナ.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("kanaShimei");
        } else if (RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum.市町村コード.
                get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shichosonCode");
        }
        return 帳票物理名;
    }
}
