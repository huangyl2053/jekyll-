/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200025.ShokanRenrakuhyoSofuIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200025.ShokanRenrakuhyoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran.ShokanRenrakuhyoSofuIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran.ShokanRenrakuhyoSofuIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran.ShokanRenrakuhyoSofuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoSofuIchiranParam;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutputReportProcessParam;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.ShokanRenrakuhyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanrenrakuhyooutputreport.ShokanRenrakuhyoOutputReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票出力のクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
public class ShokanRenrakuhyoOutputReportProcess extends BatchKeyBreakBase<ShokanRenrakuhyoOutputReportEntity> {

    private static final RString ERROR_出力順 = new RString("帳票出力順の取得");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString 送付一覧表出力対象データ取得 = new RString("jp.co.ndensan.reams.db.dbc.persistence"
            + ".db.mapper.relate.dbc110050.IShokanRenrakuhyoOutMapper.get送付一覧表出力対象データ");
    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の2件目 = new RString("KEY_並び順の2件目");
    private static final RString KEY_並び順の3件目 = new RString("KEY_並び順の3件目");
    private static final RString KEY_並び順の4件目 = new RString("KEY_並び順の4件目");
    private static final RString KEY_並び順の5件目 = new RString("KEY_並び順の5件目");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString 定値_時 = new RString("時");
    private static final RString 定値_分 = new RString("分");
    private static final RString 定値_秒 = new RString("秒");
    private static final RString 一覧EUCエンティティID = new RString("DBC200025");
    private static final RString CSVFILENAME = new RString("DBC200025_ShokanRenrakuhyoSofuIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 丸 = new RString("●");
    private static final Code コード = new Code("0003");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");

    private BatchReportWriter<ShokanRenrakuhyoSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<ShokanRenrakuhyoSofuIchiranSource> reportSourceWriter;
    private CsvWriter<ShokanRenrakuhyoSofuIchiranCsvEntity> csvWriter;
    private List<PersonalData> personalDataList;
    private Set<RString> 識別コードset;
    private IOutputOrder 並び順;
    private RString 出力順;
    private Map<RString, RString> 出力順Map;
    private List<RString> breakItemIds;
    private ShokanRenrakuhyoOutputReportProcessParam processParameter;
    private FileSpoolManager manager;
    private RDateTime システム日付;
    private int count;
    private RString csvFilePath;

    @Override
    protected void initialize() {
        システム日付 = RDateTime.now();
        count = INDEX_0;
        breakItemIds = new ArrayList<>();
        personalDataList = new ArrayList<>();
        識別コードset = new HashSet<>();
        出力順Map = new HashMap<>();
        並び順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200025.getReportId(), processParameter.getShutsuryokujunId());
        if (並び順 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(ERROR_出力順.toString()));
        }
        出力順 = MyBatisOrderByClauseCreator.create(
                ShokanRenrakuhyoSofuIchiranOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY);

