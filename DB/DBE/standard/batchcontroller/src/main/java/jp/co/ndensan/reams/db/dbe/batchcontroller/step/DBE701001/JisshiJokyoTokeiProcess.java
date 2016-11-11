package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JisshiJokyoTokeiEditor;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei.JisshiJokyoTokeiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JisshiJokyoTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JisshiJokyoTokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況統計情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JisshiJokyoTokeiProcess extends BatchKeyBreakBase<JisshiJokyoTokeiEntity> {

    private static final RString SELECT_JISSHIJOKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getJisshiJokyoTokei");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JisshiJokyoTokeiReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString HIHOKENSYAKUBUN = new RString("【被保険者区分】");
    private static final RString GOGITAINO = new RString("【合議体番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
    private static final RString タイトル = new RString("要介護認定実施状況統計");
    private static final RString 開始年月日 = new RString("最初から");
    private static final RString 終了年月日 = new RString("最終まで");
    private static final RString 申請受付数タイトル = new RString("申請受付人数");
    private static final RString 調査実施数タイトル = new RString("調査実施人数");
    private static final RString 審査会実施数タイトル = new RString("審査会開実施人数");
    private static final RString 認定結果数タイトル = new RString("認定結果人数");
    private static final RString 新規申請タイトル = new RString("新規");
    private static final RString 更新申請タイトル = new RString("更新");
    private static final RString 区分変更申請タイトル = new RString("区分変更");
    private static final RString 合計タイトル = new RString("合計");
    private JisshiJokyoTokeiProcessParameter parameter;
    private JisshiJokyoTokei jisshiJokyoTokei;
    private boolean isデータあり;
    @BatchWriter
    private BatchReportWriter<JisshiJokyoTokeiReportSource> batchWriter;
    private ReportSourceWriter<JisshiJokyoTokeiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        jisshiJokyoTokei = new JisshiJokyoTokei();
        setヘッダー項目();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JISSHIJOKYO, parameter.toJisshiJokyoTokeiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701003.getReportId().value())
                .addBreak(new BreakerCatalog<JisshiJokyoTokeiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(JisshiJokyoTokeiEntity current) {
        if (hasBrek(getBefore(), current)) {
            JisshiJokyoTokeiReport report = new JisshiJokyoTokeiReport(jisshiJokyoTokei);
            report.writeBy(reportSourceWriter);
            jisshiJokyoTokei = new JisshiJokyoTokei();
            setヘッダー項目();
        }
    }

    @Override
    protected void usualProcess(JisshiJokyoTokeiEntity current) {
        isデータあり = true;
        new JisshiJokyoTokeiEditor(parameter, current, jisshiJokyoTokei).set要介護認定事業状況();
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            new JisshiJokyoTokeiEditor(parameter, null, jisshiJokyoTokei).set合計();
            JisshiJokyoTokeiReport report = new JisshiJokyoTokeiReport(jisshiJokyoTokei);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyo();
    }

    private boolean hasBrek(JisshiJokyoTokeiEntity before, JisshiJokyoTokeiEntity current) {
        return !(before.getShichosonCode().equals(current.getShichosonCode()));
    }

    private void setヘッダー項目() {
        jisshiJokyoTokei.setタイトル(タイトル);
        set開始終了年月日();
        jisshiJokyoTokei.set発行日時(RDateTime.now());
        jisshiJokyoTokei.set申請受付数タイトル(申請受付数タイトル);
        jisshiJokyoTokei.set調査実施数タイトル(調査実施数タイトル);
        jisshiJokyoTokei.set審査会実施数タイトル(審査会実施数タイトル);
        jisshiJokyoTokei.set認定結果数タイトル(認定結果数タイトル);
        jisshiJokyoTokei.set新規申請タイトル(新規申請タイトル);
        jisshiJokyoTokei.set更新申請タイトル(更新申請タイトル);
        jisshiJokyoTokei.set区分変更申請タイトル(区分変更申請タイトル);
        jisshiJokyoTokei.set合計タイトル(合計タイトル);
    }

    private void set開始終了年月日() {
        if (parameter.isTaishoTsukiKubun()) {
            RYearMonth 対象年月 = new RYearMonth(parameter.getTaishoNendoYM());
            jisshiJokyoTokei.set抽出開始年月日(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1).toDateString());
            jisshiJokyoTokei.set抽出終了年月日(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay()).toDateString());
        } else {
            if (!parameter.isEmptyTaishoGeppiFrom() && !parameter.isEmptyTaishoGeppiTo()) {
                jisshiJokyoTokei.set抽出開始年月日(parameter.getTaishoGeppiFrom());
                jisshiJokyoTokei.set抽出終了年月日(parameter.getTaishoGeppiTo());
            } else if (parameter.isEmptyTaishoGeppiFrom()) {
                jisshiJokyoTokei.set抽出開始年月日(開始年月日);
                jisshiJokyoTokei.set抽出終了年月日(parameter.getTaishoGeppiTo());
            } else {
                jisshiJokyoTokei.set抽出開始年月日(parameter.getTaishoGeppiFrom());
                jisshiJokyoTokei.set抽出終了年月日(終了年月日);
            }
        }
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701003.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                タイトル,
                new RString(reportSourceWriter.pageCount().value()),
                new RString("無し"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(JIGYOJYOKYOHOKOKU);
        条件.append(parameter.isJigyoJyokyoHokoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(parameter.isJissiJyokyoTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(parameter.isSinsaHanteiJyokyo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(parameter.isSinsakaiKanrenTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(parameter.isCsvShutsuryoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(parameter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(parameter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HIHOKENSYAKUBUN);
        条件.append(parameter.isJigyoJyokyoHokoku() ? RString.EMPTY : HihokenshaKubun.toValue(
                parameter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(parameter.isJigyoJyokyoHokoku() ? RString.EMPTY : new RString(parameter.getGogitaiNo()));
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(parameter.isTaishoTsukiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!parameter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(parameter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(parameter.getKijyunYMD() == null ? RString.EMPTY : parameter.getKijyunYMD().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(parameter.isTaishoGeppiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(parameter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiFrom().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(parameter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiTo().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(parameter.isShinseiji());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(parameter.isHorei());
        出力条件.add(条件.toRString());
        return 出力条件;
    }

}
