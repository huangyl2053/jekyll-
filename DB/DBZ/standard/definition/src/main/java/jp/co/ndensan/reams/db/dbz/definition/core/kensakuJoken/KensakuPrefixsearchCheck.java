/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kensakujoken;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索条件前方一致チェックを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KensakuPrefixsearchCheck {

    /**
     * コード:0 名称:なし
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:あり
     */
    あり("1", "あり");

    private final RString code;
    private final RString fullName;

    private KensakuPrefixsearchCheck(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 検索条件前方一致チェックのコードを返します。
     *
     * @return 検索条件前方一致チェックのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 検索条件前方一致チェックの名称を返します。
     *
     * @return 検索条件前方一致チェックの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 検索条件前方一致チェックのコードと一致する内容を探します。
     *
     * @param code 検索条件前方一致チェックのコード
     * @return {@code code} に対応する検索条件前方一致チェック
     */
    public static KensakuPrefixsearchCheck toValue(RString code) {
        for (KensakuPrefixsearchCheck kensakuPrefixsearchCheck : KensakuPrefixsearchCheck.values()) {
            if (kensakuPrefixsearchCheck.code.equals(code)) {
                return kensakuPrefixsearchCheck;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("検索条件前方一致チェック"));
    }
}
