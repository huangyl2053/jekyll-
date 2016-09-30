package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計表_CSV編集区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Tokeihyo_CSVEditKubun {

    /**
     * コード:0 名称:しない 略称:定義なし
     */
    しない("0", "しない"),
    /**
     * コード:1 名称:する 略称:定義なし
     */
    する("1", "する");

    private final RString code;
    private final RString fullName;

    private Tokeihyo_CSVEditKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 統計表_CSV編集区分のコードを返します。
     *
     * @return 統計表_CSV編集区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 統計表_CSV編集区分の名称を返します。
     *
     * @return 統計表_CSV編集区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 統計表_CSV編集区分のコードと一致する内容を探します。
     *
     * @param code 統計表_CSV編集区分のコード
     * @return {@code code} に対応する統計表_CSV編集区分
     */
    public static Tokeihyo_CSVEditKubun toValue(RString code) {
        for (Tokeihyo_CSVEditKubun cSVEditKubu : Tokeihyo_CSVEditKubun.values()) {
            if (cSVEditKubu.code.equals(code)) {
                return cSVEditKubu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("統計表_CSV編集区分"));
    }
}
