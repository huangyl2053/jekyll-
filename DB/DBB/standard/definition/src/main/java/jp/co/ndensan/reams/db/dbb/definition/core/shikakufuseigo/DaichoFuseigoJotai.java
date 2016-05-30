package jp.co.ndensan.reams.db.dbb.definition.core.shikakufuseigo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 台帳不整合状態を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum DaichoFuseigoJotai {

    /**
     * コード:1 名称:不整合なし 略称:定義なし
     */
    不整合なし("1", "不整合なし"),
    /**
     * コード:1 名称:不整合あり 略称:定義なし
     */
    不整合あり("1", "不整合あり"),
    /**
     * コード:1 名称:未作成 略称:定義なし
     */
    未作成("1", "未作成");

    private final RString code;
    private final RString fullName;

    private DaichoFuseigoJotai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 台帳不整合状態のコードを返します。
     *
     * @return 台帳不整合状態のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 台帳不整合状態の名称を返します。
     *
     * @return 台帳不整合状態の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 台帳不整合状態のコードと一致する内容を探します。
     *
     * @param code 台帳不整合状態のコード
     * @return {@code code} に対応する台帳不整合状態
     */
    public static DaichoFuseigoJotai toValue(RString code) {
        for (DaichoFuseigoJotai daichoFuseigoJotai : DaichoFuseigoJotai.values()) {
            if (daichoFuseigoJotai.code.equals(code)) {
                return daichoFuseigoJotai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("台帳不整合状態"));
    }
}
