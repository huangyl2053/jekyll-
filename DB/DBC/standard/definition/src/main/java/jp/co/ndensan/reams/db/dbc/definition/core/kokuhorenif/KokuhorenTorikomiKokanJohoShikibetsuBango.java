package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取込交換情報識別番号を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 sunhaidi
 */
public enum KokuhorenTorikomiKokanJohoShikibetsuBango {

    /**
     * コード:5C31 名称:共同処理用受給者情報更新結果情報_基本情報 略称:共同処理用受給者情報更新結果情報_基本情報
     */
    共同処理用受給者情報更新結果情報_基本情報("5C31", "共同処理用受給者情報更新結果情報_基本情報", "共同処理用受給者情報更新結果情報_基本情報"),
    /**
     * コード:5D31 名称:共同処理用受給者情報更新結果情報_償還情報 略称:共同処理用受給者情報更新結果情報_償還情報
     */
    共同処理用受給者情報更新結果情報_償還情報("5D31", "共同処理用受給者情報更新結果情報_償還情報", "共同処理用受給者情報更新結果情報_償還情報"),
    /**
     * コード:5E31 名称:共同処理用受給者情報更新結果情報_高額情報 略称:共同処理用受給者情報更新結果情報_高額情報
     */
    共同処理用受給者情報更新結果情報_高額情報("5E31", "共同処理用受給者情報更新結果情報_高額情報", "共同処理用受給者情報更新結果情報_高額情報"),
    /**
     * コード:5C41 名称:共同処理用受給者情報_基本情報 略称:共同処理用受給者情報_基本情報
     */
    共同処理用受給者情報_基本情報("5C41", "共同処理用受給者情報_基本情報", "共同処理用受給者情報_基本情報"),
    /**
     * コード:5D41 名称:共同処理用受給者情報_償還情報 略称:共同処理用受給者情報_償還情報
     */
    共同処理用受給者情報_償還情報("5D41", "共同処理用受給者情報_償還情報", "共同処理用受給者情報_償還情報"),
    /**
     * コード:5E41 名称:共同処理用受給者情報_高額情報 略称:共同処理用受給者情報_高額情報
     */
    共同処理用受給者情報_高額情報("5E41", "共同処理用受給者情報_高額情報", "共同処理用受給者情報_高額情報");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KokuhorenTorikomiKokanJohoShikibetsuBango(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 国保連取込交換情報識別番号のコードを返します。
     *
     * @return 国保連取込交換情報識別番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連取込交換情報識別番号の名称を返します。
     *
     * @return 国保連取込交換情報識別番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連取込交換情報識別番号の略称を返します。
     *
     * @return 国保連取込交換情報識別番号の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 国保連取込交換情報識別番号のコードと一致する内容を探します。
     *
     * @param code 国保連取込交換情報識別番号のコード
     * @return {@code code} に対応する国保連取込交換情報識別番号
     */
    public static KokuhorenTorikomiKokanJohoShikibetsuBango toValue(RString code) {
        for (KokuhorenTorikomiKokanJohoShikibetsuBango value : KokuhorenTorikomiKokanJohoShikibetsuBango.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
