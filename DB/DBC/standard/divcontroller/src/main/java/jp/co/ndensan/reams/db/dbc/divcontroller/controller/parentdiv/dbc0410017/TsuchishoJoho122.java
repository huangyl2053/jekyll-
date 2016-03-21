/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410017;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410017.TsuchishoJoho122Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_(122)総合事業費資格総合表情報のクラスです。
 */
public class TsuchishoJoho122 {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJoho122Div
     * @return 総合事業費資格総合表情報の画面。
     */
    public ResponseData<TsuchishoJoho122Div> onLoad(TsuchishoJoho122Div div) {

        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                RDate.getNowDate().getYearMonth(), new RString("1"));
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        div.getCcdKokurenJohoTorikomi().onLoadMode1();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJoho122Div
     * @return TsuchishoJoho122Div
     */
    public ResponseData<TsuchishoJoho122Div> onClick_btnExcute(TsuchishoJoho122Div div) {

        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理年月();
        return ResponseData.of(div).respond();
    }
}
