/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 現在国保資格情報Entityクラスです。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GenzaiKokuhoShikakuJyohoEntity {

    private RString 識別コード;
    private RString 履歴番号;
    private RString 国保番号;
    private RString 国保保険者番号;
    private RString 国保保険証番号;
    private RString 国保個人番号;
    private RString 資格取得日;
    private RString 資格喪失日;
    private RString 退職該当日;
    private RString 退職非該当日;
    private RString 個人区分コード;
    private RString 登録区分;
}
