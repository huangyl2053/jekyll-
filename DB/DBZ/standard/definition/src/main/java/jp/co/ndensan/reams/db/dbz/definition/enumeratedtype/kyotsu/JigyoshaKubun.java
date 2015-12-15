package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum JigyoshaKubun {

    /**
     * コード:1 名称:医科 略称:定義なし
     */
    医科("1", "医科"),
    /**
     * コード:3 名称:歯科 略称:定義なし
     */
    歯科("3", "歯科"),
    /**
     * コード:4 名称:薬局 略称:定義なし
     */
    薬局("4", "薬局"),
    /**
     * コード:5 名称:老人保健施設 略称:定義なし
     */
    老人保健施設("5", "老人保健施設"),
    /**
     * コード:6 名称:訪問看護ステーション 略称:定義なし
     */
    訪問看護ステーション("6", "訪問看護ステーション"),
    /**
     * コード:7 名称:介護保険事業所 略称:定義なし
     */
    介護保険事業所("7", "介護保険事業所"),
    /**
     * コード:8 名称:基準該当事業所 略称:定義なし
     */
    基準該当事業所("8", "基準該当事業所");

    private final RString code;
    private final RString fullName;

    private JigyoshaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業者区分のコードを返します。
     *
     * @return 事業者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業者区分の名称を返します。
     *
     * @return 事業者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業者区分のコードと一致する内容を探します。
     *
     * @param code 事業者区分のコード
     * @return {@code code} に対応する事業者区分
     */
    public static JigyoshaKubun toValue(RString code) {

        for (JigyoshaKubun jigyoshaKubun : JigyoshaKubun.values()) {
            if (jigyoshaKubun.code.equals(code)) {
                return jigyoshaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業者区分"));
    }
}
