package jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付分類区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KyufubunruiKubun {

    /**
     * コード:1 名称:介護給付 略称:定義なし
     */
    介護給付("1", "介護給付"),
    /**
     * コード:2 名称:予防給付 略称:定義なし
     */
    予防給付("2", "予防給付"),
    /**
     * コード:3 名称:介護給付と予防給付 略称:定義なし
     */
    介護給付と予防給付("3", "介護給付と予防給付"),
    /**
     * コード:4 名称:総合事業（経過措置） 略称:定義なし
     */
    総合事業_経過措置("4", "総合事業（経過措置）"),
    /**
     * コード:5 名称:総合事業 略称:定義なし
     */
    総合事業("5", "総合事業"),
    /**
     * コード:0 名称:区分なし 略称:定義なし
     */
    区分なし("0", "区分なし");

    private final RString code;
    private final RString fullName;

    private KyufubunruiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付分類区分のコードを返します。
     *
     * @return 給付分類区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付分類区分の名称を返します。
     *
     * @return 給付分類区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付分類区分のコードと一致する内容を探します。
     *
     * @param code 給付分類区分のコード
     * @return {@code code} に対応する給付分類区分
     */
    public static KyufubunruiKubun toValue(RString code) {
        for (KyufubunruiKubun kyufubunruiKubun : KyufubunruiKubun.values()) {
            if (kyufubunruiKubun.code.equals(code)) {
                return kyufubunruiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付分類区分"));
    }
}
