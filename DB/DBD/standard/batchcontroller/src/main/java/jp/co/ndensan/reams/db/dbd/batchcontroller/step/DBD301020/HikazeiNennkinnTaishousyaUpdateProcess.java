/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者更新_process処理クラスです。
 *
 * @reamsid_L DBD-4910-050 x_xuliang
 */
public class HikazeiNennkinnTaishousyaUpdateProcess extends BatchProcessBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.sokyuhikazeinenkintaishousyadoutei"
            + ".IHikazeiNennkinnTaishousyaUpdateMapper.get非課税年金対象者情報");

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity entity) {

    }
}
