package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報一覧コンフィグキーを表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum ConfigKeysKyodoshoriJukyushaJohoIchiran {

    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧("無し", "国保連取込_共同処理用受給者情報一覧"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_バッチID 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_バッチID("無し", "国保連取込_共同処理用受給者情報一覧_バッチID"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_一覧表示順 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_一覧表示順("無し", "国保連取込_共同処理用受給者情報一覧_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_交換情報識別番号 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_交換情報識別番号("無し", "国保連取込_共同処理用受給者情報一覧_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_再処理不可区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_再処理不可区分("無し", "国保連取込_共同処理用受給者情報一覧_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_処理サイクル区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_処理サイクル区分("無し", "国保連取込_共同処理用受給者情報一覧_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_処理月 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_処理月("無し", "国保連取込_共同処理用受給者情報一覧_処理月"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_処理名称 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_処理名称("無し", "国保連取込_共同処理用受給者情報一覧_処理名称"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_排他チェック有り区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_排他チェック有り区分("無し", "国保連取込_共同処理用受給者情報一覧_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_共同処理用受給者情報一覧_有効区分 略称:定義なし
     */
    国保連取込_共同処理用受給者情報一覧_有効区分("無し", "国保連取込_共同処理用受給者情報一覧_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysKyodoshoriJukyushaJohoIchiran(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 共同処理用受給者情報一覧コンフィグキーのコードを返します。
     *
     * @return 共同処理用受給者情報一覧コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 共同処理用受給者情報一覧コンフィグキーの名称を返します。
     *
     * @return 共同処理用受給者情報一覧コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 共同処理用受給者情報一覧コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 共同処理用受給者情報一覧コンフィグキーのコード
     * @return {@code code} に対応する共同処理用受給者情報一覧コンフィグキー
     */
    public static ConfigKeysKyodoshoriJukyushaJohoIchiran toValue(RString code) {

        for (ConfigKeysKyodoshoriJukyushaJohoIchiran value : ConfigKeysKyodoshoriJukyushaJohoIchiran.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("共同処理用受給者情報一覧コンフィグキー"));
    }
}
