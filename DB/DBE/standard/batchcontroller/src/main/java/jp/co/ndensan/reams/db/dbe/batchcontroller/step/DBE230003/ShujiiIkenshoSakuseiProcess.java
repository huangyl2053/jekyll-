/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE230003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.ShujiiIkenshoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
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
    private ShujiiIkenshoSakuseiProcessParamter processParamter;
    private ShujiiIkenshoSakuseiBusiness business;
    private int count;
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
        business = new ShujiiIkenshoSakuseiBusiness();
        count = 1;
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
            count = 1;
            SyujiyikenshosakuseyiraihakouReport report = SyujiyikenshosakuseyiraihakouReport.
                    createFrom(business.setHeaderItem(processParamter), business.setBodyItem(current), count++);
            report.writeBy(reportSourceWriter);
        }
    }

    private boolean hasBrek(ShujiiIkenshoSakuseiRelateEntity before, ShujiiIkenshoSakuseiRelateEntity current) {
        return !RString.isNullOrEmpty(before.get依頼書作成日()) && !before.get依頼書作成日().equals(current.get依頼書作成日())
                && !before.get依頼書提出期限().equals(current.get依頼書提出期限())
                && !before.get市町村コード().equals(current.get市町村コード());
    }

    @Override
    protected void usualProcess(ShujiiIkenshoSakuseiRelateEntity entity) {
        SyujiyikenshosakuseyiraihakouReport report = SyujiyikenshosakuseyiraihakouReport.
                createFrom(business.setHeaderItem(processParamter), business.setBodyItem(entity), count++);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        OutputJokenhyoFactory.createInstance(business.
                バッチ出力条件リストの出力(市町村名,
                        出力ページ数,
                        導入団体コード,
                        ReportIdDBE.DBE230003.getReportId().value(), ReportIdDBE.DBE230003.getReportName(),
                        processParamter)).print();
    }
}
