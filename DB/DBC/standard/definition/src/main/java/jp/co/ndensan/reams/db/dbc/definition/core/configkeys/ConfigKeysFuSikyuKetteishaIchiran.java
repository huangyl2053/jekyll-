package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定者一覧情報コンフィグキーを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum ConfigKeysFuSikyuKetteishaIchiran {

    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報("国保連取込_償還払不支給決定者一覧情報"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_バッチID 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_バッチID("国保連取込_償還払不支給決定者一覧情報_バッチID"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_一覧表示順 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_一覧表示順("国保連取込_償還払不支給決定者一覧情報_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_交換情報識別番号 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_交換情報識別番号("国保連取込_償還払不支給決定者一覧情報_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_再処理不可区分 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_再処理不可区分("国保連取込_償還払不支給決定者一覧情報_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_処理サイクル区分 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_処理サイクル区分("国保連取込_償還払不支給決定者一覧情報_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_処理月 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_処理月("国保連取込_償還払不支給決定者一覧情報_処理月"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_処理名称 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_処理名称("国保連取込_償還払不支給決定者一覧情報_処理名称"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_排他チェック有り区分 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_排他チェック有り区分("国保連取込_償還払不支給決定者一覧情報_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_償還払不支給決定者一覧情報_有効区分 略称:定義なし
     */
    国保連取込_償還払不支給決定者一覧情報_有効区分("国保連取込_償還払不支給決定者一覧情報_有効区分");

    private final RString fullName;

    private ConfigKeysFuSikyuKetteishaIchiran(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 償還払不支給決定者一覧情報コンフィグキーの名称を返します。
     *
     * @return 償還払不支給決定者一覧情報コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 償還払不支給決定者一覧情報コンフィグキーと一致する内容を探します。
     *
     * @param fullname 償還払不支給決定者一覧情報コンフィグキー
     * @return {fullname} に対応する償還払不支給決定者一覧情報コンフィグキー
     */
    public static ConfigKeysFuSikyuKetteishaIchiran toValue(RString fullname) {

        for (ConfigKeysFuSikyuKetteishaIchiran value : ConfigKeysFuSikyuKetteishaIchiran.values()) {
            if (value.get名称().equals(fullname)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("償還払不支給決定者一覧情報コンフィグキー"));
    }
}
