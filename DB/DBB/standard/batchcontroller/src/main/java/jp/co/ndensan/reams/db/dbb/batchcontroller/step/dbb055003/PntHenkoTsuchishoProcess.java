/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.PrtKetteiTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.KanendoHonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendotsuchishoikkatsuhakko.HonsanteiIdoKanendoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * 変更通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class PntHenkoTsuchishoProcess extends SimpleBatchProcessBase {

    private KanendoHonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoKanendoTsuchishoIkkatsuHakko service = HonsanteiIdoKanendoTsuchishoIkkatsuHakko.createInstance();
        ChohyoResult 出力帳票 = processParameter.get出力帳票();
        try {
            service.pntHenkoTsuchisho(processParameter.get調定年度(), processParameter.get変更_対象賦課年度(),
                    processParameter.get帳票作成日時(), processParameter.get変更_発行日(), processParameter.get変更_対象者(), processParameter.get決定_文書番号(),
                    出力帳票.get出力順ID(), new ReportId(出力帳票.get帳票ID()), processParameter.is一括発行起動フラグ());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtKetteiTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void afterExecute() {
    }
}
