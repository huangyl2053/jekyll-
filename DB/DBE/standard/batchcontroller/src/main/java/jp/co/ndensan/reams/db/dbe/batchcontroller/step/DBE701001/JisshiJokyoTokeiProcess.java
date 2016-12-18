package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JisshiJokyoTokeiEditor;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei.JisshiJokyoTokeiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JisshiJokyoTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JisshiJokyoTokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況統計情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JisshiJokyoTokeiProcess extends BatchProcessBase<JisshiJokyoTokeiEntity> {

    private static final RString SELECT_JISSHIJOKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getJisshiJokyoTokei");
    private static final RString タイトル = new RString("要介護認定実施状況統計");
    private static final RString 開始年月日 = new RString("最初から");
    private static final RString 終了年月日 = new RString("最終まで");
    private static final RString 申請受付数タイトル = new RString("申請受付人数");
    private static final RString 調査実施数タイトル = new RString("調査実施人数");
    private static final RString 審査会実施数タイトル = new RString("審査会実施人数");
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
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(JisshiJokyoTokeiEntity current) {
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

}
