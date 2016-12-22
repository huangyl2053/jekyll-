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
import jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3.TsuikashiryokagamiA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTuikaSiryoDataSakuseiA3Process extends BatchKeyBreakBase<ShinsakaiTaiyosyaJohoEntity> {

    private static final RString SELECT_SHINSAKAITAIYOSYAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiTaiyosyaJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(TsuikashiryokagamiA3ReportSource.ReportSourceFields.shinsakaiNo.name())));
    private static final int 満ページ件数 = 10;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private IShiryoShinsakaiIinMapper mapper;
    private JimuTuikaSiryoBusiness business;
    private int データ件数;
    private int count;

    @BatchWriter
    private BatchReportWriter<TsuikashiryokagamiA3ReportSource> batchWriterA3;
    private ReportSourceWriter<TsuikashiryokagamiA3ReportSource> reportSourceWriterA3;

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
        return new BatchDbReader(SELECT_SHINSAKAITAIYOSYAJOHO, paramter.toIinShinsakaiIinJohoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriterA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517009.getReportId().value())
                .addBreak(new BreakerCatalog<TsuikashiryokagamiA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriterA3);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        hasBreak();
    }

    @Override
    protected void usualProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        entity.setHihokenshaName(AtenaMeisho.EMPTY);
        entity.setShoKisaiHokenshaNo(RString.EMPTY);
        entity.setHihokenshaNo(RString.EMPTY);
        business = new JimuTuikaSiryoBusiness(entity, shinsakaiIinJohoList, paramter, count,
                ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517009.getReportId(),
                        KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate()));
        TsuikashiryokagamiA3Report report = new TsuikashiryokagamiA3Report(business);
        report.writeBy(reportSourceWriterA3);
        データ件数 = データ件数 + 1;
    }

    @Override
    protected void afterExecute() {
    }

    private boolean hasBreak() {
        return データ件数 % 満ページ件数 == 0;
    }

}
