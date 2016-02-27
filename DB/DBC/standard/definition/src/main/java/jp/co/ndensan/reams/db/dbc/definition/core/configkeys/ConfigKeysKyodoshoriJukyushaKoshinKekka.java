package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報更新結果コンフィグキーを表す列挙型です。
 *
 * @author LDNS
 */
public enum ConfigKeysKyodoshoriJukyushaKoshinKekka {

    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果("無し", "国保連取込_共同処理用受給者情報更新結果"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_バッチID 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_バッチID("無し", "国保連取込_共同処理用受給者情報更新結果_バッチID"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_一覧表示順 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_一覧表示順("無し", "国保連取込_共同処理用受給者情報更新結果_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_交換情報識別番号 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_交換情報識別番号("無し", "国保連取込_共同処理用受給者情報更新結果_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_再処理不可区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_再処理不可区分("無し", "国保連取込_共同処理用受給者情報更新結果_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_処理サイクル区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_処理サイクル区分("無し", "国保連取込_共同処理用受給者情報更新結果_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_処理月 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_処理月("無し", "国保連取込_共同処理用受給者情報更新結果_処理月"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_処理名称 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_処理名称("無し", "国保連取込_共同処理用受給者情報更新結果_処理名称"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_排他チェック有り区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_排他チェック有り区分("無し", "国保連取込_共同処理用受給者情報更新結果_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報更新結果_有効区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報更新結果_有効区分("無し", "国保連取込_共同処理用受給者情報更新結果_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysKyodoshoriJukyushaKoshinKekka(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 共同処理用受給者情報更新結果コンフィグキーのコードを返します。
     *
     * @return 共同処理用受給者情報更新結果コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 共同処理用受給者情報更新結果コンフィグキーの名称を返します。
     *
     * @return 共同処理用受給者情報更新結果コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 共同処理用受給者情報更新結果コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 共同処理用受給者情報更新結果コンフィグキーのコード
     * @return {@code code} に対応する共同処理用受給者情報更新結果コンフィグキー
     */
    public static ConfigKeysKyodoshoriJukyushaKoshinKekka toValue(RString code) {

        for (ConfigKeysKyodoshoriJukyushaKoshinKekka value : ConfigKeysKyodoshoriJukyushaKoshinKekka.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("共同処理用受給者情報更新結果コンフィグキー"));
    }
}
