/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.HikazeiNennkinDeleteProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者削除クラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class HikazeiNennkinnTaishouSyaDeleteProcess extends BatchProcessBase<DbT4037HikazeNenkinTaishoshaEntity> {

    private static final RString MAPPERPATH_削除 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "hikazeinennkintaishousyajohotorikomi.IHikazeiNennkinnTaishouSyaDeleteMapper.getBP_処理状態削除する");
    private HikazeiNennkinDeleteProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {

        if (processParameter.get処理状態().equals("3")) {
            return new BatchDbReader(MAPPERPATH_削除, processParameter.MybatisParameter(processParameter.get処理年度(),
                    processParameter.get処理区分(), processParameter.get対象月(), processParameter.get登録区分()));
        }
        return null;
    }

    @Override
    protected void process(DbT4037HikazeNenkinTaishoshaEntity t) {

    }
}
