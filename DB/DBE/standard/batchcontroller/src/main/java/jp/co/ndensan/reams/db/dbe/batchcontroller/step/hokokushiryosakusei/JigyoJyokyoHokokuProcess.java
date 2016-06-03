package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
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
    private static final RString 保険者なし = new RString("0");
    private static final RString 第1号保険者 = new RString("0");
    private static final RString 歳65以上75未満 = new RString("1");
    private static final RString 歳75以上 = new RString("2");
    private static final RString 第2号被保険者 = new RString("3");
    private static final RString コード_非該当 = new RString("01");
    private static final RString コード_要支援1 = new RString("12");
    private static final RString コード_要支援2 = new RString("13");
    private static final RString コード_要介護1 = new RString("21");
    private static final RString コード_要介護2 = new RString("22");
    private static final RString コード_要介護3 = new RString("23");
    private static final RString コード_要介護4 = new RString("24");
    private static final RString コード_要介護5 = new RString("25");
    private static final RString タイトル = new RString("要介護認定事業状況報告");
    private static final RString 第1号被保険者タイトル = new RString("第1号被保険者");
    private static final RString 歳65以上75歳未満タイトル = new RString("　65歳以上75歳未満");
    private static final RString 歳75以上タイトル = new RString("　75歳以上");
    private static final RString 第2号被保険者タイトル = new RString("第2号被保険者");
    private static final RString 総数タイトル = new RString("総　数");
    private JigyoJokyoHokoku jigyoJokyoHokoku;
    @BatchWriter
    private BatchReportWriter<JigyoJokyoHokokuReportSource> batchWriter;
    private ReportSourceWriter<JigyoJokyoHokokuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        jigyoJokyoHokoku = new JigyoJokyoHokoku();
        init事業状況報告情報();
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
            init事業状況報告情報();
        }
    }

    @Override
    protected void usualProcess(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set事業対象年月(jigyoJyokyo.getNijiHanteiYM().toDateString());
        jigyoJokyoHokoku.set保険者番号(jigyoJyokyo.getShoKisaiHokenshaNo());
        jigyoJokyoHokoku.set保険者名(jigyoJyokyo.getShichosonMeisho());
        if (第1号保険者.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set第1号被保険者(jigyoJyokyo);
        } else if (歳65以上75未満.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set歳65以上75歳未満(jigyoJyokyo);
        } else if (歳75以上.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set歳75歳以上(jigyoJyokyo);
        } else if (第2号被保険者.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set第2号被保険者(jigyoJyokyo);
        }
    }

    @Override
    protected void afterExecute() {
        jigyoJokyoHokoku.set総数_非該当(get総数非該当());
        jigyoJokyoHokoku.set総数_支援1(get総数支援1());
        jigyoJokyoHokoku.set総数_支援2(get総数支援2());
        jigyoJokyoHokoku.set総数_要介護1(get総数要介護1());
        jigyoJokyoHokoku.set総数_要介護2(get総数要介護2());
        jigyoJokyoHokoku.set総数_要介護3(get総数要介護3());
        jigyoJokyoHokoku.set総数_要介護4(get総数要介護4());
        jigyoJokyoHokoku.set総数_要介護5(get総数要介護5());
        JigyoJokyoHokokuReport report = new JigyoJokyoHokokuReport(jigyoJokyoHokoku);
        report.writeBy(reportSourceWriter);
    }

    private boolean hasBrek(JigyoJyokyoHokokuEntity before, JigyoJyokyoHokokuEntity current) {
        return !(before.getNijiHanteiYM().equals(current.getNijiHanteiYM()));
    }

    private void set第1号被保険者(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set第1号被保険者_非該当(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_非該当().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_非該当)));
        jigyoJokyoHokoku.set第1号被保険者_支援1(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_支援1().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要支援1)));
        jigyoJokyoHokoku.set第1号被保険者_支援2(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_支援2().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要支援2)));
        jigyoJokyoHokoku.set第1号被保険者_要介護1(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護1().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護1)));
        jigyoJokyoHokoku.set第1号被保険者_要介護2(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護2().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護2)));
        jigyoJokyoHokoku.set第1号被保険者_要介護3(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護3().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護3)));
        jigyoJokyoHokoku.set第1号被保険者_要介護4(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護4().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護4)));
        jigyoJokyoHokoku.set第1号被保険者_要介護5(new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護5().toString())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護5)));
    }

    private void set歳65以上75歳未満(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set歳以上75歳未満_非該当(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_非該当().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_非該当)));
        jigyoJokyoHokoku.set歳以上75歳未満_支援1(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_支援1().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要支援1)));
        jigyoJokyoHokoku.set歳以上75歳未満_支援2(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_支援2().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要支援2)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護1(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護1().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護1)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護2(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護2().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護2)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護3(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護3().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護3)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護4(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護4().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護4)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護5(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護5().toString())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護5)));
    }

    private void set歳75歳以上(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set歳75以上_非該当(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_非該当().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_非該当)));
        jigyoJokyoHokoku.set歳75以上_支援1(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_支援1().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要支援1)));
        jigyoJokyoHokoku.set歳75以上_支援2(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_支援2().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要支援2)));
        jigyoJokyoHokoku.set歳75以上_要介護1(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護1().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護1)));
        jigyoJokyoHokoku.set歳75以上_要介護2(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護2().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護2)));
        jigyoJokyoHokoku.set歳75以上_要介護3(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護3().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護3)));
        jigyoJokyoHokoku.set歳75以上_要介護4(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護4().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護4)));
        jigyoJokyoHokoku.set歳75以上_要介護5(new RString(Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護5().toString())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護5)));
    }

    private void set第2号被保険者(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set第2号被保険者_非該当(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_非該当().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_非該当)));
        jigyoJokyoHokoku.set第2号被保険者_支援1(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_支援1().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要支援1)));
        jigyoJokyoHokoku.set第2号被保険者_支援2(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_支援2().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要支援2)));
        jigyoJokyoHokoku.set第2号被保険者_要介護1(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護1().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護1)));
        jigyoJokyoHokoku.set第2号被保険者_要介護2(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護2().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護2)));
        jigyoJokyoHokoku.set第2号被保険者_要介護3(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護3().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護3)));
        jigyoJokyoHokoku.set第2号被保険者_要介護4(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護4().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護4)));
        jigyoJokyoHokoku.set第2号被保険者_要介護5(new RString(Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護5().toString())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護5)));
    }

    private int get被保険者件数(JigyoJyokyoHokokuEntity jigyoJyokyo, RString 被保険者区分, RString 要介護状態区分) {
        if (要介護状態区分.equals(jigyoJyokyo.getNijiHanteiYokaigoJotaiKubunCode().value())
                && 被保険者区分.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            return jigyoJyokyo.getCountHokensha();
        }
        return 0;
    }

    private RString get総数非該当() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_非該当().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_非該当().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_非該当().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_非該当().toString()));
    }

    private RString get総数支援1() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_支援1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_支援1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_支援1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_支援1().toString()));
    }

    private RString get総数支援2() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_支援2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_支援2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_支援2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_支援2().toString()));
    }

    private RString get総数要介護1() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護1().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護1().toString()));
    }

    private RString get総数要介護2() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護2().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護2().toString()));
    }

    private RString get総数要介護3() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護3().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護3().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護3().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護3().toString()));
    }

    private RString get総数要介護4() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護4().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護4().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護4().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護4().toString()));
    }

    private RString get総数要介護5() {
        return new RString(Integer.parseInt(jigyoJokyoHokoku.get第1号被保険者_要介護5().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳以上75歳未満_要介護5().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get歳75以上_要介護5().toString())
                + Integer.parseInt(jigyoJokyoHokoku.get第2号被保険者_要介護5().toString()));
    }

    private void init事業状況報告情報() {
        jigyoJokyoHokoku.setタイトル(タイトル);
        jigyoJokyoHokoku.set発行日時(RDateTime.now());
        jigyoJokyoHokoku.set第1号被保険者タイトル(第1号被保険者タイトル);
        jigyoJokyoHokoku.set歳以上75歳未満タイトル(歳65以上75歳未満タイトル);
        jigyoJokyoHokoku.set歳75以上タイトル(歳75以上タイトル);
        jigyoJokyoHokoku.set第2号被保険者タイトル(第2号被保険者タイトル);
        jigyoJokyoHokoku.set総数タイトル(総数タイトル);
        init第1号被保険者();
        init歳65以上75未満();
        init歳75以上();
        init第2号被保険者();
    }

    private void init第1号被保険者() {
        jigyoJokyoHokoku.set第1号被保険者_非該当(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_支援1(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_支援2(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_要介護1(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_要介護2(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_要介護3(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_要介護4(保険者なし);
        jigyoJokyoHokoku.set第1号被保険者_要介護5(保険者なし);
    }

    private void init歳65以上75未満() {
        jigyoJokyoHokoku.set歳以上75歳未満_非該当(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_支援1(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_支援2(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_要介護1(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_要介護2(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_要介護3(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_要介護4(保険者なし);
        jigyoJokyoHokoku.set歳以上75歳未満_要介護5(保険者なし);
    }

    private void init歳75以上() {
        jigyoJokyoHokoku.set歳75以上_非該当(保険者なし);
        jigyoJokyoHokoku.set歳75以上_支援1(保険者なし);
        jigyoJokyoHokoku.set歳75以上_支援2(保険者なし);
        jigyoJokyoHokoku.set歳75以上_要介護1(保険者なし);
        jigyoJokyoHokoku.set歳75以上_要介護2(保険者なし);
        jigyoJokyoHokoku.set歳75以上_要介護3(保険者なし);
        jigyoJokyoHokoku.set歳75以上_要介護4(保険者なし);
        jigyoJokyoHokoku.set歳75以上_要介護5(保険者なし);
    }

    private void init第2号被保険者() {
        jigyoJokyoHokoku.set第2号被保険者_非該当(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_支援1(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_支援2(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_要介護1(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_要介護2(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_要介護3(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_要介護4(保険者なし);
        jigyoJokyoHokoku.set第2号被保険者_要介護5(保険者なし);
    }
}
