/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護認定審査会スケジュール表_バッチフ処理クラスです
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class KaigoNinteiShinsakaiScheduleProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule."
            + "IKaigoNinteiShinsakaiScheduleMapper.get出力明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514001.getReportId();
    private int count = 1;
    private List<ShinsakaisukejuruhyoBodyItem> bodyItemList;
    private KaigoNinteiShinsakaiScheduleProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ShinsakaisukejuruhyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            ShinsakaisukejuruhyoHeadItem headItem = new ShinsakaisukejuruhyoHeadItem();
            headItem.set年度(RDate.getNowDate().wareki().eraType(EraType.KANJI).getYear());
            headItem.set広域連合(DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            ShinsakaisukejuruhyoReport report = ShinsakaisukejuruhyoReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private ShinsakaisukejuruhyoBodyItem setBodyItem(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        ShinsakaisukejuruhyoBodyItem bodyItem = new ShinsakaisukejuruhyoBodyItem();
        bodyItem.set項番(count++);
        bodyItem.set審査会番号(entity.getShinsakai());
        bodyItem.set開催日(entity.getKaisaiYMD());
        bodyItem.set開催時間(entity.getTime());
        bodyItem.set合議体(entity.getGogitai());
        bodyItem.set会場(entity.getKaijyo());
        bodyItem.set住所(entity.getKaijyoJusho());
        bodyItem.set電話番号(entity.getKaijyoTelNo());
        return bodyItem;
    }
}
