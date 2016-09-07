/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami.HanteikekkaKagamiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査判定結果（鑑）のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class HanteikekkaKagamiProcess extends BatchProcessBase<DbT5511ShinsakaiKaisaiKekkaJohoEntity> {

    private static final ReportId ID = ReportIdDBE.DBE525006.getReportId();
    private static final int パターン番号 = 1;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getShinsakaiKaisaiKekkaJoho");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private RDateTime システム時刻;

    @BatchWriter
    private BatchReportWriter<HanteikekkaKagamiReportSource> batchReportWriter;
    private ReportSourceWriter<HanteikekkaKagamiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        システム時刻 = RDateTime.now();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(DbT5511ShinsakaiKaisaiKekkaJohoEntity entity) {
        HanteikekkaKagamiEntity hanteikekkaKagamiEntity = new HanteikekkaKagamiEntity();
        hanteikekkaKagamiEntity.setPrintTimeStamp(システム時刻);
        hanteikekkaKagamiEntity.setShinsakaiKaisaiYMD(entity.getShinsakaiKaisaiYMD());
        hanteikekkaKagamiEntity.setGogitaiNo(entity.getGogitaiNo());
        hanteikekkaKagamiEntity.setNinshoshaSource(ReportUtil.get認証者情報(
                SubGyomuCode.DBE認定支援, ID,
                new FlexibleDate(システム時刻.getDate().toDateString()),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(),
                KenmeiFuyoKubunType.付与なし,
                reportSourceWriter));
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ID, KamokuCode.EMPTY, パターン番号);
        hanteikekkaKagamiEntity.setTsuchibun1(通知文.get(INDEX_1));
        hanteikekkaKagamiEntity.setTsuchibun2(通知文.get(INDEX_2));
        HanteikekkaKagamiReport report = new HanteikekkaKagamiReport(hanteikekkaKagamiEntity);
        report.writeBy(reportSourceWriter);
    }

}
