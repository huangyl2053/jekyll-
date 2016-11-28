/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.PrtMeisaiIchiranProcessPageBreak;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka.KariSanteiIdoFukaPsmParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoKinMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.FukaJohoPsmChoshuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収依頼金額明細一覧表出力クラスです。
 *
 * @reamsid_L DBB-0850-010 chenaoqi
 */
public class SpoolTokuchoKinMeisaiCSVProcess extends BatchProcessBase<FukaJohoPsmChoshuRelateEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".karisanteiidofuka.IKarisanteiIdoKekkaMapper.select特別徴収依頼金額明細");
    private static final ReportId 帳票分類ID = new ReportId("DBB200023_TokubetsuChoshuIraikingakuMeisaiIchiran");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200023");
    private static final RString EUCファイル名 = new RString("TokubetsuChoshuIraikingakuMeisaiIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 特徴開始月 = new RString("「８月」");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final int INT_1 = 1;
    private static final int INT_5 = 5;

    private KarisanteiIdoKekkaProcessParameter processParameter;
    private KariSanteiIdoFukaBatch manager;
    private FileSpoolManager spoolManager;
    private RString eucFilePath;
    private RString 出力順;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private Association 地方公共団体;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> breakKeys;
    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> reportSourceWriter;
    private CsvWriter<TokuchoKinMeisaiCSVEntity> eucCsvWriter;

    @Override
    protected void initialize() {

        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        breakKeys = new ArrayList();
        manager = KariSanteiIdoFukaBatch.createInstance();
        if (processParameter.get出力帳票Entity() != null
                && !RString.isNullOrEmpty(processParameter.get出力帳票Entity().get出力順ID())) {
            RString 出力順ID = processParameter.get出力帳票Entity().get出力順ID();
            get出力順(出力順ID);
        }
        帳票制御共通 = manager.load帳票制御共通(帳票分類ID);
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        if (改頁項目リスト.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200023.getReportId().value()).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200023.getReportId().value())
                    .addBreak(new PrtMeisaiIchiranProcessPageBreak(breakKeys)).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = spoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList();
        List<JuminJotai> 住民状態List = new ArrayList();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別List);
        builder.set住民状態(住民状態List);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        KariSanteiIdoFukaPsmParameter parameter
                = KariSanteiIdoFukaPsmParameter.createSelectByKeyParam(出力順, new UaFt200FindShikibetsuTaishoParam(searchKey));
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void process(FukaJohoPsmChoshuRelateEntity entity) {
        DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity = entity.get賦課の情報一時Entity();
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = entity.get宛名PSM();
        ChoshuHoho 徴収方法 = null;
        IKojin 宛名 = null;
        NenkinTokuchoKaifuJoho 年金特徴回付情報 = null;
        if (宛名PSM != null) {
            宛名 = ShikibetsuTaishoFactory.createKojin(宛名PSM);
        }
        if (entity.get徴収方法Entity() != null) {
            徴収方法 = new ChoshuHoho(entity.get徴収方法Entity());
        }
        if (entity.get年金特徴回付情報() != null) {
            年金特徴回付情報 = new NenkinTokuchoKaifuJoho(entity.get年金特徴回付情報());
        }
        HokenryoDankai 保険料段階 = null;
        if (!RString.isNullOrEmpty(賦課の情報一時Entity.getHokenryoDankaiKarisanntei())) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
            保険料段階 = 保険料段階List.getBy段階Index(賦課の情報一時Entity.getHokenryoDankaiKarisanntei());
        }
        TokubetsuChoshuIraikingakuMeisaiIchiranReport report = new TokubetsuChoshuIraikingakuMeisaiIchiranReport(賦課の情報一時Entity,
                宛名, 年金特徴回付情報, 徴収方法, 出力項目リスト,
                改頁項目リスト, processParameter.get賦課年度(), processParameter.get調定日時(), 地方公共団体,
                保険料段階, 帳票制御共通, false);
        report.writeBy(reportSourceWriter);
        eucCsvWriter.writeLine(set特別徴収依頼金額明細(賦課の情報一時Entity, 宛名PSM, 徴収方法, 年金特徴回付情報));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        spoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        List<RString> 出力条件リスト = new ArrayList<>();
        if (processParameter.get出力帳票Entity() != null
                && !RString.isNullOrEmpty(processParameter.get出力帳票Entity().get出力順ID())) {
            出力条件リスト = get出力条件リスト(processParameter.get出力帳票Entity().get出力順ID());
        }
        loadバッチ出力条件リスト(出力条件リスト, new RString(reportSourceWriter.pageCount().value()));
    }

    private List<RString> get出力条件リスト(RString 出力順Id) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder rstbuilder = new RStringBuilder();
        rstbuilder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順Id.toString()));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    rstbuilder.append(iSetSortItem.get項目名());
                } else {
                    rstbuilder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        出力条件リスト.add(rstbuilder.toRString());
        return 出力条件リスト;
    }

    /**
     * バッチ出力条件リストの出力
     *
     * @param 出力条件リスト List<RString>
     * @param 出力ページ数 RString
     */
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト, RString 出力ページ数) {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200023.getReportId().getColumnValue(),
                導入団体コード,
                市町村名,
                RString.EMPTY.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200023.getReportName(),
                出力ページ数,
                CSV出力有無_有り,
                EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private TokuchoKinMeisaiCSVEntity set特別徴収依頼金額明細(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity,
            UaFt200FindShikibetsuTaishoEntity 宛名PSM, ChoshuHoho 徴収方法,
            NenkinTokuchoKaifuJoho 年金特徴回付情報) {
        TokuchoKinMeisaiCSVEntity csvEntity = new TokuchoKinMeisaiCSVEntity();

        if (!RString.isNullOrEmpty(賦課の情報一時Entity.getHokenryoDankaiKarisanntei())) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
            HokenryoDankai 保険料段階 = 保険料段階List.getBy段階Index(賦課の情報一時Entity.getHokenryoDankaiKarisanntei());
            RString 保険料段階表記 = 保険料段階.get表記();
            Decimal 基準年度保険料率 = 保険料段階.get保険料率();
            csvEntity.set保険料段階(保険料段階表記);
            csvEntity.set基準年度保険料率(new RString(基準年度保険料率.toString()));
        }
        csvEntity.set作成年月日(processParameter.get調定日時().getDate().seireki().separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString());
        csvEntity.set作成時刻(processParameter.get調定日時().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        csvEntity.set賦課年度(賦課の情報一時Entity.getFukaNendo().seireki().toDateString());
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().value());
        csvEntity.set保険者名(地方公共団体.get市町村名());
        csvEntity.set通知書番号(getColumnValue(賦課の情報一時Entity.getTsuchishoNo()));
        csvEntity.set被保険者番号(getColumnValue(賦課の情報一時Entity.getHihokenshaNo()));
        csvEntity.set識別コード(getColumnValue(賦課の情報一時Entity.getShikibetsuCode()));
        csvEntity.set世帯コード(getColumnValue(賦課の情報一時Entity.getSetaiCode()));
        if (宛名PSM != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(宛名PSM);
            RString 住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名, 地方公共団体);
            csvEntity.set住所(住所編集);
            csvEntity.set被保険者氏名(getColumnValue(宛名.get名称().getName()));
            csvEntity.set住所コード(getColumnValue(宛名.get住所().get町域コード()));
            csvEntity.set行政区コード(getColumnValue(宛名.get行政区画().getGyoseiku().getコード()));
            csvEntity.set町域管内_管外住所(getColumnValue(宛名.get住所().get全国住所コード()));
            csvEntity.set番地(getColumnValue(宛名PSM.getBanchi()));
        }
        if (徴収方法 != null) {
            csvEntity.set基礎年金番号(徴収方法.get仮徴収_基礎年金番号());
            csvEntity.set年金コード(徴収方法.get仮徴収_年金コード());
            if (!RString.isNullOrEmpty(徴収方法.get仮徴収_年金コード())) {
                csvEntity.set特別徴収対象年金(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(), new Code(徴収方法.get仮徴収_年金コード())));
            }
        }
        if (年金特徴回付情報 != null) {
            csvEntity.set特別徴収業務者コード(getColumnValue(年金特徴回付情報.getDT特別徴収義務者コード()));
            if (年金特徴回付情報.getDT特別徴収義務者コード() != null) {
                csvEntity.set特別徴収業務者(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(), 年金特徴回付情報.getDT特別徴収義務者コード()));
            }
        }
        csvEntity.set特徴開始月(特徴開始月);
        csvEntity.set依頼金額(doカンマ編集(賦課の情報一時Entity.getTkKibetsuGaku03()));
        csvEntity.set備考(RString.EMPTY);
        return csvEntity;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal number) {

        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private void get出力順(RString 出力順Id) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順Id.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        出力順 = MyBatisOrderByClauseCreator.create(TokubetsuChoshuIraikingakuMeisaiIchiranProperty.BreakerFieldsEnum.class,
                outputOrder);
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                    breakKeys.add(setSortItem.get項目ID());
                }
            }
            i = i + INT_1;
        }
    }
}
