
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110090;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout.KaigokyufuhiKagoMoshitateshoOutOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout.KaigokyufuhiKagoMoshitateshoOutPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout.KaigokyufuhiKagoMoshitateshoOutReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu.SogojigyohiKagoMoshitateshojohoSofuPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu.SogojigyohiKagoMoshitateshojohoSofuReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kaigokyufuhikagomoshitateshoout.KaigokyufuhiKagoMoshitateshoOutCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomoshitateshoout.KyufuKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費過誤申立書作成の帳票出力Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutDoBillOutProcess extends BatchKeyBreakBase<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity> {

    private KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter parameter;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private List<RString> 改頁項目名リスト;
    private Map<RString, RString> 出力順Map;
    private int index = 0;
    private int index_1 = 0;
    private KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity exEtntity;
    private FileSpoolManager kaigoManager;
    private RString kaigoEucFilePath;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString 漢字_件 = new RString("件");
    private static final Code コード = new Code("0003");

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
                    + "IKaigokyufuhiKagoMoshitateshoOutMapper.do帳票出力");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コード_173 = new RString("173");
    private static final RString コード_176 = new RString("176");
    private static final RString コード_179 = new RString("179");

    private static RString 出力ファイル名;
    private static EucEntityId eUC_ENTITY_ID;
    private List<PersonalData> personalDataList;
    private Set<ShikibetsuCode> 識別コードset;
    private CodeShubetsu コード種別_1;
    private CodeShubetsu コード種別_2;

    private int 件数 = 0;
    private int 連番 = 1;

    private BatchReportWriter<KyufuKagoMoshitateshojohoSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<KyufuKagoMoshitateshojohoSofuIchiranSource> reportSourceWriter;
    private CsvWriter<KaigokyufuhiKagoMoshitateshoOutCsvEntity> seikyugakuTsuchishoInCsvWriter;
    private BatchReportWriter<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> sogojigyohiKagoReportWriter;
    private ReportSourceWriter<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> sogojigyohiKagoSourceWriter;
    private BatchReportWriter<SogojigyohiKagoMoshitateshojohoSofuSource> sogojiReportWriter;
    private ReportSourceWriter<SogojigyohiKagoMoshitateshojohoSofuSource> sogojiWriter;

    @Override
    protected void initialize() {
        super.initialize();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        personalDataList = new ArrayList<>();
        識別コードset = new HashSet<>();
        if (コード_173.equals(parameter.getコード())) {
            出力ファイル名 = new RString("DBC200045_KyufuKagoMoshitateshojohoSofuIchiran.csv");
            eUC_ENTITY_ID = new EucEntityId("DBC200045");
            this.コード種別_1 = DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード();
            this.コード種別_2 = DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード();
        } else if (コード_176.equals(parameter.getコード())) {
            出力ファイル名 = new RString("DBC200046_SogojigyohiKagoMoshitateshojohoSofuIchiran.csv");
            eUC_ENTITY_ID = new EucEntityId("DBC200046");
            this.コード種別_1 = DBCCodeShubetsu.総合事業_経過措置_過誤申立事由_様式_.getコード();
            this.コード種別_2 = DBCCodeShubetsu.総合事業_経過措置_過誤申立理由_理由.getコード();
        } else if (コード_179.equals(parameter.getコード())) {
            出力ファイル名 = new RString("DBC200079_SogojigyohiKagoMoshitateshojohoSofuIchiran.csv");
            eUC_ENTITY_ID = new EucEntityId("DBC200079");
            this.コード種別_1 = DBCCodeShubetsu.総合事業過誤申立事由_様式.getコード();
            this.コード種別_2 = DBCCodeShubetsu.総合事業過誤申立事由_理由.getコード();
        }

        改頁項目リスト = new ArrayList<>();
        改頁項目名リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        並び順 = this.get並び順(parameter.get帳票ID(), parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(KaigokyufuhiKagoMoshitateshoOutOutPutOrder.class, 並び順);
        帳票データの取得Parameter.set出力順(出力順);
        int i = 0;
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁項目リスト.add(item.get項目ID());
                改頁項目名リスト.add(item.get項目名());
            }
            if (i == INT_1) {
                出力順Map.put(KEY_並び順の２件目, item.get項目名());
            } else if (i == INT_2) {
                出力順Map.put(KEY_並び順の３件目, item.get項目名());
            } else if (i == INT_3) {
                出力順Map.put(KEY_並び順の４件目, item.get項目名());
            } else if (i == INT_4) {
                出力順Map.put(KEY_並び順の５件目, item.get項目名());
            } else if (i == INT_5) {
                出力順Map.put(KEY_並び順の６件目, item.get項目名());
            }
            i = i + 1;
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        if (コード_173.equals(parameter.getコード())) {
            PageBreaker<KyufuKagoMoshitateshojohoSofuIchiranSource> breaker = new KaigokyufuhiKagoMoshitateshoOutPageBreak(改頁項目リスト);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        } else if (コード_176.equals(parameter.getコード())) {
            PageBreaker<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> breaker176
                    = new SogojigyohiKagoMoshitateshojohoSofuIchiranPageBreak(改頁項目リスト);
            sogojigyohiKagoReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker176).create();
            sogojigyohiKagoSourceWriter = new ReportSourceWriter<>(sogojigyohiKagoReportWriter);
        } else if (コード_179.equals(parameter.getコード())) {
            PageBreaker<SogojigyohiKagoMoshitateshojohoSofuSource> breaker179 = new SogojigyohiKagoMoshitateshojohoSofuPageBreak(改頁項目リスト);
            sogojiReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker179).create();
            sogojiWriter = new ReportSourceWriter<>(sogojiReportWriter);
        }

        kaigoManager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, eUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        kaigoEucFilePath = Path.combinePath(kaigoManager.getEucOutputDirectry(),
                出力ファイル名);
        seikyugakuTsuchishoInCsvWriter = BatchWriters.csvWriter(KaigokyufuhiKagoMoshitateshoOutCsvEntity.class).
                filePath(kaigoEucFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void keyBreakProcess(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {
    }

    @Override
    protected void usualProcess(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {

        if (index_1 == 0) {
            this.exEtntity = entity;
            index_1++;
        } else {
            boolean flag = this.get合計flag(this.exEtntity, entity);
            if (コード_173.equals(parameter.getコード())) {
                KaigokyufuhiKagoMoshitateshoOutReport kaiReport
                        = new KaigokyufuhiKagoMoshitateshoOutReport(this.exEtntity, 出力順Map,
                                parameter.getシステム日付(), flag, 改頁項目名リスト, parameter.get処理年月(), 件数, 連番);
                kaiReport.writeBy(reportSourceWriter);
            } else if (コード_176.equals(parameter.getコード())) {
                SogojigyohiKagoMoshitateshojohoSofuIchiranReport sogoReport
                        = new SogojigyohiKagoMoshitateshojohoSofuIchiranReport(this.exEtntity, 出力順Map,
                                parameter.getシステム日付(), flag, 改頁項目名リスト, parameter.get処理年月(), 件数, 連番);
                sogoReport.writeBy(sogojigyohiKagoSourceWriter);
            } else if (コード_179.equals(parameter.getコード())) {
                SogojigyohiKagoMoshitateshojohoSofuReport sogojiReport
                        = new SogojigyohiKagoMoshitateshojohoSofuReport(this.exEtntity, 並び順, parameter.get処理年月(),
                                parameter.getシステム日付(), 件数, flag, 連番);
                sogojiReport.writeBy(sogojiWriter);
            }

            if (flag) {
                KaigokyufuhiKagoMoshitateshoOutCsvEntity output = this.get帳票のCSVファイル作成(
                        this.exEtntity, parameter.get処理年月(), parameter.getシステム日付(), false, 件数);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
                output = this.get帳票のCSVファイル作成(this.exEtntity, parameter.get処理年月(), parameter.getシステム日付(), true, 件数);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
                件数 = 0;
            } else {
                KaigokyufuhiKagoMoshitateshoOutCsvEntity output = this.get帳票のCSVファイル作成(
                        this.exEtntity, parameter.get処理年月(), parameter.getシステム日付(), false, 件数);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
            }
            this.exEtntity = entity;
            連番++;
        }
        this.アクセスログ対象追加(entity);
        件数++;

    }

    @Override
    protected void afterExecute() {

        if (コード_173.equals(parameter.getコード())) {
            KaigokyufuhiKagoMoshitateshoOutReport kaiReport
                    = new KaigokyufuhiKagoMoshitateshoOutReport(this.exEtntity, 出力順Map,
                            parameter.getシステム日付(), true, 改頁項目名リスト, parameter.get処理年月(), 件数, 連番);
            kaiReport.writeBy(reportSourceWriter);
            batchReportWriter.close();
        } else if (コード_176.equals(parameter.getコード())) {
            SogojigyohiKagoMoshitateshojohoSofuIchiranReport sogoReport
                    = new SogojigyohiKagoMoshitateshojohoSofuIchiranReport(this.exEtntity, 出力順Map,
                            parameter.getシステム日付(), true, 改頁項目名リスト, parameter.get処理年月(), 件数, 連番);
            sogoReport.writeBy(sogojigyohiKagoSourceWriter);
            sogojigyohiKagoReportWriter.close();
        } else if (コード_179.equals(parameter.getコード())) {
            SogojigyohiKagoMoshitateshojohoSofuReport sogojiReport
                    = new SogojigyohiKagoMoshitateshojohoSofuReport(this.exEtntity, 並び順, parameter.get処理年月(),
                            parameter.getシステム日付(), 件数, true, 連番);
            sogojiReport.writeBy(sogojiWriter);
            sogojiReportWriter.close();
        }
        KaigokyufuhiKagoMoshitateshoOutCsvEntity output = this.get帳票のCSVファイル作成(
                this.exEtntity, parameter.get処理年月(), parameter.getシステム日付(), false, 件数);
        seikyugakuTsuchishoInCsvWriter.writeLine(output);
        output = this.get帳票のCSVファイル作成(this.exEtntity, parameter.get処理年月(), parameter.getシステム日付(), true, 件数);
        seikyugakuTsuchishoInCsvWriter.writeLine(output);

        seikyugakuTsuchishoInCsvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            kaigoManager.spool(kaigoEucFilePath, accessLogUUID);
        } else {
            kaigoManager.spool(kaigoEucFilePath);
        }
    }

    private KaigokyufuhiKagoMoshitateshoOutCsvEntity get帳票のCSVファイル作成(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity, FlexibleYearMonth 処理年月,
            RDateTime 作成日時, boolean 合計flag, int 件数) {
        KaigokyufuhiKagoMoshitateshoOutCsvEntity output = new KaigokyufuhiKagoMoshitateshoOutCsvEntity();
        DbWT1731KagoMoshitateTempEntity 過誤申立 = entity.getDbWT1731Entity();
        DbWT1001HihokenshaTempEntity 被保険者 = entity.getDbWT1001Entity();
        if (index == 0) {
            output.set送付年月(パターン56(処理年月));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            index++;
        } else {
            output.set送付年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        if (!合計flag) {
            output.set証記載保険者番号(過誤申立.getShoKisaiHokenshaNo().getColumnValue());
            output.set証記載保険者名(過誤申立.getShoKisaiHokenshaName());
            output.setNo_(new RString(件数));
            output.set事業者番号(過誤申立.getJigyoshaNo().getColumnValue());
            output.set事業者名(過誤申立.getJigyoshaName());
            output.set被保険者番号(過誤申立.getHiHokenshaNo().getColumnValue());
            output.set被保険者カナ氏名(被保険者.getKanaMeisho());
            output.set被保険者氏名(被保険者.getMeisho());
            output.setサービス提供年月(doパターン54(過誤申立.getServiceTeikyoYM()));
            output.set申立年月日(過誤申立.getMoshitateYMD().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            RString 申立事由コード = 過誤申立.getMoshitateJiyuCode();
            output.set申立事由コード(申立事由コード);
            RString 申立事由1 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    this.コード種別_1,
                    new Code(申立事由コード.substringEmptyOnError(0, 2)));
            output.set申立事由1(申立事由1);
            RString 申立事由2 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    this.コード種別_2,
                    new Code(申立事由コード.substringEmptyOnError(申立事由コード.length() - 2, 申立事由コード.length())));
            output.set申立事由2(申立事由2);
        } else {
            output.set証記載保険者番号(過誤申立.getShoKisaiHokenshaNo().getColumnValue());
            output.set証記載保険者名(過誤申立.getShoKisaiHokenshaName());
            output.set合計件数(doカンマ編集(new Decimal(件数)).concat(漢字_件));
        }

        return output;
    }

    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {
        if (RString.isNullOrEmpty(出力順ID)) {
            return null;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        return outputOrder;
    }

    private boolean get合計flag(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity exEntity, KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {
        return !exEntity.getDbWT1731Entity().getShoKisaiHokenshaNo().equals(entity.getDbWT1731Entity().getShoKisaiHokenshaNo());
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private void アクセスログ対象追加(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {
        ShikibetsuCode 識別コード = entity.getDbWT1001Entity().getShikibetsuCode();
        HihokenshaNo 被保険者番号 = entity.getDbWT1001Entity().getExHihokenshaNo();
        if (null == 識別コード || 識別コード.isEmpty() || 識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号, 被保険者番号.getColumnValue());
        personalDataList.add(PersonalData.of(識別コード, expandedInformations));
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }
}
