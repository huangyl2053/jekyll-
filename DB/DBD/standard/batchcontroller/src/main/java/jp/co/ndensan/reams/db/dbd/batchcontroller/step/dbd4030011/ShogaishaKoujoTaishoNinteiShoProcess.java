/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd4030011;

import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100025.ShogaishaKojoNinteishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011.ShogaishakojoTaishoshaListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.ninteishojoho.NinteiShoJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 障がい者控除対象者認定書リスト作成帳票出力です。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class ShogaishaKoujoTaishoNinteiShoProcess extends BatchProcessBase<NinteishoJohoBusiness> {

    private static final ReportId REPORT_DBD100025 = ReportIdDBD.DBD100025.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujotaishoninteisho."
                    + "IShogaishaKoujoTaishoNinteiShoMapper.控除対象者データの取得");
    private ShogaishakojoTaishoshaListProcessParameter parameter;

    @BatchWriter
    private BatchReportWriter<NinteishoJohoReportSource> batchReportWrite;
    private ReportSourceWriter<NinteishoJohoReportSource> reportSourceWriter;
    private NinshoshaSource ninshoshaSource;

    @Override
    protected void beforeExecute() {
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShogaishaKojoTaishoshaListMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD100025.value(), SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(NinteishoJohoBusiness target) {

        NinteiShoJohoFinder finder = NinteiShoJohoFinder.createInstance();
        target = finder.setTarget(target, parameter, reportSourceWriter);

        ShogaishaKojoNinteishoReport report = new ShogaishaKojoNinteishoReport(target, ninshoshaSource);
        report.writeBy(reportSourceWriter);
    }
}
