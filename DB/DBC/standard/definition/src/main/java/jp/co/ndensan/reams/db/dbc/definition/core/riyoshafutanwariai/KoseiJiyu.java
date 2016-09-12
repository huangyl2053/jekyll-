package jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合更正事由を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KoseiJiyu {

    /**
     * コード:00 名称:当初
     */
    当初_継続_新規認定("00", "当初"),
    /**
     * コード:10 名称:本人所得
     */
    本人所得更正("10", "本人所得"),
    /**
     * コード:20 名称:世帯員所得
     */
    世帯員所得更正("20", "世帯員所得"),
    /**
     * コード:40 名称:その他
     */
    その他("40", "その他"),
    /**
     * コード:30 名称:世帯変更
     */
    世帯構成変更("30", "世帯変更");

    private final RString code;
    private final RString fullName;

    private KoseiJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 負担割合更正事由のコードを返します。
     *
     * @return 負担割合更正事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 負担割合更正事由の名称を返します。
     *
     * @return 負担割合更正事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合更正事由のコードと一致する内容を探します。
     *
     * @param code 負担割合更正事由のコード
     * @return {@code code} に対応する負担割合更正事由
     */
    public static KoseiJiyu toValue(RString code) {
        for (KoseiJiyu koseiJiyu : KoseiJiyu.values()) {
            if (koseiJiyu.code.equals(code)) {
                return koseiJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合更正事由"));
    }
}
