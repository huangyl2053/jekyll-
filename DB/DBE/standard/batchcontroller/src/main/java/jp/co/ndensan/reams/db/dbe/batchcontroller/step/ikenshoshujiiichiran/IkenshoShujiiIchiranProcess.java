/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshoshujiiichiran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.ikenshoshujiiichiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 医療機関・主治医一覧表_バッチフ処理クラスです。
 */
public class IkenshoShujiiIchiranProcess extends BatchKeyBreakBase<IkenshoShujiiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoshujiiichiran."
            + "IkenshoShujiiIchiranRelateMapper.getIkenshoShujiiIchiranRelateEntity");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("listIchiranhyoUpper_1")));

    IkenshoShujiiIchiranHeadItem headItem;
    List<IkenshoShujiiIchiranBodyItem> bodyItemList;
    IkenshoShujiiIchiranProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
        headItem = new IkenshoShujiiIchiranHeadItem(
                processParameter.getShichosonCode(),
                processParameter.getShichosonName(),
                processParameter.getIryoKikanCodeFrom(),
                processParameter.getIryoKikanCodeTo(),
                processParameter.getShujiiCodeFrom(),
                processParameter.getShujiiCodeTo(),
                processParameter.getJyokyo(),
                processParameter.getOutputSort(),
                processParameter.getNextpage());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, IkenshoShujiiIchiranProcessParameter.
                to主治医一覧表作成MybatisParameter(processParameter));
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE591001.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiIryokikanShujiiIchiranhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void usualProcess(IkenshoShujiiIchiranRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void keyBreakProcess(IkenshoShujiiIchiranRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            IkenshoShujiiIchiranReport report = IkenshoShujiiIchiranReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            bodyItemList = new ArrayList<>();
        }
    }

    @Override
    protected void afterExecute() {

        IkenshoShujiiIchiranReport report = IkenshoShujiiIchiranReport.createFrom(headItem, bodyItemList);
        report.writeBy(reportSourceWriter);
    }

    private IkenshoShujiiIchiranBodyItem setBodyItem(IkenshoShujiiIchiranRelateEntity entity) {
        return new IkenshoShujiiIchiranBodyItem(
                entity.getIryokikanCode().value(),
                entity.getIryoKikanMeishoKana(),
                entity.getDaihyoshaNameKana(),
                entity.getYubinNo() == null ? RString.EMPTY : entity.getYubinNo().value(),
                entity.getTelNo() == null ? RString.EMPTY : entity.getTelNo().value(),
                entity.isIryokikanJokyoFlag(),
                entity.getShujiiCode(),
                entity.getShujiiKana() == null ? RString.EMPTY : entity.getShujiiKana().value(),
                entity.getSeibetsu() == null ? RString.EMPTY : entity.getSeibetsu().getKey(),
                entity.isShujiiJokyoFlag(),
                entity.getIryoKikanMeisho(),
                entity.getDaihyoshaName() == null ? RString.EMPTY : entity.getDaihyoshaName().value(),
                entity.getJusho(),
                entity.getShujiiName() == null ? RString.EMPTY : entity.getShujiiName().value(),
                entity.getShinryokaName());
    }

    private boolean hasBrek(IkenshoShujiiIchiranRelateEntity before, IkenshoShujiiIchiranRelateEntity current) {
        return !before.getShujiiCode().equals(current.getShujiiCode());
    }
}
