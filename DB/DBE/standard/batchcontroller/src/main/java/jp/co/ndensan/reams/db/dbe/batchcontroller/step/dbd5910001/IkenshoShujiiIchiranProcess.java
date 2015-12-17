/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbd5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.processprm.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.IkenshoShujiiIchiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
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
 * 医療機関・主治医一覧表_バッチフ処理クラスです
 */
public class IkenshoShujiiIchiranProcess extends BatchProcessBase<IkenshoShujiiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.IkenshoShujiiIchiran.IkenshoShujiiIchiranRelateMapper.getIkenshoShujiiIchiranRelateEntity");

    private static final ReportId ID = new ReportId("DBD5910001");

    List<IkenshoShujiiIchiranBodyItem> bodyItemList = new ArrayList<>();

    @BatchWriter
    private BatchReportWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> batchReportWriter;
    InputParameter<IkenshoShujiiIchiranProcessParameter> parameterClass;
    private ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
        return new BatchDbReader(MYBATIS_SELECT_ID,
                IkenshoShujiiIchiranProcessParameter.to主治医一覧表作成MybatisParameter(parameterClass.getValue()));
    }

    @Override
    protected void process(IkenshoShujiiIchiranRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        IkenshoShujiiIchiranProcessParameter processParameter = parameterClass.getValue();
        IkenshoShujiiIchiranHeadItem headItem = new IkenshoShujiiIchiranHeadItem(
                        processParameter.getShichosonCode(),
                        processParameter.getShichosonName(),
                        processParameter.getIryoKikanCodeFrom(),
                        processParameter.getIryoKikanCodeTo(),
                        processParameter.getShujiiCodeFrom(),
                        processParameter.getShujiiCodeTo(),
                        processParameter.getJyokyo(),
                        processParameter.getOutputSort(),
                        processParameter.getNextpage());
        IkenshoShujiiIchiranReport report = IkenshoShujiiIchiranReport.createFrom(headItem, bodyItemList);
        report.writeBy(reportSourceWriter);
    }

    private IkenshoShujiiIchiranBodyItem setBodyItem(IkenshoShujiiIchiranRelateEntity entity) {
        return new IkenshoShujiiIchiranBodyItem(
                entity.getIryokikanCode().value(),
                entity.getIryoKikanMeishoKana(),
                entity.getDaihyoshaNameKana(),
                entity.getYubinNo().value(),
                entity.getTelNo().value(),
                entity.isIryokikanJokyoFlag(),
                entity.getShujiiCode().value(),
                entity.getShujiiKana().value(),
                entity.getSeibetsu().getKey(),
                entity.isShujiiJokyoFlag(),
                entity.getIryoKikanMeisho(),
                entity.getDaihyoshaName().value(),
                entity.getJusho(),
                entity.getShujiiName().value(),
                entity.getShinryokaName());
    }
}
