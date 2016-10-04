/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 介護特別徴収情報取込履歴追加のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class InsTorikomiRirekiProcess extends SimpleBatchProcessBase {

    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        システム日時 = parameter.getシステム日時();
    }

    @Override
    protected void process() {
        TokuChoSoufuJohoSakuseiBatch sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        UeT1704KaigoTokuchoTorikomiRirekiEntity uet1704Entity = sakuseiBatch.intTokuChoJohoTorikomiRireki(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), parameter.get遷移元メニュー(), システム日時);
        getMapper(ITokuChoSoufuJohoSakuseiMapper.class).insertTorikomiRireki(uet1704Entity);
    }

}
