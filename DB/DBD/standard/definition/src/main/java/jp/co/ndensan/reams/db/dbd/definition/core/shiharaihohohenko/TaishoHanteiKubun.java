package jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象判定区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TaishoHanteiKubun {

    /**
     * コード:空 名称:空 略称:定義なし
     */
    _空(RString.EMPTY.toString(), RString.EMPTY.toString()),
    /**
     * コード:1 名称:今回対象 略称:定義なし
     */
    今回対象("1", "今回対象"),
    /**
     * コード:2 名称:前回対象 略称:定義なし
     */
    前回対象("2", "前回対象");

    private final RString code;
    private final RString fullName;

    private TaishoHanteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象判定区分のコードを返します。
     *
     * @return 対象判定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象判定区分の名称を返します。
     *
     * @return 対象判定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象判定区分のコードと一致する内容を探します。
     *
     * @param code 対象判定区分のコード
     * @return {@code code} に対応する対象判定区分
     */
    public static TaishoHanteiKubun toValue(RString code) {
        for (TaishoHanteiKubun taishoHanteiKubun : TaishoHanteiKubun.values()) {
            if (taishoHanteiKubun.code.equals(code)) {
                return taishoHanteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象判定区分"));
    }
}
