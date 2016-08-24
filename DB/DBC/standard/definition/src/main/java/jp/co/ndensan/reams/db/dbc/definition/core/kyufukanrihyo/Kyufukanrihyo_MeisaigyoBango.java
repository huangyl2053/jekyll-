package jp.co.ndensan.reams.db.dbc.definition.core.kyufukanrihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票明細行番号を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kyufukanrihyo_MeisaigyoBango {

    /**
     * コード:99 名称:集計行のみ
     */
    終端行("99", "集計行のみ");

    private final RString code;
    private final RString fullName;

    private Kyufukanrihyo_MeisaigyoBango(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付管理票明細行番号のコードを返します。
     *
     * @return 給付管理票明細行番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付管理票明細行番号の名称を返します。
     *
     * @return 給付管理票明細行番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付管理票明細行番号のコードと一致する内容を探します。
     *
     * @param code 給付管理票明細行番号のコード
     * @return {@code code} に対応する給付管理票明細行番号
     */
    public static Kyufukanrihyo_MeisaigyoBango toValue(RString code) {
        for (Kyufukanrihyo_MeisaigyoBango kyufukanrihyo_MeisaigyoBango : Kyufukanrihyo_MeisaigyoBango.values()) {
            if (kyufukanrihyo_MeisaigyoBango.code.equals(code)) {
                return kyufukanrihyo_MeisaigyoBango;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付管理票明細行番号"));
    }
}
