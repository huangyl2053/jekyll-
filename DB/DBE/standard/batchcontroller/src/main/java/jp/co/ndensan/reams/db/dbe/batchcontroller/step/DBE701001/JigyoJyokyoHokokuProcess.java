package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJyokyoHokokuEditor;
import jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku.JigyoJokyoHokokuReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JigyoJyokyoHokokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
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
 * 要介護認定事業状況報告の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JigyoJyokyoHokokuProcess extends BatchKeyBreakBase<JigyoJyokyoHokokuEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getJigyoJyokyoHokoku");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JigyoJokyoHokokuReportSource.ReportSourceFields.jigyoTaishoYM.name())));
    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
    private static final RString タイトル = new RString("要介護認定事業状況報告");
    private static final RString 第1号被保険者タイトル = new RString("第1号被保険者");
    private static final RString 歳65以上75歳未満タイトル = new RString("　65歳以上75歳未満");
    private static final RString 歳75以上タイトル = new RString("　75歳以上");
    private static final RString 第2号被保険者タイトル = new RString("第2号被保険者");
    private static final RString 総数タイトル = new RString("総　数");
    private JigyoJyokyoHokokuProcessParameter paramter;
    private JigyoJokyoHokoku jigyoJokyoHokoku;
    private boolean isデータあり;
    @BatchWriter
    private BatchReportWriter<JigyoJokyoHokokuReportSource> batchWriter;
    private ReportSourceWriter<JigyoJokyoHokokuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        jigyoJokyoHokoku = new JigyoJokyoHokoku();
        set事業状況報告情報タイトル();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER);
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE702001.getReportId().value())
                .addBreak(new BreakerCatalog<JigyoJokyoHokokuReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(JigyoJyokyoHokokuEntity jigyoJokyo) {
        if (hasBrek(getBefore(), jigyoJokyo)) {
            JigyoJokyoHokokuReport report = new JigyoJokyoHokokuReport(jigyoJokyoHokoku);
            report.writeBy(reportSourceWriter);
            set事業状況報告情報タイトル();
        }
    }

    @Override
    protected void usualProcess(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        isデータあり = true;
        new JigyoJyokyoHokokuEditor(jigyoJyokyo, jigyoJokyoHokoku).get編集後事業状況報告情報();
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            JigyoJokyoHokokuReport report = new JigyoJokyoHokokuReport(jigyoJokyoHokoku);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyo();
    }

    private boolean hasBrek(JigyoJyokyoHokokuEntity before, JigyoJyokyoHokokuEntity current) {
        return !((before.getNijiHanteiYM().equals(current.getNijiHanteiYM()))
                && before.getShichosonCode().equals(current.getShichosonCode()));
    }

    private void set事業状況報告情報タイトル() {
        jigyoJokyoHokoku.setタイトル(タイトル);
        jigyoJokyoHokoku.set発行日時(RDateTime.now());
        jigyoJokyoHokoku.set第1号被保険者タイトル(第1号被保険者タイトル);
        jigyoJokyoHokoku.set歳以上75歳未満タイトル(歳65以上75歳未満タイトル);
        jigyoJokyoHokoku.set歳75以上タイトル(歳75以上タイトル);
        jigyoJokyoHokoku.set第2号被保険者タイトル(第2号被保険者タイトル);
        jigyoJokyoHokoku.set総数タイトル(総数タイトル);
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE702001.getReportId().value(),
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
        条件.append(paramter.isJigyoJyokyoHokoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(paramter.isJissiJyokyoTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(paramter.isSinsaHanteiJyokyo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(paramter.isSinsakaiKanrenTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(paramter.isCsvShutsuryoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(paramter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(paramter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(paramter.isTaishoTsukiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!paramter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(paramter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(paramter.getKijyunYMD() == null ? RString.EMPTY : paramter.getKijyunYMD().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(paramter.isTaishoGeppiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(paramter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiFrom().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(paramter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiTo().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(paramter.isShinseiji());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(paramter.isHorei());
        出力条件.add(条件.toRString());
        return 出力条件;
    }
}
