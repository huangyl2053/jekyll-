/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC160010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa.KyotakuServiceKeikakuSaList;
import jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa.KyotakuServiceKeikakuSaParam;
import jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa.KyotakuServiceKeikakuSaReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakutodokede.kyotakuTodokede_ErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.keikakutodokedejokyo.KeikakuTodokedeJokyoProcessParam;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
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
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 出力データ抽出処理です。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public class KeikakuTodokedeJokyoIchiranProcess extends BatchProcessBase<KeikakuTodokedeJokyoIchiranEntity> {

    private RDateTime システム日付;
    private IOutputOrder 並び順;
    private RString 出力順;
    private List<RString> breakItemIds;
    private KyotakuServiceKeikakuSaList outputReport;
    private HihokenshaNo 被保険者番号_前;
    private FileSpoolManager manager;
    private RString 申請日;
    private RString 対象者;
    private RString 届出状況;
    private FlexibleDate 基準日;
    private RString 作成日時;
    private RString 受給申請年月日;
    private RString 受給申請事由;
    private RString 受給申請日From;
    private RString 受給申請日To;
    private int count;
    private boolean flag;
    private KeikakuTodokedeJokyoProcessParam processParameter;
    @BatchWriter
    private BatchReportWriter<KyotakuServiceKeikakuSakuseiSource> batchReportWriter;
    private ReportSourceWriter<KyotakuServiceKeikakuSakuseiSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KeikakuTodokedeJokyoIchiranCsvEntity> csvWriter;

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".keikakutodokedejokyoichiran.IKeikakuTodokedeJokyoIchiranMapper.getデータを抽出");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString 仕切る = new RString("～");
    private static final RString 仕切る_2 = new RString(":");
    private static final RString MESSAGE_1 = new RString("計画届出状況抽出処理");
    private static final RString 定値_届出なし = new RString("届出なし");
    private static final RString 定値_有効なし = new RString("有効なし");
    private static final RString 定値_事業者無効 = new RString("事業者無効");
    private static final RString 定値_時 = new RString("時");
    private static final RString 定値_分 = new RString("分");
    private static final RString 定値_秒 = new RString("秒");
    private static final RString RS_0000 = new RString("0000");
    private static final RString RS_1 = new RString("1");
    private static final RString RS_3 = new RString("3");
    private static final RString 受給者申請中者のみ = new RString("受給申請中者のみ");
    private static final RString 全受給者_施設含む = new RString("全受給者（施設含む）");
    private static final RString 未提出者のみ = new RString("未提出者のみ");
    private static final RString 提出者のみ = new RString("提出者のみ");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString 一覧EUCエンティティID = new RString("DBC900004");
    private static final RString CSVFILENAME = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    @Override
    protected void initialize() {
        count = INDEX_0;
        breakItemIds = new ArrayList<>();
        flag = true;
        システム日付 = RDateTime.now();

        if (processParameter.getJyukyuushinseibiFrom() != null) {
            受給申請日From = processParameter.getJyukyuushinseibiFrom().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else {
            受給申請日From = RString.EMPTY;
        }
        if (processParameter.getJyukyuushinseibiTo() != null) {
            受給申請日To = processParameter.getJyukyuushinseibiTo().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else {
            受給申請日To = RString.EMPTY;
        }
        申請日 = 受給申請日From.concat(仕切る).concat(受給申請日To);
        対象者 = processParameter.getTaisyoushatyuusyutu();
        届出状況 = processParameter.getTodokeidejyoukyou();
        基準日 = processParameter.getKijyunbi();

        並び順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200060.getReportId(), processParameter.getShutsuryokujunId());
        if (並び順 != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    KeikakuTodokedeJokyoIchiranOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY);
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    breakItemIds.add(item.get項目ID());
                }
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        builder.set基準日(processParameter.getKijyunbi());
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        KeikakuTodokedeJokyoIchiranParameter parameterDB = new KeikakuTodokedeJokyoIchiranParameter(searchKey,
                processParameter.getKijyunbi(), processParameter.getKijyunbi().getYearMonth(), 出力順);
        return new BatchDbReader(MAPPERPATH, parameterDB);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200060.getReportId().value())
                .addBreak(new KeikakuTodokedeJokyoIchiranPageBreak(breakItemIds)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), CSVFILENAME)).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(KeikakuTodokedeJokyoIchiranEntity entity) {
        if (entity.get識別コード() == null) {
            if (flag) {
                RTime time = システム日付.getTime();
                RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
                RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
                RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
                RString timeFormat = hour.concat(定値_時).concat(min).concat(定値_分).concat(sec).concat(定値_秒);
                作成日時 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(timeFormat);
                flag = false;
            } else {
                作成日時 = RString.EMPTY;
            }
            KeikakuTodokedeJokyoIchiranCsvEntity csvEntity = new KeikakuTodokedeJokyoIchiranCsvEntity(作成日時,
                    MESSAGE_1,
                    entity.get被保険者番号().getColumnValue(),
                    kyotakuTodokede_ErrorListType.リストタイプ0.get名称(),
                    RString.EMPTY);
            csvWriter.writeLine(csvEntity);
        }
        if (entity.get宛名() == null) {
            if (flag) {
                RTime time = システム日付.getTime();
                RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
                RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
                RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
                RString timeFormat = hour.concat(定値_時).concat(min).concat(定値_分).concat(sec).concat(定値_秒);
                作成日時 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(timeFormat);
                flag = false;
            } else {
                作成日時 = RString.EMPTY;
            }
            KeikakuTodokedeJokyoIchiranCsvEntity csvEntity = new KeikakuTodokedeJokyoIchiranCsvEntity(作成日時,
                    MESSAGE_1,
                    entity.get被保険者番号().getColumnValue(),
                    kyotakuTodokede_ErrorListType.リストタイプ1.get名称(),
                    RString.EMPTY);
            csvWriter.writeLine(csvEntity);
        }

        if (check(entity)) {
            return;
        }

        if (!entity.get被保険者番号().equals(被保険者番号_前) && 被保険者番号_前 != null) {
            count = count + INDEX_1;
            KyotakuServiceKeikakuSaParam param = new KyotakuServiceKeikakuSaParam();
            param.set計画届出状況情報リスト(outputReport);
            param.setシステム日時(システム日付);
            param.set申請日(申請日);
            param.set対象者(対象者);
            param.set届出状況(届出状況);
            param.set基準日(基準日);
            param.set地方公共団体(AssociationFinderFactory.createInstance().getAssociation());
            param.set出力順(並び順);
            param.set連番(count);
            KyotakuServiceKeikakuSaReport report = new KyotakuServiceKeikakuSaReport(param);
            report.writeBy(reportSourceWriter);
            outputReport = null;
        }

        KyotakuServiceKeikakuSaList reportList
                = new KyotakuServiceKeikakuSaList();

        setReportList(entity, reportList);

        if (outputReport != null) {
            受給申請年月日 = RString.EMPTY;
            受給申請事由 = RString.EMPTY;
            if (entity.get受給申請年月日() != null) {
                受給申請年月日 = new RString(entity.get受給申請年月日().toString());
            }
            if (entity.get受給申請事由() != null) {
                受給申請事由 = JukyuShinseiJiyu.toValue(entity.get受給申請事由().getColumnValue()).get名称();
            }
            outputReport.set現在の申請状況(受給申請年月日.concat(仕切る_2).concat(受給申請事由));
        } else {
            outputReport = reportList;
        }
        被保険者番号_前 = entity.get被保険者番号();

    }

    @Override
    protected void afterExecute() {
        if (outputReport != null) {
            count = count + INDEX_1;
            KyotakuServiceKeikakuSaParam param = new KyotakuServiceKeikakuSaParam();
            param.set計画届出状況情報リスト(outputReport);
            param.setシステム日時(システム日付);
            param.set申請日(申請日);
            param.set対象者(対象者);
            param.set届出状況(届出状況);
            param.set基準日(基準日);
            param.set地方公共団体(AssociationFinderFactory.createInstance().getAssociation());
            param.set出力順(並び順);
            param.set連番(count);
            KyotakuServiceKeikakuSaReport report = new KyotakuServiceKeikakuSaReport(param);
            report.writeBy(reportSourceWriter);
        }
        csvWriter.close();
        manager.spool(Path.combinePath(manager.getEucOutputDirectry(), CSVFILENAME));
    }

    private void setReportList(KeikakuTodokedeJokyoIchiranEntity entity, KyotakuServiceKeikakuSaList reportList) {
        reportList.set被保険者番号(entity.get被保険者番号());
        reportList.set識別コード(entity.get識別コード());
        reportList.set宛名(entity.get宛名());
        reportList.set資格取得日(entity.get資格取得年月日());
        reportList.set資格喪失日(entity.get資格喪失年月日());
        if (entity.get資格喪失事由コード() != null) {
            reportList.set喪失事由(ShikakuSoshitsuJiyu.toValue(entity.get資格喪失事由コード()).get名称());
        }
        reportList.set受給申請日(entity.get受給申請年月日());
        if (entity.get受給申請事由() != null) {
            reportList.set申請事由(JukyuShinseiJiyu.toValue(entity.get受給申請事由().getColumnValue()).get名称());
        }
        if (entity.get要介護認定状態区分コード() != null && !entity.get要介護認定状態区分コード().isEmpty()) {
            reportList.set要介護度(YokaigoJotaiKubun.toValue(entity.get要介護認定状態区分コード().getColumnValue()).get名称());
        }
        reportList.set認定有効開始日(entity.get認定有効期間開始日());
        reportList.set認定有効終了日(entity.get認定有効期間終了日());
        reportList.set認定日(entity.get認定年月日());
        reportList.set市町村コード(entity.get市町村コード());
        reportList.set計画届出日(entity.get計画届出日());
        reportList.set計画適用開始日(entity.get適用開始年月日());
        reportList.set計画適用終了日(entity.get適用終了年月日());
        reportList.set事業者番号(entity.get事業者番号());
        reportList.set電話番号(entity.get電話番号());
        reportList.set変更年月日(entity.get変更年月日());
        reportList.set事業者名称(entity.get事業者名称());
        if (entity.get対象年月() == null
                || entity.get対象年月().isEmpty()) {
            reportList.set備考1(定値_届出なし);
        } else if (entity.get適用終了年月日() != null
                && !entity.get適用終了年月日().isEmpty()
                && processParameter.getKijyunbi() != null
                && !processParameter.getKijyunbi().isEmpty()
                && entity.get適用終了年月日().isBefore(processParameter.getKijyunbi())) {
            reportList.set備考1(定値_有効なし);
        }
        if (!RS_3.equals(entity.get作成区分コード())
                && (entity.get事業者名称() == null
                || entity.get事業者名称().isEmpty())) {
            reportList.set備考2(定値_事業者無効);
        }
    }

    private boolean check(KeikakuTodokedeJokyoIchiranEntity entity) {
        if (processParameter.getJyukyuushinseibiFrom() != null
                && !processParameter.getJyukyuushinseibiFrom().isEmpty()
                && entity.get受給申請年月日() != null
                && !entity.get受給申請年月日().isEmpty()
                && entity.get受給申請年月日().isBefore(processParameter.getJyukyuushinseibiFrom())) {
            return true;
        }
        if (processParameter.getJyukyuushinseibiTo() != null
                && !processParameter.getJyukyuushinseibiTo().isEmpty()
                && entity.get受給申請年月日() != null
                && !entity.get受給申請年月日().isEmpty()
                && processParameter.getJyukyuushinseibiTo().isBefore(entity.get受給申請年月日())) {
            return true;
        }
        if (受給者申請中者のみ.equals(processParameter.getTaisyoushatyuusyutu())
                && !RS_0000.equals(entity.get履歴番号())) {
            return true;
        }
        if (全受給者_施設含む.equals(processParameter.getTaisyoushatyuusyutu())
                && !(RS_1.equals(entity.get住所地特例フラグ())
                && (entity.get資格喪失年月日() == null
                || entity.get資格喪失年月日().isEmpty()
                || !entity.get資格取得年月日().equals(entity.get資格喪失年月日())))) {
            return true;
        }
        return check2(entity);
    }

    private boolean check2(KeikakuTodokedeJokyoIchiranEntity entity) {
        if (!全受給者_施設含む.equals(processParameter.getTaisyoushatyuusyutu())
                && !(entity.get施設フラウ() == null
                || entity.get施設フラウ().isEmpty())) {
            return true;
        }
        if (未提出者のみ.equals(processParameter.getTodokeidejyoukyou())
                && (entity.get居宅給付計画届出_被保険者番号() == null
                || ((entity.get適用終了年月日() != null
                && !entity.get適用終了年月日().isEmpty())
                && entity.get適用終了年月日().isBefore(processParameter.getKijyunbi())))) {
            return true;
        }
        return 提出者のみ.equals(processParameter.getTodokeidejyoukyou())
                && (entity.get適用開始年月日() != null
                && !entity.get適用開始年月日().isEmpty()
                && entity.get適用開始年月日().isBeforeOrEquals(processParameter.getKijyunbi()))
                && (entity.get適用終了年月日() == null
                || entity.get適用終了年月日().isEmpty()
                || processParameter.getKijyunbi().isBeforeOrEquals(entity.get適用終了年月日()));
    }

}
