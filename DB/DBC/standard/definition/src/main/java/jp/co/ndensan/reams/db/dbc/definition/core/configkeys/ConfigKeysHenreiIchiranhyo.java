package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求明細給付管理票返戻保留一覧表情報コンフィグキーを表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum ConfigKeysHenreiIchiranhyo {

    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_バッチID 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_バッチID("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_バッチID"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_一覧表示順 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_一覧表示順("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_再処理不可区分 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_再処理不可区分("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_処理サイクル区分 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_処理サイクル区分("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_処理月 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_処理月("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_処理月"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_処理名称 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_処理名称("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_処理名称"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_排他チェック有り区分 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_排他チェック有り区分("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_請求明細給付管理票返戻保留一覧表情報_有効区分 略称:定義なし
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_有効区分("無し", "国保連取込_請求明細給付管理票返戻保留一覧表情報_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysHenreiIchiranhyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 請求明細給付管理票返戻保留一覧表情報コンフィグキーのコードを返します。
     *
     * @return 請求明細給付管理票返戻保留一覧表情報コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 請求明細給付管理票返戻保留一覧表情報コンフィグキーの名称を返します。
     *
     * @return 請求明細給付管理票返戻保留一覧表情報コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 請求明細給付管理票返戻保留一覧表情報コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 請求明細給付管理票返戻保留一覧表情報コンフィグキーのコード
     * @return {@code code} に対応する請求明細給付管理票返戻保留一覧表情報コンフィグキー
     */
    public static ConfigKeysHenreiIchiranhyo toValue(RString code) {

        for (ConfigKeysHenreiIchiranhyo configKeysHenreiIchiranhyo : ConfigKeysHenreiIchiranhyo.values()) {
            if (configKeysHenreiIchiranhyo.code.equals(code)) {
                return configKeysHenreiIchiranhyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("請求明細給付管理票返戻保留一覧表情報コンフィグキー"));
    }
}
