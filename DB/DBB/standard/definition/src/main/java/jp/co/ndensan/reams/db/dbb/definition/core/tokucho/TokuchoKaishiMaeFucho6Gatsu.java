package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始前普通徴収6月を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum TokuchoKaishiMaeFucho6Gatsu {

    /**
     * コード:0 名称:特別徴収開始前の仮算定納期で普通徴収しない 略称:定義なし
     */
    なし("0", "特別徴収開始前の仮算定納期で普通徴収しない"),
    /**
     * コード:1 名称:特別徴収開始前の仮算定納期で普通徴収する 略称:定義なし
     */
    あり("1", "特別徴収開始前の仮算定納期で普通徴収する");

    private final RString code;
    private final RString fullName;

    private TokuchoKaishiMaeFucho6Gatsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴開始前普通徴収6月のコードを返します。
     *
     * @return 特徴開始前普通徴収6月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始前普通徴収6月の名称を返します。
     *
     * @return 特徴開始前普通徴収6月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始前普通徴収6月のコードと一致する内容を探します。
     *
     * @param code 特徴開始前普通徴収6月のコード
     * @return {@code code} に対応する特徴開始前普通徴収6月
     */
    public static TokuchoKaishiMaeFucho6Gatsu toValue(RString code) {
        for (TokuchoKaishiMaeFucho6Gatsu tokuｃhoKaishiMaeFucho6Gatsu : TokuchoKaishiMaeFucho6Gatsu.values()) {
            if (tokuｃhoKaishiMaeFucho6Gatsu.code.equals(code)) {
                return tokuｃhoKaishiMaeFucho6Gatsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始前普通徴収6月"));
    }
}
