/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.DBB200023MeisaiIchiranEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.PrtMeisaiIchiranMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.PrtMeisaiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoKinMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokubetsuChoshuIraikingakuMeisaiIchiranDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.jusho.KannaiKangaiKubunType;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 「特別徴収依頼金額明細一覧表出力」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 xuzhao
 */
public class PrtMeisaiIchiranProcess extends BatchKeyBreakBase<TokubetsuChoshuIraikingakuMeisaiIchiranDataEntity> {

    private static final RString SELECT_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper"
            + ".relate.gennendohonsanteiidou.IGenNendoHonsanteiIdouMapper.get特別徴収依頼金額明細情報");
    private static final ReportId 帳票ID = ReportIdDBB.DBB200023.getReportId();
    private static final RString RSTRING_04 = new RString("04");
    private static final RString 特徴開始月 = new RString("「4月」");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200023");
    private static final RString EUCファイル名 = new RString("TokubetsuChoshuIraikingakuMeisaiIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final int INT_1 = 1;
    private static final int INT_5 = 5;
    private PrtMeisaiIchiranProcessParameter parameter;
    private IOutputOrder outputOrder;
    private KariSanteiIdoFukaBatch manager;
    private FileSpoolManager spoolManager;
    private RString eucFilePath;
    private RString 出力順;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private Association 地方公共団体;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<TokuchoKinMeisaiCSVEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();

        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        manager = KariSanteiIdoFukaBatch.createInstance();
        if (parameter.get出力帳票一覧() != null
                && !RString.isNullOrEmpty(parameter.get出力帳票一覧().get出力順ID())) {
            RString 出力順ID = parameter.get出力帳票一覧().get出力順ID();
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票ID, Long.valueOf(出力順ID.toString()));
            get出力順();
        }
        帳票制御共通 = manager.load帳票制御共通(帳票ID);
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        RString 通知内容コード = TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード();
        RString 特別徴収_特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        boolean is6月捕捉が04 = 特別徴収_特徴開始月_6月捕捉.equals(RSTRING_04);
        PrtMeisaiIchiranMyBatisParameter myBatisParameter = new PrtMeisaiIchiranMyBatisParameter(通知内容コード,
                is6月捕捉が04, 出力順);
        return new BatchDbReader(SELECT_DATA_ID, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        if (改頁項目リスト.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200023.getReportId().value()).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200023.getReportId().value())
                    .addBreak(new PrtMeisaiIchiranProcessPageBreak(改頁項目リスト)).create();
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
    protected void keyBreakProcess(TokubetsuChoshuIraikingakuMeisaiIchiranDataEntity t) {
    }

    @Override
    protected void usualProcess(TokubetsuChoshuIraikingakuMeisaiIchiranDataEntity entity) {
        DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity = entity.get賦課の情報一時テーブル();
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = entity.get宛名PSMの戻り値();
        ChoshuHoho 徴収方法 = null;
        IKojin 宛名 = null;
        NenkinTokuchoKaifuJoho 年金特徴回付情報 = null;
        if (宛名PSM != null) {
            宛名 = ShikibetsuTaishoFactory.createKojin(宛名PSM);
        }
        if (entity.get徴収方法Newest() != null) {
            徴収方法 = new ChoshuHoho(entity.get徴収方法Newest());
        }
        if (entity.get年金特徴回付情報() != null) {
            年金特徴回付情報 = new NenkinTokuchoKaifuJoho(entity.get年金特徴回付情報());
        }
        HokenryoDankai 保険料段階 = null;
        if (!RString.isNullOrEmpty(賦課の情報一時Entity.getHokenryoDankaiKarisanntei())) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
            保険料段階 = 保険料段階List.getBy段階区分(賦課の情報一時Entity.getHokenryoDankaiKarisanntei());

        }
        TokubetsuChoshuIraikingakuMeisaiIchiranReport report = new TokubetsuChoshuIraikingakuMeisaiIchiranReport(賦課の情報一時Entity,
                宛名, 年金特徴回付情報, 徴収方法, 出力項目リスト,
                改頁項目リスト, 賦課の情報一時Entity.getFukaNendo(), parameter.get調定日時(), 地方公共団体,
                保険料段階, 帳票制御共通, true);
        report.writeBy(reportSourceWriter);
        eucCsvWriter.writeLine(set特別徴収依頼金額明細(賦課の情報一時Entity, 宛名PSM, 徴収方法, 年金特徴回付情報));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        spoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        List<RString> 出力条件リスト = new ArrayList<>();
        if (parameter.get出力帳票一覧() != null
                && !RString.isNullOrEmpty(parameter.get出力帳票一覧().get出力順ID())) {
            出力条件リスト = get出力条件リスト(parameter.get出力帳票一覧().get出力順ID());
        }
        loadバッチ出力条件リスト(出力条件リスト, new RString(reportSourceWriter.pageCount().value()));
    }

    private List<RString> get出力条件リスト(RString 出力順Id) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder rstbuilder = new RStringBuilder();
        rstbuilder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
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

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, RString 出力ページ数) {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
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
            HokenryoDankai 保険料段階 = 保険料段階List.getBy段階区分(賦課の情報一時Entity.getHokenryoDankaiKarisanntei());
            RString 保険料段階表記 = 保険料段階.get表記();
            Decimal 基準年度保険料率 = 保険料段階.get保険料率();
            csvEntity.set保険料段階(保険料段階表記);
            csvEntity.set基準年度保険料率(new RString(基準年度保険料率.toString()));
        }
        csvEntity.set作成年月日(parameter.get調定日時().getDate().seireki().separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString());
        csvEntity.set作成時刻(parameter.get調定日時().getTime()
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
            if (宛名.get住所().get管内管外() == KannaiKangaiKubunType.管内) {
                csvEntity.set町域管内_管外住所(getColumnValue(宛名.get住所().get町域コード()));
            } else if (宛名.get住所().get管内管外() == KannaiKangaiKubunType.管外) {
                csvEntity.set町域管内_管外住所(getColumnValue(宛名.get住所().get全国住所コード()));
            }

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
                        UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                        年金特徴回付情報.getDT特別徴収義務者コード()));
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

    private void get出力順() {
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        出力順 = MyBatisOrderByClauseCreator.create(DBB200023MeisaiIchiranEnum.class,
                outputOrder);
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                }
            }
            i = i + INT_1;
        }
    }
}
