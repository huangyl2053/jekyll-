package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.ShinsakaiShukeihyoShinseiBetsuEditor;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei.ShinsakaishukeihyoShinseiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（申請区分別）の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeihyoShinseiBetsuProcess extends BatchKeyBreakBase<ShinsakaiShukeihyoShinseiBetsuEntity> {

    private static final RString SELECT_SHUKEIHYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaiShukeihyoShinseiBetsu");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaiShukeihyoShinseiReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString 帳票タイトル = new RString("介護認定審査会集計表（申請区分別）");
    private static final RString から = new RString("～");
    private static final RString 開始期間 = new RString("最初から");
    private static final RString 終了期間 = new RString("最終まで");
    private ShinsakaiShukeihyoShinseiBetsuProcessParameter parameter;
    private ShinsakaiShukeihyoShinsei shukeihyoShinseiBetsu;
    private boolean isデータあり;

    @BatchWriter
    private BatchReportWriter<ShinsakaiShukeihyoShinseiReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiShukeihyoShinseiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        shukeihyoShinseiBetsu = new ShinsakaiShukeihyoShinsei();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHUKEIHYO, parameter.toShinsakaiShukeihyoShinseiBetsuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701008.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaiShukeihyoShinseiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiShukeihyoShinseiBetsuEntity headerJoho) {
        if (hasBrek(getBefore(), headerJoho)) {
            shukeihyoShinseiBetsu.setタイトル(帳票タイトル);
            shukeihyoShinseiBetsu.set抽出期間(get抽出期間());
            shukeihyoShinseiBetsu.set発行日時(RDateTime.now());
            ShinsakaishukeihyoShinseiReport report = new ShinsakaishukeihyoShinseiReport(shukeihyoShinseiBetsu);
            report.writeBy(reportSourceWriter);
            shukeihyoShinseiBetsu = new ShinsakaiShukeihyoShinsei();
        }
    }

    @Override
    protected void usualProcess(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        isデータあり = true;
        new ShinsakaiShukeihyoShinseiBetsuEditor(current, shukeihyoShinseiBetsu).set介護認定審査会集計表申請区分別();
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            shukeihyoShinseiBetsu.setタイトル(帳票タイトル);
            shukeihyoShinseiBetsu.set抽出期間(get抽出期間());
            shukeihyoShinseiBetsu.set発行日時(RDate.getNowDateTime());
            ShinsakaishukeihyoShinseiReport report = new ShinsakaishukeihyoShinseiReport(shukeihyoShinseiBetsu);
            report.writeBy(reportSourceWriter);
        }
    }

    private boolean hasBrek(ShinsakaiShukeihyoShinseiBetsuEntity before, ShinsakaiShukeihyoShinseiBetsuEntity current) {
        return !before.getShichosonCode().equals(current.getShichosonCode());
    }

    private RString get抽出期間() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.isTaishoTsukiKubun()) {
            RYearMonth 対象年月 = new RYearMonth(parameter.getTaishoNendoYM());
            builder.append(dateForMat(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1)));
            builder.append(から);
            builder.append(dateForMat(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay())));
        } else {
            if (!parameter.isEmptyTaishoGeppiFrom() && !parameter.isEmptyTaishoGeppiTo()) {
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiFrom().toString())));
                builder.append(から);
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiTo().toString())));
            } else if (parameter.isEmptyTaishoGeppiFrom()) {
                builder.append(開始期間);
                builder.append(から);
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiTo().toString())));
            } else {
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiFrom().toString())));
                builder.append(から);
                builder.append(終了期間);
            }
        }
        return builder.toRString();
    }

    private RString dateForMat(RDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

}
