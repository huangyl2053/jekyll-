/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 請求明細・給付管理票返戻（保留）一覧表の一覧表作成を実行する。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
public class HenreiHoryuInIchiranhyoSakuseiProcess extends BatchKeyBreakBase<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.henreihoryuin."
                    + "IHenreiHoryuInMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200001");
    private static final RString コンマ = new RString(",");
    private static final RString SAKUSEI = new RString("作成");
    private final Code code = new Code("0003");
    private final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(
                                    SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource.ReportSourceFields.shoHokenshaNo.name())));
    private static final RString 出力ファイル名
            = new RString("DBC200001_SeikyumeisaiKyufukanrihyoHenreiHoryuIchiran.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番 = 1;
    private RDateTime 作成日時;
    private FileSpoolManager manager;
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private Set<ShikibetsuCode> 識別コードset;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private RString eucFilePath;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity lastEntity;

    @BatchWriter
    private BatchReportWriter<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource> reportSourceWriter;
    private CsvWriter<HenreiHoryuInCsvEntity> henreiHoryuInCsvWriter;

    @Override
    protected void initialize() {
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        識別コードset = new HashSet();
        作成日時 = parameter.getシステム日付();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiKohiJukyushaSource> breaker = new SogojigyohiKohiJukyushaPageBreak(PAGE_BREAK_KEYS);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200001.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        henreiHoryuInCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected void keyBreakProcess(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity) {
    }

    @Override
    protected void usualProcess(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity) {
        entity.set作成日時(作成日時);
        アクセスログ対象追加(entity);
        SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport report = new SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport(beforeEntity,
                    連番);
            report.writeBy(reportSourceWriter);
            csv明細作成(beforeEntity, parameter.getシステム日付());
            連番++;
        }
        lastEntity = entity;
    }

    @Override
    protected void afterExecute() {
        lastEntity.set作成日時(作成日時);
        SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport report = new SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport(lastEntity,
                連番);
        report.writeBy(reportSourceWriter);
        csv明細作成(lastEntity, parameter.getシステム日付());
        henreiHoryuInCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void csv明細作成(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity, RDateTime 作成日時) {
        HenreiHoryuInCsvEntity output = new HenreiHoryuInCsvEntity();
        if (連番 == 1) {
            output.set審査年月(nullHandan(entity.get審査年月()));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            output.set国保連合会名(entity.get国保連合会名());
        } else {
            output.set審査年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set国保連合会名(RString.EMPTY);
        }
        output.set連番(new RString(連番));
        output.set保険者番号(entity.get保険者番号());
        output.set保険者名(entity.get保険者名());
        output.set事業者番号(entity.get事業者番号());
        output.set事業者名(entity.get事業者名());
        output.set被保険者番号(entity.get登録被保険者番号());
        output.set被保険者氏名(entity.get宛名名称());
        output.set種別(entity.get種別());
        output.setサービス提供年月(doパターン54(entity.getサービス提供年月()));
        output.setサービス種類コード(entity.getサービス種類コード());
        output.setサービス項目コード等(entity.getサービス項目コード等());
        output.set単位数(doカンマ編集(entity.get単位数()));
        output.set事由(entity.get事由());
        output.set内容(entity.get内容());
        output.set備考(entity.get備考());
        henreiHoryuInCsvWriter.writeLine(output);
    }

    private void アクセスログ対象追加(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity) {
        if (null == entity.get識別コード() || entity.get識別コード().isEmpty()) {
            return;
        }
        if (識別コードset.contains(new ShikibetsuCode(entity.get識別コード()))) {
            return;
        }
        識別コードset.add(new ShikibetsuCode(entity.get識別コード()));
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 漢字_被保険者番号,
                entity.get被保険者番号());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private RString doカンマ編集(Decimal number) {
        if (number == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString nullHandan(RString date) {
        if (!RString.isNullOrEmpty(date)) {
            return new FlexibleYearMonth(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString doパターン54(RString 年月) {
        if (RString.isNullOrEmpty(年月)) {
            return RString.EMPTY;
        }
        return new FlexibleYearMonth(年月).wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
