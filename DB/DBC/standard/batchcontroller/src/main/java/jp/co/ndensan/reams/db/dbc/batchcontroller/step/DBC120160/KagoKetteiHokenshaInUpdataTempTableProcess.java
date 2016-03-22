/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.ShihihokenshabangoTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 一時テーブルのデータの編集
 */
public class KagoKetteiHokenshaInUpdataTempTableProcess extends SimpleBatchProcessBase {

    private IKagoKetteiHokenshaInMapper mapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKagoKetteiHokenshaInMapper.class);
        mapper.create新被保険者番号();
    }

    @Override
    protected void process() {

        List<DbT1001HihokenshaDaichoEntity> list = mapper.get市町村コード();
        if (list.isEmpty()) {
            return;
        }

        List<DbT1001HihokenshaDaichoEntity> list2 = new ArrayList<>();
        DbT1001HihokenshaDaichoEntity dbT1001Entity = list.get(0);
        list2.add(dbT1001Entity);

        for (DbT1001HihokenshaDaichoEntity result : list) {
            if (!result.getHihokenshaNo().equals(dbT1001Entity.getHihokenshaNo())) {
                list2.add(result);
                dbT1001Entity = result;
            }
        }

        for (DbT1001HihokenshaDaichoEntity result : list2) {
            List<ShihihokenshabangoTempTableEntity> shi = mapper.get新被保険者番号(result.getShichosonCode());
            if (shi.isEmpty()) {
                continue;
            }
            for (ShihihokenshabangoTempTableEntity entity : shi) {
                mapper.insert新被保険者番号(entity);
            }
        }

        mapper.update保険者分情報_明細();
    }

}
