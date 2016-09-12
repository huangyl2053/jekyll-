/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kensakujoken;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索条件カーソル位置を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KensakuCursorPosition {

    /**
     * コード:01 名称:氏名_カナ
     */
    氏名_カナ("01", "氏名_カナ"),
    /**
     * コード:02 名称:氏名_漢字
     */
    氏名_漢字("02", "氏名_漢字"),
    /**
     * コード:03 名称:生年月日
     */
    生年月日("03", "生年月日"),
    /**
     * コード:04 名称:住所
     */
    住所("04", "住所"),
    /**
     * コード:05 名称:被保番号
     */
    被保番号("05", "被保番号"),
    /**
     * コード:06 名称:住民コード
     */
    住民コード("06", "住民コード"),
    /**
     * コード:07 名称:世帯コード
     */
    世帯コード("07", "世帯コード"),
    /**
     * コード:08 名称:通知書番号
     */
    通知書番号("08", "通知書番号");

    private final RString code;
    private final RString fullName;

    private KensakuCursorPosition(String code, String fullname) {
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
    public static KensakuCursorPosition toValue(RString code) {
        for (KensakuCursorPosition kensakuCursorPosition : KensakuCursorPosition.values()) {
            if (kensakuCursorPosition.code.equals(code)) {
                return kensakuCursorPosition;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("検索条件カーソル位置"));
    }
}
