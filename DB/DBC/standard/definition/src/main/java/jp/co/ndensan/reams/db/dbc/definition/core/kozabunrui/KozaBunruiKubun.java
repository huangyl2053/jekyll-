package jp.co.ndensan.reams.db.dbc.definition.core.kozabunrui;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座分類区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaBunruiKubun {

    /**
     * コード:1 名称:償還払い支給 略称:定義なし
     */
    償還払い支給("1", "償還払い支給"),
    /**
     * コード:2 名称:高額介護サービス費支給 略称:定義なし
     */
    高額介護サービス費支給("2", "高額介護サービス費支給"),
    /**
     * コード:3 名称:高額合算費支給 略称:定義なし
     */
    高額合算費支給("3", "高額合算費支給");

    private final RString code;
    private final RString fullName;

    private KozaBunruiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座分類区分のコードを返します。
     *
     * @return 口座分類区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座分類区分の名称を返します。
     *
     * @return 口座分類区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座分類区分のコードと一致する内容を探します。
     *
     * @param code 口座分類区分のコード
     * @return {@code code} に対応する口座分類区分
     */
    public static KozaBunruiKubun toValue(RString code) {

        for (KozaBunruiKubun kozaBunruiKubun : KozaBunruiKubun.values()) {
            if (kozaBunruiKubun.code.equals(code)) {
                return kozaBunruiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座分類区分"));
    }
}
