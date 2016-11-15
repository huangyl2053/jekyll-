package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計表_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum Tokeihyo_ErrorKubun {

    /**
     * コード:01 名称:マスタ構成不正 略称:定義なし
     */
    マスタ構成不正("01", "マスタ構成不正", "給付実績のマスタ構成が不正です。"),
    /**
     * コード:02 名称:サービスコードデータなし 略称:定義なし
     */
    サービスコードデータなし("02", "サービスコードデータなし", "該当のサービスコードがサービスコードマスタに存在しません。"),
    /**
     * コード:03 名称:被保険者宛名情報取得 略称:定義なし
     */
    被保険者宛名情報取得("03", "被保険者宛名情報取得", "該当データがありません。"),
    /**
     * コード:04 名称:事業者名称取得 略称:定義なし
     */
    事業者名称取得("04", "事業者名称取得", "該当データがありません。");

    private final RString code;
    private final RString fullName;
    private final RString errorMessage;

    private Tokeihyo_ErrorKubun(String code, String fullname, String errorMessage) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.errorMessage = new RString(errorMessage);
    }

    /**
     * 統計表_エラー区分のコードを返します。
     *
     * @return 統計表_エラー区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 統計表_エラー区分の名称を返します。
     *
     * @return 統計表_エラー区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 統計表_エラー区分の名称を返します。
     *
     * @return 統計表_エラー区分の名称
     */
    public RString geterrorMessage() {
        return errorMessage;
    }

    /**
     * 統計表_エラー区分のコードと一致する内容を探します。
     *
     * @param code 統計表_エラー区分のコード
     * @return {@code code} に対応する統計表_エラー区分
     */
    public static Tokeihyo_ErrorKubun toValue(RString code) {
        for (Tokeihyo_ErrorKubun tokeihyo_ErrorKubun : Tokeihyo_ErrorKubun.values()) {
            if (tokeihyo_ErrorKubun.code.equals(code)) {
                return tokeihyo_ErrorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
