/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1320011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020.DBC060020_KyufuhiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 給付費通知書作成(一括)のdivControllerです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
public class KyufuTsuchiSakuseiIkatu {

    /**
     * 給付費通知書作成(一括)初期化を処理します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onLoad(KyufuTsuchiSakuseiIkatuDiv div) {
        getHandler(div).onLoad(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務));
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費通知書作成(一括)バッチを実行します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<DBC060020_KyufuhiTsuchishoParameter> onClick_btnPrint(KyufuTsuchiSakuseiIkatuDiv div) {
        DBC060020_KyufuhiTsuchishoParameter parameter = getHandler(div).create給付費通知書作成パラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「被保険者検索」ボタンを押します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onClick_btnHihokenshaSearch(KyufuTsuchiSakuseiIkatuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費通知情報を取り込む」ボタンを押します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onClick_btnKyufuTsuchiJyoho(KyufuTsuchiSakuseiIkatuDiv div) {
        getHandler(div).setRowFileData();
        return ResponseData.of(div).respond();
    }

    /**
     * 「要介護度」の「すべて選択」チェックボックスをチェックします。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onChange_cbxYokaigoJotai(KyufuTsuchiSakuseiIkatuDiv div) {
        getHandler(div).onChange_cbxYokaigoJotai();
        return ResponseData.of(div).respond();
    }

    private KyufuTsuchiSakuseiIkatuHandler getHandler(KyufuTsuchiSakuseiIkatuDiv div) {
        return new KyufuTsuchiSakuseiIkatuHandler(div);
    }
}
