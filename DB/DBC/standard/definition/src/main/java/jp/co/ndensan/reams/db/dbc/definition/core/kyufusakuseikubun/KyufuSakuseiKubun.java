package jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績情報作成区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum KyufuSakuseiKubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:修正 略称:定義なし
     */
    修正("2", "修正"),
    /**
     * コード:3 名称:削除 略称:定義なし
     */
    削除("3", "取消");

    private final RString code;
    private final RString fullName;

    private KyufuSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績情報作成区分のコードを返します。
     *
     * @return 給付実績情報作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績情報作成区分の名称を返します。
     *
     * @return 給付実績情報作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付実績情報作成区分のコードと一致する内容を探します。
     *
     * @param code 給付実績情報作成区分のコード
     * @return {@code code} に対応する給付実績情報作成区分
     */
    public static KyufuSakuseiKubun toValue(RString code) {

        for (KyufuSakuseiKubun kyufuSakuseiKubun : KyufuSakuseiKubun.values()) {
            if (kyufuSakuseiKubun.code.equals(code)) {
                return kyufuSakuseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績情報作成区分"));
    }
}
