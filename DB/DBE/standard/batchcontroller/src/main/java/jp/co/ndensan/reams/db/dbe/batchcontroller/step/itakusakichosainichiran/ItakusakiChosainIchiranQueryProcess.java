/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.itakusakichosainichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itakusakichosainichiran.ItakusakiChosainIchiranQueryProcessParemeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itakusakichosainichiran.ItakusakiChosainIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 調査員一覧情報の取得バッチクラスです。
 */
public class ItakusakiChosainIchiranQueryProcess extends BatchProcessBase<ItakusakiChosainIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.itakusakichosainichiran."
                    + "IItakusakiChosainIchiranMapper.getNinteiChoSain");
    private static final ReportId REPORT_ID = new ReportId("DBE592001");
    private ItakusakiChosainIchiranQueryProcessParemeter paramter;
    List<ItakusakiChosainIchiranBodyItem> bodyItem = new ArrayList<>();
    InputParameter<ItakusakiChosainIchiranQueryProcessParemeter> parameterClass;
    @BatchWriter
    private BatchReportWriter<ItakusakiChosainIchiranReportSource> batchWrite;
    private ReportSourceWriter<ItakusakiChosainIchiranReportSource> retortWrite;

    @Override
    protected IBatchReader createReader() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        retortWrite = new ReportSourceWriter(batchWrite);
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParameter());
    }

    @Override
    protected void process(ItakusakiChosainIchiranRelateEntity entity) {
        bodyItem.add(setBodyItemm(entity));

    }

    @Override
    protected void afterExecute() {
        ItakusakiChosainIchiranHeadItem headItem = new ItakusakiChosainIchiranHeadItem(paramter.getItakusakiCodeFrom(),
                paramter.getItakusakiCodeTo(),
                paramter.getChosainNoFrom(),
                paramter.getChosainNoTo(),
                paramter.getJyoukyou(),
                paramter.getShichosonCode(),
                paramter.getShichosonMeisho(),
                paramter.getNarabiJun(),
                paramter.getNextPage());
        ItakusakiChosainIchiranReport report = ItakusakiChosainIchiranReport.createFrom(headItem, bodyItem);
        report.writeBy(retortWrite);

    }

    private ItakusakiChosainIchiranBodyItem setBodyItemm(ItakusakiChosainIchiranRelateEntity entity) {
        RString dDbT5910_YubinNo = RString.EMPTY;
        RString dbT5910_TelNo = RString.EMPTY;
        if (entity.getDbT5910_YubinNo() != null) {
            dDbT5910_YubinNo = entity.getDbT5910_YubinNo().value();
        }
        if (entity.getDbT5910_TelNo() != null) {
            dbT5910_TelNo = entity.getDbT5910_TelNo().value();
        }

        return new ItakusakiChosainIchiranBodyItem(entity.getDbT5910_NinteichosaItakusakiCode(),
                entity.getDbT5910_JigyoshaMeishoKana(),
                entity.getDbT5910_DaihyoshaNameKana(),
                dDbT5910_YubinNo,
                dbT5910_TelNo,
                entity.isDbT5910_JokyoFlag(),
                entity.getDbT5913_NinteiChosainNo(),
                entity.getDbT5913_ChosainKanaShimei(),
                entity.getDbT5913_ChosainShikaku(),
                entity.getDbT5913_ChosainShikaku(),
                entity.isDbT5913_JokyoFlag(),
                entity.getDbT5910_JigyoshaMeisho(),
                entity.getDbT5910_DaihyoshaName(),
                entity.getDbT5910_Jusho(),
                entity.getDbT5913_ChosainShimei(),
                entity.getDbT5913_Seibetsu(),
                entity.getDbT5913_ShozokuKikanName());
    }
}
