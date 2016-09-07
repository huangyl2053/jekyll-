/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 変更通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtHenkoTsuchishoProcess extends SimpleBatchProcessBase {

    private HonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiTsuchishoIkkatsuHakko manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        HonsanteifukaBatchTyouhyou 出力帳票一覧 = processParameter.get出力帳票一覧();
        try {
            manager.prtHenkoTsuchisho(processParameter.get調定年度(), processParameter.get決定変更_発行日(),
                    processParameter.get決定変更_文書番号(),
                    processParameter.get帳票作成日時().getRDateTime(), 出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID(),
                    processParameter.is一括発行起動フラグ(), processParameter.get打分け条件情報());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtHenkoTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void afterExecute() {
    }

}
