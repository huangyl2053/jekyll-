/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120250;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi.SogojigyohiSeikyugakuTsuchishoKeikaSochiPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi.SogojigyohiSeikyugakuTsuchishoKeikaSochiReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokeikasochiin.SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.sogojigyohisei.SogojigyohiSeiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）請求額通知書の一覧表作成を実行する
 *
 * @reamsid_L DBC-2480-011 jiangxiaolong
 */
public class SogojigyohiSeiDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<DbWT1511SeikyugakuTsuchishoTempEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisei."
                    + "ISogojigyohiSeikyugakuTsuchishoKeikaSochiMapper.select帳票出力対象データ");
    private SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200068");
    private FileSpoolManager manager;
    private RString sogojigyohiSeiFilePath;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200068_SogojigyohiSeikyugakuTsuchishoKeikaSochi.csv");
    private final RString 総合計 = new RString("＊＊　総合計　＊＊");
    private final RString コード_99 = new RString("99");
    @BatchWriter
    private BatchReportWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> reportSourceWriter;
    private CsvWriter<SogojigyohiSeiCsvEntity> sogojigyohiSeiCsvEntityWriter;
    List<RString> 改頁項目リスト;
    private int index = 0;

    @Override
    protected void initialize() {
        super.initialize();
        改頁項目リスト = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> breaker = new SogojigyohiSeikyugakuTsuchishoKeikaSochiPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200068.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        sogojigyohiSeiFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        sogojigyohiSeiCsvEntityWriter = BatchWriters.csvWriter(SogojigyohiSeiCsvEntity.class).
                filePath(sogojigyohiSeiFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity) {
    }

    @Override
    protected void beforeExecute() {
        改頁項目リスト.add(new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.shoKisaiHokenshaNo.name()));
        改頁項目リスト.add(new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.kanName.name()));
        改頁項目リスト.add(new RString(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource.DBC200068SogojigyohiSeikyugakuFields.kouName.name()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void usualProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity
    ) {
        SogojigyohiSeikyugakuTsuchishoKeikaSochiReport seikyugakuTsuchishoInReport
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiReport(entity, parameter.getシステム日付());
        seikyugakuTsuchishoInReport.writeBy(reportSourceWriter);
        SogojigyohiSeiCsvEntity output = get帳票のCSVファイル作成(entity, parameter.getシステム日付());
        sogojigyohiSeiCsvEntityWriter.writeLine(output);
    }

    @Override
    protected void afterExecute() {
        sogojigyohiSeiCsvEntityWriter.close();
    }

    private SogojigyohiSeiCsvEntity get帳票のCSVファイル作成(DbWT1511SeikyugakuTsuchishoTempEntity entity,
            RDateTime 作成日時) {
        SogojigyohiSeiCsvEntity output = new SogojigyohiSeiCsvEntity();
        if (index == 0) {
            output.set審査年月(entity.get審査年月().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            index++;
        } else {
            output.set審査年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        output.set国保連合会名(entity.get国保連合会名());
        output.set保険者番号(getColumnValue(entity.get保険者番号()));
        output.set保険者名(entity.get保険者名());
        output.set証記載保険者番号(getColumnValue(entity.get証記載保険者番号()));
        output.set款コード(entity.get款コード());
        if (コード_99.equals(entity.get款コード())) {
            output.set款名(総合計);
        } else {
            output.set款名(entity.get款名());
        }
        output.set項コード(entity.get項コード());
        if (コード_99.equals(entity.get項コード())) {
            output.set項名(RString.EMPTY);
        } else {
            output.set項名(entity.get項名());
        }
        output.setサービス種類コード(entity.getサービス種類コード());
        output.setサービス種類名(entity.getサービス種類名());
        output.set通常分_件数(doカンマ編集(entity.get通常分_件数()));
        output.set通常分_実日数(doカンマ編集(entity.get通常分_実日数()));
        output.set通常分_単位数(doカンマ編集(entity.get通常分_単位数()));
        output.set通常分_金額(doカンマ編集(entity.get通常分_金額()));
        output.set過誤_件数(doカンマ編集(entity.get再審査_過誤_件数()));
        output.set過誤_単位数(doカンマ編集(entity.get再審査_過誤_単位数()));
        output.set過誤_調整額(doカンマ編集(entity.get再審査_過誤_調整額()));
        output.set総合事業費(doカンマ編集(entity.get介護給付_総合事業費()));
        output.set利用者負担額(doカンマ編集(entity.get利用者負担額()));
        if (!entity.get合計_帳票レコード種別().isEmpty()) {
            output.set合計_通常分_件数(doカンマ編集(entity.get合計_通常分_件数()));
            output.set合計_通常分_単位数(doカンマ編集(entity.get合計_通常分_単位数()));
            output.set合計_通常分_金額(doカンマ編集(entity.get合計_通常分_金額()));
            output.set合計_過誤_件数(doカンマ編集(entity.get合計_再審査_過誤_件数()));
            output.set合計_過誤_単位数(doカンマ編集(entity.get合計_再審査_過誤_単位数()));
            output.set合計_過誤_調整額(doカンマ編集(entity.get合計_再審査_過誤_調整額()));
            output.set合計_総合事業費(doカンマ編集(entity.get合計_介護給付_総合事業費()));
            output.set合計_利用者負担額(doカンマ編集(entity.get合計_利用者負担額()));
        }
        if (!entity.get累計_帳票レコード種別().isEmpty()) {
            output.set累計_通常分_件数(doカンマ編集(entity.get累計_通常分_件数()));
            output.set累計_通常分_単位数(doカンマ編集(entity.get累計_通常分_単位数()));
            output.set累計_通常分_金額(doカンマ編集(entity.get累計_通常分_金額()));
            output.set累計_過誤_件数(doカンマ編集(entity.get累計_再審査_過誤_件数()));
            output.set累計_過誤_単位数(doカンマ編集(entity.get累計_再審査_過誤_単位数()));
            output.set累計_過誤_調整額(doカンマ編集(entity.get累計_再審査_過誤_調整額()));
            output.set累計_総合事業費(doカンマ編集(entity.get累計_介護給付_総合事業費()));
            output.set累計_利用者負担額(doカンマ編集(entity.get累計_利用者負担額()));
        }
        if (!entity.get手数料_帳票レコード種別().isEmpty()) {
            output.set手数料_請求額(doカンマ編集(entity.get手数料_請求額()));
            output.set手数料_累計請求額(doカンマ編集(entity.get手数料_累計請求額()));
        }
        return output;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
