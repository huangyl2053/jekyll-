/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0140011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160010.DBC160010_KeikakuTodokedeJokyoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011.DBC0140011KeikakuTodokeJohoListDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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
     * @return KeikakuTodokedeJokyoIchiranBatchParameter　parameter
     */
    public DBC160010_KeikakuTodokedeJokyoIchiranParameter onClick_btnBatchRegister() {
        DBC160010_KeikakuTodokedeJokyoIchiranParameter parameter = new DBC160010_KeikakuTodokedeJokyoIchiranParameter();
        if (div.getTbJukyuShinseibi().getFromValue() != null) {
            parameter.setJyukyuushinseibiFrom(new FlexibleDate(div.getTbJukyuShinseibi().getFromValue().toDateString()));
        }
        if (div.getTbJukyuShinseibi().getToValue() != null) {
            parameter.setJyukyuushinseibiTo(new FlexibleDate(div.getTbJukyuShinseibi().getToValue().toDateString()));
        }
        parameter.setTaisyoushatyuusyutu(div.getDdlTaishousha().getSelectedValue());
        parameter.setTodokeidejyoukyou(div.getDdlTodokeJokyo().getSelectedValue());
        if (div.getTbKijunbi().getValue() != null) {
            parameter.setKijyunbi(new FlexibleDate(div.getTbKijunbi().getValue().toDateString()));
        }
        if (div.getPrintOrderCv().get出力順ID() != null) {
            parameter.setShutsuryokujunId(new Long(div.getPrintOrderCv().get出力順ID()));
        }
        return parameter;

    }

    /**
     * コンストラクタです
     *
     * @param div DBC0140011KeikakuTodokeJohoListDiv
     *
     * @return ハンドラ
     */
    public static DBC0140011KeikakuTodokeJohoListHandler of(DBC0140011KeikakuTodokeJohoListDiv div) {
        return new DBC0140011KeikakuTodokeJohoListHandler(div);
    }

}
