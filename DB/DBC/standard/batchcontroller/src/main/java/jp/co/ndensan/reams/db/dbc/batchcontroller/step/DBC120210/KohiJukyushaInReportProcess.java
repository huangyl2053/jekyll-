/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費公費受給者別一覧表情報取込の一覧表作成を実行する。
 *
 * @reamsid_L DBC-2800-010 duanzhanli
 */
public class KohiJukyushaInReportProcess extends BatchKeyBreakBase<SogojigyohiKohiJukyushaEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikohijukyusha."
                    + "ISogojigyohiKohiJukyushaMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200008");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString SAKUSEI = new RString("作成");
    private final Code code = new Code("0003");
    private final RString 漢字_被保険者番号 = new RString("被保険者番号");
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
    private static final RString 出力ファイル名
            = new RString("DBC200008_KohijukyushaBetsuIchiran.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番 = 1;
    private final RString 固定改頁項目ID = new RString("0134");
    private final RString 固定出力順 = new RString("DbWT6411.\"kohiJukyushaNo\" ASC");
    private FileSpoolManager manager;
    private IOutputOrder 出力順情報;
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private List<RString> pageBreakKeys;
    private List<RString> 改頁リスト;
    private Map<RString, RString> 出力順Map;
    private Set<ShikibetsuCode> 識別コードset;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private RString eucFilePath;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private SogojigyohiKohiJukyushaEntity lastEntity;
    private RDateTime 作成日時;

    @BatchWriter
    private BatchReportWriter<KohijukyushaBetsuIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<KohijukyushaBetsuIchiranReportSource> reportSourceWriter;
    private CsvWriter<SogojigyohiKohiJukyushaCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        作成日時 = parameter.getシステム日付();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        this.出力順情報 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == this.出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        出力順Map = new HashMap<>();
        pageBreakKeys = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        pageBreakKeys.add(固定改頁項目ID);
        RString orderByStr = MyBatisOrderByClauseCreator.create(SogojigyohiKohiJukyushaOutPutOrder.class, 出力順情報);
        orderByStr = orderByStr.concat(コンマ).concat(固定出力順);
        int i = 0;
        this.改頁リスト = new ArrayList();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
            }
            if (i == INDEX_1) {
                出力順Map.put(KEY_並び順の２件目, item.get項目名());
            } else if (i == INDEX_2) {
                出力順Map.put(KEY_並び順の３件目, item.get項目名());
            } else if (i == INDEX_3) {
                出力順Map.put(KEY_並び順の４件目, item.get項目名());
            } else if (i == INDEX_4) {
                出力順Map.put(KEY_並び順の５件目, item.get項目名());
            } else if (i == INDEX_5) {
                出力順Map.put(KEY_並び順の６件目, item.get項目名());
            }
            i = i + 1;
        }
        識別コードset = new HashSet();
        帳票データの取得Parameter.set出力順(orderByStr);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KohijukyushaBetsuIchiranReportSource> breaker = new KohijukyushaBetsuIchiranPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200008.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void keyBreakProcess(SogojigyohiKohiJukyushaEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiKohiJukyushaEntity entity) {
        アクセスログ対象追加(entity);
        SogojigyohiKohiJukyushaEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            Boolean 集計Flag = get集計Flag(beforeEntity, entity);
            KohijukyushaBetsuIchiranReport report = new KohijukyushaBetsuIchiranReport(getReportData(beforeEntity), 集計Flag);
            report.writeBy(reportSourceWriter);
            this.do帳票のCSVファイル作成(beforeEntity, 集計Flag);
            連番++;
        }
        lastEntity = entity;
    }

    private KohijukyushaBetsuIchiranBusiness getReportData(SogojigyohiKohiJukyushaEntity entity) {
        KohijukyushaBetsuIchiranBusiness business = new KohijukyushaBetsuIchiranBusiness();
        business.set作成日時(作成日時);
        business.set審査年月(entity.get審査年月());
        business.set国保連合会名(entity.get国保連合会名());
        business.set公費負担者番号(entity.get公費負担者番号());
        business.set公費負担者名(entity.get公費負担者名());
        business.set公費受給者番号(entity.get公費受給者番号());
        business.setサービス提供年月(entity.getサービス提供年月());
        business.set事業所番号(entity.get事業者番号());
        business.set事業所名(entity.get事業者名());
        business.setサービス種類名(entity.getサービス種類名());
        business.setサービス項目名(entity.getサービス項目名());
        business.set日数回数(entity.get日数回数());
        business.set公費対象単位数(entity.get公費対象単位数());
        business.set公費負担金額(entity.get公費負担金額());
        business.set公費分本人負担額(entity.get公費分本人負担額());
        business.set登録被保険者番号(entity.get登録被保険者番号());
        business.set宛名名称(entity.get宛名名称());
        business.set証記載保険者番号(entity.get証記載保険者番号());
        business.set公費対象単位数集計(entity.get公費対象単位数集計());
        business.set公費負担金額集計(entity.get公費負担金額集計());
        business.set公費分本人負担額集計(entity.get公費分本人負担額集計());
        business.set並び順1(get並び順(KEY_並び順の２件目));
        business.set並び順2(get並び順(KEY_並び順の３件目));
        business.set並び順3(get並び順(KEY_並び順の４件目));
        business.set並び順4(get並び順(KEY_並び順の５件目));
        business.set並び順5(get並び順(KEY_並び順の６件目));
        business.set改頁1(get改頁(INDEX_1));
        business.set改頁2(get改頁(INDEX_2));
        business.set改頁3(get改頁(INDEX_3));
        business.set改頁4(get改頁(INDEX_4));
        business.set改頁5(get改頁(INDEX_5));
        return business;
    }

    private RString get並び順(RString 並び順Key) {
        RString 出力順 = RString.EMPTY;
        if (出力順Map.containsKey(並び順Key)) {
            出力順 = 出力順Map.get(並び順Key);
        }
        return 出力順;
    }

    private RString get改頁(int index) {
        RString 改頁 = RString.EMPTY;
        if (index < 改頁リスト.size()) {
            改頁 = 改頁リスト.get(index);
        }
        return 改頁;
    }

    @Override
    protected void afterExecute() {
        KohijukyushaBetsuIchiranReport report = new KohijukyushaBetsuIchiranReport(getReportData(lastEntity), true);
        report.writeBy(reportSourceWriter);
        this.do帳票のCSVファイル作成(lastEntity, true);
        csvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void do帳票のCSVファイル作成(SogojigyohiKohiJukyushaEntity entity, boolean 集計Flag) {
        if (集計Flag) {
            csv明細作成(entity);
            csv集計作成(entity);
        } else {
            csv明細作成(entity);
        }
    }

    private void csv明細作成(SogojigyohiKohiJukyushaEntity entity) {
        SogojigyohiKohiJukyushaCsvEntity output = new SogojigyohiKohiJukyushaCsvEntity();
        if (連番 == 1) {
            output.set審査年月(get審査年月(entity.get審査年月()));
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
        output.set公費負担者番号(entity.get公費負担者番号());
        output.set公費負担者名(entity.get公費負担者名());
        output.set公費受給者番号(entity.get公費受給者番号());
        output.setサービス提供年月(doパターン54(entity.getサービス提供年月()));
        output.set事業者番号(entity.get事業者番号());
        output.set事業者名(entity.get事業者名());
        output.setサービスコード(entity.getサービスコード());
        output.setサービス種類名(entity.getサービス種類名());
        output.setサービス項目名(entity.getサービス項目名());
        output.set日数_回数(doカンマ編集(entity.get日数回数()));
        output.set公費対象単位数(doカンマ編集(entity.get公費対象単位数()));
        output.set公費負担金額(doカンマ編集(entity.get公費負担金額()));
        output.set公費分本人負担額(doカンマ編集(entity.get公費分本人負担額()));
        output.set被保険者番号(getColumnValue(entity.get被保険者番号()));
        output.set被保険者氏名(entity.get宛名名称());
        output.set証記載保険者番号(getColumnValue(entity.get証記載保険者番号()));
        output.set公費対象単位数集計(RString.EMPTY);
        output.set公費分本人負担額集計(RString.EMPTY);
        output.set公費負担金額集計(RString.EMPTY);
        csvWriter.writeLine(output);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString get審査年月(FlexibleYearMonth value) {
        RString 審査年月 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            審査年月 = value.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 審査年月;
    }

    private void csv集計作成(SogojigyohiKohiJukyushaEntity entity) {
        SogojigyohiKohiJukyushaCsvEntity output = new SogojigyohiKohiJukyushaCsvEntity();
        output.set公費負担者番号(entity.get公費負担者番号());
        output.set公費負担者名(entity.get公費負担者名());
        output.set公費受給者番号(RString.EMPTY);
        output.setサービス提供年月(RString.EMPTY);
        output.set事業者番号(RString.EMPTY);
        output.set事業者名(RString.EMPTY);
        output.setサービスコード(RString.EMPTY);
        output.setサービス種類名(RString.EMPTY);
        output.setサービス項目名(RString.EMPTY);
        output.set日数_回数(RString.EMPTY);
        output.set公費対象単位数(RString.EMPTY);
        output.set公費負担金額(RString.EMPTY);
        output.set公費分本人負担額(RString.EMPTY);
        output.set被保険者番号(RString.EMPTY);
        output.set被保険者氏名(RString.EMPTY);
        output.set証記載保険者番号(RString.EMPTY);
        output.set公費対象単位数集計(doカンマ編集(entity.get公費対象単位数集計()));
        output.set公費分本人負担額集計(doカンマ編集(entity.get公費分本人負担額集計()));
        output.set公費負担金額集計(doカンマ編集(entity.get公費負担金額集計()));
        csvWriter.writeLine(output);
    }

    private void アクセスログ対象追加(SogojigyohiKohiJukyushaEntity entity) {
        if (null == entity.get識別コード() || entity.get識別コード().isEmpty()) {
            return;
        }
        if (識別コードset.contains(entity.get識別コード())) {
            return;
        }
        識別コードset.add(entity.get識別コード());
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(SogojigyohiKohiJukyushaEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 漢字_被保険者番号,
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param beforeEntity SogojigyohiKohiJukyushaEntity
     * @param currentEntity SogojigyohiKohiJukyushaEntity
     * @return 改頁Flag
     */
    public boolean get集計Flag(SogojigyohiKohiJukyushaEntity beforeEntity,
            SogojigyohiKohiJukyushaEntity currentEntity) {
        return this.pageBreakKeys.contains(SogojigyohiKohiJukyushaOutPutOrder.公費負担者番号.get項目ID())
                && !beforeEntity.get公費負担者番号().equals(currentEntity.get公費負担者番号());
    }

    private RString doカンマ編集(RString number) {
        if (null == number) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(number)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(number.toString()), 0);
        }
        return number;
    }
}
