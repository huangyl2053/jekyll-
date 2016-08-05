/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0140011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011.DBC0140011KeikakuTodokeJohoListDiv;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0140011_計画届出情報リスト
 *
 * @reamsid_L DBC-1960-010 wangxingpeng
 */
public final class DBC0140011KeikakuTodokeJohoListHandler {

    private final DBC0140011KeikakuTodokeJohoListDiv div;

    private DBC0140011KeikakuTodokeJohoListHandler(DBC0140011KeikakuTodokeJohoListDiv div) {
        this.div = div;
    }

    /**
     * バッチのパラメタです。
     *
     *
     * @return KeikakuTodokedeJokyoIchiranBatchParameter　parameter
     */
    public ResponseData<KeikakuTodokedeJokyoIchiranBatchParameter> onClick_btnBatchRegister() {
        KeikakuTodokedeJokyoIchiranBatchParameter parameter = new KeikakuTodokedeJokyoIchiranBatchParameter();

        parameter.set受給申請日From(new YMDHMS(div.getTbJukyuShinseibi().getFromValue().toDateString()));
        parameter.set受給申請日To(new YMDHMS(div.getTbJukyuShinseibi().getToValue().toDateString()));
        parameter.set対象者抽出(div.getDdlTaishousha().getLabelLText());
        parameter.set届出状況(div.getDdlTodokeJokyo().getLabelLText());
        parameter.set基準日(new FlexibleDate(div.getTbKijunbi().getValue().toDateString()));
        parameter.set出力順ID(new RString(div.getPrintOrderCv().get出力順ID()));
        return ResponseData.of(parameter).respond();

    }

    /**
     * コンストラクタです
     *
     * @param div DBC0140011KeikakuTodokeJohoListDiv
     * @return ハンドラ
     */
    public static DBC0140011KeikakuTodokeJohoListHandler of(DBC0140011KeikakuTodokeJohoListDiv div) {
        return new DBC0140011KeikakuTodokeJohoListHandler(div);
    }

}
