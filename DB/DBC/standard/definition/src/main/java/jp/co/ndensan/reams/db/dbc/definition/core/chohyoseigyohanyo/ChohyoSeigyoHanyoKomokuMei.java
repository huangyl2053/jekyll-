/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用項目名を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 lijian
 */
public enum ChohyoSeigyoHanyoKomokuMei {

    /**
     * コード:無し 名称:帳票タイトル 略称:定義なし
     */
    帳票タイトル("帳票タイトル"),
    /**
     * コード:無し 名称:帳票タイトル_定期 略称:定義なし
     */
    帳票タイトル_定期("帳票タイトル_定期"),
    /**
     * コード:無し 名称:帳票タイトル_随時 略称:定義なし
     */
    帳票タイトル_随時("帳票タイトル_随時"),
    /**
     * コード:無し 名称:帳票タイトル_口座 略称:定義なし
     */
    帳票タイトル_口座("帳票タイトル_口座"),
    /**
     * コード:無し 名称:帳票タイトル_窓口 略称:定義なし
     */
    帳票タイトル_窓口("帳票タイトル_窓口");

    private final RString fullName;

    private ChohyoSeigyoHanyoKomokuMei(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 処理名の名称を返します。
     *
     * @return 処理名の名称
     */
    public RString get名称() {
        return fullName;
    }
}
