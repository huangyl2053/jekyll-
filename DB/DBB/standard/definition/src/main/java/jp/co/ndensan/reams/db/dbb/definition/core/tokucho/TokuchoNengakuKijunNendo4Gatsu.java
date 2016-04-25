package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴年額基準年度4月を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum TokuchoNengakuKijunNendo4Gatsu {

    /**
     * コード:1 名称:当年度 略称:定義なし
     */
    当年度("1", "当年度"),
    /**
     * コード:2 名称:翌年度 略称:定義なし
     */
    翌年度("2", "翌年度");

    private final RString code;
    private final RString fullName;

    private TokuchoNengakuKijunNendo4Gatsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴年額基準年度4月のコードを返します。
     *
     * @return 特徴年額基準年度4月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴年額基準年度4月の名称を返します。
     *
     * @return 特徴年額基準年度4月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴年額基準年度4月のコードと一致する内容を探します。
     *
     * @param code 特徴年額基準年度4月のコード
     * @return {@code code} に対応する特徴年額基準年度4月
     */
    public static TokuchoNengakuKijunNendo4Gatsu toValue(RString code) {
        for (TokuchoNengakuKijunNendo4Gatsu value : TokuchoNengakuKijunNendo4Gatsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴年額基準年度4月"));
    }
}
