/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 編集範囲区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum HenshuHaniKubun {

    /**
     * コード:1 名称:全てのレイアウト 略称:定義なし
     */
    Coverのみ("1", "Coverのみ"),
    /**
     * コード:2 名称:全てのレイアウト 略称:定義なし
     */
    Detailのみ("2", "Detailのみ"),
    /**
     * コード:3 名称:全てのレイアウト 略称:定義なし
     */
    全てのレイアウト("3", "全てのレイアウト");
    private final RString code;
    private final RString fullName;

    private HenshuHaniKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 領収日付欄のコードを返します。
     *
     * @return 領収日付欄のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 領収日付欄の名称を返します。
     *
     * @return 領収日付欄の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 領収日付欄のコードと一致する内容を探します。
     *
     * @param code 領収日付欄のコード
     * @return {@code code} に対応する領収日付欄
     */
    public static HenshuHaniKubun toValue(RString code) {
        for (HenshuHaniKubun henshuHaniKubun : HenshuHaniKubun.values()) {
            if (henshuHaniKubun.code.equals(code)) {
                return henshuHaniKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("編集範囲区分"));
    }

}
