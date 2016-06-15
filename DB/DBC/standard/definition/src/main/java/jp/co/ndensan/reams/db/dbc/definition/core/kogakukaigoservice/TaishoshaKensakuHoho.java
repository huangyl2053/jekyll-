package jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費対象者検索方法を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum TaishoshaKensakuHoho {

    /**
     * コード:1 名称:被保険者を指定して検索する 略称:無
     */
    被保険者指定("1", "被保険者を指定して検索する"),
    /**
     * コード:2 名称:年月を指定して検索する 略称:無
     */
    年月指定("2", "年月を指定して検索する");

    private final RString code;
    private final RString fullName;

    private TaishoshaKensakuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額介護サービス費対象者検索方法のコードを返します。
     *
     * @return 高額介護サービス費対象者検索方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額介護サービス費対象者検索方法の名称を返します。
     *
     * @return 高額介護サービス費対象者検索方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額介護サービス費対象者検索方法のコードと一致する内容を探します。
     *
     * @param code 高額介護サービス費対象者検索方法のコード
     * @return {@code code} に対応する高額介護サービス費対象者検索方法
     */
    public static TaishoshaKensakuHoho toValue(RString code) {
        for (TaishoshaKensakuHoho taishoshaKensakuHoho : TaishoshaKensakuHoho.values()) {
            if (taishoshaKensakuHoho.code.equals(code)) {
                return taishoshaKensakuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額介護サービス費対象者検索方法"));
    }
}
