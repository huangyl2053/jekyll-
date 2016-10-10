/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho.IKarisanteiIdoFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「更正前の対象者（追加含む）情報を更新」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class UpdZenkenFukaTemp2Process extends SimpleBatchProcessBase {

    private IKarisanteiIdoFukaMapper mapper;
    private KarisanteiIdoFukaProcessParameter processParameter;
    private IdofukaJohoTempParameter parameter;
    private KarisanteiIdoTsuchishoIkkatsuHakko manager;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKarisanteiIdoFukaMapper.class);
    }

    @Override
    protected void process() {
        manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        parameter = manager.get仮算定異動パラメータ(processParameter.get調定年度(),
                processParameter.get賦課年度(), processParameter.get最新調定日時());
        mapper.update異動賦課情報一時テーブル更正前対象者情報(parameter);
    }

    @Override
    protected void afterExecute() {
    }
}
