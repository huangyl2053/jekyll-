/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00005;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00005.ChohyoShutsuryokuJohoShutokuResultEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 帳票出力情報の取得_process処理クラスです。
 *
 * @reamsid_L DBD-3880-030 x_lilh
 */
public class ChohyoShutsuryokuJohoShutokuProcess extends BatchProcessBase<ChohyoShutsuryokuJohoShutokuResultEntity> {

    @Override
    protected void initialize() {
        //事前準備とデータの初期化 TODO
    }

    @Override
    protected IBatchReader createReader() {
        //SQLを使用、
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void process(ChohyoShutsuryokuJohoShutokuResultEntity t) {
        // 帳票作成と編集内容を実行する
        // 編集内容複雑の場合はSERVICE とBUS に実行いいです．
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void afterExecute() {
        // バッチ出力条件リストの出力を行う
    }
}
