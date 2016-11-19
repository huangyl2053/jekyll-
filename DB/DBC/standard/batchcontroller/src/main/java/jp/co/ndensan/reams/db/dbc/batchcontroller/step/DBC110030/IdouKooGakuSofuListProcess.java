/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouDetaToriGaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouSofuListTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動高額送付対象リストを作成です。
 *
 * @reamsid_L DBC-2770-050 jinjue
 */
public class IdouKooGakuSofuListProcess extends BatchProcessBase<IdouDetaToriGaTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper.select異動データ取得");
    @BatchWriter
    private BatchPermanentTableWriter<IdouSofuListTempEntity> 送付対象リスト情報一時;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        送付対象リスト情報一時 = new BatchPermanentTableWriter<>(IdouSofuListTempEntity.class);
    }

    @Override
    protected void process(IdouDetaToriGaTempEntity entity) {
    }

    @Override
    protected void afterExecute() {
        List<IdouSofuListTempEntity> 送付対象リスト = HonnSanteiFukaManager.createInstance().set高額送付対象リスト();
        for (IdouSofuListTempEntity list : 送付対象リスト) {
            送付対象リスト情報一時.insert(list);
        }
    }
}
