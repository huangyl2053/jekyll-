package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJyokyoHokokuEditor;
import jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku.JigyoJokyoHokokuReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString タイトル = new RString("要介護認定事業状況報告");
    private static final RString 第1号被保険者タイトル = new RString("第1号被保険者");
    private static final RString 歳65以上75歳未満タイトル = new RString("　65歳以上75歳未満");
    private static final RString 歳75以上タイトル = new RString("　75歳以上");
    private static final RString 第2号被保険者タイトル = new RString("第2号被保険者");
    private static final RString 総数タイトル = new RString("総　数");
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
            new JigyoJyokyoHokokuEditor(null, jigyoJokyoHokoku).set総数();
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
            new JigyoJyokyoHokokuEditor(null, jigyoJokyoHokoku).set総数();
            JigyoJokyoHokokuReport report = new JigyoJokyoHokokuReport(jigyoJokyoHokoku);
            report.writeBy(reportSourceWriter);
        }
    }

    private boolean hasBrek(JigyoJyokyoHokokuEntity before, JigyoJyokyoHokokuEntity current) {
        return !((before.getNijiHanteiYM().equals(current.getNijiHanteiYM()))
                && before.getShichosonCode().equals(current.getShichosonCode()) && !current.isAllshichoson());
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

}
