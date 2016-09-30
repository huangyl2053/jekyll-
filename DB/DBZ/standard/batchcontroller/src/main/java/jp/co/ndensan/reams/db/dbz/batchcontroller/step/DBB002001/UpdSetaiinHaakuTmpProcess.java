/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 各住民の所得情報の取得です。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class UpdSetaiinHaakuTmpProcess extends SimpleBatchProcessBase {

    private ISetaiShotokuKazeiHanteiMapper mapper;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ISetaiShotokuKazeiHanteiMapper.class);

    }

    @Override
    protected void process() {
        List<DbV2502KaigoShotokuEntity> 介護所得list = mapper.select介護所得();
        if (介護所得list == null || 介護所得list.isEmpty()) {
            return;
        }
        for (DbV2502KaigoShotokuEntity 介護所得entity : 介護所得list) {
            mapper.update世帯員所得情報(介護所得entity);
        }
    }
}
