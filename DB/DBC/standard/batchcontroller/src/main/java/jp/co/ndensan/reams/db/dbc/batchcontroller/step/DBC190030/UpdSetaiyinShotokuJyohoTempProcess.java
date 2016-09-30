/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030.IDBC190030Mapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のプロセスクラスです。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
public class UpdSetaiyinShotokuJyohoTempProcess extends SimpleBatchProcessBase {

    @Override
    protected void beforeExecute() {
        IDBC190030Mapper mapper = getMapper(IDBC190030Mapper.class);
        mapper.update世帯員所得情報一時();
    }

    @Override
    protected void process() {
    }

}
