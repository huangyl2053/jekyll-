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
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa4.SonotashiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa4.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
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
 * 事務局用概況特記情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuGaikyotokkiSonotaJohoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_JIMUTSONOTAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get概況特記イメージ");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(SonotashiryoA4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinShinsakaiIinJohoProcessParameter paramter;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private JimuSonotashiryoBusiness business;
    private int shinsakaiOrder;
    private int 存在ファイルindex;

    @BatchWriter
    private BatchReportWriter<SonotashiryoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<SonotashiryoA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUTSONOTAJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity entity) {
        business = new JimuSonotashiryoBusiness(entity, 存在ファイルindex);
        SonotashiryoA4Report reportA4 = new SonotashiryoA4Report(business);
        reportA4.writeBy(reportSourceWriterA4);
        if (shinsakaiOrder == entity.getShinsakaiOrder()) {
            存在ファイルindex = business.get存在ファイルIndex();
        } else {
            存在ファイルindex = 0;
        }
        shinsakaiOrder = entity.getShinsakaiOrder();
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517016.getReportId().value())
                .addBreak(new BreakerCatalog<SonotashiryoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        RString id = ReportIdDBE.DBE517016.getReportId().getColumnValue();
        RString 総ページ数 = new RString(batchWriteA4.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("概況特記"),
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【合議体番号】")
                .append(" ")
                .append(paramter.getGogitaiNo());
        RStringBuilder stringBuilder = new RStringBuilder();
        stringBuilder.append("【介護認定審査会開催予定年月日】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiYoteiYMD().wareki());
        RStringBuilder 開催番号 = new RStringBuilder();
        stringBuilder.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        list.add(builder.toRString());
        list.add(stringBuilder.toRString());
        list.add(開催番号.toRString());
        return list;
    }
}
