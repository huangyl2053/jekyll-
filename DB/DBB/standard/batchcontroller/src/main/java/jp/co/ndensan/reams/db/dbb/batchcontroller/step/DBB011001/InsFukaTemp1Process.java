/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報一時テーブルに登録processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsFukaTemp1Process extends BatchProcessBase<FukaJohoTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select資格等最新化_４月開始登録");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final int INT_1 = 1;
    private static final RString 賦課情報一時テーブル_NAME = new RString("DbT2002FukaJohoTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.set調定年度BeforeYear(processParameter.get調定年度().minusYear(INT_1));
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(賦課情報一時テーブル_NAME, FukaJohoTempEntity.class);
    }

    @Override
    protected void process(FukaJohoTempEntity entity) {
        tempDbWriter.insert(entity);
    }
}
