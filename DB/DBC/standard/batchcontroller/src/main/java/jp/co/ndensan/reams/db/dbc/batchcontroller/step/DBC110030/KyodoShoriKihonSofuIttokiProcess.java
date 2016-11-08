/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import jp.co.ndensan.reams.db.dbc.business.core.honnsanteifuka.KyodoShoriKihonSofuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKihonSofuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動基本送付データバックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class KyodoShoriKihonSofuIttokiProcess extends BatchProcessBase<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select共同処理基本送付一時");
    private static final RString TABLE_共同処理基本送付 = new RString("KyodoShoriKihonSofuIttokiTemp");
    private HonnsanteiFukaProcessParamter processParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 共同処理基本送付一時;
    private KyodoShoriKihonSofuBusiness business;

    @Override
    protected void initialize() {
        business = new KyodoShoriKihonSofuBusiness();
    }

    @Override
    protected void createWriter() {
        共同処理基本送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_共同処理基本送付,
                KyodoShoriKihonSofuTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSofuDataMybitisParamter());
    }

    @Override
    protected void process(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
        共同処理基本送付一時.insert(business.set共同処理基本送付全件(entity));
    }
}
