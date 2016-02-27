package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費再審査決定通知書公費情報コンフィグキーを表す列挙型です。
 *
 * @author LDNS
 */
public enum ConfigKeysSaishinsaKetteiTuchi_Kohi {

    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報("無し", "国保連取込_介護給付費再審査決定通知書公費情報"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_バッチID 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_バッチID("無し", "国保連取込_介護給付費再審査決定通知書公費情報_バッチID"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_一覧表示順 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_一覧表示順("無し", "国保連取込_介護給付費再審査決定通知書公費情報_一覧表示順"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号("無し", "国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_再処理不可区分 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_再処理不可区分("無し", "国保連取込_介護給付費再審査決定通知書公費情報_再処理不可区分"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_処理サイクル区分 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_処理サイクル区分("無し", "国保連取込_介護給付費再審査決定通知書公費情報_処理サイクル区分"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_処理月 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_処理月("無し", "国保連取込_介護給付費再審査決定通知書公費情報_処理月"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_処理名称 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_処理名称("無し", "国保連取込_介護給付費再審査決定通知書公費情報_処理名称"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_排他チェック有り区分 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_排他チェック有り区分("無し", "国保連取込_介護給付費再審査決定通知書公費情報_排他チェック有り区分"),
    /**
     * コード:無し 名称:国保連取込_介護給付費再審査決定通知書公費情報_有効区分 略称:定義なし
     */
    国保連取込_介護給付費再審査決定通知書公費情報_有効区分("無し", "国保連取込_介護給付費再審査決定通知書公費情報_有効区分");

    private final RString code;
    private final RString fullName;

    private ConfigKeysSaishinsaKetteiTuchi_Kohi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護給付費再審査決定通知書公費情報コンフィグキーのコードを返します。
     *
     * @return 介護給付費再審査決定通知書公費情報コンフィグキーのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護給付費再審査決定通知書公費情報コンフィグキーの名称を返します。
     *
     * @return 介護給付費再審査決定通知書公費情報コンフィグキーの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護給付費再審査決定通知書公費情報コンフィグキーのコードと一致する内容を探します。
     *
     * @param code 介護給付費再審査決定通知書公費情報コンフィグキーのコード
     * @return {@code code} に対応する介護給付費再審査決定通知書公費情報コンフィグキー
     */
    public static ConfigKeysSaishinsaKetteiTuchi_Kohi toValue(RString code) {

        for (ConfigKeysSaishinsaKetteiTuchi_Kohi value : ConfigKeysSaishinsaKetteiTuchi_Kohi.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護給付費再審査決定通知書公費情報コンフィグキー"));
    }
}
