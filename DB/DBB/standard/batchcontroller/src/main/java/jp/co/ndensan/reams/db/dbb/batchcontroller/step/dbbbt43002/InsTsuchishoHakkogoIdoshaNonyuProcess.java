/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 納入通知書発行後異動者登録するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class InsTsuchishoHakkogoIdoshaNonyuProcess extends SimpleBatchProcessBase {

    private HonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiTsuchishoIkkatsuHakko manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        HonsanteifukaBatchTyouhyou 出力帳票一覧 = processParameter.get出力帳票一覧();
        manager.insTsuchishoHakkogoIdoshaNonyu(processParameter.get帳票作成日時(), processParameter.get納入_出力期(),
                processParameter.get納入_対象者(), processParameter.get納入_生活保護対象者をまとめて先頭に出力(),
                出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID());
    }

    @Override
    protected void afterExecute() {

    }
}
