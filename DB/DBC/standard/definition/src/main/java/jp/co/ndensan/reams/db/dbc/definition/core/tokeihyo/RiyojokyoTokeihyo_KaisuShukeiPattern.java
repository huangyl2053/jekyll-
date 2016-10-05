package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_回数集計パターンを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum RiyojokyoTokeihyo_KaisuShukeiPattern {

    /**
     * コード:11 名称:短期入所実日数_内訳なし_合計加算あり 略称:定義なし
     */
    短期入所実日数_内訳なし_合計加算あり("11", "短期入所実日数_内訳なし_合計加算あり"),
    /**
     * コード:12 名称:短期入所実日数_内訳あり_合計加算あり 略称:定義なし
     */
    短期入所実日数_内訳あり_合計加算あり("12", "短期入所実日数_内訳あり_合計加算あり"),
    /**
     * コード:13 名称:短期入所実日数_内訳なし_合計加算なし 略称:定義なし
     */
    短期入所実日数_内訳なし_合計加算なし("13", "短期入所実日数_内訳なし_合計加算なし"),
    /**
     * コード:14 名称:短期入所実日数_内訳あり_合計加算なし 略称:定義なし
     */
    短期入所実日数_内訳あり_合計加算なし("14", "短期入所実日数_内訳あり_合計加算なし"),
    /**
     * コード:21 名称:日数回数_内訳なし_合計加算あり 略称:定義なし
     */
    日数回数_内訳なし_合計加算あり("21", "日数回数_内訳なし_合計加算あり"),
    /**
     * コード:22 名称:日数回数_内訳なし_合計加算なし 略称:定義なし
     */
    日数回数_内訳なし_合計加算なし("22", "日数回数_内訳なし_合計加算なし"),
    /**
     * コード:31 名称:居宅支援_内訳あり_合計加算なし 略称:定義なし
     */
    居宅支援_内訳あり_合計加算なし("31", "居宅支援_内訳あり_合計加算なし"),
    /**
     * コード:"" 名称:加算対象外 略称:定義なし
     */
    加算対象外("", "加算対象外");

    private final RString code;
    private final RString fullName;

    private RiyojokyoTokeihyo_KaisuShukeiPattern(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用状況統計表_回数集計パターンのコードを返します。
     *
     * @return 利用状況統計表_回数集計パターンのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_回数集計パターンの名称を返します。
     *
     * @return 利用状況統計表_回数集計パターンの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_回数集計パターンのコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_回数集計パターンのコード
     * @return {@code code} に対応する利用状況統計表_回数集計パターン
     */
    public static RiyojokyoTokeihyo_KaisuShukeiPattern toValue(RString code) {
        for (RiyojokyoTokeihyo_KaisuShukeiPattern value : RiyojokyoTokeihyo_KaisuShukeiPattern.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
