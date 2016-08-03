package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * プリントコントロール区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum PrintControlKubun {

    /**
     * コード:1 名称:集計のみ 略称:定義なし
     */
    集計のみ("1", "集計のみ"),
    /**
     * コード:2 名称:集計後印刷 略称:定義なし
     */
    集計後印刷("2", "集計後印刷"),
    /**
     * コード:3 名称:過去分の印刷 略称:定義なし
     */
    過去分の印刷("3", "過去分の印刷");

    private final RString code;
    private final RString fullName;

    private PrintControlKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * プリントコントロール区分のコードを返します。
     *
     * @return プリントコントロール区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * プリントコントロール区分の名称を返します。
     *
     * @return プリントコントロール区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * プリントコントロール区分のコードと一致する内容を探します。
     *
     * @param code プリントコントロール区分のコード
     * @return {@code code} に対応するプリントコントロール区分
     */
    public static PrintControlKubun toValue(RString code) {
        for (PrintControlKubun printControlKubun : PrintControlKubun.values()) {
            if (printControlKubun.code.equals(code)) {
                return printControlKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("プリントコントロール区分"));
    }
}
