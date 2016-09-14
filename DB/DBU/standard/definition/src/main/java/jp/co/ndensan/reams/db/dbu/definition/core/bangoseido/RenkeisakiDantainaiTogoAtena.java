package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携先団体内統合宛名を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum RenkeisakiDantainaiTogoAtena {

    /**
     * コード:000 名称:標準（中間SVBS） 略称:定義なし
     */
    標準_中間SVBS("000", "標準（中間SVBS）"),

    /**
     * コード:001 名称:NEC 略称:定義なし
     */
    NEC("001", "NEC"),

    /**
     * コード:002 名称:富士電機 略称:定義なし
     */
    富士電機("002", "富士電機"),

    /**
     * コード:003 名称:富士通 略称:定義なし
     */
    富士通("003", "富士通"),

    /**
     * コード:004 名称:両毛システムズ 略称:定義なし
     */
    両毛システムズ("004", "両毛システムズ"),

    /**
     * コード:005 名称:日立 略称:定義なし
     */
    日立("005", "日立"),

    /**
     * コード:100 名称:大雪広域 略称:定義なし
     */
    大雪広域("100", "大雪広域"),

    /**
     * コード:101 名称:南部箕蚊屋広域 略称:定義なし
     */
    南部箕蚊屋広域("101", "南部箕蚊屋広域");

    private final RString code;
    private final RString fullName;

    private RenkeisakiDantainaiTogoAtena(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連携先団体内統合宛名のコードを返します。
     *
     * @return 連携先団体内統合宛名のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連携先団体内統合宛名の名称を返します。
     *
     * @return 連携先団体内統合宛名の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連携先団体内統合宛名のコードと一致する内容を探します。
     *
     * @param code 連携先団体内統合宛名のコード
     * @return {@code code} に対応する連携先団体内統合宛名
     */
    public static RenkeisakiDantainaiTogoAtena toValue(RString code) {
        for (RenkeisakiDantainaiTogoAtena renkeisakiDantainaiTogoAtena : RenkeisakiDantainaiTogoAtena.values()) {
            if (renkeisakiDantainaiTogoAtena.code.equals(code)) {
                return renkeisakiDantainaiTogoAtena;
            }
        }
       throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
