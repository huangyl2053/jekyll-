/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.santeikijungaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 算定基準額を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 wangkanglei
 */
public enum SanteiKijungaku {

    /**
     * コード:1 名称:15_000円 略称:15,000円
     */
    算定基準額_15_000円("1", "15_000円", "15,000円"),
    /**
     * コード:2 名称:24_600円 略称:24,600円
     */
    算定基準額_24_600円("2", "24_600円", "24,600円"),
    /**
     * コード:3 名称:37_200円 略称:37,200円
     */
    算定基準額_37_200円("3", "37_200円", "37,200円"),
    /**
     * コード:4 名称:44_400円 略称:44,400円
     */
    算定基準額_44_400円("4", "44_400円", "44,400円");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private SanteiKijungaku(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 算定基準額のコードを返します。
     *
     * @return 算定基準額のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 算定基準額の名称を返します。
     *
     * @return 算定基準額の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 算定基準額の略称を返します。
     *
     * @return 算定基準額の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 算定基準額のコードと一致する内容を探します。
     *
     * @param code 算定基準額のコード
     * @return {@code code} に対応する算定基準額
     */
    public static SanteiKijungaku toValue(RString code) {

        for (SanteiKijungaku saihakkoKubun : SanteiKijungaku.values()) {
            if (saihakkoKubun.code.equals(code)) {
                return saihakkoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("算定基準額"));
    }
}
