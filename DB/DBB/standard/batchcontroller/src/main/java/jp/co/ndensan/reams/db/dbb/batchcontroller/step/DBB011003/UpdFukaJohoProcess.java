/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 更新前年度賦課情報クラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class UpdFukaJohoProcess extends SimpleBatchProcessBase {

    private ITokuchoKarisanteiTsuchishoHakkoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoKarisanteiTsuchishoHakkoMapper.class);
    }

    @Override
    protected void process() {
        mapper.update仮算定一括発行一時_前年度賦課情報();
    }

    @Override
    protected void afterExecute() {

    }
}
