/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHako;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 変更通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class PrtIdoHenkoTsuchishoProcess extends SimpleBatchProcessBase {

    private HonsanteiIdoProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoGennendoTsuchisyoIkatsuHako manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        ChohyoResult 出力帳票一覧 = processParameter.get出力帳票一覧();
        try {
            manager.prtHenkoTsuchisho(processParameter.get調定年度(), new RDate(processParameter.get変更_発行日().toString()),
                    processParameter.get変更_文書番号(),
                    processParameter.get帳票作成日時().getRDateTime(), 出力帳票一覧.get出力順ID(), new ReportId(出力帳票一覧.get帳票ID()),
                    processParameter.is一括発行起動フラグ(), processParameter.get変更_対象者());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtIdoHenkoTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void afterExecute() {
    }
}
