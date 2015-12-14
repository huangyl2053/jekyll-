package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付書の型を表す列挙型です。
 *
 * @author LDNS
 */
public enum NofusyoType {

    /**
     * コード:0 名称:なし 略称:定義なし
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:期毎 略称:定義なし
     */
    期毎("1", "期毎"),
    /**
     * コード:2 名称:銀振型5期 略称:定義なし
     */
    銀振型5期("2", "銀振型5期"),
    /**
     * コード:4 名称:銀振型4期 略称:定義なし
     */
    銀振型4期("4", "銀振型4期"),
    /**
     * コード:5 名称:ブック 略称:定義なし
     */
    ブック("5", "ブック"),
    /**
     * コード:6 名称:コンビニ 略称:定義なし
     */
    コンビニ("6", "コンビニ"),
    /**
     * コード:9 名称:その他 略称:定義なし
     */
    その他("9", "その他");

    private final RString code;
    private final RString fullName;

    private NofusyoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納付書の型のコードを返します。
     *
     * @return 納付書の型のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納付書の型の名称を返します。
     *
     * @return 納付書の型の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納付書の型のコードと一致する内容を探します。
     *
     * @param code 納付書の型のコード
     * @return {@code code} に対応する納付書の型
     */
    public static NofusyoType toValue(RString code) {
        for (NofusyoType nofusyoType : NofusyoType.values()) {
            if (nofusyoType.code.equals(code)) {
                return nofusyoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納付書の型"));
    }
}
