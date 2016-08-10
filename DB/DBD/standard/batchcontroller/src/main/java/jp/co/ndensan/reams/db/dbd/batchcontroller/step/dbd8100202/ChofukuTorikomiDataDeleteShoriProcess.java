/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ChofukuTorikomiDataDeleteShoriJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 重複取込データ除外処理_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class ChofukuTorikomiDataDeleteShoriProcess extends BatchProcessBase<ChofukuTorikomiDataDeleteShoriJohoEntity> {

    @Override
    protected IBatchReader createReader() {
        // TODO ＳＱＬ発行
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void createWriter() {
        // TODO 一時テーブルWriter作成
    }

    @Override
    protected void process(ChofukuTorikomiDataDeleteShoriJohoEntity t) {
        // TODO 非課税年金対象者同定結果情報一時の[重複データ除外処理]
        // 取込データ一時削除
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
