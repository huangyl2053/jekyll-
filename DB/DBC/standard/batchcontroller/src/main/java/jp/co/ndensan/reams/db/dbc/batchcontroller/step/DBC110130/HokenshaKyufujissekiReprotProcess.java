/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.hokenshakyufujisseki.HokenshaKyufujissekiOutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.hokenshakyufujisseki.HokenshaKyufujissekiOutPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki.HokenshaKyufujissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujisseki.HokenshaKyufujissekiReprotCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyuufujisekikoshinnkekka.KyuufuJisekiKoshinnKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
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

/**
 * 保険者保有給付実績情報作成の帳票出力Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiReprotProcess extends BatchKeyBreakBase<KyuufuJisekiKoshinnKekkaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get帳票出力対象データ");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200053.getReportId();
    private static final RString メッセージ引数 = new RString("帳票出力順の取得");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200053");
    private static final RString 出力ファイル名 = new RString("DBC200053_KyufuJisekiJohoSofuIchiran.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 作成R = new RString("作成");
    private static final RString 事業者名不明R = new RString("事業者名不明");
    private static final Code コード = new Code("0003");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString 記号1 = new RString("○");
    private static final RString 記号2 = new RString("◎");
    private static final RString 記号3 = new RString("●");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    private HokenshaKyufujissekiProcessParameter processParameter;
    private HokenshaKyufujissekiMybatisParameter mybatisParam;
    private IOutputOrder 出力順情報;
    private List<RString> pageBreakKeys;
    private List<RString> 出力順リスト;
    private List<RString> 改頁リスト;
    private FileSpoolManager eucManager;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private List<PersonalData> personalDataList;
    private Set<ShikibetsuCode> 識別コードset;
    private int index;
    private int 合計件数;
    private HokenshaNo 保険者番号;
    private KyuufuJisekiKoshinnKekkaEntity 一覧表entity;

    private CsvWriter<HokenshaKyufujissekiReprotCsvEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<KyufuJisekiJohoSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<KyufuJisekiJohoSofuIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        pageBreakKeys = new ArrayList<>();
        識別コードset = new HashSet<>();
        personalDataList = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        保険者番号 = HokenshaNo.EMPTY;
        合計件数 = INT_0;
        index = INT_1;
        一覧表entity = null;
        get出力順();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisParam = processParameter.toHokenshaKyufujissekiMybatisParameter();
        RString 出力順 = MyBatisOrderByClauseCreator.create(HokenshaKyufujissekiOutOrder.class, 出力順情報);
        mybatisParam.set出力順(出力順);
        return new BatchDbReader(READ_DATA_ID, mybatisParam);
    }

    @Override
    protected void createWriter() {
        eucManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = eucManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

        PageBreaker<KyufuJisekiJohoSofuIchiranSource> breakPage = new HokenshaKyufujissekiOutPageBreak(pageBreakKeys);
        batchReportWriter
                = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付).addBreak(breakPage).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(KyuufuJisekiKoshinnKekkaEntity entity) {
        if (!保険者番号.equals(entity.get給付実績一時Entity().getコントロールレコード保険者番号()) && !保険者番号.isEmpty()) {
            HokenshaKyufujissekiReprotCsvEntity csvEntity = getCsvGoukiiEntity();
            eucCsvWriter.writeLine(csvEntity);
            KyufuJisekiJohoSofuIchiranReport report = new KyufuJisekiJohoSofuIchiranReport(
                    一覧表entity, 出力順リスト, 改頁リスト, processParameter.getShoriYM(),
                    processParameter.getNow().getRDateTime(), true, new Decimal(合計件数), index - INT_1);
            report.writeBy(reportSourceWriter);
            保険者番号 = entity.get給付実績一時Entity().getコントロールレコード保険者番号();
            合計件数 = INT_0;
        } else {
            if (一覧表entity != null) {
                KyufuJisekiJohoSofuIchiranReport report = new KyufuJisekiJohoSofuIchiranReport(
                        一覧表entity, 出力順リスト, 改頁リスト, processParameter.getShoriYM(),
                        processParameter.getNow().getRDateTime(), false, new Decimal(合計件数), index - INT_1);
                report.writeBy(reportSourceWriter);
            }
        }
        if (index == INT_1) {
            保険者番号 = entity.get給付実績一時Entity().getコントロールレコード保険者番号();
            HokenshaKyufujissekiReprotCsvEntity csvEntity = getCsvMeisaiEntity(entity);
            RString 処理年月 = processParameter.getShoriYM().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            csvEntity.set送付年月(処理年月);
            csvEntity.set作成日時(getSakuseiYmhm(processParameter.getNow().getRDateTime()));
            eucCsvWriter.writeLine(csvEntity);
        } else {
            HokenshaKyufujissekiReprotCsvEntity csvEntity = getCsvMeisaiEntity(entity);
            eucCsvWriter.writeLine(csvEntity);
        }
        アクセスログ対象追加(entity);
        index = index + INT_1;
        一覧表entity = entity;
        合計件数 = 合計件数 + INT_1;
    }

    @Override
    protected void keyBreakProcess(KyuufuJisekiKoshinnKekkaEntity t) {
    }

    @Override
    protected void afterExecute() {
        if (index != INT_1) {
            HokenshaKyufujissekiReprotCsvEntity csvEntity = getCsvGoukiiEntity();
            eucCsvWriter.writeLine(csvEntity);
            eucCsvWriter.close();
            KyufuJisekiJohoSofuIchiranReport report = new KyufuJisekiJohoSofuIchiranReport(
                    一覧表entity, 出力順リスト, 改頁リスト, processParameter.getShoriYM(),
                    processParameter.getNow().getRDateTime(), true, new Decimal(合計件数), index - INT_1);
            report.writeBy(reportSourceWriter);
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                eucManager.spool(eucFilePath, accessLogUUID);
            } else {
                eucManager.spool(eucFilePath);
            }
        } else {
            eucCsvWriter.close();
        }
    }

    private void アクセスログ対象追加(KyuufuJisekiKoshinnKekkaEntity entity) {
        ShikibetsuCode 識別コード = entity.get被保険者一時Entity().getShikibetsuCode();
        HihokenshaNo 被保険者番号 = entity.get被保険者一時Entity().getExHihokenshaNo();
        if (null == 識別コード || 識別コード.isEmpty() || 識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号, 被保険者番号.getColumnValue());
        personalDataList.add(PersonalData.of(識別コード, expandedInformations));
    }

    private HokenshaKyufujissekiReprotCsvEntity getCsvMeisaiEntity(KyuufuJisekiKoshinnKekkaEntity entity) {
        HokenshaKyufujissekiReprotCsvEntity csvEntity = new HokenshaKyufujissekiReprotCsvEntity();
        csvEntity.set送付年月(RString.EMPTY);
        csvEntity.set作成日時(RString.EMPTY);
        DbWT1001HihokenshaTempEntity 被保険者一時Entity = entity.get被保険者一時Entity();
        DbWT1111KyufuJissekiTempEntity 給付実績一時Entity = entity.get給付実績一時Entity();
        csvEntity.set保険者番号(給付実績一時Entity.getコントロールレコード保険者番号() == null
                ? RString.EMPTY : 給付実績一時Entity.getコントロールレコード保険者番号().getColumnValue());
        csvEntity.set保険者名(
                給付実績一時Entity.getコントロールレコード保険者名() == null ? RString.EMPTY : 給付実績一時Entity.getコントロールレコード保険者名());
        csvEntity.setNo(new RString(index));
        csvEntity.set入力識別番号(
                給付実績一時Entity.get入力識別番号() == null ? RString.EMPTY : 給付実績一時Entity.get入力識別番号().getColumnValue());
        csvEntity.set入力識別名称(給付実績一時Entity.get入力識別名称() == null ? RString.EMPTY : 給付実績一時Entity.get入力識別名称());
        RString 作成区分コード = 給付実績一時Entity.get給付実績情報作成区分コード();
        csvEntity.set作成区分(作成区分コード == null ? RString.EMPTY : 作成区分コード);
        RString 作成区分名 = 作成区分コード == null || 作成区分コード.isEmpty()
                ? RString.EMPTY : CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.給付実績情報作成区分.getコード(),
                        new Code(作成区分コード), FlexibleDate.getNowDate());
        csvEntity.set作成区分名(作成区分名);
        csvEntity.set被保険者番号(被保険者一時Entity.getExHihokenshaNo() == null
                ? RString.EMPTY : 被保険者一時Entity.getExHihokenshaNo().getColumnValue());
        csvEntity.set被保険者カナ氏名(被保険者一時Entity.getKanaMeisho() == null ? RString.EMPTY : 被保険者一時Entity.getKanaMeisho());
        csvEntity.set被保険者氏名(被保険者一時Entity.getMeisho() == null ? RString.EMPTY : 被保険者一時Entity.getMeisho());
        csvEntity = getCsvMeisaiEntity(csvEntity, 給付実績一時Entity);
        csvEntity.set整理番号(給付実績一時Entity.get整理番号() == null ? RString.EMPTY : 給付実績一時Entity.get整理番号());
        csvEntity.set作成レコード種別_01基本(get種別(給付実績一時Entity.get件数_H1()));
        csvEntity.set作成レコード種別_02明細(get種別_明細(給付実績一時Entity.get件数_D1(), 給付実績一時Entity.get件数_DD()));
        csvEntity.set作成レコード種別_03施設(get種別(給付実績一時Entity.get件数_D2()));
        csvEntity.set作成レコード種別_04特診(get種別(給付実績一時Entity.get件数_D3()));
        csvEntity.set作成レコード種別_05食事(get種別(給付実績一時Entity.get件数_D4()));
        csvEntity.set作成レコード種別_06計画(get種別(給付実績一時Entity.get件数_D5()));
        csvEntity.set作成レコード種別_07用具(get種別(給付実績一時Entity.get件数_D6()));
        csvEntity.set作成レコード種別_08住宅(get種別(給付実績一時Entity.get件数_D7()));
        csvEntity.set作成レコード種別_09高額(
                get種別(給付実績一時Entity.get件数_D8() == INT_0 && 給付実績一時Entity.get件数_DE() == INT_0 ? INT_0 : INT_1));
        csvEntity.set作成レコード種別_10集計(get種別(給付実績一時Entity.get件数_T1()));
        csvEntity.set作成レコード種別_11特定(get種別(給付実績一時Entity.get件数_D9()));
        csvEntity.set作成レコード種別_12社福(get種別(給付実績一時Entity.get件数_DA()));
        csvEntity.set作成レコード種別_13所定(get種別(給付実績一時Entity.get件数_DC()));
        csvEntity.set合計件数(RString.EMPTY);
        return csvEntity;
    }

    private HokenshaKyufujissekiReprotCsvEntity getCsvMeisaiEntity(HokenshaKyufujissekiReprotCsvEntity csvEntity,
            DbWT1111KyufuJissekiTempEntity 給付実績一時Entity) {
        csvEntity.setサービス提供年月(給付実績一時Entity.getサービス提供年月() == null || 給付実績一時Entity.getサービス提供年月().isEmpty()
                ? RString.EMPTY : 給付実績一時Entity.getサービス提供年月().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        RString 給付実績区分 = 給付実績一時Entity.get給付実績区分();
        csvEntity.set給付実績区分(給付実績区分 == null ? RString.EMPTY : 給付実績区分);
        RString 給付実績区分名 = 給付実績区分 == null || 給付実績区分.isEmpty()
                ? RString.EMPTY : CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.給付実績区分.getコード(),
                        new Code(給付実績区分), FlexibleDate.getNowDate());
        csvEntity.set給付実績区分名(給付実績区分名);
        csvEntity.set事業者番号(給付実績一時Entity.get事業所番号() == null ? RString.EMPTY : 給付実績一時Entity.get事業所番号().getColumnValue());
        if (給付実績一時Entity.get事業所番号() != null && !給付実績一時Entity.get事業所番号().isEmpty()
                && (給付実績一時Entity.get事業者名称() == null || 給付実績一時Entity.get事業者名称().isEmpty())) {
            csvEntity.set事業者名(事業者名不明R);
        } else {
            csvEntity.set事業者名(給付実績一時Entity.get事業者名称());
        }
        return csvEntity;
    }

    private HokenshaKyufujissekiReprotCsvEntity getCsvGoukiiEntity() {
        DbWT1111KyufuJissekiTempEntity 給付実績一時Entity = 一覧表entity.get給付実績一時Entity();
        HokenshaKyufujissekiReprotCsvEntity csvEntity = new HokenshaKyufujissekiReprotCsvEntity();
        csvEntity.set送付年月(RString.EMPTY);
        csvEntity.set作成日時(RString.EMPTY);
        csvEntity.set保険者番号(給付実績一時Entity.getコントロールレコード保険者番号() == null
                ? RString.EMPTY : 給付実績一時Entity.getコントロールレコード保険者番号().getColumnValue());
        csvEntity.set保険者名(給付実績一時Entity.getコントロールレコード保険者名() == null ? RString.EMPTY : 給付実績一時Entity.getコントロールレコード保険者名());
        csvEntity.setNo(RString.EMPTY);
        csvEntity.set入力識別番号(RString.EMPTY);
        csvEntity.set入力識別名称(RString.EMPTY);
        csvEntity.set作成区分(RString.EMPTY);
        csvEntity.set作成区分名(RString.EMPTY);
        csvEntity.set被保険者番号(RString.EMPTY);
        csvEntity.set被保険者カナ氏名(RString.EMPTY);
        csvEntity.set被保険者氏名(RString.EMPTY);
        csvEntity.setサービス提供年月(RString.EMPTY);
        csvEntity.set給付実績区分(RString.EMPTY);
        csvEntity.set給付実績区分名(RString.EMPTY);
        csvEntity.set事業者番号(RString.EMPTY);
        csvEntity.set事業者名(RString.EMPTY);
        csvEntity.set整理番号(RString.EMPTY);
        csvEntity.set作成レコード種別_01基本(RString.EMPTY);
        csvEntity.set作成レコード種別_02明細(RString.EMPTY);
        csvEntity.set作成レコード種別_03施設(RString.EMPTY);
        csvEntity.set作成レコード種別_04特診(RString.EMPTY);
        csvEntity.set作成レコード種別_05食事(RString.EMPTY);
        csvEntity.set作成レコード種別_06計画(RString.EMPTY);
        csvEntity.set作成レコード種別_07用具(RString.EMPTY);
        csvEntity.set作成レコード種別_08住宅(RString.EMPTY);
        csvEntity.set作成レコード種別_09高額(RString.EMPTY);
        csvEntity.set作成レコード種別_10集計(RString.EMPTY);
        csvEntity.set作成レコード種別_11特定(RString.EMPTY);
        csvEntity.set作成レコード種別_12社福(RString.EMPTY);
        csvEntity.set作成レコード種別_13所定(RString.EMPTY);
        csvEntity.set合計件数(new RString(合計件数));
        return csvEntity;
    }

    private RString get種別_明細(int 値1, int 値2) {
        if (INT_1 <= 値1) {
            return INT_1 <= 値2 ? 記号2 : 記号1;
        } else {
            return INT_1 <= 値2 ? 記号3 : RString.EMPTY;
        }
    }

    private RString get種別(int 値) {
        if (INT_1 <= 値) {
            return 記号1;
        }
        return RString.EMPTY;
    }

    private RString getSakuseiYmhm(RDateTime datetime) {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成R);
        return sakuseiYMD.toRString();
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processParameter.getShutsuryokujunId())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票ID, Long.parseLong(processParameter.getShutsuryokujunId().toString()));
        }
        if (出力順情報 == null) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(メッセージ引数.toString()).evaluate());
        }
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            出力順リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
                改頁リスト.add(item.get項目名());
            }
        }
    }
}
