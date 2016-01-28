package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 開始期を表す列挙型です。
 *
 * @author LDNS
 */
public enum KaishiKi {

    /**
     * コード:0 名称:無し 略称:定義なし
     */
    無し("0", "無し"),
    /**
     * コード:1 名称:_1期 略称:定義なし
     */
    _1期("1", "_1期"),
    /**
     * コード:2 名称:_2期 略称:定義なし
     */
    _2期("2", "_2期"),
    /**
     * コード:3 名称:_3期 略称:定義なし
     */
    _3期("3", "_3期"),
    /**
     * コード:4 名称:_4期 略称:定義なし
     */
    _4期("4", "_4期"),
    /**
     * コード:5 名称:_5期 略称:定義なし
     */
    _5期("5", "_5期"),
    /**
     * コード:6 名称:_6期 略称:定義なし
     */
    _6期("6", "_6期"),
    /**
     * コード:7 名称:_7期 略称:定義なし
     */
    _7期("7", "_7期"),
    /**
     * コード:8 名称:_8期 略称:定義なし
     */
    _8期("8", "_8期"),
    /**
     * コード:9 名称:_9期 略称:定義なし
     */
    _9期("9", "_9期"),
    /**
     * コード:10 名称:_10期 略称:定義なし
     */
    _10期("10", "_10期"),
    /**
     * コード:11 名称:_11期 略称:定義なし
     */
    _11期("11", "_11期"),
    /**
     * コード:12 名称:_12期 略称:定義なし
     */
    _12期("12", "_12期");

    private final RString code;
    private final RString fullName;

    private KaishiKi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 開始期のコードを返します。
     *
     * @return 開始期のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 開始期の名称を返します。
     *
     * @return 開始期の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 開始期のコードと一致する内容を探します。
     *
     * @param code 開始期のコード
     * @return {@code code} に対応する開始期
     */
    public static KaishiKi toValue(RString code) {
        for (KaishiKi kaishiKi : KaishiKi.values()) {
            if (kaishiKi.code.equals(code)) {
                return kaishiKi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("開始期"));
    }
}
