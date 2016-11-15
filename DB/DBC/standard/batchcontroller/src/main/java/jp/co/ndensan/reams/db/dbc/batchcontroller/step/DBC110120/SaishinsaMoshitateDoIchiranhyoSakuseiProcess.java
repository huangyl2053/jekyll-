/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsamoshitateshoout.SaishinsaMoshitateDoIchiranhyoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsamoshitateshoout.SaishinsaMoshitateDoIchiranhyoPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsamoshitateshoout.SaishinsaMoshitateDoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費再審査申立書情報作成・一覧表作成を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<SaishinsaMoshitateIchiranhyoTaisyoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsamoshitateshoout."
                    + "ISaishinsaMoshitateshoOutJohoMapper.get帳票出力対象データ");
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter parameter;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private IOutputOrder 並び順;
    private Set<ShikibetsuCode> 識別コードset;
    private List<RString> 改頁項目リスト;
    private List<RString> 出力順リスト;
    private List<RString> 改頁リスト;
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString 固定付加出力順 = new RString(" , DbWT1741.\"renban\" ASC");
    private static final RString 出力ファイル名 = new RString("DBC200047_KyufuSaishinsaMoshitateshojohoSofuIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200047");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 固定改頁項目ID = new RString("0103");
    private static final RString 作成 = new RString("作成");
    private static final RString CODE = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private SaishinsaMoshitateIchiranhyoTaisyoEntity lastEntity;
    private int 連番 = 0;
    private int 連番_NO = 0;
    private int 合計件数 = 0;
    private CsvWriter csvWriter;
    private BatchReportWriter<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        識別コードset = new HashSet<>();
        改頁項目リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        改頁リスト.add(固定改頁項目ID);
        並び順 = get並び順();
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator.create(SaishinsaMoshitateDoIchiranhyoOutPutOrder.class, 並び順);
        if (null != 並び順) {
            int i = 0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                    改頁リスト.add(item.get項目ID());
                }
                if (i == INT_1) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INT_2) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INT_3) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INT_4) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INT_5) {
                    出力順リスト.add(item.get項目名());
                }
                i = i + 1;
            }
        }
        出力順 = 出力順.concat(固定付加出力順);
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        帳票データの取得Parameter.set出力順(出力順);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> breaker = new SaishinsaMoshitateDoIchiranhyoPageBreak(改頁リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(SaishinsaMoshitateIchiranhyoTaisyoEntity t) {

    }

    @Override
    protected void usualProcess(SaishinsaMoshitateIchiranhyoTaisyoEntity currentEntity) {
        if (null == csvWriter) {
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
        連番 = 連番 + 1;
        SaishinsaMoshitateIchiranhyoTaisyoEntity beforeEntity = getBefore();
        SaishinsaMoshitateDoIchiranCSVEntity output;
        if (null == beforeEntity) {
            合計件数 = 合計件数 + 1;
            output = 書き込むデータ作成(currentEntity, true);
            csvWriter.writeLine(output);
        } else {
            if (is改頁(beforeEntity, currentEntity)) {
                output = 集計項目作成(beforeEntity);
                csvWriter.writeLine(output);
                連番_NO = 連番_NO + 1;
                KyufuSaishinsaMoshitateshojohoSofuIchiranReport report = new KyufuSaishinsaMoshitateshojohoSofuIchiranReport(
                        beforeEntity, 出力順リスト, 改頁項目リスト,
                        new FlexibleYearMonth(parameter.get処理年月().toDateString()), parameter.getシステム日付(), 連番_NO, true, new Decimal(合計件数));
                report.writeBy(reportSourceWriter);
                合計件数 = 1;
                output = 書き込むデータ作成(currentEntity, false);
                csvWriter.writeLine(output);
            } else {
                合計件数 = 合計件数 + 1;
                output = 書き込むデータ作成(currentEntity, false);
                csvWriter.writeLine(output);
                連番_NO = 連番_NO + 1;
                KyufuSaishinsaMoshitateshojohoSofuIchiranReport report = new KyufuSaishinsaMoshitateshojohoSofuIchiranReport(
                        beforeEntity, 出力順リスト, 改頁項目リスト, new FlexibleYearMonth(parameter.get処理年月().toDateString()),
                        parameter.getシステム日付(), 連番_NO, false, new Decimal(合計件数));
                report.writeBy(reportSourceWriter);
            }
        }
        lastEntity = currentEntity;
        if (null != currentEntity.get被保険者_識別コード() && !currentEntity.get被保険者_識別コード().isEmpty()
                && !識別コードset.contains(currentEntity.get被保険者_識別コード())) {
            識別コードset.add(currentEntity.get被保険者_識別コード());
            personalDataList.add(getPersonalData(currentEntity));
        }
    }

    @Override
    protected void afterExecute() {
        if (null != lastEntity) {
            連番_NO = 連番_NO + 1;
            SaishinsaMoshitateDoIchiranCSVEntity output = 集計項目作成(lastEntity);
            csvWriter.writeLine(output);
            KyufuSaishinsaMoshitateshojohoSofuIchiranReport report = new KyufuSaishinsaMoshitateshojohoSofuIchiranReport(
                    lastEntity, 出力順リスト, 改頁項目リスト,
                    new FlexibleYearMonth(parameter.get処理年月().toDateString()), parameter.getシステム日付(), 連番_NO, true, new Decimal(合計件数));
            report.writeBy(reportSourceWriter);
            合計件数 = 0;
        }
        if (null != csvWriter) {
            csvWriter.close();
            if (null != personalDataList && !personalDataList.isEmpty()) {
                AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                manager.spool(eucFilePath, log);
            } else {
                manager.spool(eucFilePath);
            }
        }
        batchReportWriter.close();
    }

    private PersonalData getPersonalData(SaishinsaMoshitateIchiranhyoTaisyoEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code(CODE), 被保険者番号,
                getColumnValue(entity.get被保険者_被保険者番号()));
        return PersonalData.of(entity.get被保険者_識別コード(), expandedInformations);
    }

    private IOutputOrder get並び順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        return order;
    }

    private SaishinsaMoshitateDoIchiranCSVEntity 書き込むデータ作成(SaishinsaMoshitateIchiranhyoTaisyoEntity 出力データ, boolean ヘッダーフラグ) {
        SaishinsaMoshitateDoIchiranCSVEntity csvEntity = new SaishinsaMoshitateDoIchiranCSVEntity();
        if (ヘッダーフラグ) {
            csvEntity.set送付年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = parameter.getシステム日付().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(作成);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        } else {
            csvEntity.set送付年月(RString.EMPTY);
            csvEntity.set作成日時(RString.EMPTY);
        }
        csvEntity.set証記載保険者番号(getColumnValue(出力データ.get再審査申立_証記載保険者番号()));
        csvEntity.set証記載保険者名(出力データ.get再審査申立_証記載保険者名());
        csvEntity.setNo(new RString(連番));
        csvEntity.set事業者番号(getColumnValue(出力データ.get再審査申立_事業所番号()));
        csvEntity.set事業者名(出力データ.get再審査申立_事業者名());
        csvEntity.set被保険者番号(getColumnValue(出力データ.get再審査申立_被保険者番号()));
        csvEntity.set被保険者カナ氏名(出力データ.get被保険者_宛名カナ名称());
        csvEntity.set被保険者氏名(出力データ.get被保険者_宛名名称());
        csvEntity.setサービス提供年月(doパターン54(出力データ.get再審査申立_サービス提供年月()));
        csvEntity.setサービスコード(getColumnValue(出力データ.get再審査申立_サービス種類コード())
                .concat(getColumnValue(出力データ.get再審査申立_サービス項目コード())));
        csvEntity.setサービス名称(出力データ.get再審査申立_サービス名称());
        csvEntity.set申立年月日(doパターン4(出力データ.get再審査申立_申立年月日()));
        csvEntity.set申立点数(doカンマ編集(new Decimal(出力データ.get再審査申立_申立単位数())));
        csvEntity.set申立事由コード(出力データ.get再審査申立_申立事由コード());
        if (!RString.isNullOrEmpty(出力データ.get再審査申立_申立事由コード())) {
            RString 申立事由_1 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査申立事由コード_上２桁_申立対象項目コード.getコード(),
                    new Code(出力データ.get再審査申立_申立事由コード()));
            csvEntity.set申立事由1(申立事由_1);
            RString 申立事由_2 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査申立事由コード_下２桁_申立理由番号.getコード(),
                    new Code(出力データ.get再審査申立_申立事由コード()));
            csvEntity.set申立事由2(申立事由_2);
        }
        return csvEntity;
    }

    private SaishinsaMoshitateDoIchiranCSVEntity 集計項目作成(SaishinsaMoshitateIchiranhyoTaisyoEntity 出力データ) {
        SaishinsaMoshitateDoIchiranCSVEntity csvEntity = new SaishinsaMoshitateDoIchiranCSVEntity();
        csvEntity.set証記載保険者番号(getColumnValue(出力データ.get再審査申立_証記載保険者番号()));
        csvEntity.set証記載保険者名(出力データ.get再審査申立_証記載保険者名());
        csvEntity.set合計件数(doカンマ編集(new Decimal(合計件数)));
        return csvEntity;
    }

    private boolean is改頁(SaishinsaMoshitateIchiranhyoTaisyoEntity currentData,
            SaishinsaMoshitateIchiranhyoTaisyoEntity nextData) {
        boolean flag = false;
        if (!currentData.get再審査申立_証記載保険者番号().equals(nextData.get再審査申立_証記載保険者番号())) {
            flag = true;
        }
        return flag;
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
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
