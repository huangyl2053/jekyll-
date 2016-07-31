/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiKouhoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票一括発行一時テーブル作成するクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class RinjiCreatTableProcess extends BatchProcessBase<RString> {

    /**
     * TABLE_NAME_SHOTOKUSHOUKAIKOUHOSHATEMP
     */
    public static final RString SHOTOKUSHOUKAIKOUHOSHATEMP;
    /**
     * TABLE_NAME_SHOTOKUSHOUKAIDATATEMP
     */
    public static final RString SHOTOKUSHOUKAIDATATEMP;
    /**
     * TABLE_NAME_JUKYUUSYATEMPENTITY
     */
    public static final RString TABLE_NAME_JUKYUUSYATEMPENTITY;

    private static final RString FILEPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "shotokushokaihyo.IShotokushokaihyoMapper.select候補者転入者");

    static {
        SHOTOKUSHOUKAIKOUHOSHATEMP = new RString("ShotokuShoukaiKouhoshaTemp");
        SHOTOKUSHOUKAIDATATEMP = new RString("ShotokuShoukaiDataTemp");
        TABLE_NAME_JUKYUUSYATEMPENTITY = new RString("JukyuusyaTemp");
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter shotokuShoukaiKouhoshaTemp;
    BatchEntityCreatedTempTableWriter shotokuShoukaiDataTemp;
    BatchEntityCreatedTempTableWriter jukyuusyaTemp;

    @Override
    protected void createWriter() {
        shotokuShoukaiKouhoshaTemp
                = new BatchEntityCreatedTempTableWriter(SHOTOKUSHOUKAIKOUHOSHATEMP,
                        ShotokuShoukaiKouhoshaTempEntity.class);
        shotokuShoukaiDataTemp
                = new BatchEntityCreatedTempTableWriter(SHOTOKUSHOUKAIDATATEMP,
                        ShotokuShoukaiDataTempEntity.class);
        jukyuusyaTemp
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME_JUKYUUSYATEMPENTITY,
                        JukyuusyaTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(FILEPATH);
    }

    @Override
    protected void process(RString t) {
    }

}
