/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「納入通知書（仮算定）の発行」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class PntKarisanteiNonyuTsuchishoProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        KarisanteiIdoTsuchishoIkkatsuHakko manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        TyouhyouEntity 出力帳票一覧 = processParameter.get出力帳票一覧();
        try {
            manager.pntKarisanteiNonyuTsuchisho(processParameter.get調定年度(), processParameter.get賦課年度(),
                    processParameter.get帳票作成日時(), 出力帳票一覧.get出力順ID(), processParameter.get納入_出力方式(),
                    processParameter.get納入_出力期(), processParameter.get納入_発行日(),
                    processParameter.get納入_対象者(), processParameter.get納入_生活保護対象者(),
                    processParameter.get納入_ページごとに山分け(), 出力帳票一覧.get帳票ID(),
                    processParameter.is一括発行起動フラグ());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PntKarisanteiNonyuTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void afterExecute() {

    }
}
