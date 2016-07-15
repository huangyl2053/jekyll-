/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiKouhoshaTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.shotokushokaihyo.Shotokushokaihyo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票を発行する可能性がある住民情報を作成
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class GetJuminjouhouProcess extends BatchProcessBase<RString> {

    /**
     * 所得照会候補者Temp
     */
    public static final RString SHOTOKUSHOUKAIKOUHOSHATEMP;
    /**
     * 所得照会票データTemp
     */
    public static final RString SHOTOKUSHOUKAIDATATEMP;
    /**
     * 受給者Temp
     */
    public static final RString TABLE_NAME_JUKYUUSYATEMPENTITY;
    private static final RString FILEPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "shotokushokaihyo.IShotokushokaihyoMapper.select候補者転入者");
    private static final RString 出力対象が_１ = new RString("1");
    private static final RString 出力対象が_２ = new RString("2");
    private static final RString 出力対象が_３ = new RString("3");

    private ShotokuShokaihyoHakkoProcessParameter parameter;

    static {
        SHOTOKUSHOUKAIKOUHOSHATEMP = new RString("ShotokuShoukaiKouhoshaTemp");
        SHOTOKUSHOUKAIDATATEMP = new RString("ShotokuShoukaiDataTemp");
        TABLE_NAME_JUKYUUSYATEMPENTITY = new RString("JukyuusyaTemp");
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter_ShotokuShoukaiKouhoshaTemp;
    BatchEntityCreatedTempTableWriter tempTableWriter_ShotokuShoukaiDataTemp;
    BatchEntityCreatedTempTableWriter tempTableWriter_JukyuusyaTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(FILEPATH);
    }

    @Override
    protected void createWriter() {
        tempTableWriter_ShotokuShoukaiKouhoshaTemp
                = new BatchEntityCreatedTempTableWriter(SHOTOKUSHOUKAIKOUHOSHATEMP,
                        ShotokuShoukaiKouhoshaTempEntity.class);
        tempTableWriter_ShotokuShoukaiDataTemp
                = new BatchEntityCreatedTempTableWriter(SHOTOKUSHOUKAIDATATEMP,
                        ShotokuShoukaiDataTempEntity.class);
        tempTableWriter_JukyuusyaTemp
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME_JUKYUUSYATEMPENTITY,
                        JukyuusyaTempEntity.class);
    }

    @Override
    protected void process(RString t) {
    }

    @Override
    protected void afterExecute() {
        Shotokushokaihyo kaihyo = Shotokushokaihyo.createInstance();
        FlexibleYear 処理年度 = parameter.get処理年度();
        RString 出力対象 = parameter.get出力対象();
        RString 導入形態コード = parameter.get導入形態コード();
        kaihyo.getShotokushokaihyoJuminJoho(処理年度, 出力対象, null);
        if (出力対象.equals(出力対象が_１)) {
            kaihyo.getALL(処理年度);
        } else if (出力対象.equals(出力対象が_２)) {
            kaihyo.getIchigoHokenshaAndSetaiin(処理年度);

        } else if (出力対象.equals(出力対象が_３)) {
            kaihyo.getFukaKijyunYokujituSetaiin(処理年度);

        }
        kaihyo.getHakkoTaisyo(処理年度, 出力対象, 導入形態コード);
    }

}
