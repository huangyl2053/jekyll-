/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120230;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin.SeikyugakuTsuchishoInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin.SeikyugakuTsuchishoInReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishoin.SeikyugakuTsuchishoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費等請求額通知書情報取込の一覧表作成を実行クラスです
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
public class SeikyugakuTsuchishoInDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<DbWT1511SeikyugakuTsuchishoTempEntity> {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200066");
    List<RString> 改頁項目リスト;
    private int index = 0;
    FileSpoolManager seikyugakuTsuchishoInManager;
    private RString seikyugEucFilePath;
    private static final RString 出力ファイル名
            = new RString("DBC200066_SeikyugakuTsuchisho.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private final RString 款コード_99 = new RString("99");
    private final RString 項コード_99 = new RString("99");
    private final RString 総合計 = new RString("＊＊　総合計　＊＊");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyugakutsuchishoin."
            + "ISeikyugakuTsuchishoInMapper.select介護給付費サービス請求額通知書一時TBLの全件");
    @BatchWriter
    private BatchReportWriter<SeikyugakuTsuchishoSource> batchReportWriter;
    private ReportSourceWriter<SeikyugakuTsuchishoSource> reportSourceWriter;
    private CsvWriter<SeikyugakuTsuchishoInCsvEntity> seikyugakuTsuchishoInCsvWriter;

