/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuGaikyouTokkiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran.GaikyoTokkiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuGaikyoTokkiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ImjJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用概況特記一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuGaikyouTokkiIranDataSakuseiA3Process extends BatchProcessBase<GaikyoTokkiEntity> {

    private static final RString SELECT_JIMUGAIKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getJimuGaikyoTokki");
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private JimuGaikyoTokkiMyBatisParameter myBatisParameter;
    private List<GaikyoTokkiEntity> 概況特記一覧表情報;
    private List<ImjJohoEntity> 概況特記イメージ情報;
    private JimuGaikyouTokkiBusiness business;
    @BatchWriter
    private BatchReportWriter<GaikyoTokkiIchiranReportSource> batchWriteA3;
    private ReportSourceWriter<GaikyoTokkiIchiranReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuGaikyoTokkiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setImageKubun(TokkijikoTextImageKubun.テキスト.getコード());
        myBatisParameter.setGenponKubun(TokkijikoTextImageKubun.イメージ.getコード());
        概況特記一覧表情報 = mapper.getJimuGaikyoTokki(myBatisParameter);
        概況特記イメージ情報 = mapper.getJimuImjJoho(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUGAIKYO, myBatisParameter);
    }

    @Override
    protected void process(GaikyoTokkiEntity entity) {
        business = new JimuGaikyouTokkiBusiness(entity, 概況特記一覧表情報, 概況特記イメージ情報, paramter);
        GaikyoTokkiIchiranReport report = new GaikyoTokkiIchiranReport(business);
        report.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517007.getReportId().getColumnValue()).create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    @Override
    protected void afterExecute() {
    }
}
