/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.IraishoIkkatsuHakkoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「主治医意見書作成依頼履歴一覧」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-130 xuyannan
 */
public class ShujiiIkensho_DBE230004Process extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書作成依頼履歴一覧");
    private static final ReportId 帳票ID = ReportIdDBE.DBE230004.getReportId();
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;
    private IShujiiIkenshoTeishutsuIraishoHakkoMapper mapper;
    private List<RString> 被保険者番号List;

    @BatchWriter
    private BatchReportWriter<IkenshoirairirekiIchiranReportSource> batchWriter;
    private ReportSourceWriter<IkenshoirairirekiIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShujiiIkenshoTeishutsuIraishoHakkoMapper.class);
        被保険者番号List = new ArrayList<>();
        List<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> 主治医意見書提出依頼書
                = mapper.get主治医意見書提出依頼書発行(processParamter.toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter());
        for (ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity : 主治医意見書提出依頼書) {
            被保険者番号List.add(entity.get被保険者番号());
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, ShujiiIkenshoMybatisParameter.createSelectByKeyParam(被保険者番号List));
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        IkenshoirairirekiIchiranReport report = IkenshoirairirekiIchiranReport.createFrom(
                new IraishoIkkatsuHakkoBusiness(entity, null).setDBE230004Item());
        report.writeBy(reportSourceWriter);
    }
}
