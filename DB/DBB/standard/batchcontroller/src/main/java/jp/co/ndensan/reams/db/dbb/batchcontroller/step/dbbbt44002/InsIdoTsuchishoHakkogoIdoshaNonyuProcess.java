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
 * 納入通知書発行後異動者登録するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class InsIdoTsuchishoHakkogoIdoshaNonyuProcess extends SimpleBatchProcessBase {

    private HonsanteiIdoProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoGennendoTsuchisyoIkatsuHako manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        ChohyoResult 出力帳票一覧 = processParameter.get出力帳票一覧();
        manager.insTsuchishoHakkogoIdoshaNonyu(processParameter.get帳票作成日時(), processParameter.get納入_出力期(),
                processParameter.get納入_対象者(), processParameter.get納入_生活保護対象者をまとめて先頭に出力(),
                出力帳票一覧.get出力順ID(), new ReportId(出力帳票一覧.get帳票ID()));
    }

    @Override
    protected void afterExecute() {

    }
}
