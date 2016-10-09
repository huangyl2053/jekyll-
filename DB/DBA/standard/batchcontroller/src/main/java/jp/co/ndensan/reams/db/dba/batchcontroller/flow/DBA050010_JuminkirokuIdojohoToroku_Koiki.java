/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA050010.SyoriTaisyoShichosonProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA050010.DBA050010_JuminkirokuIdojohoToroku_KoikiParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba050010.JuminkirokuIdojohoTorokuKoikiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 住民異動連携情報登録【広域保険者用】のバッチ用フロークラスです。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
public class DBA050010_JuminkirokuIdojohoToroku_Koiki extends BatchFlowBase<DBA050010_JuminkirokuIdojohoToroku_KoikiParameter> {

    private static final String SYORITAISYOSHICHOSON = "処理対象市町村";
    private JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter;

    @Override
    protected void initialize() {
        processParameter = getParameter().toJuminkirokuIdojohoTorokuKoikiProcessParameter();
        processParameter.setSyorinichiji(YMDHMS.now());
    }

    @Override
    protected void defineFlow() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() != null || !市町村セキュリティ情報.get介護導入区分().isEmpty()) {
            executeStep(SYORITAISYOSHICHOSON);
        }
    }

    @Step(SYORITAISYOSHICHOSON)
    IBatchFlowCommand getSyoriTaisyoShichosonProcess() {
        return loopBatch(SyoriTaisyoShichosonProcess.class).arguments(getParameter().toJuminkirokuIdojohoTorokuKoikiProcessParameter()).define();
    }
}
