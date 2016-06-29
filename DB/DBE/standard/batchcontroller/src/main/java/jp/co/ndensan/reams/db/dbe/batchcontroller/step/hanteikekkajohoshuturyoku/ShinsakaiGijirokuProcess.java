/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku.ShinsakaiGijirokuReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.IinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiGijirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku.IHanteiKekkaJohoShuturyokuMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会議事録のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class ShinsakaiGijirokuProcess extends BatchProcessBase<ShinsakaiKekkaJohoRelateEntity> {

    private static final ReportId ID = ReportIdDBE.DBE525003.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getShinsakaiKekkaJoho");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private HanteiKekkaJohoShuturyokuMybatisParameter mybatisParameter;
    private ShinsakaiGijirokuEntity shinsakaiGijirokuEntity;
    private RDateTime システム時刻;
    private List<IinJohoRelateEntity> 委員情報;
    private ShinsakaiKaisaiKekkaJohoEntity 審査会情報;
    private int 未判定;
    private int 未審査;
    private int 一次判定を変更した件数;
    private int 審査会意見を付した件数;

    @BatchWriter
    private BatchReportWriter<ShinsakaiGijirokuReportSource> batchReportWriter;
    private ReportSourceWriter<ShinsakaiGijirokuReportSource> reportSourceWriter;

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
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        委員情報 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getIinJoho(mybatisParameter);
        for (IinJohoRelateEntity entity : 委員情報) {
            if (Sikaku.ホームヘルパー.getコード().equals(entity.getShinsakaiIinShikakuCode())
                    || Sikaku.介護職員.getコード().equals(entity.getShinsakaiIinShikakuCode())) {
                entity.setChosaIn(entity.getShinsakaiIinShimei());
            } else {
                entity.setShinsakaiIin(entity.getShinsakaiIinShimei());
            }
            if (Sikaku.その他.getコード().equals(entity.getShinsakaiIinShikakuCode())) {
                entity.setSonoTa(entity.getShinsakaiIinShimei());
            }
        }
        審査会情報 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getShinsakaiJoho(mybatisParameter);
        未判定 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getMiHanteiKensu(mybatisParameter);
        未審査 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getMishinSaKensu(mybatisParameter);
        一次判定を変更した件数 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getItiDoHanteiHenkoKensu(mybatisParameter);
        審査会意見を付した件数 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).getSinSakaiIkenTukeKensu(mybatisParameter);

    }

    @Override
    protected void process(ShinsakaiKekkaJohoRelateEntity entity) {
        shinsakaiGijirokuEntity.set作成年月日(システム時刻);
        shinsakaiGijirokuEntity.set委員情報(委員情報);
        shinsakaiGijirokuEntity.set審査会情報(審査会情報);
        shinsakaiGijirokuEntity.set審査会審査結果等(entity);
        shinsakaiGijirokuEntity.set未判定(未判定);
        shinsakaiGijirokuEntity.set未審査(未審査);
        shinsakaiGijirokuEntity.set一次判定を変更した件数(一次判定を変更した件数);
        shinsakaiGijirokuEntity.set審査会意見を付した件数(審査会意見を付した件数);
        ShinsakaiGijirokuReport report = new ShinsakaiGijirokuReport(shinsakaiGijirokuEntity);
        report.writeBy(reportSourceWriter);
    }
}
