/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanKofuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKeitai;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060.KogakugassanShikyushinseishoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110060.KogakugassanShikyushinseishoOutCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * DBCMNF1001-371_高額合算支給申請書情報作成のバッチ帳票出力_送付Processです。
 *
 * @reamsid_L DBC-2630-030 sunqingzhu
 */
public class KogakugassanShikyushinseishoOutShinseishoReportProcess
        extends BatchKeyBreakBase<KogakugassanShikyushinseishoOutFileEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get送付一覧表出力対象データ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名 = new RString("DBC200027_GassanShikyuShinseishoJohoSofuIchiran.csv");
    private static final int INT_1 = 1;
    private static final int INT_30 = 30;
    private static final RString 作成R = new RString("作成");
    private static final RString 再送要 = new RString("※");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200027");
    private static final Code コード = new Code("0003");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString 固定改頁項目 = new RString("重複フラグ");
    private static final RString 年度R = new RString("年度");

    private KogakugassanShikyushinseishoOutProcessParameter processParameter;
    private List<RString> pageBreakKeys;
    private FileSpoolManager eucManager;
    private RString eucFilePath;
    private int index;
    private List<PersonalData> personalDataList;
    private Set<ShikibetsuCode> 識別コードset;
    private RDateTime システム日付;
    private int count;

    private CsvWriter<KogakugassanShikyushinseishoOutCsvEntity> eucCsvWriter;
    private BatchReportWriter<GassanShikyuShinseishoJohoSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanShikyuShinseishoJohoSofuIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        識別コードset = new HashSet<>();
        personalDataList = new ArrayList<>();
        index = INT_1;
        pageBreakKeys = new ArrayList<>();
        システム日付 = RDateTime.now();
        count = INT_1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void usualProcess(KogakugassanShikyushinseishoOutFileEntity entity) {
        if (index == INT_1) {
            pageBreakKeys.add(固定改頁項目);
            PageBreaker<GassanShikyuShinseishoJohoSofuIchiranSource> breaker
                    = new GassanShikyuShinseishoJohoSofuIchiranPageBreak(pageBreakKeys);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200027.getReportId().getColumnValue())
                    .addBreak(breaker).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            eucManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = eucManager.getEucOutputDirectry();
            eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                    .setDelimiter(コンマ)
                    .setEnclosure(ダブル引用符)
                    .setEncode(Encode.UTF_8withBOM)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true)
                    .build();
        }
        KogakugassanShikyushinseishoOutFileEntity beforeEntity = getBefore();
        if (!entity.get高額合算申請書一時Entity().isJufukuKubun()) {
            count = INT_1;
        }
        boolean flag = true;
        if (beforeEntity != null) {
            flag = is同一申請情報(beforeEntity.get高額合算申請書一時Entity(), entity.get高額合算申請書一時Entity(), count);
        }
        GassanShikyuShinseishoJohoSofuIchiranReport report
                = new GassanShikyuShinseishoJohoSofuIchiranReport(entity, YMDHMS.now(), processParameter.get処理年月(), index, flag);
        report.writeBy(reportSourceWriter);
        KogakugassanShikyushinseishoOutCsvEntity csvEntity = getCsvEntity(index, entity);
        eucCsvWriter.writeLine(csvEntity);
        アクセスログ対象追加(entity);
        index = index + INT_1;
        count = count + INT_1;
    }

    @Override
    protected void keyBreakProcess(KogakugassanShikyushinseishoOutFileEntity t) {
    }

    @Override
    protected void afterExecute() {
        if (index != INT_1) {
            eucCsvWriter.close();
            batchReportWriter.close();
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                eucManager.spool(eucFilePath, accessLogUUID);
            } else {
                eucManager.spool(eucFilePath);
            }
        }
    }

    private boolean is同一申請情報(DbWT3711KogakuGassanShinseishoTempEntity beforeEntity,
            DbWT3711KogakuGassanShinseishoTempEntity entity, int count) {
        boolean flg = true;
        if (beforeEntity.getShikyuShinseishoSeiriNo().equals(entity.getShikyuShinseishoSeiriNo())
                && beforeEntity.getRirekiNo().equals(entity.getRirekiNo())) {
            if (count > INT_30 && count % INT_30 == INT_1) {
                flg = true;
            } else if (entity.isJufukuKubun()) {
                flg = false;
            }
        }
        return flg;
    }

    private void アクセスログ対象追加(KogakugassanShikyushinseishoOutFileEntity entity) {
        ShikibetsuCode 識別コード = entity.get被保険者一時Entity().getShikibetsuCode();
        HihokenshaNo 被保険者番号 = entity.get被保険者一時Entity().getExHihokenshaNo();
        if (null == 識別コード || 識別コード.isEmpty() || 識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号, 被保険者番号.getColumnValue());
        personalDataList.add(PersonalData.of(識別コード, expandedInformations));
    }

    private KogakugassanShikyushinseishoOutCsvEntity getCsvEntity(int flag, KogakugassanShikyushinseishoOutFileEntity entity) {
        KogakugassanShikyushinseishoOutCsvEntity csvEntity = new KogakugassanShikyushinseishoOutCsvEntity();
        if (flag == INT_1) {
            RString 処理年月 = processParameter.get処理年月().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            csvEntity.set送付年月(処理年月);
            csvEntity.set作成日時(getSakuseiYmhm(システム日付));
        }
        csvEntity.set保険者番号(processParameter.get保険者情報_保険者番号());
        csvEntity.set保険者名(processParameter.get保険者情報_保険者名称());

        DbWT3711KogakuGassanShinseishoTempEntity 一時Entity = entity.get高額合算申請書一時Entity();
        csvEntity.setNo(new RString(flag));
        FlexibleYear 対象年度 = 一時Entity.getTaishoNendo();
        RString 対象年度R = 対象年度 == null || 対象年度.isEmpty() ? RString.EMPTY : 対象年度.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(年度R);
        csvEntity.set申請年度(対象年度R);
        csvEntity.set支給申請区分(一時Entity.getShikyuShinseiKubun());
        if (一時Entity.getShikyuShinseiKubun() != null) {
            csvEntity.set支給申請区分名(KaigoGassan_ShinseiKbn.toValue(一時Entity.getShikyuShinseiKubun()).get名称());
        }
        csvEntity.set申請年月日(getFromatDate(一時Entity.getShinseiYMD()));
        csvEntity.set支給申請書整理番号(一時Entity.getShikyuShinseishoSeiriNo());
        if (null != 一時Entity.getShinseiDaihyoshaShimei()) {
            csvEntity.set申請代表者氏名(一時Entity.getShinseiDaihyoshaShimei().getColumnValue());
        }
        csvEntity.set自己負担額証明交付申請有無区分(一時Entity.getJikoFutanKofuUmu());
        if (一時Entity.getJikoFutanKofuUmu() != null) {
            csvEntity.set自己負担額証明交付申請有無(KaigoGassan_JikoFutanKofuUmu.toValue(一時Entity.getJikoFutanKofuUmu()).get名称());
        }
        csvEntity.set支給申請形態(一時Entity.getShikyuShinseiKeitai());
        if (一時Entity.getShikyuShinseiKeitai() != null) {
            csvEntity.set支給申請形態名(KaigoGassan_ShinseiKeitai.toValue(一時Entity.getShikyuShinseiKeitai()).get名称());
        }
        HihokenshaNo 被保険者番号 = 一時Entity.getHihokenshaNo();
        RString 被保険者番号R = 被保険者番号 == null || 被保険者番号.isEmpty() ? RString.EMPTY : 被保険者番号.getColumnValue();
        csvEntity.set被保険者番号(被保険者番号R);
        csvEntity.set被保険者氏名(entity.get被保険者一時Entity().getMeisho());
        csvEntity.set介護加入期間開始年月日(getFromatDate(一時Entity.getKanyuKaishiYMD()));
        csvEntity.set介護加入期間終了年月日(getFromatDate(一時Entity.getKanyuShuryoYMD()));
        csvEntity.set所得区分(一時Entity.getShotokuKubun());
        if (一時Entity.getShotokuKubun() != null) {
            csvEntity.set所得区分名(KaigoGassan_ShotokuKbn.toValue(一時Entity.getShotokuKubun()).get名称());
        }
        csvEntity.set所得区分_70歳以上分(一時Entity.getOver70_ShotokuKubun());
        if (一時Entity.getOver70_ShotokuKubun() != null) {
            csvEntity.set所得区分名_70歳以上分(KaigoGassan_Over70_ShotokuKbn.toValue(一時Entity.getOver70_ShotokuKubun()).get名称());
        }
        csvEntity.set支給方法区分(一時Entity.getShiharaiHohoKubun());
        if (一時Entity.getShiharaiHohoKubun() != null) {
            csvEntity.set支給方法名(ShiharaiHohoKubun.toValue(一時Entity.getShiharaiHohoKubun()).get名称());
        }
        RString 再送 = KokuhorenDataSaisoFlag.再送要.getコード().equals(一時Entity.getSaiSofuFlag()) ? 再送要 : RString.EMPTY;
        csvEntity.set再送(再送);
        if (一時Entity.isJufukuKubun()) {
            csvEntity.set重複(再送要);
        } else {
            csvEntity.set重複(RString.EMPTY);
        }

        return csvEntity;
    }

    private RString getFromatDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY : date.wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getSakuseiYmhm(RDateTime datetime) {
        RString 作成日 = datetime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(作成R);
    }

}
