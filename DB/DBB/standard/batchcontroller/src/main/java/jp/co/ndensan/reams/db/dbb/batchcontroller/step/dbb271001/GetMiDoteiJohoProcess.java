/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetMiDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.ue.uex.business.core.TokuchoDotei;
import jp.co.ndensan.reams.ue.uex.entity.relate.MidoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 未同定情報を取得する
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class GetMiDoteiJohoProcess extends BatchProcessBase<TokuchoTaishoshaDoteiCombineEntity> {

    private TokuchoTaishoshaDoteiIkatsu manager;
    private GetMiDoteiJohoProcessParameter parameter;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get介護の３つのテーブルの全件");
    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    @BatchWriter
    BatchEntityCreatedTempTableWriter midoteiTempTableWriter;

    static {
        TABLE_NAME = new RString("MidoteiTemp");
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();

    }

    @Override
    protected void createWriter() {
        midoteiTempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        MidoteiTempEntity.class);
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
        TokuchoDotei doteiManager = new TokuchoDotei();
        List<MidoteiTempEntity> doteiJohoList = doteiManager.get未同定情報();
        if (null != doteiJohoList && !doteiJohoList.isEmpty()) {
            manager.createTkMidoteiJoho(parameter.get開始月(), parameter.get処理日時());
        }
    }

}
