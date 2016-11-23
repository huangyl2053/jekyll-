/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DB保存情報です。
 *
 * @reamsid_L DBC-1030-180 zhuxj2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBHozonJoho {

    private DbJohoViewState db情報;
    private RString 修正前支給区分;

    /**
     * インスタンスを生成します。
     *
     * @param db情報 db情報
     * @param 修正前支給区分 修正前支給区分
     */
    public DBHozonJoho(DbJohoViewState db情報, RString 修正前支給区分) {
        this.db情報 = db情報;
        this.修正前支給区分 = 修正前支給区分;
    }
}
