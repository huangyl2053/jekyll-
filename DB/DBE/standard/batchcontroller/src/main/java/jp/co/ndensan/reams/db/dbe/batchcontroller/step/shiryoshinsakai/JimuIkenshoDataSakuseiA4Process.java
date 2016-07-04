/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4.ShujiiikenshoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1a4.ShujiiikenshoA4ReportSource;
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
 * 事務局用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuIkenshoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiWariateJohoEntity> {

    private static final RString SELECT_JIMUWARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getJimuShinsakaiWariateJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(ShujiiikenshoA4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private JimuTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<ShujiiikenshoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<ShujiiikenshoA4ReportSource> reportSourceWriterA4;
    private JimuShinsakaiWariateJohoBusiness business;

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toJimuTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUWARIATEJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(ShinsakaiWariateJohoEntity entity) {
        business = new JimuShinsakaiWariateJohoBusiness(entity);
        ShujiiikenshoA4Report reportA4 = new ShujiiikenshoA4Report(business);
        reportA4.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517152.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiikenshoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiWariateJohoEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiWariateJohoEntity before, ShinsakaiWariateJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }
}
