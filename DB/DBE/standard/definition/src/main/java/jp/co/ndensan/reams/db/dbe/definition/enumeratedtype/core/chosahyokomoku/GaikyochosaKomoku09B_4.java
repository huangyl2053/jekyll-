package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-4-09Bを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09B_4 {

    /**
     * コード:004 名称:（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ 略称:定義なし
     */
    _介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("004", "（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B_4(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-4-09Bのコードを返します。
     * 
     * @return 在宅利用-4-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-4-09Bの名称を返します。
     * 
     * @return 在宅利用-4-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-4-09Bのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-4-09Bのコード
     * @return {@code code} に対応する在宅利用-4-09B
     */
    public static GaikyochosaKomoku09B_4 toValue(RString code) {
        for (GaikyochosaKomoku09B_4 gaikyochosaKomoku09B_4 : GaikyochosaKomoku09B_4.values()) {
            if (gaikyochosaKomoku09B_4.code.equals(code)) {
                return gaikyochosaKomoku09B_4;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-4-09B"));
    }
}
