/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * ファイル出力(非課税年金対象者情報　年金番号～CSV)_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class NennkinnBanngouCsvProcess extends BatchProcessBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> {

    @Override
    protected IBatchReader createReader() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void process(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
