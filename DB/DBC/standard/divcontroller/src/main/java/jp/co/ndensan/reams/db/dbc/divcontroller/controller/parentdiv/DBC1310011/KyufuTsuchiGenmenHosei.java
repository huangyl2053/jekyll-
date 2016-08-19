/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1310011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060010.DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1310011.KyufuTsuchiGenmenHoseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1310011.KyufuTsuchiGenmenHoseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 給付費通知減免補正一覧表作成のdivcontrollerクラスです。
 *
 * @reamsid_L DBC-2270-010 lijia
 */
public class KyufuTsuchiGenmenHosei {

    /**
     * 総合事業区分支給限度額登録作成画面初期化を処理します。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiDiv> onLoad(KyufuTsuchiGenmenHoseiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoJissekiIchiranBatchParameter> 給付費通知減免補正一覧表のバッチ用パラメータ
     */
    public ResponseData<DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter> onClick_BtnPulish(KyufuTsuchiGenmenHoseiDiv div) {
        return ResponseData.of(getHandler(div).btnPulish()).respond();
    }

    private KyufuTsuchiGenmenHoseiHandler getHandler(KyufuTsuchiGenmenHoseiDiv div) {
        return new KyufuTsuchiGenmenHoseiHandler(div);
    }
}
