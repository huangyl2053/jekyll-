/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120260;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohishinsaketteiseikyumeisaikeikasochiin.SogojigyohiShinsaProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohishinsaketteiseikyumeisaikeikasochiin.SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhishinsaketteiseikyumeisaihyo.DbWT1611SinsaKetteiSeikyuMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhishinsaketteiseikyumeisaihyo.DbWT1613SinsaKetteiSeikyuGokei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
 * 総合事業費（経過措置）審査決定請求明細表情報取込の一覧表作成を実行クラスです
 *
 * @reamsid_L DBC-2500-011 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInProcess
        extends BatchKeyBreakBase<SogojigyohiShinsaKetteiSeikyumeisaihyoEntity> {

    private SogojigyohiShinsaProcessParameter parameter;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private List<RString> 改頁項目名リスト;
    private Map<RString, RString> 出力順Map;
    private int index = 0;
    private int index_1 = 0;
    private SogojigyohiShinsaKetteiSeikyumeisaihyoEntity exEtntity;
    private FileSpoolManager seikyugakuTsuchishoInManager;
    private RString seikyugakuEucFilePath;
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
    private static final RString 出力ファイル名 = new RString("DBC200070_SogojigyohiShinsaKetteiSeikyumeisaihyo.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200070");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "sogojigyohishinsaketteiseikyumeisaikeikasochiin.ISogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInMapper.get帳票出力対象データ");
    private static final RString 引用符_1 = new RString("**********");
    private static final RString 文字_合計 = new RString("合計");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");

    @BatchWriter
    private BatchReportWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> reportSourceWriter;
    private CsvWriter<SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity> seikyugakuTsuchishoInCsvWriter;

    @Override
    protected void initialize() {
        super.initialize();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        改頁項目リスト = new ArrayList<>();
        改頁項目名リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        並び順 = get並び順(parameter.get帳票ID(), parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder.class, 並び順);
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
        PageBreaker<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> breaker = new SogojigyohiShinsaKetteiSeikyumeisaihyoPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200070.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        seikyugakuTsuchishoInManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        seikyugakuEucFilePath = Path.combinePath(seikyugakuTsuchishoInManager.getEucOutputDirectry(),
                出力ファイル名);
        seikyugakuTsuchishoInCsvWriter = BatchWriters.csvWriter(SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity.class).
                filePath(seikyugakuEucFilePath).
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
    protected void keyBreakProcess(SogojigyohiShinsaKetteiSeikyumeisaihyoEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiShinsaKetteiSeikyumeisaihyoEntity entity) {

        if (index_1 == 0) {
            this.exEtntity = entity;
            index_1++;
        } else {
            SogojigyohiShinsaKetteiSeikyumeisaihyoReport sogojigyohiShinsaKetteiSeikyumeisaihyoReport
                    = new SogojigyohiShinsaKetteiSeikyumeisaihyoReport(this.exEtntity, 出力順Map,
                            parameter.getシステム日付(), this.get合計flag(this.exEtntity, entity), 改頁項目名リスト);
            sogojigyohiShinsaKetteiSeikyumeisaihyoReport.writeBy(reportSourceWriter);
            if (this.get合計flag(this.exEtntity, entity)) {
                SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity output
                        = this.get帳票のCSVファイル作成(this.exEtntity, parameter.getシステム日付(), false);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
                output
                        = this.get帳票のCSVファイル作成(this.exEtntity, parameter.getシステム日付(), true);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
            } else {
                SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity output
                        = this.get帳票のCSVファイル作成(this.exEtntity, parameter.getシステム日付(), false);
                seikyugakuTsuchishoInCsvWriter.writeLine(output);
            }
            this.exEtntity = entity;
        }

    }

    @Override
    protected void afterExecute() {
        SogojigyohiShinsaKetteiSeikyumeisaihyoReport sogojigyohiShinsaKetteiSeikyumeisaihyoReport
                = new SogojigyohiShinsaKetteiSeikyumeisaihyoReport(this.exEtntity, 出力順Map,
                        parameter.getシステム日付(), true, 改頁項目名リスト);
        sogojigyohiShinsaKetteiSeikyumeisaihyoReport.writeBy(reportSourceWriter);
        SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity output
                = this.get帳票のCSVファイル作成(this.exEtntity, parameter.getシステム日付(), false);
        seikyugakuTsuchishoInCsvWriter.writeLine(output);
        output = this.get帳票のCSVファイル作成(this.exEtntity, parameter.getシステム日付(), true);
        seikyugakuTsuchishoInCsvWriter.writeLine(output);
        seikyugakuTsuchishoInCsvWriter.close();
        seikyugakuTsuchishoInManager.spool(SubGyomuCode.DBC介護給付, seikyugakuEucFilePath);
    }

    private SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity get帳票のCSVファイル作成(SogojigyohiShinsaKetteiSeikyumeisaihyoEntity entity,
            RDateTime 作成日時, boolean 合計flag) {
        SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity output = new SogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInCsvEntity();
        DbWT1613SinsaKetteiSeikyuGokei 審査決定請求合計 = entity.get審査決定請求合計();
        DbWT1611SinsaKetteiSeikyuMeisai 審査決定請求明細 = entity.get審査決定請求明細();
        if (index == 0) {
            output.set審査年月(パターン56(審査決定請求合計.get審査年月()));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            output.set国保連合会名(審査決定請求合計.get国保連合会名());
            index++;
        } else {
            output.set審査年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set国保連合会名(RString.EMPTY);
        }
        if (!合計flag) {
            output.set保険者番号(getColumnValue(審査決定請求合計.get保険者番号()));
            output.set保険者名(審査決定請求合計.get保険者名());
            output.set証記載保険者番号(getColumnValue(審査決定請求合計.get証記載保険者番号()));
            output.set事業者番号(getColumnValue(審査決定請求明細.get事業所番号()));
            output.set事業者名(審査決定請求明細.get事業所名());
            output.setサービス提供年月(doパターン54(審査決定請求明細.getサービス提供年月()));
            output.setサービス種類名(審査決定請求明細.getサービス種類名());
            output.set件数(doカンマ編集(審査決定請求明細.get件数()));
            output.set日数_回数(doカンマ編集(審査決定請求明細.get日数_回数()));
            output.set単位(doカンマ編集(審査決定請求明細.get単位数()));
            output.set金額(doカンマ編集(審査決定請求明細.get金額()));
            output.set介護予防_日常生活支援総合事業費(doカンマ編集(審査決定請求明細.get介護給付費_総合事業費()));
            output.set利用者負担額(doカンマ編集(審査決定請求明細.get利用者負担額()));
        } else {
            output.set保険者番号(getColumnValue(審査決定請求合計.get保険者番号()));
            output.set保険者名(審査決定請求合計.get保険者名());
            output.set証記載保険者番号(getColumnValue(審査決定請求合計.get証記載保険者番号()));
            output.set事業者番号(引用符_1);
            output.set事業者名(文字_合計);
            output.set件数(doカンマ編集(審査決定請求合計.get合計_件数()));
            output.set単位(doカンマ編集(審査決定請求合計.get合計_単位数()));
            output.set金額(doカンマ編集(審査決定請求合計.get合計_金額()));
            output.set介護予防_日常生活支援総合事業費(doカンマ編集(審査決定請求合計.get合計_介護給付費_総合事業費()));
            output.set利用者負担額(doカンマ編集(審査決定請求合計.get合計_利用者負担額()));
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

    private boolean get合計flag(SogojigyohiShinsaKetteiSeikyumeisaihyoEntity exEntity, SogojigyohiShinsaKetteiSeikyumeisaihyoEntity entity) {
        return !exEntity.get審査決定請求合計().get証記載保険者番号().equals(entity.get審査決定請求合計().get証記載保険者番号());
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

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

}
