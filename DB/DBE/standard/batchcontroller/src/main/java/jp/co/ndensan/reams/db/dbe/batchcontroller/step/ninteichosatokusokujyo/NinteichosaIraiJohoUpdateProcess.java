/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteichosaIraiJohoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報テーブルの更新処理のクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteichosaIraiJohoUpdateProcess extends BatchProcessBase<DbT5201NinteichosaIraiJohoEntity> {

    private NinteichosaIraiJohoUpdateProcessParameter processParameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo."
                    + "INinteichosaTokusokujyoRelateMapper.select認定調査依頼情報BY申請書管理番号");
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNinteiChosaTokusokujoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT5201TableWriter = new BatchPermanentTableWriter<>(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(DbT5201NinteichosaIraiJohoEntity entity) {
        entity.setNinteichosaTokusokuYMD(new FlexibleDate(processParameter.getTemp_督促日()));
        entity.setNinteichosaTokusokuMemo(processParameter.getTemp_督促メモ());
        entity.setNinteichosaTokusokuHoho(processParameter.getTemp_督促方法());
        entity.setNinteichosaIraiKaisu(entity.getNinteichosaIraiKaisu() + 1);
        dbT5201TableWriter.update(entity);
    }

}
