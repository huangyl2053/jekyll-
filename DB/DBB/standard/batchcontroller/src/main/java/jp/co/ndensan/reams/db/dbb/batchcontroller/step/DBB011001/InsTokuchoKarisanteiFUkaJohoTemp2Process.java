/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranTeisiEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴仮算定計算後賦課情報Tempに登録（特徴停止分）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsTokuchoKarisanteiFUkaJohoTemp2Process extends BatchProcessBase<TokuchoKarisanteiKekkaIchiranTeisiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select特徴仮算定計算後賦課情報_特徴停止");
    private static final RString 特徴仮算定計算後賦課情報テーブル_NAME = new RString("TokuchoKariKeisangoFukaTemp");
    private static final int INT_1 = 1;
    private TokuchoKarisanteiFukaProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.set調定年度BeforeYear(processParameter.get調定年度().minusYear(INT_1));
        parameter.set賦課年度(processParameter.get賦課年度());
        parameter.set賦課年度BeforeYear(processParameter.get賦課年度().minusYear(INT_1));
        parameter.set調定日時(processParameter.get調定日時());
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(特徴仮算定計算後賦課情報テーブル_NAME, TokuchoKariKeisangoFukaTempEntity.class);
    }

    @Override
    protected void process(TokuchoKarisanteiKekkaIchiranTeisiEntity entity) {
        TokuchoKariKeisangoFukaTempEntity 特徴仮算定計算後賦課情報Entity = new TokuchoKariKeisangoFukaTempEntity();
        TokuchoKariSanteiFukaManagerBatch.createInstance().set特徴仮算定計算後賦課情報_特徴停止(特徴仮算定計算後賦課情報Entity, entity);
        tempDbWriter.insert(特徴仮算定計算後賦課情報Entity);
    }

}
