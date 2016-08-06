/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4.TsuikashiryokagamiA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public class IinTuikaSiryoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiTaiyosyaJohoEntity> {

    private static final RString SELECT_SHINSAKAITAIYOSYAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiTaiyosyaJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(TsuikashiryokagamiA4ReportSource.ReportSourceFields.shinsakaiNo.name())));
    private static final int 満ページ件数 = 10;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private JimuTuikaSiryoBusiness business;
    private int count;
    private int データ件数;
    @BatchWriter
    private BatchReportWriter<TsuikashiryokagamiA4ReportSource> batchWriterA4;
    private ReportSourceWriter<TsuikashiryokagamiA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        データ件数 = 0;
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        IinShinsakaiIinJohoMyBatisParameter myBatisParameter = paramter.toIinShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(myBatisParameter);
        count = mapper.getShinsakaiTaiyosyaJohoCount(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAITAIYOSYAJOHO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriterA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517019.getReportId().value())
                .addBreak(new BreakerCatalog<TsuikashiryokagamiA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriterA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        if (データ件数 % 満ページ件数 == 0) {
            TsuikashiryokagamiA4Report report = new TsuikashiryokagamiA4Report(business);
            report.writeBy(reportSourceWriterA4);
        }
    }

    @Override
    protected void usualProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        business = new JimuTuikaSiryoBusiness(entity, shinsakaiIinJohoList, paramter, count,
                ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517019.getReportId(),
                        KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate()));
        TsuikashiryokagamiA4Report report = new TsuikashiryokagamiA4Report(business);
        report.writeBy(reportSourceWriterA4);
        データ件数 = データ件数 + 1;
    }

    @Override
    protected void afterExecute() {
    }
}
