/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD532001.NinteiKekkaTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD532001.ServiceHenkoTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD532001.YokaigoHenkoTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD532001.ShutsuryokuTaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD532001.DBD532001_NinteiKekkaTsuchiParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.RirekiSearchType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;

/**
 * 認定結果通知書発行のバッチフロークラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
public class DBD532001_NinteiKekkaTsuchi extends BatchFlowBase<DBD532001_NinteiKekkaTsuchiParameter> {

    private static final String 認定結果通知書発行 = "認定結果通知書発行";
    private static final String サービス変更通知書発行 = "サービス変更通知書発行";
    private static final String 要介護度変更通知書発行 = "要介護度変更通知書発行";
    private IShikibetsuTaishoPSMSearchKey searchKey;

    @Override
    protected void initialize() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        List<JuminJotai> 住民状態List = new ArrayList<>();
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set住民種別(住民種別List);
        key.set住民状態(住民状態List);
        key.set氏名履歴検索方法(RirekiSearchType.検索する);
        searchKey = key.build();
    }

    @Override
    protected void defineFlow() {
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.認定結果通知書)) {
            executeStep(認定結果通知書発行);
        }
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.サービス変更通知書)) {
            executeStep(サービス変更通知書発行);
        }
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.要介護度変更通知書)) {
            executeStep(要介護度変更通知書発行);
        }
    }

    /**
     * 認定結果通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定結果通知書発行)
    protected IBatchFlowCommand hakkoNinteiKekkaTsutisho() {
        return loopBatch(NinteiKekkaTsutishoProcess.class)
                .arguments(getParameter().toNinteiKekkaTsutishoProcessParameter(searchKey))
                .define();
    }

    /**
     * サービス変更通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(サービス変更通知書発行)
    protected IBatchFlowCommand hakkoServiceHenkoTsutisho() {
        return loopBatch(ServiceHenkoTsutishoProcess.class)
                .arguments(getParameter().toServiceHenkoTsutishoProcessParameter(searchKey))
                .define();
    }

    /**
     * 要介護度変更通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護度変更通知書発行)
    protected IBatchFlowCommand hakkoYokaigoHenkoTsutisho() {
        return loopBatch(YokaigoHenkoTsutishoProcess.class)
                .arguments(getParameter().toYokaigoHenkoTsutishoProcessParameter(searchKey))
                .define();
    }
}
