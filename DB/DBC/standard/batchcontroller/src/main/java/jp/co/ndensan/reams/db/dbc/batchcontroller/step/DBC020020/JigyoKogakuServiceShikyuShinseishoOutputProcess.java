/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020020;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho.KogakuJigyoShikyuShinseishoYuchoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujigyoshikyushinseishoyucho.KogakuJigyoShikyuShinseishoYuchoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費（総合事業）支給申請書の発行の処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoKogakuServiceShikyuShinseishoOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get支給申請書データ");
    private static final RString 保険者印 = new RString("0001");
    private static final RString ORDER_BY = new RString("order by");
    private static final KinyuKikanCode 金融機関コード_9900 = new KinyuKikanCode("9900");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    private RString 認証者名;
    private RString 注意文;
    private int count1;
    private int count2;

    @BatchWriter
    private BatchReportWriter<KogakuJigyoShikyuShinseishoSource> shinseishoBatchReportWriter;
    private ReportSourceWriter<KogakuJigyoShikyuShinseishoSource> shinseishoReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<KogakuJigyoShikyuShinseishoYuchoSource> yuchoBatchReportWriter;
    private ReportSourceWriter<KogakuJigyoShikyuShinseishoYuchoSource> yuchoReportSourceWriter;

    @Override
    protected void initialize() {
        count1 = 1;
        count2 = 1;
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 保険者印);
        認証者名 = 認証者.get市町村付与名称(AssociationFinderFactory.createInstance().getAssociation());
        IOutputOrder 出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200091.getReportId(), parameter.getShutsuryokujunId());
        if (出力順 != null) {
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuJigyoShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
        }

        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100070.getReportId(), KamokuCode.EMPTY, 1);
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
        shinseishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100070.getReportId().value()).create();
        shinseishoReportSourceWriter = new ReportSourceWriter<>(shinseishoBatchReportWriter);

        yuchoBatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100071.getReportId().value()).create();
        yuchoReportSourceWriter = new ReportSourceWriter<>(yuchoBatchReportWriter);
    }

    @Override
    protected void process(ShinseiJohoChohyoTempEntity entity) {
        if (金融機関コード_9900.equals(entity.getKinyuKikanCodeChohyo())) {
            KogakuJigyoShikyuShinseishoYuchoEntity param = new KogakuJigyoShikyuShinseishoYuchoEntity();
            entity.setEditJusho(get住所Edit(entity));
            param.setシステム日付(RDateTime.now());
            param.set注意文(注意文);
            param.set帳票出力対象データ(entity);
            param.set認証者役職名(認証者名);
            param.set連番(new RString(count1));
            param.setIs金融機関表示(parameter.isKinyuKikanHyoji());

            KogakuJigyoShikyuShinseishoYuchoReport report = new KogakuJigyoShikyuShinseishoYuchoReport(param);
            report.writeBy(yuchoReportSourceWriter);
            count1 = count1 + 1;
        }
        KogakuJigyoShikyuShinseishoEntity param1 = new KogakuJigyoShikyuShinseishoEntity();
        entity.setEditJusho(get住所Edit(entity));
        param1.setシステム日付(RDate.getNowDate());
        param1.set申請情報帳票発行一時(entity);
        param1.set認証者役職名(認証者名);
        param1.set連番(new RString(count2));
        param1.set注意文(注意文);

        KogakuJigyoShikyuShinseishoReport report1 = new KogakuJigyoShikyuShinseishoReport(param1);
        report1.writeBy(shinseishoReportSourceWriter);
        count2 = count2 + 1;

    }
    
    private RString get住所Edit(ShinseiJohoChohyoTempEntity entity) {
        RString 住所 = entity.getJushoChohyo() == null ? RString.EMPTY : entity.getJushoChohyo().getColumnValue();
        RString 番地 = entity.getBanchi() == null ? RString.EMPTY : entity.getBanchi().getColumnValue();
        RString 方書 = entity.getKatagaki() == null ? RString.EMPTY : entity.getKatagaki().getColumnValue();
        return 住所.concat(番地).concat(RString.EMPTY).concat(方書);
    }
}
