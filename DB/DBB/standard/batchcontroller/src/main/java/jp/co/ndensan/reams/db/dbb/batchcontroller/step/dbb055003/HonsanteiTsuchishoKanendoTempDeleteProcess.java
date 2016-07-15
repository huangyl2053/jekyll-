/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendotsuchishoikkatsuhakko.IKanendoTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 本算定（過年度）通知書一時テーブル作成するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class HonsanteiTsuchishoKanendoTempDeleteProcess extends SimpleBatchProcessBase {

    private IKanendoTsuchishoIkkatsuHakkoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKanendoTsuchishoIkkatsuHakkoMapper.class);
    }

    @Override
    protected void process() {
        mapper.clear賦課情報一時テーブル();
    }
}
