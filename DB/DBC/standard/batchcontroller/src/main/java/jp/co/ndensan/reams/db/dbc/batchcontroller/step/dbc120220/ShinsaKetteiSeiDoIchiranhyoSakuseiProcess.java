/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shinsaketteiseikyumeisaiin.ShinsaKetteiSeiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.shinsaketteiseidoichiranhyosakusei.KyufuhiShinsaKetteiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
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
 * 介護給付費等審査決定請求明細表情報取込の一覧表作成を実行クラスです
 *
 * @reamsid_L DBC-2500-010 jiangxiaolong
 */
public class ShinsaKetteiSeiDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<KyufuhiShinsaKetteiSeikyuMeisaihyoEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shinsaketteiseidoichiranhyosakusei."
                    + "IShinsaKetteiSeiDoIchiranhyoSakuseiMapper.select帳票出力対象データ");
    private ShinsaKetteiSeiDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200069");
    private FileSpoolManager manager;
    private RString kyufuhiShinsaFilePath;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString アステリスク = new RString("**********");
    private static final RString 文字_高額介護サービス費 = new RString("高額介護サービス費");
    private static final RString 文字_合計 = new RString("合計");
    private static final RString 出力ファイル名
            = new RString("DBC200069_KyufuhiShinsaKetteiSeikyuMeisaihyo.csv");
    @BatchWriter
    private BatchReportWriter<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> batchReportWriter;
    private ReportSourceWriter<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> reportSourceWriter;
    private CsvWriter<KyufuhiShinsaKetteiCsvEntity> kyufuhiShinsaCsvEntityWriter;
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString SAKUSEI = new RString("作成");
    private IOutputOrder 並び順;
    private List<RString> 改頁リスト;
    private Map<RString, RString> 出力順Map;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private static final RString デフォルト出力順 = new RString(" ORDER BY \"DbWT1613SinsaKetteiSeikyuGokei\".\"shoKisaiHokenshaNo\" ASC ");
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
    private KyufuhiShinsaKetteiSeikyuMeisaihyoEntity currentRecord;

    @Override
    protected void initialize() {
        super.initialize();
        改頁リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        並び順 = get並び順(parameter.get帳票ID(), parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.class, 並び順);
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = 出力順.split(コンマ.toString());
            出力順 = デフォルト出力順;
            if (出力順BODY.size() > 1) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    出力順 = 出力順.concat(コンマ).concat(出力順BODY.get(i));
                }
            }
        }
        帳票データの取得Parameter.set出力順(出力順);
        if (並び順 != null) {
            int i = 0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁リスト.add(item.get項目ID());
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
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> breaker = new KyufuhiShinsaKetteiSeikyuMeisaihyoPageBreak(改頁リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        kyufuhiShinsaFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        kyufuhiShinsaCsvEntityWriter = BatchWriters.csvWriter(KyufuhiShinsaKetteiCsvEntity.class).
                filePath(kyufuhiShinsaFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(KyufuhiShinsaKetteiSeikyuMeisaihyoEntity entity) {
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void usualProcess(KyufuhiShinsaKetteiSeikyuMeisaihyoEntity entity
    ) {
        currentRecord = entity;
        KyufuhiShinsaKetteiSeikyuMeisaihyoEntity beforeEntity = getBefore();
        KyufuhiShinsaKetteiSeikyuMeisaihyoReport kyufuhiShinsaKetteiInReport;
        KyufuhiShinsaKetteiCsvEntity output;
        if (null != beforeEntity) {
            if (is改頁(beforeEntity, entity)) {
                kyufuhiShinsaKetteiInReport = new KyufuhiShinsaKetteiSeikyuMeisaihyoReport(beforeEntity,
                        出力順Map, parameter.getシステム日付(), true);
                output = get帳票のCSVファイル作成(beforeEntity, true, false);
                kyufuhiShinsaCsvEntityWriter.writeLine(output);
                output = get帳票のCSVファイル作成(beforeEntity, true, true);
                kyufuhiShinsaCsvEntityWriter.writeLine(output);
            } else {
                kyufuhiShinsaKetteiInReport = new KyufuhiShinsaKetteiSeikyuMeisaihyoReport(beforeEntity,
                        出力順Map, parameter.getシステム日付(), false);
                output = get帳票のCSVファイル作成(beforeEntity, false, false);
                kyufuhiShinsaCsvEntityWriter.writeLine(output);
            }
            kyufuhiShinsaKetteiInReport.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (currentRecord != null) {
            KyufuhiShinsaKetteiCsvEntity output = get帳票のCSVファイル作成(currentRecord, false, false);
            kyufuhiShinsaCsvEntityWriter.writeLine(output);
            output = get帳票のCSVファイル作成(currentRecord, true, false);
            kyufuhiShinsaCsvEntityWriter.writeLine(output);
            output = get帳票のCSVファイル作成(currentRecord, true, true);
            kyufuhiShinsaCsvEntityWriter.writeLine(output);
            KyufuhiShinsaKetteiSeikyuMeisaihyoReport kyufuhiShinsaKettei合計InReport = new KyufuhiShinsaKetteiSeikyuMeisaihyoReport(currentRecord,
                    出力順Map, parameter.getシステム日付(), true);
            kyufuhiShinsaKettei合計InReport.writeBy(reportSourceWriter);
        }
        kyufuhiShinsaCsvEntityWriter.close();
    }

    private KyufuhiShinsaKetteiCsvEntity get帳票のCSVファイル作成(KyufuhiShinsaKetteiSeikyuMeisaihyoEntity entity, boolean 集計, boolean 合計) {
        KyufuhiShinsaKetteiCsvEntity output = new KyufuhiShinsaKetteiCsvEntity();
        output.set保険者名(entity.get合計テータ().get保険者名());
        output.set証記載保険者番号(getColumnValue(entity.get合計テータ().get証記載保険者番号()));
        output.set保険者番号(getColumnValue(entity.get合計テータ().get保険者番号()));
        if (集計) {
            output.set事業者番号(アステリスク);
            if (!合計) {
                output.set事業者名(文字_高額介護サービス費);
                output.set件数(doカンマ編集(entity.get高額テータ().get高額_高額該当件数()));
                output.set介護給付費(doカンマ編集(entity.get高額テータ().get高額_高額介護サービス費()));
                output.set公費負担額(doカンマ編集(entity.get高額テータ().get高額_公費負担額()));
            } else {
                output.set事業者名(文字_合計);
                output.set件数(doカンマ編集(entity.get合計テータ().get合計_件数()));
                output.set単位(doカンマ編集(entity.get合計テータ().get合計_単位数()));
                output.set金額(doカンマ編集(entity.get合計テータ().get合計_金額()));
                output.set介護給付費(doカンマ編集(entity.get合計テータ().get合計_介護給付費_総合事業費()));
                output.set利用者負担額(doカンマ編集(entity.get合計テータ().get合計_利用者負担額()));
                output.set公費負担額(doカンマ編集(entity.get合計テータ().get合計_公費負担額()));
            }
        } else {
            output.set審査年月(パターン56(entity.get合計テータ().get審査年月()));
            RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = parameter.getシステム日付().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            output.set国保連合会名(entity.get合計テータ().get国保連合会名());
            output.set事業者番号(getColumnValue(entity.get明細テータ().get事業所番号()));
            output.set事業者名(entity.get明細テータ().get事業所名());
            output.setサービス提供年月(doパターン54(entity.get明細テータ().getサービス提供年月()));
            output.setサービス種類名(entity.get明細テータ().getサービス種類名());
            output.set件数(doカンマ編集(entity.get明細テータ().get件数()));
            output.set日数_回数(doカンマ編集(entity.get明細テータ().get日数_回数()));
            output.set単位(doカンマ編集(entity.get明細テータ().get単位数()));
            output.set金額(doカンマ編集(entity.get明細テータ().get金額()));
            output.set介護給付費(doカンマ編集(entity.get明細テータ().get介護給付費_総合事業費()));
            output.set利用者負担額(doカンマ編集(entity.get明細テータ().get利用者負担額()));
            output.set公費負担額(doカンマ編集(entity.get明細テータ().get公費負担額()));
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

    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {
        if (RString.isNullOrEmpty(出力順ID)) {
            return null;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        return outputOrder;
    }

    private boolean is改頁(KyufuhiShinsaKetteiSeikyuMeisaihyoEntity currentSource,
            KyufuhiShinsaKetteiSeikyuMeisaihyoEntity nextSource) {
        boolean flag = false;
        if (!currentSource.get合計テータ().get証記載保険者番号().equals(nextSource.get合計テータ().get証記載保険者番号())) {
            flag = true;
        }
        return flag;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
