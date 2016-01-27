package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴捕捉者依頼金額計算を表す列挙型です。
 *
 * @author LDNS
 */
public enum HosokushaIraiKingaku {

    /**
     * コード:0 名称:通常の異動賦課に含めて計算する 略称:定義なし
     */
    通常の異動賦課に含めて計算する("0", "通常の異動賦課に含めて計算する"),
    /**
     * コード:1 名称:特徴捕捉対象者のみを計算する 略称:定義なし
     */
    特徴捕捉対象者のみを計算する("1", "特徴捕捉対象者のみを計算する");

    private final RString code;
    private final RString fullName;

    private HosokushaIraiKingaku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴捕捉者依頼金額計算のコードを返します。
     *
     * @return 特徴捕捉者依頼金額計算のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴捕捉者依頼金額計算の名称を返します。
     *
     * @return 特徴捕捉者依頼金額計算の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴捕捉者依頼金額計算のコードと一致する内容を探します。
     *
     * @param code 特徴捕捉者依頼金額計算のコード
     * @return {@code code} に対応する特徴捕捉者依頼金額計算
     */
    public static HosokushaIraiKingaku toValue(RString code) {
        for (HosokushaIraiKingaku hosokushaIraiKingaku : HosokushaIraiKingaku.values()) {
            if (hosokushaIraiKingaku.code.equals(code)) {
                return hosokushaIraiKingaku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴捕捉者依頼金額計算"));
    }
}
