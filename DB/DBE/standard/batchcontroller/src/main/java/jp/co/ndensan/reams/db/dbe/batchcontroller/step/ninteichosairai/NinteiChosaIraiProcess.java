/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosairai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoHeadItem;
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
    private List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList;
    private NinteiChosaIraiProcessParamter processParamter;
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
        bodyItemList = new ArrayList<>();
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
            ChosaIraiHakkoIchiranhyoReport report = ChosaIraiHakkoIchiranhyoReport.createFrom(setHeadItem(), bodyItemList);
            report.writeBy(reportSourceWriter);
            bodyItemList = new ArrayList<>();
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
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            ChosaIraiHakkoIchiranhyoReport report = ChosaIraiHakkoIchiranhyoReport.createFrom(setHeadItem(), bodyItemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private ChosaIraiHakkoIchiranhyoHeadItem setHeadItem() {
        ChosaIraiHakkoIchiranhyoHeadItem headItem = new ChosaIraiHakkoIchiranhyoHeadItem();
        headItem.set認定調査依頼書FLG(processParamter.getNinteiChosaIraisyo());
        headItem.set依頼日From(processParamter.getIraiFromYMD());
        headItem.set依頼日To(processParamter.getIraiToYMD());
        return headItem;
    }

    private ChosaIraiHakkoIchiranhyoBodyItem setBodyItem(NinteiChosaIraiRelateEntity entity) {
        ChosaIraiHakkoIchiranhyoBodyItem bodyItem = new ChosaIraiHakkoIchiranhyoBodyItem();
        bodyItem.set依頼書作成日(entity.getIraishoShutsuryokuYMD());
        bodyItem.set依頼書提出期限(entity.getNinteichosaKigenYMD());
        bodyItem.set市町村コード(entity.getShichosonCode());
        bodyItem.set市町村名称(entity.getShichosonMeisho());
        bodyItem.set被保険者番号(entity.getHihokenshaNo());
        bodyItem.set被保険者氏名(entity.getHihokenshaName());
        bodyItem.set依頼日(entity.getNinteichosaIraiYMD());
        bodyItem.set委託先名(entity.getJigyoshaMeisho());
        bodyItem.set代表者名(entity.getDaihyoshaName());
        bodyItem.set連絡先(entity.getTelNo());
        bodyItem.set調査員名(entity.getChosainShimei());
        return bodyItem;
    }
}
