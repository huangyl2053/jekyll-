/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka.IKariSanteiIdoFukaBatchMapper;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 資格異動者抽出クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class ShikakuIdoshaChushutsuProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoKekkaProcessParameter processParameter;
    private IKariSanteiIdoFukaBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKariSanteiIdoFukaBatchMapper.class);
        mapper.create資格喪失Temp();
        mapper.create資格取得Temp();
        mapper.create特別徴収開始Temp();
        mapper.create特徴仮算定抽出Temp();
        mapper.create特別徴収停止Temp();
        mapper.create賦課情報Temp();
        mapper.create口座異動Temp();
        mapper.create世帯員把握Temp();
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        manager.selectShikakuIdosha(processParameter.get抽出開始日時(),
                processParameter.get抽出終了日時(), processParameter.get普徴仮算定賦課処理日時());
    }

    @Override
    protected void afterExecute() {

    }
}
