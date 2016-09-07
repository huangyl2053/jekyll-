package jp.co.ndensan.reams.db.dbc.definition.core.kyufukanrihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 明細行出力有無を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KyufuKanrihyo_MeisaigyoKubun {

    /**
     * コード:0 名称:集計行のみ
     */
    集計行のみ("0", "集計行のみ"),
    /**
     * コード:1 名称:明細行含む
     */
    明細行含む("1", "明細行含む");

    private final RString code;
    private final RString fullName;

    private KyufuKanrihyo_MeisaigyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 明細行出力有無のコードを返します。
     *
     * @return 明細行出力有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 明細行出力有無の名称を返します。
     *
     * @return 明細行出力有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 明細行出力有無のコードと一致する内容を探します。
     *
     * @param code 明細行出力有無のコード
     * @return {@code code} に対応する明細行出力有無
     */
    public static KyufuKanrihyo_MeisaigyoKubun toValue(RString code) {
        for (KyufuKanrihyo_MeisaigyoKubun kyufuKanrihyo_MeisaigyoKubun : KyufuKanrihyo_MeisaigyoKubun.values()) {
            if (kyufuKanrihyo_MeisaigyoKubun.code.equals(code)) {
                return kyufuKanrihyo_MeisaigyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("明細行出力有無"));
    }
}
