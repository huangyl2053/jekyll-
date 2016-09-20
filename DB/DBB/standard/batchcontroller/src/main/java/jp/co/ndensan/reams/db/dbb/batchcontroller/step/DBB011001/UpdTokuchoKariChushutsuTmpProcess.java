/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka.ITokuchoKariSanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 特徴仮算定抽出Temp更新（前年度6期）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class UpdTokuchoKariChushutsuTmpProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(ITokuchoKariSanteiFukaMapper.class).update特徴仮算定抽出Temp();
    }
}
