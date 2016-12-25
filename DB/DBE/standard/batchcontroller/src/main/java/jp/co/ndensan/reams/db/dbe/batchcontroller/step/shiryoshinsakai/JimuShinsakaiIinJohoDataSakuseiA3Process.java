/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3.ShinsakaishiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用介護認定審査対象者一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShinsakaiIinJohoDataSakuseiA3Process extends BatchProcessBase<ShinsakaiTaiyosyaJohoEntity> {

    private static final RString SELECT_JIMUSHINASKAIIINJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get事務局情報");
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private ShinsakaishiryoA3Report report;
    private List<JimuShinsakaishiryoBusiness> businessList;
    private int no;
    private int count;
    @BatchWriter
    private BatchReportWriter<ShinsakaishiryoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<ShinsakaishiryoA3ReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.get事務局委員氏名(myBatisParameter);
        count = mapper.get事務局情報件数(myBatisParameter);
        businessList = new ArrayList<>();
        report = new ShinsakaishiryoA3Report(businessList);
        no = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUSHINASKAIIINJOHO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517001.getReportId().value()).create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    @Override
    protected void process(ShinsakaiTaiyosyaJohoEntity entity) {
        entity.setJimukyoku(true);
        JimuShinsakaishiryoBusiness business = new JimuShinsakaishiryoBusiness(paramter, entity, shinsakaiIinJohoList, no, count);
        report.addBusiness(business);
        no = no + 1;
    }

    @Override
    protected void afterExecute() {
        report.writeBy(reportSourceWriterA3);
    }
}
