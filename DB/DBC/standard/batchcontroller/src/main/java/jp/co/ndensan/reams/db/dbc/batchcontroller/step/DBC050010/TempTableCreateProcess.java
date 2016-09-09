/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 一時テーブル作成_Process処理クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public class TempTableCreateProcess extends SimpleBatchProcessBase {

    @BatchWriter
    BatchEntityCreatedTempTableWriter furikomiDetailWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kozaFurikomiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shoriKekkaKakuninListWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        createTempTable();
    }

    @Override
    protected void process() {

    }

    private void createTempTable() {
        furikomiDetailWriter = new BatchEntityCreatedTempTableWriter(
                FurikomiDetailTempTableEntity.TABLE_NAME, FurikomiDetailTempTableEntity.class);
        kozaFurikomiWriter = new BatchEntityCreatedTempTableWriter(
                KozaFurikomiTempTableEntity.TABLE_NAME, KozaFurikomiTempTableEntity.class);
        shoriKekkaKakuninListWriter = new BatchEntityCreatedTempTableWriter(
                ShoriKekkaKakuninListTempTableEntity.TABLE_NAME, ShoriKekkaKakuninListTempTableEntity.class);
    }

//    private void edit振込業務内区分() {
//
//    }
//
//    private void edit処理名() {
//
//    }
}
