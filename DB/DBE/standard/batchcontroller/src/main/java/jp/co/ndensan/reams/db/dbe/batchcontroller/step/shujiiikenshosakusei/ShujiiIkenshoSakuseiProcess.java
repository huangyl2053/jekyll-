/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
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
 * 主治医意見書作成依頼発行一覧表_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
public class ShujiiIkenshoSakuseiProcess extends BatchKeyBreakBase<ShujiiIkenshoSakuseiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoSakuseiMapper."
            + "get主治医意見書作成依頼発行一覧表");
    private static final RString 帳票ID = ReportIdDBE.DBE230003.getReportId().value();
    private List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList;
    private ShujiiIkenshoSakuseiProcessParamter processParamter;
    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("joken3"));
        PAGE_BREAK_KEYS.add(new RString("joken4"));
        PAGE_BREAK_KEYS.add(new RString("cityCode"));
    }
    @BatchWriter
    private BatchReportWriter<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenshoSakuseiMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID).
                addBreak(new BreakerCatalog<IkenshoSakuseiIraiIchiranhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(ShujiiIkenshoSakuseiRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            SyujiyikenshosakuseyiraihakouReport report = SyujiyikenshosakuseyiraihakouReport.createFrom(setHeaderItem(), bodyItemList);
            report.writeBy(reportSourceWriter);
            bodyItemList = new ArrayList<>();
        }
    }

    private boolean hasBrek(ShujiiIkenshoSakuseiRelateEntity before, ShujiiIkenshoSakuseiRelateEntity current) {
        return !RString.isNullOrEmpty(before.get依頼書作成日()) && !before.get依頼書作成日().equals(current.get依頼書作成日())
                && !before.get依頼書提出期限().equals(current.get依頼書提出期限())
                && !before.get市町村コード().equals(current.get市町村コード());
    }

    @Override
    protected void usualProcess(ShujiiIkenshoSakuseiRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            SyujiyikenshosakuseyiraihakouReport report = SyujiyikenshosakuseyiraihakouReport.createFrom(setHeaderItem(), bodyItemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private SyujiyikenshosakuseyiraihakouHeadItem setHeaderItem() {
        return new SyujiyikenshosakuseyiraihakouHeadItem(processParamter.getIraiFromYMD(),
                processParamter.getIraiToYMD(),
                processParamter.getShujiiIkenshoSakuseiIraisho());
    }

    private SyujiyikenshosakuseyiraihakouBodyItem setBodyItem(ShujiiIkenshoSakuseiRelateEntity entity) {
        return new SyujiyikenshosakuseyiraihakouBodyItem(entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get依頼日(),
                entity.get医療機関名称(),
                entity.get代表者名(),
                entity.get連絡先(),
                entity.get主治医名(),
                RString.EMPTY,
                RString.EMPTY,
                entity.get依頼書作成日(),
                entity.get依頼書提出期限(),
                entity.get市町村コード(),
                entity.get市町村名称());
    }
}
