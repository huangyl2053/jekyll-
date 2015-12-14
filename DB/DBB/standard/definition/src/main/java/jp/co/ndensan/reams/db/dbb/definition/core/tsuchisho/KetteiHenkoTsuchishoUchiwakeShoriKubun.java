package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定変更通知書打ち分け処理区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KetteiHenkoTsuchishoUchiwakeShoriKubun {

    /**
     * コード:0 名称:本算定賦課 略称:定義なし
     */
    本算定賦課("0", "本算定賦課"),
    /**
     * コード:1 名称:異動賦課 略称:定義なし
     */
    異動賦課("1", "異動賦課");

    private final RString code;
    private final RString fullName;

    private KetteiHenkoTsuchishoUchiwakeShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 決定変更通知書打ち分け処理区分のコードを返します。
     *
     * @return 決定変更通知書打ち分け処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定変更通知書打ち分け処理区分の名称を返します。
     *
     * @return 決定変更通知書打ち分け処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定変更通知書打ち分け処理区分のコードと一致する内容を探します。
     *
     * @param code 決定変更通知書打ち分け処理区分のコード
     * @return {@code code} に対応する決定変更通知書打ち分け処理区分
     */
    public static KetteiHenkoTsuchishoUchiwakeShoriKubun toValue(RString code) {
        for (KetteiHenkoTsuchishoUchiwakeShoriKubun value : KetteiHenkoTsuchishoUchiwakeShoriKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定変更通知書打ち分け処理区分"));
    }
}
