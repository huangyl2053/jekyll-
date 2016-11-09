/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka.HonnsanteiFukaMybatisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouDetaToriGaTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動データ取得トリガバックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class IdouDetaToriGaProcess extends BatchProcessBase<IdouDetaToriGaTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select異動データ取得");
    private static final RString TABLE_異動データ取得トリガ = new RString("IdouDetaToriGaTemp");
    private IHonnSanteiFukaMapper mapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動データ取得トリガ;

    @Override
    protected void initialize() {
        mapper = getMapper(IHonnSanteiFukaMapper.class);
    }

    @Override
    protected void createWriter() {
        異動データ取得トリガ = new BatchEntityCreatedTempTableWriter(TABLE_異動データ取得トリガ,
                IdouDetaToriGaTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(IdouDetaToriGaTempEntity entity) {
        異動データ取得トリガ.insert(entity);
        mapper.update異動中間基本送付一時(HonnsanteiFukaMybatisParamter.
                createIdouDateParam(entity.get異動年月日(), entity.get被保険者番号()));
    }
}
