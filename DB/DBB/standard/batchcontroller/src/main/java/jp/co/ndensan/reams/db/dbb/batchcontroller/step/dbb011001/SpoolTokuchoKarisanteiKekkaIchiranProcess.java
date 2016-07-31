/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.SpoolTokuchoKarisanteiKekkaIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 特徴仮算定結果一覧表出力process
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class SpoolTokuchoKarisanteiKekkaIchiranProcess extends SimpleBatchProcessBase {

    private SpoolTokuchoKarisanteiKekkaIchiranProcessParameter parameter;
    private TokuchoKariSanteiFukaManagerBatch manager;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKariSanteiFukaManagerBatch.createInstance();
    }

    @Override
    protected void process() {
        manager.spoolTokuchoKarisanteiKekkaIchiran(parameter.get調定年度(), parameter.get賦課年度(), parameter.get調定日時(), parameter.get出力順ID());
        manager.update処理日付管理テーブル(parameter.get調定年度(), parameter.get調定日時());
    }
}
