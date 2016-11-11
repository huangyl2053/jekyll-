/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE220003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaIraiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.NinteiChosaIraiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 認定調査依頼発行一覧表_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
public class NinteiChosaIraiProcess extends BatchKeyBreakBase<NinteiChosaIraiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.INinteiChosaIraiMapper."
            + "get認定調査依頼発行一覧");
    private static final RString 帳票ID = ReportIdDBE.DBE220003.getReportId().value();
    private NinteiChosaIraiProcessParamter processParamter;
    private NinteiChosaIraiBusiness business;
    private int count;
    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("joken4"));
        PAGE_BREAK_KEYS.add(new RString("joken5"));
        PAGE_BREAK_KEYS.add(new RString("cityCode"));
    }
    @BatchWriter
    private BatchReportWriter<ChosaIraiHakkoIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<ChosaIraiHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        count = 1;
        business = new NinteiChosaIraiBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaIraiMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID).
                addBreak(new BreakerCatalog<ChosaIraiHakkoIchiranhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(NinteiChosaIraiRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            count = 1;
            ChosaIraiHakkoIchiranhyoReport report = ChosaIraiHakkoIchiranhyoReport.
                    createFrom(business.setHeadItem(processParamter), business.setBodyItem(current), count++);
            report.writeBy(reportSourceWriter);
        }
    }

    private boolean hasBrek(NinteiChosaIraiRelateEntity before, NinteiChosaIraiRelateEntity current) {
        return !RString.isNullOrEmpty(before.getIraishoShutsuryokuYMD()) && !RString.isNullOrEmpty(before.getNinteichosaKigenYMD())
                && !before.getIraishoShutsuryokuYMD().equals(current.getIraishoShutsuryokuYMD())
                && !before.getNinteichosaKigenYMD().equals(current.getNinteichosaKigenYMD())
                && !before.getShichosonCode().equals(current.getShichosonCode());
    }

    @Override
    protected void usualProcess(NinteiChosaIraiRelateEntity entity) {
        ChosaIraiHakkoIchiranhyoReport report = ChosaIraiHakkoIchiranhyoReport.
                createFrom(business.setHeadItem(processParamter), business.setBodyItem(entity), count++);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {

    }

}
