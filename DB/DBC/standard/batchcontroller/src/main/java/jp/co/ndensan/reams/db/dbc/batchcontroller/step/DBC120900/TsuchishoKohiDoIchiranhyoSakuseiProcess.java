    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120900;

import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohiseikyugakutsuchishokohiin.TsuchishoKohiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohiseikyugakutsuchishokohi.TsuchishofutanshaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 請求額通知書の一覧表作成を実行する
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
public class TsuchishoKohiDoIchiranhyoSakuseiProcess extends BatchProcessBase<DbWT1511SeikyugakuTsuchishoTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.sogojigyohiseikyugakutsuchishokohikouhifutann.ITsuchishoKohiChoyoMapper.get帳票出力対象データ");
    private TsuchishoKohiDoIchiranhyoSakuseiProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200082");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200082_SogojigyohiSeikyugakuTsuchishoKohi.csv");
    @BatchWriter
    private BatchReportWriter<SogojigyohiSeikyugakuTsuchishoKohiSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKohiSource> reportSourceWriter;
    private CsvWriter<TsuchishofutanshaIchiranCSVEntity> csvEntityWriter;
    private final RString 総合計 = new RString("＊＊　総合計　＊＊");
    private final RString コード_99 = new RString("99");
    private int index = 0;
    private static final RString SAKUSEI = new RString("作成");

    @Override
    protected void initialize() {
        super.initialize();

    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200082.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 出力ファイル名);
        csvEntityWriter = BatchWriters.csvWriter(TsuchishofutanshaIchiranCSVEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        SogojigyohiSeikyugakuTsuchishoKohiReport report = new SogojigyohiSeikyugakuTsuchishoKohiReport(entity, parameter.getシステム日付());
        report.writeBy(reportSourceWriter);
        TsuchishofutanshaIchiranCSVEntity csvEntity = do帳票のCSVファイル作成(entity, parameter.getシステム日付());
        csvEntityWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        csvEntityWriter.close();
    }

    private TsuchishofutanshaIchiranCSVEntity do帳票のCSVファイル作成(DbWT1511SeikyugakuTsuchishoTempEntity csvDataEntity,
            YMDHMS 作成日時) {
        TsuchishofutanshaIchiranCSVEntity csvEntity = new TsuchishofutanshaIchiranCSVEntity();
        FlexibleYearMonth 審査年月 = csvDataEntity.get審査年月();
        if (index == 0) {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = new RString(作成日時.getRDateTime().toString()).concat(RString.HALF_SPACE).concat(SAKUSEI);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            csvEntity.set審査年月(パターン56(csvDataEntity.get審査年月()));
            csvEntity.set国保連合会名(csvDataEntity.get国保連合会名());
            index++;
        } else {
            csvEntity.set審査年月(RString.EMPTY);
            csvEntity.set作成日時(RString.EMPTY);
            csvEntity.set国保連合会名(RString.EMPTY);

        }
        csvEntity.set公費負担者番号(csvDataEntity.get公費負担者番号());
        csvEntity.set公費負担者名(csvDataEntity.get公費負担者名());
        if (コード_99.equals(csvDataEntity.get款コード())) {
            csvEntity.set款コード(総合計);
        } else {
            csvEntity.set款名(csvDataEntity.get款名());
        }
        if (コード_99.equals(csvDataEntity.get項コード())) {
            csvEntity.set項名(RString.EMPTY);
        } else {
            csvEntity.set項名(csvDataEntity.get項名());
        }
        csvEntity.setサービス種類コード(csvDataEntity.getサービス種類コード());
        csvEntity.setサービス種類名(csvDataEntity.getサービス種類名());
        csvEntity.set通常分_件数(doカンマ編集(csvDataEntity.get通常分_件数()));
        csvEntity.set通常分_実日数(doカンマ編集(csvDataEntity.get通常分_実日数()));
        csvEntity.set通常分_公費対象単位数(doカンマ編集(csvDataEntity.get通常分_単位数()));
        csvEntity.set通常分_公費対象金額(doカンマ編集(csvDataEntity.get通常分_金額()));
        csvEntity.set再審査_過誤_件数(doカンマ編集(csvDataEntity.get再審査_過誤_件数()));
        csvEntity.set再審査_過誤_公費対象単位数(doカンマ編集(csvDataEntity.get再審査_過誤_単位数()));
        csvEntity.set再審査_過誤_公費対象調整額(doカンマ編集(csvDataEntity.get再審査_過誤_調整額()));
        csvEntity.set負担額(doカンマ編集(csvDataEntity.get公費負担額()));
        csvEntity.set公費分本人負担額(doカンマ編集(csvDataEntity.get利用者負担額()));
        if (!RString.isNullOrEmpty(csvDataEntity.get合計_帳票レコード種別())) {
            csvEntity.set合計_通常分_件数(doカンマ編集(csvDataEntity.get合計_通常分_件数()));
            csvEntity.set合計_通常分_公費対象単位数(doカンマ編集(csvDataEntity.get合計_通常分_単位数()));
            csvEntity.set合計_通常分_公費対象金額(doカンマ編集(csvDataEntity.get合計_通常分_金額()));
            csvEntity.set合計_再審査_過誤_件数(doカンマ編集(csvDataEntity.get合計_再審査_過誤_件数()));
            csvEntity.set合計_再審査_過誤_公費対象単位数(doカンマ編集(csvDataEntity.get合計_再審査_過誤_単位数()));
            csvEntity.set合計_再審査_過誤_公費対象調整額(doカンマ編集(csvDataEntity.get合計_再審査_過誤_調整額()));
            csvEntity.set合計_負担額(doカンマ編集(csvDataEntity.get合計_公費負担額()));
            csvEntity.set合計_公費分本人負担額(doカンマ編集(csvDataEntity.get合計_利用者負担額()));
        }
        if (!RString.isNullOrEmpty(csvDataEntity.get累計_帳票レコード種別())) {
            csvEntity.set累計_通常分_件数(doカンマ編集(csvDataEntity.get累計_通常分_件数()));
            csvEntity.set累計_通常分_公費対象単位数(doカンマ編集(csvDataEntity.get累計_通常分_単位数()));
            csvEntity.set累計_通常分_公費対象金額(doカンマ編集(csvDataEntity.get累計_通常分_金額()));
            csvEntity.set累計_再審査_過誤_件数(doカンマ編集(csvDataEntity.get累計_再審査_過誤_件数()));
            csvEntity.set累計_再審査_過誤_公費対象単位数(doカンマ編集(csvDataEntity.get累計_再審査_過誤_単位数()));
            csvEntity.set累計_再審査_過誤_公費対象調整額(doカンマ編集(csvDataEntity.get累計_再審査_過誤_調整額()));
            csvEntity.set累計_負担額(doカンマ編集(csvDataEntity.get合計_公費負担額()));
            csvEntity.set累計_公費分本人負担額(doカンマ編集(csvDataEntity.get累計_利用者負担額()));
        }
        if (!RString.isNullOrEmpty(csvDataEntity.get手数料_帳票レコード種別())) {
            csvEntity.set手数料_請求額(doカンマ編集(csvDataEntity.get手数料_請求額()));
            csvEntity.set手数料_累計請求額(doカンマ編集(csvDataEntity.get手数料_累計請求額()));
        }
        return csvEntity;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
