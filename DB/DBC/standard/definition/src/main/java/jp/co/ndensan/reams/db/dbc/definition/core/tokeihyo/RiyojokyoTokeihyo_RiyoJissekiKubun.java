package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_利用実績区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum RiyojokyoTokeihyo_RiyoJissekiKubun {

    /**
     * コード:1 名称:実績あり 略称:定義なし
     */
    実績あり("1", "実績あり"),
    /**
     * コード:2 名称:実績なし 略称:定義なし
     */
    実績なし("2", "実績なし"),
    /**
     * コード:3 名称:両方 略称:定義なし
     */
    両方("3", "両方");

    private final RString code;
    private final RString fullName;

    private RiyojokyoTokeihyo_RiyoJissekiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用状況統計表_利用実績区分のコードを返します。
     *
     * @return 利用状況統計表_利用実績区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_利用実績区分の名称を返します。
     *
     * @return 利用状況統計表_利用実績区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_利用実績区分のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_利用実績区分のコード
     * @return {@code code} に対応する利用状況統計表_利用実績区分
     */
    public static RiyojokyoTokeihyo_RiyoJissekiKubun toValue(RString code) {
        for (RiyojokyoTokeihyo_RiyoJissekiKubun riyoJissekiKubun : RiyojokyoTokeihyo_RiyoJissekiKubun.values()) {
            if (riyoJissekiKubun.code.equals(code)) {
                return riyoJissekiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用状況統計表_利用実績区分"));
    }
}
