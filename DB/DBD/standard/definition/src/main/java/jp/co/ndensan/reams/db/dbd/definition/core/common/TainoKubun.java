package jp.co.ndensan.reams.db.dbd.definition.core.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 滞納区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TainoKubun {

    /**
     * コード:なし 名称:空白 略称:定義なし
     */
    空白("空白"),
    /**
     * コード:なし 名称:時効成立 略称:定義なし
     */
    時効成立("時効成立"),
    /**
     * コード:なし 名称:最古滞納期 略称:定義なし
     */
    最古滞納期("最古滞納期"),
    /**
     * コード:なし 名称:滞納期 略称:定義なし
     */
    滞納期("滞納期"),
    /**
     * コード:なし 名称:納期限未到来 略称:定義なし
     */
    納期限未到来("納期限未到来");

    private final RString fullName;

    private TainoKubun(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 滞納区分の名称を返します。
     *
     * @return 滞納区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 滞納区分の名称と一致する内容を探します。
     *
     * @param fullname 滞納区分の名称
     * @return {@code code} に対応する滞納区分
     */
    public static TainoKubun toValue(RString fullname) {
        for (TainoKubun tainoKubun : TainoKubun.values()) {
            if (tainoKubun.get名称().equals(fullname)) {
                return tainoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("滞納区分"));
    }
}
