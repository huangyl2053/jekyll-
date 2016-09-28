package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 番号制度認定済区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum BangoseidoNinteisumiKubun {

    /**
     * コード:0 名称:初期値 略称:定義なし
     */
    初期値("0", "初期値"),
    /**
     * コード:1 名称:認定済 略称:定義なし
     */
    認定済("1", "認定済"),
    /**
     * コード:2 名称:申請中 略称:定義なし
     */
    申請中("2", "申請中");

    private final RString code;
    private final RString fullName;

    private BangoseidoNinteisumiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 番号制度認定済区分のコードを返します。
     *
     * @return 番号制度認定済区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 番号制度認定済区分の名称を返します。
     *
     * @return 番号制度認定済区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 番号制度認定済区分のコードと一致する内容を探します。
     *
     * @param code 番号制度認定済区分のコード
     * @return {@code code} に対応する番号制度認定済区分
     */
    public static BangoseidoNinteisumiKubun toValue(RString code) {
        for (BangoseidoNinteisumiKubun bangoseidoNinteisumiKubun : BangoseidoNinteisumiKubun.values()) {
            if (bangoseidoNinteisumiKubun.code.equals(code)) {
                return bangoseidoNinteisumiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
