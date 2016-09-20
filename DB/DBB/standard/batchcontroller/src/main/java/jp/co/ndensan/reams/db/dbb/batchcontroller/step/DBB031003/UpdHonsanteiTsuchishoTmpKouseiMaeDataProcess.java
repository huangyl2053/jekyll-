/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「計算後情報「更正前」情報を更新」処理クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class UpdHonsanteiTsuchishoTmpKouseiMaeDataProcess extends SimpleBatchProcessBase {

    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;
    private HonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        if (processParameter.is一括発行起動フラグ()) {
            mapper.update本算定通知書一時_計算後情報更正前_一時();
        } else {
            mapper.update本算定通知書一時_計算後情報更正前();
        }
    }

    @Override
    protected void afterExecute() {
    }
}
