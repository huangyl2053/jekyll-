/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.NenkinNoTotsugoGaitouJohoNasiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 年金番号突合_該当年金情報なし一時_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class NenkinNoTotsugoGaitouJohoNasiProcess extends BatchProcessBase<NenkinNoTotsugoGaitouJohoNasiJohoEntity> {

    @Override
    protected IBatchReader createReader() {
        // TODO ＳＱＬ発行
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void createWriter() {
        // 一時テーブルWriter作成
    }

    @Override
    protected void process(NenkinNoTotsugoGaitouJohoNasiJohoEntity t) {
        // TODO　該当年金情報なし一時テーブルを登録する
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
