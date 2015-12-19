/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshoShujiiIchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.processprm.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.ikenshoShujiiIchiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
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
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoShujiiIchiran.IkenshoShujiiIchiranRelateMapper.getIkenshoShujiiIchiranRelateEntity");

    List<IkenshoShujiiIchiranBodyItem> bodyItemList = new ArrayList<>();
    private static final ReportId REPORT_ID = new ReportId("DBE591001");
    @BatchWriter
    private BatchReportWriter<ItakusakiChosainIchiranReportSource> batchWrite;
    InputParameter<IkenshoShujiiIchiranProcessParameter> parameterClass;
    private ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {

        super.initialize();
        super.sqlParameter = IkenshoShujiiIchiranProcessParameter.
                to主治医一覧表作成MybatisParameter(parameterClass.getValue()).toHashMap();
    }

    @Override
    protected IBatchReader createReader() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        return new BatchDbReader(MYBATIS_SELECT_ID, super.sqlParameter);
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
                entity.getTelNo() == null ? RString.EMPTY : entity.getTelNo().value(),
                entity.getTelNo() == null ? RString.EMPTY : entity.getTelNo().value(),
                entity.isIryokikanJokyoFlag(),
                entity.getShujiiCode() == null ? RString.EMPTY : entity.getShujiiCode().value(),
                entity.getShujiiKana() == null ? RString.EMPTY : entity.getShujiiKana().value(),
                entity.getSeibetsu() == null ? RString.EMPTY : entity.getSeibetsu().getKey(),
                entity.isShujiiJokyoFlag(),
                entity.getIryoKikanMeisho(),
                entity.getDaihyoshaName() == null ? RString.EMPTY : entity.getDaihyoshaName().value(),
                entity.getJusho(),
                entity.getShujiiName() == null ? RString.EMPTY : entity.getShujiiName().value(),
                entity.getShinryokaName());
    }
}
