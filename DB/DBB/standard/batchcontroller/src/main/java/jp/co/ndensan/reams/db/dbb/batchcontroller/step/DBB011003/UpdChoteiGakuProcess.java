/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 更新特徴調定額クラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class UpdChoteiGakuProcess extends SimpleBatchProcessBase {

    private ITokuchoKarisanteiTsuchishoHakkoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoKarisanteiTsuchishoHakkoMapper.class);
    }

    @Override
    protected void process() {
        mapper.update仮算定一括発行一時_特徴調定額();
    }

    @Override
    protected void afterExecute() {

    }
}
