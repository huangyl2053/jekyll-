/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka.ITokuchoKariSanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 前年度賦課Temp履歴削除（特徴６月開始データ）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class DelZennendoFukaTmpProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(ITokuchoKariSanteiFukaMapper.class).delete最新履歴以外のデータ();
    }

}
