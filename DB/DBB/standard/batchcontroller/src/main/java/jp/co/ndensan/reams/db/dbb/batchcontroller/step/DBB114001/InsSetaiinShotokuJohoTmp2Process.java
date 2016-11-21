/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiShotokuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員所得情報Temp２テーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsSetaiinShotokuJohoTmp2Process extends BatchProcessBase<SetaiShotokuTempEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select世帯員所得2");
    private static final RString 世帯員所得情報TEMP = new RString("TmpSetaiShotoku2");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員所得情報writer;
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
    private SetaiCode 世帯コード = SetaiCode.EMPTY;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH);
    }

    @Override
    protected void createWriter() {
        世帯員所得情報writer = new BatchEntityCreatedTempTableWriter(世帯員所得情報TEMP, SetaiShotokuTempEntity.class);
    }

    @Override
    protected void process(SetaiShotokuTempEntity t) {
        if (t.getShikibetsuCode() == null) {
            return;
        }
        if (!識別コード.equals(t.getShikibetsuCode())
                && !世帯コード.equals(t.getSetaiCode())) {
            世帯員所得情報writer.insert(t);
            識別コード = t.getShikibetsuCode();
            世帯コード = t.getSetaiCode();
        }
    }
}
