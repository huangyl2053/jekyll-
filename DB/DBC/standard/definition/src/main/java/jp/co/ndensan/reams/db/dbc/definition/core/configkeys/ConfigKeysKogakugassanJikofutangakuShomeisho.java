package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報コンフィグキーを表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum ConfigKeysKogakugassanJikofutangakuShomeisho {

    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報("無し", "国保連取込_高額合算自己負担額証明書情報"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_バッチID 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_バッチID("無し", "国保連取込_高額合算自己負担額証明書情報_バッチID"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_一覧表示順 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_一覧表示順("無し", "国保連取込_高額合算自己負担額証明書情報_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_交換情報識別番号 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_交換情報識別番号("無し", "国保連取込_高額合算自己負担額証明書情報_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_再処理不可区分 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_再処理不可区分("無し", "国保連取込_高額合算自己負担額証明書情報_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_処理サイクル区分 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_処理サイクル区分("無し", "国保連取込_高額合算自己負担額証明書情報_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_処理月 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_処理月("無し", "国保連取込_高額合算自己負担額証明書情報_処理月"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_処理名称 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_処理名称("無し", "国保連取込_高額合算自己負担額証明書情報_処理名称"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_排他チェック有り区分 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_排他チェック有り区分("無し", "国保連取込_高額合算自己負担額証明書情報_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_高額合算自己負担額証明書情報_有効区分 略称:定義なし
     */
    国保連取込_高額合算自己負担額証明書情報_有効区分("無し", "国保連取込_高額合算自己負担額証明書情報_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysKogakugassanJikofutangakuShomeisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額合算自己負担額証明書情報コンフィグキーのコードを返します。
     *
     * @return 高額合算自己負担額証明書情報コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額合算自己負担額証明書情報コンフィグキーの名称を返します。
     *
     * @return 高額合算自己負担額証明書情報コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額合算自己負担額証明書情報コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 高額合算自己負担額証明書情報コンフィグキーのコード
     * @return {@code code} に対応する高額合算自己負担額証明書情報コンフィグキー
     */
    public static ConfigKeysKogakugassanJikofutangakuShomeisho toValue(RString code) {

        for (ConfigKeysKogakugassanJikofutangakuShomeisho value : ConfigKeysKogakugassanJikofutangakuShomeisho.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額合算自己負担額証明書情報コンフィグキー"));
    }
}
