package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定通知書タイプを表す列挙型です。
 *
 * @author LDNS
 */
public enum KetteiTsuchishoType {

    /**
     * コード:01 名称:B5横 略称:定義なし
     */
    B5横("01", "B5横"),
    /**
     * コード:02 名称:A4縦 略称:定義なし
     */
    A4縦("02", "A4縦");

    private final RString code;
    private final RString fullName;

    private KetteiTsuchishoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 決定通知書タイプのコードを返します。
     *
     * @return 決定通知書タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定通知書タイプの名称を返します。
     *
     * @return 決定通知書タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定通知書タイプのコードと一致する内容を探します。
     *
     * @param code 決定通知書タイプのコード
     * @return {@code code} に対応する決定通知書タイプ
     */
    public static KetteiTsuchishoType toValue(RString code) {
        for (KetteiTsuchishoType ketteiTsuchishoType : KetteiTsuchishoType.values()) {
            if (ketteiTsuchishoType.code.equals(code)) {
                return ketteiTsuchishoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定通知書タイプ"));
    }
}