    @Override
    protected void initialize() {
        super.initialize();
        改頁項目リスト = new ArrayList<>();
        改頁項目リスト.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.shoKisaiHokenshaNo.name()));
        改頁項目リスト.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.kanCode.name()));
        改頁項目リスト.add(new RString(SeikyugakuTsuchishoSource.DBC200066SourceFields.kouCode.name()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        PageBreaker<SeikyugakuTsuchishoSource> breaker = new SeikyugakuTsuchishoInPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC120230.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        seikyugakuTsuchishoInManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        seikyugEucFilePath = Path.combinePath(seikyugakuTsuchishoInManager.getEucOutputDirectry(),
                出力ファイル名);
        seikyugakuTsuchishoInCsvWriter = BatchWriters.csvWriter(SeikyugakuTsuchishoInCsvEntity.class).
                filePath(seikyugEucFilePath).
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
    protected void keyBreakProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity) {
    }

    @Override
    protected void usualProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity) {

        SeikyugakuTsuchishoInReport seikyugakuTsuchishoInReport = new SeikyugakuTsuchishoInReport(entity, parameter.getシステム日付());
        seikyugakuTsuchishoInReport.writeBy(reportSourceWriter);
        SeikyugakuTsuchishoInCsvEntity output = get帳票のCSVファイル作成(entity, parameter.getシステム日付());
        seikyugakuTsuchishoInCsvWriter.writeLine(output);

    }

    @Override
    protected void afterExecute() {
        seikyugakuTsuchishoInCsvWriter.close();
        seikyugakuTsuchishoInManager.spool(SubGyomuCode.DBC介護給付, seikyugEucFilePath);
    }

    private SeikyugakuTsuchishoInCsvEntity get帳票のCSVファイル作成(DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書,
            RDateTime 作成日時) {
        SeikyugakuTsuchishoInCsvEntity output = new SeikyugakuTsuchishoInCsvEntity();
        if (index == 0) {
            output.set審査年月(パターン56(請求額通知書.get審査年月()));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(SAKUSEI));
            output.set国保連合会名(請求額通知書.get国保連合会名());
            index++;
        } else {
            output.set審査年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set国保連合会名(RString.EMPTY);
        }
        output.set保険者番号(getColumnValue(請求額通知書.get保険者番号()));
        output.set保険者名(請求額通知書.get保険者名());
        output.set証記載保険者番号(getColumnValue(請求額通知書.get証記載保険者番号()));
        output.set款コード(請求額通知書.get款コード());
        if (款コード_99.equals(請求額通知書.get款コード())) {
            output.set款名(総合計);
        } else {
            output.set款名(請求額通知書.get款名());
        }
        output.set項コード(請求額通知書.get項コード());
        if (項コード_99.equals(請求額通知書.get項コード())) {
            output.set項名(RString.EMPTY);
        } else {
            output.set項名(請求額通知書.get項名());
        }
        output.setサービス種類コード(請求額通知書.getサービス種類コード());
        output.setサービス種類名(請求額通知書.getサービス種類名());
        output.set通常_分件数(doカンマ編集(請求額通知書.get通常分_件数()));
        output.set通常分_実日数(doカンマ編集(請求額通知書.get通常分_実日数()));
        output.set通常分_単位数(doカンマ編集(請求額通知書.get通常分_単位数()));
        output.set通常分_金額(doカンマ編集(請求額通知書.get通常分_金額()));
        output.set再審査_過誤_件数(doカンマ編集(請求額通知書.get再審査_過誤_件数()));
        output.set再審査_過誤_単位数(doカンマ編集(請求額通知書.get再審査_過誤_単位数()));
        output.set再審査_過誤_調整額(doカンマ編集(請求額通知書.get再審査_過誤_調整額()));
        output.set介護給付費(doカンマ編集(請求額通知書.get介護給付_総合事業費()));
        output.set利用者負担額(doカンマ編集(請求額通知書.get利用者負担額()));
        output.set公費負担額(doカンマ編集(請求額通知書.get公費負担額()));
        if (!RString.isNullOrEmpty(請求額通知書.get合計_帳票レコード種別())) {
            output.set合計_通常分_件数(doカンマ編集(請求額通知書.get合計_通常分_件数()));
            output.set合計_通常分_単位数(doカンマ編集(請求額通知書.get合計_通常分_単位数()));
            output.set合計_通常分_金額(doカンマ編集(請求額通知書.get合計_通常分_金額()));
            output.set合計_再審査_過誤_件数(doカンマ編集(請求額通知書.get合計_再審査_過誤_件数()));
            output.set合計_再審査_過誤_単位数(doカンマ編集(請求額通知書.get合計_再審査_過誤_単位数()));
            output.set合計_再審査_過誤_調整額(doカンマ編集(請求額通知書.get合計_再審査_過誤_調整額()));
            output.set合計_介護給付費(doカンマ編集(請求額通知書.get合計_介護給付_総合事業費()));
            output.set合計_利用者負担額(doカンマ編集(請求額通知書.get合計_利用者負担額()));
            output.set合計_公費負担額(doカンマ編集(請求額通知書.get合計_公費負担額()));
        }
        if (!RString.isNullOrEmpty(請求額通知書.get累計_帳票レコード種別())) {
            output.set累計_通常分_件数(doカンマ編集(請求額通知書.get累計_通常分_件数()));
            output.set累計_通常分_単位数(doカンマ編集(請求額通知書.get累計_通常分_単位数()));
            output.set累計_通常分_金額(doカンマ編集(請求額通知書.get累計_通常分_金額()));
            output.set累計_再審査_過誤_件数(doカンマ編集(請求額通知書.get累計_再審査_過誤_件数()));
            output.set累計_再審査_過誤_単位数(doカンマ編集(請求額通知書.get累計_再審査_過誤_単位数()));
            output.set累計_再審査_過誤_調整額(doカンマ編集(請求額通知書.get累計_再審査_過誤_調整額()));
            output.set累計_介護給付費(doカンマ編集(請求額通知書.get累計_介護給付_総合事業費()));
            output.set累計_利用者負担額(doカンマ編集(請求額通知書.get累計_利用者負担額()));
            output.set累計_公費負担額(doカンマ編集(請求額通知書.get累計_公費負担額()));
        }
        if (!RString.isNullOrEmpty(請求額通知書.get手数料_帳票レコード種別())) {
            output.set手数料_請求額(doカンマ編集(請求額通知書.get手数料_請求額()));
            output.set手数料_累計請求額(doカンマ編集(請求額通知書.get手数料_累計請求額()));
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

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
