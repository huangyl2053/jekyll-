/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410048;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokohi.KokuhorenDataTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410048.DBC0410048TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410048.TsuchishoJoho632Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_[632]総合事業費等請求額通知書（公費）情報取込のクラスです。
 *
 * @reamsid_L DBC-4700-010 qinzhen
 */
public class TsuchishoJoho632 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho632Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho632Div> onLoad(TsuchishoJoho632Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho632Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho632Div> onImplement(TsuchishoJoho632Div div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        div.getCcdKokurenJohoTorikomi().get再処理区分();
        div.getCcdKokurenJohoTorikomi().get処理年月();
        return ResponseData.of(div).respond();

    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho632Div
     * @return ResponseData
     */
    public ResponseData<KokuhorenDataTorikomiBatchParameter> onClick_btnExcute(TsuchishoJoho632Div div) {
        KokuhorenDataTorikomiBatchParameter parameter = setBatchParameter(div);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「実行する」を処理します。
     *
     * @param div TsuchishoJoho632Div
     * @return KokuhorenDataTorikomiBatchParameter
     */
    public KokuhorenDataTorikomiBatchParameter setBatchParameter(TsuchishoJoho632Div div) {
        KokuhorenDataTorikomiBatchParameter parameter = new KokuhorenDataTorikomiBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        SaiShoriKubun 再処理区分 = null;
        if (SaiShoriKubun.再処理.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.再処理;
        } else if (SaiShoriKubun.空白.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.空白;
        }
        RString 出力順ID = RString.EMPTY;
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toString()));
        parameter.setShutsuryokujunId(出力順ID);
        return parameter;
    }

    /**
     * 「戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC0410011
     * @return ResponseData<DBC0410011Div>
     */
    public ResponseData<TsuchishoJoho632Div> onClick_btnBack(TsuchishoJoho632Div div) {

        return ResponseData.of(div).forwardWithEventName(DBC0410048TransitionEventName.戻る).respond();
    }
}
