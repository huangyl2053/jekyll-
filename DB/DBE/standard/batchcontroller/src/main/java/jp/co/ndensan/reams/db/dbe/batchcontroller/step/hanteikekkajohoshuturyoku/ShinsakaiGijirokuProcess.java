/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiGijirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku.IHanteiKekkaJohoShuturyokuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会議事録のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class ShinsakaiGijirokuProcess extends BatchProcessBase<ShinsakaiKekkaJohoRelateEntity> {

//    private static final ReportId ID = ReportIdDBE.DBE525003.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getShinsakaiKekkaJoho");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private HanteiKekkaJohoShuturyokuMybatisParameter mybatisParameter;
    private IHanteiKekkaJohoShuturyokuMapper mapper;
    private ShinsakaiGijirokuEntity shinsakaiGijirokuEntity;
    private RDateTime システム時刻;

    // TODO 帳票について、未作成
//    @BatchWriter
//    private BatchReportWriter<ShinsakaiGijirokuReportSource> batchReportWriter;
//    private ReportSourceWriter<ShinsakaiGijirokuReportSource> reportSourceWriter;
    @Override
    protected void initialize() {
        システム時刻 = RDateTime.now();
        shinsakaiGijirokuEntity = new ShinsakaiGijirokuEntity();
        mybatisParameter = processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IHanteiKekkaJohoShuturyokuMapper.class);
    }

    @Override
    protected void process(ShinsakaiKekkaJohoRelateEntity entity) {
        shinsakaiGijirokuEntity.set作成年月日(システム時刻);
        shinsakaiGijirokuEntity.set委員情報(mapper.getIinJoho(mybatisParameter));
        shinsakaiGijirokuEntity.set審査会情報(mapper.getShinsakaiJoho(mybatisParameter));
        shinsakaiGijirokuEntity.set審査会審査結果等(entity);
        shinsakaiGijirokuEntity.set未判定(mapper.getMiHanteiKensu(mybatisParameter));
        shinsakaiGijirokuEntity.set未審査(mapper.getMishinSaKensu(mybatisParameter));
        shinsakaiGijirokuEntity.set一次判定を変更した件数(mapper.getItiDoHanteiHenkoKensu(mybatisParameter));
        shinsakaiGijirokuEntity.set審査会意見を付した件数(mapper.getSinSakaiIkenTukeKensu(mybatisParameter));
//        shinsakaiGijirokuReport report = new shinsakaiGijirokuReport(entity);
//        report.writeBy(reportSourceWriter);
    }
}
