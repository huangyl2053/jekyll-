/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.ue.uex.entity.relate.GyomuHihokenshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 業務被保険者情報作成（年次）
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateGyomuHokenshaJohoNenjiProcess extends BatchProcessBase<TokuchoTaishoshaDoteiCombineEntity> {

    private TokuchoTaishoshaDoteiIkatsu manager;
    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get介護の３つのテーブルの全件");

    @BatchWriter
    BatchEntityCreatedTempTableWriter gyomuHihokenshaTempTableWriter;

    static {
        TABLE_NAME = new RString("GyomuHihokenshaTemp");
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void createWriter() {
        gyomuHihokenshaTempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        GyomuHihokenshaTempEntity.class);
    }

    @Override
    protected void process(TokuchoTaishoshaDoteiCombineEntity entity) {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void afterExecute() {
        manager.createGyomuHokenshaJohoNenji();
    }

}
