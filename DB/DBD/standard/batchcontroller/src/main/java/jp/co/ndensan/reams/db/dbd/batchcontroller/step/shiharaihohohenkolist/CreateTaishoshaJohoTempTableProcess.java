/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.definition.core.outputorderkey.ShiharaiHohoHenkoHaakuIchiranOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohokanrilist.ShiharaiHohoKanriListMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.CreateTaishoshaJohoTempTableProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更管理リスト作成_バッチフ処理クラスです。
 *
 * @reamsid_L DBD-3630-040 liangbc
 */
public class CreateTaishoshaJohoTempTableProcess extends BatchProcessBase<HihokenshaNo> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohokanrilist."
                    + "IShiharaiHohoKanriListMapper.selectTaishoshaJoho");
    private CreateTaishoshaJohoTempTableProcessParameter processParamter;
    private RString 出力順;
//    private LasdecCode 市町村コード;
//    private RString 市町村名;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void beforeExecute() {
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                new ReportId(processParamter.get帳票ID()), processParamter.getReamsLoginID(), processParamter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(ShiharaiHohoHenkoHaakuIchiranOrderKey.class, outputOrder);
//        IAssociationFinder finder = AssociationFinderFactory.createInstance();
//        Association 地方公共団体 = finder.getAssociation();
//        市町村コード = 地方公共団体.get地方公共団体コード();
//        市町村名 = 地方公共団体.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, ShiharaiHohoKanriListMapperParameter.createParameter(processParamter, 出力順));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TaishoshaJohoTempTableEntity.class)
                .tempTableName(TaishoshaJohoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(HihokenshaNo hihokenshaNo) {
        TaishoshaJohoTempTableEntity entity = new TaishoshaJohoTempTableEntity(hihokenshaNo);
        tmpTableWriter.insert(entity);
    }
}
