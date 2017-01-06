/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE525002;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 判定結果情報出力(保険者)_バッチ処理クラスです
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
public class HanteiKekkaJohoShutsuryokuProcess extends BatchKeyBreakBase<HanteiKekkaJohoShutsuryokuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshutsuryoku."
            + "IHanteiKekkaJohoShutsuryokuMapper.get出力対象者明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE525005.getReportId();
    private static final RString 改ページ = new RString("shichosonName");
    private List<RString> page_break_keys;
    private KaigoKekkaTaishouIchiranHeadItem headItem;
    private KaigoKekkaTaishouIchiranBodyItem bodyItem;
    private HanteiKekkaJohoShutsuryokuProcessParamter processPrm;
    private HanteiKekkaJohoShutsuryokuMybitisParamter mybatisPrm;
    private int index;
    @BatchWriter
    private BatchReportWriter<KekkatsuchiTaishoshaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KekkatsuchiTaishoshaIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toHanteiKekkaJohoShutsuryokuMybitisParamter();
        page_break_keys = Collections.unmodifiableList(Arrays.asList(改ページ));
        index = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<KekkatsuchiTaishoshaIchiranReportSource>().simplePageBreaker(page_break_keys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void usualProcess(HanteiKekkaJohoShutsuryokuRelateEntity entity) {
        bodyItem = setBodyItem(entity, index);

        headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                entity.getShichosonMeisho(),
                processPrm.getNijiHanteiYMDFrom(),
                processPrm.getNijiHanteiYMDTo(),
                RDate.getNowDate().toDateString(),
                index);
        KaigoKekkaTaishouIchiranReport report = KaigoKekkaTaishouIchiranReport.createFrom(headItem, bodyItem);
        report.writeBy(reportSourceWriter);
        index = index + 1;
    }

    private KaigoKekkaTaishouIchiranBodyItem setBodyItem(HanteiKekkaJohoShutsuryokuRelateEntity entity, int index) {
        return new KaigoKekkaTaishouIchiranBodyItem(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinsakaiKaisaiYMD(),
                entity.getNinteiShinseiYMD(),
                entity.getHihokenshaNo(),
                entity.getHihokenshaName(),
                entity.getHihokenshaKana(),
                entity.getSeinengappiYMD(),
                Seibetsu.toValue(entity.getSeibetsu()).get名称(),
                YokaigoJotaiKubun09.toValue(entity.getNijiHanteiKekka()).get名称(),
                index);
    }

    @Override
    protected void keyBreakProcess(HanteiKekkaJohoShutsuryokuRelateEntity current) {
        if (!getBefore().getShoKisaiHokenshaNo().value().equals(current.getShoKisaiHokenshaNo().value())) {
            index = 1;
        }
    }

    @Override
    protected void afterExecute() {
    }
}
