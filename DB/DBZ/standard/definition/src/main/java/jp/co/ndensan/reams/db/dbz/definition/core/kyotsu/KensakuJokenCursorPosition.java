/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索条件カーソル位置を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KensakuJokenCursorPosition {

    /**
     * コード:1 名称:被保番号 略称:定義なし
     */
    被保番号("1", "被保番号"),
    /**
     * コード:2 名称:個人番号 略称:定義なし
     */
    個人番号("2", "個人番号"),
    /**
     * コード:3 名称:名称 略称:定義なし
     */
    名称("3", "名称"),
    /**
     * コード:4 名称:生年月日 略称:定義なし
     */
    生年月日("4", "生年月日"),
    /**
     * コード:5 名称:住所 略称:定義なし
     */
    住所("5", "住所");

    private final RString code;
    private final RString fullName;

    private KensakuJokenCursorPosition(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 検索条件カーソル位置のコードを返します。
     *
     * @return 検索条件カーソル位置のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 検索条件カーソル位置の名称を返します。
     *
     * @return 検索条件カーソル位置の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 検索条件カーソル位置のコードと一致する内容を探します。
     *
     * @param code 検索条件カーソル位置のコード
     * @return {@code code} に対応する検索条件カーソル位置
     */
    public static KensakuJokenCursorPosition toValue(RString code) {

        for (KensakuJokenCursorPosition value : KensakuJokenCursorPosition.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("検索条件カーソル位置"));
    }
}
