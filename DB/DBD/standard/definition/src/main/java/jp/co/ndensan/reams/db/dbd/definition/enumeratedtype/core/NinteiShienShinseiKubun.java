package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定支援申請区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiShienShinseiKubun {

    /**
     * コード:0 名称:認定支援申請以外 略称:定義なし
     */
    認定支援申請以外("0", "認定支援申請以外"),
    /**
     * コード:1 名称:認定支援申請 略称:定義なし
     */
    認定支援申請("1", "認定支援申請");

    private final RString code;
    private final RString fullName;

    private NinteiShienShinseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定支援申請区分のコードを返します。
     *
     * @return 認定支援申請区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定支援申請区分の名称を返します。
     *
     * @return 認定支援申請区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定支援申請区分のコードと一致する内容を探します。
     *
     * @param code 認定支援申請区分のコード
     * @return {@code code} に対応する認定支援申請区分
     */
    public static NinteiShienShinseiKubun toValue(RString code) {

        for (NinteiShienShinseiKubun ninteiShienShinseiKubun : NinteiShienShinseiKubun.values()) {
            if (ninteiShienShinseiKubun.code.equals(code)) {
                return ninteiShienShinseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定支援申請区分"));
    }
}
