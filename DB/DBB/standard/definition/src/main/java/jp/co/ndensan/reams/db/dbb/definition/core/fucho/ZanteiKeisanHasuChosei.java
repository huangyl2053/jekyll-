package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定計算端数調整を表す列挙型です。
 *
 * @author LDNS
 */
public enum ZanteiKeisanHasuChosei {

    /**
     * コード:0 名称:端数調整なし 略称:なし
     */
    なし("0", "端数調整なし", "なし"),
    /**
     * コード:1 名称:端数調整あり 略称:あり
     */
    あり("1", "端数調整あり", "あり");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ZanteiKeisanHasuChosei(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 仮算定計算端数調整のコードを返します。
     *
     * @return 仮算定計算端数調整のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 仮算定計算端数調整の名称を返します。
     *
     * @return 仮算定計算端数調整の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 仮算定計算端数調整の略称を返します。
     *
     * @return 仮算定計算端数調整の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 仮算定計算端数調整のコードと一致する内容を探します。
     *
     * @param code 仮算定計算端数調整のコード
     * @return {@code code} に対応する仮算定計算端数調整
     */
    public static ZanteiKeisanHasuChosei toValue(RString code) {
        for (ZanteiKeisanHasuChosei zanteiKeisanHasuChosei : ZanteiKeisanHasuChosei.values()) {
            if (zanteiKeisanHasuChosei.code.equals(code)) {
                return zanteiKeisanHasuChosei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("仮算定計算端数調整"));
    }
}
