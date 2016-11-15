/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanfushikyuketteiin.ShokanFushikyuKetteiInCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
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
 * 償還払不支給決定情報取込バッチ処理クラス．一覧表作成を実行する
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuKetteiInProcess extends BatchKeyBreakBase<ShokanFushikyuKetteiInEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfushikyuketteiin."
                    + "IShokanFushikyuKetteiInMapper.select一時テーブル");
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目;
    private Map<RString, RString> 出力順Map;
    private static final int 文字20 = 20;
    private static final RString コンマ = new RString(",");
    private static final RString 更新DB有無_有 = new RString("1");
    private static final RString アスタリスク = new RString("*");
    private Set<ShikibetsuCode> 識別コードset = new HashSet();
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
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200022");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    private ShokanFushikyuKetteiInEntity lastentity;
    private List<RString> pageBreakKeys;
    private static final RString SAKUSEI = new RString("作成");

    private static final RString 出力ファイル名
            = new RString("DBC200022_ShokanbaraiFushikyuKetteishaIchiran.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString ダブル引用符 = new RString("\"");
    @BatchWriter
    private CsvWriter eucCsvWriter;
    private BatchReportWriter<ShokanbaraiFushikyuKetteishaIchiranSource> batchReportWriter;
    private ReportSourceWriter<ShokanbaraiFushikyuKetteishaIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        改頁項目 = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        識別コードset = new HashSet<>();
        出力順Map = new HashMap<>();
        lastentity = new ShokanFushikyuKetteiInEntity();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        並び順 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());

        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(ShokanFushikyuKetteiInOutPutOrder.class, 並び順);
        帳票データの取得Parameter.set出力順(出力順);
        改頁項目.add(new RString(ShokanbaraiFushikyuKetteishaIchiranSource.ReportSourceFields.shoKisaiHokenshaNo.name()));
        pageBreakKeys.add(new RString(ShokanbaraiFushikyuKetteishaIchiranSource.ReportSourceFields.shoKisaiHokenshaNo.name()));
        int index = 0;
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目() && index != 0) {
                改頁項目.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
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
    }

    @Override
    protected void createWriter() {
        PageBreaker<ShokanbaraiFushikyuKetteishaIchiranSource> breaker
                = new ShokanFushikyuKetteiInPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
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
    protected void keyBreakProcess(ShokanFushikyuKetteiInEntity entity) {

    }

    @Override
    protected void usualProcess(ShokanFushikyuKetteiInEntity entity) {
        boolean flag = entity.get国保連合会名().equals(lastentity.get国保連合会名());
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200022.getReportId().getColumnValue(), GyomuBunrui.介護事務);
        RString 編集住所 = 住所Editor.editJusho(
                entity.get管内管外区分(), entity.get住所(), entity.get番地(), entity.get方書(), entity.get行政区名(), entity.get市町村コード());
        ShokanFushikyuKetteiInReport report = new ShokanFushikyuKetteiInReport(
                entity,
                出力順Map,
                改頁項目,
                parameter.getシステム日付(),
                編集住所);
        report.writeBy(reportSourceWriter);
        do帳票のCSVファイル作成(entity, parameter.getシステム日付(), 編集住所, flag);
        lastentity = entity;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        batchReportWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void do帳票のCSVファイル作成(
            ShokanFushikyuKetteiInEntity entity,
            RDateTime 作成日時,
            RString 編集住所,
            boolean flag) {
        ShokanFushikyuKetteiInCSVEntity output = new ShokanFushikyuKetteiInCSVEntity();
        if (!flag) {
            output.set処理年月(パターン56(parameter.get処理年月()));
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            output.set国保連合会名(entity.get国保連合会名());
        }
        output.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
        output.set証記載保険者名(entity.get証記載保険者名());
        output.set決定通知(entity.get決定通知());
        output.set整理番号(entity.get整理番号());
        output.set被保険者番号(entity.get被保険者番号().getColumnValue());
        output.set被保険者氏名(entity.get被保険者氏名());
        output.set町域コード(entity.get町域コード());
        output.set住所(編集住所.substringReturnAsPossible(0, 文字20));
        output.set行政区コード(entity.get行政区コード());
        output.set行政区名(entity.get行政区名());
        if (entity.get事業者番号() != null) {
            output.set事業者番号(entity.get事業者番号().getColumnValue());
        }
        output.set事業者名(entity.get事業者名());
        output.setサービス提供年月(entity.getサービス提供年月().wareki().separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString());
        output.setサービス種類コード(entity.getサービス種類コード().getColumnValue());
        RString サービス種類名 = (null == entity.getサービス種類名()) ? RString.EMPTY : entity.getサービス種類名();
        output.setサービス種類(サービス種類名);
        output.set単位数(doカンマ編集(entity.get単位数()));
        output.set喪失事由コード(entity.get資格喪失事由コード());
        output.set喪失事由(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                new Code(entity.get資格喪失事由コード())));
        output.set資格喪失日(entity.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        output.set備考1(entity.get備考1());
        output.set備考2(entity.get備考2());
        if (更新DB有無_有.equals(entity.get更新DB無())) {
            output.set更新DB無(アスタリスク);
        } else {
            output.set更新DB無(RString.EMPTY);
        }
        eucCsvWriter.writeLine(output);
        if (null != entity.get識別コード() && !entity.get識別コード().isEmpty()
                && !識別コードset.contains(entity.get識別コード())) {
            PersonalData personalData = getPersonalData(entity);
            personalDataList.add(personalData);
            識別コードset.add(entity.get識別コード());

        }
    }

    private PersonalData getPersonalData(ShokanFushikyuKetteiInEntity chohyoEntity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                chohyoEntity.get被保険者番号().getColumnValue());
        return PersonalData.of(chohyoEntity.get識別コード(), expandedInformations);
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
