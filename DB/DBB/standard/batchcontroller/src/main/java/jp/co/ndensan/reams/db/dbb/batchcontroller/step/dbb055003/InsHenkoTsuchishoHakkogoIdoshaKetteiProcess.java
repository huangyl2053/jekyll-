/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.KanendoHonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendotsuchishoikkatsuhakko.HonsanteiIdoKanendoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * 変更通知書発行後異動者登録するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class InsHenkoTsuchishoHakkogoIdoshaKetteiProcess extends SimpleBatchProcessBase {

    private KanendoHonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoKanendoTsuchishoIkkatsuHakko service = HonsanteiIdoKanendoTsuchishoIkkatsuHakko.createInstance();
        ChohyoResult 出力帳票 = processParameter.get出力帳票();
        service.insTsuchishoHakkogoIdoshaHenko(processParameter.get帳票作成日時(),
                出力帳票.get出力順ID(), processParameter.get変更_対象者(),
                new ReportId(出力帳票.get帳票ID()), processParameter.get変更_対象賦課年度());
    }

    @Override
    protected void afterExecute() {

    }
}
