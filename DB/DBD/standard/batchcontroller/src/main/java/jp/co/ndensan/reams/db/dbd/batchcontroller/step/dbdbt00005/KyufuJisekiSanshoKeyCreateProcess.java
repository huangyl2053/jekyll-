/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00005;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00005.temptable.KyufuJisekiSanshoKeyTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 給付実績参照キー作成_process処理クラスです。
 *
 * @reamsid_L DBD-3880-030 x_lilh
 */
public class KyufuJisekiSanshoKeyCreateProcess extends BatchProcessBase<KyufuJisekiSanshoKeyTempTableEntity> {

    @Override
    protected IBatchReader createReader() {
        //SQLを使用、SQLの実行結果の類型はKyufuJisekiSanshoKeyTempTableEntityのリストです
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void process(KyufuJisekiSanshoKeyTempTableEntity t) {
        // 給付実績キー一時テーブルを登録 TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
