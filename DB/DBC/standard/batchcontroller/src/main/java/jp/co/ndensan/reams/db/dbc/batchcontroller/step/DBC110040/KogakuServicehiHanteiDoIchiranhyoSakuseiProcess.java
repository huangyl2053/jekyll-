/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110040;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteikekkaout.KogakuServicehiHanteiDoIchiranhyoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteikekkaout.KogakuServicehiHanteiDoIchiranhyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout.KogakuServicehiHanteiDoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額サービス費給付判定結果情報作成・一覧表作成を実行する。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<KogakuServicehiHanteiIchiranhyoTaisyoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuservicehihanteikekkaout."
                    + "IKogakuServicehiHanteikekkaOutJohoMapper.get帳票出力対象データ");
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private KogakuServicehiHanteiDoIchiranhyoSakuseiProcessParameter parameter;
    private static final int INT_0 = 0;
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
    private static final RString 固定付加出力順 = new RString(" , DbWT3411.\"hihokenshaNo\" ASC, DbWT3411.\"serviceTeikyoYM\" ASC");
    private static final RString 出力ファイル名 = new RString("DBC200019_KogakuServicehiKyufuHanteiKekkaSofuIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200019");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 固定改頁項目ID = new RString("0365");
    private static final RString 作成 = new RString("作成");
    private static final RString CODE = new RString("0003");
    private static final RString スペース = new RString(" ");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private int 連番 = 0;
    private CsvWriter csvWriter;
    private BatchReportWriter<KogakuServicehiSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuServicehiSofuIchiranSource> reportSourceWriter;

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
        RString 出力順 = MyBatisOrderByClauseCreator.create(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.class, 並び順);
        if (null != 並び順) {
            int i = 0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                    改頁リスト.add(item.get項目ID());
                }
                if (i == INT_0) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INT_1) {
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
        PageBreaker<KogakuServicehiSofuIchiranSource> breaker = new KogakuServicehiHanteiDoIchiranhyoPageBreak(改頁リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KogakuServicehiHanteiIchiranhyoTaisyoEntity t) {

    }

    @Override
    protected void usualProcess(KogakuServicehiHanteiIchiranhyoTaisyoEntity currentEntity) {
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
        KogakuServicehiHanteiIchiranhyoTaisyoEntity beforeEntity = getBefore();
        KogakuServicehiHanteiDoIchiranCSVEntity output;
        if (null == beforeEntity) {
            output = 書き込むデータ作成(currentEntity, true);
            csvWriter.writeLine(output);
        } else {

            output = 書き込むデータ作成(currentEntity, false);
            csvWriter.writeLine(output);

        }
        KogakuServicehiSofuIchiranReport report = new KogakuServicehiSofuIchiranReport(
                currentEntity, 出力順リスト, 改頁項目リスト, parameter.get処理年月(), parameter.getシステム日付(), 連番);
        report.writeBy(reportSourceWriter);
        if (null != currentEntity.get被保険者_識別コード() && !currentEntity.get被保険者_識別コード().isEmpty()
                && !識別コードset.contains(currentEntity.get被保険者_識別コード())) {
            識別コードset.add(currentEntity.get被保険者_識別コード());
            personalDataList.add(getPersonalData(currentEntity));
        }
    }

    @Override
    protected void afterExecute() {
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

    private PersonalData getPersonalData(KogakuServicehiHanteiIchiranhyoTaisyoEntity entity) {
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

    private KogakuServicehiHanteiDoIchiranCSVEntity 書き込むデータ作成(KogakuServicehiHanteiIchiranhyoTaisyoEntity 出力データ, boolean ヘッダーフラグ) {
        KogakuServicehiHanteiDoIchiranCSVEntity csvEntity = new KogakuServicehiHanteiDoIchiranCSVEntity();
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
        csvEntity.set保険者番号(getColumnValue(出力データ.get高額介護_保険者番号()));
        csvEntity.set保険者名(出力データ.get高額介護_保険者名());
        csvEntity.setNo(new RString(連番));
        csvEntity.set被保険者番号(getColumnValue(出力データ.get高額介護_被保険者番号()));
        csvEntity.set被保険者カナ氏名(出力データ.get被保険者_宛名カナ名称());
        csvEntity.set被保険者氏名(出力データ.get被保険者_宛名名称());
        csvEntity.set町域コード(出力データ.get被保険者_町域コード());
        csvEntity.set郵便番号(get郵便番号(new YubinNo(出力データ.get被保険者_郵便番号())));
        csvEntity.set住所(編集住所(出力データ.get被保険者_住所(), 出力データ.get被保険者_番地(), 出力データ.get被保険者_方書()));
        csvEntity.set行政区コード(出力データ.get被保険者_行政区コード());
        csvEntity.set行政区(出力データ.get被保険者_行政区名());
        csvEntity.setサービス提供年月(doパターン54(出力データ.get高額介護_サービス提供年月()));
        csvEntity.set支給区分(出力データ.get高額介護_支給区分コード());
        if (!RString.isNullOrEmpty(出力データ.get高額介護_支給区分コード())) {
            csvEntity.set支給区分名(ShikyuKubun.toValue(出力データ.get高額介護_支給区分コード()).get名称());
        }
        csvEntity.set審査方法(出力データ.get高額介護_審査方法区分());
        if (!RString.isNullOrEmpty(出力データ.get高額介護_審査方法区分())) {
            csvEntity.set審査方法名(ShinsaHohoKubun.toValue(出力データ.get高額介護_審査方法区分()).get名称());
        }
        csvEntity.set受付年月日(doパターン4(出力データ.get高額介護_受付年月日()));
        csvEntity.set決定年月日(doパターン4(出力データ.get高額介護_決定年月日()));
        csvEntity.set本人支払額(doカンマ編集(出力データ.get高額介護_本人支払額()));
        csvEntity.set支給額(doカンマ編集(出力データ.get高額介護_支給金額()));
        csvEntity.set不支給理由(出力データ.get高額介護_不支給理由());
        return csvEntity;
    }

    private RString 編集住所(RString 住所, RString 番地, RString 方書) {
        住所 = 住所 != null ? 住所 : RString.EMPTY;
        番地 = 番地 != null ? 番地 : RString.EMPTY;
        方書 = 方書 != null ? 方書 : RString.EMPTY;
        return 住所.concat(番地).concat(スペース).concat(方書);
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

    private RString get郵便番号(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.getEditedYubinNo();
    }
}
