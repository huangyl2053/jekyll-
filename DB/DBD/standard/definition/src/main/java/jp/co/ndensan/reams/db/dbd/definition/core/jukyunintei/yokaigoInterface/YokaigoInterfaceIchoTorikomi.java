package jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigoInterface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護ＩＦ_医調取込みを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum YokaigoInterfaceIchoTorikomi {

    /**
     * コード:1 名称:両方取込まない 略称:定義なし
     */
    両方取込まない("1", "両方取込まない"),
    /**
     * コード:2 名称:主治医のみ 略称:定義なし
     */
    主治医のみ("2", "主治医のみ"),
    /**
     * コード:3 名称:調査員のみ 略称:定義なし
     */
    調査員のみ("3", "調査員のみ"),
    /**
     * コード:4 名称:両方取込む 略称:定義なし
     */
    両方取込む("4", "両方取込む");

    private final RString code;
    private final RString fullName;

    private YokaigoInterfaceIchoTorikomi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護ＩＦ_医調取込みのコードを返します。
     *
     * @return 要介護ＩＦ_医調取込みのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護ＩＦ_医調取込みの名称を返します。
     *
     * @return 要介護ＩＦ_医調取込みの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護ＩＦ_医調取込みのコードと一致する内容を探します。
     *
     * @param code 要介護ＩＦ_医調取込みのコード
     * @return {@code code} に対応する要介護ＩＦ_医調取込み
     */
    public static YokaigoInterfaceIchoTorikomi toValue(RString code) {
        for (YokaigoInterfaceIchoTorikomi yokaigoInterfaceIchoTorikomi : YokaigoInterfaceIchoTorikomi.values()) {
            if (yokaigoInterfaceIchoTorikomi.code.equals(code)) {
                return yokaigoInterfaceIchoTorikomi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護ＩＦ_医調取込み"));
    }
}
