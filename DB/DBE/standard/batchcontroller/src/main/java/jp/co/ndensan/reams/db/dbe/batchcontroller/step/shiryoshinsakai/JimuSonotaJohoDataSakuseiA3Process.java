/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa3.SonotashiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.SonotaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa3.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用その他資料情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuSonotaJohoDataSakuseiA3Process extends BatchKeyBreakBase<SonotaJohoEntity> {

    private static final RString SELECT_JIMUTSONOTAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getJimuSonotaJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(SonotashiryoA3ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private JimuTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private JimuSonotashiryoBusiness business;
    @BatchWriter
    private BatchReportWriter<SonotashiryoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<SonotashiryoA3ReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toJimuTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUTSONOTAJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(SonotaJohoEntity entity) {
        business = new JimuSonotashiryoBusiness(entity);
        SonotashiryoA3Report reportA3 = new SonotashiryoA3Report(business);
        reportA3.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517006.getReportId().value())
                .addBreak(new BreakerCatalog<SonotashiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    @Override
    protected void keyBreakProcess(SonotaJohoEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(SonotaJohoEntity before, SonotaJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        RString id = ReportIdDBE.DBE517006.getReportId().getColumnValue();
        RString idName = ReportIdDBE.DBE517006.getReportName();
        RString 総ページ数 = new RString(batchWriteA3.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                idName,
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【開始資料番号】")
                .append(" ")
                .append(paramter.getBangoStart());
        RStringBuilder stringBuilder = new RStringBuilder();
        stringBuilder.append("【終了資料番号】")
                .append(" ")
                .append(paramter.getBangoEnd());
        list.add(builder.toRString());
        list.add(stringBuilder.toRString());
        return list;
    }
}
