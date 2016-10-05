/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「仮算定額変更通知書発行後異動者登録」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class InsKarisanteigakuHenkoTsuchishoHakkogoIdoshaProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        KarisanteiIdoTsuchishoIkkatsuHakko manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        TyouhyouEntity 出力帳票一覧 = processParameter.get出力帳票一覧();
        manager.insKarisanteigakuHenkoTsuchishoHakkogoIdosha(processParameter.get帳票作成日時(),
                出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID());
    }

    @Override
    protected void afterExecute() {

    }
}
