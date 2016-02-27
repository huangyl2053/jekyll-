package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳突合結果情報随時コンフィグキーを表す列挙型です。
 *
 * @author LDNS
 */
public enum ConfigKeysJukyushaDaichoTotsugoKekka {

    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時("無し", "国保連取込_受給者台帳突合結果情報随時"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_バッチID 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_バッチID("無し", "国保連取込_受給者台帳突合結果情報随時_バッチID"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_一覧表示順 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_一覧表示順("無し", "国保連取込_受給者台帳突合結果情報随時_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_交換情報識別番号 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_交換情報識別番号("無し", "国保連取込_受給者台帳突合結果情報随時_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_再処理不可区分 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_再処理不可区分("無し", "国保連取込_受給者台帳突合結果情報随時_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_処理サイクル区分 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_処理サイクル区分("無し", "国保連取込_受給者台帳突合結果情報随時_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_処理月 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_処理月("無し", "国保連取込_受給者台帳突合結果情報随時_処理月"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_処理名称 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_処理名称("無し", "国保連取込_受給者台帳突合結果情報随時_処理名称"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分("無し", "国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_受給者台帳突合結果情報随時_有効区分 略称:定義なし
     */
    国保連取込_受給者台帳突合結果情報随時_有効区分("無し", "国保連取込_受給者台帳突合結果情報随時_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysJukyushaDaichoTotsugoKekka(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者台帳突合結果情報随時コンフィグキーのコードを返します。
     *
     * @return 受給者台帳突合結果情報随時コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者台帳突合結果情報随時コンフィグキーの名称を返します。
     *
     * @return 受給者台帳突合結果情報随時コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者台帳突合結果情報随時コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 受給者台帳突合結果情報随時コンフィグキーのコード
     * @return {@code code} に対応する受給者台帳突合結果情報随時コンフィグキー
     */
    public static ConfigKeysJukyushaDaichoTotsugoKekka toValue(RString code) {

        for (ConfigKeysJukyushaDaichoTotsugoKekka value : ConfigKeysJukyushaDaichoTotsugoKekka.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者台帳突合結果情報随時コンフィグキー"));
    }
}
