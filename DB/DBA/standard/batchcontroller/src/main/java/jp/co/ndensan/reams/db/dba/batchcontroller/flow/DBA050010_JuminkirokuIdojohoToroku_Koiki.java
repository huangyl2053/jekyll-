/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA050010.SyoriTaisyoShichosonProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA050010.DBA050010_JuminkirokuIdojohoToroku_KoikiParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba050010.JuminkirokuIdojohoTorokuKoikiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        KoikiShichosonJohoFinder 全市町村情報取得 = KoikiShichosonJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<RString> list = new ArrayList<>();
        if (市町村セキュリティ情報.get導入形態コード() != null) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                    || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                List<KoikiZenShichosonJoho> 広域用情報リスト = 全市町村情報取得.getGenShichosonJoho().records();
                for (KoikiZenShichosonJoho 広域情報リスト : 広域用情報リスト) {
                    list.add(広域情報リスト.get市町村コード().value());
                    processParameter.setShichosonCode(list);

                }
                executeStep(SYORITAISYOSHICHOSON);
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                List<ShichosonCodeYoriShichoson> 単一用情報リスト = 全市町村情報取得.shichosonCodeYoriShichosonJoho(市町村セキュリティ情報.
                        get市町村情報().get市町村コード()).records();
                for (ShichosonCodeYoriShichoson 単一 : 単一用情報リスト) {
                    list.add(単一.get市町村コード().value());
                    processParameter.setShichosonCode(list);
                }
                executeStep(SYORITAISYOSHICHOSON);
            }
        }
    }

    @Step(SYORITAISYOSHICHOSON)
    IBatchFlowCommand getSyoriTaisyoShichosonProcess() {
        return loopBatch(SyoriTaisyoShichosonProcess.class).arguments(processParameter).define();
    }

}
