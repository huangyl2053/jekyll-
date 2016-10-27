/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200096.KyufuJissekiTorikeshiIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseiTaishoKyufuJissekiIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseitaishoKyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyufuJissekiTorikeshiIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200096.KyufuJissekiTorikeshiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.config.KaigoToiawasesakiConfig;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(更正対象給付実績一覧表出力)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcess extends BatchKeyBreakBase<KoseitaishoKyuhuzissekiJohoTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get更正対象給付実績情報");
    private KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter processParameter;
    private LasdecCode 保険者番号;
    private RString 保険者番名;
    private int 連番;
    private int csv連番;
    private int 給付実績取消一覧CSV連番;
    private static final RString 給付実績情報作成区分_削除 = new RString("3");
    private List<RString> 改頁List;
    private static final RString キー_年度 = new RString("年度");
    private static final RString キー_被保険者番号 = new RString("被保険者番号");
    private static final RString キー_サービス提供年月 = new RString("サービス提供年月");
    private boolean 開始flag;
    private boolean 合計出力flag;
    private boolean データ存在flag;
    private KoseiTaishoJissekiIchiranEntity 給付実績一覧表合計Entity;
    private KoseiTaishoKyufuJissekiIchiranCsvEntity 合計CSVEntity;
    private static final RString 記号 = new RString("※");
    private static final RString データ区分_明細 = new RString("M");
    private static final RString データ区分_合計 = new RString("G");
    private static List<PersonalData> hojinShikibetsuCodeList;
    /**
     * プロセス戻り値：対象月データありなしフラグ
     */
    public static final RString OUT_HAS_TARGET_DATA;

    private OutputParameter<Boolean> 変換_FLAG;
    private boolean 変換flag;

    static {
        OUT_HAS_TARGET_DATA = new RString("変換_FLAG");
    }

    @BatchWriter
    private BatchReportWriter<KoseiTaishoJissekiIchiranSource> 給付実績一覧表ReportWriter;
    private ReportSourceWriter<KoseiTaishoJissekiIchiranSource> 給付実績一覧表SourceWriter;

    @BatchWriter
    private BatchReportWriter<KyufuJissekiTorikeshiIchiranSource> 給付実績取消一覧表ReportWriter;
    private ReportSourceWriter<KyufuJissekiTorikeshiIchiranSource> 給付実績取消一覧表SourceWriter;

    @BatchWriter
    private CsvWriter<KoseiTaishoKyufuJissekiIchiranCsvEntity> 給付実績一覧表csvWriter;

    @BatchWriter
    private CsvWriter<KyufuJissekiTorikeshiIchiranCsvEntity> 給付実績取消一覧表csvWriter;

    private static final EucEntityId 給付実績一覧表EUC_ENTITY_ID = new EucEntityId(new RString("DBC200096"));
    private static final EucEntityId 給付実績取消一覧_EUCENTITYID = new EucEntityId(new RString("DBC200097"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString 給付実績一覧表eucFilePath;
    private RString 給付実績取消一覧eucFilePath;
    private FileSpoolManager manager;
    private FileSpoolManager 給付実績取消一覧manager;
    private static final RString 給付実績一覧表CSVファイル名 = new RString("KoseiTaishoKyufuJissekiIchiran.csv");
    private static final RString 給付実績取消一覧CSVファイル名 = new RString("KyufuJissekiTorikeshiIchiran.csv");
    private static final RString 文言_対象データがありません = new RString("対象データがありません。");
    private static final RString 文字コード_1 = new RString("1");
    private static final RString 文字コード_2 = new RString("2");
    private static final RString 文字コード_3 = new RString("3");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString 開始 = new RString("【開始】　");
    private static final RString 終了 = new RString("【終了】　");
    private static final RString 出力順_コード_1 = new RString("1");
    private static final RString 出力順_コード_2 = new RString("2");
    private static final RString 出力順_1 = new RString("年度＞被保険者番号");
    private static final RString 出力順_2 = new RString("被保険者番号＞年度");
    private RString 共通_文字コード;
    private Association 導入団体クラス;

    @Override
    protected void initialize() {
        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        保険者番号 = 導入団体クラス.get地方公共団体コード();
        保険者番名 = 導入団体クラス.get市町村名();
        連番 = 0;
        csv連番 = 0;
        給付実績取消一覧CSV連番 = 0;
        改頁List = new ArrayList<>();
        get改頁List();
        開始flag = true;
        合計出力flag = false;
        データ存在flag = false;
        給付実績一覧表合計Entity = new KoseiTaishoJissekiIchiranEntity();
        合計CSVEntity = new KoseiTaishoKyufuJissekiIchiranCsvEntity();
        hojinShikibetsuCodeList = new ArrayList<>();
        KaigoToiawasesakiConfig config = new KaigoToiawasesakiConfig();
        共通_文字コード = config.getEUC共通_文字コード();
        変換flag = false;
        変換_FLAG = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        PageBreaker<KoseiTaishoJissekiIchiranSource> breaker
                = new KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessPageBreak(改頁List);
        給付実績一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200096.getReportId().value()).addBreak(breaker).create();
        給付実績一覧表SourceWriter = new ReportSourceWriter<>(給付実績一覧表ReportWriter);

        給付実績取消一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200097.getReportId().value()).create();
        給付実績取消一覧表SourceWriter = new ReportSourceWriter<>(給付実績取消一覧表ReportWriter);

        //TODO 文字コード変換の方法は分かりません。
        Encode 文字コード = Encode.UTF_8withBOM;
        if (文字コード_1.equals(共通_文字コード)) {
            文字コード = Encode.UTF_8withBOM;
        } else if (文字コード_2.equals(共通_文字コード)) {
            文字コード = Encode.SJIS;
        } else if (文字コード_3.equals(共通_文字コード)) {
            文字コード = Encode.UTF_8withBOM;
            変換flag = true;
        }

        変換_FLAG.setValue(変換flag);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, 給付実績一覧表EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        this.給付実績一覧表eucFilePath = Path.combinePath(spoolWorkPath, 給付実績一覧表CSVファイル名);
        給付実績一覧表csvWriter = new CsvWriter.InstanceBuilder(this.給付実績一覧表eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(文字コード).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        給付実績取消一覧manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, 給付実績取消一覧_EUCENTITYID,
                UzUDE0831EucAccesslogFileType.Csv);
        RString 給付実績取消一覧spoolWorkPath = 給付実績取消一覧manager.getEucOutputDirectry();
        this.給付実績取消一覧eucFilePath = Path.combinePath(給付実績取消一覧spoolWorkPath, 給付実績取消一覧CSVファイル名);
        給付実績取消一覧表csvWriter = new CsvWriter.InstanceBuilder(this.給付実績取消一覧eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(文字コード).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(KoseitaishoKyuhuzissekiJohoTempEntity entity) {

    }

    @Override
    protected void usualProcess(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        データ存在flag = true;
        if (!給付実績情報作成区分_削除.equals(entity.get給付実績情報作成区分コード())) {
            get合計Entity(entity);
            get合計CSVEntity(entity);
            合計出力(entity);
            連番++;
            KoseiTaishoJissekiIchiranReport report = new KoseiTaishoJissekiIchiranReport(get明細Entity(entity),
                    processParameter.get抽出期間開始日時(), processParameter.get抽出期間終了日時(), processParameter.get出力順(), 連番);
            report.writeBy(給付実績一覧表SourceWriter);
            給付実績一覧表csvWriter.writeLine(get明細CSVEntity(entity));
        } else {
            連番++;
            KyufuJissekiTorikeshiIchiranReport report = new KyufuJissekiTorikeshiIchiranReport(entity, processParameter.get抽出期間開始日時(),
                    processParameter.get抽出期間終了日時(), processParameter.get出力順(),
                    AssociationFinderFactory.createInstance().getAssociation(), 連番);
            report.writeBy(給付実績取消一覧表SourceWriter);
            給付実績取消一覧表csvWriter.writeLine(get給付実績取消一覧表CSVEntity(entity));
        }
        if (entity.get識別コード() != null) {
            PersonalData data = PersonalData.of(entity.get識別コード());
            hojinShikibetsuCodeList.add(data);
        }
    }

    @Override
    protected void afterExecute() {
        if (!データ存在flag) {
            KoseiTaishoJissekiIchiranEntity 給付実績一覧entity = new KoseiTaishoJissekiIchiranEntity();
            給付実績一覧entity.set氏名(文言_対象データがありません);
            KoseiTaishoJissekiIchiranReport 給付実績一覧report = new KoseiTaishoJissekiIchiranReport(給付実績一覧entity,
                    processParameter.get抽出期間開始日時(), processParameter.get抽出期間終了日時(), RString.EMPTY, 0);
            給付実績一覧report.writeBy(給付実績一覧表SourceWriter);
            KoseitaishoKyuhuzissekiJohoTempEntity tempentity = new KoseitaishoKyuhuzissekiJohoTempEntity();
            tempentity.set氏名(文言_対象データがありません);
            KyufuJissekiTorikeshiIchiranReport report = new KyufuJissekiTorikeshiIchiranReport(tempentity, processParameter.get抽出期間開始日時(),
                    processParameter.get抽出期間終了日時(), RString.EMPTY, null, 0);
            report.writeBy(給付実績取消一覧表SourceWriter);
        }

        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();

        ReportOutputJokenhyoItem 給付実績一覧表item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC200096.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC200096.getReportName(),
                new RString(String.valueOf(給付実績一覧表SourceWriter.pageCount().value())),
                CSV出力有無_有り,
                給付実績一覧表CSVファイル名,
                get出力条件());
        OutputJokenhyoFactory.createInstance(給付実績一覧表item).print();

        ReportOutputJokenhyoItem 給付実績取消一覧表item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC200097.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC200097.getReportName(),
                new RString(String.valueOf(給付実績取消一覧表SourceWriter.pageCount().value())),
                CSV出力有無_有り,
                給付実績取消一覧CSVファイル名,
                get出力条件());
        OutputJokenhyoFactory.createInstance(給付実績取消一覧表item).print();

        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, hojinShikibetsuCodeList);
        給付実績一覧表csvWriter.close();
        給付実績取消一覧表csvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, 給付実績一覧表eucFilePath);
        給付実績取消一覧manager.spool(SubGyomuCode.DBC介護給付, 給付実績取消一覧eucFilePath);
        processParameter.set給付実績ファイルパス(給付実績一覧表eucFilePath);
        processParameter.set給付実績取消ファイルパス(給付実績取消一覧eucFilePath);
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件List = new ArrayList<>();
        出力条件List.add(開始.concat(get和暦日時(processParameter.get抽出期間開始日時())));
        出力条件List.add(終了.concat(get和暦日時(processParameter.get抽出期間終了日時())));
        if (出力順_コード_1.equals(processParameter.get出力順())) {
            出力条件List.add(出力順_1);
        } else if (出力順_コード_2.equals(processParameter.get出力順())) {
            出力条件List.add(出力順_2);
        }
        return 出力条件List;
    }

    private void 合計出力(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        if (!開始flag) {
            if ((!getBefore().get年度().equals(entity.get年度())
                    || !getBefore().get被保険者番号().equals(entity.get被保険者番号())
                    || !getBefore().getサービス提供年月().equals(entity.getサービス提供年月())) && 合計出力flag) {
                連番++;
                KoseiTaishoJissekiIchiranReport 合計Report
                        = new KoseiTaishoJissekiIchiranReport(給付実績一覧表合計Entity,
                                processParameter.get抽出期間開始日時(),
                                processParameter.get抽出期間終了日時(),
                                processParameter.get出力順(), 連番);
                合計Report.writeBy(給付実績一覧表SourceWriter);
                給付実績一覧表csvWriter.writeLine(合計CSVEntity);
                合計CSVEntity = new KoseiTaishoKyufuJissekiIchiranCsvEntity();
                給付実績一覧表合計Entity = new KoseiTaishoJissekiIchiranEntity();
                合計出力flag = false;
                開始flag = true;
            }
        } else {
            開始flag = false;
        }
    }

    private KoseiTaishoJissekiIchiranEntity get明細Entity(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        KoseiTaishoJissekiIchiranEntity 更正対象給付実績一覧表のEntity = new KoseiTaishoJissekiIchiranEntity();
        更正対象給付実績一覧表のEntity.set地方公共団体コード(保険者番号);
        更正対象給付実績一覧表のEntity.set被保険者番号(entity.get被保険者番号());
        更正対象給付実績一覧表のEntity.set年度(entity.get年度());
        更正対象給付実績一覧表のEntity.setサービス提供年月(entity.getサービス提供年月());
        更正対象給付実績一覧表のEntity.set市町村名(保険者番名);
        更正対象給付実績一覧表のEntity.set氏名(entity.get氏名());
        if (entity.get入力識別番号() != null) {
            更正対象給付実績一覧表のEntity.set入力識別番号(entity.get入力識別番号().value());
        }
        更正対象給付実績一覧表のEntity.set事業者番号(entity.get事業所番号());
        更正対象給付実績一覧表のEntity.set整理番号(entity.get整理番号());
        更正対象給付実績一覧表のEntity.setサービス種類(entity.getサービス種類());
        更正対象給付実績一覧表のEntity.set軽減率(entity.get軽減率());
        更正対象給付実績一覧表のEntity.set高額サービス費用額(entity.get高額サービス費用額());
        if (entity.get更正前保険給付率() != null) {
            更正対象給付実績一覧表のEntity.set更正前給付率(entity.get更正前保険給付率().value());
        }
        更正対象給付実績一覧表のEntity.setサービス費用額(entity.getサービス費用額());
        更正対象給付実績一覧表のEntity.set更正前請求額(entity.get更正前請求額());
        更正対象給付実績一覧表のEntity.set更正前自己負担額(entity.get更正前自己負担額());
        更正対象給付実績一覧表のEntity.set更正後請求額(entity.get更正後請求額());
        更正対象給付実績一覧表のEntity.set更正後自己負担額(entity.get更正後自己負担額());
        更正対象給付実績一覧表のEntity.set自己負担差額(entity.get自己負担額差額());
        return 更正対象給付実績一覧表のEntity;
    }

    private void get合計Entity(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        if (開始flag) {
            給付実績一覧表合計Entity.set地方公共団体コード(保険者番号);
            給付実績一覧表合計Entity.set被保険者番号(entity.get被保険者番号());
            給付実績一覧表合計Entity.set年度(entity.get年度());
            給付実績一覧表合計Entity.setサービス提供年月(entity.getサービス提供年月());
            給付実績一覧表合計Entity.set市町村名(保険者番名);
            給付実績一覧表合計Entity.set氏名(entity.get氏名());
            if (entity.get入力識別番号() != null) {
                給付実績一覧表合計Entity.set入力識別番号(entity.get入力識別番号().value());
            }
            給付実績一覧表合計Entity.set事業者番号(entity.get事業所番号());
            給付実績一覧表合計Entity.set整理番号(entity.get整理番号());
            給付実績一覧表合計Entity.setサービス種類(entity.getサービス種類());
            給付実績一覧表合計Entity.set高額サービス費用額(entity.get高額サービス費用額());
            給付実績一覧表合計Entity.set自己負担差額(entity.get自己負担額差額());
        } else {
            合計出力flag = true;
            給付実績一覧表合計Entity.set高額サービス費用額(給付実績一覧表合計Entity.get高額サービス費用額().add(entity.get高額サービス費用額()));
            給付実績一覧表合計Entity.set自己負担差額(給付実績一覧表合計Entity.get自己負担差額().add(entity.get自己負担額差額()));
        }
    }

    private KoseiTaishoKyufuJissekiIchiranCsvEntity get明細CSVEntity(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        KoseiTaishoKyufuJissekiIchiranCsvEntity csvEntity = new KoseiTaishoKyufuJissekiIchiranCsvEntity();
        csvEntity.setデータ区分(データ区分_明細);
        csvEntity.set連番(new RString(csv連番++));
        csvEntity.set被保険者氏名(entity.get氏名());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set年度(entity.get年度());
        if (entity.getサービス提供年月() != null) {
            csvEntity.setサービス提供年月(entity.getサービス提供年月().seireki().
                    separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get入力識別番号() != null) {
            csvEntity.set入力識別番号(entity.get入力識別番号().value());
        }
        csvEntity.set事業者番号(entity.get事業所番号());
        csvEntity.set整理番号(entity.get整理番号());
        csvEntity.setサービス種類(entity.getサービス種類());
        csvEntity.setサービス種類コード(entity.getサービス種類コード());
        csvEntity.setサービス費用額(entity.getサービス費用額());
        if (entity.get軽減率() != null) {
            csvEntity.set社福(記号);
        }
        if (entity.get更正前保険給付率() != null) {
            csvEntity.set更正前給付率(new RString(entity.get更正前保険給付率().value().toString()));
        }
        csvEntity.set更正前請求額(entity.get更正前請求額());
        csvEntity.set更正前自己負担額(entity.get更正前自己負担額());
        if (entity.get更正後保険給付率() != null) {
            csvEntity.set更正後給付率(entity.get更正後保険給付率().value());
        }
        csvEntity.set更正後請求額(entity.get更正後請求額());
        csvEntity.set更正後自己負担額(entity.get更正後自己負担額());
        csvEntity.set自己負担額差額(entity.get自己負担額差額());
        return csvEntity;
    }

    private void get合計CSVEntity(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        if (開始flag) {
            合計CSVEntity.setデータ区分(データ区分_合計);
            合計CSVEntity.set被保険者氏名(entity.get氏名());
            合計CSVEntity.set被保険者番号(entity.get被保険者番号());
            合計CSVEntity.set年度(entity.get年度());
            合計CSVEntity.setサービス提供年月(entity.getサービス提供年月().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
            if (entity.get入力識別番号() != null) {
                合計CSVEntity.set入力識別番号(entity.get入力識別番号().value());
            }

            if (entity.get高額サービス費用額() != null) {
                合計CSVEntity.set高額(記号);
            }
            合計CSVEntity.set自己負担額差額(entity.get自己負担額差額());
            合計CSVEntity.set高額サービス費用額(entity.get高額サービス費用額());
        } else {
            合計CSVEntity.set自己負担額差額(合計CSVEntity.get自己負担額差額().add(entity.get自己負担額差額()));
            合計CSVEntity.set高額サービス費用額(合計CSVEntity.get高額サービス費用額().add(entity.get高額サービス費用額()));
        }
    }

    private KyufuJissekiTorikeshiIchiranCsvEntity get給付実績取消一覧表CSVEntity(KoseitaishoKyuhuzissekiJohoTempEntity entity) {
        KyufuJissekiTorikeshiIchiranCsvEntity csvEntity = new KyufuJissekiTorikeshiIchiranCsvEntity();
        csvEntity.set連番(new RString(給付実績取消一覧CSV連番++));
        csvEntity.set被保険者氏名(entity.get氏名());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set年度(entity.get年度());
        if (entity.getサービス提供年月() != null) {
            csvEntity.setサービス提供年月(entity.getサービス提供年月().seireki().
                    separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get入力識別番号() != null) {
            csvEntity.set入力識別番号(entity.get入力識別番号().value());
        }
        csvEntity.set事業者番号(entity.get事業所番号());
        csvEntity.set整理番号(entity.get整理番号());
        csvEntity.setサービス種類(entity.getサービス種類());
        csvEntity.setサービス種類コード(entity.getサービス種類コード());
        csvEntity.setサービス費用額(entity.getサービス費用額());
        if (entity.get軽減率() != null) {
            csvEntity.set社福(記号);
        }
        if (entity.get更正前保険給付率() != null) {
            csvEntity.set更正前給付率(new RString(entity.get更正前保険給付率().value().toString()));
        }
        csvEntity.set更正前請求額(entity.get更正前請求額());
        csvEntity.set更正前自己負担額(entity.get更正前自己負担額());
        return csvEntity;
    }

    private void get改頁List() {
        改頁List.add(キー_年度);
        改頁List.add(キー_被保険者番号);
        改頁List.add(キー_サービス提供年月);
    }

    private RString get和暦日時(RDateTime 日時) {
        if (null != 日時) {
            RString 和暦日 = 日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 和暦時 = 日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            return 和暦日.concat(RString.HALF_SPACE).concat(和暦時);
        }
        return RString.EMPTY;
    }
}
