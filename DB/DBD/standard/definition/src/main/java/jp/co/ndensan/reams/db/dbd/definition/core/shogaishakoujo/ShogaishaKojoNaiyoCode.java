/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shogaishakoujo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除認定内容を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 xuyue
 */
public enum ShogaishaKojoNaiyoCode {

    /**
     * コード:01 名称:知的障がい者（軽度～中度）に準ずる 略称:定義なし
     */
    知的障がい者("01", "知的障がい者（軽度～中度）に準ずる"),
    /**
     * コード:02 名称:知的障がい者（重度）に準ずる 略称:定義なし
     */
    重度知的障がい者("02", "知的障がい者（重度）に準ずる"),
    /**
     * コード:03 名称:身体障がい者（３級～６級）に準ずる 略称:定義なし
     */
    身体障がい者("03", "身体障がい者（３級～６級）に準ずる"),
    /**
     * コード:04 名称:ねたきり老人 略称:定義なし
     */
    ねたきり老人("04", "ねたきり老人");

    private final RString code;
    private final RString fullName;

    private ShogaishaKojoNaiyoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 障がい者控除認定内容のコードを返します。
     *
     * @return 障がい者控除認定内容のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 障がい者控除認定内容の名称を返します。
     *
     * @return 障がい者控除認定内容の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 障がい者控除認定内容のコードと一致する内容を探します。
     *
     * @param code 障がい者控除認定内容のコード
     * @return {@code code} に対応する障がい者控除認定内容
     */
    public static ShogaishaKojoNaiyoCode toValue(RString code) {

        for (ShogaishaKojoNaiyoCode shogaishaKojoNaiyoCode : ShogaishaKojoNaiyoCode.values()) {
            if (shogaishaKojoNaiyoCode.code.equals(code)) {
                return shogaishaKojoNaiyoCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("障がい者控除認定内容"));
    }
}
