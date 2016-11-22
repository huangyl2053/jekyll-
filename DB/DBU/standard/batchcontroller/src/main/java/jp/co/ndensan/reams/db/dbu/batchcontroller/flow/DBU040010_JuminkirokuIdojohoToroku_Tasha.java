/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU040010.KaigojuminHyotrukuDBUpdateProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU040010.DBU040010_JuminkirokuIdojohoToroku_TashaParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku.KaigojuminHyotrukuProcessParameter;
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
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class DBU040010_JuminkirokuIdojohoToroku_Tasha extends BatchFlowBase<DBU040010_JuminkirokuIdojohoToroku_TashaParameter> {

    private static final String KAIGOJUMINHYO_DB_UPD_PROCESS = "KaigojuminHyotrukuDBUpdateProcess";
    private KaigojuminHyotrukuProcessParameter processParameter;

    @Override
    protected void initialize() {
        processParameter = getParameter().toKaigoJuminhyoProcessParameter();
        processParameter.setShoriTimestamp(YMDHMS.now().getRDateTime());
    }

    @Override
    protected void defineFlow() {
        List<RString> list = new ArrayList<>();
        KoikiShichosonJohoFinder 全市町村情報取得 = KoikiShichosonJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() != null) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                    || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                List<KoikiZenShichosonJoho> 広域用情報リスト = 全市町村情報取得.getGenShichosonJoho().records();
                for (KoikiZenShichosonJoho 広域情報リスト : 広域用情報リスト) {
                    list.add(広域情報リスト.get市町村コード().value());
                    processParameter.setShichosonCodelist(list);
                }
                executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                List<ShichosonCodeYoriShichoson> 単一用情報リスト = 全市町村情報取得.shichosonCodeYoriShichosonJoho(市町村セキュリティ情報.
                        get市町村情報().get市町村コード()).records();
                for (ShichosonCodeYoriShichoson 単一 : 単一用情報リスト) {
                    list.add(単一.get市町村コード().value());
                    processParameter.setShichosonCodelist(list);
                }
                executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
            }
        }
    }

    /**
     * DB登録またはDB更新です。
     *
     * @return 登録または更新件数
     */
    @Step(KAIGOJUMINHYO_DB_UPD_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoDBUpdateProcess() {
        return loopBatch(KaigojuminHyotrukuDBUpdateProcess.class).arguments(processParameter).define();
    }
}
