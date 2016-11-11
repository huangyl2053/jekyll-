/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120920;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1611SinsaKetteiSeikyuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1612SinsaKetteiSeikyuKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1613SinsaKetteiSeikyuGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
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
 * 一覧表作成。
 *
 * @reamsid_L DBC-2500-012 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiProcess
        extends BatchKeyBreakBase<SogojigyohiShinsaKetteiSeikyumeisaiInEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120920."
                    + "ISogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiMapper.get帳票出力対象データ");
    private int 連番;
    private IOutputOrder 並び順;
    private List<RString> 改頁リスト;
    private List<RString> 改頁項目名リスト;
    private SogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiProcessParameter parameter;
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString アステリスク = new RString("**********");
    private static final RString 文字_高額介護サービス費 = new RString("高額介護サービス費");
    private static final RString 文字_合計 = new RString("合計");
    private FileSpoolManager manager;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200084");
    private RString eucFilePath;
    private static final RString 出力ファイル名
            = new RString("DBC200084_SogojigyohiShinsaKetteiSeikyumeisaihyo.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private static final RString SAKUSEI = new RString("作成");

    @BatchWriter
    private BatchReportWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> reportSourceWriter;
    private CsvWriter<SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity> sogojigyohiKagoKetteiInCsvWriter;

    private SogojigyohiShinsaKetteiSeikyumeisaiInEntity lastEntity;
    private Map<RString, RString> 出力順Map;

    @Override
    protected void initialize() {
        連番 = 0;
        改頁リスト = new ArrayList<>();
        改頁項目名リスト = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        出力順Map = new HashMap<>();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        並び順 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                Long.parseLong(parameter.get出力順ID().toString()));
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.class, 並び順);
        int index = 0;
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目ID());
                改頁項目名リスト.add(item.get項目名());
            }
            if (index == INDEX_1) {
                出力順Map.put(KEY_並び順の２件目, item.get項目名());
            } else if (index == INDEX_2) {
                出力順Map.put(KEY_並び順の３件目, item.get項目名());
            } else if (index == INDEX_3) {
                出力順Map.put(KEY_並び順の４件目, item.get項目名());
            } else if (index == INDEX_4) {
                出力順Map.put(KEY_並び順の５件目, item.get項目名());
            } else if (index == INDEX_5) {
                出力順Map.put(KEY_並び順の６件目, item.get項目名());
            }
            index = index + 1;
        }
        帳票データの取得Parameter.set出力順(出力順);

    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> breaker = new SogojigyohiShinsaKetteiSeikyumeisaiInPageBreak(改頁リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200084.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        sogojigyohiKagoKetteiInCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void keyBreakProcess(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity) {
        SogojigyohiShinsaKetteiSeikyumeisaiInReport report;
        if (null != lastEntity) {
            do帳票のCSVファイル作成(lastEntity, false);
            if (is改頁(lastEntity, entity)) {
                report = new SogojigyohiShinsaKetteiSeikyumeisaiInReport(lastEntity,
                        出力順Map, parameter.getシステム日付(), true, 改頁項目名リスト);
                do帳票のCSVファイル作成(lastEntity, true);
            } else {
                report = new SogojigyohiShinsaKetteiSeikyumeisaiInReport(lastEntity,
                        出力順Map, parameter.getシステム日付(), false, 改頁項目名リスト);
            }
            report.writeBy(reportSourceWriter);
        }
        連番++;
        lastEntity = entity;
    }

    @Override
    protected void afterExecute() {
        SogojigyohiShinsaKetteiSeikyumeisaiInReport report = new SogojigyohiShinsaKetteiSeikyumeisaiInReport(lastEntity,
                出力順Map, RDateTime.now(), true, 改頁項目名リスト);
        report.writeBy(reportSourceWriter);
        do帳票のCSVファイル作成(lastEntity, false);
        do帳票のCSVファイル作成(lastEntity, true);
        sogojigyohiKagoKetteiInCsvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
    }

    private void do帳票のCSVファイル作成(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity, boolean 集計) {
        RDateTime 作成日時 = parameter.getシステム日付();
        SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity output = new SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity();
        DbWT1613SinsaKetteiSeikyuGokeiEntity 審査決定請求合計一時TBL = entity.get審査決定請求合計一時TBL();
        if (連番 == 1) {
            output.set審査年月(パターン56(審査決定請求合計一時TBL.get審査年月()));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(SAKUSEI));
            output.set国保連合会名(審査決定請求合計一時TBL.get国保連合会名());
        } else {
            output.set審査年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set国保連合会名(RString.EMPTY);
        }
        output.set保険者番号(getColumnValue(審査決定請求合計一時TBL.get保険者番号()));
        output.set保険者名(審査決定請求合計一時TBL.get保険者名());
        output.set証記載保険者番号(getColumnValue(審査決定請求合計一時TBL.get証記載保険者番号()));

        if (集計) {
            edit高額介護サービス費項目(entity, output);
            sogojigyohiKagoKetteiInCsvWriter.writeLine(output);
            edit集計項目(entity, output);
            sogojigyohiKagoKetteiInCsvWriter.writeLine(output);
        } else {
            edit明細項目(entity, output);
            sogojigyohiKagoKetteiInCsvWriter.writeLine(output);
        }
    }

    private void edit明細項目(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity, SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity output) {
        DbWT1611SinsaKetteiSeikyuMeisaiEntity 審査決定請求明細一時TBL = entity.get審査決定請求明細一時TBL();
        output.set事業者番号(getColumnValue(審査決定請求明細一時TBL.get事業所番号()));
        output.set事業者名(審査決定請求明細一時TBL.get事業所名());
        output.setサービス提供年月(doパターン54(審査決定請求明細一時TBL.getサービス提供年月()));
        output.setサービス種類名(審査決定請求明細一時TBL.getサービス種類名());
        output.set件数(doカンマ編集(審査決定請求明細一時TBL.get件数()));
        output.set日数_回数(doカンマ編集(審査決定請求明細一時TBL.get日数_回数()));
        output.set単位(doカンマ編集(審査決定請求明細一時TBL.get単位数()));
        output.set金額(doカンマ編集(審査決定請求明細一時TBL.get金額()));
        output.set総合事業費(doカンマ編集(審査決定請求明細一時TBL.get介護給付費_総合事業費()));
        output.set利用者負担額(doカンマ編集(審査決定請求明細一時TBL.get利用者負担額()));
        output.set公費負担額(doカンマ編集(審査決定請求明細一時TBL.get公費負担額()));
    }

    private void edit集計項目(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity, SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity output) {
        DbWT1613SinsaKetteiSeikyuGokeiEntity 審査決定請求合計一時TBL = entity.get審査決定請求合計一時TBL();
        setEmpty(output);
        output.set事業者番号(アステリスク);
        output.set事業者名(文字_合計);
        output.set件数(doカンマ編集(審査決定請求合計一時TBL.get合計_件数()));
        output.set単位(doカンマ編集(審査決定請求合計一時TBL.get合計_単位数()));
        output.set金額(doカンマ編集(審査決定請求合計一時TBL.get合計_金額()));
        output.set総合事業費(doカンマ編集(審査決定請求合計一時TBL.get合計_介護給付費_総合事業費()));
        output.set利用者負担額(doカンマ編集(審査決定請求合計一時TBL.get合計_利用者負担額()));
        output.set公費負担額(doカンマ編集(審査決定請求合計一時TBL.get合計_公費負担額()));
    }

    private void edit高額介護サービス費項目(SogojigyohiShinsaKetteiSeikyumeisaiInEntity entity, SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity output) {
        DbWT1612SinsaKetteiSeikyuKogakuEntity 審査決定請求高額一時TBL = entity.get審査決定請求高額一時TBL();
        setEmpty(output);
        output.set事業者番号(アステリスク);
        output.set事業者名(文字_高額介護サービス費);
        output.set件数(doカンマ編集(審査決定請求高額一時TBL.get高額_高額該当件数()));
        output.set総合事業費(doカンマ編集(審査決定請求高額一時TBL.get高額_高額介護サービス費()));
        output.set公費負担額(doカンマ編集(審査決定請求高額一時TBL.get高額_公費負担額()));
    }

    private boolean is改頁(SogojigyohiShinsaKetteiSeikyumeisaiInEntity currentSource,
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity nextSource) {
        boolean flag = false;
        if (!currentSource.get審査決定請求合計一時TBL().get証記載保険者番号().equals(nextSource.get審査決定請求合計一時TBL().get証記載保険者番号())) {
            flag = true;
        }
        return flag;
    }

    private void setEmpty(SogojigyohiShinsaKetteiSeikyumeisaiInCSVEntity output) {
        output.set審査年月(RString.EMPTY);
        output.set作成日時(RString.EMPTY);
        output.set国保連合会名(RString.EMPTY);
        output.setサービス提供年月(RString.EMPTY);
        output.setサービス種類名(RString.EMPTY);
        output.set件数(RString.EMPTY);
        output.set日数_回数(RString.EMPTY);
        output.set単位(RString.EMPTY);
        output.set金額(RString.EMPTY);
        output.set総合事業費(RString.EMPTY);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
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
