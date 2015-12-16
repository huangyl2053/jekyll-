/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.IkenshoShujiiIchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranItem;
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
 *
 * @author zuotao
 */
public class IkenshoShujiiIchiranProcess extends BatchProcessBase<IkenshoShujiiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.syujii.shujiiiryokikanjoho.IShujiiIryoKikanJohoMapper.getShujiiIryoKikanShujiiJouhou");

    private static final ReportId ID = new ReportId("DBD5900010");

    List<IkenshoShujiiIchiranItem> printOutList = new ArrayList<>();

    @BatchWriter
    private BatchReportWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> batchReportWriter;
    InputParameter<IkenshoShujiiIchiranProcessParameter> parameterClass;
    private ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        super.initialize();
        printOutList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameterClass.getValue());
    }

    @Override
    protected void process(IkenshoShujiiIchiranRelateEntity entity) {
//        printOutList.add(setItem(entity));
    }

    @Override
    protected void afterExecute() {
    }

//    private IkenshoShujiiIchiranItem setItem(IkenshoShujiiIchiranRelateEntity entity) {
//        IkenshoShujiiIchiranItem item = new IkenshoShujiiIchiranItem(
//                ,
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID,
//                MYBATIS_SELECT_ID, 
//                MYBATIS_SELECT_ID)
//    }
    
}
