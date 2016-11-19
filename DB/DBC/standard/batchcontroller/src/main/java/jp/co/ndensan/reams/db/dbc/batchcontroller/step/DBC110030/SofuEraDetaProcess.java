/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouDetaToriGaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.SofuEraRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付エラー一時テーブルバックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class SofuEraDetaProcess extends BatchProcessBase<IdouDetaToriGaTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select異動データ取得");
    private static final RString TABLE_送付エラー一時 = new RString("SofuEraDetaTemp");
    private IHonnSanteiFukaMapper mapper;
    private List<IdouDetaToriGaTempEntity> entityData;
    private int 連番 = 0;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 送付エラー一時;

    @Override
    protected void initialize() {
        mapper = getMapper(IHonnSanteiFukaMapper.class);
        entityData = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        送付エラー一時 = new BatchEntityCreatedTempTableWriter(TABLE_送付エラー一時,
                SofuEraRelateEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(IdouDetaToriGaTempEntity entity) {
        連番++;
        entityData.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (0 < 連番) {
            List<SofuEraRelateEntity> 送付情報 = mapper.select異動データ取得トリガ(entityData);
            for (SofuEraRelateEntity sofuEntity : 送付情報) {
                送付エラー一時.insert(sofuEntity);
            }
        }
    }
}
