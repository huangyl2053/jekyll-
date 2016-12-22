/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
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
 * 事務局予備判定記入表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuHanteiDataSakuseiA4Process extends BatchKeyBreakBase<HanteiJohoEntity> {

    private static final RString SELECT_JIMUHANTEIJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.getJimuHanteiJoho");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JimukyokuyoYobihanteiKinyuhyoReportSource.ReportSourceFields.shinsakaiKaisaiNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private JimuTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private JimuYobihanteiKinyuhyoBusiness business;
    private int データ件数;
    private static final int 満ページ件数 = 10;
    @BatchWriter
    private BatchReportWriter<JimukyokuyoYobihanteiKinyuhyoReportSource> batchWrite;
    private ReportSourceWriter<JimukyokuyoYobihanteiKinyuhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        データ件数 = 0;
        myBatisParameter = paramter.toJimuTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setIsShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setIsShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUHANTEIJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(HanteiJohoEntity entity) {
        business = new JimuYobihanteiKinyuhyoBusiness(entity, paramter);
        JimukyokuyoYobihanteiKinyuhyoReport report = new JimukyokuyoYobihanteiKinyuhyoReport(business);
        データ件数 = データ件数 + 1;
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517002.getReportId().value())
                .addBreak(new BreakerCatalog<JimukyokuyoYobihanteiKinyuhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected void keyBreakProcess(HanteiJohoEntity t) {
        if (データ件数 % 満ページ件数 == 0) {
            JimukyokuyoYobihanteiKinyuhyoReport report = new JimukyokuyoYobihanteiKinyuhyoReport(business);
            report.writeBy(reportSourceWriter);
        }
    }
}
