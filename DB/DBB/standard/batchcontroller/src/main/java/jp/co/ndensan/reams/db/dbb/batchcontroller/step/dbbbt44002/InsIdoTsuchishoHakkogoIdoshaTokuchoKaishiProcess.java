/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHako;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * 特徴開始通知書発行後異動者登録クラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class InsIdoTsuchishoHakkogoIdoshaTokuchoKaishiProcess extends SimpleBatchProcessBase {

    private HonsanteiIdoProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoGennendoTsuchisyoIkatsuHako manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        ChohyoResult 出力帳票一覧 = processParameter.get出力帳票一覧();
        manager.insTsuchishoHakkogoIdoshaTokuchoKaishi(processParameter.get特徴_出力対象(),
                processParameter.get帳票作成日時(), 出力帳票一覧.get出力順ID(), new ReportId(出力帳票一覧.get帳票ID()));
    }

    @Override
    protected void afterExecute() {

    }
}
