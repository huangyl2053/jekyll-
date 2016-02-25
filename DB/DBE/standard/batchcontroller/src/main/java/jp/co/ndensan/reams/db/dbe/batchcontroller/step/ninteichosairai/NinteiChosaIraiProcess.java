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
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.NinteiChosaIraiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.NinteiChosaIraiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 認定調査依頼発行一覧表_バッチフ処理クラスです
 */
public class NinteiChosaIraiProcess extends BatchProcessBase<NinteiChosaIraiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.INinteiChosaIraiMapper."
            + "get認定調査依頼発行一覧");
    private static final RString 帳票ID = ReportIdDBE.DBE220003.getReportId().value();
    private ChosaIraiHakkoIchiranhyoHeadItem headItem;
    private List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList;
    private NinteiChosaIraiProcessParamter processParamter;
    private NinteiChosaIraiMybitisParamter mybatisParamter;
    @BatchWriter
    private BatchReportWriter<ChosaIraiHakkoIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<ChosaIraiHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisParamter = processParamter.toNinteiChosaIraiMybitisParamter();
        bodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParamter);
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(NinteiChosaIraiRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            setHeadItem();
            ChosaIraiHakkoIchiranhyoReport report = ChosaIraiHakkoIchiranhyoReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private void setHeadItem() {
        headItem = new ChosaIraiHakkoIchiranhyoHeadItem();
        headItem.set認定調査委託先コード(processParamter.getNinteiChosaItakusakiCodeList());
        headItem.set認定調査員コード(processParamter.getNinteiChosainNoList());
        headItem.set保険者番号(processParamter.getHihokenshaNo());
        headItem.set認定調査依頼書FLG(processParamter.getNinteiChosaIraisyo());
        headItem.set依頼日From(processParamter.getIraiFromYMD());
        headItem.set依頼日From(processParamter.getIraiToYMD());
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
