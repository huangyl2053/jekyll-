/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran.ShinsaHoshuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsahoshuichiran.ShinsaHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.IShinsaHoshuIchiranEntityCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護認定審査会委員報酬一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public class ShinsaHoshuIchiranProcess extends BatchProcessBase<ShinsaHoshuIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID_GOKE = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper.get合計額");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE604001"));
    private static final RString CSV_FILE_NAME = new RString("介護認定審査会委員報酬一覧表.csv");
    private static final RString なし = new RString("なし");
    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");
    private ShinsaHoshuIchiranChange 審査報酬一覧EntityConvertor;
    private ShinsaHoshuIchiranProcessParameter paramter;
    private List<ShinsaHoshuIchiranRelateEntity> 出席状況EntityList;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
    private int 出席回数;
    private static final RString 長 = new RString("長");
    private static final RString 出 = new RString("出");
    private static final RString 副 = new RString("副");
    private static final RString 月 = new RString("月");
    private static final int ZERO = 0;
    private static final long ONE = 1;
    private static final int FOUR = 4;
    private boolean is初回目 = true;
    private int 総合計_審査回数;
    private Decimal 総合計_報酬総額;
    private Decimal 総合計_その他費用;
    private Decimal 総合計_税控除額;
    private Decimal 総合計_報酬合計;

    @BatchWriter
    private CsvWriter<IShinsaHoshuIchiranEntityCsvEucEntity> csvWriter;
    @BatchWriter
    private BatchReportWriter<ShinsaHoshuIchiranReportSource> batchWriter;
    private ReportSourceWriter<ShinsaHoshuIchiranReportSource> reportWriter;


    @Override
    protected void initialize() {
        総合計_審査回数 = 0;
        総合計_報酬総額 = Decimal.ZERO;
        総合計_その他費用 = Decimal.ZERO;
        総合計_税控除額 = Decimal.ZERO;
        総合計_報酬合計 = Decimal.ZERO;
        審査報酬一覧EntityConvertor = new ShinsaHoshuIchiranChange();
    }
    
    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        IShinsaHoshuIchiranMapper mapper = getMapper(IShinsaHoshuIchiranMapper.class);
        出席状況EntityList = mapper.get出席状況(paramter.get審査会開催年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_GOKE, paramter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_FILE_NAME);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .build();
        
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE601005.getReportId().value()).create();
        reportWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShinsaHoshuIchiranRelateEntity 合計額Entity) {
        for (ShinsaHoshuIchiranRelateEntity 出席状況Entity : 出席状況EntityList) {
            if ((合計額Entity.get合議体番号() == 出席状況Entity.get合議体番号())
                    && 合計額Entity.get介護認定審査会委員コード().equals(出席状況Entity.get介護認定審査会委員コード())) {
                出席状況Entity.set審査会開催年月(get出席日(paramter.get審査会開催年月(), paramter.get帳票出力区分()));
                出席状況Entity.set報酬総額(合計額Entity.get報酬総額());
                出席状況Entity.setその他費用(合計額Entity.getその他費用());
                出席状況Entity.set税額控除(合計額Entity.get税額控除());
                出席状況Entity.set報酬合計(合計額Entity.get報酬合計());
                出席状況Entity.set総合計_報酬総額(合計額Entity.get総合計_報酬総額());
                出席状況Entity.set総合計_その他費用(合計額Entity.get総合計_その他費用());
                出席状況Entity.set総合計_税控除額(合計額Entity.get総合計_税控除額());
                出席状況Entity.set総合計_報酬合計(合計額Entity.get総合計_報酬合計());

                出席回数 = 0;
                this.count出席回数(出席状況Entity.get出席状況_1日());
                this.count出席回数(出席状況Entity.get出席状況_2日());
                this.count出席回数(出席状況Entity.get出席状況_3日());
                this.count出席回数(出席状況Entity.get出席状況_4日());
                this.count出席回数(出席状況Entity.get出席状況_5日());
                this.count出席回数(出席状況Entity.get出席状況_6日());
                this.count出席回数(出席状況Entity.get出席状況_7日());
                this.count出席回数(出席状況Entity.get出席状況_8日());
                this.count出席回数(出席状況Entity.get出席状況_9日());
                this.count出席回数(出席状況Entity.get出席状況_10日());
                this.count出席回数(出席状況Entity.get出席状況_11日());
                this.count出席回数(出席状況Entity.get出席状況_12日());
                this.count出席回数(出席状況Entity.get出席状況_13日());
                this.count出席回数(出席状況Entity.get出席状況_14日());
                this.count出席回数(出席状況Entity.get出席状況_15日());
                this.count出席回数(出席状況Entity.get出席状況_16日());
                this.count出席回数(出席状況Entity.get出席状況_17日());
                this.count出席回数(出席状況Entity.get出席状況_18日());
                this.count出席回数(出席状況Entity.get出席状況_19日());
                this.count出席回数(出席状況Entity.get出席状況_20日());
                this.count出席回数(出席状況Entity.get出席状況_21日());
                this.count出席回数(出席状況Entity.get出席状況_22日());
                this.count出席回数(出席状況Entity.get出席状況_23日());
                this.count出席回数(出席状況Entity.get出席状況_24日());
                this.count出席回数(出席状況Entity.get出席状況_25日());
                this.count出席回数(出席状況Entity.get出席状況_26日());
                this.count出席回数(出席状況Entity.get出席状況_27日());
                this.count出席回数(出席状況Entity.get出席状況_28日());
                this.count出席回数(出席状況Entity.get出席状況_29日());
                this.count出席回数(出席状況Entity.get出席状況_30日());
                this.count出席回数(出席状況Entity.get出席状況_31日());
                出席状況Entity.set出席回数(出席回数);                    
                総合計_審査回数 += 出席回数;

                if (is初回目) {
                    総合計_報酬総額 = 合計額Entity.get総合計_報酬総額();
                    総合計_その他費用 = 合計額Entity.getその他費用();
                    総合計_税控除額 = 合計額Entity.get税額控除();
                    総合計_報酬合計 = 合計額Entity.get総合計_報酬合計();
                    is初回目 = false;
                }

                ShinsaHoshuIchiranEntity 審査報酬一覧Entity = 
                        審査報酬一覧EntityConvertor.createData(出席状況Entity, paramter.get帳票出力区分());
                if (CSVを出力する.equals(paramter.get帳票出力区分())) {
                    csvWriter.writeLine(審査報酬一覧Entity);
                } else if (一覧表を発行する.equals(paramter.get帳票出力区分())) {
                    ShinsaHoshuIchiranReport report = new ShinsaHoshuIchiranReport(審査報酬一覧Entity);
                    report.writeBy(reportWriter);
                }
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            ShinsaHoshuIchiranEntity 総合計 = new ShinsaHoshuIchiranEntity(
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, new RString(総合計_審査回数),
                    DecimalFormatter.toコンマ区切りRString(総合計_報酬総額, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_その他費用, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_税控除額, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_報酬合計, ZERO));
            csvWriter.writeLine(総合計);
        }
        csvWriter.close();
        fileSpoolManager.spool(eucFilePath);
        
        Association 導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            バッチ出力条件リストの出力(導入団体);
        } else if (一覧表を発行する.equals(paramter.get帳票出力区分())) {
            帳票出力条件リストの出力(導入団体);
        }
    }

    private void バッチ出力条件リストの出力(Association 導入団体) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("【対象年月】");
        審査会開催年月.append(getFormatted年月(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("介護認定審査会委員報酬一覧表CSV"),
                導入団体.getLasdecCode_().value(), 
                導入団体.get市町村名(), 
                new RString(JobContextHolder.getJobId()),
                CSV_FILE_NAME, 
                EUC_ENTITY_ID.toRString(), 
                new RString(csvWriter.getCount() - ONE), 
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void 帳票出力条件リストの出力(Association 導入団体) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("【対象年月】");
        審査会開催年月.append(getFormatted年月(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE601005.getReportId().value(),
                導入団体.getLasdecCode_().value(), 
                導入団体.get市町村名(), 
                new RString(JobContextHolder.getJobId()),
                ReportIdDBE.DBE601005.getReportName(), 
                new RString(reportWriter.pageCount().value()), 
                なし, 
                なし, 
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private void count出席回数(RString 出席状況) {
        if (ShinsaHoshuIchiranProcess.長.equals(出席状況) 
                || ShinsaHoshuIchiranProcess.副.equals(出席状況) 
                || ShinsaHoshuIchiranProcess.出.equals(出席状況)) {
            出席回数++;
        }
    }

    private static RString getFormatted年月(RString 年月RString) {
        if (RString.isNullOrEmpty(年月RString)) {
            return RString.EMPTY;
        }
        return (new RYearMonth(年月RString)).wareki().toDateString();
    }

    private static RString get出席日(RString 年月RString, RString 帳票出力区分) {
        if (RString.isNullOrEmpty(年月RString)) {
            return RString.EMPTY;
        }
        
        if (CSVを出力する.equals(帳票出力区分)) {
            return getFormatted年月(年月RString);
        }
        
        if (一覧表を発行する.equals(帳票出力区分)) {
            RStringBuilder 出席日 = new RStringBuilder();
            出席日.append(年月RString.substring(FOUR));
            出席日.append(月);
            return 出席日.toRString();
        }
        
        return RString.EMPTY;
    }
}
