/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 遷移画面と支給申請一覧Entityクラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuGaisuDataParameter implements Serializable {

    private List<JutakuGaisuListDataParameter> 住宅改修データ;
    private List<RString> 限度額リセット;
}
