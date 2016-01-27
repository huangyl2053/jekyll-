package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請有効区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiShinseiYukoKubunCode {

    /**
     * コード:0 名称:仮状態 略称:定義なし
     */
    仮状態("0", "仮状態"),
    /**
     * コード:1 名称:有効 略称:定義なし
     */
    有効("1", "有効"),
    /**
     * コード:2 名称:無効 略称:定義なし
     */
    無効("2", "無効");

    private final RString code;
    private final RString fullName;

    private NinteiShinseiYukoKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定申請有効区分のコードを返します。
     *
     * @return 認定申請有効区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定申請有効区分の名称を返します。
     *
     * @return 認定申請有効区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定申請有効区分のコードと一致する内容を探します。
     *
     * @param code 認定申請有効区分のコード
     * @return {@code code} に対応する認定申請有効区分
     */
    public static NinteiShinseiYukoKubunCode toValue(RString code) {

        for (NinteiShinseiYukoKubunCode ninteiShinseiYukoKubunCode : NinteiShinseiYukoKubunCode.values()) {
            if (ninteiShinseiYukoKubunCode.code.equals(code)) {
                return ninteiShinseiYukoKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定申請有効区分"));
    }
}
