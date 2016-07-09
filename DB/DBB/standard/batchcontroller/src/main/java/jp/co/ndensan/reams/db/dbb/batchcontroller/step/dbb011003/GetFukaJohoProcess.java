/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 賦課情報の取得
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class GetFukaJohoProcess extends SimpleBatchProcessBase {

    private TokuchoKaishiTsuchishoDataHenshu manager;
    private TokuchoKaishiTsuchishoProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKaishiTsuchishoDataHenshu.createInstance();
    }

    @Override
    protected void process() {
        manager.getFukaJoho();
        KarisanteiBatchEntity 出力帳票一覧 = processParameter.get出力帳票一覧Entity();
        manager.printTsuchisho(processParameter.get調定年度(), processParameter.get出力対象(),
                processParameter.get発行日(), processParameter.get帳票作成日時(), 出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID());

    }

    @Override
    protected void afterExecute() {

    }

}
