/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 通知書発行後異動者の登録
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class InsTsuchishoHakkogoIdoshaProcess extends SimpleBatchProcessBase {

    private TokuchoKaishiTsuchishoDataHenshu manager;
    private TokuchoKaishiTsuchishoProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKaishiTsuchishoDataHenshu.createInstance();
    }

    @Override
    protected void process() {
        manager.insTsuchishoHakkogoIdosha(parameter.get出力対象(), parameter.get帳票作成日時(),
                parameter.get出力帳票一覧Entity().get出力順ID(), parameter.get出力帳票一覧Entity().get帳票ID());
    }

    @Override
    protected void afterExecute() {

    }

}
