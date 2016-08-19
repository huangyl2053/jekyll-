package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象区分(給付減額管理リスト)を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TaishoKubun {

    /**
     * コード:1 名称:決定日 略称:定義なし
     */
    決定日("1", "決定日"),
    /**
     * コード:※ 名称:申請日 略称:定義なし
     */
    申請日("0", "申請日");

    private final RString code;
    private final RString fullName;

    private TaishoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象区分(給付減額管理リスト)のコードを返します。
     *
     * @return 対象区分(給付減額管理リスト)のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象区分(給付減額管理リスト)の名称を返します。
     *
     * @return 対象区分(給付減額管理リスト)の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象区分(給付減額管理リスト)のコードと一致する内容を探します。
     *
     * @param code 対象区分(給付減額管理リスト)のコード
     * @return {@code code} に対応する対象区分(給付減額管理リスト)
     */
    public static TaishoKubun toValue(RString code) {
        for (TaishoKubun taishoKubun : TaishoKubun.values()) {
            if (taishoKubun.code.equals(code)) {
                return taishoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象区分(給付減額管理リスト)"));
    }
}
