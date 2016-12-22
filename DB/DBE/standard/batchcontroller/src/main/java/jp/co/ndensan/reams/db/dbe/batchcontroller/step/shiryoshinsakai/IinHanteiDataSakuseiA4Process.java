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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IinYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReportSource;
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
 * 委員用予備判定記入表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinHanteiDataSakuseiA4Process extends BatchKeyBreakBase<HanteiJohoEntity> {

    private static final RString SELECT_HANTEIJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getHanteiJoho");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(IinYobihanteiKinyuhyoReportSource.ReportSourceFields.shinsakaiKaisaiNo.name())));
    private static final int 満ページ件数 = 10;
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IinYobihanteiKinyuhyoBusiness business;
    private int データ件数;

    @BatchWriter
    private BatchReportWriter<IinYobihanteiKinyuhyoReportSource> batchWrite;
    private ReportSourceWriter<IinYobihanteiKinyuhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        データ件数 = 0;
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HANTEIJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(HanteiJohoEntity entity) {
        business = new IinYobihanteiKinyuhyoBusiness(entity, paramter);
        IinYobihanteiKinyuhyoReport report = IinYobihanteiKinyuhyoReport.createFrom(business);
        データ件数 = データ件数 + 1;
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517022.getReportId().value())
                .addBreak(new BreakerCatalog<IinYobihanteiKinyuhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected void keyBreakProcess(HanteiJohoEntity t) {
        if (データ件数 % 満ページ件数 == 0) {
            IinYobihanteiKinyuhyoReport report = IinYobihanteiKinyuhyoReport.createFrom(business);
            report.writeBy(reportSourceWriter);
        }
    }
}
