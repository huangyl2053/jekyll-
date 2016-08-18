/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.KogakuShikyuShinseishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費支給申請書の発行の処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class KogakuServiceShikyuShinseishoOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get支給申請書データ");
    private static final RString 保険者印 = new RString("0001");
    private static final RString ORDER_BY = new RString("order by");
    private static final KinyuKikanCode 金融機関コード_9900 = new KinyuKikanCode("9900");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    private RString 認証者名;
    private RString 注意文;
    private int count;

    @BatchWriter
    private BatchReportWriter<KogakuShikyuShinseishoSource> shinseishoBatchReportWriter;
    private ReportSourceWriter<KogakuShikyuShinseishoSource> shinseishoReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<KogakuShikyuShinseishoYuchoSource> shinseishoYuchoBatchReportWriter;
    private ReportSourceWriter<KogakuShikyuShinseishoYuchoSource> shinseishoYuchoReportSourceWriter;

    @Override
    protected void initialize() {
        count = 1;
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 保険者印);
        認証者名 = 認証者.get市町村付与名称(AssociationFinderFactory.createInstance().getAssociation());
        IOutputOrder 出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200091.getReportId(), parameter.getShutsuryokujunId());
        if (出力順 != null) {
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuJigyoShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
        }

        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100068.getReportId(), KamokuCode.EMPTY, 1);
        if (map == null) {
            注意文 = RString.EMPTY;
        } else {
            注意文 = map.get(1);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        shinseishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100068.getReportId().value()).create();
        shinseishoReportSourceWriter = new ReportSourceWriter<>(shinseishoBatchReportWriter);

        shinseishoYuchoBatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100069.getReportId().value()).create();
        shinseishoYuchoReportSourceWriter = new ReportSourceWriter<>(shinseishoYuchoBatchReportWriter);
    }

    @Override
    protected void process(ShinseiJohoChohyoTempEntity entity) {
        if (金融機関コード_9900.equals(entity.getKinyuKikanCodeChohyo())) {
            KogakuShikyuShinseishoYuchoEntity param = new KogakuShikyuShinseishoYuchoEntity();
            param.setシステム日付(FlexibleDate.getNowDate());
            param.set注意文(注意文);
            param.set申請情報帳票発行一時(entity);
            param.set認証者役職名(認証者名);
            param.set連番(new RString(count));
            param.set金融機関表示(parameter.isKinyuKikanHyoji());

            KogakuShikyuShinseishoYuchoReport report = new KogakuShikyuShinseishoYuchoReport(param);
            report.writeBy(shinseishoYuchoReportSourceWriter);
        } else {
            KogakuShikyuShinseishoEntity param = new KogakuShikyuShinseishoEntity();
            param.setシステム日付(FlexibleDate.getNowDate());
            param.set申請情報帳票発行一時(entity);
            param.set認証者役職名(認証者名);
            param.set連番(new RString(count));
            param.set注意文(注意文);

            KogakuShikyuShinseishoReport report = new KogakuShikyuShinseishoReport(param);
            report.writeBy(shinseishoReportSourceWriter);
        }
        count = count + 1;
    }
}
