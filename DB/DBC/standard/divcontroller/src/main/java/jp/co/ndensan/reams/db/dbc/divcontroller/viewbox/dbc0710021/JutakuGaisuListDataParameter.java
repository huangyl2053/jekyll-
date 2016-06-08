/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 遷移画面と支給申請一覧Entityクラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuGaisuListDataParameter implements Serializable {

    private RString txtJyotai;
    private RString txtJutakuAddress;
    private RString txtKaishuNaiyo;
    private RString txtSeiriNo;
    private RString txtChakkoYoteibi;
    private RString txtKanseiYoteibi;
    private RString txtKaishuKingaku;
    private RString txtJigyosha;
    private RString txtJigyoshaNo;
    private RString txtMeseiNo;
    private RString txtRenban;
}
