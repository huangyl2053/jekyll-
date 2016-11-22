/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.ShotaiinHaakuIttokiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握トリガ一時バックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class IdouDetaTyuushutuProcess extends BatchProcessBase<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select共同処理高額送付一時");
    private HonnsanteiFukaProcessParamter processParameter;
    private static final RString TABLE_世帯員把握トリガ一時 = new RString("SetaiYinHaAKuToRiGaTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員把握トリガ一時;

    @Override
    protected void createWriter() {
        世帯員把握トリガ一時 = new BatchEntityCreatedTempTableWriter(TABLE_世帯員把握トリガ一時,
                ShotaiinHaakuIttokiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSofuDataMybitisParamter());
    }

    @Override
    protected void process(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
    }

    @Override
    protected void afterExecute() {
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報 = HonnSanteiFukaManager.createInstance().
                set異動中間高額送付(processParameter.get処理対象年月(), processParameter.get合併区分());
        List<ShotaiinHaakuIttokiTempEntity> 世帯員把握情報 = HonnSanteiFukaManager.createInstance().
                set世帯員把握情報(異動中間高額送付情報, processParameter.get処理対象年月());
        for (ShotaiinHaakuIttokiTempEntity 世帯員情報 : 世帯員把握情報) {
            世帯員把握トリガ一時.insert(世帯員情報);
        }
    }
}
