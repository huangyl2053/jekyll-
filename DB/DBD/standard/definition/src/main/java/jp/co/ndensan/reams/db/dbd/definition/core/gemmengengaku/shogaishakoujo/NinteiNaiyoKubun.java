package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除認定内容区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum NinteiNaiyoKubun {

    /**
     * コード:1 名称:知的障がい者（軽度・中度）に準ずる 略称:定義なし
     */
    知的障がい者_軽度_中度_に準ずる("1", "知的障がい者（軽度・中度）に準ずる"),
    /**
     * コード:2 名称:知的障がい者（重度）に準ずる 略称:定義なし
     */
    知的障がい者_重度_に準ずる("2", "知的障がい者（重度）に準ずる"),
    /**
     * コード:3 名称:身体障がい者（３～６級）に準ずる 略称:定義なし
     */
    身体障がい者_３から６級_に準ずる("3", "身体障がい者（３～６級）に準ずる"),
    /**
     * コード:4 名称:ねたきり老人 略称:定義なし
     */
    ねたきり老人("4", "ねたきり老人");

    private final RString code;
    private final RString fullName;

    private NinteiNaiyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 障がい者控除認定内容区分のコードを返します。
     *
     * @return 障がい者控除認定内容区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 障がい者控除認定内容区分の名称を返します。
     *
     * @return 障がい者控除認定内容区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 障がい者控除認定内容区分のコードと一致する内容を探します。
     *
     * @param code 障がい者控除認定内容区分のコード
     * @return {@code code} に対応する障がい者控除認定内容区分
     */
    public static NinteiNaiyoKubun toValue(RString code) {
        for (NinteiNaiyoKubun ninteiNaiyoKubun : NinteiNaiyoKubun.values()) {
            if (ninteiNaiyoKubun.code.equals(code)) {
                return ninteiNaiyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴普徴区分"));
    }
}
