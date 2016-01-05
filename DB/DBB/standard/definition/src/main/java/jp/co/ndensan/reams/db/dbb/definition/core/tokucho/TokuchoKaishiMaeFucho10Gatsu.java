package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始前普通徴収10月を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoKaishiMaeFucho10Gatsu {

    /**
     * コード:0 名称:なし 略称:年度前半の本算定納期で普通徴収しない
     */
    年度前半の本算定納期で普通徴収しない("0", "なし", "年度前半の本算定納期で普通徴収しない"),
    /**
     * コード:1 名称:あり 略称:年度前半の本算定納期で普通徴収する
     */
    年度前半の本算定納期で普通徴収する("1", "あり", "年度前半の本算定納期で普通徴収する");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoKaishiMaeFucho10Gatsu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴開始前普通徴収10月のコードを返します。
     *
     * @return 特徴開始前普通徴収10月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始前普通徴収10月の名称を返します。
     *
     * @return 特徴開始前普通徴収10月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始前普通徴収10月の略称を返します。
     *
     * @return 特徴開始前普通徴収10月の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴開始前普通徴収10月のコードと一致する内容を探します。
     *
     * @param code 特徴開始前普通徴収10月のコード
     * @return {@code code} に対応する特徴開始前普通徴収10月
     */
    public static TokuchoKaishiMaeFucho10Gatsu toValue(RString code) {
        for (TokuchoKaishiMaeFucho10Gatsu tokuchoKaishiMaeFucho10Gatsu : TokuchoKaishiMaeFucho10Gatsu.values()) {
            if (tokuchoKaishiMaeFucho10Gatsu.code.equals(code)) {
                return tokuchoKaishiMaeFucho10Gatsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始前普通徴収10月"));
    }
}