        int i = INDEX_0;
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                breakItemIds.add(item.get項目ID());
            }
            if (i == INDEX_0) {
                出力順Map.put(KEY_並び順の1件目, item.get項目名());
            } else if (i == INDEX_1) {
                出力順Map.put(KEY_並び順の2件目, item.get項目名());
            } else if (i == INDEX_2) {
                出力順Map.put(KEY_並び順の3件目, item.get項目名());
            } else if (i == INDEX_3) {
                出力順Map.put(KEY_並び順の4件目, item.get項目名());
            } else if (i == INDEX_4) {
                出力順Map.put(KEY_並び順の5件目, item.get項目名());
            }
            i = i + 1;
        }
    }

    @Override
    protected IBatchReader createReader() {
        ShokanRenrakuhyoSofuIchiranParam parameterDB = new ShokanRenrakuhyoSofuIchiranParam();
        parameterDB.set送付除外フラグ(false);
        parameterDB.setOrderBy(出力順);
        return new BatchDbReader(送付一覧表出力対象データ取得, parameterDB);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        csvFilePath = Path.combinePath(manager.getEucOutputDirectry(), CSVFILENAME);
    }

    @Override
    protected void keyBreakProcess(ShokanRenrakuhyoOutputReportEntity entity) {
    }

    @Override
    protected void usualProcess(ShokanRenrakuhyoOutputReportEntity entity) {
        if (count == INDEX_0) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200025.getReportId().value())
                    .addBreak(new ShokanRenrakuhyoSofuIchiranPageBreak(breakItemIds)).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            csvWriter = new CsvWriter.InstanceBuilder(csvFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
        }
        count = count + INDEX_1;
        ShokanRenrakuhyoSofuIchiranParameter reportParam = new ShokanRenrakuhyoSofuIchiranParameter();
        ShokanRenrakuhyoSofuIchiranEntity reportEntity = new ShokanRenrakuhyoSofuIchiranEntity();
        reportEntity.set償還払支給申請一時TBL(entity.get償還払支給申請一時TBL());
        reportEntity.set被保険者一時TBL(entity.get被保険者一時TBL());
        reportEntity.set基本_事業者番号(entity.get基本_事業者番号());
        reportEntity.set基本_様式番号(entity.get基本_様式番号());
        reportEntity.set識別番号_略称(entity.get識別番号_略称());
        reportParam.set償還連絡票一覧表データ(reportEntity);
        reportParam.set出力順Map(出力順Map);
        reportParam.set処理年月(processParameter.getSyoriYM());
        reportParam.set作成日時(システム日付);
        ShokanRenrakuhyoSofuIchiranReport report = new ShokanRenrakuhyoSofuIchiranReport(reportParam);
        report.writeBy(reportSourceWriter);

        アクセスログ対象追加(entity);
        ShokanRenrakuhyoSofuIchiranCsvEntity csvEntity = editCsvEntity(entity);
        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        if (INDEX_0 < count) {
            batchReportWriter.close();
            csvWriter.close();
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                manager.spool(csvFilePath, accessLogUUID);
            } else {
                manager.spool(csvFilePath);
            }
        }
    }

    private ShokanRenrakuhyoSofuIchiranCsvEntity editCsvEntity(ShokanRenrakuhyoOutputReportEntity entity) {
        RString 送付年月 = RString.EMPTY;
        if (processParameter.getSyoriYM() != null) {
            送付年月 = processParameter.getSyoriYM().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }

        RTime time = システム日付.getTime();
        RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat(定値_時).concat(min).concat(定値_分).concat(sec).concat(定値_秒);
        RString 作成日時 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(timeFormat);

        RString 保険者番号 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getHokenshaNo() != null) {
            保険者番号 = entity.get償還払支給申請一時TBL().getHokenshaNo().getColumnValue();
        }
        RString 保険者名 = entity.get償還払支給申請一時TBL().getHokenshaName();
        RString 整理番号 = entity.get償還払支給申請一時TBL().getSeiriNo();
        RString 証記載保険者番号 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getShoKisaiHokenshaNo() != null) {
            証記載保険者番号 = entity.get償還払支給申請一時TBL().getShoKisaiHokenshaNo().getColumnValue();
        }
        RString 被保険者番号 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getHiHokenshaNo() != null) {
            被保険者番号 = entity.get償還払支給申請一時TBL().getHiHokenshaNo().getColumnValue();
        }
        RString 被保険者氏名 = entity.get被保険者一時TBL().getMeisho();
        RString 旧措置 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().isKyuSochishaFlag()) {
            旧措置 = 丸;
        }
        RString 要介護状態区分コード = entity.get償還払支給申請一時TBL().getYokaigoJotaiKubunCode();
        RString 要介護状態区分 = RString.EMPTY;
        RString サービス提供年月 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getServiceTeikyoYM() != null) {
            サービス提供年月 = entity.get償還払支給申請一時TBL().getServiceTeikyoYM().wareki()
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            IYokaigoJotaiKubun 要介護区分 = YokaigoJotaiKubunSupport.toValue(entity.get償還払支給申請一時TBL().getServiceTeikyoYM(),
                    entity.get償還払支給申請一時TBL().getYokaigoJotaiKubunCode());
            要介護状態区分 = 要介護区分.getName();
        }
        RString 認定有効開始年月日 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getNinteiYukoKikanKaishiYMD() != null) {
            認定有効開始年月日 = entity.get償還払支給申請一時TBL().getNinteiYukoKikanKaishiYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        RString 認定有効終了年月日 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getNinteiYukoKikanShuryoYMD() != null) {
            認定有効終了年月日 = entity.get償還払支給申請一時TBL().getNinteiYukoKikanShuryoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        RString 保険請求額 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getHokenKyufugaku() != null) {
            保険請求額 = DecimalFormatter.toコンマ区切りRString(entity.get償還払支給申請一時TBL().getHokenKyufugaku(), INDEX_0);
        }
        RString 自己負担額 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getRiyoshaFutangaku() != null) {
            自己負担額 = DecimalFormatter.toコンマ区切りRString(entity.get償還払支給申請一時TBL().getRiyoshaFutangaku(), INDEX_0);
        }
        RString 支払合計金額 = RString.EMPTY;
        if (entity.get償還払支給申請一時TBL().getShiharaiKingakuTotal() != null) {
            支払合計金額 = DecimalFormatter.toコンマ区切りRString(entity.get償還払支給申請一時TBL().getShiharaiKingakuTotal(), INDEX_0);
        }
        RString 様式番号 = entity.get基本_様式番号();
        RString 備考 = entity.get識別番号_略称();
        ShokanRenrakuhyoSofuIchiranCsvEntity csvEntity = new ShokanRenrakuhyoSofuIchiranCsvEntity(送付年月, 作成日時,
                保険者番号, 保険者名,
                new RString(count), 整理番号,
                サービス提供年月, 証記載保険者番号,
                被保険者番号, 被保険者氏名,
                旧措置, 要介護状態区分コード,
                要介護状態区分, 認定有効開始年月日,
                認定有効終了年月日, 保険請求額,
                自己負担額, 支払合計金額,
                様式番号, 備考);
        return csvEntity;
    }

    private void アクセスログ対象追加(ShokanRenrakuhyoOutputReportEntity entity) {
        DbWT1001HihokenshaTempEntity 被保険者 = entity.get被保険者一時TBL();
        RString 識別コード = 被保険者.getSeibetsuCode();
        RString 宛名情報 = 被保険者.getMeisho();
        if (null == 識別コード || 識別コード.isEmpty()
                || null == 宛名情報 || 宛名情報.isEmpty()) {
            return;
        }
        if (識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        PersonalData personalData = getPersonalData(被保険者);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(DbWT1001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号,
                entity.getExHihokenshaNo().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.getSeibetsuCode()), expandedInformations);
    }
}
