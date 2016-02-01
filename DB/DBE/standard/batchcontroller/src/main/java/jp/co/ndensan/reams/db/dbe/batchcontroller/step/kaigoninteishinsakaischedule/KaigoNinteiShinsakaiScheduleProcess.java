/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 介護認定審査会スケジュール表_バッチフ処理クラスです
 */
public class KaigoNinteiShinsakaiScheduleProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule."
            + "IKaigoNinteiShinsakaiScheduleMapper.get出力明細一覧");
    private static final ReportId REPORT_ID = new ReportId("DBE525005");
//    private KaigoKekkaTaishouIchiranHeadItem headItem;
//    private List<KaigoKekkaTaishouIchiranBodyItem> bodyItemList;
    private KaigoNinteiShinsakaiScheduleProcessParamter processParamter;
    private KaigoNinteiShinsakaiScheduleMybitisParamter mybatisParamter;
//    @BatchWriter
//    private BatchReportWriter<KekkatsuchiTaishoshaIchiranReportSource> batchWrite;
//    private ReportSourceWriter<KekkatsuchiTaishoshaIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisParamter = processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter();
        // bodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParamter);
    }

    @Override
    protected void createWriter() {
//        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        //bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        RDate.getNowDate().wareki().separator(Separator.JAPANESE);
        //TODO QA538 業務Config広域連合がない
        //BusinessConfig.get(広域連合, SubGyomuCode.DBE認定支援);
        //        headItem = new KaigoKekkaTaishouIchiranHeadItem(RString.EMPTY, processParamter.getNijiHanteiYMDFrom(),
        //                processParamter.getNijiHanteiYMDTo(), RDate.getNowDate().toDateString(), bodyItemList.size());
        // KaigoKekkaTaishouIchiranReport report = KaigoKekkaTaishouIchiranReport.createFrom(headItem, bodyItemList);
        //report.writeBy(reportSourceWriter);
        if (processParamter.getShinsakaiIinCodeList().isEmpty()) {
            //帳票「介護認定審査会スケジュール表」発行だけ
        } else {
            //帳票「介護認定審査会スケジュール表」と「「介護認定審査会スケジュール表かがみ」発行
        }
    }

//    private KaigoKekkaTaishouIchiranBodyItem setBodyItem(HanteiKekkaJohoShutsuryokuRelateEntity entity) {
//        return new KaigoKekkaTaishouIchiranBodyItem(
//                entity.getShinsakaiKaisaiNo(),
//                entity.getShinsakaiKaisaiYMD(),
//                entity.getNinteiShinseiYMD(),
//                entity.getHihokenshaNo(),
//                entity.getHihokenshaName(),
//                entity.getHihokenshaKana(),
//                entity.getSeinengappiYMD(),
//                Seibetsu.toValue(entity.getSeibetsu()).get名称(),
//                YokaigoJotaiKubun09.toValue(entity.getNijiHanteiKekka()).get名称());
//    }
}
