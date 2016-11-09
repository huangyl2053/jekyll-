/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import jp.co.ndensan.reams.db.dbc.business.core.honnsanteifuka.KyodoShoriKihonSofuBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriShouKannTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動償還送付データバックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class KyodoShoriShouKannProcess extends BatchProcessBase<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select共同処理償還送付");
    private static final RString TABLE_共同処理償還送付全件 = new RString("KyodoShoriShouKannTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 共同処理償還送付全件一時;
    private KyodoShoriKihonSofuBusiness business;

    @Override
    protected void initialize() {
        business = new KyodoShoriKihonSofuBusiness();
    }

    @Override
    protected void createWriter() {
        共同処理償還送付全件一時 = new BatchEntityCreatedTempTableWriter(TABLE_共同処理償還送付全件,
                KyodoShoriShouKannTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        共同処理償還送付全件一時.insert(business.set共同処理償還送付全件(entity));
    }
}
