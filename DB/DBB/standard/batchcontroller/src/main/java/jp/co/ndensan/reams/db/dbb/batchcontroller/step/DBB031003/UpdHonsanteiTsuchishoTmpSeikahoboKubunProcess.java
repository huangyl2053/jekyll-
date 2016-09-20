/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「生活保護区分を更新」処理クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class UpdHonsanteiTsuchishoTmpSeikahoboKubunProcess extends SimpleBatchProcessBase {

    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        mapper.update本算定通知書一時_生活保護区分();
    }

    @Override
    protected void afterExecute() {
    }
}
